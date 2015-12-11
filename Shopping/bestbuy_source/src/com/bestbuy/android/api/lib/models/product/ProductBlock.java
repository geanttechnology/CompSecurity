// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;

public class ProductBlock
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private int haveValue;
    private int wantValue;

    public ProductBlock()
    {
    }

    public static ProductBlock loadData()
    {
        ProductBlock productblock = new ProductBlock();
        productblock.wantValue = 1;
        productblock.haveValue = 0;
        return productblock;
    }

    public int getHaveValue()
    {
        return haveValue;
    }

    public int getWantValue()
    {
        return wantValue;
    }
}
