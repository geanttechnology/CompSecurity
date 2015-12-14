// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.upload;


public interface DeviceAttributeStore
{

    public abstract void clearCachedDeviceInformation();

    public abstract boolean deviceHasWAN();

    public abstract String getCachedDeviceId();

    public abstract String getDefaultDeviceName();

    public abstract String getDeviceName();

    public abstract String getDeviceSerialNumber();

    public abstract String getDeviceType();

    public abstract String getDeviceTypeId();

    public abstract String getUniqueDeviceId();

    public abstract boolean isTablet();

    public abstract void storeDeviceId(String s);
}
