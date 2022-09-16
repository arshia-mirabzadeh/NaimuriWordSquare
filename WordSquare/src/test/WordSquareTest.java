package test;

import main.WordSquare;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordSquareTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNoArgs() throws IllegalArgumentException, IOException {
        String[] args = new String[0];
        WordSquare.solveChallenge(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOneArg() throws IllegalArgumentException, IOException {
        String[] args = new String[1];
        args[0] = "4";
        WordSquare.solveChallenge(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThreeArgs() throws IllegalArgumentException, IOException {
        String[] args = new String[3];
        args[0] = "4";
        args[1] = "eeeeddoonnnsssrv";
        args[2] = "test";
        WordSquare.solveChallenge(args);
    }

    @Test
    public void testValidArgs() throws IllegalArgumentException, IOException {
        String[] args = new String[2];
        args[0] = "4";
        args[1] = "eeeeddoonnnsssrv";
        WordSquare.solveChallenge(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFirstArg() throws IllegalArgumentException, IOException {
        String[] args = new String[2];
        args[0] = "test";
        args[1] = "eeeeddoonnnsssrv";
        WordSquare.solveChallenge(args);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidSecondArg() throws IllegalArgumentException, IOException {
        String[] args = new String[2];
        args[0] = "4";
        args[1] = "aeiou123";
        WordSquare.solveChallenge(args);
    }

    @Test
    public void testChallenge1() throws IOException {
        String[] args = new String[2];
        args[0] = "4";
        args[1] = "eeeeddoonnnsssrv";
        List<List<String>> output = WordSquare.solveChallenge(args);
        List<List<String>> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("rose");
        temp.add("oven");
        temp.add("send");
        temp.add("ends");
        answer.add(temp);
        Assert.assertEquals(output, answer);
    }

    @Test
    public void testChallenge2() throws IOException {
        String[] args = new String[2];
        args[0] = "4";
        args[1] = "aaccdeeeemmnnnoo";
        List<List<String>> output = WordSquare.solveChallenge(args);
        List<List<String>> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("moan");
        temp.add("once");
        temp.add("acme");
        temp.add("need");
        answer.add(temp);
        Assert.assertEquals(answer, output);
    }

    @Test
    public void testChallenge3() throws IOException {
        String[] args = new String[2];
        args[0] = "5";
        args[1] = "aabbeeeeeeeehmosrrrruttvv";
        List<List<String>> output = WordSquare.solveChallenge(args);
        List<List<String>> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("heart");
        temp.add("ember");
        temp.add("above");
        temp.add("revue");
        temp.add("trees");
        answer.add(temp);
        Assert.assertEquals(answer, output);
    }

    @Test
    public void testChallenge4() throws IOException {
        String[] args = new String[2];
        args[0] = "7";
        args[1] = "aaaaaaaaabbeeeeeeedddddggmmlloooonnssssrrrruvvyyy";
        List<List<String>> output = WordSquare.solveChallenge(args);
        List<List<String>> answer = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        temp.add("bravado");
        temp.add("renamed");
        temp.add("analogy");
        temp.add("valuers");
        temp.add("amoebas");
        temp.add("degrade");
        temp.add("odyssey");
        answer.add(temp);
        Assert.assertEquals(answer, output);
    }
}
