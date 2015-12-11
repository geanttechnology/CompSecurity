// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.data;


// Referenced classes of package com.gotv.crackle.data:
//            DetailsProvider

public static final class  extends Enum
{

    private static final Watchlist $VALUES[];
    public static final Watchlist Episode;
    public static final Watchlist Movie;
    public static final Watchlist Pending;
    public static final Watchlist Show;
    public static final Watchlist Watchlist;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/gotv/crackle/data/DetailsProvider$DetailsType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Pending = new <init>("Pending", 0);
        Movie = new <init>("Movie", 1);
        Show = new <init>("Show", 2);
        Episode = new <init>("Episode", 3);
        Watchlist = new <init>("Watchlist", 4);
        $VALUES = (new .VALUES[] {
            Pending, Movie, Show, Episode, Watchlist
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
