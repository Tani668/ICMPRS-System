public class PriorityCalculator {

    private static int learningFactor = 0;

    private static final String[] NEGATIVE_WORDS = {
        "angry", "worst", "bad", "terrible", "hate", "frustrated", "issue", "problem"
    };

    private static final String[] CRITICAL_WORDS = {
        "crash", "failed", "error", "not working", "down", "broken"
    };

    public static int detectSentimentScore(String desc) {
        desc = desc.toLowerCase();
        int score = 0;

        for (String word : NEGATIVE_WORDS) {
            if (desc.contains(word)) score++;
        }

        return score >= 2 ? 5 : (score == 1 ? 4 : 2);
    }

    public static int detectImpact(String desc) {
        desc = desc.toLowerCase();
        int score = 0;

        for (String word : CRITICAL_WORDS) {
            if (desc.contains(word)) score++;
        }

        return score >= 2 ? 5 : (score == 1 ? 4 : 2);
    }

    public static int calculate(String desc) {
        int urgency = detectSentimentScore(desc);
        int impact = detectImpact(desc);

        int priority = urgency + impact + learningFactor;
        learningFactor = Math.min(2, learningFactor + 1);

        return priority;
    }

    public static String getPriorityLevel(int p) {
        if (p >= 9) return "HIGH";
        else if (p >= 6) return "MEDIUM";
        else return "LOW";
    }
}
