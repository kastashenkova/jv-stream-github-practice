package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return false;
    }

    @Override
    public Predicate<Candidate> and(Predicate<? super Candidate> other) {
        return Predicate.super.and(other);
    }

    @Override
    public Predicate<Candidate> negate() {
        return Predicate.super.negate();
    }

    @Override
    public Predicate<Candidate> or(Predicate<? super Candidate> other) {
        return Predicate.super.or(other);
    }

    public static Predicate<Candidate> validateAge() {
        return p -> p.getAge() >= 35;
    }

    public static Predicate<Candidate> validateVote() {
        return Candidate::isAllowedToVote;
    }

    public static Predicate<Candidate> validateNationality() {
        return p -> p.getNationality().equals("Ukrainian");
    }

    public static Predicate<Candidate> validatePeriodsInUkr() {
        return p -> {
            String[] parts = p.getPeriodsInUkr().split("-");
            return Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) >= 10;
        };
    }
}
