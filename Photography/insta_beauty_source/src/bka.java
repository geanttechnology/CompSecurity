// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bka
{

    private static bka a = new bka();
    private byte b[];
    private boolean c;
    private String d;

    private bka()
    {
        c = true;
    }

    public static bka a()
    {
        return a;
    }

    public void a(byte abyte0[])
    {
        b = abyte0;
    }

    public byte[] b()
    {
        return b;
    }

    public String c()
    {
        return d;
    }

    public boolean d()
    {
        return c;
    }

}
