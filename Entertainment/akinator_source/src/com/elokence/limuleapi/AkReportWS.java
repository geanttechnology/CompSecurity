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

class AkReportWS extends AkWebservice
{

    private ArrayList mReport;
    private Session mSession;

    public AkReportWS()
    {
        mReport = new ArrayList();
        mWsService = "report.php";
        mSession = SessionFactory.sharedInstance().getSession();
        addParameter("base", "0");
        addParameter("channel", mSession.getChannel());
        addParameter("session", mSession.getSession());
        addParameter("signature", mSession.getSignature());
    }

    public ArrayList getReport()
    {
        return mReport;
    }

    void parseWSListReport(Document document)
        throws AkWsException
    {
        document = document.getElementsByTagName("STEP");
        int i = 0;
        do
        {
            if (i >= document.getLength())
            {
                break;
            }
            Object obj = document.item(i);
            Session.ObjectReport objectreport = new Session.ObjectReport();
            obj = ((Node) (obj)).getChildNodes();
            int j = 0;
            while (j < ((NodeList) (obj)).getLength()) 
            {
                Node node = ((NodeList) (obj)).item(j);
                if (node.getNodeName().equals("QUESTION"))
                {
                    objectreport.setQuestionLabel(node.getTextContent());
                } else
                if (node.getNodeName().equals("GIVEN_ANSWER"))
                {
                    objectreport.setGivenAnswer(node.getTextContent());
                } else
                if (node.getNodeName().equals("EXPECTED_ANSWER"))
                {
                    objectreport.setAnswerExpected(node.getTextContent());
                }
                j++;
            }
            mReport.add(objectreport);
            i++;
        } while (true);
        mSession.handleWSCallCompleted(this);
    }

    void parseWSResponse(Document document)
        throws AkWsException
    {
        parseWSListReport(document);
    }
}
