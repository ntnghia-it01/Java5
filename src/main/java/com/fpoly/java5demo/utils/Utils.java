package com.fpoly.java5demo.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
	private static final Pattern SIZE_PATTERN = Pattern.compile("^([\\d.]+)\\s*([a-zA-Z]+)$");

	public static long parseToBytes(String input) {
		if (input == null || input.trim().isEmpty()) {
			return 0;
		}

		// Xóa khoảng trắng thừa, chuyển về chữ hoa (5mb -> 5MB)
		String normalizedInput = input.trim().toUpperCase();

		Matcher matcher = SIZE_PATTERN.matcher(normalizedInput);

		if (!matcher.find()) {
			throw new IllegalArgumentException("Định dạng kích thước không hợp lệ: " + input);
		}
//		5MB => 
//		matcher.group(1) = 5
//		matcher.group(2) = MB
		// Lấy phần số (ví dụ: 5.5)
		double value = Double.parseDouble(matcher.group(1));
		// Lấy phần đơn vị (ví dụ: MB)
		String unit = matcher.group(2);

		long multiplier = 1;

		switch (unit) {
		case "KB":
		case "K":
			multiplier = 1024L;
			break;
		case "MB":
		case "M":
			multiplier = 1024L * 1024;
			break;
		case "GB":
		case "G":
			multiplier = 1024L * 1024 * 1024;
			break;
		case "TB":
		case "T":
			multiplier = 1024L * 1024 * 1024 * 1024;
			break;
		case "B":
		case "BYTE":
		case "BYTES":
			multiplier = 1;
			break;
		default:
			throw new IllegalArgumentException("Đơn vị không được hỗ trợ: " + unit);
		}

		return (long) (value * multiplier);
	}
}
