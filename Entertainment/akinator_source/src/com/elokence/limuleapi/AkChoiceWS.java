// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import com.elokence.limuleapi.Exceptions.AkException;
import com.elokence.limuleapi.exceptions.AkWsMalformedResponseException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebservice, SessionFactory, Session

class AkChoiceWS extends AkWebservice
{

    private int mIdSession;
    private boolean mJackpot;
    Session.LimuleObjectStats mLimuleObjectStat;
    private Session mSession;

    public AkChoiceWS(int i, boolean flag)
    {
        mJackpot = false;
        mLimuleObjectStat = new Session.LimuleObjectStats();
        mIdSession = i;
        mSession = SessionFactory.sharedInstance().getSession();
        mWsService = "choice.php";
        addParameter("base", "0");
        addParameter("channel", mSession.getChannel());
        addParameter("session", mSession.getSession());
        addParameter("signature", mSession.getSignature());
        addParameter("step", (new StringBuilder()).append("").append(mSession.getCurrentSessionProgression().getStep()).toString());
        String s;
        if (flag)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        addParameter("jackpot", s);
        addParameter("element", (new StringBuilder()).append("").append(i).toString());
    }

    public int getIdSession()
    {
        return mIdSession;
    }

    public Session.LimuleObjectStats getLimuleObjectStats()
    {
        return mLimuleObjectStat;
    }

    void parseWSInformationsCharacter(Document document)
        throws AkException
    {
        document = document.getElementsByTagName("ELEMENT_INFORMATIONS");
        if (document.getLength() == 0)
        {
            throw new AkWsMalformedResponseException("NO ELEMENT_INFORMATIONS FOUND");
        }
        document = document.item(0).getChildNodes();
        int i = 0;
        while (i < document.getLength()) 
        {
            Node node = document.item(i);
            if (node.getNodeName().equals("TIMES_SELECTED"))
            {
                mLimuleObjectStat.setNbPlayed(Integer.valueOf(node.getTextContent()).intValue());
            } else
            if (node.getNodeName().equals("PREVIOUS"))
            {
                mLimuleObjectStat.setPreviousTime(node.getTextContent());
            } else
            if (node.getNodeName().equals("JACKPOT_DELAY"))
            {
                mLimuleObjectStat.setDelayAward(Integer.valueOf(node.getTextContent()).intValue());
            } else
            if (node.getNodeName().equals("FLAG_PHOTO"))
            {
                mLimuleObjectStat.setFlagPhoto(Integer.valueOf(node.getTextContent()).intValue());
            } else
            if (node.getNodeName().equals("ID_BASE"))
            {
                mLimuleObjectStat.setIdBase(Integer.valueOf(node.getTextContent()).intValue());
            }
            i++;
        }
        mSession.handleWSCallCompleted(this);
    }

    void parseWSResponse(Document document)
        throws AkException
    {
        parseWSInformationsCharacter(document);
    }
}
