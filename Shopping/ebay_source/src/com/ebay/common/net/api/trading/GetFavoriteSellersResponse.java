// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.SavedSeller;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetFavoriteSellersResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetFavoriteSellersResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
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
                    return new FavoriteSellers();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetFavoriteSellersResponse.this;
            super();
        }

    }

    private final class RootElement.FavoriteSeller extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final SavedSeller seller;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("UserID".compareToIgnoreCase(s1) == 0)
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FavoriteSeller this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            seller.userId = s;
                        }

            
            {
                this$2 = RootElement.FavoriteSeller.this;
                super();
            }
                    };
                }
                if ("StoreName".compareToIgnoreCase(s1) == 0)
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.FavoriteSeller this$2;

                        public void text(String s)
                            throws SAXException
                        {
                            seller.storeName = s;
                        }

            
            {
                this$2 = RootElement.FavoriteSeller.this;
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


        private RootElement.FavoriteSeller()
        {
            this$1 = RootElement.this;
            super();
            seller = new SavedSeller();
            sellerList.add(seller);
        }

    }

    private final class RootElement.FavoriteSellers extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "FavoriteSeller".equals(s1))
            {
                return new RootElement.FavoriteSeller();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.FavoriteSellers()
        {
            this$1 = RootElement.this;
            super();
        }

    }


    public final ArrayList sellerList = new ArrayList();

    public GetFavoriteSellersResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
