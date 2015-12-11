// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import android.util.Log;
import android.util.Xml;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class CompleteSaleResponse extends EbayResponse
{

    public CompleteSaleResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        XmlPullParser xmlpullparser;
        int i;
        xmlpullparser = Xml.newPullParser();
        int j;
        try
        {
            xmlpullparser.setInput(new InputStreamReader(inputstream));
            i = xmlpullparser.getEventType();
            ackCode = 1;
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            Log.e("CompleteSale", "Error parsing XML", inputstream);
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
_L2:
        j = xmlpullparser.next();
        i = j;
        if (j == 1)
        {
            return;
        }
          goto _L1
_L3:
        inputstream = xmlpullparser.getName();
        if (inputstream.equals("Ack"))
        {
            if (xmlpullparser.nextText().equalsIgnoreCase("success"))
            {
                break; /* Loop/switch isn't completed */
            }
            ackCode = -1;
            addResultMessage(new com.ebay.nautilus.kernel.content.ResultStatus.Message[] {
                new EbayResponseError()
            });
            break; /* Loop/switch isn't completed */
        }
        if (inputstream.equals("ShortMessage"))
        {
            ((EbayResponseError)getResultStatus().getFirstMessage()).shortMessage = xmlpullparser.nextText();
            break; /* Loop/switch isn't completed */
        }
        if (inputstream.equals("LongMessage"))
        {
            ((EbayResponseError)getResultStatus().getFirstMessage()).longMessage = xmlpullparser.nextText();
            break; /* Loop/switch isn't completed */
        }
        if (!inputstream.equals("ErrorCode"))
        {
            break; /* Loop/switch isn't completed */
        }
        ((EbayResponseError)getResultStatus().getFirstMessage()).code = xmlpullparser.nextText();
        break; /* Loop/switch isn't completed */
_L1:
        if (i == 2) goto _L3; else goto _L2
    }
}
