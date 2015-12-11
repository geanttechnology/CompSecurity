// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model;


// Referenced classes of package com.xfinity.playerlib.model:
//            MerlinId

public static final class  extends Enum
{

    private static final TvEpisode $VALUES[];
    public static final TvEpisode Movie;
    public static final TvEpisode TvEpisode;
    public static final TvEpisode TvSeries;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/xfinity/playerlib/model/MerlinId$Namespace, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    public String getBundleKey()
    {
        return (new StringBuilder()).append("EXTRA_MERLIN_ID_").append(name()).toString();
    }

    static 
    {
        Movie = new <init>("Movie", 0);
        TvSeries = new <init>("TvSeries", 1);
        TvEpisode = new <init>("TvEpisode", 2);
        $VALUES = (new .VALUES[] {
            Movie, TvSeries, TvEpisode
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
