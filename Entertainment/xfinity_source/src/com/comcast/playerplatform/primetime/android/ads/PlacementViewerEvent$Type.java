// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;


// Referenced classes of package com.comcast.playerplatform.primetime.android.ads:
//            PlacementViewerEvent

public static final class  extends Enum
{

    private static final STOP $VALUES[];
    public static final STOP FAST_FARWARD;
    public static final STOP PAUSE;
    public static final STOP PLAY;
    public static final STOP REWIND;
    public static final STOP STOP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/PlacementViewerEvent$Type, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FAST_FARWARD = new <init>("FAST_FARWARD", 0);
        PAUSE = new <init>("PAUSE", 1);
        PLAY = new <init>("PLAY", 2);
        REWIND = new <init>("REWIND", 3);
        STOP = new <init>("STOP", 4);
        $VALUES = (new .VALUES[] {
            FAST_FARWARD, PAUSE, PLAY, REWIND, STOP
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
