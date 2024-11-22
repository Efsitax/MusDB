package com.musdb.user_service.user.repository;

import com.musdb.user_service.user.entity.user_entity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface user_repository extends JpaRepository<user_entity, Long> {

}
