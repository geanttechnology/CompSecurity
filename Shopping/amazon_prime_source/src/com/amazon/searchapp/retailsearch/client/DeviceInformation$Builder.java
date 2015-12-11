// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;


// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            DeviceInformation

public static class Type
{

    private String buildFingerprint;
    private String buildProduct;
    private String carrier;
    private String deviceDensityClassification;
    private String deviceDescriptorId;
    private String deviceScreenLayout;
    private String deviceType;
    private String manufacturer;
    private String model;
    private String osVersion;
    private String phoneType;
    private String ref;
    private String serial;
    private String simOperator;

    public DeviceInformation build()
    {
        return new DeviceInformation(carrier, manufacturer, model, deviceType, deviceDescriptorId, osVersion, ref, deviceDensityClassification, deviceScreenLayout, serial, buildProduct, buildFingerprint, simOperator, phoneType);
    }

    public String getBuildFingerprint()
    {
        return buildFingerprint;
    }

    public String getBuildProduct()
    {
        return buildProduct;
    }

    public String getCarrier()
    {
        return carrier;
    }

    public String getDeviceDensityClassification()
    {
        return deviceDensityClassification;
    }

    public String getDeviceDescriptorId()
    {
        return deviceDescriptorId;
    }

    public String getDeviceScreenLayout()
    {
        return deviceScreenLayout;
    }

    public String getDeviceType()
    {
        return deviceType;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public String getModel()
    {
        return model;
    }

    public String getOsVersion()
    {
        return osVersion;
    }

    public String getPhoneType()
    {
        return phoneType;
    }

    public String getRef()
    {
        return ref;
    }

    public String getSerial()
    {
        return serial;
    }

    public String getSimOperator()
    {
        return simOperator;
    }

    public simOperator setBuildFingerprint(String s)
    {
        buildFingerprint = s;
        return this;
    }

    public buildFingerprint setBuildProduct(String s)
    {
        buildProduct = s;
        return this;
    }

    public buildProduct setCarrier(String s)
    {
        carrier = s;
        return this;
    }

    public carrier setDeviceDensityClassification(String s)
    {
        deviceDensityClassification = s;
        return this;
    }

    public deviceDensityClassification setDeviceDescriptorId(String s)
    {
        deviceDescriptorId = s;
        return this;
    }

    public deviceDescriptorId setDeviceScreenLayout(String s)
    {
        deviceScreenLayout = s;
        return this;
    }

    public deviceScreenLayout setDeviceType(String s)
    {
        deviceType = s;
        return this;
    }

    public deviceType setManufacturer(String s)
    {
        manufacturer = s;
        return this;
    }

    public manufacturer setModel(String s)
    {
        model = s;
        return this;
    }

    public model setOsVersion(String s)
    {
        osVersion = s;
        return this;
    }

    public osVersion setPhoneType(String s)
    {
        phoneType = s;
        return this;
    }

    public phoneType setRef(String s)
    {
        ref = s;
        return this;
    }

    public ref setSerial(String s)
    {
        serial = s;
        return this;
    }

    public serial setSimOperator(String s)
    {
        simOperator = s;
        return this;
    }

    public ()
    {
    }

    public (DeviceInformation deviceinformation)
    {
        carrier = deviceinformation.getCarrier();
        manufacturer = deviceinformation.getManufacturer();
        model = deviceinformation.getModel();
        deviceType = deviceinformation.getDeviceType();
        deviceDescriptorId = deviceinformation.getDeviceDescriptorId();
        osVersion = deviceinformation.getOsVersion();
        ref = deviceinformation.getRef();
        deviceDensityClassification = deviceinformation.getDeviceDensityClassification();
        deviceScreenLayout = deviceinformation.getDeviceScreenLayout();
        serial = deviceinformation.getSerial();
        buildProduct = deviceinformation.getBuildProduct();
        buildFingerprint = deviceinformation.getBuildFingerprint();
        simOperator = deviceinformation.getSimOperator();
        phoneType = deviceinformation.getPhoneType();
    }
}
