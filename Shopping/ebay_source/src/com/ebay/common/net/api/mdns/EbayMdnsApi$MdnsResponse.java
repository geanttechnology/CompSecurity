// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.mdns;

import android.util.Log;
import android.util.Xml;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

// Referenced classes of package com.ebay.common.net.api.mdns:
//            EbayMdnsApi

public static class taException extends EbayResponse
{

    private void parseAck(XmlPullParser xmlpullparser)
        throws IOException, SAXException, XmlPullParserException
    {
        if (xmlpullparser.nextText().equals("Success"))
        {
            ackCode = 1;
            return;
        } else
        {
            ackCode = -1;
            return;
        }
    }

    private void parseError(XmlPullParser xmlpullparser)
        throws IOException, SAXException, XmlPullParserException
    {
        EbayResponseError ebayresponseerror = new EbayResponseError();
        String s = "error";
        do
        {
            if (s.equals("errorId"))
            {
                break;
            }
            if (xmlpullparser.next() == 2)
            {
                s = xmlpullparser.getName();
            }
        } while (true);
        ebayresponseerror.code = xmlpullparser.nextText();
        do
        {
            if (s.equals("message"))
            {
                break;
            }
            if (xmlpullparser.next() == 2)
            {
                s = xmlpullparser.getName();
            }
        } while (true);
        ebayresponseerror.longMessage = xmlpullparser.nextText();
        addResultMessage(new com.ebay.nautilus.kernel.content.esultMessage[] {
            ebayresponseerror
        });
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.taException
    {
        int i;
        int j;
        XmlPullParser xmlpullparser = Xml.newPullParser();
        int k;
        try
        {
            xmlpullparser.setInput(new InputStreamReader(inputstream));
            j = xmlpullparser.getEventType();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            Log.w("MdnsResponse", "Exception parsing response", inputstream);
            throw com.ebay.nautilus.kernel.net.taException.create(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.taException.create(inputstream);
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            throw com.ebay.nautilus.kernel.net.taException.create(inputstream);
        }
          goto _L1
_L3:
        k = xmlpullparser.next();
        i = j;
        j = k;
          goto _L1
_L6:
        inputstream = xmlpullparser.getName();
        if (!inputstream.equals("ack"))
        {
            break MISSING_BLOCK_LABEL_87;
        }
        parseAck(xmlpullparser);
        j = i;
        if (ackCode != 1) goto _L3; else goto _L2
_L2:
        j = 1;
          goto _L3
        j = i;
        if (!inputstream.equals("error")) goto _L3; else goto _L4
_L4:
        parseError(xmlpullparser);
        j = i;
          goto _L3
_L1:
        for (i = 0; j == 1 || i != 0;)
        {
            return;
        }

        j;
        JVM INSTR tableswitch 2 2: default 168
    //                   2 49;
           goto _L5 _L6
_L5:
        j = i;
          goto _L3
    }

    public taException()
    {
    }
}
