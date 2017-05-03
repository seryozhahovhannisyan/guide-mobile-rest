package com.connectto.mobile.repository;

import com.connectto.mobile.entity.XmlFilesUpdate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IXmlFilesUpdateRepository extends JpaRepository<XmlFilesUpdate, Long> {
}