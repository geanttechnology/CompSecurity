// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.favorites;


public final class FavoritesParameter extends Enum
{

    private static final FavoritesParameter $VALUES[];
    public static final FavoritesParameter CONFIGURATION;
    public static final FavoritesParameter ITEMS;
    public static final FavoritesParameter REQUEST_TOKEN;
    private final String name;

    private FavoritesParameter(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static FavoritesParameter valueOf(String s)
    {
        return (FavoritesParameter)Enum.valueOf(com/amazon/searchapp/retailsearch/client/favorites/FavoritesParameter, s);
    }

    public static FavoritesParameter[] values()
    {
        return (FavoritesParameter[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        CONFIGURATION = new FavoritesParameter("CONFIGURATION", 0, "favConfig");
        ITEMS = new FavoritesParameter("ITEMS", 1, "favItems");
        REQUEST_TOKEN = new FavoritesParameter("REQUEST_TOKEN", 2, "favRequestToken");
        $VALUES = (new FavoritesParameter[] {
            CONFIGURATION, ITEMS, REQUEST_TOKEN
        });
    }
}
