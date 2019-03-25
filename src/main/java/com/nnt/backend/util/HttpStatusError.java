package com.nnt.backend.util;
import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
/***
 * created by Nay Nyein Tun
 * March 19 2019
 * jva
 ***/

@Component
public class HttpStatusError {
   public ResponseEntity<Map<String,Object>> messageError( Map<String,Object> meta,Map<String,Object> resultData,String mes){
	   meta.put("code", 400);
  	   meta.put("message", mes);
  	   resultData.put("meta", meta);
	   return new ResponseEntity<>(resultData,HttpStatus.BAD_REQUEST);
   }
   public ResponseEntity<Map<String,Object>> messageNotFound( Map<String,Object> meta,Map<String,Object> resultData,String mes){
	   meta.put("code", 404);
  	   meta.put("message", mes);
  	   resultData.put("meta", meta);
	   return new ResponseEntity<>(resultData,HttpStatus.NOT_FOUND);
   }
   public ResponseEntity<Map<String,Object>>  messageError(String str)
   {   Map<String,Object> meta= new HashMap<>();
   	   meta.put("code", 400);
	   meta.put("message", str);
	   return new ResponseEntity<>(meta,HttpStatus.BAD_REQUEST);
   }

	public ResponseEntity<Map<String,Object>> messageNotFound(String mes){
		Map<String,Object> meta= new HashMap<>();
		meta.put("code", 404);
		meta.put("message", mes);
		return new ResponseEntity<>(meta,HttpStatus.NOT_FOUND);
	}
}
