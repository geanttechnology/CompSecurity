// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import com.elokence.limuleapi.exceptions.AkWsException;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebservice, SessionFactory, Session

class AkSoundlikeSearchWS extends AkWebservice
{

    private ArrayList mListofLimuleObjects;
    private Session mSession;

    public AkSoundlikeSearchWS(String s)
    {
        mListofLimuleObjects = new ArrayList();
        mWsService = "soundlike_search.php";
        mSession = SessionFactory.sharedInstance().getSession();
        addParameter("base", "0");
        addParameter("channel", mSession.getChannel());
        addParameter("session", mSession.getSession());
        addParameter("signature", mSession.getSignature());
        addParameter("step", (new StringBuilder()).append("").append(mSession.getCurrentSessionProgression().getStep()).toString());
        addParameter("name", s);
    }

    public ArrayList getListofLimuleObjects()
    {
        return mListofLimuleObjects;
    }

    void parseWSListSoundlikes(Document document)
    {
        document = document.getElementsByTagName("ELEMENT");
        int i = 0;
        do
        {
            if (i >= document.getLength())
            {
                break;
            }
            Object obj = document.item(i);
            Session.LimuleObject limuleobject = new Session.LimuleObject();
            obj = ((Node) (obj)).getChildNodes();
            int j = 0;
            while (j < ((NodeList) (obj)).getLength()) 
            {
                Node node = ((NodeList) (obj)).item(j);
                if (node.getNodeName().equals("NAME"))
                {
                    limuleobject.setName(node.getTextContent());
                } else
                if (node.getNodeName().equals("DESCRIPTION"))
                {
                    limuleobject.setDescription(node.getTextContent());
                } else
                if (node.getNodeName().equals("ID_BASE"))
                {
                    limuleobject.setIdBase(Integer.valueOf(node.getTextContent()).intValue());
                }
                j++;
            }
            mListofLimuleObjects.add(limuleobject);
            i++;
        } while (true);
    }

    void parseWSResponse(Document document)
        throws AkWsException
    {
        parseWSListSoundlikes(document);
    }
}
