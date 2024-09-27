package com.fastcampus.pass.service.pass;

import com.fastcampus.pass.controller.admin.BulkPassRequest;
import com.fastcampus.pass.repository.packaze.PackageEntity;
import com.fastcampus.pass.repository.packaze.PackageRepository;
import com.fastcampus.pass.repository.pass.BulkPassEntity;
import com.fastcampus.pass.repository.pass.BulkPassRepository;
import com.fastcampus.pass.repository.pass.BulkPassStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BulkPassService {

    private final BulkPassRepository bulkPassRepository;

    private final PackageRepository packageRepository;

    public List<BulkPass> getAllBulkPasses() {
        List<BulkPassEntity> bulkPassEntities = bulkPassRepository.findAllOrderByStartedAtDesc();
        return BulkPassModelMapper.INSTANCE.map(bulkPassEntities);
    }

    public void addBulkPass(BulkPassRequest bulkPassRequest) {
        // bulkPassRequest를 기반으로 passEntity를 생성하여 DB에 저장
        PackageEntity packageEntity = packageRepository.findById(bulkPassRequest.getPackageSeq()).orElseThrow();

        BulkPassEntity bulkPassEntity = BulkPassModelMapper.INSTANCE.map(bulkPassRequest);
        bulkPassEntity.setStatus(BulkPassStatus.READY);
        bulkPassEntity.setCount(packageEntity.getCount());
        bulkPassEntity.setEndedAt(packageEntity.getPeriod());

        bulkPassRepository.save(bulkPassEntity);

    }
}
