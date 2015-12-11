// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserDisputesResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t
{

    final GetUserDisputesResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(GetUserDisputesResponse.this);
            }
            if ("Timestamp".equals(s1))
            {
                return new TimestampElement(GetUserDisputesResponse.this);
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(GetUserDisputesResponse.this, "urn:ebay:apis:eBLBaseComponents");
            }
            if ("DisputeArray".equals(s1))
            {
                return new (GetUserDisputesResponse.this, null);
            }
            if ("PaginationResult".equals(s1))
            {
                return new sult(GetUserDisputesResponse.this, null);
            }
            if ("PageNumber".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetUserDisputesResponse.RootElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        pageNumber = i;
                    }

            
            {
                this$1 = GetUserDisputesResponse.RootElement.this;
                super();
            }
                };
            }
        }
        return super.t(s, s1, s2, attributes);
    }

    private _cls1.this._cls1()
    {
        this$0 = GetUserDisputesResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
