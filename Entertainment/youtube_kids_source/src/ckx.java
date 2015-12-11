// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;

public class ckx extends cja
    implements android.view.SurfaceHolder.Callback
{

    public final ckz c;
    private final View d;
    private boolean e;

    public ckx(Context context)
    {
        super(context);
        c = new ckz(this, context);
        c.getHolder().addCallback(this);
        d = new View(context);
        d.setBackgroundColor(0xff000000);
        addView(c);
        addView(d);
    }

    public final volatile void a(boolean flag)
    {
        super.a(flag);
    }

    public final SurfaceHolder d()
    {
        return c.getHolder();
    }

    protected final void e()
    {
        d.setVisibility(8);
    }

    protected final void f()
    {
        d.setVisibility(0);
    }

    public final volatile ckf h()
    {
        return super.h();
    }

    public final Surface i()
    {
        return c.getHolder().getSurface();
    }

    public final boolean j()
    {
        return e;
    }

    public final void k()
    {
        post(new cky(this));
    }

    public final void l()
    {
        Surface surface = c.getHolder().getSurface();
        if (surface != null)
        {
            surface.release();
        }
    }

    public final int m()
    {
        return 3;
    }

    protected void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        a(c, k1, l1);
        if (d.getVisibility() != 8)
        {
            a(d, k1, l1);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i1, int j1, int k1)
    {
        if (b != null)
        {
            b.b();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        e = true;
        if (b != null)
        {
            b.a();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        e = false;
        if (b != null)
        {
            b.c();
        }
        g();
    }
}
