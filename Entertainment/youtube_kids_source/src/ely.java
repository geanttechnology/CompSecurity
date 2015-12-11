// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class ely
{

    private static final int a;
    private static final elw b = new emc("SHA-1", "Hashing.sha1()");

    public static elw a()
    {
        return b;
    }

    private static elw a(elz elz1, String s)
    {
        return new elq(elz1, elz.a(elz1), s);
    }

    static 
    {
        int i = (int)System.currentTimeMillis();
        a = i;
        new emh(i);
        new emf(a);
        new emh(0);
        new emf(0);
        new emc("MD5", "Hashing.md5()");
        new emc("SHA-256", "Hashing.sha256()");
        new emc("SHA-512", "Hashing.sha512()");
        a(elz.a, "Hashing.crc32()");
        a(elz.b, "Hashing.adler32()");
    }
}
