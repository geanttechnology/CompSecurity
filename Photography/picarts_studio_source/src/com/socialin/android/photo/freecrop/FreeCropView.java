// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.freecrop;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.socialin.android.apiv3.util.Inventory;
import com.socialin.android.photo.select.o;
import com.socialin.android.util.l;
import myobfuscated.cn.a;
import myobfuscated.cn.b;

// Referenced classes of package com.socialin.android.photo.freecrop:
//            FreeCropDrawController, e

public class FreeCropView extends View
{

    private boolean a;
    private FreeCropDrawController b;
    private float c;
    private float d;

    public FreeCropView(Context context)
    {
        super(context);
        c = 0.0F;
        d = 0.0F;
        a();
    }

    public FreeCropView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c = 0.0F;
        d = 0.0F;
        a();
    }

    public FreeCropView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c = 0.0F;
        d = 0.0F;
        a();
    }

    private void a()
    {
        if (getResources().getConfiguration().orientation == 1)
        {
            c = getResources().getDimension(0x7f0b0107);
        } else
        {
            d = getResources().getDimension(0x7f0b0107);
            if (Inventory.isAdsEnabled())
            {
                c = getResources().getDimension(0x7f0b0105);
                return;
            }
        }
    }

    protected void onDraw(Canvas canvas)
    {
        e e1;
        Object obj;
        Path path;
        boolean flag;
label0:
        {
            flag = false;
            super.onDraw(canvas);
            if (b != null)
            {
                obj = b;
                if (((FreeCropDrawController) (obj)).o != null && !((FreeCropDrawController) (obj)).o.isRecycled() && !((FreeCropDrawController) (obj)).u.isFinishing() && canvas != null)
                {
                    break label0;
                }
            }
            return;
        }
        if (((FreeCropDrawController) (obj)).C == FreeCropDrawController.DrawMode.FreeCrop)
        {
            if (!((FreeCropDrawController) (obj)).c.isEmpty())
            {
                canvas.saveLayer(0.0F, 0.0F, canvas.getWidth(), canvas.getHeight(), ((FreeCropDrawController) (obj)).v, 4);
                canvas.drawBitmap(((FreeCropDrawController) (obj)).o, ((FreeCropDrawController) (obj)).t, ((FreeCropDrawController) (obj)).s, ((FreeCropDrawController) (obj)).A);
                canvas.drawPath(((FreeCropDrawController) (obj)).c, ((FreeCropDrawController) (obj)).x);
                if (((FreeCropDrawController) (obj)).n != null && !((FreeCropDrawController) (obj)).n.isRecycled())
                {
                    canvas.drawBitmap(((FreeCropDrawController) (obj)).n, ((FreeCropDrawController) (obj)).t, ((FreeCropDrawController) (obj)).s, ((FreeCropDrawController) (obj)).y);
                }
                if (!((FreeCropDrawController) (obj)).w)
                {
                    canvas.drawPath(((FreeCropDrawController) (obj)).c, ((FreeCropDrawController) (obj)).z);
                }
                canvas.restore();
                return;
            } else
            {
                canvas.drawBitmap(((FreeCropDrawController) (obj)).o, ((FreeCropDrawController) (obj)).t, ((FreeCropDrawController) (obj)).s, ((FreeCropDrawController) (obj)).A);
                return;
            }
        }
        canvas.saveLayer(0.0F, 0.0F, canvas.getWidth(), canvas.getHeight(), ((FreeCropDrawController) (obj)).v, 4);
        e1 = ((FreeCropDrawController) (obj)).E;
        obj = ((FreeCropDrawController) (obj)).o;
        if (obj == null || ((Bitmap) (obj)).isRecycled())
        {
            break MISSING_BLOCK_LABEL_620;
        }
        canvas.drawBitmap(((Bitmap) (obj)), e1.f, e1.e, e1.w);
        path = e1.v.a;
        if (!e1.u) goto _L2; else goto _L1
_L1:
        UnsupportedOperationException unsupportedoperationexception;
        int i;
        boolean flag1;
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            flag1 = e1.q.isHardwareAccelerated();
        } else
        {
            flag1 = false;
        }
        if (flag1) goto _L2; else goto _L3
