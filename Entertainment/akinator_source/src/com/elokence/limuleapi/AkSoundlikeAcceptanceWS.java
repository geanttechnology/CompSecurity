// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import com.elokence.limuleapi.exceptions.AkWsException;
import com.elokence.limuleapi.exceptions.AkWsMalformedResponseException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebservice, SessionFactory, Session

class AkSoundlikeAcceptanceWS extends AkWebservice
{

    private Session mSession;

    public AkSoundlikeAcceptanceWS(int i)
    {
        mWsService = "soundlike_acceptance.php";
        mSession = SessionFactory.sharedInstance().getSession();
        addParameter("base", "0");
        addParameter("channel", mSession.getChannel());
        addParameter("session", mSession.getSession());
        addParameter("signature", mSession.getSignature());
        addParameter("step", (new StringBuilder()).append("").append(mSession.getCurrentSessionProgression().getStep()).toString());
        addParameter("number", String.valueOf(i));
    }

    void parseWSInformationsSoundlike(Document document)
        throws AkWsException
    {
        document = document.getElementsByTagName("ID");
        if (document.getLength() == 0)
        {
            throw new AkWsMalformedResponseException("NO ID FOUND");
        } else
        {
            document.item(0);
            return;
        }
    }

    void parseWSResponse(Document document)
        throws AkWsException
    {
        parseWSInformationsSoundlike(document);
    }
}
