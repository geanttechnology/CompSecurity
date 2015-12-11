// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.finding;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorMessageElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.finding:
//            FindNewItemsForFavoriteSearch

private static final class <init> extends EbayResponse
{
    private final class MainElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final FindNewItemsForFavoriteSearch.EbaySavedSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("totalEntries".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final MainElement this$1;

                    public void setValue(int i)
                        throws SAXException
                    {
                        count = i;
                    }

            
            {
                this$1 = MainElement.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private MainElement()
        {
            this$0 = FindNewItemsForFavoriteSearch.EbaySavedSearchResponse.this;
            super();
        }

        MainElement(FindNewItemsForFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final FindNewItemsForFavoriteSearch.EbaySavedSearchResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(FindNewItemsForFavoriteSearch.EbaySavedSearchResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(FindNewItemsForFavoriteSearch.EbaySavedSearchResponse.this);
            }
            if ("errorMessage".equals(s1))
            {
                return new ErrorMessageElement(FindNewItemsForFavoriteSearch.EbaySavedSearchResponse.this, "http://www.ebay.com/marketplace/search/v1/services");
            }
            if ("paginationOutput".equals(s1))
            {
                return new MainElement(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = FindNewItemsForFavoriteSearch.EbaySavedSearchResponse.this;
            super();
        }

        RootElement(FindNewItemsForFavoriteSearch._cls1 _pcls1)
        {
            this();
        }
    }


    public int count;

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.se
    {
        SaxHandler.parseXml(inputstream, new RootElement(null));
    }

    private RootElement()
    {
    }

    RootElement(RootElement rootelement)
    {
        this();
    }
}
