// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags;


// Referenced classes of package com.xfinity.playerlib.model.tags:
//            FeaturedShow

public static final class  extends Enum
{

    private static final TvSeries $VALUES[];
    public static final TvSeries Movie;
    public static final TvSeries TvSeries;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/xfinity/playerlib/model/tags/FeaturedShow$EntityType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Movie = new <init>("Movie", 0);
        TvSeries = new <init>("TvSeries", 1);
        $VALUES = (new .VALUES[] {
            Movie, TvSeries
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
