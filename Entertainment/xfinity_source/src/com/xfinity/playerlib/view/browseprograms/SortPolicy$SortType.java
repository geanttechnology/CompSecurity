// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;


// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            SortPolicy

public static final class  extends Enum
{

    private static final POPULAR $VALUES[];
    public static final POPULAR ALPHA;
    public static final POPULAR EXPIRING;
    public static final POPULAR NEW;
    public static final POPULAR NONE;
    public static final POPULAR POPULAR;
    public static final POPULAR RECENT;
    public static final POPULAR YEAR;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/xfinity/playerlib/view/browseprograms/SortPolicy$SortType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        YEAR = new <init>("YEAR", 1);
        ALPHA = new <init>("ALPHA", 2);
        NEW = new <init>("NEW", 3);
        RECENT = new <init>("RECENT", 4);
        EXPIRING = new <init>("EXPIRING", 5);
        POPULAR = new <init>("POPULAR", 6);
        $VALUES = (new .VALUES[] {
            NONE, YEAR, ALPHA, NEW, RECENT, EXPIRING, POPULAR
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
