// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

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
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "TotalNumberOfPages".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetUserDisputesResponse.PaginationResult this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    totalNumberOfPages = i;
                }

            
            {
                this$1 = GetUserDisputesResponse.PaginationResult.this;
                super();
            }
            };
        } else
        {
            return super.t(s, s1, s2, attributes);
        }
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
