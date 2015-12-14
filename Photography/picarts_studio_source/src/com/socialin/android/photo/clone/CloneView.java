// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.clone;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.photo.gpu.g;
import com.picsart.effectnew.RectangleF;
import myobfuscated.bw.a;
import myobfuscated.bw.d;
import myobfuscated.bw.e;
import myobfuscated.dc.b;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.photo.clone:
//            a, b

public class CloneView extends View
{

    private Rect a;
    private RectF b;
    private RectangleF c;
    private Bitmap d;
    private int e;
    private int f;
    private float g;
    private float h;
    private boolean i;
    private a j;
    private g k;

    public CloneView(Context context)
    {
        super(context);
        a = new Rect();
        b = new RectF();
        c = new RectangleF();
        e = 0;
        f = 0;
        g = 0.7F;
        h = 5F;
        i = false;
        new Paint(2);
    }

    public CloneView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new Rect();
        b = new RectF();
        c = new RectangleF();
        e = 0;
        f = 0;
        g = 0.7F;
        h = 5F;
        i = false;
        new Paint(2);
    }

    public CloneView(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        a = new Rect();
        b = new RectF();
        c = new RectangleF();
        e = 0;
        f = 0;
        g = 0.7F;
        h = 5F;
        i = false;
        new Paint(2);
    }

    public final boolean a(MotionEvent motionevent)
    {
        if (!i) goto _L2; else goto _L1
_L1:
        float f1;
        f1 = g;
        if (k == null);
        if (!myobfuscated.dc.b.a().a(motionevent, c, b, h, f1)) goto _L4; else goto _L3
_L3:
        if (k != null)
        {
            g g1 = k;
            if (g1.i)
            {
                g1.a();
                g1.i = false;
                g1.j = false;
            }
            int l = motionevent.getAction() & 0xff;
            if (l == 6 || l == 1)
            {
                motionevent.getPointerCount();
            }
        }
        invalidate();
_L2:
        return true;
_L4:
        if (k == null) goto _L2; else goto _L5
_L5:
        g g2 = k;
        switch (motionevent.getAction())
        {
        default:
            return true;

        case 0: // '\0'
            motionevent.getX();
            motionevent.getY();
            throw new NullPointerException();

        case 2: // '\002'
            float f2 = motionevent.getX();
            float f3 = motionevent.getY();
            if (CloneDrawController.Mode.SOURCE == null)
            {
                g2.l.a((int)f2, (int)f3);
                g2.m.invalidate(g2.l.a());
                return true;
            }
            if (CloneDrawController.Mode.CLONE == null && g2.i)
            {
                throw new NullPointerException();
            }
            break;

        case 1: // '\001'
        case 3: // '\003'
            if (g2.i && g2.j)
            {
                g2.a();
            }
            g2.i = false;
            g2.j = false;
            g2.l.h = false;
            g2.m.invalidate(g2.l.a());
            return true;
        }
        if (true) goto _L2; else goto _L6
_L6:
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        Bitmap bitmap = d;
        boolean flag;
        if (bitmap != null && !bitmap.isRecycled())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && k != null)
        {
            Object obj = k;
            Rect rect = a;
            if (((g) (obj)).h)
            {
                if (CloneDrawController.Mode.SOURCE == null)
                {
                    canvas.drawBitmap(((g) (obj)).b, rect, ((g) (obj)).k, null);
                } else
                {
                    ((g) (obj)).c.setStrokeWidth(((g) (obj)).e.a);
                    ((g) (obj)).c.setMaskFilter(((g) (obj)).e.a(((g) (obj)).c.getStrokeWidth()));
                    canvas.drawBitmap(((g) (obj)).b, null, ((g) (obj)).k, null);
                    if (((g) (obj)).e.b > 0)
                    {
                        ((g) (obj)).d.setAlpha(((g) (obj)).e.b);
                        canvas.drawBitmap(((g) (obj)).b, null, ((g) (obj)).k, ((g) (obj)).d);
                        ((g) (obj)).d.setAlpha(255);
                    }
                    canvas.save();
                    canvas.clipRect(null);
                    canvas.drawPath(new Path(null), ((g) (obj)).c);
                    canvas.restore();
                    canvas.drawBitmap(((g) (obj)).a, null, ((g) (obj)).k, ((g) (obj)).d);
                }
                ((g) (obj)).l.e = ((g) (obj)).e.a / 2;
                obj = ((g) (obj)).l;
                if (((com.socialin.android.photo.clone.a) (obj)).h)
                {
                    Point point = ((com.socialin.android.photo.clone.a) (obj)).b;
                    ((com.socialin.android.photo.clone.a) (obj)).d.setColor(-1);
                    ((com.socialin.android.photo.clone.a) (obj)).d.setStrokeWidth(((com.socialin.android.photo.clone.a) (obj)).f);
                    canvas.drawCircle(point.x, point.y, (float)((com.socialin.android.photo.clone.a) (obj)).e - ((com.socialin.android.photo.clone.a) (obj)).f / 2.0F, ((com.socialin.android.photo.clone.a) (obj)).d);
                    ((com.socialin.android.photo.clone.a) (obj)).d.setColor(Color.argb(204, 0, 0, 0));
                    ((com.socialin.android.photo.clone.a) (obj)).d.setStrokeWidth((((com.socialin.android.photo.clone.a) (obj)).f * 2.0F) / 3F);
                    canvas.drawCircle(point.x, point.y, (float)((com.socialin.android.photo.clone.a) (obj)).e - ((com.socialin.android.photo.clone.a) (obj)).f / 3F - ((com.socialin.android.photo.clone.a) (obj)).f, ((com.socialin.android.photo.clone.a) (obj)).d);
                    ((com.socialin.android.photo.clone.a) (obj)).d.setColor(0xff000000);
                    ((com.socialin.android.photo.clone.a) (obj)).d.setStrokeWidth(((com.socialin.android.photo.clone.a) (obj)).g);
                    canvas.drawLine(point.x - ((com.socialin.android.photo.clone.a) (obj)).e / 6, (float)point.y - ((com.socialin.android.photo.clone.a) (obj)).g / 2.0F, point.x + ((com.socialin.android.photo.clone.a) (obj)).e / 6, (float)point.y - ((com.socialin.android.photo.clone.a) (obj)).g / 2.0F, ((com.socialin.android.photo.clone.a) (obj)).d);
                    canvas.drawLine((float)point.x - ((com.socialin.android.photo.clone.a) (obj)).g / 2.0F, point.y - ((com.socialin.android.photo.clone.a) (obj)).e / 6, (float)point.x - ((com.socialin.android.photo.clone.a) (obj)).g / 2.0F, point.y + ((com.socialin.android.photo.clone.a) (obj)).e / 6, ((com.socialin.android.photo.clone.a) (obj)).d);
                    ((com.socialin.android.photo.clone.a) (obj)).d.setColor(-1);
                    float f1 = point.x - ((com.socialin.android.photo.clone.a) (obj)).e / 6;
                    float f2 = point.y;
                    float f3 = ((com.socialin.android.photo.clone.a) (obj)).g / 2.0F;
                    float f4 = point.x + ((com.socialin.android.photo.clone.a) (obj)).e / 6;
                    float f5 = point.y;
                    canvas.drawLine(f1, f3 + f2, f4, ((com.socialin.android.photo.clone.a) (obj)).g / 2.0F + f5, ((com.socialin.android.photo.clone.a) (obj)).d);
                    f1 = point.x;
                    f2 = ((com.socialin.android.photo.clone.a) (obj)).g / 2.0F;
                    f3 = point.y - ((com.socialin.android.photo.clone.a) (obj)).e / 6;
                    f4 = point.x;
                    canvas.drawLine(f2 + f1, f3, ((com.socialin.android.photo.clone.a) (obj)).g / 2.0F + f4, point.y + ((com.socialin.android.photo.clone.a) (obj)).e / 6, ((com.socialin.android.photo.clone.a) (obj)).d);
                    if (((com.socialin.android.photo.clone.a) (obj)).i == CloneDrawController.Mode.CLONE)
                    {
                        canvas = ((com.socialin.android.photo.clone.a) (obj)).c;
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
            g g1 = k;
            if (g1.i)
            {
                g1.a();
                g1.i = false;
                g1.j = false;
            }
        }
        setWithOrientationDefaultSize(l, i1);
    }

    public void setDrawController$5938f3fb(g g1)
    {
        k = g1;
        g1.m = this;
    }

    public void setOrigBitmap(Bitmap bitmap)
    {
        d = bitmap;
        if (d != null && !d.isRecycled())
        {
            e = bitmap.getWidth();
            f = bitmap.getHeight();
            setWithOrientationDefaultSize(getWidth(), getHeight());
        }
    }

    public void setWithOrientationDefaultSize(int l, int i1)
    {
        if (d != null && !d.isRecycled() && l > 0 && i1 > 0)
        {
            float f1 = Math.min((float)l / (float)e, (float)i1 / (float)f);
            int j1 = Math.round((float)e * f1);
            int k1 = Math.round(f1 * (float)f);
            int l1 = (int)((double)(l - j1) / 2D);
            int i2 = (int)((double)(i1 - k1) / 2D);
            a.set(0, 0, e, f);
            c.set(l1, i2, l1 + j1, i2 + k1);
            b.set(c);
            i = true;
            h = Math.max((float)l / (float)j1, (float)i1 / (float)k1) * 1.2F;
            h = Math.max(h, 5F);
            if (k != null)
            {
                g g1 = k;
                g1.k = c;
                g1.h = true;
                g1 = k;
                l = getWidth() / 2;
                i1 = getHeight() / 2;
                if (g1.l == null)
                {
                    g1.l = new com.socialin.android.photo.clone.a(g1.m.getContext(), new Point(l, i1));
                } else
                {
                    g1.l.a(l, i1);
                }
            }
            invalidate();
        }
    }

    public void setupSpenTouch()
    {
        j = m.f();
        j.a(this, new e() {

            private CloneView a;

            public final boolean a(MotionEvent motionevent)
            {
                a.a(motionevent);
                return true;
            }

            public final boolean b(MotionEvent motionevent)
            {
                return a.a(motionevent);
            }

            public final boolean c(MotionEvent motionevent)
            {
                return a.a(motionevent);
            }

            public final void d(MotionEvent motionevent)
            {
            }

            
            {
                a = CloneView.this;
                super();
            }
        });
        if (myobfuscated.bw.a.a())
        {
            j.a(this, new d() {

                public final void a()
                {
                }

                public final boolean a(View view, MotionEvent motionevent)
                {
                    return false;
                }

            });
        }
    }
}
