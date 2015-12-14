// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.commons.core.utilities.a;

import android.util.Base64;
import com.inmobi.commons.core.utilities.Logger;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.inmobi.commons.core.utilities.a:
//            a

public class b
{

    private static final String a = com/inmobi/commons/core/utilities/a/b.getSimpleName();
    private static String b = "AES";
    private static String c = "AES/CBC/PKCS7Padding";
    private static byte d[];

    public b()
    {
    }

    public static String a(String s, byte abyte0[], byte abyte1[], byte abyte2[], String s1, String s2)
    {
        try
        {
            s = b(s.getBytes("UTF-8"), abyte0, abyte1);
            byte abyte3[] = a(((byte []) (s)), abyte2);
            s = a(((byte []) (s)));
            abyte3 = a(abyte3);
            abyte1 = a(abyte1);
            s = new String(Base64.encode(b(a(a(b(b(a(abyte0), a(abyte2)), abyte1), s2, s1)), b(s, abyte3)), 8));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

    public static byte[] a()
    {
        com/inmobi/commons/core/utilities/a/b;
        JVM INSTR monitorenter ;
        byte abyte0[] = new a();
        if (System.currentTimeMillis() / 1000L - abyte0.c() <= 0x15180L) goto _L2; else goto _L1
_L1:
        d = b();
        abyte0.a(Base64.encodeToString(d, 0));
_L4:
        abyte0 = d;
        com/inmobi/commons/core/utilities/a/b;
        JVM INSTR monitorexit ;
        return abyte0;
_L2:
        if (d != null) goto _L4; else goto _L3
_L3:
        String s = abyte0.b();
        d = Base64.decode(s, 0);
          goto _L4
        IllegalArgumentException illegalargumentexception;
        illegalargumentexception;
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "getAesPublicKey failed to decode the cached key.", illegalargumentexception);
        d = b();
        abyte0.a(Base64.encodeToString(d, 0));
          goto _L4
        Exception exception;
        exception;
        throw exception;
    }

    public static byte[] a(int i)
    {
        byte abyte0[] = new byte[i];
        (new SecureRandom()).nextBytes(abyte0);
        return abyte0;
    }

    private static byte[] a(byte abyte0[])
    {
        long l = abyte0.length;
        ByteBuffer bytebuffer = ByteBuffer.allocate(8);
        bytebuffer.order(ByteOrder.LITTLE_ENDIAN);
        bytebuffer.putLong(l);
        byte abyte1[] = bytebuffer.array();
        byte abyte2[] = new byte[abyte1.length + abyte0.length];
        System.arraycopy(abyte1, 0, abyte2, 0, abyte1.length);
        System.arraycopy(abyte0, 0, abyte2, abyte1.length, abyte0.length);
        return abyte2;
    }

    public static byte[] a(byte abyte0[], String s, String s1)
    {
        s1 = new BigInteger(s1, 16);
        s = new BigInteger(s, 16);
        try
        {
            s = (RSAPublicKey)KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(s1, s));
            s1 = Cipher.getInstance("RSA/ECB/nopadding");
            s1.init(1, s);
            abyte0 = s1.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        return abyte0;
    }

    private static byte[] a(byte abyte0[], byte abyte1[])
    {
        abyte1 = new SecretKeySpec(abyte1, 0, abyte1.length, "HmacSHA1");
        try
        {
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(abyte1);
            abyte0 = mac.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        return abyte0;
    }

    public static byte[] a(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        abyte1 = new SecretKeySpec(abyte1, b);
        try
        {
            Cipher cipher = Cipher.getInstance(c);
            cipher.init(2, abyte1, new IvParameterSpec(abyte2));
            abyte0 = cipher.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", abyte0);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", abyte0);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", abyte0);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", abyte0);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", abyte0);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, a, "Error while decrypting response.", abyte0);
            return null;
        }
        return abyte0;
    }

    private static byte[] b()
    {
        byte abyte0[] = new byte[16];
        try
        {
            SecureRandom.getInstance("SHA1PRNG", "Crypto").nextBytes(abyte0);
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            nosuchalgorithmexception.printStackTrace();
            return abyte0;
        }
        catch (NoSuchProviderException nosuchproviderexception)
        {
            nosuchproviderexception.printStackTrace();
            return abyte0;
        }
        return abyte0;
    }

    private static byte[] b(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length + abyte1.length];
        System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
        System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
        return abyte2;
    }

    private static byte[] b(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        abyte1 = new SecretKeySpec(abyte1, b);
        abyte2 = new IvParameterSpec(abyte2);
        try
        {
            Cipher cipher = Cipher.getInstance(c);
            cipher.init(1, abyte1, abyte2);
            cipher.init(1, abyte1, abyte2);
            cipher.init(1, abyte1, abyte2);
            abyte0 = cipher.doFinal(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            abyte0.printStackTrace();
            return null;
        }
        return abyte0;
    }

}
