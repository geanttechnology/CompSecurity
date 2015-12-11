// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;


final class StringName extends Enum
{

    private static final StringName $VALUES[];
    public static final StringName AndroidId;
    public static final StringName BuildFingerprint;
    public static final StringName BuildProduct;
    public static final StringName ClientRequestId;
    public static final StringName DeviceModel;
    public static final StringName ExceptionMessage;
    public static final StringName ExceptionName;
    public static final StringName Manufacturer;
    public static final StringName Message;
    public static final StringName NetworkName;
    public static final StringName OsVersion;
    public static final StringName RequestHeaders;
    public static final StringName RequestMethod;
    public static final StringName RequestParameters;
    public static final StringName RequestUrl;
    public static final StringName SerialNumber;
    public static final StringName StackTrace;
    public static final StringName TelephonyDeviceId;

    private StringName(String s, int i)
    {
        super(s, i);
    }

    public static StringName valueOf(String s)
    {
        return (StringName)Enum.valueOf(com/amazon/retailsearch/metrics/StringName, s);
    }

    public static StringName[] values()
    {
        return (StringName[])$VALUES.clone();
    }

    static 
    {
        Message = new StringName("Message", 0);
        ExceptionName = new StringName("ExceptionName", 1);
        ExceptionMessage = new StringName("ExceptionMessage", 2);
        StackTrace = new StringName("StackTrace", 3);
        OsVersion = new StringName("OsVersion", 4);
        DeviceModel = new StringName("DeviceModel", 5);
        Manufacturer = new StringName("Manufacturer", 6);
        BuildProduct = new StringName("BuildProduct", 7);
        BuildFingerprint = new StringName("BuildFingerprint", 8);
        SerialNumber = new StringName("SerialNumber", 9);
        AndroidId = new StringName("AndroidId", 10);
        TelephonyDeviceId = new StringName("TelephonyDeviceId", 11);
        NetworkName = new StringName("NetworkName", 12);
        RequestMethod = new StringName("RequestMethod", 13);
        RequestUrl = new StringName("RequestUrl", 14);
        RequestParameters = new StringName("RequestParameters", 15);
        RequestHeaders = new StringName("RequestHeaders", 16);
        ClientRequestId = new StringName("ClientRequestId", 17);
        $VALUES = (new StringName[] {
            Message, ExceptionName, ExceptionMessage, StackTrace, OsVersion, DeviceModel, Manufacturer, BuildProduct, BuildFingerprint, SerialNumber, 
            AndroidId, TelephonyDeviceId, NetworkName, RequestMethod, RequestUrl, RequestParameters, RequestHeaders, ClientRequestId
        });
    }
}
