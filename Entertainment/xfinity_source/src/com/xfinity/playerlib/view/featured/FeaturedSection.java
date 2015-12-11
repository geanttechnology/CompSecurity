// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.featured;


public final class FeaturedSection extends Enum
{

    private static final FeaturedSection $VALUES[];
    public static final FeaturedSection FEATURED;
    public static final FeaturedSection MOVIES;
    public static final FeaturedSection TV_SERIES;
    private final int captionResId;

    private FeaturedSection(String s, int i, int j)
    {
        super(s, i);
        captionResId = j;
    }

    public static FeaturedSection valueOf(String s)
    {
        return (FeaturedSection)Enum.valueOf(com/xfinity/playerlib/view/featured/FeaturedSection, s);
    }

    public static FeaturedSection[] values()
    {
        return (FeaturedSection[])$VALUES.clone();
    }

    static 
    {
        FEATURED = new FeaturedSection("FEATURED", 0, com.xfinity.playerlib.R.string.featured_label);
        TV_SERIES = new FeaturedSection("TV_SERIES", 1, com.xfinity.playerlib.R.string.tv_series_label);
        MOVIES = new FeaturedSection("MOVIES", 2, com.xfinity.playerlib.R.string.movies_label);
        $VALUES = (new FeaturedSection[] {
            FEATURED, TV_SERIES, MOVIES
        });
    }
}
