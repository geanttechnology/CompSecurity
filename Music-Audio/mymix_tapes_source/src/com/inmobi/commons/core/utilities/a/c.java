// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.a;

import android.util.Base64;
import com.inmobi.commons.core.utilities.Logger;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class c
{

    private static final String a = com/inmobi/commons/core/utilities/a/c.getSimpleName();

    public c()
    {
    }

    public static String a(String s)
    {
        if (s == null || "".equals(s))
        {
            return null;
        }
        try
        {
            Object obj = new BigInteger("C10F7968CFE2C76AC6F0650C877806D4514DE58FC239592D2385BCE5609A84B2A0FBDAF29B05505EAD1FDFEF3D7209ACBF34B5D0A806DF18147EA9C0337D6B5B", 16);
            Object obj1 = new BigInteger("010001", 16);
            obj = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(((BigInteger) (obj)), ((BigInteger) (obj1))));
            obj1 = Cipher.getInstance("RSA/ECB/nopadding");
            ((Cipher) (obj1)).init(1, ((java.security.Key) (obj)));
            s = new String(Base64.encode(a(s.getBytes("UTF-8"), 1, ((Cipher) (obj1))), 0));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Erorr in uid encryption.", s);
            return null;
        }
        return s;
    }

    private static byte[] a(byte abyte0[], int i, Cipher cipher)
        throws IllegalBlockSizeException, BadPaddingException
    {
        if (i != 1);
        int k = abyte0.length;
        byte abyte3[] = new byte[64];
        byte abyte1[] = new byte[0];
        i = 0;
        while (i < k) 
        {
            byte abyte4[] = abyte3;
            byte abyte2[] = abyte1;
            if (i > 0)
            {
                abyte4 = abyte3;
                abyte2 = abyte1;
                if (i % 64 == 0)
                {
                    abyte2 = a(abyte1, cipher.doFinal(abyte3));
                    int j;
                    if (i + 64 > k)
                    {
                        j = k - i;
                    } else
                    {
                        j = 64;
                    }
                    abyte4 = new byte[j];
                }
            }
            abyte4[i % 64] = abyte0[i];
            i++;
            abyte3 = abyte4;
            abyte1 = abyte2;
        }
        return a(abyte1, cipher.doFinal(abyte3));
    }

    private static byte[] a(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length + abyte1.length];
        System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
        System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
        return abyte2;
    }

}
