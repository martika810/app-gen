package com.madcoding.domain;

public final class Person {
	private final String id;
	private final String name;
	private final int age;
	
	public static Person of(final String id,final String name, final int age){
		return new Person(id,name,age);
	}
	
	private Person(final String id, final String name, final int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	
	public String id(){return id;}
	public String name(){return name;}
	public int age(){return age;}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
