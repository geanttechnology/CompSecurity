// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shopping;

import com.ebay.common.model.EbayProductDomain;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.shopping:
//            FindProductsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.am
{
    public final class Domain extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayProductDomain domain = new EbayProductDomain();
        final FindProductsResponse.RootElement.DomainHistogram this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Count".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final Domain this$3;

                        protected void setValue(long l)
                            throws SAXException
                        {
                            domain.count = l;
                        }

            
            {
                this$3 = Domain.this;
                super();
            }
                    };
                }
                if ("Name".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final Domain this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            domain.name = s;
                        }

            
            {
                this$3 = Domain.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public Domain()
        {
            this$2 = FindProductsResponse.RootElement.DomainHistogram.this;
            super();
            domainHistogram.add(domain);
        }
    }


    final Domain this$1;

    public com.ebay.nautilus.kernel.util.am get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Domain".equals(s1))
        {
            return new Domain();
        } else
        {
            return super.am(s, s1, s2, attributes);
        }
    }

    private Domain.domain()
    {
        this$1 = this._cls1.this;
        super();
    }

    this._cls1(this._cls1 _pcls1_1)
    {
        this();
    }
}
