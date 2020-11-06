package dothidothi;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class readFile {
    private String fileName="D:\\nam4\\Khai Phá DL\\btl\\data\\urbanGB.txt";
    private String[] s;

    public readFile() throws FileNotFoundException {
//         
    	super();
	}
	//Map<Integer, Integer> map =new HashMap<Integer, Integer>();
	   public  List<Obj> read() throws IOException {
		    List<Obj> listO=new ArrayList<Obj>();
		    try (BufferedReader bufferedReader =
                    new BufferedReader(new FileReader(fileName))) {
           String line = bufferedReader.readLine();
           while (line != null) {
               //System.out.println(line);
        	   s=line.split(",");
        	   Obj o =new Obj(Double.parseDouble(s[0]), Double.parseDouble(s[1]));
        	   listO.add(o);
        	   if(listO.size()==200) {
        		   return listO;
        	   }
               line = bufferedReader.readLine();
           }
       } catch (IOException e) {
           e.printStackTrace();
           return null;
       }
			return listO;
	        
	    }  
//	   public static void main(String[] args) throws IOException {
//		readFile r=new readFile();
//		List<Obj> lo=r.read();
//		System.out.println(lo.size());
	//}
}