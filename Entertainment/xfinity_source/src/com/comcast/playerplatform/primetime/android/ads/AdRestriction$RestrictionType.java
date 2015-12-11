// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;


// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            AdRestriction

public static final class  extends Enum
{

    private static final NONE $VALUES[];
    public static final NONE NONE;
    public static final NONE PAUSE;
    public static final NONE SEEK;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PAUSE = new <init>("PAUSE", 0);
        SEEK = new <init>("SEEK", 1);
        NONE = new <init>("NONE", 2);
        $VALUES = (new .VALUES[] {
            PAUSE, SEEK, NONE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
