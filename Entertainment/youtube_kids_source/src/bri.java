// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bri
{

    public final din a;
    public bsf b;
    public bsr c;
    public btl d;
    private dki e;

    public bri()
    {
        a = null;
    }

    public bri(din din1)
    {
        a = (din)b.a(din1);
    }

    public boolean a()
    {
        return a != null && a.a != null;
    }

    public final dki b()
    {
        if (a() && a.a.e != null)
        {
            return a.a.e;
        }
        if (e == null)
        {
            e = new dki();
        }
        return e;
    }
}
