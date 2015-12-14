// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import bo;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class g extends bo
{

    public g()
    {
    }

    protected final String a()
    {
        return UUID.randomUUID().toString();
    }

    protected final byte[] a(byte abyte0[], byte abyte1[])
    {
        if (abyte0 == null || abyte1 == null)
        {
            return new byte[0];
        }
        try
        {
            abyte0 = new SecretKeySpec(abyte0, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(abyte0);
            abyte0 = mac.doFinal(abyte1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return new byte[0];
        }
        return abyte0;
    }
}
