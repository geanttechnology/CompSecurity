// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptimize;


public class ApptimizeOptions
{

    private boolean developerModeDisabled;
    private String deviceName;
    private boolean explicitEnablingRequired;
    private LogLevel logLevel;
    private boolean multiprocessMode;
    private Long updateMetaDataTimeout;

    public ApptimizeOptions()
    {
        updateMetaDataTimeout = null;
        developerModeDisabled = false;
        deviceName = null;
        explicitEnablingRequired = false;
        logLevel = LogLevel.VERBOSE;
        multiprocessMode = false;
    }

    public String getDeviceName()
    {
        return deviceName;
    }

    public LogLevel getLogLevel()
    {
        return logLevel;
    }

    public Long getUpdateMetaDataTimeout()
    {
        return updateMetaDataTimeout;
    }

    public boolean isDeveloperModeDisabled()
    {
        return developerModeDisabled;
    }

    public boolean isExplicitEnablingRequired()
    {
        return explicitEnablingRequired;
    }

    public boolean isMultiprocessModeEnabled()
    {
        return multiprocessMode;
    }

    public ApptimizeOptions setDeveloperModeDisabled(boolean flag)
    {
        developerModeDisabled = flag;
        return this;
    }

    public ApptimizeOptions setDeviceName(String s)
    {
        deviceName = s;
        return this;
    }

    public ApptimizeOptions setExplicitEnablingRequired(boolean flag)
    {
        explicitEnablingRequired = flag;
        return this;
    }

    public ApptimizeOptions setLogLevel(LogLevel loglevel)
    {
        logLevel = loglevel;
        return this;
    }

    public ApptimizeOptions setMultiprocessMode(boolean flag)
    {
        multiprocessMode = flag;
        return this;
    }

    public ApptimizeOptions setUpdateMetadataTimeout(long l)
    {
        updateMetaDataTimeout = Long.valueOf(l);
        return this;
    }

    /* member class not found */
    class LogLevel {}

}
