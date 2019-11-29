package com.allianz.shopping.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {
	
	public static Date convertStringToDate(String date)
	{
		
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dateLocal=sdf.parse(date);
			return dateLocal;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static String convertDateToString(Date date)
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
		String dateLocal=sdf.format(date);
		return dateLocal;
    }
	
	public static java.sql.Date convertUtilToSql(java.util.Date date)
	{
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
		
	}

}
