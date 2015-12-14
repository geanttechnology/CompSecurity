// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            NativeVideoViewController

static final class  extends Enum
{

    private static final FAILED_LOAD $VALUES[];
    public static final FAILED_LOAD BUFFERING;
    public static final FAILED_LOAD ENDED;
    public static final FAILED_LOAD FAILED_LOAD;
    public static final FAILED_LOAD LOADING;
    public static final FAILED_LOAD NONE;
    public static final FAILED_LOAD PAUSED;
    public static final FAILED_LOAD PLAYING;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/nativeads/NativeVideoViewController$VideoState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        LOADING = new <init>("LOADING", 1);
        BUFFERING = new <init>("BUFFERING", 2);
        PAUSED = new <init>("PAUSED", 3);
        PLAYING = new <init>("PLAYING", 4);
        ENDED = new <init>("ENDED", 5);
        FAILED_LOAD = new <init>("FAILED_LOAD", 6);
        $VALUES = (new .VALUES[] {
            NONE, LOADING, BUFFERING, PAUSED, PLAYING, ENDED, FAILED_LOAD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
