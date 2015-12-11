// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.findproduct;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.findproduct:
//            FindProductsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.mmary
{

    final _cls2 this$1;

    public com.ebay.nautilus.kernel.util.mmary get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("matchCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final FindProductsResponse.RootElement.ResultSummary this$2;

                protected void setValue(int i)
                    throws SAXException
                {
                    matchCount = i;
                }

            
            {
                this$2 = FindProductsResponse.RootElement.ResultSummary.this;
                super();
            }
            };
        }
        if ("abridgedMatchCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final FindProductsResponse.RootElement.ResultSummary this$2;

                protected void setValue(int i)
                    throws SAXException
                {
                    abridgedMatchCount = i;
                }

            
            {
                this$2 = FindProductsResponse.RootElement.ResultSummary.this;
                super();
            }
            };
        } else
        {
            return super.mmary(s, s1, s2, attributes);
        }
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
