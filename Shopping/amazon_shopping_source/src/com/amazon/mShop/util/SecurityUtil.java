// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.util;

import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.spec.RSAPublicKeySpec;
import javax.crypto.Cipher;

public class SecurityUtil
{

    private static final RSAPublicKeySpec PUBLIC_KEY_SPEC = new RSAPublicKeySpec(new BigInteger("00929aee0d3595cc2bc2aac2a75b65b5dcdacc62e2f1794f344a536ec535eb18407290e2da8a211e876f68494a5c98d34fefb398c6631f543b02ec05d0757fd2a46e467a5709eaccb2c0a73ea76dbf53b156eb897c103964ab93f5018be88a40df7b3b8ad95d5ea1188857ce1c21a1adfd016a8a46c54cab7edcdf05a9dca7ee3ce6d797f6de8260a0d1a07c73a6e3f37ae9035d8335691298395e8da4df8ab20cb25ee409fb50e3404031035f4cbf9add91cbd96596e64ab577616aacf66a210e92843205e06509d5fbe06aa0e10e4ebc02bc9e1bf597f39f2c98393a7e79cc0f3641c6d053bc8f9b20f443283aa0e88047718360683baaf41f01fe50694b3167", 16), new BigInteger("10001", 16));

    public SecurityUtil()
    {
    }

    public static String decryptHex(String s)
        throws Exception
    {
        s = hexToBytes(s);
        java.security.PublicKey publickey = KeyFactory.getInstance("RSA").generatePublic(PUBLIC_KEY_SPEC);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(2, publickey);
        return new String(cipher.doFinal(s));
    }

    public static byte[] hexToBytes(String s)
    {
        if (s != null && s.length() != 0) goto _L2; else goto _L1
_L1:
        byte abyte0[] = null;
_L4:
        return abyte0;
_L2:
        if ((s.length() & 1) == 1)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Input should have an even number of characters, not odd: ").append(s).toString());
        }
        byte abyte1[] = new byte[s.length() >> 1];
        int i = 0;
        do
        {
            abyte0 = abyte1;
            if (i >= s.length())
            {
                continue;
            }
            abyte1[i >> 1] = (byte)(Integer.parseInt(s.substring(i, i + 2), 16) & 0xff);
            i += 2;
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
    }

}
