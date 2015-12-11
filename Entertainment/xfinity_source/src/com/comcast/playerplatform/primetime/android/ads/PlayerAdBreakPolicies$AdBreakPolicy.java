// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;


// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            PlayerAdBreakPolicies

public static final class  extends Enum
{

    private static final REMOVE_BEFORE_PLAYBACK $VALUES[];
    public static final REMOVE_BEFORE_PLAYBACK KEEP;
    public static final REMOVE_BEFORE_PLAYBACK REMOVE;
    public static final REMOVE_BEFORE_PLAYBACK REMOVE_BEFORE_PLAYBACK;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/PlayerAdBreakPolicies$AdBreakPolicy, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        KEEP = new <init>("KEEP", 0);
        REMOVE = new <init>("REMOVE", 1);
        REMOVE_BEFORE_PLAYBACK = new <init>("REMOVE_BEFORE_PLAYBACK", 2);
        $VALUES = (new .VALUES[] {
            KEEP, REMOVE, REMOVE_BEFORE_PLAYBACK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
