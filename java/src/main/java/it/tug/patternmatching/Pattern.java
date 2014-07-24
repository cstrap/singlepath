package it.tug.patternmatching;

public interface Pattern {
	
	boolean matches(Object value);

	Object apply(Object value);
	
}