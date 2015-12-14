// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class uz
{

    private static uz a = new uz();
    private String b;
    private byte c[];
    private boolean d;
    private String e;

    private uz()
    {
        d = true;
    }

    public static uz a()
    {
        return a;
    }

    public void a(String s)
    {
        b = s;
    }

    public void a(boolean flag)
    {
        d = flag;
    }

    public void a(byte abyte0[])
    {
        c = abyte0;
    }

    public void b()
    {
        b = null;
        c = null;
        d = true;
        e = null;
    }

    public void b(String s)
    {
        e = s;
    }

    public byte[] c()
    {
        return c;
    }

    public String d()
    {
        return e;
    }

    public boolean e()
    {
        return d;
    }

}
