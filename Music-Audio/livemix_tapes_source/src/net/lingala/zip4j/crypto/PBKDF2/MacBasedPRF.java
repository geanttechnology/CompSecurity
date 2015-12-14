// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.crypto.PBKDF2;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package net.lingala.zip4j.crypto.PBKDF2:
//            PRF

public class MacBasedPRF
    implements PRF
{

    protected int hLen;
    protected Mac mac;
    protected String macAlgorithm;

    public MacBasedPRF(String s)
    {
        macAlgorithm = s;
        try
        {
            mac = Mac.getInstance(s);
            hLen = mac.getMacLength();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
    }

    public MacBasedPRF(String s, String s1)
    {
        macAlgorithm = s;
        try
        {
            mac = Mac.getInstance(s, s1);
            hLen = mac.getMacLength();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException(s);
        }
    }

    public byte[] doFinal()
    {
        return mac.doFinal();
    }

    public byte[] doFinal(byte abyte0[])
    {
        return mac.doFinal(abyte0);
    }

    public int getHLen()
    {
        return hLen;
    }

    public void init(byte abyte0[])
    {
        try
        {
            mac.init(new SecretKeySpec(abyte0, macAlgorithm));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException(abyte0);
        }
    }

    public void update(byte abyte0[])
    {
        try
        {
            mac.update(abyte0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException(abyte0);
        }
    }

    public void update(byte abyte0[], int i, int j)
    {
        try
        {
            mac.update(abyte0, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new RuntimeException(abyte0);
        }
    }
}
