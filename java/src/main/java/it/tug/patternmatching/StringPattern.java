package it.tug.patternmatching;

import java.util.function.Function;

public class StringPattern implements Pattern {
	private final String pattern;
	private final Function<String, Object> function;

	public StringPattern(String pattern, Function<String, Object> function) {
		this.pattern = pattern;
		this.function = function;
	}

	public boolean matches(Object value) {
		return pattern.equals(value);
	}

	public Object apply(Object value) {
		return function.apply((String) value);
	}

	public static Pattern inCaseOf(String pattern,
			Function<String, Object> function) {
		return new StringPattern(pattern, function);
	}
}