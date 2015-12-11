// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreegateway.encryption;

import java.security.SecureRandom;

// Referenced classes of package com.braintreegateway.encryption:
//            PRNGFixes

public final class Random
{

    public Random()
    {
    }

    public static byte[] secureRandomBytes(int i)
    {
        PRNGFixes.apply();
        SecureRandom securerandom = new SecureRandom();
        byte abyte0[] = new byte[i];
        securerandom.nextBytes(abyte0);
        return abyte0;
    }
}
