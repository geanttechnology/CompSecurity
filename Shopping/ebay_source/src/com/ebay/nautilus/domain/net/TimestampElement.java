// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import java.text.ParseException;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayDateUtils, EbayResponse

public final class TimestampElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
{

    public long hostTime;
    private final EbayResponse response;

    public TimestampElement(EbayResponse ebayresponse)
    {
        hostTime = 0L;
        response = ebayresponse;
    }

    public void text(String s)
        throws SAXException
    {
        try
        {
            hostTime = EbayDateUtils.parseIntoMs(s);
            response.setHostTime(hostTime);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new SAXNotRecognizedException(s.getLocalizedMessage());
        }
    }
}
