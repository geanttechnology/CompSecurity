// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;

import com.shazam.model.advert.HardCodedAdvertSiteIdKeys;

public final class TrackLayoutType extends Enum
{

    private static final TrackLayoutType $VALUES[];
    public static final TrackLayoutType LOCAL_WEB;
    public static final TrackLayoutType MUSIC;
    public static final TrackLayoutType PROMO;
    public static final TrackLayoutType TOP_WEB;
    public static final TrackLayoutType VIDEO;
    private final int databaseID;
    private final HardCodedAdvertSiteIdKeys siteIdKey;
    private final String typeLabel;

    private TrackLayoutType(String s, int i, int j, String s1, HardCodedAdvertSiteIdKeys hardcodedadvertsiteidkeys)
    {
        super(s, i);
        typeLabel = s1;
        databaseID = j;
        siteIdKey = hardcodedadvertsiteidkeys;
    }

    public static TrackLayoutType getByDatabaseId(int i)
    {
        return getByDatabaseId(Integer.valueOf(i), null);
    }

    public static TrackLayoutType getByDatabaseId(Integer integer, TrackLayoutType tracklayouttype)
    {
        TrackLayoutType tracklayouttype1 = tracklayouttype;
        if (integer == null) goto _L2; else goto _L1
_L1:
        TrackLayoutType atracklayouttype[];
        int i;
        int j;
        atracklayouttype = values();
        j = atracklayouttype.length;
        i = 0;
_L6:
        tracklayouttype1 = tracklayouttype;
        if (i >= j) goto _L2; else goto _L3
_L3:
        tracklayouttype1 = atracklayouttype[i];
        if (tracklayouttype1.databaseID != integer.intValue()) goto _L4; else goto _L2
_L2:
        return tracklayouttype1;
_L4:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static TrackLayoutType getByString(String s)
    {
        return getByString(s, null);
    }

    public static TrackLayoutType getByString(String s, TrackLayoutType tracklayouttype)
    {
        TrackLayoutType atracklayouttype[] = values();
        int j = atracklayouttype.length;
        for (int i = 0; i < j; i++)
        {
            TrackLayoutType tracklayouttype1 = atracklayouttype[i];
            if (tracklayouttype1.typeLabel.equalsIgnoreCase(s))
            {
                tracklayouttype = tracklayouttype1;
            }
        }

        return tracklayouttype;
    }

    public static boolean isValidId(Integer integer)
    {
        return integer != null && getByDatabaseId(integer, null) != null;
    }

    public static TrackLayoutType valueOf(String s)
    {
        return (TrackLayoutType)Enum.valueOf(com/shazam/model/TrackLayoutType, s);
    }

    public static TrackLayoutType[] values()
    {
        return (TrackLayoutType[])$VALUES.clone();
    }

    public final int getDatabaseID()
    {
        return databaseID;
    }

    public final HardCodedAdvertSiteIdKeys getSiteIdKey()
    {
        return siteIdKey;
    }

    public final String getTypeLabel()
    {
        return typeLabel;
    }

    public final boolean hasAdFrameworkBoundAd()
    {
        return hasBannerAd() || this == PROMO;
    }

    public final boolean hasBannerAd()
    {
        return this == MUSIC;
    }

    static 
    {
        MUSIC = new TrackLayoutType("MUSIC", 0, 1, "music", HardCodedAdvertSiteIdKeys.TAG_RESULT);
        PROMO = new TrackLayoutType("PROMO", 1, 2, "promo", HardCodedAdvertSiteIdKeys.PROMO);
        TOP_WEB = new TrackLayoutType("TOP_WEB", 2, 3, "top_web", null);
        VIDEO = new TrackLayoutType("VIDEO", 3, 4, "video", null);
        LOCAL_WEB = new TrackLayoutType("LOCAL_WEB", 4, 5, "local_web", null);
        $VALUES = (new TrackLayoutType[] {
            MUSIC, PROMO, TOP_WEB, VIDEO, LOCAL_WEB
        });
    }
}
