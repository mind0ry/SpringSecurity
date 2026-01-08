package com.sist.db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MainClass {

	public static void main(String[] args) {
		EmpDAO dao=new EmpDAO();
		List<EmpVO> list=dao.empAllData();
		
		// filter사용
		List<EmpVO> sList=list.stream()
					      .filter(e->e.getSal()>=3000)
					      .toList();
		sList.forEach(vo->System.out.println(vo.getEmpno()+" "
				+vo.getEname()+" "
				+vo.getSal()+" "
				+vo.getJob()+" "
				+vo.getDbday()));
		// sort사용
		List<EmpVO> mList=list.stream()
				          .sorted(Comparator.comparing(EmpVO::getSal).reversed())
				          .toList();
		
		mList.forEach(vo->System.out.println(vo.getEmpno()+" "
				+vo.getEname()+" "
				+vo.getSal()+" "
				+vo.getJob()+" "
				+vo.getDbday()));
		
		System.out.println("=============================");
		List<String> kList=List.of("java","spring","html","css","javascript","java","css","html","vuejs");
		kList.stream()
		     .sorted((a,b)->a.length()-b.length())
		     .forEach(System.out::println);
		System.out.println("=============================");
		kList.stream()
		     .distinct()
		     .forEach(System.out::println);
		System.out.println("=============================");
		int total=list.stream()
				  .map(EmpVO::getSal)
				  .reduce(0, Integer::sum);
		System.out.println(total);
		
		System.out.println("=============================");
		double avg=list.stream()
				   .mapToInt(EmpVO::getSal)
				   .average()
				   .orElse(0);
		System.out.println(avg);
		
		// distinct : 중복 제거 : DISTINCT
		// reduce : 총합 : sum
		// average : 평균 : avg
		// sorted : 정렬 : ORDER BY
		// groupingBy : GROUP BY
		// filter : WHERE
		// map
		
		Map<String,List<EmpVO>> user=
				list.stream()
				.collect(Collectors.groupingBy(EmpVO::getJob));
		//System.out.println(user);
		/*List<EmpVO> oList=user.get("ANALYST");
		for(EmpVO  vo:oList) {
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob());
		}*/
		/*Set<String> keys=user.keySet();
		for(String key:keys) {
			List<EmpVO> oList=user.get(key);
			for(EmpVO vo:oList) {
				System.out.println(vo.getEmpno()+" "
						+vo.getEname()+" "
						+vo.getJob());
			}
			System.out.println("=============");
		}*/
		/*user.keySet().stream()
			.forEach(System.out::println);
		*/
		
	}
}
