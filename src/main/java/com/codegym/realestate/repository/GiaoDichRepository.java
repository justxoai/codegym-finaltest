package com.codegym.realestate.repository;

import com.codegym.realestate.entity.GiaoDich;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GiaoDichRepository extends JpaRepository<GiaoDich, String>, JpaSpecificationExecutor<GiaoDich> {

    @Override
    @EntityGraph(attributePaths = "khachHang")
    List<GiaoDich> findAll(Specification<GiaoDich> specification, Sort sort);

    @Override
    @EntityGraph(attributePaths = "khachHang")
    Optional<GiaoDich> findById(String maGiaoDich);
}
