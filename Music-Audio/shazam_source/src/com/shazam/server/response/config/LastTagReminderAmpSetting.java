// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;


public class LastTagReminderAmpSetting
{

    private long delayMs;
    private boolean enabled;
    private int hourOfTheDay;

    private LastTagReminderAmpSetting()
    {
    }

    private LastTagReminderAmpSetting(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        delayMs = Builder.access._mth000(builder);
        hourOfTheDay = Builder.access._mth100(builder);
        enabled = Builder.access._mth200(builder);
    }

    LastTagReminderAmpSetting(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public long getDelayMs()
    {
        return delayMs;
    }

    public int getHourOfTheDay()
    {
        return hourOfTheDay;
    }

    public boolean isEnabled()
    {
        return enabled;
    }
}
