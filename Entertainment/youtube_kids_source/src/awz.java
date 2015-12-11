// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;

final class awz extends bu
    implements avt, awk
{

    public final awi f;
    boolean g;
    private avq h;

    public awz(Context context, awi awi1)
    {
        super(context);
        f = awi1;
    }

    private void b(avq avq1)
    {
        h = avq1;
        if (super.c && !super.d)
        {
            a(avq1);
        }
    }

    public final void a(int i)
    {
    }

    public final void a(Bundle bundle)
    {
        g = false;
        b(avq.a);
    }

    public final void a(avq avq1)
    {
        g = true;
        b(avq1);
    }

    protected final void b()
    {
        super.b();
        f.a(this);
        f.a(this);
        if (h != null)
        {
            a(h);
        }
        if (!f.c() && !f.d() && !g)
        {
            f.a();
        }
    }

    protected final void d()
    {
        f.b();
    }

    protected final void f()
    {
        h = null;
        g = false;
        f.b(this);
        f.b(this);
        f.b();
    }
}
