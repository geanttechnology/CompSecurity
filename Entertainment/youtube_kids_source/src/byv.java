// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Base64;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public final class byv extends coo
{

    private final byte a[];

    public byv(byte abyte0[])
    {
        a = (byte[])b.a(abyte0);
    }

    private byte[] a(String s)
    {
label0:
        {
            Cipher cipher;
            byte abyte0[];
            byte abyte1[];
            try
            {
                cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new bnn(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new bnn(s);
            }
            abyte1 = Base64.decode(a, 0);
            s = Base64.decode(s, 0);
            try
            {
                cipher.init(2, new SecretKeySpec(abyte1, "AES"));
                s = cipher.doFinal(s);
                if (s.length <= 20)
                {
                    break label0;
                }
                abyte0 = new byte[20];
                System.arraycopy(s, 0, abyte0, 0, 20);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new bnn(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new bnn(s);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                throw new bnn(s);
            }
            return abyte0;
        }
        return s;
    }

    protected final Object a(InputStream inputstream)
    {
        Object obj = new Properties();
        ((Properties) (obj)).load(inputstream);
        inputstream = ((Properties) (obj)).getProperty("DeviceId");
        obj = ((Properties) (obj)).getProperty("DeviceKey");
        if (inputstream != null && obj != null)
        {
            return new cdl(inputstream, a(((String) (obj))));
        } else
        {
            throw new bnn("invalid device registration response");
        }
    }
}
