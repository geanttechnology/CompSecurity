// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;

import android.widget.ImageView;

// Referenced classes of package com.bestbuy.android.api.lib.models.mybby:
//            Transaction

public class RecepitProduct extends Transaction
{

    private static final long serialVersionUID = 1L;
    private String category;
    private String price;
    private String productImage;
    private String productName;
    private String purchaseDate;
    private String sku;

    public RecepitProduct()
    {
    }

    public void fetchImage(ImageView imageview)
    {
    }

    public String getCategory()
    {
        return category;
    }

    public String getFirstDetail()
    {
        return null;
    }

    public String getName()
    {
        return null;
    }

    public String getPrice()
    {
        return price;
    }

    public String getProductImage()
    {
        return productImage;
    }

    public String getProductName()
    {
        return productName;
    }

    public String getPurchaseDate()
    {
        return purchaseDate;
    }

    public String getSecondDetail()
    {
        return null;
    }

    public String getSku()
    {
        return sku;
    }

    public void setCategory(String s)
    {
        category = s;
    }

    public void setFirstDetail()
    {
    }

    public void setName()
    {
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setProductImage(String s)
    {
        productImage = s;
    }

    public void setProductName(String s)
    {
        productName = s;
    }

    public void setPurchaseDate(String s)
    {
        purchaseDate = s;
    }

    public void setSecondDetail()
    {
    }

    public void setSku(String s)
    {
        sku = s;
    }
}
