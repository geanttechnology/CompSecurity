// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;


// Referenced classes of package com.amazon.identity.kcpsdk.auth:
//            BatchCredentialsParser

private static final class mRefDeviceType
{

    private final String mCredType;
    private final String mDeviceType;
    private final String mRefDeviceType;

    public String getCredentialType()
    {
        return mCredType;
    }

    public String getDeviceType()
    {
        return mDeviceType;
    }

    public String getReferenceDeviceType()
    {
        return mRefDeviceType;
    }

    public (String s, String s1, String s2)
    {
        mDeviceType = s;
        mCredType = s1;
        mRefDeviceType = s2;
    }
}
