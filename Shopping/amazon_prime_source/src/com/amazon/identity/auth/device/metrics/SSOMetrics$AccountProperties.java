// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.metrics;


// Referenced classes of package com.amazon.identity.auth.device.metrics:
//            SSOMetrics

public static final class mName extends Enum
{

    private static final General $VALUES[];
    public static final General DeviceEmail;
    public static final General DeviceName;
    public static final General General;
    private final String mName;

    public static mName valueOf(String s)
    {
        return (mName)Enum.valueOf(com/amazon/identity/auth/device/metrics/SSOMetrics$AccountProperties, s);
    }

    public static mName[] values()
    {
        return (mName[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        DeviceName = new <init>("DeviceName", 0, "DeviceName");
        DeviceEmail = new <init>("DeviceEmail", 1, "DeviceEmail");
        General = new <init>("General", 2, "General");
        $VALUES = (new .VALUES[] {
            DeviceName, DeviceEmail, General
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }
}
