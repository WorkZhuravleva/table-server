package data.transform.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import data.transform.model.Data;

public interface IDataRepository extends JpaRepository<Data, Integer>{

}
