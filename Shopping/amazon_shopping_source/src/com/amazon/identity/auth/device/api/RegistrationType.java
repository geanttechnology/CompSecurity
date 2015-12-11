// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.api;


public final class RegistrationType extends Enum
{

    private static final RegistrationType $VALUES[];
    public static final RegistrationType FROM_ACCESS_TOKEN;
    public static final RegistrationType FROM_ATMAIN;
    public static final RegistrationType FROM_AUTH_TOKEN;
    public static final RegistrationType REGISTER_DELEGATED_ACCOUNT;
    public static final RegistrationType WITH_DEVICE_SECRET;
    public static final RegistrationType WITH_DIRECTEDID_CREDENTIALS;
    public static final RegistrationType WITH_EXPLICIT_URL;
    public static final RegistrationType WITH_LOGIN_CREDENTIALS;
    private final String mName;

    private RegistrationType(String s, int i, String s1)
    {
        super(s, i);
        mName = s1;
    }

    public static RegistrationType fromName(String s)
    {
        RegistrationType aregistrationtype[] = values();
        int j = aregistrationtype.length;
        for (int i = 0; i < j; i++)
        {
            RegistrationType registrationtype = aregistrationtype[i];
            if (registrationtype.getName().equals(s))
            {
                return registrationtype;
            }
        }

        return null;
    }

    public static RegistrationType valueOf(String s)
    {
        return (RegistrationType)Enum.valueOf(com/amazon/identity/auth/device/api/RegistrationType, s);
    }

    public static RegistrationType[] values()
    {
        return (RegistrationType[])$VALUES.clone();
    }

    public String getName()
    {
        return mName;
    }

    static 
    {
        WITH_LOGIN_CREDENTIALS = new RegistrationType("WITH_LOGIN_CREDENTIALS", 0, "LoginCredentials");
        WITH_DEVICE_SECRET = new RegistrationType("WITH_DEVICE_SECRET", 1, "DeviceSecret");
        WITH_EXPLICIT_URL = new RegistrationType("WITH_EXPLICIT_URL", 2, "ExplicitUrl");
        FROM_ATMAIN = new RegistrationType("FROM_ATMAIN", 3, "ATMain");
        FROM_AUTH_TOKEN = new RegistrationType("FROM_AUTH_TOKEN", 4, "AuthToken");
        FROM_ACCESS_TOKEN = new RegistrationType("FROM_ACCESS_TOKEN", 5, "AccessToken");
        REGISTER_DELEGATED_ACCOUNT = new RegistrationType("REGISTER_DELEGATED_ACCOUNT", 6, "RegisterDelegatedAccount");
        WITH_DIRECTEDID_CREDENTIALS = new RegistrationType("WITH_DIRECTEDID_CREDENTIALS", 7, "DirectedIdCredentials");
        $VALUES = (new RegistrationType[] {
            WITH_LOGIN_CREDENTIALS, WITH_DEVICE_SECRET, WITH_EXPLICIT_URL, FROM_ATMAIN, FROM_AUTH_TOKEN, FROM_ACCESS_TOKEN, REGISTER_DELEGATED_ACCOUNT, WITH_DIRECTEDID_CREDENTIALS
        });
    }
}
