// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.database.r;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.HairDyeBrushHandler;
import com.cyberlink.youcammakeup.kernelctrl.ROI;
import com.cyberlink.youcammakeup.kernelctrl.ah;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.CmdSetting;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.c;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.n;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.q;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.bv;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.panzoomviewer:
//            n, m, q, s, 
//            w, ImageViewer, i, t, 
//            c, e, r, f, 
//            l, j, g, h

public class ImageLoader
{

    public HashMap a;
    public HashMap b;
    public HashMap c;
    public String d;
    protected bv e;
    protected com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.n f;
    public Object g;
    public HashMap h;
    private HashMap i;
    private ViewEngine j;
    private ImageViewer k;
    private HairDyeBrushHandler l;
    private ah m;
    private HashMap n;
    private Integer o;
    private Object p;
    private Bitmap q;

    public ImageLoader(ImageViewer imageviewer)
    {
        a = null;
        b = null;
        c = null;
        i = null;
        d = null;
        j = null;
        k = null;
        e = null;
        l = null;
        m = null;
        f = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.n();
        g = new Object();
        n = null;
        o = Integer.valueOf(0);
        p = new Object();
        a = new HashMap();
        a.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.a, null);
        a.put(BufferName.b, null);
        a.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c, null);
        a.put(BufferName.d, null);
        a.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.e, null);
        b = new HashMap();
        b.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.a, null);
        b.put(BufferName.b, null);
        b.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c, null);
        b.put(BufferName.d, null);
        b.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.e, null);
        c = new HashMap();
        c.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.a, null);
        c.put(BufferName.b, null);
        c.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c, null);
        c.put(BufferName.d, null);
        c.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.e, null);
        i = new HashMap();
        i.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.a, com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.b);
        i.put(BufferName.b, com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.c);
        i.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c, com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d);
        i.put(BufferName.d, com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.b);
        i.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.e, com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.b);
        j = ViewEngine.a();
        k = imageviewer;
        e = new bv();
        n = new HashMap();
        h = new HashMap();
        h.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.a, new AtomicLong());
        h.put(BufferName.b, new AtomicLong());
        h.put(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c, new AtomicLong());
    }

    private m a(w w1, float f1, float f2, float f3, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        m m1 = new m(this);
        w1 = b(w1, f1, f2, f3, q1);
        f1 = Math.min(f1 / (float)q1.b, f2 / (float)q1.c);
        m1.a = (float)q1.h.c * f1;
        m1.b = f1 * (float)q1.h.d;
        m1.c = w1;
        return m1;
    }

    private w a(float f1, float f2, w w1, UIImageOrientation uiimageorientation)
    {
        float f3;
        float f4;
        if (uiimageorientation == UIImageOrientation.g)
        {
            f4 = w1.b();
            f3 = f1 - (w1.a() + w1.c());
            f2 = w1.d();
            f1 = w1.c();
        } else
        if (uiimageorientation == UIImageOrientation.d)
        {
            f4 = f1 - (w1.a() + w1.c());
            f3 = f2 - (w1.b() + w1.d());
            f2 = w1.c();
            f1 = w1.d();
        } else
        if (uiimageorientation == UIImageOrientation.i)
        {
            f4 = f2 - (w1.b() + w1.d());
            f3 = w1.a();
            f2 = w1.d();
            f1 = w1.c();
        } else
        if (uiimageorientation == UIImageOrientation.f)
        {
            f4 = w1.b();
            f3 = w1.a();
            f2 = w1.d();
            f1 = w1.c();
        } else
        if (uiimageorientation == UIImageOrientation.h)
        {
            f4 = f2 - (w1.b() + w1.d());
            f3 = f1 - (w1.a() + w1.c());
            f2 = w1.d();
            f1 = w1.c();
        } else
        if (uiimageorientation == UIImageOrientation.c)
        {
            f4 = f1 - (w1.a() + w1.c());
            f3 = w1.b();
            f2 = w1.c();
            f1 = w1.d();
        } else
        if (uiimageorientation == UIImageOrientation.e)
        {
            f4 = w1.a();
            f3 = f2 - (w1.b() + w1.d());
            f2 = w1.c();
            f1 = w1.d();
        } else
        {
            f4 = w1.a();
            f3 = w1.b();
            f2 = w1.c();
            f1 = w1.d();
        }
        return new w(f4, f3, f2, f1);
    }

    static Integer a(ImageLoader imageloader)
    {
        return imageloader.o;
    }

    private void a(BufferName buffername, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1, Long long1)
    {
        Object obj;
        obj = (Bitmap)a.get(buffername);
        break MISSING_BLOCK_LABEL_13;
        if (canvas == null || l == null || !l.h().booleanValue() || buffername != com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c && buffername != BufferName.b) goto _L2; else goto _L1
_L1:
        obj2 = Boolean.valueOf(false);
        q = l.f();
        if (q == null) goto _L2; else goto _L3
_L3:
        obj = new Paint();
        ((Paint) (obj)).setAlpha(80);
        ((Paint) (obj)).setFilterBitmap(true);
        if (buffername != com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c) goto _L5; else goto _L4
_L4:
        f2 = l.g();
        if (q1.q.d > 1.0F)
        {
            f1 = 1.0F;
        } else
        {
            f1 = q1.q.d;
        }
        obj1 = a(q1);
        l2 = (int)Math.floor((((m) (obj1)).c.a() * f2) / f1);
        i3 = (int)Math.floor((((m) (obj1)).c.b() * f2) / f1);
        j2 = (int)Math.floor((((m) (obj1)).c.c() * f2) / f1);
        k2 = (int)Math.floor((f2 * ((m) (obj1)).c.d()) / f1);
        if (l2 + j2 > q.getWidth())
        {
            j2 -= (l2 + j2) - q.getWidth();
        }
        if (i3 + k2 > q.getHeight())
        {
            k2 -= (i3 + k2) - q.getHeight();
        }
        obj1 = q;
        obj1;
        JVM INSTR monitorenter ;
        if (!((Boolean) (obj2)).booleanValue()) goto _L7; else goto _L6
_L6:
        obj2 = Bitmap.createBitmap(q);
        canvas1 = new Canvas(((Bitmap) (obj2)));
        paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setColor(0xffff0000);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_OUT));
        canvas1.drawRect(new Rect(0, 0, ((Bitmap) (obj2)).getWidth(), ((Bitmap) (obj2)).getHeight()), paint);
        canvas.drawBitmap(((Bitmap) (obj2)), new Rect(l2, i3, j2 + l2, k2 + i3), new Rect(i2 / 2, l1 / 2, i2 / 2 + j1, l1 / 2 + k1), ((Paint) (obj)));
