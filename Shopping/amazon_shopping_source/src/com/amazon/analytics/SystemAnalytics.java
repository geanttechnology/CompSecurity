// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;


public class SystemAnalytics
{

    public SystemAnalytics()
    {
    }

    public com.amazon.analytics.eventbuilder.AnalyticsBuilderInterfaces.IAPTypeBuilder createIAPEvent()
    {
        return new com.amazon.analytics.eventbuilder.IAPEventTypeBuilder.IAPBuilder();
    }

    public com.amazon.analytics.eventbuilder.AnalyticsBuilderInterfaces.BaseAnalyticsBuilder createInstallEvent()
    {
        return new com.amazon.analytics.eventbuilder.InstallEventTypeBuilder.InstallBuilder();
    }

    public com.amazon.analytics.eventbuilder.AnalyticsBuilderInterfaces.SessionTypeBuilder createOnPauseEvent()
    {
        return new com.amazon.analytics.eventbuilder.SessionEventTypeBuilder.OnPauseBuilder();
    }

    public com.amazon.analytics.eventbuilder.AnalyticsBuilderInterfaces.SessionTypeBuilder createOnResumeEvent()
    {
        return new com.amazon.analytics.eventbuilder.SessionEventTypeBuilder.OnResumeBuilder();
    }

    public com.amazon.analytics.eventbuilder.AnalyticsBuilderInterfaces.BaseAnalyticsBuilder createUninstallEvent()
    {
        return new com.amazon.analytics.eventbuilder.InstallEventTypeBuilder.UninstallBuilder();
    }

    public com.amazon.analytics.eventbuilder.AnalyticsBuilderInterfaces.BaseAnalyticsBuilder createUpgradeEvent()
    {
        return new com.amazon.analytics.eventbuilder.InstallEventTypeBuilder.UpgradeBuilder();
    }
}
