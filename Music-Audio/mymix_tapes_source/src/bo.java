// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmsp.client.sdk.oem.g;

public abstract class bo
{

    private static bo a = new g();

    public bo()
    {
    }

    public static String b()
    {
        return a.a();
    }

    public static byte[] b(byte abyte0[], byte abyte1[])
    {
        return a.a(abyte0, abyte1);
    }

    protected abstract String a();

    protected abstract byte[] a(byte abyte0[], byte abyte1[]);

}
