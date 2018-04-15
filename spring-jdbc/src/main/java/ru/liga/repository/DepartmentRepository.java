package ru.liga.repository;

import ru.liga.entity.DepartmentEntity;

public interface DepartmentRepository {
    DepartmentEntity save(DepartmentEntity entity);

    void deleteById(Long id);

    DepartmentEntity findById(Long id);
}
