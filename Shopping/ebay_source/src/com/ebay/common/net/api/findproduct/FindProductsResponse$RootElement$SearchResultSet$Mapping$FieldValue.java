// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.findproduct;

import android.text.TextUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

// Referenced classes of package com.ebay.common.net.api.findproduct:
//            FindProductsResponse

private final class <init> extends com.ebay.nautilus.kernel.util.Value
{

    final this._cls3 this$3;

    public com.ebay.nautilus.kernel.util.Value get(String s, String s1, String s2, Attributes attributes)
        throws SAXException
    {
        if ("value".equals(s1))
        {
            return new com.ebay.nautilus.kernel.util.SaxHandler.TextElement() {

                final FindProductsResponse.RootElement.SearchResultSet.Mapping.FieldValue this$4;

                public void text(String s3)
                    throws SAXException
                {
                    if ("PRODUCT_REFERENCE_ID".equals(FindProductsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                    {
                        result.id = s3;
                    } else
                    {
                        if ("TITLE".equals(FindProductsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.title = s3;
                            return;
                        }
                        if ("STOCK_PHOTO_URL".equals(FindProductsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            result.stockPhotoUrl = s3;
                            return;
                        }
                        if ("ALLCATS".equals(FindProductsResponse.RootElement.SearchResultSet.Mapping.access$500(this$3)))
                        {
                            if (TextUtils.isEmpty(result.categoryIdPath))
                            {
                                result.categoryIdPath = s3;
                                return;
                            } else
                            {
                                StringBuilder stringbuilder = new StringBuilder();
                                FindProductsResponse.ProductResult productresult = result;
                                productresult.categoryIdPath = stringbuilder.append(productresult.categoryIdPath).append(":").append(s3).toString();
                                return;
                            }
                        }
                    }
                }

            
            {
                this$4 = FindProductsResponse.RootElement.SearchResultSet.Mapping.FieldValue.this;
                super();
            }
            };
        } else
        {
            return super.Value(s, s1, s2, attributes);
        }
    }

    private _cls1.this._cls4()
    {
        this$3 = this._cls3.this;
        super();
    }

    this._cls3(this._cls3 _pcls3_1)
    {
        this();
    }
}
