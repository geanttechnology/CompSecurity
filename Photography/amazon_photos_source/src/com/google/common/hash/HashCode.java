// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.hash;

import java.security.MessageDigest;

public abstract class HashCode
{

    private static final char hexDigits[] = "0123456789abcdef".toCharArray();

    HashCode()
    {
    }

    public abstract byte[] asBytes();

    public abstract int asInt();

    public abstract long asLong();

    public boolean equals(Object obj)
    {
        if (obj instanceof HashCode)
        {
            obj = (HashCode)obj;
            return MessageDigest.isEqual(asBytes(), ((HashCode) (obj)).asBytes());
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return asInt();
    }

    public String toString()
    {
        byte abyte0[] = asBytes();
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 2);
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            byte byte0 = abyte0[i];
            stringbuilder.append(hexDigits[byte0 >> 4 & 0xf]).append(hexDigits[byte0 & 0xf]);
        }

        return stringbuilder.toString();
    }

}
