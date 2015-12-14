// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.socialin.android.d;
import com.socialin.android.util.FileUtils;
import com.socialin.android.util.c;
import com.sonyericsson.zoom.ImageZoomView;
import com.sonyericsson.zoom.PinchZoomListener;
import com.sonyericsson.zoom.a;
import com.sonyericsson.zoom.b;

// Referenced classes of package com.socialin.android.picsart.profile.view:
//            d, e

public class GalleryPagerItemView extends ImageZoomView
{

    public int a;
    public com.socialin.android.net.d b;
    public com.socialin.android.picsart.profile.view.d c;
    public String d;
    private Drawable i;
    private Object j;
    private e k;

    public GalleryPagerItemView(Context context)
    {
        super(context);
        a = -1;
        c = null;
        j = new Object();
        d = null;
    }

    public GalleryPagerItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = -1;
        c = null;
        j = new Object();
        d = null;
    }

    private int a(int l)
    {
        boolean flag;
        boolean flag1;
        flag = true;
        flag1 = true;
        if (l == 1) goto _L2; else goto _L1
_L1:
        int i1 = l;
        if (l != 2) goto _L3; else goto _L2
_L2:
        android.graphics.BitmapFactory.Options options;
        int j1;
        c.a = true;
        options = new android.graphics.BitmapFactory.Options();
        j1 = ((flag) ? 1 : 0);
        options.inJustDecodeBounds = true;
        j1 = ((flag) ? 1 : 0);
        com.socialin.android.util.c.a(d, options);
        j1 = ((flag) ? 1 : 0);
        if (options.outWidth > 1024)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        i1 = ((flag1) ? 1 : 0);
        j1 = ((flag) ? 1 : 0);
        if (options.outHeight <= 1024)
        {
            break MISSING_BLOCK_LABEL_110;
        }
        j1 = ((flag) ? 1 : 0);
        i1 = Math.max(options.outWidth / 1024, options.outHeight / 1024);
        j1 = i1;
        options.inSampleSize = i1;
        j1 = i1;
        options.inJustDecodeBounds = false;
        j1 = i1;
        f = com.socialin.android.util.c.a(d, options);
        j1 = i1;
        Bitmap bitmap = f;
        if (bitmap == null)
        {
            l = -1;
        }
_L5:
        c.a = false;
        i1 = l;
_L3:
        return i1;
        OutOfMemoryError outofmemoryerror;
        outofmemoryerror;
        com.socialin.android.d.a("gallery: loadImage- OOM", outofmemoryerror);
        options.inJustDecodeBounds = false;
        options.inSampleSize = j1 * 2;
        c.a = false;
        f = com.socialin.android.util.c.a(d, options);
        if (true) goto _L5; else goto _L4
_L4:
    }

    static int a(GalleryPagerItemView gallerypageritemview, int l)
    {
        return gallerypageritemview.a(l);
    }

    static Object a(GalleryPagerItemView gallerypageritemview)
    {
        return gallerypageritemview.j;
    }

    private void a(Drawable drawable)
    {
        int i1 = getWidth();
        int l = getHeight();
        drawable.getIntrinsicHeight();
        i1 = (i1 - drawable.getIntrinsicWidth()) / 2;
        l = (l - drawable.getIntrinsicHeight()) / 2;
        drawable.setBounds(i1, l, drawable.getIntrinsicWidth() + i1, drawable.getIntrinsicHeight() + l);
    }

    static String b(GalleryPagerItemView gallerypageritemview)
    {
        return gallerypageritemview.d;
    }

    static void b(GalleryPagerItemView gallerypageritemview, int l)
    {
        gallerypageritemview.b();
        if (l == -1)
        {
            try
            {
                FileUtils.c(gallerypageritemview.d);
            }
            catch (Exception exception)
            {
                com.socialin.android.d.a("Error while deleting file from sd", exception);
            }
            gallerypageritemview.setState(2);
        }
    }

    static Bitmap c(GalleryPagerItemView gallerypageritemview)
    {
        return gallerypageritemview.f;
    }

    static void d(GalleryPagerItemView gallerypageritemview)
    {
        gallerypageritemview.setState(2);
        try
        {
            FileUtils.c(gallerypageritemview.d);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GalleryPagerItemView gallerypageritemview)
        {
            com.socialin.android.d.a("Error while deleting file from sd", gallerypageritemview);
        }
    }

    static void e(GalleryPagerItemView gallerypageritemview)
    {
        gallerypageritemview.setState(2);
    }

    static void f(GalleryPagerItemView gallerypageritemview)
    {
        gallerypageritemview.setImage(gallerypageritemview.f);
        b b1 = new b();
        a a1;
        if (android.os.Build.VERSION.SDK_INT >= 7)
        {
            PinchZoomListener pinchzoomlistener = new PinchZoomListener(gallerypageritemview.getContext().getApplicationContext());
            pinchzoomlistener.a = b1;
            gallerypageritemview.setOnTouchListener(pinchzoomlistener);
        } else
        {
            gallerypageritemview.setOnTouchListener(new _cls1());
        }
        gallerypageritemview.setZoomControl(b1);
        a1 = ((ImageZoomView) (gallerypageritemview)).e;
        if (b1.b != null)
        {
            b1.b.deleteObserver(b1);
        }
        b1.b = a1;
        b1.b.addObserver(b1);
        gallerypageritemview.g.e(1.01F);
        gallerypageritemview.a();
        b1.update(null, null);
        gallerypageritemview.setState(4);
        if (gallerypageritemview.c != null)
        {
            gallerypageritemview.c.a = false;
        }
    }

    public final void a()
    {
        if (g != null)
        {
            super.a();
        }
    }

    public final void b()
    {
        if (b != null)
        {
            b.cancel(false);
        }
        synchronized (j)
        {
            if (f != null)
            {
                f.recycle();
                f = null;
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void invalidateDrawable(Drawable drawable)
    {
        if (drawable == c)
        {
            invalidate();
            return;
        } else
        {
            super.invalidateDrawable(drawable);
            return;
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (a == 1)
        {
            if (c != null)
            {
                a(c);
                c.draw(canvas);
            }
        } else
        {
            if (a == 2)
            {
                if (i == null)
                {
                    i = getContext().getResources().getDrawable(0x7f020217);
                }
                a(i);
                i.draw(canvas);
                return;
            }
            if (a == 3 || a == 4)
            {
                super.onDraw(canvas);
                return;
            }
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag && c != null)
        {
            a(c);
        }
    }

    public void setOnStateChangedListener(e e1)
    {
        k = e1;
    }

    public void setState(int l)
    {
        a = l;
        if (k != null)
        {
            k.a(this, l);
        }
    }

    protected boolean verifyDrawable(Drawable drawable)
    {
        return drawable == c || super.verifyDrawable(drawable);
    }

    /* member class not found */
    class _cls1 {}

}
