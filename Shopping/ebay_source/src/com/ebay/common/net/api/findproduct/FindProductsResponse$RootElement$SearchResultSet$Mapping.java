// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.findproduct;

import android.text.TextUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.findproduct:
//            FindProductsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.pping
{
    private final class Field extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final FindProductsResponse.RootElement.SearchResultSet.Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("name".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final Field this$4;

                    public void text(String s)
                        throws SAXException
                    {
                        name = s;
                    }

            
            {
                this$4 = Field.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private Field()
        {
            this$3 = FindProductsResponse.RootElement.SearchResultSet.Mapping.this;
            super();
        }

        Field(FindProductsResponse._cls1 _pcls1)
        {
            this();
        }
    }

    private final class FieldValue extends com.ebay.nautilus.kernel.util.SaxHandler.Element
    {

        final FindProductsResponse.RootElement.SearchResultSet.Mapping this$3;

        public com.ebay.nautilus.kernel.util.SaxHandler.Element get(String s, String s1, String s2, Attributes attributes)
            throws SAXException
        {
            if ("value".equals(s1))
            {
                return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                    final FieldValue this$4;

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
                this$4 = FieldValue.this;
                super();
            }
                };
            } else
            {
                return super.get(s, s1, s2, attributes);
            }
        }

        private FieldValue()
        {
            this$3 = FindProductsResponse.RootElement.SearchResultSet.Mapping.this;
            super();
        }

        FieldValue(FindProductsResponse._cls1 _pcls1)
        {
            this();
        }
    }


    private String name;
    final FieldValue this$2;

    public com.ebay.nautilus.kernel.util.pping get(String s, String s1, String s2, Attributes attributes)
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
            return super.pping(s, s1, s2, attributes);
        }
    }



/*
    static String access$502(FieldValue._cls1 _pcls1, String s)
    {
        _pcls1.name = s;
        return s;
    }

*/

    private FieldValue()
    {
        this$2 = this._cls2.this;
        super();
    }

    this._cls2(this._cls2 _pcls2_1)
    {
        this();
    }
}
