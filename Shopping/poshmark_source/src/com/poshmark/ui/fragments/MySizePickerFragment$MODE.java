// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;


// Referenced classes of package com.poshmark.ui.fragments:
//            MySizePickerFragment

static final class _cls9 extends Enum
{

    private static final SEARCH_FILTER $VALUES[];
    public static final SEARCH_FILTER MY_SIZE;
    public static final SEARCH_FILTER SEARCH_FILTER;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/poshmark/ui/fragments/MySizePickerFragment$MODE, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        MY_SIZE = new <init>("MY_SIZE", 0);
        SEARCH_FILTER = new <init>("SEARCH_FILTER", 1);
        $VALUES = (new .VALUES[] {
            MY_SIZE, SEARCH_FILTER
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
