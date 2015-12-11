// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk.util;

import android.util.Base64;
import java.util.Arrays;

public class c
{

    private final byte a[];
    private final byte b[];
    private final byte c[];

    public static byte[] a(byte abyte0[], byte abyte1[])
    {
        byte abyte2[] = new byte[abyte0.length + abyte1.length];
        System.arraycopy(abyte0, 0, abyte2, 0, abyte0.length);
        System.arraycopy(abyte1, 0, abyte2, abyte0.length, abyte1.length);
        return abyte2;
    }

    public byte[] a()
    {
        return a;
    }

    public byte[] b()
    {
        return b;
    }

    public byte[] c()
    {
        return c;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (c)obj;
            if (!Arrays.equals(a, ((a) (obj)).a))
            {
                return false;
            }
            if (!Arrays.equals(b, ((b) (obj)).b))
            {
                return false;
            }
            if (!Arrays.equals(c, ((c) (obj)).c))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return ((Arrays.hashCode(a) + 31) * 31 + Arrays.hashCode(b)) * 31 + Arrays.hashCode(c);
    }

    public String toString()
    {
        String s = Base64.encodeToString(b, 2);
        String s1 = Base64.encodeToString(a, 2);
        String s2 = Base64.encodeToString(c, 2);
        return String.format((new StringBuilder()).append(s).append(":").append(s2).append(":").append(s1).toString(), new Object[0]);
    }

    public (String s)
    {
        s = s.split(":");
        if (s.length != 3)
        {
            throw new IllegalArgumentException("Cannot parse iv:ciphertext:mac");
        } else
        {
            b = Base64.decode(s[0], 2);
            c = Base64.decode(s[1], 2);
            a = Base64.decode(s[2], 2);
            return;
        }
    }

    public a(byte abyte0[], byte abyte1[], byte abyte2[])
    {
        a = Arrays.copyOf(abyte0, abyte0.length);
        b = Arrays.copyOf(abyte1, abyte1.length);
        c = Arrays.copyOf(abyte2, abyte2.length);
    }
}
