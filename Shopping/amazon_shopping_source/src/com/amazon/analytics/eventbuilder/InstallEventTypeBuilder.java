// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics.eventbuilder;

import com.amazon.device.analytics.events.Event;

// Referenced classes of package com.amazon.analytics.eventbuilder:
//            AnalyticsEventBuilder

public abstract class InstallEventTypeBuilder extends AnalyticsEventBuilder
{
    public static class InstallBuilder extends InstallEventTypeBuilder
    {

        String getType()
        {
            return "install";
        }

        public InstallBuilder()
        {
        }
    }

    public static class UninstallBuilder extends InstallEventTypeBuilder
    {

        String getType()
        {
            return "uninstall";
        }

        public UninstallBuilder()
        {
        }
    }

    public static class UpgradeBuilder extends InstallEventTypeBuilder
    {

        String getType()
        {
            return "upgrade";
        }

        public UpgradeBuilder()
        {
        }
    }


    private InstallEventTypeBuilder()
    {
    }


    void setupEventAttributesAndMetrics(Event event)
    {
        super.setupEventAttributesAndMetrics(event);
    }
}
