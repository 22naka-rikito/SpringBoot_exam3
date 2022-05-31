package com.example.unit;

public class Utility {
	 public static boolean isNullOrEmpty(String str) {
	        if (str == null || str.isEmpty()) {
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public static boolean isNumber(String str) {
	        try {
	            Integer.parseInt(str);
	        } catch (NumberFormatException ex) {
	            return false;
	        }

	        return true;
	    }

	    public static Integer checkAndParseInt(String str) {
	        if (isNumber(str)) {
	            return Integer.parseInt(str);
	        } else {
	            return null;
	        }
	    }
}