_L3:
        canvas.save();
        canvas.clipPath(path);
        i = 1;
_L5:
        canvas.restore();
        if (i != 0)
        {
            e1.w.setAlpha(e1.t);
            canvas.drawPaint(e1.w);
            e1.w.setAlpha(255);
            canvas.save();
            canvas.clipPath(path);
            canvas.drawBitmap(((Bitmap) (obj)), e1.f, e1.e, e1.w);
            canvas.restore();
        }
_L2:
        if (e1.v == null)
        {
            break MISSING_BLOCK_LABEL_582;
        }
        if (e1.z != null)
        {
            e1.v.a(e1.z.a);
        }
        e1.v.a(canvas);
        if (e1.p == null)
        {
            break MISSING_BLOCK_LABEL_582;
        }
        o o1 = e1.p;
        Rect rect = e1.f;
        Path path1 = e1.v.a;
        Paint paint = e1.v.b;
        Paint paint1 = e1.v.c;
        if (!o1.e)
        {
            break MISSING_BLOCK_LABEL_582;
        }
        canvas.save();
        canvas.clipRect(o1.b);
        canvas.translate(o1.f, o1.g);
        canvas.drawBitmap(((Bitmap) (obj)), rect, o1.a, o1.d);
        for (i = ((flag) ? 1 : 0); i < 2; i++)
        {
            canvas.drawPath(path1, (new Paint[] {
                paint, paint1
            })[i]);
        }

        break; /* Loop/switch isn't completed */
        unsupportedoperationexception;
        i = 0;
        if (true) goto _L5; else goto _L4
