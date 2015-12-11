// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.findproduct;

import android.text.TextUtils;
import com.ebay.nautilus.domain.net.AckElement;
import com.ebay.nautilus.domain.net.TimestampElement;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.findproduct:
//            FindProductsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.ement
{
    private final class ResultSummary extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final FindProductsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("matchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final ResultSummary this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        matchCount = i;
                    }

            
            {
                this$2 = ResultSummary.this;
                super();
            }
                };
            }
            if ("abridgedMatchCount".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.IntegerElement() {

                    final ResultSummary this$2;

                    protected void setValue(int i)
                        throws SAXException
                    {
                        abridgedMatchCount = i;
                    }

            
            {
                this$2 = ResultSummary.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private ResultSummary()
        {
            this$1 = FindProductsResponse.RootElement.this;
            super();
        }

        ResultSummary(FindProductsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class SearchResultSet extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        public FindProductsResponse.ProductResult result;
        final FindProductsResponse.RootElement this$1;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("mapping".equals(s1))
            {
                return new Mapping(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        public SearchResultSet()
        {
            this$1 = FindProductsResponse.RootElement.this;
            super();
            result = new FindProductsResponse.ProductResult();
            results.add(result);
        }
    }

    private final class SearchResultSet.Mapping extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private String name;
        final SearchResultSet this$2;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("field".equals(s1))
            {
                return new Field(null);
            }
            if ("fieldValue".equals(s1))
            {
                return new FieldValue(null);
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }



/*
        static String access$502(SearchResultSet.Mapping mapping, String s)
        {
            mapping.name = s;
            return s;
        }

*/

        private SearchResultSet.Mapping()
        {
            this$2 = SearchResultSet.this;
            super();
        }

        SearchResultSet.Mapping(FindProductsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class SearchResultSet.Mapping.Field extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchResultSet.Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SearchResultSet.Mapping.Field this$4;

                    public void text(String s)
                        throws SAXException
                    {
                        name = s;
                    }

            
            {
                this$4 = SearchResultSet.Mapping.Field.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SearchResultSet.Mapping.Field()
        {
            this$3 = SearchResultSet.Mapping.this;
            super();
        }

        SearchResultSet.Mapping.Field(FindProductsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class SearchResultSet.Mapping.FieldValue extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final SearchResultSet.Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final SearchResultSet.Mapping.FieldValue this$4;

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
                                    FindProductsResponse.ProductResult productresult = result;
                                    productresult.categoryIdPath = stringbuilder.append(productresult.categoryIdPath).append(":").append(s).toString();
                                    return;
                                }
                            }
                        }
                    }

            
            {
                this$4 = SearchResultSet.Mapping.FieldValue.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private SearchResultSet.Mapping.FieldValue()
        {
            this$3 = SearchResultSet.Mapping.this;
            super();
        }

        SearchResultSet.Mapping.FieldValue(FindProductsResponse._cls1 _pcls1)
        {
            this();
        }
    }


    final FindProductsResponse this$0;

    public com.ebay.nautilus.kernel.util.ement get(String s, String s1, String s2, Attributes attributes)
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
            return new ResultSummary(null);
        }
        if ("searchResultSet".equals(s1))
        {
            return new SearchResultSet();
        } else
        {
            return super.ement(s, s1, s2, attributes);
        }
    }

    private SearchResultSet.result()
    {
        this$0 = FindProductsResponse.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
