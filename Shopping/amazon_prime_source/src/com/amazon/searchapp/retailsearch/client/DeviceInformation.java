// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;


public class DeviceInformation
{
    public static class Builder
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

        public Builder setBuildFingerprint(String s)
        {
            buildFingerprint = s;
            return this;
        }

        public Builder setBuildProduct(String s)
        {
            buildProduct = s;
            return this;
        }

        public Builder setCarrier(String s)
        {
            carrier = s;
            return this;
        }

        public Builder setDeviceDensityClassification(String s)
        {
            deviceDensityClassification = s;
            return this;
        }

        public Builder setDeviceDescriptorId(String s)
        {
            deviceDescriptorId = s;
            return this;
        }

        public Builder setDeviceScreenLayout(String s)
        {
            deviceScreenLayout = s;
            return this;
        }

        public Builder setDeviceType(String s)
        {
            deviceType = s;
            return this;
        }

        public Builder setManufacturer(String s)
        {
            manufacturer = s;
            return this;
        }

        public Builder setModel(String s)
        {
            model = s;
            return this;
        }

        public Builder setOsVersion(String s)
        {
            osVersion = s;
            return this;
        }

        public Builder setPhoneType(String s)
        {
            phoneType = s;
            return this;
        }

        public Builder setRef(String s)
        {
            ref = s;
            return this;
        }

        public Builder setSerial(String s)
        {
            serial = s;
            return this;
        }

        public Builder setSimOperator(String s)
        {
            simOperator = s;
            return this;
        }

        public Builder()
        {
        }

        public Builder(DeviceInformation deviceinformation)
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


    private final String buildFingerprint;
    private final String buildProduct;
    private final String carrier;
    private final String deviceDensityClassification;
    private final String deviceDescriptorId;
    private final String deviceScreenLayout;
    private final String deviceType;
    private final String manufacturer;
    private final String model;
    private final String osVersion;
    private final String phoneType;
    private final String ref;
    private final String serial;
    private final String simOperator;

    public DeviceInformation(String s, String s1, String s2, String s3, String s4, String s5, String s6, 
            String s7, String s8, String s9, String s10, String s11, String s12, String s13)
    {
        carrier = s;
        manufacturer = s1;
        model = s2;
        deviceType = s3;
        deviceDescriptorId = s4;
        osVersion = s5;
        ref = s6;
        deviceDensityClassification = s7;
        deviceScreenLayout = s8;
        serial = s9;
        buildProduct = s10;
        buildFingerprint = s11;
        simOperator = s12;
        phoneType = s13;
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
}
