// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.findproduct;

import android.text.TextUtils;
import java.util.ArrayList;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.findproduct:
//            FindProductsByIdsResponse

private final class result extends com.ebay.nautilus.kernel.util.ltSet
{
    private final class Mapping extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        private String name;
        final FindProductsByIdsResponse.RootElement.SearchResultSet this$2;

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
        static String access$402(Mapping mapping, String s)
        {
            mapping.name = s;
            return s;
        }

*/

        private Mapping()
        {
            this$2 = FindProductsByIdsResponse.RootElement.SearchResultSet.this;
            super();
        }

        Mapping(FindProductsByIdsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Mapping.Field extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Mapping.Field this$4;

                    public void text(String s)
                        throws SAXException
                    {
                        name = s;
                    }

            
            {
                this$4 = Mapping.Field.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Mapping.Field()
        {
            this$3 = Mapping.this;
            super();
        }

        Mapping.Field(FindProductsByIdsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class Mapping.FieldValue extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Mapping.FieldValue this$4;

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
                this$4 = Mapping.FieldValue.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Mapping.FieldValue()
        {
            this$3 = Mapping.this;
            super();
        }

        Mapping.FieldValue(FindProductsByIdsResponse._cls1 _pcls1)
        {
            this();
        }
    }


    public Mapping result;
    final Mapping this$1;

    public com.ebay.nautilus.kernel.util.ltSet get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("mapping".equals(s1))
        {
            return new Mapping(null);
        } else
        {
            return super.ltSet(s, s1, s2, attributes);
        }
    }

    public Mapping()
    {
        this$1 = this._cls1.this;
        super();
        result = new result();
        results.add(result);
    }
}
