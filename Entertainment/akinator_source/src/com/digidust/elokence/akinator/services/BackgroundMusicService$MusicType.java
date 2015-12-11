// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.services;


// Referenced classes of package com.digidust.elokence.akinator.services:
//            BackgroundMusicService

public static final class  extends Enum
{

    private static final NO_CHANGE $VALUES[];
    public static final NO_CHANGE FULL_MUSIC;
    public static final NO_CHANGE NO_CHANGE;
    public static final NO_CHANGE SHORT_MUSIC;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/digidust/elokence/akinator/services/BackgroundMusicService$MusicType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FULL_MUSIC = new <init>("FULL_MUSIC", 0);
        SHORT_MUSIC = new <init>("SHORT_MUSIC", 1);
        NO_CHANGE = new <init>("NO_CHANGE", 2);
        $VALUES = (new .VALUES[] {
            FULL_MUSIC, SHORT_MUSIC, NO_CHANGE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
