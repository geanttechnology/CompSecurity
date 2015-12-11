// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public abstract class bgi
    implements cwv
{

    private final bje a;

    public bgi(bje bje1)
    {
        a = (bje)b.a(bje1);
    }

    public abstract void a(int i1, int j1);

    public abstract void a(cnd cnd);

    public abstract void a(crw crw);

    protected abstract void a(csg csg);

    public abstract void a(cte cte);

    public void b()
    {
        a.b(this);
    }

    public abstract void b(crw crw);

    public abstract void c();

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public abstract void g();

    public abstract void h();

    public abstract void i();

    public abstract void j();

    public abstract bgj k();

    public abstract void l();

    public abstract void m();

    public void n()
    {
        a.a(this, bgi);
    }

    public void relayPlayerGeometryChanged(csg csg)
    {
        a(csg);
    }
}
