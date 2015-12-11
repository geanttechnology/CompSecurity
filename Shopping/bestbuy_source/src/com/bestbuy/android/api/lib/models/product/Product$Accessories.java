// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.product:
//            Product

public class s
    implements Serializable
{

    private static final long serialVersionUID = 1L;

    public static ArrayList getAccessoriesList(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray != null)
        {
            int i = 0;
            while (i < jsonarray.length()) 
            {
                Product product = new Product();
                JSONObject jsonobject = jsonarray.optJSONObject(i);
                if (jsonobject != null)
                {
                    Product.access$002(product, jsonobject.optString("skuId"));
                    Product.access$102(product, jsonobject.optString("productId"));
                    Product.access$202(product, jsonobject.optJSONObject("meta").optString("title"));
                    s s = new s();
                    if (jsonobject.optJSONObject("media") != null)
                    {
                        if (jsonobject.optJSONObject("media").optJSONObject("listImage") != null)
                        {
                            s.access._mth302(s, jsonobject.optJSONObject("media").optJSONObject("listImage").optString("url"));
                        }
                        if (jsonobject.optJSONObject("media").optJSONObject("primaryImage") != null)
                        {
                            s.access._mth402(s, jsonobject.optJSONObject("media").optJSONObject("primaryImage").optString("url"));
                        }
                    }
                    Product.access$502(product, s);
                    Product.access$602(product, Integer.parseInt(jsonobject.optJSONObject("customerRatings").optString("totalCount")));
                    if (Product.access$600(product) == 0)
                    {
                        product.customerReviewAverage = 0.0D;
                    } else
                    if (jsonobject.optJSONObject("customerRatings") != null)
                    {
                        if (jsonobject.optJSONObject("customerRatings").optJSONObject("averageRating") != null)
                        {
                            product.customerReviewAverage = Double.parseDouble(jsonobject.optJSONObject("customerRatings").optJSONObject("averageRating").optString("score"));
                        } else
                        {
                            product.customerReviewAverage = 0.0D;
                        }
                    } else
                    {
                        product.customerReviewAverage = 0.0D;
                    }
                }
                arraylist.add(product);
                i++;
            }
        }
        return arraylist;
    }

    public s()
    {
    }
}
