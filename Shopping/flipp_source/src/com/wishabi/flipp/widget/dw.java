// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.view.View;
import com.a.b.ad;
import com.a.b.aj;
import com.a.b.ap;
import com.a.b.aq;
import com.a.b.aw;
import com.a.b.ax;
import com.a.b.ba;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.wishabi.flipp.widget:
//            dy, dx

public final class dw extends View
{

    float a;
    float b;
    public ad c;
    public final Map d = new HashMap();
    public final Map e = new HashMap();
    public final Stack f = new Stack();
    private float g[];
    private String h;
    private boolean i;
    private float j;
    private float k;
    private float l;
    private final RectF m = new RectF();
    private final dy n = new dy(0, 0, 0);

    public dw(Context context)
    {
        super(context);
        if (!isInEditMode())
        {
            c = ad.a(context);
        }
    }

    static Map a(dw dw1)
    {
        return dw1.d;
    }

    private void a(Canvas canvas, float f1, float f2, float f3, float f4, int i1)
    {
        float f5 = 256F * g[i1];
        float f6 = (float)(Math.ceil(l / f5) * (double)f5 - (double)l);
        int j2 = (int)Math.ceil(l / f5) - 1;
        int k1 = (int)Math.ceil(k / f5);
        int i2 = (int)Math.max(0.0D, Math.floor(f2 / f5));
        int k2 = (int)Math.min(j2, Math.floor((f6 + f4) / f5));
        int j1 = (int)Math.max(0.0D, Math.floor(f1 / f5));
        int l2 = (int)Math.min(k1 - 1, Math.floor(f3 / f5));
        f2 = f5 * (float)j1;
        f1 = f2 + f5;
        for (; j1 <= l2; j1++)
        {
            f4 = (float)i2 * f5 - f6;
            f3 = f4 + f5;
            int l1 = i2;
            while (l1 <= k2) 
            {
                int i3 = j2 - l1;
                n.a(i3, j1, i1);
                Object obj = (dx)d.get(n);
                if (obj != null)
                {
                    obj = ((dx) (obj)).c;
                } else
                {
                    if (!e.containsKey(n))
                    {
                        Object obj1;
                        android.graphics.Bitmap bitmap;
                        byte abyte0[];
                        AtomicInteger atomicinteger;
                        ap ap1;
                        if (f.empty())
                        {
                            obj = null;
                        } else
                        {
                            obj = (dx)f.pop();
                        }
                        if (obj == null)
                        {
                            obj = new dx(this, i3, j1, i1, f2, f4, f1, f3);
                        } else
                        {
                            obj.a = i1;
                            ((dx) (obj)).b.a(i3, j1, i1);
                            ((dx) (obj)).f.set(f2, f4, f1, f3);
                        }
                        e.put(((dx) (obj)).b, obj);
                        obj1 = (new StringBuilder()).append(h).append(i1).append("_").append(j1).append("_").append(i3).append(".jpg").toString();
                        obj1 = c.a(((String) (obj1)));
                        bitmap = ((dx) (obj)).c;
                        abyte0 = ((dx) (obj)).d;
                        atomicinteger = ((dx) (obj)).e;
                        obj1.c = true;
                        ap1 = ((aq) (obj1)).b;
                        i3 = atomicinteger.incrementAndGet();
                        ap1.b = bitmap;
                        ap1.c = abyte0;
                        ap1.d = i3;
                        ap1.e = atomicinteger;
                        if (obj == null)
                        {
                            throw new IllegalArgumentException("Target must not be null.");
                        }
                        if (((aq) (obj1)).d)
                        {
                            throw new IllegalStateException("Fit cannot be used with a Target.");
                        }
                        if (((aq) (obj1)).e != 0)
                        {
                            ((aq) (obj1)).a.c.getResources().getDrawable(((aq) (obj1)).e);
                        }
                        if (!((aq) (obj1)).b.a())
                        {
                            ((aq) (obj1)).a.a(obj);
                        } else
                        {
                            com.a.b.ao ao = ((aq) (obj1)).a.a(((aq) (obj1)).b.b());
                            String s = ba.a(ao);
                            if (!((aq) (obj1)).c && ((aq) (obj1)).a.b(s) != null)
                            {
                                ((aq) (obj1)).a.a(obj);
                                obj1 = aj.a;
                                ((aw) (obj)).a();
                            } else
                            {
                                obj = new ax(((aq) (obj1)).a, ((aw) (obj)), ao, ((aq) (obj1)).c, s);
                                ((aq) (obj1)).a.a(((com.a.b.a) (obj)));
                            }
                        }
                    }
                    obj = null;
                }
                if (obj != null)
                {
                    m.set(f2, f4, f1, f3);
                    canvas.drawBitmap(((android.graphics.Bitmap) (obj)), null, m, null);
                }
                f4 += f5;
                f3 += f5;
                l1++;
            }
            f2 += f5;
            f1 += f5;
        }

    }

