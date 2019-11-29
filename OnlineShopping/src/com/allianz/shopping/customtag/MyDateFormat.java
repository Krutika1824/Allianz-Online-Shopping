package com.allianz.shopping.customtag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class MyDateFormat extends TagSupport {

	private static final long serialVersionUID = 1L;
	private String value;
	private String pattern;
	
	public int doStartTag() throws JspException
	{
		JspWriter out=pageContext.getOut();
		try {
			out.print(value+""+pattern);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return SKIP_BODY;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

}
