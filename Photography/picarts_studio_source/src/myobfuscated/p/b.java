// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.p;

import myobfuscated.s.g;

public final class b
{

    public final g a;
    public final myobfuscated.s.b b;

    public b(g g, myobfuscated.s.b b1)
    {
        a = g;
        b = b1;
    }

    public final void a(byte abyte0[])
    {
        if (b == null)
        {
            return;
        } else
        {
            b.a(abyte0, [B);
            return;
        }
    }

    public final byte[] a(int i)
    {
        if (b == null)
        {
            return new byte[i];
        } else
        {
            return (byte[])b.a(i, [B);
        }
    }
}
