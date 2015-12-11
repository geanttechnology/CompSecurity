// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.attributes;

import com.amazon.identity.auth.device.utils.KeyInfo;

public final class CustomerAttributeStoreKeyUtils
{

    public static boolean isCorPfm(KeyInfo keyinfo)
    {
        keyinfo = keyinfo.getKey();
        return "COR".equals(keyinfo) || "PFM".equals(keyinfo);
    }

    public static boolean isCustomerProfileAttributeKey(KeyInfo keyinfo)
    {
        return "com.amazon.dcp.sso.property.deviceemail".equals(keyinfo.getKey()) || "com.amazon.dcp.sso.property.devicename".equals(keyinfo.getKey()) || "com.amazon.dcp.sso.property.username".equals(keyinfo.getKey()) || "com.amazon.dcp.sso.token.devicedevicetype".equals(keyinfo.getKey()) || "com.amazon.dcp.sso.token.device.deviceserialname".equals(keyinfo.getKey()) || "com.amazon.dcp.sso.token.device.accountpool".equals(keyinfo.getKey()) || "com.amazon.dcp.sso.property.account.UUID".equals(keyinfo.getKey()) || "com.amazon.dcp.sso.property.secondary".equals(keyinfo.getKey()) || keyinfo.getKey().startsWith("com.amazon.dcp.sso.property.account.extratokens");
    }

    public static boolean isXFSNCookie(KeyInfo keyinfo)
    {
        return "com.amazon.identity.cookies.xfsn".equals(keyinfo.getKey());
    }

    public static boolean isXMainAndXACBCookies(KeyInfo keyinfo)
    {
        return "com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies".equals(keyinfo.getKey());
    }
}
