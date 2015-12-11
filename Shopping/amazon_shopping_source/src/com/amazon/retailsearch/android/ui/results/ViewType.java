// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.results;


public final class ViewType extends Enum
{

    private static final ViewType $VALUES[];
    public static final ViewType GalleryView;
    public static final ViewType GridView;
    public static final ViewType ListView;
    public static final ViewType SplitView;
    private final String name;

    private ViewType(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static ViewType findByNameIgnoreCase(String s)
    {
        ViewType aviewtype[] = values();
        int j = aviewtype.length;
        for (int i = 0; i < j; i++)
        {
            ViewType viewtype = aviewtype[i];
            if (viewtype.getName().equalsIgnoreCase(s))
            {
                return viewtype;
            }
        }

        return null;
    }

    public static ViewType valueOf(String s)
    {
        return (ViewType)Enum.valueOf(com/amazon/retailsearch/android/ui/results/ViewType, s);
    }

    public static ViewType[] values()
    {
        return (ViewType[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        ListView = new ViewType("ListView", 0, "List");
        GridView = new ViewType("GridView", 1, "Grid");
        GalleryView = new ViewType("GalleryView", 2, "Gallery");
        SplitView = new ViewType("SplitView", 3, "Split");
        $VALUES = (new ViewType[] {
            ListView, GridView, GalleryView, SplitView
        });
    }
}