    static Map b(dw dw1)
    {
        return dw1.e;
    }

    static Stack c(dw dw1)
    {
        return dw1.f;
    }

    private int getPreferredResolution()
    {
        int j1;
        int l1;
        j1 = 0;
        l1 = 0;
        if (g != null) goto _L2; else goto _L1
_L1:
        return l1;
_L2:
        float f3 = 256F / j;
        float f1 = (1.0F / 0.0F);
        float af[] = g;
        int i2 = af.length;
        int k1 = 0;
        int i1 = 0;
        do
        {
            l1 = j1;
            if (k1 >= i2)
            {
                continue;
            }
            float f2 = Math.abs(af[k1] * 256F - f3);
            if (f2 < f1)
            {
                j1 = i1;
                f1 = f2;
            }
            k1++;
            i1++;
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void a(String s, float af[], float f1, float f2)
    {
        g = (float[])af.clone();
        k = f1;
        l = f2;
        j = 1.0F;
        h = (new StringBuilder("http://f.wishabi.net/")).append(s).toString();
    }

    protected final void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if (isInEditMode())
        {
            return;
        }
        float f1 = a;
        float f2 = b;
        float f8 = (float)getWidth() / j;
        float f7 = (float)getHeight() / j;
        float f3 = f1 + f8;
        float f4 = f2 + f7;
        float f5 = f1 - 2.0F * f8;
        float f6 = f2 - 2.0F * f7;
        f8 = f1 + f8 * 4F;
        f7 = f2 + 4F * f7;
        int i1 = canvas.save();
        canvas.scale(j, j);
        canvas.translate(-a, -b);
        if (!i)
        {
            int j1 = getPreferredResolution();
            Iterator iterator = d.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                dx dx1 = (dx)((java.util.Map.Entry)iterator.next()).getValue();
                if (dx1.a != 0 && dx1.a != j1 || !dx1.f.intersects(f1, f2, f3, f4) && dx1.a == j1 || !dx1.f.intersects(f5, f6, f8, f7) && dx1.a == 0)
                {
                    f.push(dx1);
                    iterator.remove();
                }
            } while (true);
            iterator = e.entrySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                dx dx2 = (dx)((java.util.Map.Entry)iterator.next()).getValue();
                if (dx2.a != 0 && dx2.a != j1 || !dx2.f.intersects(f1, f2, f3, f4) && dx2.a == j1 || !dx2.f.intersects(f5, f6, f8, f7) && dx2.a == 0)
                {
                    dx2.e.incrementAndGet();
                    c.a(dx2);
                    f.push(dx2);
                    iterator.remove();
                }
            } while (true);
            a(canvas, f5, f6, f8, f7, 0);
            if (j1 != 0)
            {
                a(canvas, f1, f2, f3, f4, j1);
            }
        } else
        {
            a(canvas, f5, f6, f8, f7, 0);
        }
        canvas.restoreToCount(i1);
    }

    public final void setZoomScale(float f1)
    {
        j = f1;
        invalidate();
    }

    public final void setZooming(boolean flag)
    {
        if (i == flag)
        {
            return;
        } else
        {
            i = flag;
            invalidate();
            return;
        }
    }
}
