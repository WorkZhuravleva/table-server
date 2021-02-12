package data.transform.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import data.transform.model.Data;

public interface IDataService {
	
	List<Data> addData(MultipartFile fileName);

}
