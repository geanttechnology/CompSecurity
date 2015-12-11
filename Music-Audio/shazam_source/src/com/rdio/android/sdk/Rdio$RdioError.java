// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk;


// Referenced classes of package com.rdio.android.sdk:
//            Rdio

public static final class  extends Enum
{

    private static final PLAYBACK_TOKEN $VALUES[];
    public static final PLAYBACK_TOKEN AUTHORIZATION;
    public static final PLAYBACK_TOKEN CANNOT_STREAM;
    public static final PLAYBACK_TOKEN INITIALIZATION;
    public static final PLAYBACK_TOKEN PLAYBACK_TOKEN;
    public static final PLAYBACK_TOKEN TRACK_LOOKUP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/sdk/Rdio$RdioError, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        AUTHORIZATION = new <init>("AUTHORIZATION", 0);
        INITIALIZATION = new <init>("INITIALIZATION", 1);
        TRACK_LOOKUP = new <init>("TRACK_LOOKUP", 2);
        CANNOT_STREAM = new <init>("CANNOT_STREAM", 3);
        PLAYBACK_TOKEN = new <init>("PLAYBACK_TOKEN", 4);
        $VALUES = (new .VALUES[] {
            AUTHORIZATION, INITIALIZATION, TRACK_LOOKUP, CANNOT_STREAM, PLAYBACK_TOKEN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
