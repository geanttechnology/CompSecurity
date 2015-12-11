// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.SavedSeller;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetFavoriteSellersResponse

private final class <init> extends com.ebay.nautilus.kernel.util.t
{
    private final class FavoriteSeller extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final SavedSeller seller;
        final GetFavoriteSellersResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("UserID".compareToIgnoreCase(s1) == 0)
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FavoriteSeller this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            seller.userId = s;
                        }

            
            {
                this$2 = FavoriteSeller.this;
                super();
            }
                    };
                }
                if ("StoreName".compareToIgnoreCase(s1) == 0)
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final FavoriteSeller this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            seller.storeName = s;
                        }

            
            {
                this$2 = FavoriteSeller.this;
                super();
            }
                    };
                } else
                {
                    return super.get(s, s1, s2, attributes);
                }
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }


        private FavoriteSeller()
        {
            this$1 = GetFavoriteSellersResponse.RootElement.this;
            super();
            seller = new SavedSeller();
            sellerList.add(seller);
        }

        FavoriteSeller(GetFavoriteSellersResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class FavoriteSellers extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetFavoriteSellersResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "FavoriteSeller".equals(s1))
            {
                return new FavoriteSeller(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private FavoriteSellers()
        {
            this$1 = GetFavoriteSellersResponse.RootElement.this;
            super();
        }

        FavoriteSellers(GetFavoriteSellersResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final GetFavoriteSellersResponse this$0;

    public com.ebay.nautilus.kernel.util.t get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("urn:ebay:apis:eBLBaseComponents".equals(s))
        {
            if ("Ack".equals(s1))
            {
                return new AckElement(GetFavoriteSellersResponse.this);
            }
            if ("Timestamp".equals(s1))
            {
                return new TimestampElement(GetFavoriteSellersResponse.this);
            }
            if ("Errors".equals(s1))
            {
                return new ErrorElement(GetFavoriteSellersResponse.this, "urn:ebay:apis:eBLBaseComponents");
            }
            if ("FavoriteSellers".equals(s1))
            {
                return new FavoriteSellers(null);
            }
        }
        return super.t(s, s1, s2, attributes);
    }

    private FavoriteSellers()
    {
        this$0 = GetFavoriteSellersResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
