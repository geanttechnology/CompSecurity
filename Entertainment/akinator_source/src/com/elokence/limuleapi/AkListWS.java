// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import com.elokence.limuleapi.Exceptions.AkException;
import com.elokence.limuleapi.exceptions.AkWsMalformedResponseException;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebservice, SessionFactory, Session, MinibaseFactory

class AkListWS extends AkWebservice
{

    private ArrayList mLimuleObjects;
    private boolean mModeObjectPropose;
    private boolean mModeQuestion;
    private int mNbObjetsPertinents;
    private Session mSession;
    private int mSize;

    public AkListWS(int i, boolean flag)
    {
        mNbObjetsPertinents = -1;
        mLimuleObjects = new ArrayList();
        mModeObjectPropose = false;
        if (i == 1)
        {
            mModeObjectPropose = true;
        }
        mSession = SessionFactory.sharedInstance().getSession();
        mWsService = "list.php";
        mSize = i;
        mModeQuestion = flag;
        addParameter("base", "0");
        addParameter("channel", mSession.getChannel());
        addParameter("session", mSession.getSession());
        addParameter("signature", mSession.getSignature());
        addParameter("step", (new StringBuilder()).append("").append(mSession.getCurrentSessionProgression().getStep()).toString());
        addParameter("size", (new StringBuilder()).append("").append(mSize).toString());
        addParameter("max_pic_width", String.valueOf(SessionFactory.sharedInstance().getLargeurPhoto()));
        addParameter("max_pic_height", String.valueOf(SessionFactory.sharedInstance().getHauteurPhoto()));
        if (flag)
        {
            addParameter("mode_question", "1");
            return;
        } else
        {
            addParameter("mode_question", "0");
            return;
        }
    }

    public ArrayList getLimuleObjects()
    {
        return mLimuleObjects;
    }

    public int getNbObjetsPertinents()
    {
        return mNbObjetsPertinents;
    }

    public boolean isModeObjectPropose()
    {
        return mModeObjectPropose;
    }

    void parseWSListCharacters(Document document)
        throws AkException
    {
        Object obj = document.getElementsByTagName("NBOBJETSPERTINENTS");
        if (((NodeList) (obj)).getLength() > 0)
        {
            obj = ((NodeList) (obj)).item(0);
            Object obj1;
            Node node;
            int i;
            int j;
            boolean flag;
            try
            {
                mNbObjetsPertinents = Integer.parseInt(((Node) (obj)).getTextContent());
            }
            catch (NumberFormatException numberformatexception) { }
        }
        document = document.getElementsByTagName("ELEMENT");
        if (document.getLength() == 0)
        {
            throw new AkWsMalformedResponseException("NO ELEMENT FOUND");
        }
        for (i = 0; i < document.getLength(); i++)
        {
            obj1 = document.item(i);
            obj = new Session.ProposedLimuleObjectMinibase();
            obj1 = ((Node) (obj1)).getChildNodes();
            j = 0;
            while (j < ((NodeList) (obj1)).getLength()) 
            {
                node = ((NodeList) (obj1)).item(j);
                if (node.getNodeName().equals("NAME"))
                {
                    ((Session.ProposedLimuleObjectMinibase) (obj)).setName(node.getTextContent());
                } else
                if (node.getNodeName().equals("DESCRIPTION"))
                {
                    ((Session.ProposedLimuleObjectMinibase) (obj)).setDescription(node.getTextContent());
                } else
                if (node.getNodeName().equals("ID_BASE"))
                {
                    ((Session.ProposedLimuleObjectMinibase) (obj)).setIdBase(Integer.valueOf(node.getTextContent()).intValue());
                } else
                if (node.getNodeName().equals("ID"))
                {
                    ((Session.ProposedLimuleObjectMinibase) (obj)).setIdSession(Integer.valueOf(node.getTextContent()).intValue());
                } else
                if (node.getNodeName().equals("PICTURE_PATH"))
                {
                    ((Session.ProposedLimuleObjectMinibase) (obj)).setPicturePath((new StringBuilder()).append(SessionFactory.sharedInstance().getBaseUrlFromSessionFactory().replace("ws", "photo0")).append("/").append(node.getTextContent()).toString());
                } else
                if (node.getNodeName().equals("VALIDE_CONTRAINTE"))
                {
                    if (Integer.valueOf(node.getTextContent()).intValue() > 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ((Session.ProposedLimuleObjectMinibase) (obj)).setValideConstrait(flag);
                } else
                if (node.getNodeName().equals("RANKING"))
                {
                    ((Session.ProposedLimuleObjectMinibase) (obj)).setRankingLimit(Integer.valueOf(node.getTextContent()).intValue());
                } else
                if (node.getNodeName().equals("MINIBASE_ADDABLE"))
                {
                    if (Integer.valueOf(node.getTextContent()).intValue() > 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    ((Session.ProposedLimuleObjectMinibase) (obj)).setMyWorldAddable(flag);
                } else
                if (node.getNodeName().equals("RELATIVE_ID"))
                {
                    ((Session.ProposedLimuleObjectMinibase) (obj)).setElementMinibaseId(Integer.valueOf(node.getTextContent()).intValue());
                }
                j++;
            }
            if (((Session.ProposedLimuleObjectMinibase) (obj)).getElementMinibaseId() != -1)
            {
                ((Session.ProposedLimuleObjectMinibase) (obj)).setName(MinibaseFactory.sharedInstance().decrypteEtDessaleNom(((Session.ProposedLimuleObjectMinibase) (obj)).getName()));
                ((Session.ProposedLimuleObjectMinibase) (obj)).setNbPlayed(MinibaseFactory.sharedInstance().getCharacter(((Session.ProposedLimuleObjectMinibase) (obj)).getElementMinibaseId()).getNbPlayed());
            }
            mLimuleObjects.add(obj);
        }

        mSession.handleWSCallCompleted(this);
    }

    void parseWSResponse(Document document)
        throws AkException
    {
        parseWSListCharacters(document);
    }
}
