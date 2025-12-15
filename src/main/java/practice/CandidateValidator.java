package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKR = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return validateAge().test(candidate)
                && validateVote().test(candidate)
                && validateNationality().test(candidate)
                && validatePeriodsInUkr().test(candidate);
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
        return p -> p.getAge() >= REQUIRED_AGE;
    }

    public static Predicate<Candidate> validateVote() {
        return Candidate::isAllowedToVote;
    }

    public static Predicate<Candidate> validateNationality() {
        return p -> p.getNationality().equals(REQUIRED_NATIONALITY);
    }

    public static Predicate<Candidate> validatePeriodsInUkr() {
        return p -> {
            String[] parts = p.getPeriodsInUkr().split("-");
            return Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]) >= REQUIRED_YEARS_IN_UKR;
        };
    }
}
