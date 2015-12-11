// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.SharedPreferences;
import roboguice.util.Strings;

public class AttributionService
{

    private static final Long TIME_BEFORE_EXPIRING = Long.valueOf(0x9a7ec800L);
    private SharedPreferences prefs;

    public AttributionService()
    {
    }

    private void init()
    {
        Long long1 = Long.valueOf(System.currentTimeMillis());
        if (isCidExpired(long1) && isAnyCidSet())
        {
            prefs.edit().remove("attributionDownloadCid").remove("attributionCid").remove("attributionId").remove("attributionType").remove("attributionDeepLinkTimestamp").apply();
        }
        setAttributionAppLastOpenTimestamp(long1);
    }

    private boolean isAnyCidSet()
    {
        return Strings.notEmpty(getAttributionDownloadCid()) || Strings.notEmpty(getAttributionCid());
    }

    private boolean isCidExpired(Long long1)
    {
        return long1.longValue() - getAttributionAppLastOpenTimestamp().longValue() > TIME_BEFORE_EXPIRING.longValue();
    }

    private boolean isDeepLinkTimestampSet()
    {
        return getAttributionDeepLinkTimestamp().longValue() > 0L;
    }

    public Long getAttributionAppLastOpenTimestamp()
    {
        return Long.valueOf(prefs.getLong("attributionLastAppOpenTimestamp", 0L));
    }

    public String getAttributionCid()
    {
        return prefs.getString("attributionCid", "");
    }

    public Long getAttributionDeepLinkTimestamp()
    {
        return Long.valueOf(prefs.getLong("attributionDeepLinkTimestamp", 0L));
    }

    public String getAttributionDownloadCid()
    {
        return prefs.getString("attributionDownloadCid", "");
    }

    public String getAttributionDownloadId()
    {
        return prefs.getString("attributionDownloadId", "");
    }

    public String getAttributionDownloadUrl()
    {
        return prefs.getString("attributionDownloadUrl", "");
    }

    public String getAttributionId()
    {
        return prefs.getString("attributionId", "");
    }

    public String getAttributionType()
    {
        return prefs.getString("attributionType", "");
    }

    public Long getDeepLinkTimeOverlap(Long long1)
    {
        long l;
        if (isDeepLinkTimestampSet())
        {
            l = long1.longValue() - getAttributionDeepLinkTimestamp().longValue();
        } else
        {
            l = 0L;
        }
        return Long.valueOf(l);
    }

    public void setAttributionAppLastOpenTimestamp(Long long1)
    {
        prefs.edit().putLong("attributionLastAppOpenTimestamp", long1.longValue()).apply();
    }

    public void setDeepLinkingAttribution(String s, String s1, String s2, Long long1)
    {
        long l;
        if (Strings.isEmpty(s) && Strings.isEmpty(s1) && Strings.isEmpty(s2))
        {
            l = 0L;
        } else
        {
            l = long1.longValue();
        }
        long1 = s;
        if (Strings.isEmpty(s))
        {
            long1 = "";
        }
        s = s1;
        if (Strings.isEmpty(s1))
        {
            s = "";
        }
        s1 = s2;
        if (Strings.isEmpty(s2))
        {
            s1 = "";
        }
        prefs.edit().putString("attributionCid", long1).putString("attributionId", s).putString("attributionType", s1).putLong("attributionDeepLinkTimestamp", Long.valueOf(l).longValue()).apply();
    }

    public void setDownloadAttribution(String s, String s1, String s2)
    {
        String s3 = s;
        if (Strings.isEmpty(s))
        {
            s3 = "";
        }
        s = s1;
        if (Strings.isEmpty(s1))
        {
            s = "";
        }
        s1 = s2;
        if (Strings.isEmpty(s2))
        {
            s1 = "";
        }
        prefs.edit().putString("attributionDownloadUrl", s3).putString("attributionDownloadId", s).putString("attributionDownloadCid", s1).apply();
    }

}