_L2:
        canvas.restore();
        canvas.setBitmap(null);
        if (i1.a == null)
        {
            i1.a = bitmap;
        }
        i1.c = true;
        if (buffername == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c)
        {
            i1.d = q1.q.a;
        }
        i1.e = long1;
        return;
_L7:
        canvas.drawBitmap(q, new Rect(l2, i3, j2 + l2, k2 + i3), new Rect(i2 / 2, l1 / 2, i2 / 2 + j1, l1 / 2 + k1), ((Paint) (obj)));
          goto _L2
        buffername;
        obj1;
        JVM INSTR monitorexit ;
        throw buffername;
_L5:
        obj1 = q;
        obj1;
        JVM INSTR monitorenter ;
        if (!((Boolean) (obj2)).booleanValue())
        {
            break MISSING_BLOCK_LABEL_1275;
        }
        obj2 = Bitmap.createBitmap(q);
        canvas1 = new Canvas(((Bitmap) (obj2)));
        paint = new Paint();
        paint.setStyle(android.graphics.Paint.Style.FILL);
        paint.setColor(0xffff0000);
        paint.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SRC_OUT));
        canvas1.drawRect(new Rect(0, 0, ((Bitmap) (obj2)).getWidth(), ((Bitmap) (obj2)).getHeight()), paint);
        canvas.drawBitmap(((Bitmap) (obj2)), new Rect(0, 0, ((Bitmap) (obj2)).getWidth(), ((Bitmap) (obj2)).getHeight()), new Rect(i2 / 2, l1 / 2, i2 / 2 + j1, l1 / 2 + k1), ((Paint) (obj)));
          goto _L2
        buffername;
        obj1;
        JVM INSTR monitorexit ;
        throw buffername;
        canvas.drawBitmap(q, new Rect(0, 0, q.getWidth(), q.getHeight()), new Rect(i2 / 2, l1 / 2, i2 / 2 + j1, l1 / 2 + k1), ((Paint) (obj)));
          goto _L2
    }

    static void a(ImageLoader imageloader, BufferName buffername, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1, Long long1)
    {
        imageloader.a(buffername, q1, long1);
    }

    static ImageViewer b(ImageLoader imageloader)
    {
        return imageloader.k;
    }

    private w b(w w1, float f1, float f2, float f3, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        boolean flag;
        flag = true;
        break MISSING_BLOCK_LABEL_3;
        if (w1 != null && (Math.abs(w1.c() - f1) >= (float)2 || Math.abs(w1.d() - f2) >= (float)2))
        {
            flag = false;
        }
        if (flag)
        {
            return null;
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.c c1 = k.a(w1.a() / f3, w1.b() / f3);
            return new w((float)Math.floor(c1.a), (float)Math.floor(c1.b), (float)Math.floor(w1.c() / f3), (float)Math.floor(w1.d() / f3), q1.h.k);
        }
    }

    static Object c(ImageLoader imageloader)
    {
        return imageloader.p;
    }

    static HashMap d(ImageLoader imageloader)
    {
        return imageloader.n;
    }

    private void e()
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        BufferName abuffername[];
        int j1;
        abuffername = BufferName.values();
        j1 = abuffername.length;
        int i1 = 0;
