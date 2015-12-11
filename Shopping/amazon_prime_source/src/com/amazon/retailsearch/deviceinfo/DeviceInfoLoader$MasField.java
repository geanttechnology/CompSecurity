// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.deviceinfo;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.retailsearch.deviceinfo:
//            DeviceInfoLoader

private static final class name extends Enum
{

    private static final names $VALUES[];
    public static final names BuildFingerprint;
    public static final names BuildProduct;
    public static final names Carrier;
    public static final names DeviceDensityClassification;
    public static final names DeviceDescriptorId;
    public static final names DeviceInfo;
    public static final names DeviceScrenLayout;
    public static final names DeviceType;
    public static final names Manufacturer;
    public static final names Model;
    public static final names OsVersion;
    public static final names PhoneType;
    public static final names Ref;
    public static final names SearchContext;
    public static final names Serial;
    public static final names SimOperator;
    private static final Map names;
    private final String name;

    public static name find(String s)
    {
        return (name)names.get(s);
    }

    public static names valueOf(String s)
    {
        return (names)Enum.valueOf(com/amazon/retailsearch/deviceinfo/DeviceInfoLoader$MasField, s);
    }

    public static names[] values()
    {
        return (names[])$VALUES.clone();
    }

    public String getName()
    {
        return name;
    }

    static 
    {
        Carrier = new <init>("Carrier", 0, "carrier");
        Manufacturer = new <init>("Manufacturer", 1, "manufacturer");
        Model = new <init>("Model", 2, "model");
        DeviceType = new <init>("DeviceType", 3, "deviceType");
        DeviceDescriptorId = new <init>("DeviceDescriptorId", 4, "deviceDescriptorId");
        OsVersion = new <init>("OsVersion", 5, "osVersion");
        Ref = new <init>("Ref", 6, "ref");
        DeviceDensityClassification = new <init>("DeviceDensityClassification", 7, "deviceDensityClassification");
        DeviceScrenLayout = new <init>("DeviceScrenLayout", 8, "deviceScreenLayout");
        Serial = new <init>("Serial", 9, "serial");
        BuildProduct = new <init>("BuildProduct", 10, "build_product");
        BuildFingerprint = new <init>("BuildFingerprint", 11, "build_fingerprint");
        SimOperator = new <init>("SimOperator", 12, "simOperator");
        PhoneType = new <init>("PhoneType", 13, "phoneType");
        SearchContext = new <init>("SearchContext", 14, "searchContext");
        DeviceInfo = new <init>("DeviceInfo", 15, "deviceInfo");
        $VALUES = (new .VALUES[] {
            Carrier, Manufacturer, Model, DeviceType, DeviceDescriptorId, OsVersion, Ref, DeviceDensityClassification, DeviceScrenLayout, Serial, 
            BuildProduct, BuildFingerprint, SimOperator, PhoneType, SearchContext, DeviceInfo
        });
        HashMap hashmap = new HashMap(values().length);
        name aname[] = values();
        int j = aname.length;
        for (int i = 0; i < j; i++)
        {
            name name1 = aname[i];
            hashmap.put(name1.getName(), name1);
        }

        names = Collections.unmodifiableMap(hashmap);
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        name = s1;
    }
}
