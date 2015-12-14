// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.accessorypreviewview;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.kernelctrl.VenusHelper;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.t;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.ai;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.accessorypreviewview:
//            b, a, c, AccessoryView, 
//            d

public class AccessoryDrawingCtrl
{

    private static WeakReference r = null;
    private static Handler s = new Handler(new b(null));
    public Paint a;
    private float b[];
    private PointF c;
    private RectF d;
    private float e;
    private float f;
    private float g;
    private float h;
    private double i;
    private double j;
    private float k;
    private RectF l;
    private boolean m;
    private AccessoryType n;
    private RectF o;
    private float p;
    private a q;

    private AccessoryDrawingCtrl(AccessoryType accessorytype)
    {
        b = new float[9];
        c = new PointF();
        d = new RectF();
        a = aa.a();
        h = 1.0F;
        l = new RectF();
        m = false;
        o = new RectF();
        p = 0.0F;
        q = new a(this);
        n = accessorytype;
    }


    public static AccessoryDrawingCtrl a(AccessoryType accessorytype)
    {
        return (AccessoryDrawingCtrl)com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.c.a().get(accessorytype);
    }

    public static List a(BeautyMode beautymode)
    {
        ArrayList arraylist = new ArrayList();
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[BeautyMode.values().length];
                try
                {
                    a[BeautyMode.z.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[BeautyMode.A.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[BeautyMode.B.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[BeautyMode.C.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[beautymode.ordinal()])
        {
        default:
            arraylist.add(AccessoryType.a);
            return arraylist;

        case 1: // '\001'
            arraylist.add(AccessoryType.a);
            return arraylist;

        case 2: // '\002'
            arraylist.add(AccessoryType.b);
            return arraylist;

        case 3: // '\003'
            arraylist.add(AccessoryType.c);
            return arraylist;

        case 4: // '\004'
            arraylist.add(AccessoryType.d);
            break;
        }
        arraylist.add(AccessoryType.e);
        return arraylist;
    }

    public static void a(int i1)
    {
        s.removeMessages(3);
        Message message = Message.obtain(s, 3, i1, -1);
        s.sendMessage(message);
    }

    public static void a(t t1)
    {
        s.removeMessages(1);
        t1 = Message.obtain(s, 1, t1);
        s.sendMessage(t1);
    }

    public static void a(AccessoryView accessoryview)
    {
        if (r != null)
        {
            r.clear();
            r = null;
        }
        if (accessoryview != null)
        {
            r = new WeakReference(accessoryview);
        }
    }

    public static AccessoryDrawingCtrl b(BeautyMode beautymode)
    {
        return (AccessoryDrawingCtrl)com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.c.a().get(a(beautymode).get(0));
    }

    private void b(RectF rectf)
    {
        ai.a(-j, q.a, q.b, c);
        rectf.left = rectf.left + c.x;
        rectf.top = rectf.top + c.y;
        float f1 = q.c;
        float f2 = rectf.right;
        float f3 = rectf.bottom;
        rectf.right = f2 * f1;
        rectf.bottom = f1 * f3;
        rectf.left = rectf.left + (f2 - rectf.right) * 0.5F;
        rectf.top = rectf.top + (f3 - rectf.bottom) * 0.5F;
    }

    private void c(RectF rectf)
    {
        float f3 = rectf.left;
        float f4 = rectf.top;
        float f5 = rectf.right;
        float f6 = rectf.bottom;
        ai.a(j, f3, f4, c);
        float f1 = c.x;
        float f2 = c.y;
        ai.a(j, f3 + f5 * 0.5F, f4 + f6 * 0.5F, c);
        f3 = c.x;
        f4 = c.y;
        ai.a(k, f1 - f3, f2 - f4, c);
        f1 = c.x;
        f2 = c.y;
        ai.a(-i, f3 + f1, f4 + f2, c);
        rectf.left = c.x;
        rectf.top = c.y;
    }

    public static AccessoryView m()
    {
        if (r == null)
        {
            return null;
        } else
        {
            return (AccessoryView)r.get();
        }
    }

    public static void n()
    {
        s.removeMessages(4);
        Message message = Message.obtain(s, 4);
        s.sendMessage(message);
    }

    public static void o()
    {
        s.removeMessages(6);
        Message message = Message.obtain(s, 6);
        s.sendMessage(message);
    }

    public float a()
    {
        return f;
    }

    public RectF a(float f1, float f2)
    {
        float f4 = (float)i;
        float f5 = l.left;
        float f6 = l.top;
        float f7 = l.width();
        float f3 = l.height();
        ai.a(f4, f5 + f7 * 0.5F, f6 + f3 * 0.5F, c);
        f4 = (f7 * 1.0F) / 2.0F;
        f3 = (f3 * 1.0F) / 2.0F;
        RectF rectf = new RectF(c.x - f4, c.y - f3, f4 + c.x, f3 + c.y);
        rectf.left = (rectf.left * e + f1 + f) - (float)d.g;
        rectf.top = (rectf.top * e + f2 + g) - (float)d.g;
        rectf.right = rectf.right * e + f1 + f + (float)d.g;
        rectf.bottom = rectf.bottom * e + f2 + g + (float)d.g;
        return rectf;
    }

    public void a(float f1)
    {
        q.c = f1;
    }

    public void a(RectF rectf)
    {
        o = rectf;
    }

    public void a(t t1, Bitmap bitmap, bi bi1)
    {
        t1.e.getValues(b);
        e = b[0];
        f = b[2] * e;
        g = b[5] * e;
        float f1 = bi1.b();
        h = q.c * f1;
        j = Math.toDegrees(bi1.c());
        k = q.d;
        i = j + (double)k;
        d = new RectF(bi1.d() * f1, bi1.e() * f1, (float)bitmap.getWidth() * f1, f1 * (float)bitmap.getHeight());
        b(d);
        c(d);
        l.left = d.left;
        l.top = d.top;
        l.right = l.left + d.right;
        l.bottom = l.top + d.bottom;
        a(true);
    }

    public void a(boolean flag)
    {
        m = flag;
    }

    public float b()
    {
        return g;
    }

    public void b(float f1)
    {
        q.d = f1;
    }

    public void b(float f1, float f2)
    {
        q.a = f1;
        q.b = f2;
    }

    public float c()
    {
        return e;
    }

    public void c(float f1)
    {
        p = f1;
    }

    public double d()
    {
        return i;
    }

    public RectF e()
    {
        return l;
    }

    public bi f()
    {
        bi bi1 = new bi();
        if (g())
        {
            bi1.c(l.left / h);
            bi1.d(l.top / h);
            bi1.a(h);
            bi1.b((float)Math.toRadians(i));
            return bi1;
        } else
        {
            return VenusHelper.a().l();
        }
    }

    public boolean g()
    {
        return m;
    }

    public float h()
    {
        return q.a;
    }

    public float i()
    {
        return q.b;
    }

    public float j()
    {
        return q.c;
    }

    public float k()
    {
        return q.d;
    }

    public void l()
    {
        q.a();
    }

    public RectF p()
    {
        return o;
    }

    public float q()
    {
        return p;
    }


    private class AccessoryType extends Enum
    {

        public static final AccessoryType a;
        public static final AccessoryType b;
        public static final AccessoryType c;
        public static final AccessoryType d;
        public static final AccessoryType e;
        private static final AccessoryType f[];

        public static AccessoryType valueOf(String s1)
        {
            return (AccessoryType)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/accessorypreviewview/AccessoryDrawingCtrl$AccessoryType, s1);
        }

        public static AccessoryType[] values()
        {
            return (AccessoryType[])f.clone();
        }

        static 
        {
            a = new AccessoryType("EYE_WEAR", 0);
            b = new AccessoryType("HAIR_BAND", 1);
            c = new AccessoryType("NECKLACE", 2);
            d = new AccessoryType("LEFT_EARRING", 3);
            e = new AccessoryType("RIGHT_EARRING", 4);
            f = (new AccessoryType[] {
                a, b, c, d, e
            });
        }

        private AccessoryType(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
