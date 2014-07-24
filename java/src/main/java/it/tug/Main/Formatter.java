package it.tug.Main;

import static it.tug.patternmatching.OtherwisePattern.otherwise;
import static it.tug.patternmatching.StringPattern.inCaseOf;
import static java.lang.String.format;
import it.tug.patternmatching.PatternMatching;

import java.util.function.Function;

public class Formatter {

	private Service service;

	public Formatter(Service service) {
		this.service = service;
	}

	public String doTheJob(final String theInput) {
        return (String) new PatternMatching(
                inCaseOf("FAIL", new Function<String, Object>() {
                    public Object apply(String _) {
                        return "error";
                    }
                }),
                inCaseOf("OK", new Function<String, Object>() {
                    public Object apply(String _) {
                        return format("%s%s", theInput, theInput);
                    }
                }),
                otherwise(new Function<Object, Object>() {
                    public Object apply(Object _) {
                        return null;
                    }
                })
        	).matchFor(service.askForPermission());
    }
}
