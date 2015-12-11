// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ultElement
{

    final _cls2 this$0;

    public com.ebay.nautilus.kernel.util.ultElement get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("TotalNumberOfEntries".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.ListElement.PaginationResultElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    response.totalEntries = i;
                }

            
            {
                this$1 = GetMyEbayResponse.RootElement.ListElement.PaginationResultElement.this;
                super();
            }
            };
        }
        if ("TotalNumberOfPages".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.ListElement.PaginationResultElement this$1;

                protected void setValue(int i)
                    throws SAXException
                {
                    response.totalPages = i;
                }

            
            {
                this$1 = GetMyEbayResponse.RootElement.ListElement.PaginationResultElement.this;
                super();
            }
            };
        } else
        {
            return super.ultElement(s, s1, s2, attributes);
        }
    }

    private _cls2.this._cls1()
    {
        this$0 = this._cls0.this;
        super();
    }

    this._cls0(this._cls0 _pcls0_1)
    {
        this();
    }
}
