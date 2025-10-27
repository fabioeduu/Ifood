package com.ifood.ifood.repository;

import com.ifood.ifood.model.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CupomRepository extends JpaRepository<Cupom,Long> {
}
