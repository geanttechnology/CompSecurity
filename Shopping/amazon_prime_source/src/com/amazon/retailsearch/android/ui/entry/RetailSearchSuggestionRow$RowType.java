// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;


// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchSuggestionRow

static final class viewType extends Enum
{

    private static final ICON $VALUES[];
    public static final ICON ICON;
    public static final ICON SUGGESTION;
    private final int viewType;

    public static viewType valueOf(String s)
    {
        return (viewType)Enum.valueOf(com/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType, s);
    }

    public static viewType[] values()
    {
        return (viewType[])$VALUES.clone();
    }

    public int getViewType()
    {
        return viewType;
    }

    static 
    {
        SUGGESTION = new <init>("SUGGESTION", 0, 1);
        ICON = new <init>("ICON", 1, 0);
        $VALUES = (new .VALUES[] {
            SUGGESTION, ICON
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        viewType = j;
    }
}
