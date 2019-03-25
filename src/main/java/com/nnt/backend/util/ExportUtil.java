package com.nnt.backend.util;

import org.springframework.stereotype.Component;
/***
 * created by Nay Nyein Tun
 * March 19 2019
 ***/

@Component
public class ExportUtil {
	 public String cleanXSS(String value) {
	       if (value != null) {
	           // You'll need to remove the spaces from the html entities below
	           value = value.replaceAll("<", "& lt;").replaceAll(">", "& gt;");
	           //value = value.replaceAll("\\(", "& #40;").replaceAll("\\)", "& #41;");
	           //value = value.replaceAll("'", "& #39;");
	           value = value.replaceAll("eval\\((.*)\\)", "");
	           value = value.replaceAll("[\\\"\\\'][\\s]*javascript:(.*)[\\\"\\\']", "\"\"");

	           value = value.replaceAll("(?i)<.*?javascript:.*?>.*?</.*?>", "");
	           value = value.replaceAll("(?i)<.*?\\s+on.*?>.*?</.*?>", "");
	           value = value.replaceAll("(?i)<script>", "");
	           value = value.replaceAll("(?i)</script>", "");
	           value = value.replaceAll("(?i)=", "");
	           //logger.info("OutnXSS RequestWrapper ........ value ......." + value);
	       }
	       return value;
	   }
}
