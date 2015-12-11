// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;

import java.util.Locale;

public final class TrackCategory extends Enum
{

    private static final TrackCategory $VALUES[];
    public static final TrackCategory ADVERT;
    public static final TrackCategory CAMPAIGN;
    public static final TrackCategory CONTEXT;
    public static final TrackCategory MUSIC;
    public static final TrackCategory TELEVISION;

    private TrackCategory(String s, int i)
    {
        super(s, i);
    }

    public static TrackCategory fromString(String s)
    {
        if ("television".equals(s))
        {
            return TELEVISION;
        }
        if ("campaign".equals(s))
        {
            return CAMPAIGN;
        }
        if ("music".equals(s))
        {
            return MUSIC;
        }
        if ("advert".equals(s))
        {
            return ADVERT;
        }
        if ("context".equals(s))
        {
            return CONTEXT;
        } else
        {
            return MUSIC;
        }
    }

    public static TrackCategory valueOf(String s)
    {
        return (TrackCategory)Enum.valueOf(com/shazam/model/TrackCategory, s);
    }

    public static TrackCategory[] values()
    {
        return (TrackCategory[])$VALUES.clone();
    }

    public final String toString()
    {
        return name().toLowerCase(Locale.US);
    }

    static 
    {
        TELEVISION = new TrackCategory("TELEVISION", 0);
        CAMPAIGN = new TrackCategory("CAMPAIGN", 1);
        MUSIC = new TrackCategory("MUSIC", 2);
        ADVERT = new TrackCategory("ADVERT", 3);
        CONTEXT = new TrackCategory("CONTEXT", 4);
        $VALUES = (new TrackCategory[] {
            TELEVISION, CAMPAIGN, MUSIC, ADVERT, CONTEXT
        });
    }
}
