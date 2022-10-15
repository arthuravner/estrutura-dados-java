package br.alura.ed.vetor;

import java.util.Arrays;

public class Vector {

	private Students[] students = new Students[100];
	
	private int totalStudents = 0;

	private boolean isValidPosition(int position) {
		return position >= 0 && position <= totalStudents;
	}
	
	private void ensureSpace() {
		if(totalStudents == students.length) {
			Students[] newArray = new Students[totalStudents * 2];
			for(int i = 0; i < students.length; i++) {
				newArray[i] = students[i];
			}
			this.students = newArray;
		}
	}
	
	public void add(Students student) {
		this.students[totalStudents] = student;
		this.totalStudents++;
		ensureSpace();
	}
	
	private boolean isOccupiedPosition(int position) {
		if(!isValidPosition(position)) {
			throw new IllegalArgumentException("Invalid position");
		}
		return position >= 0 && position <= totalStudents;
	}
	
	public void add(int position, Students student) {
		for(int i = totalStudents; i >= position; i--) {
			students[i+1] = students[i];			
		}
		students[position] = student;
		totalStudents++;	
		ensureSpace();
	}
	
	public Students get(int position) {
		if(!isOccupiedPosition(position)) {
			throw new IllegalArgumentException("Invalid position");
		}
		return students[position];
	}

	public void remove(int position) {
		if(!isValidPosition(position)) {
			throw new IllegalArgumentException("Invalid position");
		}
		for(int i = position; i < totalStudents; i++) {
			students[i] = students[i+1];			
		}				
		totalStudents--;
	}

	public boolean contain(Students student) {
		for(int i = 0; i < totalStudents; i++) {
			if(students[i] != null && students[i].equals(student)) {
				return true;
			}
		}
		return false;
	}

	public int size() {
		return this.totalStudents;
	}

	@Override
	public String toString() {
		return Arrays.toString(students);
	}

}
