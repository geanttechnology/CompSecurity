// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.collage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.brushlib.layer.BlendMode;
import com.socialin.android.util.ScaleRotateGestureDetector;
import com.socialin.android.util.c;
import com.socialin.android.util.l;
import com.socialin.android.util.w;
import myobfuscated.bq.a;
import myobfuscated.bq.b;

// Referenced classes of package com.socialin.android.photo.collage:
//            ShapeCropHelper, c

public class ShapeCropView extends View
{

    static final Paint a = new Paint(3);
    public boolean b;
    public RectF c;
    public Bitmap d;
    public RectF e;
    public ShapeCropHelper f;
    private final Matrix g = new Matrix();
    private a h;
    private com.socialin.android.colorpicker.c i;
    private final float j[] = new float[2];
    private com.socialin.android.photo.collage.c k;
    private RectF l;
    private Matrix m;
    private Bitmap n;
    private Path o;
    private RectF p;
    private boolean q;

    public ShapeCropView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        l = new RectF();
        c = new RectF();
        m = new Matrix();
        o = new Path();
        p = new RectF();
        e = new RectF();
        h = new a(getResources(), new b() {

            private ShapeCropView a;

            public final int a(int i1, int j1)
            {
                com.socialin.android.photo.collage.ShapeCropView.c(a).setRectToRect(com.socialin.android.photo.collage.ShapeCropView.a(a), com.socialin.android.photo.collage.ShapeCropView.b(a), android.graphics.Matrix.ScaleToFit.CENTER);
                ShapeCropView.d(a)[0] = i1;
                ShapeCropView.d(a)[1] = j1;
                com.socialin.android.photo.collage.ShapeCropView.c(a).mapPoints(ShapeCropView.d(a));
                if (ShapeCropView.d(a)[0] < 0.0F || ShapeCropView.d(a)[0] >= (float)ShapeCropView.e(a).getWidth() || ShapeCropView.d(a)[1] < 0.0F || ShapeCropView.d(a)[1] >= (float)ShapeCropView.e(a).getHeight())
                {
                    return 0xff000000;
                } else
                {
                    return ShapeCropView.e(a).getPixel((int)ShapeCropView.d(a)[0], (int)ShapeCropView.d(a)[1]);
                }
            }

            
            {
                a = ShapeCropView.this;
                super();
            }
        });
    }

    static RectF a(ShapeCropView shapecropview)
    {
        return shapecropview.e;
    }

    static RectF b(ShapeCropView shapecropview)
    {
        return shapecropview.c;
    }

    static Matrix c(ShapeCropView shapecropview)
    {
        return shapecropview.g;
    }

    static float[] d(ShapeCropView shapecropview)
    {
        return shapecropview.j;
    }

    static Bitmap e(ShapeCropView shapecropview)
    {
        return shapecropview.d;
    }

    public final void a()
    {
        b = true;
        h.a(getWidth() / 2, getHeight() / 2);
        h.a = d.getPixel(d.getWidth() / 2, d.getHeight() / 2);
    }

    public final Bitmap b()
    {
        if (d == null || d.isRecycled())
        {
            return null;
        }
        float f5 = com.socialin.android.util.l.a(m);
        int i1 = f.r;
        float f6 = (float)i1 / f5;
        f.r = (int)Math.ceil(f6);
        RectF rectf = f.d();
        f.r = i1;
        Paint paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.STROKE);
        paint.setStrokeWidth(f6);
        paint.setAlpha(150);
        paint.setAntiAlias(true);
        paint.setColor(f.o);
        Paint paint1 = new Paint(3);
        paint1.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_IN));
        Object obj1 = new Paint(1);
        ((Paint) (obj1)).setStyle(android.graphics.Paint.Style.FILL);
        o.set(f.k);
        float f3 = f.e.width();
        float f4 = f.e.height();
        Object obj = new RectF(f.f);
        Object obj3 = new RectF(f.e);
        int j1 = Math.round(Math.abs(((RectF) (obj)).width()));
        i1 = Math.round(Math.abs(((RectF) (obj)).height()));
        float f1;
        float f2;
        Object obj2;
        if (((RectF) (obj)).width() < 0.0F)
        {
            f1 = -1F;
        } else
        {
            f1 = 1.0F;
        }
        if (((RectF) (obj)).height() < 0.0F)
        {
            f2 = -1F;
        } else
        {
            f2 = 1.0F;
        }
        obj2 = new Matrix();
        ((Matrix) (obj2)).setScale(f1, f2, f3 / 2.0F, f4 / 2.0F);
        o.transform(((Matrix) (obj2)));
        j1 = Math.max((int)(c.width() * ((float)j1 / e.width())), 1);
        i1 = Math.max((int)(c.height() * ((float)i1 / e.height())), 1);
        if (((RectF) (obj)).left < ((RectF) (obj)).right)
        {
            f3 = ((RectF) (obj)).left;
        } else
        {
            f3 = ((RectF) (obj)).right;
        }
        if (((RectF) (obj)).top < ((RectF) (obj)).bottom)
        {
            f4 = ((RectF) (obj)).top;
        } else
        {
            f4 = ((RectF) (obj)).bottom;
        }
        f3 = (f3 - e.left) / f5;
        f4 = (f4 - e.top) / f5;
        obj = com.socialin.android.util.c.a(j1, i1, android.graphics.Bitmap.Config.ARGB_8888);
        if (obj == null)
        {
            return null;
        }
        Canvas canvas = new Canvas(((Bitmap) (obj)));
        ((Matrix) (obj2)).setScale((float)j1 / ((RectF) (obj3)).width(), (float)i1 / ((RectF) (obj3)).height());
        ((Matrix) (obj2)).postScale(f1, f2, j1 / 2, i1 / 2);
        obj3 = new Path();
        f.k.transform(((Matrix) (obj2)), ((Path) (obj3)));
        canvas.drawPath(((Path) (obj3)), ((Paint) (obj1)));
        obj1 = com.socialin.android.util.c.a((int)((float)j1 + (rectf.left + rectf.right) / f5), (int)((float)i1 + (rectf.top + rectf.bottom) / f5), android.graphics.Bitmap.Config.ARGB_8888);
        if (obj1 == null)
        {
            ((Bitmap) (obj)).recycle();
            return null;
        }
        obj2 = new Canvas(((Bitmap) (obj1)));
        ((Canvas) (obj2)).translate(rectf.left / f5, rectf.top / f5);
        ((Canvas) (obj2)).drawBitmap(((Bitmap) (obj)), 0.0F, 0.0F, a);
        ((Canvas) (obj2)).drawBitmap(d, -f3, -f4, paint1);
        if (f6 > 0.0F)
        {
            ((Canvas) (obj2)).drawPath(((Path) (obj3)), paint);
        }
        ((Bitmap) (obj)).recycle();
        return ((Bitmap) (obj1));
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (q && d != null && !d.isRecycled())
        {
            canvas.drawBitmap(n, null, e, a);
            if (!b)
            {
                f.a(canvas, true);
                f.c = k;
            }
        }
        if (b)
        {
            h.a(canvas);
        }
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        l.set(getPaddingLeft(), getPaddingTop(), i1 - getPaddingRight(), j1 - getPaddingBottom());
        m.setRectToRect(c, l, android.graphics.Matrix.ScaleToFit.CENTER);
        com.socialin.android.util.l.a(c, l, e);
        ShapeCropHelper shapecrophelper = f;
        RectF rectf = e;
        shapecrophelper.j.set(rectf);
        com.socialin.android.util.l.b(e, p);
        f.a(p);
        q = true;
        if (i1 != 0 && j1 != 0 && b)
        {
            a();
        }
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        if (b) goto _L2; else goto _L1
_L1:
        ShapeCropHelper shapecrophelper;
        int i1;
        int j1;
        int k1;
        shapecrophelper = f;
        i1 = motionevent.getAction();
        j1 = (int)motionevent.getX();
        k1 = (int)motionevent.getY();
        shapecrophelper.m.a(motionevent);
        i1;
        JVM INSTR tableswitch 0 2: default 72
    //                   0 78
    //                   1 425
    //                   2 274;
           goto _L3 _L4 _L5 _L6
