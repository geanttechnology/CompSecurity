// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.view;


// Referenced classes of package com.tapjoy.mraid.view:
//            MraidView

public static final class  extends Enum
{

    private static final PLAY_VIDEO $VALUES[];
    public static final PLAY_VIDEO PLAY_AUDIO;
    public static final PLAY_VIDEO PLAY_VIDEO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/tapjoy/mraid/view/MraidView$Action, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PLAY_AUDIO = new <init>("PLAY_AUDIO", 0);
        PLAY_VIDEO = new <init>("PLAY_VIDEO", 1);
        $VALUES = (new .VALUES[] {
            PLAY_AUDIO, PLAY_VIDEO
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
