// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;


public class ProductSuggestion
{

    public String categoryId;
    public String categoryName;
    public String epid;
    public String imageUrl;
    public String label;

    public ProductSuggestion()
    {
    }

    public String toString()
    {
        return label;
    }
}
