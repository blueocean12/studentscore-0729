package util;

import java.io.File;

public class Common {
	public static boolean isExistFile(String filePath) {
		boolean result = false;
		
		File file = new File(filePath);
		if (file.exists()) {           
			if (file.isDirectory()) {    
				result = true;
			}
		}
		
		return result;
	}
	
	public static boolean makeDir(String filePath) {
		boolean result = false;
		
		return result;
	}
}
