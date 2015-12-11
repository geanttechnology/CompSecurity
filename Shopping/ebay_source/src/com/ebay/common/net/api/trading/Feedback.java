// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import java.util.Date;

public class Feedback
{

    public boolean commentReplaced;
    public String commentText;
    public Date commentTime;
    public String commentType;
    public String commentingUser;
    public int commentingUserScore;
    public boolean countable;
    public String feedbackId;
    public String feedbackResponse;
    public boolean feedbackRevised;
    public String followUp;
    public boolean followUpReplaced;
    public String itemId;
    public String itemTitle;
    public boolean loading;
    public String orderLineItemId;
    public boolean responseReplaced;
    public String role;
    public String transactionId;

    public Feedback(boolean flag)
    {
        commentingUser = "";
        commentingUserScore = 0;
        commentReplaced = false;
        commentText = "";
        commentTime = new Date();
        commentType = "";
        countable = false;
        feedbackId = "";
        feedbackResponse = "";
        feedbackRevised = false;
        followUp = "";
        followUpReplaced = false;
        itemId = "";
        itemTitle = "";
        orderLineItemId = "";
        responseReplaced = false;
        role = "";
        transactionId = "";
        loading = false;
        loading = flag;
    }
}
