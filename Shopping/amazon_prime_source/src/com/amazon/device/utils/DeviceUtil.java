// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import java.security.SecureRandom;

public interface DeviceUtil
{

    public abstract String fetchCountryOfResidence();

    public abstract String fetchCustomerID();

    public abstract String fetchDeviceLanguage();

    public abstract String fetchDeviceMode();

    public abstract String fetchDeviceSerialNumber();

    public abstract String fetchDeviceSerialNumberOrAnonymous();

    public abstract String fetchDeviceType();

    public abstract String fetchPreferredMarketplace();

    public abstract String fetchRemoteIP();

    public abstract String fetchRsmGroupName();

    public abstract String fetchSessionID();

    public abstract String fetchStaticCredential();

    public abstract String fetchUserAgent();

    public abstract String fetchWANSupportedDeviceMode();

    public abstract String getRandomDigits(int i, SecureRandom securerandom);

    public abstract boolean isDeviceSerialNumberAnonymous();
}
