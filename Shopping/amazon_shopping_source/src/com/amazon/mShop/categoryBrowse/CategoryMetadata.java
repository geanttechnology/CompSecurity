// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.categoryBrowse;


public class CategoryMetadata
{

    public String searchAlias;
    public String searchUrl;
    public String title;

    private CategoryMetadata()
    {
        title = null;
        searchUrl = null;
        searchAlias = null;
    }

    public CategoryMetadata(String s, String s1, String s2)
    {
        title = null;
        searchUrl = null;
        searchAlias = null;
        title = s;
        searchUrl = s1;
        searchAlias = s2;
    }
}
