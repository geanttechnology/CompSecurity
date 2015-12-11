// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.findproduct;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.TimestampElement;
import com.ebay.nautilus.kernel.util.SaxHandler;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class FindProductsResponse extends EbayResponse
{
    public static class ProductResult
    {

        public String categoryIdPath;
        public String id;
        public String stockPhotoUrl;
        public String title;

        public ProductResult()
        {
        }
    }

    private final class RootElement extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final FindProductsResponse this$0;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("ack".equals(s1))
            {
                return new AckElement(FindProductsResponse.this);
            }
            if ("timestamp".equals(s1))
            {
                return new TimestampElement(FindProductsResponse.this);
            }
            if ("resultSummary".equals(s1))
            {
                return new ResultSummary();
            }
            if ("searchResultSet".equals(s1))
            {
                return new SearchResultSet();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement()
        {
            this$0 = FindProductsResponse.this;
            super();
        }

    }

    private final class RootElement.ResultSummary extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("matchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.ResultSummary this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        matchCount = i;
                    }

            
            {
                this$2 = RootElement.ResultSummary.this;
                super();
            }
                };
            }
            if ("abridgedMatchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final RootElement.ResultSummary this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        abridgedMatchCount = i;
                    }

            
            {
                this$2 = RootElement.ResultSummary.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.ResultSummary()
        {
            this$1 = RootElement.this;
            super();
        }

    }

    private final class RootElement.SearchResultSet extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public ProductResult result;
        final RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("mapping".equals(s1))
            {
                return new Mapping();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public RootElement.SearchResultSet()
        {
            this$1 = RootElement.this;
            super();
            result = new ProductResult();
            results.add(result);
        }
    }

    private final class RootElement.SearchResultSet.Mapping extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private String name;
        final RootElement.SearchResultSet this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("field".equals(s1))
            {
                return new Field();
            }
            if ("fieldValue".equals(s1))
            {
                return new FieldValue();
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }



/*
        static String access$502(RootElement.SearchResultSet.Mapping mapping, String s)
        {
            mapping.name = s;
            return s;
        }

*/

        private RootElement.SearchResultSet.Mapping()
        {
            this$2 = RootElement.SearchResultSet.this;
            super();
        }

    }

    private final class RootElement.SearchResultSet.Mapping.Field extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.SearchResultSet.Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.SearchResultSet.Mapping.Field this$4;

                    public void text(String s)
                        throws SAXException
                    {
                        name = s;
                    }

            
            {
                this$4 = RootElement.SearchResultSet.Mapping.Field.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.SearchResultSet.Mapping.Field()
        {
            this$3 = RootElement.SearchResultSet.Mapping.this;
            super();
        }

    }

    private final class RootElement.SearchResultSet.Mapping.FieldValue extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final RootElement.SearchResultSet.Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final RootElement.SearchResultSet.Mapping.FieldValue this$4;

                    public void text(String s)
                        throws SAXException
                    {
                        if ("PRODUCT_REFERENCE_ID".equals(name))
                        {
                            result.id = s;
                        } else
                        {
                            if ("TITLE".equals(name))
                            {
                                result.title = s;
                                return;
                            }
                            if ("STOCK_PHOTO_URL".equals(name))
                            {
                                result.stockPhotoUrl = s;
                                return;
                            }
                            if ("ALLCATS".equals(name))
                            {
                                if (TextUtils.isEmpty(result.categoryIdPath))
                                {
                                    result.categoryIdPath = s;
                                    return;
                                } else
                                {
                                    StringBuilder stringbuilder = new StringBuilder();
                                    ProductResult productresult = result;
                                    productresult.categoryIdPath = stringbuilder.append(productresult.categoryIdPath).append(":").append(s).toString();
                                    return;
                                }
                            }
                        }
                    }

            
            {
                this$4 = RootElement.SearchResultSet.Mapping.FieldValue.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private RootElement.SearchResultSet.Mapping.FieldValue()
        {
            this$3 = RootElement.SearchResultSet.Mapping.this;
            super();
        }

    }


    public int abridgedMatchCount;
    public int matchCount;
    public ArrayList results;

    public FindProductsResponse()
    {
        results = new ArrayList();
    }

    public void parse(InputStream inputstream)
        throws com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException
    {
        SaxHandler.parseXml(inputstream, new RootElement());
    }
}
