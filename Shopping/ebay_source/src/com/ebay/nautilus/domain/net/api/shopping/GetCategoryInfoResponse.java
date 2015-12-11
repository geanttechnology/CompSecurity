// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopping;

import com.ebay.nautilus.domain.data.EbayCategory;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.ErrorElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class GetCategoryInfoResponse extends EbayResponse
{
    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final GetCategoryInfoResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("Ack".equals(s1))
                {
                    return new AckElement(GetCategoryInfoResponse.this);
                }
                if ("Timestamp".equals(s1))
                {
                    return new TimestampElement(GetCategoryInfoResponse.this);
                }
                if ("Errors".equals(s1))
                {
                    return new ErrorElement(GetCategoryInfoResponse.this, "urn:ebay:apis:eBLBaseComponents");
                }
                if ("CategoryArray".equals(s1))
                {
                    return new CategoryArray();
                }
            }
            return super.get(s, s1, s2, attributes);
        }

        private RootElement()
        {
            this$0 = GetCategoryInfoResponse.this;
            super();
        }

    }

    private final class RootElement.CategoryArray extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s) && "Category".equals(s1))
            {
                return new Category();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.CategoryArray()
        {
            this$1 = RootElement.this;
            super();
        }

    }

    private final class RootElement.CategoryArray.Category extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private final EbayCategory category = new EbayCategory();
        final RootElement.CategoryArray this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("urn:ebay:apis:eBLBaseComponents".equals(s))
            {
                if ("CategoryID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final RootElement.CategoryArray.Category this$3;

                        public void setValue(long l)
                            throws SAXException
                        {
                            category.id = l;
                        }

            
            {
                this$3 = RootElement.CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("CategoryParentID".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.LongElement() {

                        final RootElement.CategoryArray.Category this$3;

                        public void setValue(long l)
                            throws SAXException
                        {
                            category.parentId = l;
                        }

            
            {
                this$3 = RootElement.CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("CategoryLevel".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                        final RootElement.CategoryArray.Category this$3;

                        public void setValue(int i)
                            throws SAXException
                        {
                            category.level = i;
                        }

            
            {
                this$3 = RootElement.CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("CategoryIDPath".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.CategoryArray.Category this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            category.idPath = s;
                        }

            
            {
                this$3 = RootElement.CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("CategoryName".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.CategoryArray.Category this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            category.name = s;
                        }

            
            {
                this$3 = RootElement.CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("CategoryNamePath".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                        final RootElement.CategoryArray.Category this$3;

                        public void text(String s)
                            throws SAXException
                        {
                            category.namePath = s;
                        }

            
            {
                this$3 = RootElement.CategoryArray.Category.this;
                super();
            }
                    };
                }
                if ("LeafCategory".equals(s1))
                {
                    return new com.ebay.nautilus.kernel.util.SaxHandler.BooleanElement() {

                        final RootElement.CategoryArray.Category this$3;

                        public void setValue(boolean flag)
                            throws SAXException
                        {
                            category.isLeaf = flag;
                        }

            
            {
                this$3 = RootElement.CategoryArray.Category.this;
                super();
            }
                    };
                }
            }
            return super.get(s, s1, s2, attributes);
        }


        public RootElement.CategoryArray.Category()
        {
            this$2 = RootElement.CategoryArray.this;
            super();
            categories.add(category);
        }
    }


    public final ArrayList categories = new ArrayList();

    public GetCategoryInfoResponse()
    {
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
