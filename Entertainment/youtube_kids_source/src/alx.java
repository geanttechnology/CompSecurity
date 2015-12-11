// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class alx
{

    String a;
    public int b;
    public cxu c;
    String d;
    int e;

    public alx()
    {
        a = "";
        b = 0;
        c = null;
        d = "";
        e = -1;
    }

    public alx(alw alw1)
    {
        a = alw1.a;
        b = alw1.b;
        c = alw1.c;
        d = alw1.d;
        e = alw1.e;
    }

    public final alw a()
    {
        return new alw(this);
    }

    public final alx a(int i)
    {
        if (i < 0)
        {
            i = -1;
        }
        e = i;
        return this;
    }

    public final alx a(String s)
    {
        if (s != null)
        {
            a = s;
        }
        return this;
    }

    public final alx b(String s)
    {
        if (s != null)
        {
            d = s;
        }
        return this;
    }
}