_L2:
        BufferName buffername;
        if (i1 >= j1)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        buffername = abuffername[i1];
        Bitmap bitmap;
        if (!a.containsKey(buffername))
        {
            break MISSING_BLOCK_LABEL_85;
        }
        bitmap = (Bitmap)a.get(buffername);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_85;
        }
        bitmap.recycle();
        a.put(buffername, null);
        break MISSING_BLOCK_LABEL_85;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void f()
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        BufferName abuffername[];
        int k1;
        abuffername = BufferName.values();
        k1 = abuffername.length;
        int j1 = 0;
_L2:
        BufferName buffername;
        if (j1 >= k1)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        buffername = abuffername[j1];
        i i1;
        if (!b.containsKey(buffername))
        {
            break MISSING_BLOCK_LABEL_125;
        }
        i1 = (i)b.get(buffername);
        if (i1 == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        if (i1.a != null)
        {
            i1.a.recycle();
            i1.a = null;
        }
        i1.c = false;
        if (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c == buffername || BufferName.d == buffername || com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.e == buffername)
        {
            i1.d = false;
        }
        break MISSING_BLOCK_LABEL_125;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        j1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void g()
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        BufferName abuffername[];
        int k1;
        abuffername = BufferName.values();
        k1 = abuffername.length;
        int j1 = 0;
_L2:
        BufferName buffername;
        if (j1 >= k1)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        buffername = abuffername[j1];
        i i1;
        if (!b.containsKey(buffername))
        {
            break MISSING_BLOCK_LABEL_102;
        }
        i1 = (i)b.get(buffername);
        if (i1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        if (i1.a != null)
        {
            i1.a.recycle();
            i1.a = null;
        }
        b.put(buffername, null);
        break MISSING_BLOCK_LABEL_102;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        j1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void h()
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        BufferName abuffername[];
        int k1;
        abuffername = BufferName.values();
        k1 = abuffername.length;
        int j1 = 0;
_L2:
        BufferName buffername;
        if (j1 >= k1)
        {
            break MISSING_BLOCK_LABEL_151;
        }
        buffername = abuffername[j1];
        if (b.containsKey(buffername) && b.get(buffername) == null)
        {
            String s1 = (new StringBuilder()).append(buffername).append("Canvas").toString();
            i i1 = (i)b.get(buffername);
            i1 = new i(this);
            i1.b = s1;
            i1.c = false;
            if (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c == buffername || BufferName.d == buffername || com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.e == buffername)
            {
                i1.d = false;
            }
            b.put(buffername, i1);
        }
        break MISSING_BLOCK_LABEL_159;
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        j1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public DevelopSetting a(long l1)
    {
        return com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e.a().a(Long.valueOf(l1), Boolean.TRUE);
    }

    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.e a(float f1, w w1, float f2, float f3, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        float f4;
        Object obj;
        ROI roi;
        boolean flag;
        if (f1 > 1.0F)
        {
            f1 = 1.0F;
            f4 = 1.0F;
        } else
        {
            f4 = f1;
        }
        if (w1 != null && (Math.abs(w1.c() - f2) > (float)2 || Math.abs(w1.d() - f3) > (float)2))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (w1 != null && flag)
        {
            roi = new ROI(0, 0, 0, 0, w1.e());
            roi.a((int)Math.floor(w1.a() / f1));
            roi.b((int)Math.floor(w1.b() / f1));
            roi.c((int)Math.floor(w1.c() / f1));
            roi.d((int)Math.floor(w1.d() / f1));
        } else
        {
            roi = null;
        }
        obj = roi;
        if (q1.h.b)
        {
            obj = roi;
            if (k.x)
            {
                obj = roi;
                if (q1.h.a == q1.a)
                {
                    q1 = a(w1, f2, f3, f1, q1);
                    obj = k;
                    if (((m) (q1)).c != null)
                    {
                        w1 = new w(((m) (q1)).c.a(), ((m) (q1)).c.b(), ((m) (q1)).c.c(), ((m) (q1)).c.d(), ((m) (q1)).c.e());
                    } else
                    {
                        w1 = null;
                    }
                    obj.y = w1;
                    k.z = (int)((m) (q1)).a;
                    k.A = (int)((m) (q1)).b;
                    if (((m) (q1)).c != null)
                    {
                        obj = new ROI((int)((m) (q1)).c.a(), (int)((m) (q1)).c.b(), (int)((m) (q1)).c.c(), (int)((m) (q1)).c.d(), ((m) (q1)).c.e());
                    } else
                    {
                        obj = null;
                    }
                }
            }
        }
        w1 = new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.e(this);
        w1.a = f4;
        w1.b = ((ROI) (obj));
        return w1;
    }

    public com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.e a(BufferName buffername)
    {
        return (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.e)c.get(buffername);
    }

    public m a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1)
    {
        m m1 = new m(this);
        w w1 = a((float)q1.e * q1.q.d, (float)q1.f * q1.q.d, q1.q.f, q1.d);
        float f1 = (float)q1.b * q1.q.d;
        float f2 = (float)q1.c * q1.q.d;
        if (q1.q.d >= 1.0F)
        {
            m1.a = q1.b;
            m1.b = q1.c;
            if (w1.c() == f1 && w1.d() == f2)
            {
                m1.c = new w(0.0F, 0.0F, q1.b, q1.c);
            } else
            {
                f1 = q1.q.d;
                m1.c = new w(w1.a() / f1, w1.b() / f1, w1.c() / f1, w1.d() / f1);
            }
        } else
        {
            m1.a = f1;
            m1.b = f2;
            m1.c = w1;
        }
        if (m1.c.a() + m1.c.c() > m1.a)
        {
            m1.c.c(m1.a - m1.c.a());
        }
        if (m1.c.b() + m1.c.d() > m1.b)
        {
            m1.c.d(m1.b - m1.c.b());
        }
        return m1;
    }

    public void a()
    {
        h();
    }

    public void a(HairDyeBrushHandler hairdyebrushhandler, ah ah, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.n n1)
    {
        l = hairdyebrushhandler;
        m = ah;
        f = n1;
    }

    public void a(BufferName buffername, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1, f f1, h h1)
    {
        Object obj;
        Object obj1;
        c c1;
        float f2;
        if (buffername == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c || BufferName.d == buffername || com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.e == buffername)
        {
label0:
            {
                m m1 = a(q1);
                f2 = q1.q.d;
                if (buffername != BufferName.d)
                {
                    obj = m1;
                    if (buffername != com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.e)
                    {
                        break label0;
                    }
                }
                f2 = q1.s.b;
                obj = m1;
            }
        } else
        {
            if (buffername == BufferName.b)
            {
                obj = q1.r;
            } else
            {
                obj = q1.s;
            }
            obj1 = new m(this);
            obj1.a = (float)q1.b * ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.r) (obj)).b;
            obj1.b = (float)q1.c * ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.r) (obj)).b;
            obj1.c = null;
            f2 = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.r) (obj)).b;
            obj = obj1;
        }
        obj1 = a(f2, ((m) (obj)).c, ((m) (obj)).a, ((m) (obj)).b, q1);
        c.put(buffername, new com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.e(this, ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.e) (obj1))));
        if (q1.h.b && !k.x)
        {
            ((CmdSetting)q1.g.get("global")).remove(Integer.valueOf(7));
        }
        obj = (i)b.get(buffername);
        if (obj != null)
        {
            obj.c = false;
        }
        c1 = new c((com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole)i.get(buffername));
        c1.a = ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.e) (obj1)).b;
        c1.b = (com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole)i.get(buffername);
        if (f1.c != null)
        {
            obj = f1.c.f;
        } else
        {
            obj = null;
        }
        c1.f = ((Boolean) (obj));
        if (f1.c != null)
        {
            f1 = f1.c.e;
        } else
        {
            f1 = null;
        }
        c1.e = f1;
        if (q1.h.b && !k.x)
        {
            c1.e = Boolean.valueOf(true);
        }
        obj = q1.g;
        if (((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.e) (obj1)).a > 0.0F) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (!h.containsKey(buffername))
        {
            break MISSING_BLOCK_LABEL_528;
        }
        f1 = (AtomicLong)h.get(buffername);
        if (f1 == null)
        {
            break MISSING_BLOCK_LABEL_528;
        }
        f1 = Long.valueOf(f1.incrementAndGet());
