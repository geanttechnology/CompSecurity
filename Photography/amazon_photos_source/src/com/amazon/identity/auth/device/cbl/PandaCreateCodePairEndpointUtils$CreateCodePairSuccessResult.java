// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.cbl;


// Referenced classes of package com.amazon.identity.auth.device.cbl:
//            PandaCreateCodePairEndpointUtils

public static class mExpiresIn
{

    public long mExpiresAt;
    public long mExpiresIn;
    public String mPrivateCode;
    public String mPublicCode;

    (String s, String s1, String s2)
    {
        mPublicCode = s;
        mPrivateCode = s1;
        mExpiresIn = Long.parseLong(s2) * 1000L;
        mExpiresAt = System.currentTimeMillis() + mExpiresIn;
    }
}
