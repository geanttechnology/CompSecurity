// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;


public final class DeviceInfoParameter extends Enum
{

    private static final DeviceInfoParameter $VALUES[];
    public static final DeviceInfoParameter BUILD_FINGERPRINT;
    public static final DeviceInfoParameter BUILD_PRODUCT;
    public static final DeviceInfoParameter CARRIER;
    public static final DeviceInfoParameter DEVICE_DENSITY_CLASSIFICATION;
    public static final DeviceInfoParameter DEVICE_DESCRIPTOR_ID;
    public static final DeviceInfoParameter DEVICE_SCREEN_LAYOUT;
    public static final DeviceInfoParameter DEVICE_TYPE;
    public static final DeviceInfoParameter MANUFACTURER;
    public static final DeviceInfoParameter MODEL;
    public static final DeviceInfoParameter OS_VERSION;
    public static final DeviceInfoParameter PHONE_TYPE;
    public static final DeviceInfoParameter REF;
    public static final DeviceInfoParameter SERIAL;
    public static final DeviceInfoParameter SIM_OPERATOR;
    private final String name;

    private DeviceInfoParameter(String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }

    public static DeviceInfoParameter valueOf(String s)
    {
        return (DeviceInfoParameter)Enum.valueOf(com/amazon/searchapp/retailsearch/client/DeviceInfoParameter, s);
    }

    public static DeviceInfoParameter[] values()
    {
        return (DeviceInfoParameter[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        CARRIER = new DeviceInfoParameter("CARRIER", 0, "carrier");
        MANUFACTURER = new DeviceInfoParameter("MANUFACTURER", 1, "manufacturer");
        MODEL = new DeviceInfoParameter("MODEL", 2, "model");
        DEVICE_TYPE = new DeviceInfoParameter("DEVICE_TYPE", 3, "deviceType");
        DEVICE_DESCRIPTOR_ID = new DeviceInfoParameter("DEVICE_DESCRIPTOR_ID", 4, "deviceDescriptorId");
        OS_VERSION = new DeviceInfoParameter("OS_VERSION", 5, "osVersion");
        REF = new DeviceInfoParameter("REF", 6, "deviceRef");
        DEVICE_DENSITY_CLASSIFICATION = new DeviceInfoParameter("DEVICE_DENSITY_CLASSIFICATION", 7, "deviceDensityClassification");
        DEVICE_SCREEN_LAYOUT = new DeviceInfoParameter("DEVICE_SCREEN_LAYOUT", 8, "deviceScreenLayout");
        SERIAL = new DeviceInfoParameter("SERIAL", 9, "serial");
        BUILD_PRODUCT = new DeviceInfoParameter("BUILD_PRODUCT", 10, "buildProduct");
        BUILD_FINGERPRINT = new DeviceInfoParameter("BUILD_FINGERPRINT", 11, "buildFingerprint");
        SIM_OPERATOR = new DeviceInfoParameter("SIM_OPERATOR", 12, "simOperator");
        PHONE_TYPE = new DeviceInfoParameter("PHONE_TYPE", 13, "phoneType");
        $VALUES = (new DeviceInfoParameter[] {
            CARRIER, MANUFACTURER, MODEL, DEVICE_TYPE, DEVICE_DESCRIPTOR_ID, OS_VERSION, REF, DEVICE_DENSITY_CLASSIFICATION, DEVICE_SCREEN_LAYOUT, SERIAL, 
            BUILD_PRODUCT, BUILD_FINGERPRINT, SIM_OPERATOR, PHONE_TYPE
        });
    }
}
