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

public final class domain extends com.ebay.nautilus.kernel.util.in
{

    private final EbayProductDomain domain = new EbayProductDomain();
    final domain this$2;

    public com.ebay.nautilus.kernel.util.in get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Count".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                    final FindProductsResponse.RootElement.DomainHistogram.Domain this$3;

                    protected void setValue(long l)
                        throws SAXException
                    {
                        domain.count = l;
                    }

            
            {
                this$3 = FindProductsResponse.RootElement.DomainHistogram.Domain.this;
                super();
            }
                };
            }
            if ("Name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FindProductsResponse.RootElement.DomainHistogram.Domain this$3;

                    public void text(String s3)
                        throws SAXException
                    {
                        domain.name = s3;
                    }

            
            {
                this$3 = FindProductsResponse.RootElement.DomainHistogram.Domain.this;
                super();
            }
                };
            }
        }
        return super.in(s, s1, s2, attributes);
    }


    public _cls2.this._cls3()
    {
        this$2 = this._cls2.this;
        super();
        domainHistogram.add(domain);
    }
}
