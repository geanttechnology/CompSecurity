// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results.layout;


public final class SearchLayoutType extends Enum
{

    private static final SearchLayoutType $VALUES[];
    public static final SearchLayoutType FlipBook;
    public static final SearchLayoutType Gallery;
    public static final SearchLayoutType Grid;
    public static final SearchLayoutType List;
    public static final SearchLayoutType Split;

    private SearchLayoutType(String s, int i)
    {
        super(s, i);
    }

    public static SearchLayoutType valueOf(String s)
    {
        return (SearchLayoutType)Enum.valueOf(com/amazon/retailsearch/android/ui/results/layout/SearchLayoutType, s);
    }

    public static SearchLayoutType[] values()
    {
        return (SearchLayoutType[])$VALUES.clone();
    }

    static 
    {
        List = new SearchLayoutType("List", 0);
        Grid = new SearchLayoutType("Grid", 1);
        Gallery = new SearchLayoutType("Gallery", 2);
        FlipBook = new SearchLayoutType("FlipBook", 3);
        Split = new SearchLayoutType("Split", 4);
        $VALUES = (new SearchLayoutType[] {
            List, Grid, Gallery, FlipBook, Split
        });
    }
}
