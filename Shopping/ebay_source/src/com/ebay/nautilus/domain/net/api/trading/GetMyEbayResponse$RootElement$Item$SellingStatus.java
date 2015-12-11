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

private final class <init> extends com.ebay.nautilus.kernel.util.lingStatus
{
    private final class HighBidder extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetMyEbayResponse.RootElement.Item.SellingStatus this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("UserID".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final HighBidder this$2;

                    public void text(String s)
                        throws SAXException
                    {
                        item.highBidderId = s;
                    }

            
            {
                this$2 = HighBidder.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private HighBidder()
        {
            this$1 = GetMyEbayResponse.RootElement.Item.SellingStatus.this;
            super();
        }

        HighBidder(GetMyEbayResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final HighBidder this$0;

    public com.ebay.nautilus.kernel.util.lingStatus get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("BidCount".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                final GetMyEbayResponse.RootElement.Item.SellingStatus this$1;

                public void setValue(int i)
                    throws SAXException
                {
                    item.bidCount = i;
                }

            
            {
                this$1 = GetMyEbayResponse.RootElement.Item.SellingStatus.this;
                super();
            }
            };
        }
        if ("ConvertedCurrentPrice".equals(s1))
        {
            s = _fld1;
            s1 = new ItemCurrency();
            s.convertedCurrentPrice = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("CurrentPrice".equals(s1))
        {
            s = _fld1;
            s1 = new ItemCurrency();
            s.currentPrice = s1;
            return new CurrencyElement(s1, "currencyID", attributes);
        }
        if ("ReserveMet".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                final GetMyEbayResponse.RootElement.Item.SellingStatus this$1;

                public void setValue(boolean flag)
                    throws SAXException
                {
                    item.reserveMet = flag;
                }

            
            {
                this$1 = GetMyEbayResponse.RootElement.Item.SellingStatus.this;
                super();
            }
            };
        }
        if ("HighBidder".equals(s1))
        {
            return new HighBidder(null);
        } else
        {
            return super.lingStatus(s, s1, s2, attributes);
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
