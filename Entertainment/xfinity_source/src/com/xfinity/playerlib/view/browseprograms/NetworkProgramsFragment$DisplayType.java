// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.browseprograms;


// Referenced classes of package com.xfinity.playerlib.view.browseprograms:
//            NetworkProgramsFragment

public static final class  extends Enum
{

    private static final COLLECTION $VALUES[];
    public static final COLLECTION ALL_MOVIES;
    public static final COLLECTION ALL_TV_SERIES;
    public static final COLLECTION COLLECTION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/xfinity/playerlib/view/browseprograms/NetworkProgramsFragment$DisplayType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ALL_MOVIES = new <init>("ALL_MOVIES", 0);
        ALL_TV_SERIES = new <init>("ALL_TV_SERIES", 1);
        COLLECTION = new <init>("COLLECTION", 2);
        $VALUES = (new .VALUES[] {
            ALL_MOVIES, ALL_TV_SERIES, COLLECTION
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
