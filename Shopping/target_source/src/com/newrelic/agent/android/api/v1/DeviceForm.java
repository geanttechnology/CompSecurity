// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.api.v1;


public final class DeviceForm extends Enum
{

    private static final DeviceForm $VALUES[];
    public static final DeviceForm LARGE;
    public static final DeviceForm NORMAL;
    public static final DeviceForm SMALL;
    public static final DeviceForm UNKNOWN;
    public static final DeviceForm XLARGE;

    private DeviceForm(String s, int i)
    {
        super(s, i);
    }

    public static DeviceForm valueOf(String s)
    {
        return (DeviceForm)Enum.valueOf(com/newrelic/agent/android/api/v1/DeviceForm, s);
    }

    public static DeviceForm[] values()
    {
        return (DeviceForm[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new DeviceForm("UNKNOWN", 0);
        SMALL = new DeviceForm("SMALL", 1);
        NORMAL = new DeviceForm("NORMAL", 2);
        LARGE = new DeviceForm("LARGE", 3);
        XLARGE = new DeviceForm("XLARGE", 4);
        $VALUES = (new DeviceForm[] {
            UNKNOWN, SMALL, NORMAL, LARGE, XLARGE
        });
    }
}
