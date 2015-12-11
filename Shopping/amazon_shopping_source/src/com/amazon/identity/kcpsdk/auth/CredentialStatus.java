// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


public final class CredentialStatus extends Enum
{

    private static final CredentialStatus $VALUES[];
    public static final CredentialStatus CredentialStatusInvalid;
    public static final CredentialStatus CredentialStatusOK;
    public static final CredentialStatus CredentialStatusStale;
    public static final CredentialStatus CredentialStatusUnknownError;
    public static final CredentialStatus CredentialStatusUnknownWarning;
    private final int mValue;

    private CredentialStatus(String s, int i, int j)
    {
        super(s, i);
        mValue = j;
    }

    public static CredentialStatus valueOf(String s)
    {
        return (CredentialStatus)Enum.valueOf(com/amazon/identity/kcpsdk/auth/CredentialStatus, s);
    }

    public static CredentialStatus[] values()
    {
        return (CredentialStatus[])$VALUES.clone();
    }

    public int getValue()
    {
        return mValue;
    }

    static 
    {
        CredentialStatusOK = new CredentialStatus("CredentialStatusOK", 0, 0);
        CredentialStatusStale = new CredentialStatus("CredentialStatusStale", 1, 1);
        CredentialStatusInvalid = new CredentialStatus("CredentialStatusInvalid", 2, 2);
        CredentialStatusUnknownWarning = new CredentialStatus("CredentialStatusUnknownWarning", 3, 3);
        CredentialStatusUnknownError = new CredentialStatus("CredentialStatusUnknownError", 4, 4);
        $VALUES = (new CredentialStatus[] {
            CredentialStatusOK, CredentialStatusStale, CredentialStatusInvalid, CredentialStatusUnknownWarning, CredentialStatusUnknownError
        });
    }
}
