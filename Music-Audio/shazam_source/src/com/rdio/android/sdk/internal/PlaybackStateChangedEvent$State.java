// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;


// Referenced classes of package com.rdio.android.sdk.internal:
//            PlaybackStateChangedEvent

public static final class  extends Enum
{

    private static final None $VALUES[];
    public static final None Error;
    public static final None Loading;
    public static final None None;
    public static final None Paused;
    public static final None Playing;
    public static final None Stopped;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/rdio/android/sdk/internal/PlaybackStateChangedEvent$State, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Playing = new <init>("Playing", 0);
        Paused = new <init>("Paused", 1);
        Stopped = new <init>("Stopped", 2);
        Loading = new <init>("Loading", 3);
        Error = new <init>("Error", 4);
        None = new <init>("None", 5);
        $VALUES = (new .VALUES[] {
            Playing, Paused, Stopped, Loading, Error, None
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
