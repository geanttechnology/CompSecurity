// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import com.elokence.limuleapi.exceptions.AkWsException;
import org.w3c.dom.Document;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebservice, SessionFactory, Session

class AkNewElementWS extends AkWebservice
{

    private String description;
    private Session mSession;
    private String name;

    public AkNewElementWS(String s, String s1)
    {
        mWsService = "new_element.php";
        mSession = SessionFactory.sharedInstance().getSession();
        addParameter("base", "0");
        addParameter("channel", mSession.getChannel());
        addParameter("session", mSession.getSession());
        addParameter("signature", mSession.getSignature());
        addParameter("step", (new StringBuilder()).append("").append(mSession.getCurrentSessionProgression().getStep()).toString());
        addParameter("name", s);
        addParameter("description", s1);
    }

    void parseWSResponse(Document document)
        throws AkWsException
    {
    }
}
