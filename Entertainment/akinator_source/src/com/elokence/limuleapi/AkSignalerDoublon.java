// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Document;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebservice, SessionFactory, Session

class AkSignalerDoublon extends AkWebservice
{

    Session mSession;

    public AkSignalerDoublon(ArrayList arraylist, boolean flag)
    {
        mSession = SessionFactory.sharedInstance().getSession();
        mWsService = "signaler_doublon.php";
        Object obj = "";
        Iterator iterator = arraylist.iterator();
        for (arraylist = ((ArrayList) (obj)); iterator.hasNext(); arraylist = (new StringBuilder()).append(arraylist).append(String.valueOf(obj)).append(",").toString())
        {
            obj = (Integer)iterator.next();
        }

        addParameter("ids_doublons", arraylist);
        if (flag)
        {
            addParameter("org", "SSL");
            return;
        } else
        {
            addParameter("org", "LST");
            return;
        }
    }

    void parseWSResponse(Document document)
    {
    }
}