_L4:
        q1 = j.a((int)q1.a, ((com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.e) (obj1)).a, ((DevelopSetting) (obj)), c1, new com.cyberlink.youcammakeup.kernelctrl.viewengine.a(buffername, q1, h1) {

            final BufferName a;
            final com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q b;
            final h c;
            final ImageLoader d;
            private Integer e;

            public void a(com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskCancelType taskcanceltype, String s1, Object obj2)
            {
                synchronized (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.c(d))
                {
                    ImageLoader.d(d).remove(e);
                }
                return;
                s1;
                taskcanceltype;
                JVM INSTR monitorexit ;
                throw s1;
            }

            public void a(q q2, Object obj2)
            {
                q2 = q2.a();
                Object obj3 = d.g;
                obj3;
                JVM INSTR monitorenter ;
                long l1;
                long l2;
                long l3;
                l1 = ImageLoader.b(d).m.a;
                l2 = ImageLoader.b(d).t.a;
                l3 = ImageLoader.b(d).u.a;
                if (a != com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.e) goto _L2; else goto _L1
_L1:
                l1 = l3;
_L4:
                if (l1 == b.a)
                {
                    break; /* Loop/switch isn't completed */
                }
                q2.m();
                c.a(new Exception("cancel this task since it is out of date"));
                obj3;
                JVM INSTR monitorexit ;
                return;
_L2:
                if (a == BufferName.d)
                {
                    l1 = l2;
                }
                if (true) goto _L4; else goto _L3
_L3:
                if (!d.a.containsKey(a)) goto _L6; else goto _L5
_L5:
                Bitmap bitmap = (Bitmap)d.a.get(a);
                if (bitmap == null) goto _L8; else goto _L7
_L7:
                if (bitmap.getWidth() != (int)q2.b() || bitmap.getHeight() != (int)q2.c()) goto _L8; else goto _L9
_L9:
                q2.c(bitmap);
_L6:
                com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.a(d, a, b, (Long)obj2);
                if (a == com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.e || a == BufferName.d)
                {
                    ((Bitmap)d.a.get(a)).recycle();
                    d.a.put(a, null);
                }
                obj3;
                JVM INSTR monitorexit ;
                synchronized (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.c(d))
                {
                    ImageLoader.d(d).remove(e);
                }
                q2.m();
                c.a();
                return;
_L8:
                if (q2.b() > 0L && q2.c() > 0L)
                {
                    break MISSING_BLOCK_LABEL_372;
                }
                q2.m();
                c.a(new IllegalArgumentException("width and height must be > 0"));
                obj3;
                JVM INSTR monitorexit ;
                return;
                q2;
                obj3;
                JVM INSTR monitorexit ;
                throw q2;
                Bitmap bitmap1 = Bitmap.createBitmap((int)q2.b(), (int)q2.c(), android.graphics.Bitmap.Config.ARGB_8888);
                q2.c(bitmap1);
                d.a.put(a, bitmap1);
                  goto _L6
                q2;
                obj2;
                JVM INSTR monitorexit ;
                throw q2;
            }

            public void a(String s1, Object obj2)
            {
                synchronized (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.c(d))
                {
                    ImageLoader.d(d).remove(e);
                }
                return;
                obj2;
                s1;
                JVM INSTR monitorexit ;
                throw obj2;
            }

            
            {
                d = ImageLoader.this;
                a = buffername;
                b = q1;
                c = h1;
                super();
                e = com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.a(d);
            }
        }, f1);
        if (q1 == null) goto _L1; else goto _L3
