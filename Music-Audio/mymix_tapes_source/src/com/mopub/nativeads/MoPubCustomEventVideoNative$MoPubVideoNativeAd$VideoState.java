// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;


// Referenced classes of package com.mopub.nativeads:
//            MoPubCustomEventVideoNative

public static final class  extends Enum
{

    private static final FAILED_LOAD $VALUES[];
    public static final FAILED_LOAD BUFFERING;
    public static final FAILED_LOAD CREATED;
    public static final FAILED_LOAD ENDED;
    public static final FAILED_LOAD FAILED_LOAD;
    public static final FAILED_LOAD LOADING;
    public static final FAILED_LOAD PAUSED;
    public static final FAILED_LOAD PLAYING;
    public static final FAILED_LOAD PLAYING_MUTED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/mopub/nativeads/MoPubCustomEventVideoNative$MoPubVideoNativeAd$VideoState, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CREATED = new <init>("CREATED", 0);
        LOADING = new <init>("LOADING", 1);
        BUFFERING = new <init>("BUFFERING", 2);
        PAUSED = new <init>("PAUSED", 3);
        PLAYING = new <init>("PLAYING", 4);
        PLAYING_MUTED = new <init>("PLAYING_MUTED", 5);
        ENDED = new <init>("ENDED", 6);
        FAILED_LOAD = new <init>("FAILED_LOAD", 7);
        $VALUES = (new .VALUES[] {
            CREATED, LOADING, BUFFERING, PAUSED, PLAYING, PLAYING_MUTED, ENDED, FAILED_LOAD
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
