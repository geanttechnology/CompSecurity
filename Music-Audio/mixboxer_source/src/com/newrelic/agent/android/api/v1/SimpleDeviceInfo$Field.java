// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.api.v1;


// Referenced classes of package com.newrelic.agent.android.api.v1:
//            SimpleDeviceInfo

private static final class  extends Enum
{

    private static final MISC $VALUES[];
    public static final MISC AGENT_NAME;
    public static final MISC AGENT_VERSION;
    public static final MISC COUNTRY_CODE;
    public static final MISC DEVICE_ID;
    public static final MISC MANUFACTURER;
    public static final MISC MANUFACTURER_MODEL;
    public static final MISC MISC;
    public static final MISC OS_NAME;
    public static final MISC OS_VERSION;
    public static final MISC REGION_CODE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/newrelic/agent/android/api/v1/SimpleDeviceInfo$Field, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        OS_NAME = new <init>("OS_NAME", 0);
        OS_VERSION = new <init>("OS_VERSION", 1);
        MANUFACTURER_MODEL = new <init>("MANUFACTURER_MODEL", 2);
        AGENT_NAME = new <init>("AGENT_NAME", 3);
        AGENT_VERSION = new <init>("AGENT_VERSION", 4);
        DEVICE_ID = new <init>("DEVICE_ID", 5);
        COUNTRY_CODE = new <init>("COUNTRY_CODE", 6);
        REGION_CODE = new <init>("REGION_CODE", 7);
        MANUFACTURER = new <init>("MANUFACTURER", 8);
        MISC = new <init>("MISC", 9);
        $VALUES = (new .VALUES[] {
            OS_NAME, OS_VERSION, MANUFACTURER_MODEL, AGENT_NAME, AGENT_VERSION, DEVICE_ID, COUNTRY_CODE, REGION_CODE, MANUFACTURER, MISC
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
