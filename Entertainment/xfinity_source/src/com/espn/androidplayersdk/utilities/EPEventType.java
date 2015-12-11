// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.espn.androidplayersdk.utilities;


public final class EPEventType extends Enum
{

    private static final EPEventType ENUM$VALUES[];
    public static final EPEventType LIVE;
    public static final EPEventType REPLAY;
    public static final EPEventType STREAM;
    public static final EPEventType UPCOMING;
    private String event;

    private EPEventType(String s, int i, String s1)
    {
        super(s, i);
        event = s1;
    }

    public static EPEventType valueOf(String s)
    {
        return (EPEventType)Enum.valueOf(com/espn/androidplayersdk/utilities/EPEventType, s);
    }

    public static EPEventType[] values()
    {
        EPEventType aepeventtype[] = ENUM$VALUES;
        int i = aepeventtype.length;
        EPEventType aepeventtype1[] = new EPEventType[i];
        System.arraycopy(aepeventtype, 0, aepeventtype1, 0, i);
        return aepeventtype1;
    }

    public String getEventStr()
    {
        return event;
    }

    static 
    {
        LIVE = new EPEventType("LIVE", 0, "live");
        REPLAY = new EPEventType("REPLAY", 1, "replay");
        UPCOMING = new EPEventType("UPCOMING", 2, "upcoming");
        STREAM = new EPEventType("STREAM", 3, "stream");
        ENUM$VALUES = (new EPEventType[] {
            LIVE, REPLAY, UPCOMING, STREAM
        });
    }
}
