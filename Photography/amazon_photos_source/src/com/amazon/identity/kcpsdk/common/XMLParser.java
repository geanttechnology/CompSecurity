// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.common;

import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.platform.metric.MetricsHelper;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class XMLParser
{

    private static final String TAG = com/amazon/identity/kcpsdk/common/XMLParser.getName();
    private final ByteArrayOutputStream mBytesToParse = new ByteArrayOutputStream();

    public XMLParser()
    {
    }

    public boolean parseChunk(byte abyte0[], long l)
    {
        mBytesToParse.write(abyte0, 0, (int)l);
        return true;
    }

    public Document parseEndOfDocument()
    {
        Document document = null;
        Document document1 = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new ByteArrayInputStream(mBytesToParse.toByteArray()));
        document = document1;
_L2:
        return document;
        Object obj;
        obj;
        MAPLog.e(TAG, (new StringBuilder("Could not parse xml because of parser configuration issue: ")).append(((ParserConfigurationException) (obj)).getMessage()).toString());
        return null;
        SAXException saxexception;
        saxexception;
        String s = saxexception.getMessage();
        MAPLog.e(TAG, (new StringBuilder("Could not parse xml because it was invalid: ")).append(s).toString());
        MetricsHelper.incrementCounter("RegistrationError:SAXException", new String[0]);
        if (s.contains("Unexpected end of document"))
        {
            MetricsHelper.incrementCounter("RegistrationError:SAXException:UnexpectedEndOfDocument", new String[0]);
            return null;
        }
        if (true) goto _L2; else goto _L1
_L1:
        obj;
        MAPLog.e(TAG, (new StringBuilder("Could not parse xml because of an IOException: ")).append(((IOException) (obj)).getMessage()).toString());
        return null;
    }

}
