package data.transform.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Data {
	
	String docType;
	Integer companyID;
	Date date;
	@Id
	Integer docID;
	String sign;
	Integer amount;
	
	
	public Data() {}


	public Data(String docType, Integer companyID, Date date, Integer docID, String sign, Integer amount) {
		this.docType = docType;
		this.companyID = companyID;
		this.date = date;
		this.docID = docID;
		this.sign = sign;
		this.amount = amount;
	}


	public String getDocType() {
		return docType;
	}


	public Integer getCompanyID() {
		return companyID;
	}


	public Date getDate() {
		return date;
	}


	public Integer getDocID() {
		return docID;
	}


	public String getSign() {
		return sign;
	}


	public Integer getAmount() {
		return amount;
	}
	

}
