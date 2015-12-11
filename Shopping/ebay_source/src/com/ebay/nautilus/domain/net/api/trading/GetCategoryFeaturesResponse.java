// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetCategoryFeaturesResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetCategoryFeaturesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetCategoryFeaturesResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetCategoryFeaturesResponse.this);
                }
                if ("Category".equals(s1))
                {
                    return new Category();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetCategoryFeaturesResponse.this;
            super();
        }

    }

    private final class RootElement.Category extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private long categoryId;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CategoryID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final RootElement.Category this$2;

                        public void setValue(long l)
                            throws SAXException
                        {
                            categoryId = l;
                        }

            
            {
                this$2 = RootElement.Category.this;
                super();
            }
                    };
                }
                if ("UserConsentRequired".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final RootElement.Category this$2;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            if (flag && categoryId > 0L)
                            {
                                categoriesRequiringConsent.add(Long.valueOf(categoryId));
                            }
                        }

            
            {
                this$2 = RootElement.Category.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }



/*
        static long access$202(RootElement.Category category, long l)
        {
            category.categoryId = l;
            return l;
        }

*/

        private RootElement.Category()
        {
            this$1 = RootElement.this;
            super();
        }

    }


    public final List categoriesRequiringConsent = new ArrayList();

    public GetCategoryFeaturesResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
