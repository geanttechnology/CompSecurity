// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.utils;

import java.security.SecureRandom;

// Referenced classes of package com.amazon.device.utils:
//            DeviceUtil

public class NullDeviceUtil
    implements DeviceUtil
{

    public NullDeviceUtil()
    {
    }

    public String fetchCountryOfResidence()
    {
        return "";
    }

    public String fetchCustomerID()
    {
        return "";
    }

    public String fetchDeviceLanguage()
    {
        return "";
    }

    public String fetchDeviceMode()
    {
        return null;
    }

    public String fetchDeviceSerialNumber()
    {
        return "";
    }

    public String fetchDeviceSerialNumberOrAnonymous()
    {
        return "";
    }

    public String fetchDeviceType()
    {
        return "";
    }

    public String fetchPreferredMarketplace()
    {
        return "";
    }

    public String fetchRemoteIP()
    {
        return "";
    }

    public String fetchRsmGroupName()
    {
        return "";
    }

    public String fetchSessionID()
    {
        return "";
    }

    public String fetchStaticCredential()
    {
        return "";
    }

    public String fetchUserAgent()
    {
        return "";
    }

    public String fetchWANSupportedDeviceMode()
    {
        return null;
    }

    public String getRandomDigits(int i, SecureRandom securerandom)
    {
        return "";
    }

    public boolean isDeviceSerialNumberAnonymous()
    {
        return false;
    }
}
