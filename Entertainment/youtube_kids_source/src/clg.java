// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;

public final class clg extends cja
    implements android.view.TextureView.SurfaceTextureListener
{

    private cli c;
    private Surface d;

    public clg(Context context)
    {
        super(context);
        n();
        addView(c);
    }

    static cli a(clg clg1)
    {
        return clg1.c;
    }

    static void b(clg clg1)
    {
        clg1.n();
    }

    private void n()
    {
        c = new cli(this, getContext());
        c.setSurfaceTextureListener(this);
        c.setLayoutParams(new android.view.ViewGroup.LayoutParams(-2, -2));
        c.setPivotX(0.0F);
        c.setPivotY(0.0F);
        c.setScaleX(1.00001F);
    }

    public final volatile void a(boolean flag)
    {
        super.a(flag);
    }

    public final volatile SurfaceHolder d()
    {
        return super.d();
    }

    protected final void e()
    {
        c.setAlpha(1.0F);
        setBackgroundDrawable(null);
    }

    protected final void f()
    {
        c.setAlpha(0.0F);
        setBackgroundColor(0xff000000);
    }

    public final volatile ckf h()
    {
        return super.h();
    }

    public final Surface i()
    {
        return d;
    }

    public final boolean j()
    {
        return d != null;
    }

    public final void k()
    {
        post(new clh(this));
    }

    public final void l()
    {
        if (d != null)
        {
            d.release();
        }
    }

    public final int m()
    {
        return 2;
    }

    protected final void onLayout(boolean flag, int i1, int j1, int k1, int l1)
    {
        a(c, k1, l1);
    }

    public final void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i1, int j1)
    {
        d = new Surface(surfacetexture);
        if (b != null)
        {
            b.a();
        }
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        d = null;
        if (b != null)
        {
            b.c();
        }
        removeCallbacks(super.a);
        return true;
    }

    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i1, int j1)
    {
        if (b != null)
        {
            b.b();
        }
    }

    public final void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
        if (b != null)
        {
            b.b();
        }
    }
}
