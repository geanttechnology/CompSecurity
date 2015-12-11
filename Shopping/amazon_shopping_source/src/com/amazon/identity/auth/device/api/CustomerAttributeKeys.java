// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;

import com.amazon.identity.auth.device.storage.StorageKeyUtils;

public final class CustomerAttributeKeys
{

    public static final String KEY_ACCOUNT_POOL = "com.amazon.dcp.sso.token.device.accountpool";
    public static final String KEY_COR = "COR";
    public static final String KEY_DEVICE_EMAIL = "com.amazon.dcp.sso.property.deviceemail";
    public static final String KEY_DEVICE_NAME = "com.amazon.dcp.sso.property.devicename";
    public static final String KEY_DEVICE_TYPE = "com.amazon.dcp.sso.token.devicedevicetype";
    public static final String KEY_DSN = "com.amazon.dcp.sso.token.device.deviceserialname";
    public static final String KEY_EXTRA_TOKENS_KEY_PREFIX = "com.amazon.dcp.sso.property.account.extratokens";
    public static final String KEY_NAME = "com.amazon.dcp.sso.property.username";
    public static final String KEY_PFM = "PFM";
    public static final String KEY_XFSN = "com.amazon.identity.cookies.xfsn";
    public static final String KEY_XMAIN_AND_XACB_COOKIES = "com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies";

    private CustomerAttributeKeys()
    {
    }

    public static String getCustomizedKeyForPackage(String s, String s1)
    {
        return StorageKeyUtils.getKeyWithPackageNamespace(s, (new StringBuilder("com.amazon.dcp.sso.property.account.extratokens.")).append(s1).toString());
    }

    public static String getDeviceEmailKeyForPackage(String s)
    {
        return StorageKeyUtils.getKeyWithPackageNamespace(s, "com.amazon.dcp.sso.property.deviceemail");
    }

    public static String getDeviceNameKeyForPackage(String s)
    {
        return StorageKeyUtils.getKeyWithPackageNamespace(s, "com.amazon.dcp.sso.property.devicename");
    }

    public static String getDeviceTypeKeyForPackage(String s)
    {
        return StorageKeyUtils.getKeyWithPackageNamespace(s, "com.amazon.dcp.sso.token.devicedevicetype");
    }

    public static String getDsnKeyForPackage(String s)
    {
        return StorageKeyUtils.getKeyWithPackageNamespace(s, "com.amazon.dcp.sso.token.device.deviceserialname");
    }

    public static String getUserNameKeyForPackage(String s)
    {
        return StorageKeyUtils.getKeyWithPackageNamespace(s, "com.amazon.dcp.sso.property.username");
    }
}
