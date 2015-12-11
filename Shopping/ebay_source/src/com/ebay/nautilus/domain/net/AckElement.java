// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import java.util.Locale;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayResponse

public final class AckElement extends com.ebay.nautilus.kernel.util.SaxHandler.TextElement
{

    private final EbayResponse response;

    public AckElement(EbayResponse ebayresponse)
    {
        response = ebayresponse;
    }

    public void text(String s)
        throws SAXException
    {
        s = s.toLowerCase(Locale.US);
        int i;
        if (s.equals("success"))
        {
            i = 1;
        } else
        if (s.equals("warning"))
        {
            i = 2;
        } else
        if (s.equals("customcode"))
        {
            i = 0;
        } else
        if (s.equals("partialfailure"))
        {
            i = -2;
        } else
        {
            i = -1;
        }
        response.ackCode = i;
    }
}
