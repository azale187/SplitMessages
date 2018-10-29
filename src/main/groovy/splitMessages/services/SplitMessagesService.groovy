package splitMessages.services

import java.util.regex.Matcher
import java.util.regex.Pattern

class SplitMessagesService {
    int solution(String S, int K) {
        List<String> result = new ArrayList<>()

        Matcher matcher = Pattern.compile("\\b.{1," + K + "}\\b\\W?").matcher(S)

        while (matcher.find()) {
            if (matcher.group().trim().length() > 0) {
                result.add(matcher.group())
            } else {
                result.clear()
                break
            }
        }

        if (result.size() > 0) {
            return result.size()
        } else {
            return -1
        }
    }
}
