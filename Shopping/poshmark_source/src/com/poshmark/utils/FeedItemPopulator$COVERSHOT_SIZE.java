// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            FeedItemPopulator

public static final class _cls9 extends Enum
{

    private static final SMALL $VALUES[];
    public static final SMALL LARGE;
    public static final SMALL MEDIUM;
    public static final SMALL SMALL;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/poshmark/utils/FeedItemPopulator$COVERSHOT_SIZE, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        LARGE = new <init>("LARGE", 0);
        MEDIUM = new <init>("MEDIUM", 1);
        SMALL = new <init>("SMALL", 2);
        $VALUES = (new .VALUES[] {
            LARGE, MEDIUM, SMALL
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
