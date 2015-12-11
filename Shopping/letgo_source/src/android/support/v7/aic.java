// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package android.support.v7:
//            aia, ajt

public class aic
    implements aia
{

    public aic()
    {
    }

    private byte[] a(byte abyte0[])
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(abyte0);
            abyte0 = messagedigest.digest();
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            ajt.a(abyte0);
            return null;
        }
        return abyte0;
    }

    public String a(String s)
    {
        return (new BigInteger(a(s.getBytes()))).abs().toString(36);
    }
}
