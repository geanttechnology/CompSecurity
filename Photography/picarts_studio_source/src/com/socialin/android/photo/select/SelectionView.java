// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.select;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.util.Geom;
import com.socialin.android.util.Utils;
import myobfuscated.av.d;
import myobfuscated.cn.a;
import myobfuscated.cn.b;

// Referenced classes of package com.socialin.android.photo.select:
//            SelectionDrawController, j, m, o, 
//            SelectionShapeDrawController, c, e, l

public class SelectionView extends View
{

    private boolean a;
    private SelectionDrawController b;
    private float c;
    private float d;
    private float e;
    private float f;

    public SelectionView(Context context)
    {
        super(context);
        c = 0.0F;
        d = 0.0F;
        e = 0.0F;
        f = 0.0F;
        a(context);
    }

    public SelectionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = 0.0F;
        d = 0.0F;
        e = 0.0F;
        f = 0.0F;
        a(context);
    }

    public SelectionView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c = 0.0F;
        d = 0.0F;
        e = 0.0F;
        f = 0.0F;
        a(context);
    }

    private void a(Context context)
    {
        Utils.a(3F, context);
        if (getResources().getConfiguration().orientation == 1)
        {
            c = getResources().getDimension(0x7f0b001f);
            e = getResources().getDimension(0x7f0b0107);
        } else
        {
            d = getResources().getDimension(0x7f0b0020);
            f = getResources().getDimension(0x7f0b0107);
            if (Inventory.isAdsEnabled())
            {
                e = getResources().getDimension(0x7f0b0105);
                return;
            }
        }
    }

    protected void onDraw(Canvas canvas)
    {
        if (b == null) goto _L2; else goto _L1
_L1:
        Object obj = b;
        if (((SelectionDrawController) (obj)).a != null && !((SelectionDrawController) (obj)).a.isRecycled() && ((SelectionDrawController) (obj)).b != null && !((SelectionDrawController) (obj)).b.isRecycled() && !((Activity)((SelectionDrawController) (obj)).i).isFinishing() && canvas != null) goto _L3; else goto _L2
_L2:
        return;
_L3:
        if (((SelectionDrawController) (obj)).w)
        {
            canvas.drawBitmap(((SelectionDrawController) (obj)).a, ((SelectionDrawController) (obj)).g, ((SelectionDrawController) (obj)).f, ((SelectionDrawController) (obj)).k);
            canvas.translate(((SelectionDrawController) (obj)).y.x - ((SelectionDrawController) (obj)).x.x, ((SelectionDrawController) (obj)).y.y - ((SelectionDrawController) (obj)).x.y);
            canvas.drawBitmap(((SelectionDrawController) (obj)).b, ((SelectionDrawController) (obj)).e, ((SelectionDrawController) (obj)).f, ((SelectionDrawController) (obj)).d);
            return;
        }
        com.socialin.android.photo.select.SelectionDrawController._cls1.a[((SelectionDrawController) (obj)).m.ordinal()];
        JVM INSTR tableswitch 1 4: default 208
    //                   1 209
    //                   2 418
    //                   3 958
    //                   4 1106;
           goto _L4 _L5 _L6 _L7 _L8
_L4:
        return;
_L5:
        j j1 = ((SelectionDrawController) (obj)).q;
        Bitmap bitmap = ((SelectionDrawController) (obj)).a;
        Bitmap bitmap3 = ((SelectionDrawController) (obj)).b;
        Rect rect2 = ((SelectionDrawController) (obj)).e;
        Paint paint = ((SelectionDrawController) (obj)).d;
        obj = ((SelectionDrawController) (obj)).j;
        if (!j1.c.isEmpty())
        {
            canvas.saveLayer(0.0F, 0.0F, canvas.getWidth(), canvas.getHeight(), ((Paint) (obj)), 31);
            canvas.drawBitmap(bitmap, j1.r, j1.q, j1.p);
            canvas.drawBitmap(bitmap3, rect2, j1.q, paint);
            canvas.drawPath(j1.c, j1.m);
            canvas.drawBitmap(bitmap, j1.r, j1.q, j1.n);
            if (!j1.s)
            {
                canvas.drawPath(j1.c, j1.o);
            }
            canvas.restore();
            return;
        } else
        {
            canvas.drawBitmap(bitmap, j1.r, j1.q, j1.p);
            canvas.drawBitmap(bitmap3, rect2, j1.q, paint);
            return;
        }
_L6:
        m m1;
        Bitmap bitmap1;
        Rect rect;
        Bitmap bitmap4;
        canvas.saveLayer(0.0F, 0.0F, canvas.getWidth(), canvas.getHeight(), ((SelectionDrawController) (obj)).j, 4);
        m1 = ((SelectionDrawController) (obj)).p;
        bitmap1 = ((SelectionDrawController) (obj)).a;
        rect = ((SelectionDrawController) (obj)).e;
        bitmap4 = ((SelectionDrawController) (obj)).b;
        obj = ((SelectionDrawController) (obj)).d;
        if (bitmap4 == null || bitmap4.isRecycled()) goto _L10; else goto _L9
_L9:
        Path path;
        canvas.drawBitmap(bitmap1, m1.f, m1.e, m1.w);
        canvas.drawBitmap(bitmap4, rect, m1.e, ((Paint) (obj)));
        path = m1.v.a;
        if (!m1.u) goto _L12; else goto _L11
_L11:
        boolean flag;
        boolean flag1;
        boolean flag2 = false;
        int k = android.os.Build.VERSION.SDK_INT;
        flag = false;
        flag1 = flag2;
        if (k >= 11)
        {
            flag1 = flag2;
            if (m1.q != null)
            {
                flag1 = m1.q.isHardwareAccelerated();
            }
        }
        if (flag1) goto _L12; else goto _L13
_L13:
        canvas.save();
        canvas.clipPath(path);
        flag = true;
_L14:
        canvas.restore();
        if (flag)
        {
            m1.w.setAlpha(m1.t);
            canvas.drawPaint(m1.w);
            m1.w.setAlpha(255);
            canvas.save();
            canvas.clipPath(path);
            canvas.drawBitmap(bitmap1, m1.f, m1.e, m1.w);
            canvas.drawBitmap(bitmap4, rect, m1.e, ((Paint) (obj)));
            canvas.restore();
        }
_L12:
        if (m1.v != null)
        {
            if (m1.z != null)
            {
                m1.v.a(m1.z.a);
            }
            m1.v.a(canvas);
            if (m1.p != null)
            {
                o o1 = m1.p;
                Rect rect3 = m1.f;
                Path path1 = m1.v.a;
                Paint paint1 = m1.v.b;
                Paint paint2 = m1.v.c;
                if (o1.e)
                {
                    canvas.save();
                    canvas.clipRect(o1.b);
                    canvas.translate(o1.f, o1.g);
                    canvas.drawBitmap(bitmap1, rect3, o1.a, o1.d);
                    canvas.drawBitmap(bitmap4, rect, o1.a, ((Paint) (obj)));
                    for (int i = 0; i < 2; i++)
                    {
                        canvas.drawPath(path1, (new Paint[] {
                            paint1, paint2
                        })[i]);
                    }

                    canvas.restore();
                }
            }
        }
        if (m1.c != null)
        {
            m1.c.a(canvas, m1.w);
        }
        if (m1.d != null)
        {
            m1.d.a(canvas, m1.w);
        }
_L10:
        canvas.restore();
        return;
_L7:
        SelectionShapeDrawController selectionshapedrawcontroller = ((SelectionDrawController) (obj)).r;
        Bitmap bitmap2 = ((SelectionDrawController) (obj)).a;
        Rect rect1 = ((SelectionDrawController) (obj)).e;
        Bitmap bitmap5 = ((SelectionDrawController) (obj)).b;
        obj = ((SelectionDrawController) (obj)).d;
        canvas.drawBitmap(bitmap2, selectionshapedrawcontroller.c, selectionshapedrawcontroller.b, selectionshapedrawcontroller.f);
        canvas.drawBitmap(bitmap5, rect1, selectionshapedrawcontroller.b, ((Paint) (obj)));
        if (selectionshapedrawcontroller.e != null)
        {
            if (selectionshapedrawcontroller.s == SelectionShapeDrawController.SelectionShapeType.RECTANGLE)
            {
                canvas.drawRect(selectionshapedrawcontroller.r, selectionshapedrawcontroller.g);
                canvas.drawRect(selectionshapedrawcontroller.r, selectionshapedrawcontroller.h);
                return;
            } else
            {
                canvas.drawOval(selectionshapedrawcontroller.r, selectionshapedrawcontroller.g);
                canvas.drawOval(selectionshapedrawcontroller.r, selectionshapedrawcontroller.h);
                return;
            }
        }
          goto _L2
_L8:
        if (((SelectionDrawController) (obj)).B != 0.0F)
        {
            float f1 = ((SelectionDrawController) (obj)).A.x;
            float f4 = ((SelectionDrawController) (obj)).f.width();
            float f7 = ((SelectionDrawController) (obj)).f.left;
            float f9 = ((SelectionDrawController) (obj)).A.y;
            float f11 = ((SelectionDrawController) (obj)).f.height();
            float f13 = ((SelectionDrawController) (obj)).f.top;
            canvas.rotate(((SelectionDrawController) (obj)).B, f1 * f4 + f7, f9 * f11 + f13);
        }
        canvas.drawBitmap(((SelectionDrawController) (obj)).a, ((SelectionDrawController) (obj)).g, ((SelectionDrawController) (obj)).f, ((SelectionDrawController) (obj)).k);
        obj = ((SelectionDrawController) (obj)).u;
        if (((c) (obj)).n != 0.0F)
        {
            float f2 = ((c) (obj)).o.x;
            float f5 = ((c) (obj)).l.width();
            float f8 = ((c) (obj)).l.left;
            float f10 = ((c) (obj)).o.y;
            float f12 = ((c) (obj)).l.height();
            float f14 = ((c) (obj)).l.top;
            canvas.rotate(((c) (obj)).n, f2 * f5 + f8, f10 * f12 + f14);
        }
        canvas.save();
        float f3;
        float f6;
        if (((c) (obj)).x)
        {
            f3 = -1F;
        } else
        {
            f3 = 1.0F;
        }
        if (((c) (obj)).y)
        {
            f6 = -1F;
        } else
        {
            f6 = 1.0F;
        }
        canvas.scale(f3, f6, ((c) (obj)).l.centerX(), ((c) (obj)).l.centerY());
        canvas.drawBitmap(((c) (obj)).F, ((c) (obj)).m, ((c) (obj)).l, ((c) (obj)).p);
        if (((c) (obj)).s)
        {
            if (((c) (obj)).a == null || ((c) (obj)).c == null || ((c) (obj)).b == null || ((c) (obj)).a.isRecycled() || ((c) (obj)).c.isRecycled() || ((c) (obj)).b.isRecycled())
            {
                canvas.restore();
                return;
            } else
            {
                com.socialin.android.photo.view.a.a(canvas, ((c) (obj)).l, ((c) (obj)).q, ((c) (obj)).r, ((c) (obj)).l.centerX(), ((c) (obj)).l.centerY(), ((c) (obj)).a, ((c) (obj)).b, ((c) (obj)).g, ((c) (obj)).d, ((c) (obj)).d, ((c) (obj)).h, ((c) (obj)).e, ((c) (obj)).e, ((c) (obj)).j);
                canvas.restore();
                com.socialin.android.photo.view.a.a(canvas, ((c) (obj)).l, ((c) (obj)).c, ((c) (obj)).d, ((c) (obj)).d, ((c) (obj)).i, ((c) (obj)).f, ((c) (obj)).f, ((c) (obj)).j);
                return;
            }
        } else
        {
            canvas.restore();
            return;
        }
        UnsupportedOperationException unsupportedoperationexception;
        unsupportedoperationexception;
          goto _L14
    }

    protected void onSizeChanged(int i, int k, int i1, int j1)
    {
        if (b != null)
        {
            b.a(null, false);
        }
        super.onSizeChanged(i, k, i1, j1);
        setWithOrientationDefaultSize(i, k);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        boolean flag1 = true;
        if (a && b != null) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L12:
        return flag;
_L2:
        l l1;
        int i;
        int k;
        l1 = b.s.b;
        i = motionevent.getPointerCount();
        k = motionevent.getActionIndex();
        motionevent.getActionMasked();
        JVM INSTR tableswitch 0 6: default 92
    //                   0 94
    //                   1 590
    //                   2 393
    //                   3 92
    //                   4 92
    //                   5 198
    //                   6 335;
           goto _L3 _L4 _L5 _L6 _L3 _L3 _L7 _L8
_L3:
        return true;
_L4:
        float f1 = motionevent.getX(0);
        float f2 = motionevent.getY(0);
        l1.o.set(f1, f2);
        l1.a = motionevent.getPointerId(0);
        l1.h = true;
        l1.j = true;
        l1.k = false;
        l1.i = true;
        l1.g.postDelayed(new l._cls1(l1, f1, f2), l1.e);
        l1.n = false;
        l1.d.d(l1.o);
        return true;
_L7:
        l1.h = false;
        flag = flag1;
        if (i == 2)
        {
            l1.b = motionevent.getPointerId(k);
            l1.a(motionevent, i, -1);
            PointF pointf = com.socialin.android.photo.select.l.a(motionevent, l1.a);
            motionevent = com.socialin.android.photo.select.l.a(motionevent, l1.b);
            flag = flag1;
            if (pointf != null)
            {
                flag = flag1;
                if (motionevent != null)
                {
                    l1.d.c(pointf);
                    if (l1.k)
                    {
                        l1.d.a();
                    }
                    l1.d.a(pointf, motionevent);
                    l1.j = false;
                    l1.k = true;
                    l1.i = false;
                    return true;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L8:
        if (i == 1)
        {
            flag = flag1;
            if (l1.k)
            {
                l1.d.a();
                l1.k = false;
                return true;
            }
        } else
        {
            flag = flag1;
            if (i > 2)
            {
                l1.a(motionevent, i, k);
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (!l1.k) goto _L10; else goto _L9
_L9:
        boolean flag2;
        boolean flag3;
        flag2 = com.socialin.android.photo.select.l.a(motionevent, l1.a, l1.l);
        flag3 = com.socialin.android.photo.select.l.a(motionevent, l1.b, l1.m);
        if (flag2)
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (!flag3) goto _L12; else goto _L11
_L11:
        l1.d.a(l1.l, l1.m, flag2, flag3);
        return true;
_L10:
        flag = flag1;
        if (l1.j)
        {
            l1.l.set(motionevent.getX(), motionevent.getY());
            if (l1.n)
            {
                l1.d.b(l1.l);
                return true;
            }
            flag = flag1;
            if (Geom.a(l1.l, l1.o) >= l1.c)
            {
                l1.n = true;
                l1.d.a(l1.o);
                l1.d.b(l1.l);
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (l1.k)
        {
            l1.d.a();
            l1.k = false;
            return true;
        }
        if (l1.h && motionevent.getEventTime() - motionevent.getDownTime() <= l1.f)
        {
            new PointF(motionevent.getX(), motionevent.getY());
        }
        flag = flag1;
        if (l1.j)
        {
            l1.d.c(new PointF(motionevent.getX(), motionevent.getY()));
            return true;
        }
        if (true) goto _L12; else goto _L13
_L13:
    }

    public void setDrawController(SelectionDrawController selectiondrawcontroller)
    {
        b = selectiondrawcontroller;
        setWithOrientationDefaultSize(getWidth(), getHeight());
    }

    public void setWithOrientationDefaultSize(float f1, float f2)
    {
        if (b != null)
        {
            f1 -= d + f;
            f2 -= c + e;
            Bitmap bitmap = b.a;
            if (bitmap != null && !bitmap.isRecycled() && f1 > 0.0F && f2 > 0.0F)
            {
                Rect rect = b.g;
                RectF rectf = b.f;
                RectF rectf1 = b.h;
                b.a(true);
                int i = bitmap.getWidth();
                int k = bitmap.getHeight();
                float f3 = Math.min(f1 / (float)i, f2 / (float)k);
                int i1 = Math.round((float)i * f3);
                int j1 = Math.round(f3 * (float)k);
                f1 = (float)(int)((f1 - (float)i1) / 2.0F) + d;
                f2 = (float)(int)((f2 - (float)j1) / 2.0F) + c;
                rect.set(0, 0, i, k);
                rectf.set(f1, f2, (float)i1 + f1, (float)j1 + f2);
                rectf1.set(rectf);
                a = true;
                b.b(true);
                invalidate();
                return;
            }
        }
    }
}
