// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import com.AmazonDevice.Authentication.ITokenAuthProvider;

// Referenced classes of package com.amazon.device.ads:
//            AmazonOODMSUserIdentifier

static final class  extends ITokenAuthProvider
{

    final String val$adpToken;
    final String val$privateKey;

    public String getPrivateKey()
    {
        return val$privateKey;
    }

    public String getToken()
    {
        return val$adpToken;
    }

    (String s, String s1)
    {
        val$adpToken = s;
        val$privateKey = s1;
        super();
    }
}
