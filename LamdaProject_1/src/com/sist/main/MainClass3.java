package com.sist.main;
import java.util.*;
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		List<String> names=new ArrayList<>();
//		names.add("심청이");
//		names.add("박문수");
//		names.add("이순신");
//		names.add("강감찬");
//		names.add("김두한");
//		
//		for(String name:names) {
//			System.out.println(name);
//		}
//		
//		System.out.println("==============");
//		names.forEach(name->System.out.println(name));
		
		List<String> colors=List.of("red","blue","black","green","yellow");
		colors.stream()
				.filter(c->c.startsWith("b"))
				.map(String::toUpperCase)
				//.forEach(System.out::println);
				.forEach(c->System.out.println(c));
		// 검색 / 정렬 / 출력 / null 체크
		
		/*
		 *   한줄 처리 => if ~ else => 삼항연산자
		 *   조건 : filter
		 *   변환 : map
		 *   출력 : forEach
		 *   
		 *   ------------------------------------
		 *   복잡한 비지니스 로직
		 *   디버깅이 많은 경우 (X)
		 */
	}

}
