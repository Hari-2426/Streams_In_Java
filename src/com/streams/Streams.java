package com.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Streams {
	
	
	public static void main(String[] args) {
		
		
		basicStreamIteration();
		evenNumbers();
		sortEvenNumbers();
		desecndingOrder();
		customClassSorting();
		mapFunction();
		
		removeDuplicates();
		
		extractingEmployeesWithConditions();
		
		largestNumberAndSecondLargestNumber();
		limitFunction();
		
		mapOperations();
		
		allAndAnyMatch();
		
		partioningBy();
		
		reduceMethod();
		
		removeDuplicatesFromString();
		
		joiningMethod();
	
		firstLetterFromEachWord();
		
		String str="FRONTLINESMEDIA";
		Map<Character,Long> map=str.chars()
		.mapToObj(c->(char)c)
		.collect(Collectors.groupingBy(c->c,Collectors.counting()));
		System.out.println(map);
	}

	private static void firstLetterFromEachWord() {
		String str="I am A Java Developer Lets Crack It";
		
		String[] words = str.split(" ");
		String result=Arrays.stream(words)
		.map(c->String.valueOf(c.charAt(0)))
		.collect(Collectors.joining());
		
		System.out.println(result);
	}

	private static void joiningMethod() {
		String str="FRONT";
		String collect = str.chars()
		.mapToObj(n->String.valueOf((char) n))
		.collect(Collectors.joining(",","[","]"));
		System.out.println(collect);
	}

	private static void removeDuplicatesFromString() {
		String str="This Is Java Programming";
		String list = str.chars()
		.mapToObj(n->String.valueOf((char) n))
		.distinct()
		.collect(Collectors.joining(",")); // Collectors.joining only works on Strings
		
		System.out.println(list);
	}

	private static void reduceMethod() {
		ArrayList<Integer> al=new ArrayList<>(Arrays.asList(12,20,31,41,50,12,50,71));
		System.out.println(al);
		Integer sum = al.stream()
		.reduce(0,(a,b)->a+b);
		System.out.println(sum);
	}

	private static void partioningBy() {
		ArrayList<Integer> al=new ArrayList<>(Arrays.asList(12,20,31,41,50,12,50,71));
		System.out.println(al);
		Map<Boolean, List<Integer>> collect = al.stream()
		.collect(Collectors.partitioningBy(n->n%2==0));
		System.out.println(collect);
	}

	private static void allAndAnyMatch() {
		ArrayList<Integer> al=new ArrayList<>(Arrays.asList(12,20,31,41,50,12,50,71));
		System.out.println(al);
		boolean allMatch = al.stream()
		.allMatch(n->n%2==0);
		System.out.println(allMatch);
		
		boolean anyMatch = al.stream()
		.anyMatch(n->n%2==0);
		System.out.println(anyMatch);
	}

	private static void mapOperations() {
		Map<String,String> map=new HashMap<>();
		map.put("Hari", "PML");
		map.put("Veda", "BGLR");
		map.put("Nandan", "HYD");
		
		map.entrySet()
		.stream()
		.forEach(entry->System.out.println(entry.getKey()+" "+entry.getValue()));
	}

	private static void limitFunction() {
		ArrayList<Integer> al=new ArrayList<>(Arrays.asList(12,20,31,41,50,12,50,71));
		System.out.println(al);
		al.stream()
		.limit(3)
		.forEach(n->System.out.println(n));
	}

	private static void largestNumberAndSecondLargestNumber() {
		ArrayList<Integer> al=new ArrayList<>(Arrays.asList(12,20,31,41,50,12,50,71));
		System.out.println(al);
		Integer maxValue = al.stream()
		.sorted(Comparator.reverseOrder())
		.findFirst()
		.get();
		System.out.println(maxValue);
		
		Integer secondValue = al.stream()
		.sorted(Comparator.reverseOrder())
		.skip(1)
		.findFirst()
		.get();
		System.out.println(secondValue);
	}

	private static void extractingEmployeesWithConditions() {
		List<Employee> li=new ArrayList<>();
		li.add(new Employee(1,"Nandan",50000));
		li.add(new Employee(2,"Veda",48000));
		li.add(new Employee(3,"Vyas",49000));
		li.add(new Employee(4,"Hari",65000));
		List<Employee> list = li.stream()
		.filter((emp)->emp.getEmpname().length()>=4 && emp.getEmpSal()>=50000)
		.toList();
		System.out.println(list);
	}

	private static void removeDuplicates() {
		ArrayList<Integer> al=new ArrayList<>(Arrays.asList(12,20,31,41,50,12,50,71));
		System.out.println(al);
		List<Integer> list=al.stream()
		.distinct()
		.toList();
		
		System.out.println(list);
	}

	private static void mapFunction() {
		List<Employee> li=new ArrayList<>();
		li.add(new Employee(1,"Nandan",50000));
		li.add(new Employee(2,"Veda",48000));
		li.add(new Employee(3,"Vyas",49000));
		li.add(new Employee(4,"Hari",65000));
		List<Integer> list=li.stream()
		.map(emp->emp.getEmpSal()+3000)
		.toList();
		System.out.println(list);
	}

	private static void customClassSorting() {
		List<Employee> li=new ArrayList<>();
		li.add(new Employee(1,"Nandan",50000));
		li.add(new Employee(2,"Veda",48000));
		li.add(new Employee(3,"Vyas",49000));
		li.add(new Employee(4,"Hari",65000));
		
		List<Employee> list = li.stream()
			    .sorted((emp1, emp2) -> Integer.compare(emp1.getEmpSal(), emp2.getEmpSal()))
			    .toList();
		System.out.println(list);
	}

	private static void desecndingOrder() {
		ArrayList<Integer> al=new ArrayList<>(Arrays.asList(12,20,31,41,50,12,50,71));
		System.out.println(al);
		List<Integer> collect = al.stream()
		.sorted(Comparator.reverseOrder())
		.collect(Collectors.toList());
		System.out.println(collect);
	}

	private static void sortEvenNumbers() {
		ArrayList<Integer> al=new ArrayList<>(Arrays.asList(12,20,31,41,50,12,50,71));
		System.out.println(al);
		
		Set<Integer> collect = al.stream()
		.filter(n->n%2==0)
		.sorted()
		.collect(Collectors.toSet());
		
		System.out.println(collect);
	}

	private static void evenNumbers() {
		ArrayList<Integer> al=new ArrayList<>(Arrays.asList(12,20,31,41,50));
		System.out.println(al);
		al.stream()
		.filter((n)->n%2==0)
		.forEach(n->System.out.println(n));
	}

	private static void basicStreamIteration() {
		ArrayList<Integer> al=new ArrayList<>(Arrays.asList(12,20,30,40,50));
		al.forEach((n)->{System.out.println(n);});
		
		Stream<Integer> stream = al.stream();
		
		
		stream.forEach(n->System.out.println(n));
	}

}
