// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import com.elokence.limuleapi.exceptions.AkWsException;
import java.util.ArrayList;
import org.w3c.dom.Document;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebservice, SessionFactory, Session

class AkCancelAnswerWS extends AkWebservice
{

    private ArrayList mAnswers;
    private String mProgression;
    private String mQuestion;
    private Session mSession;
    private String mStep;

    public AkCancelAnswerWS()
    {
        mAnswers = new ArrayList();
        mSession = SessionFactory.sharedInstance().getSession();
        mWsService = "cancel_answer.php";
        addParameter("base", "0");
        addParameter("channel", mSession.getChannel());
        addParameter("session", mSession.getSession());
        addParameter("signature", mSession.getSignature());
        addParameter("step", (new StringBuilder()).append("").append(mSession.getCurrentSessionProgression().getStep()).toString());
    }

    public ArrayList getAnswers()
    {
        return mAnswers;
    }

    public float getProgression()
    {
        return Float.valueOf(mProgression).floatValue();
    }

    public String getQuestion()
    {
        return mQuestion;
    }

    public int getStep()
    {
        return Integer.valueOf(mStep).intValue();
    }

    void parseWSResponse(Document document)
        throws AkWsException
    {
        mStep = parseWSStep(document);
        mProgression = parseWSProgression(document);
        mQuestion = parseWSQuestionAnswers(document, mAnswers);
        mSession.handleWSCallCompleted(this);
    }
}
