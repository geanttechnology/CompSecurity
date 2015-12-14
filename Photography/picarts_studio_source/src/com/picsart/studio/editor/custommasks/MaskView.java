// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.custommasks;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.picsart.effectnew.EffectsDrawController;
import com.picsart.effectnew.MaskBrushNew;
import com.picsart.effectnew.RectangleF;
import com.picsart.effectnew.e;
import myobfuscated.bw.a;
import myobfuscated.bw.d;
import myobfuscated.dc.b;
import myobfuscated.f.m;

public class MaskView extends View
{

    private RectF a;
    private RectangleF b;
    private Rect c;
    private Bitmap d;
    private boolean e;
    private int f;
    private int g;
    private float h;
    private float i;
    private a j;
    private e k;

    public MaskView(Context context)
    {
        super(context);
        a = new RectF();
        b = new RectangleF();
        c = new Rect();
        e = false;
        f = 0;
        g = 0;
        h = 0.7F;
        i = 5F;
        new Paint(2);
        setLayerType(1, null);
    }

    public MaskView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new RectF();
        b = new RectangleF();
        c = new Rect();
        e = false;
        f = 0;
        g = 0;
        h = 0.7F;
        i = 5F;
        new Paint(2);
        setLayerType(1, null);
    }

    public MaskView(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        a = new RectF();
        b = new RectangleF();
        c = new Rect();
        e = false;
        f = 0;
        g = 0;
        h = 0.7F;
        i = 5F;
        new Paint(2);
        setLayerType(1, null);
    }

    static e a(MaskView maskview)
    {
        return maskview.k;
    }

    private static boolean a(Bitmap bitmap)
    {
        return bitmap != null && !bitmap.isRecycled();
    }

    public final boolean a(MotionEvent motionevent)
    {
        if (!e) goto _L2; else goto _L1
_L1:
        float f1;
        k.c.q();
        f1 = h;
        if (!myobfuscated.dc.b.a().a(motionevent, b, a, i, f1)) goto _L4; else goto _L3
_L3:
        e e1 = k;
        e1.a(false);
        if (e1.d)
        {
            e1.c.o();
            e1.d = false;
            e1.e = false;
        }
        int l = motionevent.getAction() & 0xff;
        if (l == 6 || l == 1)
        {
            motionevent.getPointerCount();
        }
        k.c.r();
        invalidate();
_L2:
        return true;
_L4:
        e e2;
        if (!a(k.c.f) || k.c.g == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        e2 = k;
        if (!e2.h)
        {
            break; /* Loop/switch isn't completed */
        }
        float f2 = motionevent.getX();
        float f5 = motionevent.getY();
        float f8;
        switch (motionevent.getAction())
        {
        case 1: // '\001'
        default:
            return true;

        case 0: // '\0'
            e2.b.set(f2, f5);
            return true;

        case 2: // '\002'
            f8 = f2 - e2.b.x;
            break;
        }
        float f10 = f5 - e2.b.y;
        e2.c.q();
        if (Math.sqrt(f8 * f8 + f10 * f10) >= (double)e2.g)
        {
            motionevent = e2.i;
            motionevent.left = ((RectangleF) (motionevent)).left + f8;
            motionevent = e2.i;
            motionevent.right = f8 + ((RectangleF) (motionevent)).right;
            motionevent = e2.i;
            motionevent.top = ((RectangleF) (motionevent)).top + f10;
            motionevent = e2.i;
            motionevent.bottom = f10 + ((RectangleF) (motionevent)).bottom;
            e2.b.set(f2, f5);
            e2.c.r();
            e2.c();
            return true;
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (e2.l)
        {
            e2.n.x = motionevent.getX();
            e2.n.y = motionevent.getY();
            e2.m = true;
        }
        switch (motionevent.getAction())
        {
        default:
            return true;

        case 0: // '\0'
            e2.c.a(motionevent.getX(), motionevent.getY());
            float f3 = motionevent.getX();
            float f6 = motionevent.getY();
            e2.b.set(f3, f6);
            e2.d = true;
            e2.e = false;
            return true;

        case 2: // '\002'
            if (e2.d)
            {
                float f4 = motionevent.getX();
                float f7 = motionevent.getY();
                float f9 = f4 - e2.b.x;
                float f11 = f7 - e2.b.y;
                if (!e2.e && Math.abs(Math.sqrt(f9 * f9 + f11 * f11)) >= (double)e2.f)
                {
                    e2.c.b(e2.b.x, e2.b.y);
                    e2.e = true;
                }
                if (e2.e && Math.abs(Math.sqrt(f9 * f9 + f11 * f11)) >= (double)e2.g)
                {
                    e2.c.c(f4, f7);
                    e2.e = true;
                    e2.b.set(f4, f7);
                    return true;
                }
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            if (e2.d && e2.e)
            {
                e2.c.n();
            }
            e2.d = false;
            e2.e = false;
            return true;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (a(k.c.f) && k.c.g != null)
        {
            e e1 = k;
            Rect rect = c;
            if (e1.k != null)
            {
                e1.c.a(canvas, rect);
                if (e1.m && e1.c.m == com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH)
                {
                    MaskBrushNew maskbrushnew = e1.b();
                    if (maskbrushnew.v == com.picsart.effectnew.MaskBrushNew.BrushDrawMode.ERASE)
                    {
                        float f1 = maskbrushnew.f.getStrokeWidth();
                        f1 = (maskbrushnew.d + f1) / 2.0F;
                        canvas.drawCircle(e1.n.x, e1.n.y, f1, e1.o);
                    }
                }
            }
        }
    }

    protected void onSizeChanged(int l, int i1, int j1, int k1)
    {
        super.onSizeChanged(l, i1, j1, k1);
        if (k != null)
        {
            e e1 = k;
            if (e1.d)
            {
                e1.c.p();
                e1.d = false;
                e1.e = false;
            }
        }
        setWithOrientationDefaultSize(l, i1);
    }

    public void setDrawController(e e1)
    {
        k = e1;
        e1.a = this;
        e1.c.c = this;
    }

    public void setOrigBitmap(Bitmap bitmap)
    {
        d = bitmap;
        if (d != null && !d.isRecycled())
        {
            f = bitmap.getWidth();
            g = bitmap.getHeight();
            setWithOrientationDefaultSize(getWidth(), getHeight());
        }
    }

    public void setWithOrientationDefaultSize(int l, int i1)
    {
        if (d != null && !d.isRecycled() && l > 0 && i1 > 0)
        {
            float f1;
            int j1;
            int k1;
            int l1;
            int i2;
            boolean flag;
            if (k != null)
            {
                boolean flag1 = k.j;
                flag = flag1;
                if (flag1)
                {
                    k.c.q();
                    flag = flag1;
                }
            } else
            {
                flag = false;
            }
            f1 = Math.min((float)l / (float)f, (float)i1 / (float)g);
            j1 = Math.round((float)f * f1);
            k1 = Math.round(f1 * (float)g);
            l1 = (l - j1) / 2;
            i2 = (i1 - k1) / 2;
            c.set(0, 0, f, g);
            b.set(l1, i2, l1 + j1, i2 + k1);
            a.set(b);
            e = true;
            i = Math.max((float)l / (float)j1, (float)i1 / (float)k1) * 1.2F;
            i = Math.max(i, 5F);
            if (k != null)
            {
                Object obj = k;
                Object obj1 = b;
                obj.i = ((RectangleF) (obj1));
                ((e) (obj)).c.a = ((RectF) (obj1));
                obj.j = true;
                obj = k;
                obj1 = a;
                ((e) (obj)).c.b = ((RectF) (obj1));
                obj = k.c;
                if (obj != null)
                {
                    ((EffectsDrawController) (obj)).a(a.width());
                }
                if (flag)
                {
                    k.c.r();
                }
            }
            invalidate();
        }
    }

    public void setupSpenTouch()
    {
        j = m.f();
        j.a(this, new myobfuscated.bw.e() {

            private MaskView a;

            public final boolean a(MotionEvent motionevent)
            {
                if (com.picsart.studio.editor.custommasks.MaskView.a(a) != null)
                {
                    com.picsart.studio.editor.custommasks.MaskView.a(a).l = false;
                }
                a.a(motionevent);
                return true;
            }

            public final boolean b(MotionEvent motionevent)
            {
                if (com.picsart.studio.editor.custommasks.MaskView.a(a) != null)
                {
                    com.picsart.studio.editor.custommasks.MaskView.a(a).l = true;
                }
                return a.a(motionevent);
            }

            public final boolean c(MotionEvent motionevent)
            {
                if (com.picsart.studio.editor.custommasks.MaskView.a(a) != null)
                {
                    com.picsart.studio.editor.custommasks.MaskView.a(a).l = true;
                    if (com.picsart.studio.editor.custommasks.MaskView.a(a).b().v == com.picsart.effectnew.MaskBrushNew.BrushDrawMode.DRAW)
                    {
                        Object obj = com.picsart.studio.editor.custommasks.MaskView.a(a);
                        if (((e) (obj)).k == null || !((e) (obj)).e && !((e) (obj)).h && ((e) (obj)).c.m == com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH)
                        {
                            obj = com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH;
                        }
                    }
                }
                return a.a(motionevent);
            }

            public final void d(MotionEvent motionevent)
            {
                if (com.picsart.studio.editor.custommasks.MaskView.a(a) != null)
                {
                    com.picsart.studio.editor.custommasks.MaskView.a(a).d();
                }
            }

            
            {
                a = MaskView.this;
                super();
            }
        });
        if (myobfuscated.bw.a.a())
        {
            j.a(this, new d() {

                private MaskView a;

                public final void a()
                {
                    if (com.picsart.studio.editor.custommasks.MaskView.a(a) != null)
                    {
                        com.picsart.studio.editor.custommasks.MaskView.a(a).d();
                    }
                }

                public final boolean a(View view, MotionEvent motionevent)
                {
                    if (com.picsart.studio.editor.custommasks.MaskView.a(a) == null)
                    {
                        return false;
                    }
                    view = com.picsart.studio.editor.custommasks.MaskView.a(a);
                    if (motionevent.getAction() != 10 && !((e) (view)).h && ((e) (view)).c.m == com.picsart.effectnew.EffectsDrawController.EffectsDrawMode.BRUSH)
                    {
                        view.l = true;
                        view.a(true);
                        float f1 = motionevent.getX();
                        float f2 = motionevent.getY();
                        ((e) (view)).n.x = f1;
                        ((e) (view)).n.y = f2;
                    } else
                    {
                        view.l = true;
                        view.a(false);
                    }
                    view.c();
                    return false;
                }

            
            {
                a = MaskView.this;
                super();
            }
            });
        }
    }
}
