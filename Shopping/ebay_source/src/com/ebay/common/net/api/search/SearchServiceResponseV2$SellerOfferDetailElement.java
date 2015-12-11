// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.common.net.api.search.wiremodel.SearchResponse;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.search:
//            SearchServiceResponseV2

private class this._cls0 extends com.ebay.nautilus.kernel.util.
{

    final SearchServiceResponseV2 this$0;

    public com.ebay.nautilus.kernel.util. get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("subTitle".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final SearchServiceResponseV2.SellerOfferDetailElement this$1;

                public void text(String s3)
                    throws SAXException
                {
                    searchResponse.sellerOfferDetail.subTitle = s3;
                }

            
            {
                this$1 = SearchServiceResponseV2.SellerOfferDetailElement.this;
                super();
            }
            };
        }
        if ("offerMessageDetail".equals(s1))
        {
            return new (SearchServiceResponseV2.this, null);
        } else
        {
            return super._mth0(s, s1, s2, attributes);
        }
    }

    public _cls1.this._cls1()
    {
        this$0 = SearchServiceResponseV2.this;
        super();
        searchResponse.sellerOfferDetail = new this._cls0();
    }
}
