// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.zxing.client.result;


// Referenced classes of package com.google.zxing.client.result:
//            ParsedResult, ParsedResultType

public final class ProductParsedResult extends ParsedResult
{

    private final String normalizedProductID;
    private final String productID;

    ProductParsedResult(String s)
    {
        this(s, s);
    }

    ProductParsedResult(String s, String s1)
    {
        super(ParsedResultType.PRODUCT);
        productID = s;
        normalizedProductID = s1;
    }

    public String getDisplayResult()
    {
        return productID;
    }

    public String getNormalizedProductID()
    {
        return normalizedProductID;
    }

    public String getProductID()
    {
        return productID;
    }
}
