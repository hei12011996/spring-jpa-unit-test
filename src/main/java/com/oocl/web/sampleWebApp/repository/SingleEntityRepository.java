package com.oocl.web.sampleWebApp.repository;

import com.oocl.web.sampleWebApp.entity.SingleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SingleEntityRepository extends JpaRepository<SingleEntity, Long> {
}
