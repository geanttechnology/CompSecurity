// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.analytics;


// Referenced classes of package com.amazon.analytics:
//            AnalyticsConfiguration

public static final class defaultValue extends Enum
{

    private static final MaturityDelta $VALUES[];
    public static final MaturityDelta AvailabilityLogBatchSize;
    public static final MaturityDelta Enabled;
    public static final MaturityDelta IgnoreSessionInterval;
    public static final MaturityDelta MaturityDelta;
    public static final MaturityDelta NeverCollectForPackageNames;
    public static final MaturityDelta RunningProcessPollInterval;
    private final Object defaultValue;
    private final String key;

    public static defaultValue valueOf(String s)
    {
        return (defaultValue)Enum.valueOf(com/amazon/analytics/AnalyticsConfiguration$Setting, s);
    }

    public static defaultValue[] values()
    {
        return (defaultValue[])$VALUES.clone();
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
        Enabled = new <init>("Enabled", 0, "enabled", Boolean.valueOf(false));
        RunningProcessPollInterval = new <init>("RunningProcessPollInterval", 1, "runningProcessPollInterval", Integer.valueOf(5));
        IgnoreSessionInterval = new <init>("IgnoreSessionInterval", 2, "ignoreSessionInterval", Integer.valueOf(10));
        NeverCollectForPackageNames = new <init>("NeverCollectForPackageNames", 3, "neverCollectForPackageNames", "");
        AvailabilityLogBatchSize = new <init>("AvailabilityLogBatchSize", 4, "logBatchSize", Integer.valueOf(0));
        MaturityDelta = new <init>("MaturityDelta", 5, "maturityDelta", Integer.valueOf(3));
        $VALUES = (new .VALUES[] {
            Enabled, RunningProcessPollInterval, IgnoreSessionInterval, NeverCollectForPackageNames, AvailabilityLogBatchSize, MaturityDelta
        });
    }

    private _cls9(String s, int i, String s1, Object obj)
    {
        super(s, i);
        key = s1;
        defaultValue = obj;
    }
}
