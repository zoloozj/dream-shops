package mn.dailycodework.dreamshops.service.image;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import mn.dailycodework.dreamshops.dto.ImageDto;
import mn.dailycodework.dreamshops.model.Image;

public interface IImageService {
    Image getImageById(Long id);

    void deleteImageById(Long id);

    List<ImageDto> createImage(List<MultipartFile> files, Long productId);

    void updateImage(MultipartFile file, Long imageId);
}
