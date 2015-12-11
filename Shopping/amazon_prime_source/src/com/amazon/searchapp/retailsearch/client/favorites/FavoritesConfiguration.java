// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client.favorites;


public final class FavoritesConfiguration extends Enum
{

    private static final FavoritesConfiguration $VALUES[];
    public static final FavoritesConfiguration AIRSTREAM;
    public static final FavoritesConfiguration WISHLIST;
    private final String name;

    private FavoritesConfiguration(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static FavoritesConfiguration valueOf(String s)
    {
        return (FavoritesConfiguration)Enum.valueOf(com/amazon/searchapp/retailsearch/client/favorites/FavoritesConfiguration, s);
    }

    public static FavoritesConfiguration[] values()
    {
        return (FavoritesConfiguration[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        WISHLIST = new FavoritesConfiguration("WISHLIST", 0, "wishlist");
        AIRSTREAM = new FavoritesConfiguration("AIRSTREAM", 1, "airstream");
        $VALUES = (new FavoritesConfiguration[] {
            WISHLIST, AIRSTREAM
        });
    }
}
