package com.edisonmaciel.dslearn.repositories;

import com.edisonmaciel.dslearn.entities.Offer;
import com.edisonmaciel.dslearn.entities.Reply;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

}
