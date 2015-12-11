// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.primetime.android.ads;

import com.comcast.playerplatform.util.android.StringUtil;

public class AdRestriction
{
    public static final class RestrictionType extends Enum
    {

        private static final RestrictionType $VALUES[];
        public static final RestrictionType NONE;
        public static final RestrictionType PAUSE;
        public static final RestrictionType SEEK;

        public static RestrictionType valueOf(String s)
        {
            return (RestrictionType)Enum.valueOf(com/comcast/playerplatform/primetime/android/ads/AdRestriction$RestrictionType, s);
        }

        public static RestrictionType[] values()
        {
            return (RestrictionType[])$VALUES.clone();
        }

        static 
        {
            PAUSE = new RestrictionType("PAUSE", 0);
            SEEK = new RestrictionType("SEEK", 1);
            NONE = new RestrictionType("NONE", 2);
            $VALUES = (new RestrictionType[] {
                PAUSE, SEEK, NONE
            });
        }

        private RestrictionType(String s, int i)
        {
            super(s, i);
        }
    }


    private String id;
    private boolean isRestricted;
    private RestrictionType type;

    public AdRestriction(String s, String s1, String s2)
    {
        id = s;
        if (s1.toLowerCase().equals("pause"))
        {
            type = RestrictionType.PAUSE;
            isRestricted = true;
        } else
        if (s1.toLowerCase().equals("fastforward"))
        {
            type = RestrictionType.SEEK;
            isRestricted = true;
        } else
        {
            type = RestrictionType.NONE;
        }
        if (StringUtil.isNotNullOrEmpty(s2) && s2.toLowerCase().equals("always"))
        {
            isRestricted = true;
        }
    }

    public String getId()
    {
        return id;
    }

    public RestrictionType getType()
    {
        return type;
    }

    public boolean isRestricted()
    {
        return isRestricted;
    }
}
