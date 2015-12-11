// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;


public interface DeviceUtil
{

    public abstract String fetchCountryOfResidence();

    public abstract String fetchCustomerID();

    public abstract String fetchDeviceLanguage();

    public abstract String fetchDeviceMode();

    public abstract String fetchDeviceSerialNumberOrAnonymous();

    public abstract String fetchDeviceType();

    public abstract String fetchPreferredMarketplace();

    public abstract String fetchRemoteIP();

    public abstract String fetchRsmGroupName();

    public abstract String fetchSessionID();

    public abstract String fetchStaticCredential();

    public abstract String fetchUserAgent();

    public abstract boolean isDeviceSerialNumberAnonymous();
}
