package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_TERM_LIVE_IN_UKR = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && Integer.parseInt(period[YEAR_TO_INDEX])
                - Integer.parseInt(period[YEAR_FROM_INDEX])
                >= MIN_TERM_LIVE_IN_UKR;
    }
}
