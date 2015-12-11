// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.algorithm;

import android.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

public class DESUtil
{

    private Cipher decryptCipher;

    private byte[] decryptByte(byte abyte0[])
        throws BadPaddingException, IllegalBlockSizeException
    {
        return decryptCipher.doFinal(abyte0);
    }

    public String decryptStr(String s)
    {
        String s1;
        try
        {
            s1 = new String(decryptByte(Base64.decode(s, 0)), "UTF8");
        }
        catch (Exception exception)
        {
            return (new StringBuilder()).append("[des]").append(s).append("|").append(exception.toString()).toString();
        }
        return s1;
    }
}
