// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

final class emh extends elw
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private final int a;

    emh(int i)
    {
        a = i;
    }

    static int a(int i)
    {
        return Integer.rotateLeft(0xcc9e2d51 * i, 15) * 0x1b873593;
    }

    static int a(int i, int j)
    {
        return Integer.rotateLeft(i ^ j, 13) * 5 - 0x19ab949c;
    }

    static els b(int i, int j)
    {
        i ^= j;
        i = (i ^ i >>> 16) * 0x85ebca6b;
        i = (i ^ i >>> 13) * 0xc2b2ae35;
        return a.i(i ^ i >>> 16);
    }

    public final elx a()
    {
        return new emi(a);
    }

    public final String toString()
    {
        return (new StringBuilder("Hashing.murmur3_32(")).append(a).append(")").toString();
    }
}
