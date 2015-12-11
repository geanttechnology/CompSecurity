// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            ReviseMyMessagesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ootElement
{

    final ReviseMyMessagesResponse this$0;

    public com.ebay.nautilus.kernel.util.ootElement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(ReviseMyMessagesResponse.this);
            }
            if ("Timestamp".equals(s1))
            {
                return new TimestampElement(ReviseMyMessagesResponse.this);
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(ReviseMyMessagesResponse.this, "urn:ebay:apis:eBLBaseComponents");
            }
        }
        return super._mth0(s, s1, s2, attributes);
    }

    private ()
    {
        this$0 = ReviseMyMessagesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
