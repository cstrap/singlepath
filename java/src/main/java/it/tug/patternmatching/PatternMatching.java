package it.tug.patternmatching;
public class PatternMatching {
    private Pattern[] patterns;
 
    public PatternMatching(Pattern... patterns) { this.patterns = patterns; }
 
    public Object matchFor(Object value) {
        for (Pattern pattern : patterns)
            if (pattern.matches(value))
                return pattern.apply(value);
 
        throw new IllegalArgumentException("cannot match " + value);
    }
}