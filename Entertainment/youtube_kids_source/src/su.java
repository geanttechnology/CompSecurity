// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.animation.Animation;

public final class su
    implements ss
{

    private cux a;
    private st b;
    private boolean c;
    private boolean d;
    private boolean e;
    private String f[];
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;

    public su()
    {
    }

    public final void a()
    {
        throw new UnsupportedOperationException("Cannot show StubOverflowOverlay");
    }

    public final void a(Animation animation)
    {
    }

    public final void a(cux cux)
    {
        a = cux;
    }

    public final void a(ss ss1)
    {
        ss1.a(a);
        ss1.a(b);
        ss1.a(c);
        ss1.c(d);
        ss1.b(e);
        ss1.a(f, g);
        ss1.e(h);
        ss1.d(i);
        ss1.f(j);
    }

    public final void a(st st)
    {
        b = st;
    }

    public final void a(boolean flag)
    {
        c = flag;
    }

    public final void a(String as[], int k)
    {
        f = as;
        g = k;
    }

    public final void b(boolean flag)
    {
        e = flag;
    }

    public final void c()
    {
    }

    public final void c(boolean flag)
    {
        d = flag;
    }

    public final void d()
    {
        c = false;
        e = false;
        h = false;
    }

    public final void d(boolean flag)
    {
        i = flag;
    }

    public final void e(boolean flag)
    {
        h = flag;
    }

    public final void f(boolean flag)
    {
        j = flag;
    }
}
