// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.view.View;
import java.lang.ref.WeakReference;

public final class ep
{

    public static final ex b;
    public WeakReference a;
    private Runnable c;
    private Runnable d;
    private int e;

    ep(View view)
    {
        c = null;
        d = null;
        e = -1;
        a = new WeakReference(view);
    }

    static int a(ep ep1, int i)
    {
        ep1.e = -1;
        return -1;
    }

    static Runnable a(ep ep1)
    {
        return null;
    }

    static Runnable b(ep ep1)
    {
        return null;
    }

    static int c(ep ep1)
    {
        return ep1.e;
    }

    public final ep a(float f)
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.a(this, view, f);
        }
        return this;
    }

    public final ep a(fa fa)
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.a(this, view, fa);
        }
        return this;
    }

    public final void a()
    {
        View view = (View)a.get();
        if (view != null)
        {
            b.a(this, view);
        }
    }

    static 
    {
        int i = android.os.Build.VERSION.SDK_INT;
        if (i >= 19)
        {
            b = new ew();
        } else
        if (i >= 18)
        {
            b = new eu();
        } else
        if (i >= 16)
        {
            b = new ev();
        } else
        if (i >= 14)
        {
            b = new es();
        } else
        {
            b = new eq();
        }
    }
}
