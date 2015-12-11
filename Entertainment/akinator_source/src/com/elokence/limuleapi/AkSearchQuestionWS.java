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

class AkSearchQuestionWS extends AkWebservice
{

    private ArrayList mListOfQuestions;
    private Session mSession;

    public AkSearchQuestionWS(String s)
    {
        mListOfQuestions = new ArrayList();
        mWsService = "search_question.php";
        mSession = SessionFactory.sharedInstance().getSession();
        addParameter("base", "0");
        addParameter("prio", "1");
        addParameter("channel", mSession.getChannel());
        addParameter("session", mSession.getSession());
        addParameter("signature", mSession.getSignature());
        addParameter("step", (new StringBuilder()).append("").append(mSession.getCurrentSessionProgression().getStep()).toString());
        addParameter("search", s);
    }

    public ArrayList getListOfQuestions()
    {
        return mListOfQuestions;
    }

    void parseWSListQuestions(Document document)
        throws AkWsException
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
            mListOfQuestions.add(questionobject);
            i++;
        } while (true);
        mSession.handleWSCallCompleted(this);
    }

    void parseWSResponse(Document document)
        throws AkWsException
    {
        parseWSListQuestions(document);
    }
}
