package data.transform.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import data.transform.dao.IDataRepository;
import data.transform.model.Data;

@Service
public class DataServiceImpl implements IDataService {
	
	private IDataRepository repository;
	
	@Autowired
	public DataServiceImpl(IDataRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Data> addData(MultipartFile fileName) {	
		List<Data> result = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new InputStreamReader(fileName.getInputStream()))) {
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			String line;
			while ((line = br.readLine()) != null) {
				Date date = null;
				try {
					date = format.parse(line.substring(10, 18));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				result.add(repository.save(new Data(line.substring(0, 1), Integer.parseInt(line.substring(1, 10)), date, Integer.parseInt(line.substring(18, 27)), line.substring(27, 28), Integer.parseInt(line.substring(28, 38)))));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	
}
