// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import android.util.Log;
import android.util.Xml;
import com.ebay.common.model.ClientAlertsAuthToken;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.util.FwLog;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.Date;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class GetClientAlertsAuthTokenResponse extends EbayResponse
{

    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("GetClientAlertsToken", 3, "Log GetClientAlertsAuthToken");
    ClientAlertsAuthToken caAuthToken;

    public GetClientAlertsAuthTokenResponse()
    {
        caAuthToken = new ClientAlertsAuthToken();
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        XmlPullParser xmlpullparser;
        boolean flag;
        boolean flag1;
        int i;
        boolean flag2;
        boolean flag3;
        xmlpullparser = Xml.newPullParser();
        flag1 = false;
        flag3 = false;
        Object obj;
        int j;
        try
        {
            xmlpullparser.setInput(new InputStreamReader(inputstream));
            i = xmlpullparser.getEventType();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            Log.e(log.tag, "Error parsing XML", inputstream);
            addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                new EbayResponseError()
            });
            throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException.create(inputstream);
        }
          goto _L1
_L9:
        j = xmlpullparser.next();
        flag1 = flag;
        i = j;
        flag3 = flag2;
        if (!flag2) goto _L1; else goto _L2
_L2:
        Log.e(log.tag, "Error response from API");
        flag1 = flag;
        i = j;
        flag3 = flag2;
          goto _L1
_L7:
        inputstream = xmlpullparser.getName();
        if (!inputstream.equals("Ack"))
        {
            break MISSING_BLOCK_LABEL_418;
        }
        if (xmlpullparser.nextText().equalsIgnoreCase("success"))
        {
            break MISSING_BLOCK_LABEL_402;
        }
        flag3 = true;
        flag1 = true;
        xmlpullparser.next();
        obj = xmlpullparser.getName();
        inputstream = ((InputStream) (obj));
        if (!((String) (obj)).equalsIgnoreCase("Errors"))
        {
            xmlpullparser.next();
            xmlpullparser.getEventType();
            inputstream = xmlpullparser.getName();
        }
        obj = new EbayResponseError();
        flag = flag1;
        flag2 = flag3;
        if (!inputstream.equalsIgnoreCase("Errors"))
        {
            break; /* Loop/switch isn't completed */
        }
        xmlpullparser.next();
        if (xmlpullparser.getName().equalsIgnoreCase("shortmessage"))
        {
            xmlpullparser.next();
            obj.shortMessage = xmlpullparser.getText();
            xmlpullparser.next();
            xmlpullparser.next();
        }
        if (xmlpullparser.getName().equalsIgnoreCase("longmessage"))
        {
            xmlpullparser.next();
            obj.longMessage = xmlpullparser.getText();
            xmlpullparser.next();
            xmlpullparser.next();
        }
        if (xmlpullparser.getName().equalsIgnoreCase("ErrorCode"))
        {
            xmlpullparser.next();
            obj.code = xmlpullparser.getText();
            xmlpullparser.next();
            xmlpullparser.next();
        }
        addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
            obj
        });
        flag = flag1;
        flag2 = flag3;
        break; /* Loop/switch isn't completed */
        ackCode = 1;
        flag = flag1;
        flag2 = flag3;
        break; /* Loop/switch isn't completed */
        if (!inputstream.equals("ClientAlertsAuthToken"))
        {
            break MISSING_BLOCK_LABEL_470;
        }
        caAuthToken.token = xmlpullparser.nextText();
        flag = flag1;
        flag2 = flag3;
        if (caAuthToken.expiry > 0L)
        {
            flag = true;
            flag2 = flag3;
        }
        break; /* Loop/switch isn't completed */
        flag = flag1;
        flag2 = flag3;
        if (!inputstream.equals("HardExpirationTime"))
        {
            break; /* Loop/switch isn't completed */
        }
        inputstream = xmlpullparser.nextText();
        Date date = EbayDateUtils.parseIso8601DateTime(inputstream);
        caAuthToken.expiry = date.getTime();
        flag = flag1;
_L3:
        flag2 = flag3;
        if (caAuthToken.token != null)
        {
            flag = true;
            flag2 = flag3;
        }
        break; /* Loop/switch isn't completed */
        ParseException parseexception;
        parseexception;
        Log.e(log.tag, (new StringBuilder()).append("Exception parsing date:").append(inputstream).toString(), parseexception);
        flag3 = true;
        flag = true;
        addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
            new EbayResponseError()
        });
          goto _L3
_L5:
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("Parsing complete errors=").append(flag3).toString());
        }
        if (flag3)
        {
            break MISSING_BLOCK_LABEL_712;
        }
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("No errors token=").append(caAuthToken.token).toString());
            FwLog.println(log, (new StringBuilder()).append("No errors expiry=").append(caAuthToken.expiry).toString());
        }
        ackCode = 1;
        if (log.isLoggable)
        {
            FwLog.println(log, (new StringBuilder()).append("Got response back token=").append(caAuthToken.token).toString());
        }
        return;
_L1:
        if (i == 1 || flag1) goto _L5; else goto _L4
_L4:
        switch (i)
        {
        default:
            flag = flag1;
            flag2 = flag3;
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break;
        }
        if (true) goto _L7; else goto _L6
_L6:
        if (true) goto _L9; else goto _L8
_L8:
    }

}
