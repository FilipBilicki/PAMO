package com.example.tipper;

public class Question
{
    // answerResId will store Question
    private int answerResId;

    // answerTrue will store correct answer
    // of the Question provided
    private boolean answerTrue;

    public Question(int answerResId, boolean answerTrue)
    {
        // setting the values through
        // arguments passed in constructor
        this.answerResId = answerResId;
        this.answerTrue = answerTrue;
    }

    // returning the Question passed
    public int getAnswerResId()
    {
        return answerResId;
    }

    // setting the Question passed
    public void setAnswerResId(int answerResId)
    {
        this.answerResId = answerResId;
    }

    // returning the correct answer
    // of Question
    public boolean isAnswerTrue()
    {
        return answerTrue;
    }

    // setting the correct
    // ans of Question
    public void setAnswerTrue(boolean answerTrue)
    {
        this.answerTrue = answerTrue;
    }
}
