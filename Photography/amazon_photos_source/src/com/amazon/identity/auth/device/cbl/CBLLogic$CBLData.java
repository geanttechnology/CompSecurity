// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.cbl;


// Referenced classes of package com.amazon.identity.auth.device.cbl:
//            CBLLogic

public static class mTimeLeft
{

    public final String mPrivateCode;
    public final String mPublicCode;
    public final long mTimeLeft;

    (String s, String s1, long l)
    {
        mPublicCode = s;
        mPrivateCode = s1;
        mTimeLeft = l - System.currentTimeMillis();
    }
}