_L3:
        invalidate();
        return true;
_L4:
        float f1 = j1;
        float f4 = k1;
        shapecrophelper.g.set(shapecrophelper.f);
        shapecrophelper.f.sort();
        boolean flag = shapecrophelper.f.contains(f1, f4);
        shapecrophelper.f.set(shapecrophelper.g);
        if (flag)
        {
            shapecrophelper.d = ShapeCropHelper.Action.DRAG;
            shapecrophelper.l = true;
            shapecrophelper.a(f1, f4);
        } else
        {
            shapecrophelper.h.set(shapecrophelper.i);
            shapecrophelper.h.offsetTo(shapecrophelper.f.right - shapecrophelper.i.width() / 2.0F, shapecrophelper.f.bottom - shapecrophelper.i.height() / 2.0F);
            if (shapecrophelper.h.contains(f1, f4))
            {
                shapecrophelper.d = ShapeCropHelper.Action.HANDLE_ZOOM;
                shapecrophelper.l = true;
                shapecrophelper.a(f1, f4);
            } else
            {
                shapecrophelper.d = ShapeCropHelper.Action.NONE;
                shapecrophelper.l = false;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (shapecrophelper.d != ShapeCropHelper.Action.DRAG && shapecrophelper.d != ShapeCropHelper.Action.HANDLE_ZOOM) goto _L8; else goto _L7
_L7:
        float f7;
        float f9;
        float f2 = j1;
        float f5 = k1;
        f7 = f2 - shapecrophelper.u.x;
        f9 = f5 - shapecrophelper.u.y;
        shapecrophelper.u.set(f2, f5);
        com.socialin.android.photo.collage.ShapeCropHelper._cls2.a[shapecrophelper.d.ordinal()];
        JVM INSTR tableswitch 1 2: default 372
    //                   1 381
    //                   2 402;
           goto _L8 _L9 _L10
_L8:
        shapecrophelper.l = false;
        continue; /* Loop/switch isn't completed */
_L9:
        shapecrophelper.f.offset(f7, f9);
        shapecrophelper.a(false);
          goto _L8
_L10:
        shapecrophelper.f.inset(-f7, -f9);
        shapecrophelper.a(false);
          goto _L8
_L5:
        shapecrophelper.l = true;
        shapecrophelper.a();
        if (shapecrophelper.a != (double)shapecrophelper.f.height() || shapecrophelper.b != (double)shapecrophelper.f.width())
        {
            shapecrophelper.a = shapecrophelper.f.height();
            shapecrophelper.b = shapecrophelper.f.width();
            if (shapecrophelper.c != null)
            {
                shapecrophelper.c.a();
            }
        }
        if (true) goto _L3; else goto _L2
_L2:
        if (motionevent.getActionMasked() == 1)
        {
            i.a(h.a);
            b = false;
            invalidate();
            return true;
        }
        float f6 = motionevent.getX();
        float f8 = motionevent.getY();
        float f3;
        if (f6 > e.right)
        {
            f3 = e.right;
        } else
        {
            f3 = f6;
            if (f6 < e.left)
            {
                f3 = e.left;
            }
        }
        if (f8 < e.top)
        {
            f6 = e.top;
        } else
        {
            f6 = f8;
            if (f8 > e.bottom)
            {
                f6 = e.bottom;
            }
        }
        h.a(motionevent.getActionMasked(), f3, f6);
        invalidate();
        return true;
    }

    public void setBlendMode(BlendMode blendmode)
    {
        f.t = blendmode;
        invalidate();
    }

    public void setBorderColor(int i1)
    {
        f.o = i1;
        invalidate();
    }

    public void setBorderSize(int i1)
    {
        f.r = i1;
        invalidate();
    }

    public void setColorSelectedListener(com.socialin.android.colorpicker.c c1)
    {
        i = c1;
    }

    public void setEditMode(ShapeCropHelper.EditMode editmode)
    {
    }

    public void setEyeDropperActive(boolean flag)
    {
        b = flag;
    }

    public void setInverted(boolean flag)
    {
        f.s = flag;
        invalidate();
    }

    public void setOrigBitmap(Bitmap bitmap)
    {
        d = bitmap;
        n = w.f(bitmap, 2048);
        int i1 = d.getWidth();
        int j1 = d.getHeight();
        c.set(0.0F, 0.0F, i1, j1);
    }

    public void setOverlayAlpha(int i1)
    {
        f.q = i1;
        invalidate();
    }

    public void setOverlayColor(int i1)
    {
        f.a(i1);
        invalidate();
    }

    public void setOverlayImage(Bitmap bitmap)
    {
        f.a(bitmap);
        invalidate();
    }

    public void setResizeCallBack(com.socialin.android.photo.collage.c c1)
    {
        k = c1;
    }

    public void setShapeCropHelper(ShapeCropHelper shapecrophelper)
    {
        f = shapecrophelper;
    }

    public void setShapeRes(int i1)
    {
        ShapeCropHelper shapecrophelper = f;
        Context context = getContext();
        shapecrophelper.n = i1;
        shapecrophelper.a(context);
        com.socialin.android.util.l.b(e, p);
        f.a(p);
        invalidate();
    }

}
