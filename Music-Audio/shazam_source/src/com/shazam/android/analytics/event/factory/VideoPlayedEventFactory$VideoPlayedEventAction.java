// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event.factory;


// Referenced classes of package com.shazam.android.analytics.event.factory:
//            VideoPlayedEventFactory

public static final class action extends Enum
{

    private static final PAUSE $VALUES[];
    public static final PAUSE PAUSE;
    public static final PAUSE PLAY;
    private final String action;

    public static action valueOf(String s)
    {
        return (action)Enum.valueOf(com/shazam/android/analytics/event/factory/VideoPlayedEventFactory$VideoPlayedEventAction, s);
    }

    public static action[] values()
    {
        return (action[])$VALUES.clone();
    }

    public final String getAction()
    {
        return action;
    }

    static 
    {
        PLAY = new <init>("PLAY", 0, "play");
        PAUSE = new <init>("PAUSE", 1, "pause");
        $VALUES = (new .VALUES[] {
            PLAY, PAUSE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        action = s1;
    }
}
