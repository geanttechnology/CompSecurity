// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class apb
    implements asl
{

    public final app a;
    public final int b;
    final art c;
    final arx d;
    asn e;

    public apb(art art1, arx arx1, app app1, int i)
    {
        boolean flag;
        if (arx1.e <= 0x7fffffffL)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        c = (art)a.b(art1);
        d = (arx)a.b(arx1);
        a = (app)a.b(app1);
        b = i;
    }

    public final void a()
    {
        if (e != null)
        {
            e.j();
            e = null;
        }
    }

    public void a(asn asn1)
    {
    }

    public final void b()
    {
        boolean flag;
        if (e != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag);
        a(e);
    }

    protected final void c()
    {
        if (e != null)
        {
            e.b();
        }
    }

    public final void d()
    {
        e.d();
    }

    public final boolean e()
    {
        return e.e();
    }

    public final void f()
    {
        a.g("chunkLoad");
        e.f();
        a.c();
        return;
        Exception exception;
        exception;
        a.c();
        throw exception;
    }
}
