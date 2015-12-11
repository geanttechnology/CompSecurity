// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;


public final class TrackStyle extends Enum
{

    private static final TrackStyle $VALUES[];
    public static final TrackStyle V2;
    public static final TrackStyle V2_1;
    public static final TrackStyle V3;
    private final String style;

    private TrackStyle(String s, int i, String s1)
    {
        super(s, i);
        style = s1;
    }

    public static TrackStyle from(String s)
    {
        TrackStyle atrackstyle[] = values();
        int j = atrackstyle.length;
        for (int i = 0; i < j; i++)
        {
            TrackStyle trackstyle = atrackstyle[i];
            if (trackstyle.style.equals(s))
            {
                return trackstyle;
            }
        }

        return getDefaultStyle();
    }

    public static TrackStyle getDefaultStyle()
    {
        return V3;
    }

    public static TrackStyle valueOf(String s)
    {
        return (TrackStyle)Enum.valueOf(com/shazam/model/TrackStyle, s);
    }

    public static TrackStyle[] values()
    {
        return (TrackStyle[])$VALUES.clone();
    }

    public final String getStyle()
    {
        return style;
    }

    static 
    {
        V2 = new TrackStyle("V2", 0, "v2");
        V2_1 = new TrackStyle("V2_1", 1, "v2.1");
        V3 = new TrackStyle("V3", 2, "v3");
        $VALUES = (new TrackStyle[] {
            V2, V2_1, V3
        });
    }
}
