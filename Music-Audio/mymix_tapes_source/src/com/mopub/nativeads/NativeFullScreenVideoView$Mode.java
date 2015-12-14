// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            NativeFullScreenVideoView

public static final class  extends Enum
{

    private static final FINISHED $VALUES[];
    public static final FINISHED FINISHED;
    public static final FINISHED LOADING;
    public static final FINISHED PAUSED;
    public static final FINISHED PLAYING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/nativeads/NativeFullScreenVideoView$Mode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOADING = new <init>("LOADING", 0);
        PLAYING = new <init>("PLAYING", 1);
        PAUSED = new <init>("PAUSED", 2);
        FINISHED = new <init>("FINISHED", 3);
        $VALUES = (new .VALUES[] {
            LOADING, PLAYING, PAUSED, FINISHED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