_L4:
        canvas.restore();
        if (e1.c != null)
        {
            e1.c.a(canvas, e1.w);
        }
        if (e1.d != null)
        {
            e1.d.a(canvas, e1.w);
        }
        canvas.restore();
        return;
    }

    protected void onSizeChanged(int i, int j, int k, int i1)
    {
        if (b != null)
        {
            b.a(null, false);
        }
        super.onSizeChanged(i, j, k, i1);
        setWithOrientationDefaultSize(i, j);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        FreeCropDrawController freecropdrawcontroller;
        if (!a || b == null)
        {
            return false;
        }
        freecropdrawcontroller = b;
        freecropdrawcontroller.c();
        if (!myobfuscated.dc.b.a().a(motionevent, freecropdrawcontroller.s, freecropdrawcontroller.r, 20F, 0.7F)) goto _L2; else goto _L1
_L1:
        freecropdrawcontroller.a(false);
        if (freecropdrawcontroller.j)
        {
            freecropdrawcontroller.a(motionevent, false);
        }
        int i = motionevent.getAction() & 0xff;
        if ((i == 6 || i == 1) && motionevent.getPointerCount() == 1 && freecropdrawcontroller.C == FreeCropDrawController.DrawMode.Lasso && freecropdrawcontroller.E != null)
        {
            freecropdrawcontroller.E.a();
        }
        freecropdrawcontroller.F.invalidate();
_L17:
        return true;
_L2:
        if (!freecropdrawcontroller.G)
        {
            continue; /* Loop/switch isn't completed */
        }
        motionevent.getAction();
        JVM INSTR tableswitch 0 3: default 184
    //                   0 187
    //                   1 1183
    //                   2 270
    //                   3 1183;
           goto _L3 _L4 _L5 _L6 _L5
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        float f5 = motionevent.getX();
        float f = motionevent.getY();
        if (freecropdrawcontroller.C == FreeCropDrawController.DrawMode.FreeCrop)
        {
            freecropdrawcontroller.f = f5;
            freecropdrawcontroller.g = f;
        } else
        {
            motionevent = freecropdrawcontroller.E;
            f5 = motionevent.a(f5);
            f = motionevent.b(f);
            motionevent.g = f5;
            motionevent.h = f;
            motionevent.i = true;
            motionevent.j = true;
        }
        freecropdrawcontroller.j = true;
        break; /* Loop/switch isn't completed */
_L6:
        if (!freecropdrawcontroller.j) goto _L8; else goto _L7
_L7:
        float f6;
        float f7;
        f7 = motionevent.getX();
        f6 = motionevent.getY();
        if (freecropdrawcontroller.C != FreeCropDrawController.DrawMode.FreeCrop) goto _L10; else goto _L9
_L9:
        float f1;
        f1 = freecropdrawcontroller.b;
        if (freecropdrawcontroller.k)
        {
            f1 = freecropdrawcontroller.a;
        }
        if (l.b(freecropdrawcontroller.f, freecropdrawcontroller.g, f7, f6) < f1) goto _L8; else goto _L11
_L11:
        boolean flag;
        if (freecropdrawcontroller.k)
        {
            float f2 = (freecropdrawcontroller.f + f7) / 2.0F;
            float f8 = (freecropdrawcontroller.g + f6) / 2.0F;
            freecropdrawcontroller.e.quadTo(freecropdrawcontroller.f, freecropdrawcontroller.g, f2, f8);
            freecropdrawcontroller.e.computeBounds(freecropdrawcontroller.h, true);
            float f11 = freecropdrawcontroller.l / 2.0F + 1.0F;
            motionevent = freecropdrawcontroller.h;
            motionevent.left = ((RectF) (motionevent)).left - f11;
            motionevent = freecropdrawcontroller.h;
            motionevent.top = ((RectF) (motionevent)).top - f11;
            motionevent = freecropdrawcontroller.h;
            motionevent.right = ((RectF) (motionevent)).right + f11;
            motionevent = freecropdrawcontroller.h;
            motionevent.bottom = f11 + ((RectF) (motionevent)).bottom;
            freecropdrawcontroller.i.set((int)freecropdrawcontroller.h.left, (int)freecropdrawcontroller.h.top, (int)freecropdrawcontroller.h.right, (int)freecropdrawcontroller.h.bottom);
            freecropdrawcontroller.c.quadTo(freecropdrawcontroller.f, freecropdrawcontroller.g, f2, f8);
            f11 = freecropdrawcontroller.a(freecropdrawcontroller.f);
            float f12 = freecropdrawcontroller.b(freecropdrawcontroller.g);
            float f13 = freecropdrawcontroller.a(f2);
            float f14 = freecropdrawcontroller.b(f8);
            freecropdrawcontroller.d.quadTo(f11, f12, f13, f14);
            freecropdrawcontroller.e.reset();
            freecropdrawcontroller.e.moveTo(f2, f8);
        } else
        {
            float f3 = freecropdrawcontroller.f;
            float f9 = freecropdrawcontroller.g;
            freecropdrawcontroller.c.reset();
            freecropdrawcontroller.c.moveTo(f3, f9);
            freecropdrawcontroller.d.reset();
            freecropdrawcontroller.d.moveTo(freecropdrawcontroller.a(f3), freecropdrawcontroller.b(f9));
            freecropdrawcontroller.e.moveTo(f3, f9);
        }
        freecropdrawcontroller.f = f7;
        freecropdrawcontroller.g = f6;
        freecropdrawcontroller.k = true;
        flag = true;
_L15:
        if (flag)
        {
            float f4;
            float f10;
            if (freecropdrawcontroller.C == FreeCropDrawController.DrawMode.FreeCrop)
            {
                motionevent = freecropdrawcontroller.i;
            } else
            {
                motionevent = freecropdrawcontroller.E;
                if (((e) (motionevent)).u)
                {
                    motionevent = null;
                } else
                if (((e) (motionevent)).r)
                {
                    motionevent.r = false;
                    motionevent = null;
                } else
                {
                    motionevent = ((e) (motionevent)).v.d;
                }
            }
            if (motionevent == null)
            {
                freecropdrawcontroller.F.invalidate();
            } else
            {
                freecropdrawcontroller.F.invalidate(motionevent);
            }
        }
        break; /* Loop/switch isn't completed */
_L10:
        motionevent = freecropdrawcontroller.E;
        if (!((e) (motionevent)).j) goto _L13; else goto _L12
_L12:
        f7 = motionevent.a(f7);
        f6 = motionevent.b(f6);
        f10 = l.b(f7, f6, ((e) (motionevent)).g, ((e) (motionevent)).h);
        if (((e) (motionevent)).i)
        {
            f4 = ((e) (motionevent)).m;
        } else
        {
            f4 = ((e) (motionevent)).l;
        }
        if (f10 < f4) goto _L13; else goto _L14
_L14:
        if (((e) (motionevent)).i)
        {
            if (!((e) (motionevent)).c.c(((e) (motionevent)).g, ((e) (motionevent)).h) || ((e) (motionevent)).v.a.isEmpty())
            {
                ((e) (motionevent)).v.a(((e) (motionevent)).g, ((e) (motionevent)).h);
                ((e) (motionevent)).d.b(((e) (motionevent)).g, ((e) (motionevent)).h);
                ((e) (motionevent)).d.a = true;
            }
            if (((e) (motionevent)).p != null)
            {
                ((e) (motionevent)).p.e = true;
                ((e) (motionevent)).p.a(((e) (motionevent)).g, ((e) (motionevent)).h);
            }
            motionevent.i = false;
            motionevent.c();
            ((e) (motionevent)).c.a = false;
            ((e) (motionevent)).q.invalidate();
        }
        motionevent.n = f7 - ((e) (motionevent)).g;
        motionevent.o = f6 - ((e) (motionevent)).h;
        motionevent.a(f7, f6);
        motionevent.b = com.socialin.android.photo.view.a.a(((e) (motionevent)).d.c, ((e) (motionevent)).d.d, ((e) (motionevent)).g, ((e) (motionevent)).h);
        f4 = ((e) (motionevent)).b / 2.0F;
        f6 = ((e) (motionevent)).v.a();
        if (((e) (motionevent)).b <= ((e) (motionevent)).a && (double)f6 >= (double)f4 * 3.1415926535897931D)
        {
            motionevent.u = true;
            motionevent.t = (int)(150F * (1.0F - ((e) (motionevent)).b / ((e) (motionevent)).a));
        } else
        {
            if (((e) (motionevent)).u)
            {
                motionevent.r = true;
            }
            motionevent.u = false;
        }
        motionevent.k = true;
        flag = true;
          goto _L15
_L13:
        flag = false;
          goto _L15
_L8:
        flag = false;
          goto _L15
_L5:
        freecropdrawcontroller.a(motionevent, true);
        if (true) goto _L17; else goto _L16
_L16:
    }

    public void setDrawController(FreeCropDrawController freecropdrawcontroller)
    {
        b = freecropdrawcontroller;
        setWithOrientationDefaultSize(getWidth(), getHeight());
    }

    public void setWithOrientationDefaultSize(float f, float f1)
    {
        if (b != null)
        {
            f -= 0.0F + d;
            f1 -= 0.0F + c;
            Bitmap bitmap = b.n;
            if (bitmap != null && !bitmap.isRecycled() && f > 0.0F && f1 > 0.0F)
            {
                Rect rect = b.t;
                RectF rectf = b.s;
                RectF rectf1 = b.r;
                b.c();
                int i = bitmap.getWidth();
                int j = bitmap.getHeight();
                float f2 = Math.min(f / (float)i, f1 / (float)j);
                int k = Math.round((float)i * f2);
                int i1 = Math.round(f2 * (float)j);
                f = (float)(int)((f - (float)k) / 2.0F) + 0.0F;
                f1 = (float)(int)((f1 - (float)i1) / 2.0F) + 0.0F;
                rect.set(0, 0, i, j);
                rectf.set(f, f1, (float)k + f, (float)i1 + f1);
                rectf1.set(rectf);
                a = true;
                b.a(true);
                invalidate();
                return;
            }
        }
    }
}
