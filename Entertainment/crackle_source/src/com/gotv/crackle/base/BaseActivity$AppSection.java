// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.base;


// Referenced classes of package com.gotv.crackle.base:
//            BaseActivity

public static final class  extends Enum
{

    private static final WATCHLISTS $VALUES[];
    public static final WATCHLISTS HOME;
    public static final WATCHLISTS MOVIES;
    public static final WATCHLISTS SHOWS;
    public static final WATCHLISTS WATCHLISTS;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/gotv/crackle/base/BaseActivity$AppSection, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HOME = new <init>("HOME", 0);
        MOVIES = new <init>("MOVIES", 1);
        SHOWS = new <init>("SHOWS", 2);
        WATCHLISTS = new <init>("WATCHLISTS", 3);
        $VALUES = (new .VALUES[] {
            HOME, MOVIES, SHOWS, WATCHLISTS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
