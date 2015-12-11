// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.limuleapi;

import com.elokence.limuleapi.Exceptions.AkException;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package com.elokence.limuleapi:
//            AkWebservice, SessionFactory, Session

class AkAddQuestionWS extends AkWebservice
{

    private Session mSession;

    public AkAddQuestionWS(String s, ArrayList arraylist)
    {
        mWsService = "add_question.php";
        mSession = SessionFactory.sharedInstance().getSession();
        addParameter("base", "0");
        addParameter("channel", mSession.getChannel());
        addParameter("session", mSession.getSession());
        addParameter("signature", mSession.getSignature());
        addParameter("player", SessionFactory.sharedInstance().getPlayerName());
        addParameter("question", s);
        s = "";
        for (arraylist = arraylist.iterator(); arraylist.hasNext();)
        {
            Session.ObjectAnswer objectanswer = (Session.ObjectAnswer)arraylist.next();
            s = (new StringBuilder()).append(s).append(objectanswer.getIndex()).append("|").toString();
        }

        addParameter("answers", s);
    }

    void parseWSListQuestions(Document document)
        throws AkException
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
            Session.QuestionObject questionobject = new Session.QuestionObject();
            obj = ((Node) (obj)).getChildNodes();
            int j = 0;
            while (j < ((NodeList) (obj)).getLength()) 
            {
                Node node = ((NodeList) (obj)).item(j);
                if (node.getNodeName().equals("ID"))
                {
                    questionobject.setId(Integer.valueOf(node.getTextContent()).intValue());
                } else
                if (node.getNodeName().equals("NAME"))
                {
                    questionobject.setQuestion(node.getTextContent());
                } else
                if (node.getNodeName().equals("NOT_VALIDATED_YET"))
                {
                    boolean flag;
                    if (Integer.valueOf(node.getTextContent()).intValue() > 0)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    questionobject.setValidated(flag);
                }
                j++;
            }
            i++;
        } while (true);
    }

    void parseWSResponse(Document document)
        throws AkException
    {
        parseWSListQuestions(document);
    }

    public void setQuestionId(int i)
    {
        addParameter("num_question", Integer.toString(i));
    }
}
