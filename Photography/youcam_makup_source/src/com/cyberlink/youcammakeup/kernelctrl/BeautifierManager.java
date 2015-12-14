// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.graphics.PointF;
import android.graphics.Rect;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.jniproxy.bn;
import com.cyberlink.youcammakeup.jniproxy.c;
import com.cyberlink.youcammakeup.jniproxy.f;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.d;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.ad;
import com.cyberlink.youcammakeup.kernelctrl.status.h;
import com.cyberlink.youcammakeup.kernelctrl.status.v;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.venus.FaceAlignData;
import com.cyberlink.youcammakeup.venus.MutableInteger;
import com.pf.common.utility.m;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            h, BeautifierTaskInfo, g, e, 
//            d, f

public class BeautifierManager
    implements ad, h, v
{

    private c a;
    private f b;
    private ImageBufferWrapper c;
    private ImageBufferWrapper d;
    private ImageBufferWrapper e;
    private ImageBufferWrapper f;
    private long g;
    private ExecutorService h;
    private ArrayList i;
    private AtomicBoolean j;
    private AtomicBoolean k;
    private AtomicBoolean l;
    private y m;
    private int n;
    private boolean o;
    private boolean p;
    private ImageBufferWrapper q;
    private ImageBufferWrapper r;
    private ImageBufferWrapper s;
    private ImageBufferWrapper t;
    private com.cyberlink.youcammakeup.kernelctrl.f u;

    public BeautifierManager()
    {
        a = Globals.d().a();
        b = Globals.d().b();
        c = null;
        d = null;
        e = null;
        f = null;
        g = -1L;
        h = Executors.newFixedThreadPool(1);
        i = null;
        j = new AtomicBoolean(false);
        k = new AtomicBoolean(false);
        l = new AtomicBoolean(false);
        m = null;
        n = 0;
        q = null;
        r = null;
        s = null;
        t = null;
        u = null;
        i = new ArrayList();
        StatusManager.j().a(this);
        StatusManager.j().a(this);
        StatusManager.j().a(this);
    }

    static int a(BeautifierManager beautifiermanager, int i1)
    {
        beautifiermanager.n = i1;
        return i1;
    }

    static long a(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.g;
    }

    static long a(BeautifierManager beautifiermanager, long l1)
    {
        beautifiermanager.g = l1;
        return l1;
    }

    static y a(BeautifierManager beautifiermanager, y y)
    {
        beautifiermanager.m = y;
        return y;
    }

    public static BeautifierManager a()
    {
        return com.cyberlink.youcammakeup.kernelctrl.h.a();
    }

    static ImageBufferWrapper a(BeautifierManager beautifiermanager, ImageBufferWrapper imagebufferwrapper)
    {
        beautifiermanager.c = imagebufferwrapper;
        return imagebufferwrapper;
    }

    static void a(BeautifierManager beautifiermanager, BeautifierTaskInfo beautifiertaskinfo)
    {
        beautifiermanager.a(beautifiertaskinfo);
    }

    private void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        ImageBufferWrapper imagebufferwrapper;
        if (beautifiertaskinfo == null || !beautifiertaskinfo.d())
        {
            return;
        }
        imagebufferwrapper = new ImageBufferWrapper();
        if (beautifiertaskinfo.f() != BeautifierTaskInfo.ResultBufferType.a || e == null) goto _L2; else goto _L1
_L1:
        imagebufferwrapper.a(e);
_L4:
        beautifiertaskinfo.a(imagebufferwrapper);
        return;
_L2:
        if (beautifiertaskinfo.f() == BeautifierTaskInfo.ResultBufferType.b && f != null)
        {
            imagebufferwrapper.a(f);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static boolean a(BeautifierManager beautifiermanager, boolean flag)
    {
        beautifiermanager.o = flag;
        return flag;
    }

    static c b(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.a;
    }

    static ImageBufferWrapper b(BeautifierManager beautifiermanager, ImageBufferWrapper imagebufferwrapper)
    {
        beautifiermanager.d = imagebufferwrapper;
        return imagebufferwrapper;
    }

    static boolean b(BeautifierManager beautifiermanager, boolean flag)
    {
        beautifiermanager.p = flag;
        return flag;
    }

    static f c(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.b;
    }

    static ImageBufferWrapper c(BeautifierManager beautifiermanager, ImageBufferWrapper imagebufferwrapper)
    {
        beautifiermanager.e = imagebufferwrapper;
        return imagebufferwrapper;
    }

    static ImageBufferWrapper d(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.c;
    }

    static ImageBufferWrapper d(BeautifierManager beautifiermanager, ImageBufferWrapper imagebufferwrapper)
    {
        beautifiermanager.f = imagebufferwrapper;
        return imagebufferwrapper;
    }

    static ImageBufferWrapper e(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.d;
    }

    static ImageBufferWrapper e(BeautifierManager beautifiermanager, ImageBufferWrapper imagebufferwrapper)
    {
        beautifiermanager.q = imagebufferwrapper;
        return imagebufferwrapper;
    }

    static ImageBufferWrapper f(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.e;
    }

    static ImageBufferWrapper f(BeautifierManager beautifiermanager, ImageBufferWrapper imagebufferwrapper)
    {
        beautifiermanager.r = imagebufferwrapper;
        return imagebufferwrapper;
    }

    static ImageBufferWrapper g(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.f;
    }

    static ImageBufferWrapper g(BeautifierManager beautifiermanager, ImageBufferWrapper imagebufferwrapper)
    {
        beautifiermanager.s = imagebufferwrapper;
        return imagebufferwrapper;
    }

    static ImageBufferWrapper h(BeautifierManager beautifiermanager, ImageBufferWrapper imagebufferwrapper)
    {
        beautifiermanager.t = imagebufferwrapper;
        return imagebufferwrapper;
    }

    static AtomicBoolean h(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.j;
    }

    static AtomicBoolean i(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.k;
    }

    static y j(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.m;
    }

    static AtomicBoolean k(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.l;
    }

    static boolean l(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.o;
    }

    static ArrayList m(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.i;
    }

    static ImageBufferWrapper n(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.q;
    }

    static ImageBufferWrapper o(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.r;
    }

    static ImageBufferWrapper p(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.s;
    }

    static ImageBufferWrapper q(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.t;
    }

    static com.cyberlink.youcammakeup.kernelctrl.f r(BeautifierManager beautifiermanager)
    {
        return beautifiermanager.u;
    }

    public int a(ai ai, bn bn)
    {
        return b.a(ai, bn);
    }

    public void a(long l1)
    {
        (new g(this, TaskType.b)).executeOnExecutor(h, new Long[] {
            Long.valueOf(l1)
        });
        (new g(this, TaskType.a)).executeOnExecutor(h, new Long[] {
            Long.valueOf(l1)
        });
        j.set(true);
        k.set(false);
        l.set(true);
        m = null;
    }

    public void a(long l1, Object obj, UUID uuid)
    {
        a(l1);
    }

    public void a(d d1, BeautifierTaskInfo beautifiertaskinfo)
    {
        (new e(this, beautifiertaskinfo)).executeOnExecutor(h, new d[] {
            d1
        });
    }

    public void a(d d1, boolean flag, boolean flag1)
    {
        (new com.cyberlink.youcammakeup.kernelctrl.d(this, new BeautifierTaskInfo(flag, flag1, true, false))).executeOnExecutor(h, new d[] {
            d1
        });
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.f f1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!i.contains(f1))
        {
            i.add(f1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        f1;
        this;
        JVM INSTR monitorexit ;
        throw f1;
    }

    public void a(boolean flag)
    {
        AtomicBoolean atomicboolean = j;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        atomicboolean.set(flag);
    }

    public void a(boolean flag, float f1)
    {
        b.a(flag, f1);
    }

    public void a(byte abyte0[], int i1, int j1, int k1, boolean flag)
    {
        b.a(abyte0, i1, j1, k1, flag);
    }

    public void a(PointF apointf[], int i1, int j1)
    {
        b.a(apointf, i1, j1);
    }

    public boolean a(int i1)
    {
        return b.a(i1);
    }

    public boolean a(Rect rect)
    {
        return b.b(rect);
    }

    public boolean a(Rect rect, FaceAlignData facealigndata)
    {
        return b.a(rect, facealigndata);
    }

    public boolean a(Rect rect, MutableInteger mutableinteger)
    {
        return b.b(rect, mutableinteger);
    }

    public boolean a(com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter.LipStickProfile lipstickprofile)
    {
        return b.c(lipstickprofile);
    }

    public boolean a(ai ai)
    {
        return b.a(ai);
    }

    public boolean a(MutableInteger mutableinteger)
    {
        return b.a(mutableinteger);
    }

    public boolean a(MutableInteger mutableinteger, ArrayList arraylist, int i1, int j1, int k1, int ai[], float f1, 
            float f2, boolean flag)
    {
        return b.a(mutableinteger, arraylist, i1, j1, k1, ai, f1, f2, flag);
    }

    public boolean a(String s1, String s2)
    {
        return b.a(s1, s2);
    }

    public boolean a(ArrayList arraylist, int i1)
    {
        return b.a(arraylist, i1);
    }

    public boolean a(byte abyte0[], byte abyte1[][], int i1, int j1, int k1, int l1, int i2)
    {
        return b.a(abyte0, abyte1, i1, j1, k1, l1, i2);
    }

    public boolean a(int ai[], byte abyte0[][], int ai1[], int ai2[], int i1, int j1, int k1, 
            int l1, int i2, int ai3[], int j2, int k2, int l2, byte abyte1[], 
            byte abyte2[], byte abyte3[])
    {
        return b.a(ai, abyte0, ai1, ai2, i1, j1, k1, l1, i2, ai3, j2, k2, l2, abyte1, abyte2, abyte3);
    }

    public boolean a(com.cyberlink.clgpuimage.CLMakeupLiveEyeFilter.LiveEyeMakeupMetadata aliveeyemakeupmetadata[], com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter.LipstickData lipstickdata, com.cyberlink.clgpuimage.CLMakeupLiveBlushFilter.LiveBlushMakeupdata liveblushmakeupdata, com.cyberlink.clgpuimage.CLMakeupLiveSmoothFilter.LiveSmoothMetadata livesmoothmetadata, com.cyberlink.clgpuimage.CLMakeupLiveFilter.LiveFrameInformation liveframeinformation)
    {
        return b.a(aliveeyemakeupmetadata, lipstickdata, liveblushmakeupdata, livesmoothmetadata, liveframeinformation);
    }

    public void b()
    {
        j.set(true);
        k.set(false);
        l.set(true);
        m = null;
    }

    public void b(com.cyberlink.youcammakeup.kernelctrl.f f1)
    {
        this;
        JVM INSTR monitorenter ;
        if (i.contains(f1))
        {
            i.remove(f1);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        f1;
        this;
        JVM INSTR monitorexit ;
        throw f1;
    }

    protected void b(boolean flag)
    {
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        if (f != null && f.j() != null)
        {
            ViewEngine.a().a(g, f);
            return;
        }
        try
        {
            ViewEngine.a().a(g, e);
            return;
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            com.pf.common.utility.m.e("BeautifierManager", "setViewEngineSourceBuffer IllegalArgumentException !!!");
        }
        return;
    }

    public boolean b(byte abyte0[], byte abyte1[][], int i1, int j1, int k1, int l1, int i2)
    {
        return b.b(abyte0, abyte1, i1, j1, k1, l1, i2);
    }

    public void c()
    {
        k.set(false);
    }

    public void c(com.cyberlink.youcammakeup.kernelctrl.f f1)
    {
        u = f1;
    }

    public void d()
    {
        (new g(this, com.cyberlink.youcammakeup.kernelctrl.TaskType.c)).executeOnExecutor(h, new Long[] {
            Long.valueOf(g)
        });
    }

    public int e()
    {
        return n;
    }

    public boolean f()
    {
        return o;
    }

    public ImageBufferWrapper g()
    {
        return t;
    }

    public void h()
    {
        this;
        JVM INSTR monitorenter ;
        if (!p)
        {
            if (q != null)
            {
                q.n();
                q = null;
            }
            if (r != null)
            {
                r.n();
                r = null;
            }
            if (s != null)
            {
                s.n();
                s = null;
            }
            if (t != null)
            {
                t.n();
                t = null;
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void i()
    {
        u = null;
    }

    public boolean j()
    {
        if (!b.b())
        {
            return false;
        } else
        {
            return b.j();
        }
    }

    public boolean k()
    {
        return b.k();
    }

    private class TaskType extends Enum
    {

        public static final TaskType a;
        public static final TaskType b;
        public static final TaskType c;
        private static final TaskType d[];

        public static TaskType valueOf(String s1)
        {
            return (TaskType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/BeautifierManager$TaskType, s1);
        }

        public static TaskType[] values()
        {
            return (TaskType[])d.clone();
        }

        static 
        {
            a = new TaskType("SET_IMAGE", 0);
            b = new TaskType("RELEASE_IMAGE", 1);
            c = new TaskType("FACE_CHANGE", 2);
            d = (new TaskType[] {
                a, b, c
            });
        }

        private TaskType(String s1, int i1)
        {
            super(s1, i1);
        }
    }

}
