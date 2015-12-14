// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.birdview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.TextureView;
import android.view.View;
import android.view.WindowManager;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.i;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.w;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.pf.common.utility.m;

public class BirdView extends TextureView
    implements android.view.TextureView.SurfaceTextureListener
{

    private Point a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private Point g;
    private Bitmap h;
    private Bitmap i;
    private Bitmap j;
    private boolean k;
    private Context l;

    public BirdView(Context context)
    {
        super(context);
        a = new Point(5, 0);
        d = 30;
        e = 1.2F;
        f = 2.2F;
        g = null;
        h = null;
        i = null;
        j = null;
        k = false;
        l = null;
        a(context);
    }

    public BirdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new Point(5, 0);
        d = 30;
        e = 1.2F;
        f = 2.2F;
        g = null;
        h = null;
        i = null;
        j = null;
        k = false;
        l = null;
        a(context);
    }

    public BirdView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = new Point(5, 0);
        d = 30;
        e = 1.2F;
        f = 2.2F;
        g = null;
        h = null;
        i = null;
        j = null;
        k = false;
        l = null;
        a(context);
    }

    private int a(float f1)
    {
        return (int)(getResources().getDisplayMetrics().density * f1 + 0.5F);
    }

    private void a(Context context)
    {
        setSurfaceTextureListener(this);
        setOpaque(false);
        setVisibility(4);
        l = context;
        c();
        h = BitmapFactory.decodeResource(getResources(), 0x7f0201be);
        i = BitmapFactory.decodeResource(getResources(), 0x7f0201bc);
        j = Bitmap.createBitmap(b, c, android.graphics.Bitmap.Config.ARGB_8888);
    }

    private void a(Canvas canvas, int i1, int j1, float f1)
    {
        Paint paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(false);
        if (e * f1 > 1.0001F)
        {
            paint.setFilterBitmap(true);
        }
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DST_IN));
        Rect rect = new Rect(0, 0, i1, j1);
        canvas.drawBitmap(h, null, rect, paint);
    }

    private void a(Canvas canvas, i i1, float f1, Rect rect, RectF rectf)
    {
        Paint paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(false);
        if (e * f1 > 1.0001F)
        {
            paint.setFilterBitmap(true);
        }
        canvas.drawColor(0xff000000);
        if (i1.a == null || i1.a.isRecycled())
        {
            a("bitmap is null or recycled, return");
            return;
        } else
        {
            canvas.drawBitmap(i1.a, rect, rectf, paint);
            return;
        }
    }

    private void a(BirdViewMode birdviewmode, i i1, int j1, int k1, float f1, Rect rect, RectF rectf)
    {
        int l1 = b;
        int i2 = c;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        float f8;
        float f9;
        float f10;
        float f11;
        if (f1 > 1.0F)
        {
            f3 = 1.0F / f1;
        } else
        {
            f3 = 1.0F;
        }
        f10 = ((float)l1 * f3) / e;
        f8 = ((float)i2 * f3) / e;
        f4 = ((float)j1 - (float)l1 / e / 2.0F) * f3;
        f6 = ((float)k1 - (float)i2 / e / 2.0F) * f3;
        f11 = l1;
        f9 = i2;
        f2 = 0.0F;
        f5 = 0.0F;
        f1 = f4;
        if (f4 < 0.0F)
        {
            f2 = 0.0F - (f4 / f3) * e;
            f1 = 0.0F;
        }
        f4 = f6;
        if (f6 < 0.0F)
        {
            f5 = 0.0F - (f6 / f3) * e;
            f4 = 0.0F;
        }
        f7 = f11;
        f6 = f10;
        if (f1 + f10 > (float)i1.a.getWidth())
        {
            f7 = f11 - (Math.abs((f1 + f10) - (float)i1.a.getWidth()) * e) / f3;
            f6 = f10 - Math.abs((f1 + f10) - (float)i1.a.getWidth());
        }
        if (f4 + f8 > (float)i1.a.getHeight())
        {
            f3 = f9 - (Math.abs((f4 + f8) - (float)i1.a.getHeight()) * e) / f3;
            f8 -= Math.abs((f4 + f8) - (float)i1.a.getHeight());
        } else
        {
            f3 = f9;
        }
        rect.left = (int)f1;
        rect.top = (int)f4;
        rect.right = (int)(f6 + f1);
        rect.bottom = (int)(f4 + f8);
        rectf.left = f2;
        rectf.top = f5;
        rectf.right = f2 + f7;
        rectf.bottom = f3 + f5;
    }

    private void a(BirdViewMode birdviewmode, Float float1, Bitmap bitmap, int i1, int j1, View view, int k1, 
            int l1)
    {
        birdviewmode = lockCanvas();
        if (birdviewmode == null)
        {
            return;
        }
        birdviewmode.drawColor(0, android.graphics.PorterDuff.Mode.CLEAR);
        Paint paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setAntiAlias(false);
        Rect rect = birdviewmode.getClipBounds();
        birdviewmode.drawBitmap(i, null, rect, paint);
        paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(false);
        if (float1.floatValue() > 1.0001F)
        {
            paint.setFilterBitmap(true);
        }
        float1 = new Rect();
        float1.left = 0;
        float1.top = 0;
        float1.right = bitmap.getWidth();
        float1.bottom = bitmap.getHeight();
        birdviewmode.drawBitmap(bitmap, float1, birdviewmode.getClipBounds(), paint);
        if (view != null)
        {
            k1 = (int)(e * (float)k1);
            l1 = (int)(e * (float)l1);
            i1 = (i1 - k1) / 2;
            j1 = (j1 - l1) / 2;
            view.measure(android.view.View.MeasureSpec.makeMeasureSpec(k1, 0x40000000), android.view.View.MeasureSpec.makeMeasureSpec(l1, 0x40000000));
            view.layout(0, 0, k1, l1);
            birdviewmode.save();
            birdviewmode.translate(i1, j1);
            view.draw(birdviewmode);
            birdviewmode.restore();
        }
        unlockCanvasAndPost(birdviewmode);
    }

    private void a(String s)
    {
        m.b("BirdView", s);
    }

    private Point b(BirdViewMode birdviewmode, int i1, int j1, int k1, int l1)
    {
        j1 = b;
        int i2 = c;
        Point point;
        if (g == null)
        {
            birdviewmode = a;
        } else
        {
            birdviewmode = g;
        }
        point = new Point();
        if (k1 >= ((Point) (birdviewmode)).x - d && k1 <= ((Point) (birdviewmode)).x + j1 + d && l1 >= ((Point) (birdviewmode)).y - d && l1 <= i2 + ((Point) (birdviewmode)).y + d)
        {
            point.x = i1 - ((Point) (birdviewmode)).x - j1;
            point.y = ((Point) (birdviewmode)).y;
            return point;
        } else
        {
            point.x = ((Point) (birdviewmode)).x;
            point.y = ((Point) (birdviewmode)).y;
            return point;
        }
    }

    private void c()
    {
        b = a(180F);
        c = a(180F);
        Display display;
        if (l != null)
        {
            if ((display = ((WindowManager)l.getSystemService("window")).getDefaultDisplay()) != null)
            {
                Point point = new Point();
                display.getSize(point);
                if (point != null)
                {
                    b = (int)((float)point.x / f);
                    c = b;
                    return;
                }
            }
        }
    }

    public void a()
    {
        if (h != null)
        {
            h.recycle();
            h = null;
        }
        if (i != null)
        {
            i.recycle();
            i = null;
        }
        if (j != null)
        {
            j.recycle();
            j = null;
        }
    }

    public void a(BirdViewMode birdviewmode, int i1, int j1, int k1, int l1)
    {
        int i2 = b;
        int j2 = c;
        g = b(birdviewmode, i1, j1, k1, l1);
        birdviewmode = (android.widget.FrameLayout.LayoutParams)getLayoutParams();
        if (g == null || ((android.widget.FrameLayout.LayoutParams) (birdviewmode)).leftMargin != g.x || ((android.widget.FrameLayout.LayoutParams) (birdviewmode)).topMargin != g.y)
        {
            birdviewmode.leftMargin = g.x;
            birdviewmode.topMargin = g.y;
            birdviewmode.width = i2;
            birdviewmode.height = j2;
            setLayoutParams(birdviewmode);
        }
        if (getVisibility() == 4)
        {
            setVisibility(0);
        }
        StatusManager.j().e(true);
    }

    public void a(BirdViewMode birdviewmode, int i1, int j1, int k1, int l1, i i2, float f1, 
            w w1, View view, int j2, int k2)
    {
        if (i2 == null || i2.a == null)
        {
            return;
        } else
        {
            i1 = (int)(((float)i1 - w1.c()) / 2.0F);
            j1 = (int)(((float)j1 - w1.d()) / 2.0F);
            w1 = new Rect();
            RectF rectf = new RectF();
            Canvas canvas = new Canvas(j);
            a(birdviewmode, i2, k1 - i1, l1 - j1, f1, ((Rect) (w1)), rectf);
            a(canvas, i2, f1, ((Rect) (w1)), rectf);
            a(canvas, b, c, f1);
            a(birdviewmode, Float.valueOf(f1), j, b, c, view, j2, k2);
            return;
        }
    }

    public void b()
    {
        g = null;
        setVisibility(4);
        StatusManager.j().e(false);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int i1, int j1)
    {
        k = true;
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int i1, int j1)
    {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }
}
