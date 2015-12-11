// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;


// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            PlayerAdBreakPolicies

public static final class  extends Enum
{

    private static final PLAY_FROM_BEGINNING $VALUES[];
    public static final PLAY_FROM_BEGINNING PLAY;
    public static final PLAY_FROM_BEGINNING PLAY_FROM_BEGINNING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakSeekIntoPolicy, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PLAY = new <init>("PLAY", 0);
        PLAY_FROM_BEGINNING = new <init>("PLAY_FROM_BEGINNING", 1);
        $VALUES = (new .VALUES[] {
            PLAY, PLAY_FROM_BEGINNING
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
