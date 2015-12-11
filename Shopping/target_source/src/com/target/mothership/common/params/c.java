// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.params;

import com.target.mothership.common.product.Tcin;

public class c
{

    private static final String INCLUDE = "Products";
    private static final String PREFIX_PRODUCT_ID = "ProductId:";
    private static final String STATISTICS_TYPE = "Reviews";
    private final int mItemsPerPage;
    private final int mOffset;
    private final int mPageNumber;
    private final String mProductId;

    public c(Tcin tcin, int i, int j)
    {
        mProductId = tcin.b();
        mItemsPerPage = i;
        mPageNumber = j;
        mOffset = i * j;
    }

    public static String b()
    {
        return "Reviews";
    }

    public static String c()
    {
        return "Products";
    }

    public String a()
    {
        StringBuilder stringbuilder = new StringBuilder("ProductId:");
        stringbuilder.append(mProductId);
        return stringbuilder.toString();
    }

    public String d()
    {
        return Integer.toString(mOffset);
    }

    public String e()
    {
        return Integer.toString(mItemsPerPage);
    }
}
