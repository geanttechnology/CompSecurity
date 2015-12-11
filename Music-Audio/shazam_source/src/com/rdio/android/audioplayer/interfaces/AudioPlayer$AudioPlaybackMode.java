// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.audioplayer.interfaces;


// Referenced classes of package com.rdio.android.audioplayer.interfaces:
//            AudioPlayer

public static final class  extends Enum
{

    private static final Gapless $VALUES[];
    public static final Gapless Gapless;
    public static final Gapless Normal;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/audioplayer/interfaces/AudioPlayer$AudioPlaybackMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Normal = new <init>("Normal", 0);
        Gapless = new <init>("Gapless", 1);
        $VALUES = (new .VALUES[] {
            Normal, Gapless
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
