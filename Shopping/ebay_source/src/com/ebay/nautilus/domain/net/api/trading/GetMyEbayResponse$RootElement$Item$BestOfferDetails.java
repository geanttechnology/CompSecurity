// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.CurrencyElement;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ferDetails
{

    final _cls2 this$0;

    public com.ebay.nautilus.kernel.util.ferDetails get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("BestOffer".equals(s1))
        {
            s = this._cls0.this.<init>;
            s1 = new ItemCurrency();
            s.bestOfferAmount = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("BestOfferStatus".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final GetMyEbayResponse.RootElement.Item.BestOfferDetails this$1;

                public void text(String s3)
                    throws SAXException
                {
                    item.bestOfferStatus = s3;
                }

            
            {
                this$1 = GetMyEbayResponse.RootElement.Item.BestOfferDetails.this;
                super();
            }
            };
        }
        if ("BestOfferCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.Item.BestOfferDetails this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    item.bestOfferPendingCount = i;
                }

            
            {
                this$1 = GetMyEbayResponse.RootElement.Item.BestOfferDetails.this;
                super();
            }
            };
        } else
        {
            return super.ferDetails(s, s1, s2, attributes);
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
