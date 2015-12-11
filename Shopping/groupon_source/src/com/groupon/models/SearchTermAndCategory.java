// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models;


public class SearchTermAndCategory
{

    public static final String EMPTY_CATEGORY = "";
    private String searchCategory;
    private String searchTerm;

    public SearchTermAndCategory(String s, String s1)
    {
        searchTerm = s;
        searchCategory = s1;
    }

    public boolean equals(Object obj)
    {
        return (obj instanceof SearchTermAndCategory) && ((SearchTermAndCategory)obj).getSearchTerm().equals(searchTerm);
    }

    public String getSearchCategory()
    {
        return searchCategory;
    }

    public String getSearchTerm()
    {
        return searchTerm;
    }

    public int hashCode()
    {
        return searchTerm.hashCode();
    }
}
