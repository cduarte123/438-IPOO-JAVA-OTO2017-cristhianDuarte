package com.ipoo.grupo6.Api;

	import java.io.BufferedOutputStream;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.io.OutputStreamWriter;
	import java.net.HttpURLConnection;
	import java.net.SocketTimeoutException;
	import java.net.URL;
	import java.text.SimpleDateFormat;
	import java.util.Date;

	public class Api_Instagram {
		
		public Api_Instagram(){
			
		}
		
		public String ejecutar(String url, String parametros){
			
			String contentType = "application/json";
			
			HttpURLConnection con = null;
			InputStreamReader r = null;
			OutputStreamWriter w = null;
		
			StringBuilder sb = new StringBuilder();
		
			try {
				
				String userCredentials = "Bearer conseguir token en spotify";
		
				con = (HttpURLConnection) new URL(url).openConnection();
				
				con.setRequestProperty ("Authorization", userCredentials);
		
				con.setConnectTimeout(30000);
				con.setReadTimeout(120000);
		
				con.setRequestProperty("Content-Type", contentType);
				con.setRequestProperty("Accept", contentType);
				
				if(parametros!=null){
		
					con.setDoOutput(true);
					w = new OutputStreamWriter(new BufferedOutputStream(con.getOutputStream()), "UTF-8");
					w.write(parametros);
					w.flush();
					w.close();
					
				}
		
				r = new InputStreamReader(con.getInputStream());
		
				int c;
				while ((c = r.read()) != -1) sb.append((char) c);
		
			} catch (SocketTimeoutException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(con!=null) con.disconnect();
			}
			
			return sb.toString();
			
		}
		
		public static void main(String[] args){
			Api_Instagram t=new Api_Instagram();
			
			String fecha=new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			
			//link
			String s=t.ejecutar("https://www.instagram.com/developer/" , null);
			System.out.println(s);
		}

}
