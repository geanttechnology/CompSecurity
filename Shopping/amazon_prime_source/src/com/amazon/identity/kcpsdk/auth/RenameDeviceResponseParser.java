// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.StringConversionHelpers;
import com.amazon.identity.kcpsdk.common.ParseError;
import com.amazon.identity.kcpsdk.common.WebResponseParser;
import com.amazon.identity.kcpsdk.common.XMLParser;
import com.amazon.identity.kcpsdk.common.XMLParserHelpers;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            RenameDeviceResponse

public class RenameDeviceResponseParser extends WebResponseParser
{

    private final XMLParser mParser = new XMLParser();
    private RenameDeviceResponse mResponse;

    public RenameDeviceResponseParser()
    {
        super(com/amazon/identity/kcpsdk/auth/RenameDeviceResponseParser.getName());
    }

    public RenameDeviceResponse getParsedResponse()
    {
        return mResponse;
    }

    public volatile Object getParsedResponse()
    {
        return getParsedResponse();
    }

    protected void internalEndParse()
    {
        Object obj1;
        Document document = mParser.parseEndOfDocument();
        if (document == null)
        {
            setParseError(ParseError.ParseErrorMalformedBody);
            return;
        }
        obj1 = document.getDocumentElement();
        if (obj1 != null && ((Element) (obj1)).getTagName().equals("response")) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L8:
        obj1 = obj;
        if (obj == null)
        {
            obj1 = new RenameDeviceResponse(null, 7);
        }
        mResponse = ((RenameDeviceResponse) (obj1));
        return;
_L2:
        obj = XMLParserHelpers.getFirstElementWithTag(((Element) (obj1)), "error_code");
        obj1 = XMLParserHelpers.getFirstElementWithTag(((Element) (obj1)), "text");
        obj = XMLParserHelpers.getTextContent(((Element) (obj)));
        obj1 = XMLParserHelpers.getTextContent(((Element) (obj1)));
        if (obj == null)
        {
            obj = null;
            continue; /* Loop/switch isn't completed */
        }
        obj = StringConversionHelpers.toInteger(((String) (obj)));
        if (obj == null)
        {
            obj = new RenameDeviceResponse("No response code found.", 7);
            continue; /* Loop/switch isn't completed */
        }
        ((Integer) (obj)).intValue();
        JVM INSTR tableswitch 0 4: default 168
    //                   0 184
    //                   1 168
    //                   2 192
    //                   3 168
    //                   4 197;
           goto _L3 _L4 _L3 _L5 _L3 _L6
_L6:
        break MISSING_BLOCK_LABEL_197;
_L4:
        break; /* Loop/switch isn't completed */
_L3:
        int i = 7;
_L9:
        obj = new RenameDeviceResponse(((String) (obj1)), i);
        if (true) goto _L8; else goto _L7
_L7:
        i = ((Integer) (obj)).intValue();
          goto _L9
_L5:
        i = 3;
          goto _L9
        i = 5;
          goto _L9
    }

    protected void internalParseBodyChunk(byte abyte0[], long l)
    {
        mParser.parseChunk(abyte0, l);
    }
}
