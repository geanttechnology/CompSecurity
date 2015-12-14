// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


class ceu
    implements Runnable
{

    final byte a[];
    final cet b;

    ceu(cet cet1, byte abyte0[])
    {
        b = cet1;
        a = abyte0;
        super();
    }

    public void run()
    {
        b.b.a(b.a, a);
    }
}
