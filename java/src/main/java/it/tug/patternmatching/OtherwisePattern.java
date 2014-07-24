package it.tug.patternmatching;

import java.util.function.Function;

public class OtherwisePattern implements Pattern {
	private final Function<Object, Object> function;

	public OtherwisePattern(Function<Object, Object> function) {
		this.function = function;
	}

	public boolean matches(Object value) {
		return true;
	}

	public Object apply(Object value) {
		return function.apply(value);
	}

	public static Pattern otherwise(Function<Object, Object> function) {
		return new OtherwisePattern(function);
	}
}