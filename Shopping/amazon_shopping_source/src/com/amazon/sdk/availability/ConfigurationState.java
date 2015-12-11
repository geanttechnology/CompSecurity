// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.content.Context;

// Referenced classes of package com.amazon.sdk.availability:
//            Preferences, Logger, StringUtil, Configuration

public class ConfigurationState
{

    private Long configurationExpiry;
    private Long configurationNextRefresh;

    public ConfigurationState(Context context)
    {
        Object obj = new Preferences(context);
        context = ((Preferences) (obj)).get("configurationExpiry");
        if (context != null)
        {
            try
            {
                configurationExpiry = Long.valueOf(Long.parseLong(context));
            }
            catch (NumberFormatException numberformatexception1)
            {
                Logger.e((new StringBuilder()).append("error parsing configuration expiry: ").append(context).toString(), numberformatexception1);
            }
        }
        obj = ((Preferences) (obj)).get("configurationNextRefresh");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        configurationNextRefresh = Long.valueOf(Long.parseLong(((String) (obj))));
        return;
        NumberFormatException numberformatexception;
        numberformatexception;
        Logger.e((new StringBuilder()).append("error parsing configuration refresh: ").append(context).toString(), numberformatexception);
        return;
    }

    public Long getConfigurationExpiry()
    {
        return configurationExpiry;
    }

    public Long getConfigurationNextRefresh()
    {
        return configurationNextRefresh;
    }

    public String toString()
    {
        return String.format("{\n\t\"configurationExpiry\" : %s,\n\t\"nextRefresh\" : %s\n}", new Object[] {
            StringUtil.dateToString(getConfigurationExpiry()), StringUtil.dateToString(getConfigurationNextRefresh())
        });
    }

    public ConfigurationState updateSchedule(Context context, Configuration configuration)
    {
        long l = System.currentTimeMillis();
        context = new Preferences(context);
        configurationExpiry = null;
        configurationNextRefresh = null;
        Long long1 = configuration.getStateExpiry();
        if (long1 != null)
        {
            configurationExpiry = Long.valueOf(long1.longValue() + l);
        }
        if (configurationExpiry != null)
        {
            context.put("configurationExpiry", Long.toString(configurationExpiry.longValue()));
        } else
        {
            context.remove("configurationExpiry");
        }
        configuration = configuration.getStateNextRefresh();
        if (configuration != null)
        {
            configurationNextRefresh = Long.valueOf(configuration.longValue() + l);
        }
        if (configuration != null)
        {
            context.put("configurationNextRefresh", Long.toString(configurationNextRefresh.longValue()));
            return this;
        } else
        {
            context.remove("configurationNextRefresh");
            return this;
        }
    }
}
