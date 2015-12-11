// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.security.MessageDigest;

public abstract class els
{

    private static final char a[] = "0123456789abcdef".toCharArray();

    els()
    {
    }

    public abstract int a();

    public abstract byte[] b();

    public boolean equals(Object obj)
    {
        if (obj instanceof els)
        {
            obj = (els)obj;
            return MessageDigest.isEqual(b(), ((els) (obj)).b());
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return a();
    }

    public String toString()
    {
        byte abyte0[] = b();
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 2);
        int j = abyte0.length;
        for (int i = 0; i < j; i++)
        {
            byte byte0 = abyte0[i];
            stringbuilder.append(a[byte0 >> 4 & 0xf]).append(a[byte0 & 0xf]);
        }

        return stringbuilder.toString();
    }

}
