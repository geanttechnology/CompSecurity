// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.analytics.configuration;


// Referenced classes of package com.amazon.device.analytics.configuration:
//            ConfigurationChangedListener, ConfigurationRefreshListener

public interface Configuration
{

    public abstract Boolean getBoolean(String s);

    public abstract Integer getInt(String s);

    public abstract String getString(String s);

    public abstract Boolean optBoolean(String s, Boolean boolean1);

    public abstract Integer optInt(String s, Integer integer);

    public abstract String optString(String s, String s1);

    public abstract void refresh();

    public abstract void registerChangedListener(ConfigurationChangedListener configurationchangedlistener);

    public abstract void registerChangedListener(String s, ConfigurationChangedListener configurationchangedlistener);

    public abstract void registerRefreshListener(ConfigurationRefreshListener configurationrefreshlistener);

    public abstract void unregisterChangedListener(ConfigurationChangedListener configurationchangedlistener);

    public abstract void unregisterChangedListener(String s, ConfigurationChangedListener configurationchangedlistener);
}
