// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFeedbackResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t
{

    final _cls2 this$1;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("TotalNumberOfEntries".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetFeedbackResponse.RootElement.PaginationResult this$2;

                    public void setValue(int i)
                        throws SAXException
                    {
                        totalNumberOfEntries = i;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.PaginationResult.this;
                super();
            }
                };
            }
            if ("TotalNumberOfPages".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final GetFeedbackResponse.RootElement.PaginationResult this$2;

                    public void setValue(int i)
                        throws SAXException
                    {
                        totalNumberOfPages = i;
                    }

            
            {
                this$2 = GetFeedbackResponse.RootElement.PaginationResult.this;
                super();
            }
                };
            }
        }
        return super.t(s, s1, s2, attributes);
    }

    private _cls2.this._cls2()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
