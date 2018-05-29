package TexT;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Text {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "淡淡的忧伤";
		String str2 = URLEncoder.encode(str,"utf-8");   //对中文字符编码
		System.out.println("Str2:"+str2);
		
		String str3 = URLDecoder.decode(str2,"utf-8");  //对中文字符解码
		System.out.println("Str3:"+str3);
	}
}
