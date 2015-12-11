// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;


// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

public static final class I extends Enum
{

    private static final FULL $VALUES[];
    public static final FULL FULL;
    public static final FULL NEW;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/xfinity/playerlib/view/search/SearchResultsFragment$ListSection, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        NEW = new <init>("NEW", 0);
        FULL = new <init>("FULL", 1);
        $VALUES = (new .VALUES[] {
            NEW, FULL
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
