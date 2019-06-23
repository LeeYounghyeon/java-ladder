package ladderGameSolo.view;

import ladderGameSolo.constant.MessageConstants;
import ladderGameSolo.validate.Valid;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputView {
    private static final Scanner SCAN = new Scanner(System.in);

    public static String inputName() {
        String name;

        do {
            System.out.println(MessageConstants.INPUT_NAME);
            name = SCAN.nextLine();
        } while (inputValidate(name));

        return name;
    }

    private static boolean inputValidate(String name) {
        return Valid.validName(name) || Valid.overlapName(name);

    }

    public static int inputHeight() {
        System.out.println(MessageConstants.INPUT_HEIGHT);
        String height = SCAN.nextLine();

        if (!Valid.validHeight(height)) {
            System.err.println(MessageConstants.ERROR_INPUT);
            return inputHeight();
        }

        return Integer.parseInt(height);
    }

    public static String inputResult(int memberSize) {
        System.out.println(MessageConstants.INPUT_RESULT);
        String result = SCAN.nextLine();

        if (Valid.validGameResult(result) || Valid.isNotSameLength(memberSize, result)) {
            return inputResult(memberSize);
        }

        return result;
    }

    public static String inputTargetName(String[] names) {
        System.out.println(MessageConstants.INPUT_TARGET);
        String target = SCAN.nextLine();

        if (Valid.isBlank(target) || Valid.isNotInName(target, names)) {
            return inputTargetName(names);
        }

        return target;
    }
}
