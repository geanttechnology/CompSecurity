// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;


public final class AuthenticationType extends Enum
{

    private static final AuthenticationType $VALUES[];
    public static final AuthenticationType ADPAuthenticator;
    public static final AuthenticationType DeviceAuthenticator;
    public static final AuthenticationType None;
    public static final AuthenticationType OAuth;
    private final boolean mRequireHttps;
    private final String mValue;

    private AuthenticationType(String s, int i, String s1, boolean flag)
    {
        super(s, i);
        mValue = s1;
        mRequireHttps = flag;
    }

    public static AuthenticationType parse(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        AuthenticationType authenticationtype = null;
_L4:
        return authenticationtype;
_L2:
        AuthenticationType aauthenticationtype[] = values();
        int j = aauthenticationtype.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                AuthenticationType authenticationtype1 = aauthenticationtype[i];
                authenticationtype = authenticationtype1;
                if (s.equals(authenticationtype1.getValue()))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return null;
    }

    public static AuthenticationType valueOf(String s)
    {
        return (AuthenticationType)Enum.valueOf(com/amazon/identity/auth/device/api/AuthenticationType, s);
    }

    public static AuthenticationType[] values()
    {
        return (AuthenticationType[])$VALUES.clone();
    }

    public String getValue()
    {
        return mValue;
    }

    public boolean requireHttps()
    {
        return mRequireHttps;
    }

    static 
    {
        None = new AuthenticationType("None", 0, "None", false);
        DeviceAuthenticator = new AuthenticationType("DeviceAuthenticator", 1, "DeviceAuthenticator", false);
        ADPAuthenticator = new AuthenticationType("ADPAuthenticator", 2, "ADPAuthenticator", false);
        OAuth = new AuthenticationType("OAuth", 3, "OAuth", true);
        $VALUES = (new AuthenticationType[] {
            None, DeviceAuthenticator, ADPAuthenticator, OAuth
        });
    }
}
