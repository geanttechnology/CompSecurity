// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;

import com.amazon.device.analytics.configuration.ConfigurationChangedListener;
import java.util.List;

public interface AnalyticsConfiguration
{
    public static final class Setting extends Enum
    {

        private static final Setting $VALUES[];
        public static final Setting AvailabilityLogBatchSize;
        public static final Setting Enabled;
        public static final Setting IgnoreSessionInterval;
        public static final Setting MaturityDelta;
        public static final Setting NeverCollectForPackageNames;
        public static final Setting RunningProcessPollInterval;
        private final Object defaultValue;
        private final String key;

        public static Setting valueOf(String s)
        {
            return (Setting)Enum.valueOf(com/amazon/analytics/AnalyticsConfiguration$Setting, s);
        }

        public static Setting[] values()
        {
            return (Setting[])$VALUES.clone();
        }

        public Object getDefaultValue(Class class1)
        {
            return defaultValue;
        }

        public String getKey()
        {
            return key;
        }

        static 
        {
            Enabled = new Setting("Enabled", 0, "enabled", Boolean.valueOf(false));
            RunningProcessPollInterval = new Setting("RunningProcessPollInterval", 1, "runningProcessPollInterval", Integer.valueOf(5));
            IgnoreSessionInterval = new Setting("IgnoreSessionInterval", 2, "ignoreSessionInterval", Integer.valueOf(10));
            NeverCollectForPackageNames = new Setting("NeverCollectForPackageNames", 3, "neverCollectForPackageNames", "");
            AvailabilityLogBatchSize = new Setting("AvailabilityLogBatchSize", 4, "logBatchSize", Integer.valueOf(0));
            MaturityDelta = new Setting("MaturityDelta", 5, "maturityDelta", Integer.valueOf(3));
            $VALUES = (new Setting[] {
                Enabled, RunningProcessPollInterval, IgnoreSessionInterval, NeverCollectForPackageNames, AvailabilityLogBatchSize, MaturityDelta
            });
        }

        private Setting(String s, int i, String s1, Object obj)
        {
            super(s, i);
            key = s1;
            defaultValue = obj;
        }
    }


    public abstract boolean getBoolean(Setting setting);

    public abstract List getCommaDelimitedStringList(Setting setting);

    public abstract int getInt(Setting setting);

    public abstract void registerChangedListener(String s, ConfigurationChangedListener configurationchangedlistener);
}
