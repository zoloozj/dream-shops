package mn.dailycodework.dreamshops.service.image;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import mn.dailycodework.dreamshops.dto.ImageDto;
import mn.dailycodework.dreamshops.exceptions.ResourceNotFoundException;
import mn.dailycodework.dreamshops.model.Image;
import mn.dailycodework.dreamshops.model.Product;
import mn.dailycodework.dreamshops.repository.ImageRepository;
import mn.dailycodework.dreamshops.service.product.ProductService;

@RequiredArgsConstructor
@Service
public class ImageService implements IImageService {

    // Assuming you have an ImageRepository and ProductRepository to handle database
    // operations
    private final ImageRepository imageRepository;
    private final ProductService productService;

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image not found"));
    }

    @Override
    @Transactional
    public void deleteImageById(Long id) {
        imageRepository.findById(id).ifPresentOrElse(imageRepository::delete, () -> {
            throw new ResourceNotFoundException("Image not found");
        });
        ;
    }

    @Override
    @Transactional
    public List<ImageDto> createImage(List<MultipartFile> files, Long productId) {
        Product product = productService.getProductById(productId);
        List<ImageDto> savedImageDto = new ArrayList<>();
        for (MultipartFile file : files) {
            try {
                Image image = new Image();
                image.setFileName(file.getOriginalFilename());
                image.setFileType(file.getContentType());
                image.setImage(file.getBytes());
                image.setProduct(product);

                String buildDownloadUrl = "/api/v1/images/image/download/";
                String downloadUrl = buildDownloadUrl + image.getId();
                image.setDownloadUrl(downloadUrl);
                Image savedImage = imageRepository.save(image);

                savedImage.setDownloadUrl(buildDownloadUrl + savedImage.getId());
                imageRepository.save(savedImage);

                ImageDto imageDto = new ImageDto();
                imageDto.setId(savedImage.getId());
                imageDto.setFileName(savedImage.getFileName());
                imageDto.setDownloadUrl(savedImage.getDownloadUrl());
                savedImageDto.add(imageDto);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return savedImageDto; // Placeholder for actual implementation

    }

    @Override
    @Transactional
    public void updateImage(MultipartFile file, Long imageId) {
        Image image = getImageById(imageId);
        try {
            image.setFileName(file.getOriginalFilename());
            image.setFileType(file.getContentType());
            image.setImage(file.getBytes());
            imageRepository.save(image);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