_L3:
        synchronized (p)
        {
            n.put(o, q1);
        }
        o = Integer.valueOf(o.intValue() + 1);
        return;
        q1;
        buffername;
        JVM INSTR monitorexit ;
        throw q1;
        f1 = null;
          goto _L4
    }

    public void a(BufferName buffername, com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q q1, h h1)
    {
        if (e != null)
        {
            buffername = new l(this, buffername, q1, h1);
            e.a(buffername, new j(this));
        }
    }

    public boolean a(long l1, g g1)
    {
        if (StatusManager.j().e(l1))
        {
            a a1 = StatusManager.j().f(l1);
            g1.a = (int)a1.b;
            g1.b = (int)a1.c;
            g1.c = a1.d;
            return true;
        }
        Object obj = com.cyberlink.youcammakeup.c.f().c(l1);
        if (obj == null)
        {
            return false;
        }
        Point point = ((r) (obj)).k();
        obj = ((r) (obj)).d();
        if (obj == UIImageOrientation.g || obj == UIImageOrientation.f || obj == UIImageOrientation.i || obj == UIImageOrientation.h)
        {
            g1.a = point.y;
            g1.b = point.x;
        } else
        {
            g1.a = point.x;
            g1.b = point.y;
        }
        g1.c = UIImageOrientation.b;
        return true;
    }

    public void b()
    {
        e();
        f();
    }

    public void b(BufferName buffername)
    {
        Object obj = g;
        obj;
        JVM INSTR monitorenter ;
        i i1;
        Object obj2;
        i1 = (i)b.get(BufferName.b);
        obj2 = (i)b.get(buffername);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        obj2.c = false;
        if (((i) (obj2)).a != null)
        {
            ((i) (obj2)).a.recycle();
            obj2.a = null;
        }
        if (i1 == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        Object obj3;
        if (!i1.c)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        obj3 = i1.a;
        i1.a = null;
        if (obj2 == null || obj3 == null)
        {
            break MISSING_BLOCK_LABEL_112;
        }
        obj2.a = ((Bitmap) (obj3));
        obj2.c = true;
        BufferName abuffername[];
        int k1;
        abuffername = BufferName.values();
        k1 = abuffername.length;
        int j1 = 0;
_L2:
        if (j1 >= k1)
        {
            break MISSING_BLOCK_LABEL_218;
        }
        obj2 = abuffername[j1];
        if (!b.containsKey(obj2))
        {
            break MISSING_BLOCK_LABEL_296;
        }
        obj3 = (i)b.get(obj2);
        if (obj3 == null || buffername == obj2)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        if (((i) (obj3)).a != null)
        {
            ((i) (obj3)).a.recycle();
            obj3.a = null;
        }
        obj3.c = false;
        if (com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.BufferName.c == obj2)
        {
            obj3.d = false;
        }
        break MISSING_BLOCK_LABEL_296;
        buffername = BufferName.values();
        k1 = buffername.length;
        Object obj1;
        Bitmap bitmap;
        for (j1 = 0; j1 >= k1; j1++)
        {
            break MISSING_BLOCK_LABEL_288;
        }

        obj1 = buffername[j1];
        if (!a.containsKey(obj1))
        {
            break MISSING_BLOCK_LABEL_305;
        }
        bitmap = (Bitmap)a.get(obj1);
        if (bitmap == null)
        {
            break MISSING_BLOCK_LABEL_305;
        }
        bitmap.recycle();
        a.put(obj1, null);
        break MISSING_BLOCK_LABEL_305;
        obj;
        JVM INSTR monitorexit ;
        return;
        buffername;
        obj;
        JVM INSTR monitorexit ;
        throw buffername;
        j1++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void c()
    {
        g();
        e();
        e.a();
        e = null;
    }

    public void d()
    {
        Object obj = p;
        obj;
        JVM INSTR monitorenter ;
        if (n.isEmpty()) goto _L2; else goto _L1
_L1:
        Integer ainteger[];
        int j1;
        ainteger = (Integer[])n.keySet().toArray(new Integer[0]);
        j1 = ainteger.length;
        int i1 = 0;
_L8:
        if (i1 >= j1) goto _L4; else goto _L3
_L3:
        Object obj1 = ainteger[i1];
        obj1 = (n)n.get(obj1);
        if (obj1 == null) goto _L6; else goto _L5
_L5:
        ((n) (obj1)).b();
          goto _L6
_L4:
        n.clear();
_L2:
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L6:
        i1++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private class BufferName extends Enum
    {

        public static final BufferName a;
        public static final BufferName b;
        public static final BufferName c;
        public static final BufferName d;
        public static final BufferName e;
        private static final BufferName f[];

        public static BufferName valueOf(String s1)
        {
            return (BufferName)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/panzoomviewer/ImageLoader$BufferName, s1);
        }

        public static BufferName[] values()
        {
            return (BufferName[])f.clone();
        }

        static 
        {
            a = new BufferName("fastBg", 0);
            b = new BufferName("cachedImage", 1);
            c = new BufferName("curView", 2);
            d = new BufferName("prevView", 3);
            e = new BufferName("nextView", 4);
            f = (new BufferName[] {
                a, b, c, d, e
            });
        }

        private BufferName(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
