// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.ItemTransaction;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.m
{

    final GetItemTransactionsResponse this$0;

    public com.ebay.nautilus.kernel.util.m get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("Status".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetItemTransactionsResponse.UnpaidItem this$1;

                public void text(String s3)
                    throws SAXException
                {
                    GetItemTransactionsResponse.access$600(this$0).unpaidItem.status = s3;
                }

            
            {
                this$1 = GetItemTransactionsResponse.UnpaidItem.this;
                super();
            }
            };
        }
        if ("Type".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetItemTransactionsResponse.UnpaidItem this$1;

                public void text(String s3)
                    throws SAXException
                {
                    GetItemTransactionsResponse.access$600(this$0).unpaidItem.type = s3;
                }

            
            {
                this$1 = GetItemTransactionsResponse.UnpaidItem.this;
                super();
            }
            };
        } else
        {
            return super.m(s, s1, s2, attributes);
        }
    }

    private _cls2.this._cls1()
    {
        this$0 = GetItemTransactionsResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
