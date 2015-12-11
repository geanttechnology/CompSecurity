// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.entry;


// Referenced classes of package com.amazon.retailsearch.android.ui.entry:
//            RetailSearchSuggestionRow

static final class  extends Enum
{

    private static final ICON $VALUES[];
    public static final ICON ICON;
    public static final ICON SUGGESTION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/retailsearch/android/ui/entry/RetailSearchSuggestionRow$RowType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SUGGESTION = new <init>("SUGGESTION", 0);
        ICON = new <init>("ICON", 1);
        $VALUES = (new .VALUES[] {
            SUGGESTION, ICON
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
