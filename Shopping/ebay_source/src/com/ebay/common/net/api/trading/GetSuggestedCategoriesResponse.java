// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.model.EbaySuggestedCategory;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class GetSuggestedCategoriesResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetSuggestedCategoriesResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetSuggestedCategoriesResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetSuggestedCategoriesResponse.this);
                }
                if ("SuggestedCategoryArray".equals(s1))
                {
                    return new SuggestedCategoryArray();
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetSuggestedCategoriesResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetSuggestedCategoriesResponse.this;
            super();
        }

    }

    private final class RootElement.SuggestedCategoryArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "SuggestedCategory".equals(s1))
            {
                return new SuggestedCategory();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.SuggestedCategoryArray()
        {
            this$1 = RootElement.this;
            super();
        }

    }

    private final class RootElement.SuggestedCategoryArray.SuggestedCategory extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbaySuggestedCategory suggestedCategory = new EbaySuggestedCategory();
        final RootElement.SuggestedCategoryArray this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Category".equals(s1))
                {
                    return new Category();
                }
                if ("PercentItemFound".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final RootElement.SuggestedCategoryArray.SuggestedCategory this$3;

                        public void setValue(long l)
                            throws SAXException
                        {
                            suggestedCategory.percentItemFound = l;
                        }

            
            {
                this$3 = RootElement.SuggestedCategoryArray.SuggestedCategory.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.SuggestedCategoryArray.SuggestedCategory()
        {
            this$2 = RootElement.SuggestedCategoryArray.this;
            super();
            suggestions.add(suggestedCategory);
        }
    }

    private final class RootElement.SuggestedCategoryArray.SuggestedCategory.Category extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.SuggestedCategoryArray.SuggestedCategory this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CategoryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.SuggestedCategoryArray.SuggestedCategory.Category this$4;

                        public void text(String s)
                            throws SAXException
                        {
                            suggestedCategory.name = s;
                        }

            
            {
                this$4 = RootElement.SuggestedCategoryArray.SuggestedCategory.Category.this;
                super();
            }
                    };
                }
                if ("CategoryID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final RootElement.SuggestedCategoryArray.SuggestedCategory.Category this$4;

                        public void setValue(long l)
                            throws SAXException
                        {
                            suggestedCategory.id = l;
                        }

            
            {
                this$4 = RootElement.SuggestedCategoryArray.SuggestedCategory.Category.this;
                super();
            }
                    };
                }
                if ("CategoryParentID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.SuggestedCategoryArray.SuggestedCategory.Category this$4;

                        public void text(String s)
                            throws SAXException
                        {
                            suggestedCategory.parentIds.add(s);
                        }

            
            {
                this$4 = RootElement.SuggestedCategoryArray.SuggestedCategory.Category.this;
                super();
            }
                    };
                }
                if ("CategoryParentName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.SuggestedCategoryArray.SuggestedCategory.Category this$4;

                        public void text(String s)
                            throws SAXException
                        {
                            suggestedCategory.parentNames.add(s);
                        }

            
            {
                this$4 = RootElement.SuggestedCategoryArray.SuggestedCategory.Category.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement.SuggestedCategoryArray.SuggestedCategory.Category()
        {
            this$3 = RootElement.SuggestedCategoryArray.SuggestedCategory.this;
            super();
        }

    }


    public final ArrayList suggestions = new ArrayList();

    public GetSuggestedCategoriesResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
