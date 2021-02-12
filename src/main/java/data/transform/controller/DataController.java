package data.transform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import data.transform.model.Data;
import data.transform.service.IDataService;

@RestController
public class DataController {

	private IDataService service;

	@Autowired
	public DataController(IDataService service) {
		this.service = service;
	}
	
	@PostMapping("/data")
	public List<Data> addData(@RequestParam("file") MultipartFile file){
		return service.addData(file);
	}
}
