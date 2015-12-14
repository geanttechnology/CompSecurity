// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.FaceDetector;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.clflurry.au;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.aa;
import com.cyberlink.youcammakeup.jniproxy.ab;
import com.cyberlink.youcammakeup.jniproxy.ac;
import com.cyberlink.youcammakeup.jniproxy.ad;
import com.cyberlink.youcammakeup.jniproxy.ae;
import com.cyberlink.youcammakeup.jniproxy.af;
import com.cyberlink.youcammakeup.jniproxy.ag;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.jniproxy.aj;
import com.cyberlink.youcammakeup.jniproxy.ak;
import com.cyberlink.youcammakeup.jniproxy.av;
import com.cyberlink.youcammakeup.jniproxy.ax;
import com.cyberlink.youcammakeup.jniproxy.az;
import com.cyberlink.youcammakeup.jniproxy.bi;
import com.cyberlink.youcammakeup.jniproxy.bj;
import com.cyberlink.youcammakeup.jniproxy.bl;
import com.cyberlink.youcammakeup.jniproxy.bm;
import com.cyberlink.youcammakeup.jniproxy.bn;
import com.cyberlink.youcammakeup.jniproxy.f;
import com.cyberlink.youcammakeup.jniproxy.r;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.jniproxy.z;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.k;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.q;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.s;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.d;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.o;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.bb;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c;
import com.pf.common.utility.m;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl:
//            ba, ao, ar, az, 
//            at, t, a, BeautifierManager, 
//            aq, aw, as, ap, 
//            au, ay

public class VenusHelper
{

    private static Map g = new HashMap();
    public Object a;
    public final Object b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    private ExecutorService h;
    private Handler i;
    private f j;
    private ba k;
    private final ao l;
    private final ao m;
    private final ao n;
    private final ao o;
    private final ao p;
    private boolean q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private ImageBufferWrapper v;
    private ae w;
    private ae x;
    private final String y;
    private ConcurrentHashMap z;

    private VenusHelper()
    {
        g.put(UIImageOrientation.b, UIImageOrientation.b);
        g.put(UIImageOrientation.d, UIImageOrientation.d);
        g.put(UIImageOrientation.c, UIImageOrientation.c);
        g.put(UIImageOrientation.e, UIImageOrientation.e);
        g.put(UIImageOrientation.f, UIImageOrientation.f);
        g.put(UIImageOrientation.h, UIImageOrientation.h);
        g.put(UIImageOrientation.g, UIImageOrientation.i);
        g.put(UIImageOrientation.i, UIImageOrientation.g);
        g.put(UIImageOrientation.a, UIImageOrientation.a);
        h = Executors.newFixedThreadPool(1);
        i = new Handler(Looper.getMainLooper());
        j = Globals.d().b();
        k = new ba();
        a = new Object();
        l = new ao();
        b = l;
        m = new ao();
        c = m;
        n = new ao();
        d = n;
        o = new ao();
        e = o;
        p = new ao();
        f = p;
        q = false;
        r = false;
        s = false;
        t = false;
        u = false;
        v = null;
        w = null;
        x = null;
        y = (new StringBuilder()).append(Globals.d().q()).append("/hairDyeMask").toString();
        z = null;
    }


    private void H()
    {
        while (!j.b()) 
        {
            try
            {
                c("[waitForVenusModuleLoaded] Venus model has not been loaded. Wait for 10ms");
                Thread.sleep(10L);
            }
            catch (InterruptedException interruptedexception)
            {
                interruptedexception.printStackTrace();
            }
        }
    }

    static int a(VenusHelper venushelper, boolean flag, Float float1, Float float2)
    {
        return venushelper.a(flag, float1, float2);
    }

    public static int a(List list)
    {
        if (list == null || list.size() == 0)
        {
            throw new IllegalArgumentException("Face list can not be null nor empty.");
        }
        if (list.size() == 1)
        {
            return 0;
        }
        int i1 = 0;
        int j1 = -1;
        int k1 = -1;
        while (i1 < list.size()) 
        {
            int l1;
label0:
            {
                ar ar1 = (ar)list.get(i1);
                l1 = ar1.b.d();
                int i2 = ar1.b.b();
                i2 = ((ar1.b.e() - ar1.b.c()) + 1) * ((l1 - i2) + 1);
                if (k1 != -1)
                {
                    l1 = j1;
                    if (i2 <= j1)
                    {
                        break label0;
                    }
                }
                l1 = i2;
                k1 = i1;
            }
            i1++;
            j1 = l1;
        }
        return k1;
    }

    private int a(boolean flag, Float float1, Float float2)
    {
        int i1;
        byte byte0;
        byte0 = -1;
        if (v != null)
        {
            v.m();
            v = null;
        }
        i1 = byte0;
        if (v != null) goto _L2; else goto _L1
_L1:
        d d1;
        int j1;
        long l1 = StatusManager.j().l();
        d1 = ViewEngine.a().a(l1);
        j1 = byte0;
        if (d1 == null) goto _L4; else goto _L3
_L3:
        j1 = byte0;
        if (d1.a == null) goto _L4; else goto _L5
_L5:
        if (d1.b != null) goto _L7; else goto _L6
_L6:
        j1 = byte0;
_L4:
        return j1;
_L7:
        v = new ImageBufferWrapper();
        v.a(d1.a.a, d1.a.b, 4L);
        if (!flag) goto _L9; else goto _L8
_L8:
        j1 = byte0;
        if (w == null) goto _L4; else goto _L10
_L10:
        j1 = byte0;
        if (w.b() < 1L) goto _L4; else goto _L11
_L11:
        v.j().a(w.a(0));
_L14:
        if (float1 != null && float2 != null)
        {
            float f1 = Math.min(float1.floatValue(), float2.floatValue());
            float1 = ViewEngine.a().a(v, f1);
            i1 = byte0;
            if (float1 != null)
            {
                i1 = j.c(float1.j());
                float1.m();
            }
        } else
        {
            i1 = j.c(v.j());
        }
_L2:
        j1 = i1;
        if (v != null)
        {
            v.m();
            v = null;
            return i1;
        }
          goto _L4
_L9:
        j1 = byte0;
        if (x == null) goto _L4; else goto _L12
_L12:
        j1 = byte0;
        if (x.b() < 1L) goto _L4; else goto _L13
_L13:
        v.j().a(x.a((int)(x.b() - 1L)));
          goto _L14
    }

    private static UIImageOrientation a(UIImageOrientation uiimageorientation)
    {
        return (UIImageOrientation)g.get(uiimageorientation);
    }

    static ae a(VenusHelper venushelper, ae ae1)
    {
        venushelper.w = ae1;
        return ae1;
    }

    private static ah a(long l1, long l2, ah ah1, UIImageOrientation uiimageorientation)
    {
        ah ah2 = new ah();
        if (uiimageorientation == UIImageOrientation.b || uiimageorientation == UIImageOrientation.a || uiimageorientation == null)
        {
            ah2.a(ah1.b());
            ah2.b(ah1.c());
        } else
        {
            if (uiimageorientation == UIImageOrientation.g)
            {
                ah2.a((float)l2 - ah1.c() - 1.0F);
                ah2.b(ah1.b());
                return ah2;
            }
            if (uiimageorientation == UIImageOrientation.d)
            {
                ah2.a((float)l1 - ah1.b() - 1.0F);
                ah2.b((float)l2 - ah1.c() - 1.0F);
                return ah2;
            }
            if (uiimageorientation == UIImageOrientation.i)
            {
                ah2.a(ah1.c());
                ah2.b((float)l1 - ah1.b() - 1.0F);
                return ah2;
            }
            if (uiimageorientation == UIImageOrientation.c)
            {
                ah2.a((float)l1 - ah1.b() - 1.0F);
                ah2.b(ah1.c());
                return ah2;
            }
            if (uiimageorientation == UIImageOrientation.e)
            {
                ah2.a(ah1.b());
                ah2.b((float)l2 - ah1.c() - 1.0F);
                return ah2;
            }
            if (uiimageorientation == UIImageOrientation.f)
            {
                ah2.a(ah1.c());
                ah2.b(ah1.b());
                return ah2;
            }
            if (uiimageorientation == UIImageOrientation.h)
            {
                ah2.a((float)l2 - ah1.c() - 1.0F);
                ah2.b((float)l1 - ah1.b() - 1.0F);
                return ah2;
            }
        }
        return ah2;
    }

    public static ai a(long l1, long l2, ai ai1, UIImageOrientation uiimageorientation)
    {
        ai ai2 = new ai();
        if (uiimageorientation == UIImageOrientation.b || uiimageorientation == UIImageOrientation.a || uiimageorientation == null)
        {
            ai2.a(ai1.b());
            ai2.b(ai1.c());
            ai2.c(ai1.d());
            ai2.d(ai1.e());
        } else
        {
            if (uiimageorientation == UIImageOrientation.g)
            {
                ai2.a((int)l2 - ai1.e() - 1);
                ai2.b(ai1.b());
                ai2.c((int)l2 - ai1.c() - 1);
                ai2.d(ai1.d());
                return ai2;
            }
            if (uiimageorientation == UIImageOrientation.d)
            {
                ai2.a((int)l1 - ai1.d() - 1);
                ai2.b((int)l2 - ai1.e() - 1);
                ai2.c((int)l1 - ai1.b() - 1);
                ai2.d((int)l2 - ai1.c() - 1);
                return ai2;
            }
            if (uiimageorientation == UIImageOrientation.i)
            {
                ai2.a(ai1.c());
                ai2.b((int)l1 - ai1.d() - 1);
                ai2.c(ai1.e());
                ai2.d((int)l1 - ai1.b() - 1);
                return ai2;
            }
            if (uiimageorientation == UIImageOrientation.c)
            {
                ai2.a((int)l1 - ai1.d() - 1);
                ai2.b(ai1.c());
                ai2.c((int)l1 - ai1.b() - 1);
                ai2.d(ai1.e());
                return ai2;
            }
            if (uiimageorientation == UIImageOrientation.e)
            {
                ai2.a(ai1.b());
                ai2.b((int)l2 - ai1.e() - 1);
                ai2.c(ai1.d());
                ai2.d((int)l2 - ai1.c() - 1);
                return ai2;
            }
            if (uiimageorientation == UIImageOrientation.f)
            {
                ai2.a(ai1.c());
                ai2.b(ai1.b());
                ai2.c(ai1.e());
                ai2.d(ai1.d());
                return ai2;
            }
            if (uiimageorientation == UIImageOrientation.h)
            {
                ai2.a((int)l2 - ai1.e() - 1);
                ai2.b((int)l1 - ai1.d() - 1);
                ai2.c((int)l2 - ai1.c() - 1);
                ai2.d((int)l1 - ai1.b() - 1);
                return ai2;
            }
        }
        return ai2;
    }

    private static y a(long l1, long l2, y y1, UIImageOrientation uiimageorientation)
    {
        y y2 = new y();
        Object obj = y2.b();
        ((z) (obj)).a(a(l1, l2, y1.b().b(), uiimageorientation));
        ((z) (obj)).b(a(l1, l2, y1.b().c(), uiimageorientation));
        ((z) (obj)).c(a(l1, l2, y1.b().d(), uiimageorientation));
        ((z) (obj)).d(a(l1, l2, y1.b().e(), uiimageorientation));
        y2.a(((z) (obj)));
        obj = y2.c();
        ((z) (obj)).a(a(l1, l2, y1.c().b(), uiimageorientation));
        ((z) (obj)).b(a(l1, l2, y1.c().c(), uiimageorientation));
        ((z) (obj)).c(a(l1, l2, y1.c().d(), uiimageorientation));
        ((z) (obj)).d(a(l1, l2, y1.c().e(), uiimageorientation));
        y2.b(((z) (obj)));
        obj = y2.d();
        ((ac) (obj)).a(a(l1, l2, y1.d().b(), uiimageorientation));
        ((ac) (obj)).b(a(l1, l2, y1.d().c(), uiimageorientation));
        ((ac) (obj)).c(a(l1, l2, y1.d().d(), uiimageorientation));
        ((ac) (obj)).d(a(l1, l2, y1.d().e(), uiimageorientation));
        ((ac) (obj)).e(a(l1, l2, y1.d().f(), uiimageorientation));
        y2.a(((ac) (obj)));
        obj = y2.e();
        ((ac) (obj)).a(a(l1, l2, y1.e().b(), uiimageorientation));
        ((ac) (obj)).b(a(l1, l2, y1.e().c(), uiimageorientation));
        ((ac) (obj)).c(a(l1, l2, y1.e().d(), uiimageorientation));
        ((ac) (obj)).d(a(l1, l2, y1.e().e(), uiimageorientation));
        ((ac) (obj)).e(a(l1, l2, y1.e().f(), uiimageorientation));
        y2.b(((ac) (obj)));
        obj = y2.f();
        ((ab) (obj)).a(a(l1, l2, y1.f().b(), uiimageorientation));
        ((ab) (obj)).b(a(l1, l2, y1.f().c(), uiimageorientation));
        y2.a(((ab) (obj)));
        obj = y2.g();
        ((ab) (obj)).a(a(l1, l2, y1.g().b(), uiimageorientation));
        ((ab) (obj)).b(a(l1, l2, y1.g().c(), uiimageorientation));
        y2.b(((ab) (obj)));
        obj = y2.h();
        ((ak) (obj)).a(a(l1, l2, y1.h().b(), uiimageorientation));
        ((ak) (obj)).b(a(l1, l2, y1.h().c(), uiimageorientation));
        y2.a(((ak) (obj)));
        obj = y2.i();
        ((ak) (obj)).a(a(l1, l2, y1.i().b(), uiimageorientation));
        ((ak) (obj)).b(a(l1, l2, y1.i().c(), uiimageorientation));
        y2.b(((ak) (obj)));
        obj = y2.j();
        ((ag) (obj)).a(a(l1, l2, y1.j().b(), uiimageorientation));
        ((ag) (obj)).b(a(l1, l2, y1.j().c(), uiimageorientation));
        ((ag) (obj)).c(a(l1, l2, y1.j().d(), uiimageorientation));
        ((ag) (obj)).d(a(l1, l2, y1.j().e(), uiimageorientation));
        ((ag) (obj)).e(a(l1, l2, y1.j().f(), uiimageorientation));
        y2.a(((ag) (obj)));
        obj = y2.k();
        ((af) (obj)).a(a(l1, l2, y1.k().b(), uiimageorientation));
        ((af) (obj)).d(a(l1, l2, y1.k().e(), uiimageorientation));
        ((af) (obj)).b(a(l1, l2, y1.k().c(), uiimageorientation));
        ((af) (obj)).c(a(l1, l2, y1.k().d(), uiimageorientation));
        ((af) (obj)).e(a(l1, l2, y1.k().f(), uiimageorientation));
        ((af) (obj)).f(a(l1, l2, y1.k().g(), uiimageorientation));
        ((af) (obj)).g(a(l1, l2, y1.k().h(), uiimageorientation));
        ((af) (obj)).h(a(l1, l2, y1.k().i(), uiimageorientation));
        ((af) (obj)).i(a(l1, l2, y1.k().j(), uiimageorientation));
        ((af) (obj)).j(a(l1, l2, y1.k().k(), uiimageorientation));
        ((af) (obj)).k(a(l1, l2, y1.k().l(), uiimageorientation));
        ((af) (obj)).l(a(l1, l2, y1.k().m(), uiimageorientation));
        ((af) (obj)).m(a(l1, l2, y1.k().n(), uiimageorientation));
        ((af) (obj)).n(a(l1, l2, y1.k().o(), uiimageorientation));
        ((af) (obj)).o(a(l1, l2, y1.k().p(), uiimageorientation));
        ((af) (obj)).p(a(l1, l2, y1.k().q(), uiimageorientation));
        y2.a(((af) (obj)));
        obj = y2.l();
        ((aa) (obj)).a(a(l1, l2, y1.l().b(), uiimageorientation));
        y2.a(((aa) (obj)));
        obj = y2.m();
        ((ad) (obj)).a(a(l1, l2, y1.m().b(), uiimageorientation));
        ((ad) (obj)).b(a(l1, l2, y1.m().c(), uiimageorientation));
        ((ad) (obj)).c(a(l1, l2, y1.m().d(), uiimageorientation));
        y2.a(((ad) (obj)));
        return y2;
    }

    public static VenusHelper a()
    {
        return az.a();
    }

    static ImageBufferWrapper a(VenusHelper venushelper, ImageBufferWrapper imagebufferwrapper)
    {
        venushelper.v = imagebufferwrapper;
        return imagebufferwrapper;
    }

    public static List a(long l1, long l2, List list, UIImageOrientation uiimageorientation)
    {
        if (list == null || list.size() == 0)
        {
            return list;
        }
        ArrayList arraylist = new ArrayList();
        ar ar2;
        for (list = list.iterator(); list.hasNext(); arraylist.add(ar2))
        {
            ar ar1 = (ar)list.next();
            ar2 = new ar(ar1.a);
            ar2.b = a(l1, l2, ar1.b, uiimageorientation);
            ar2.c = a(l1, l2, ar1.c, uiimageorientation);
            ar2.d = ar1.d;
            ar2.e = ar1.e;
            ar2.f = ar1.f;
            ar2.g = ar1.g;
        }

        return arraylist;
    }

    static List a(VenusHelper venushelper, ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation)
    {
        return venushelper.a(imagebufferwrapper, uiimageorientation);
    }

    private List a(ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation)
    {
        imagebufferwrapper.l();
        H();
        ImageBufferWrapper imagebufferwrapper1 = b(imagebufferwrapper, uiimageorientation);
        int l1 = j.a(imagebufferwrapper1.j());
        c((new StringBuilder()).append("[detectFaces] faceCount=").append(l1).toString());
        G();
        ArrayList arraylist = new ArrayList();
        aj aj1 = new aj();
        if (l1 > 0)
        {
            int i1 = j.a(l1, aj1);
            c((new StringBuilder()).append("[detectFaces] uiVenus.GetFaceInfos iRet=").append(i1).toString());
            for (int j1 = 0; j1 < l1; j1++)
            {
                ai ai1 = new ai(aj1.a(j1));
                c((new StringBuilder()).append("[detectFaces] face ").append(j1).append(": ").append(ai1.b()).append(", ").append(ai1.c()).append(", ").append(ai1.d()).append(", ").append(ai1.e()).toString());
                y y1 = new y();
                int j2 = j.a(ai1, y1);
                c((new StringBuilder()).append("[detectFaces] face ").append(j1).append(": uiVenus.GetFaceAlignmentData iRet=").append(j2).toString());
                ax ax1 = new ax();
                j2 = j.a(ai1, ax1);
                c((new StringBuilder()).append("[detectFaces] face ").append(j1).append(": uiVenus.GetIrisRadius iRet=").append(j2).append(" iris radius = ").append(ax1.b()).toString());
                bn bn1 = new bn();
                j2 = j.a(ai1, bn1);
                c((new StringBuilder()).append("[detectFaces] face ").append(j1).append(": uiVenus.GetAutoWigLuminanceParameter iRet=").append(j2).append(" wig luminance = ").append(bn1.b()).toString());
                boolean flag = j.a(ai1);
                c((new StringBuilder()).append("[detectFaces] face ").append(j1).append(": uiVenus.DetectOpenMouth boolean = ").append(flag).toString());
                ar ar1 = new ar(j1);
                ar1.b = ai1;
                ar1.c = y1;
                ar1.d = ax1;
                ar1.e = bn1;
                ar1.f = flag;
                ar1.g = new com.cyberlink.youcammakeup.kernelctrl.at();
                arraylist.add(ar1);
            }

        } else
        {
            com.pf.common.utility.m.b("VenusHelper", "Use OS face detection!");
            float f1;
            Object obj;
            if (imagebufferwrapper1.c() > (long)1280 || imagebufferwrapper1.b() > (long)1280)
            {
                f1 = Math.min((float)1280 / (float)imagebufferwrapper1.b(), (float)1280 / (float)imagebufferwrapper1.c());
                obj = ViewEngine.a().a(imagebufferwrapper1, f1);
            } else
            {
                imagebufferwrapper1.l();
                f1 = 1.0F;
                obj = imagebufferwrapper1;
            }
            if (obj != null)
            {
                Bitmap bitmap = com.cyberlink.youcammakeup.kernelctrl.t.a(((ImageBufferWrapper) (obj)), false);
                ((ImageBufferWrapper) (obj)).m();
                obj = com.cyberlink.youcammakeup.utility.aa.a(bitmap, true);
                bitmap.recycle();
                FaceDetector facedetector = new FaceDetector(((Bitmap) (obj)).getWidth(), ((Bitmap) (obj)).getHeight(), 10);
                android.media.FaceDetector.Face aface[] = new android.media.FaceDetector.Face[10];
                int i2 = facedetector.findFaces(((Bitmap) (obj)), aface);
                for (int k1 = 0; k1 < i2; k1++)
                {
                    Object obj1 = new PointF();
                    aface[k1].getMidPoint(((PointF) (obj1)));
                    float f2 = aface[k1].eyesDistance();
                    Object obj2 = new Rect();
                    f2 *= 2.0F;
                    obj2.left = (int)((((PointF) (obj1)).x - f2 / 2.0F) / f1);
                    obj2.left = Math.max(0, ((Rect) (obj2)).left);
                    obj2.top = (int)((((PointF) (obj1)).y - f2 / 3F) / f1);
                    obj2.top = Math.max(0, ((Rect) (obj2)).top);
                    obj2.right = (int)((((PointF) (obj1)).x + f2 / 2.0F) / f1);
                    obj2.right = Math.min((int)imagebufferwrapper1.b(), ((Rect) (obj2)).right);
                    obj2.bottom = (int)((((PointF) (obj1)).y + (f2 * 2.0F) / 3F) / f1);
                    obj2.bottom = Math.min((int)imagebufferwrapper1.c(), ((Rect) (obj2)).bottom);
                    obj1 = new ai();
                    ((ai) (obj1)).a(((Rect) (obj2)).left);
                    ((ai) (obj1)).b(((Rect) (obj2)).top);
                    ((ai) (obj1)).c(((Rect) (obj2)).right);
                    ((ai) (obj1)).d(((Rect) (obj2)).bottom);
                    com.pf.common.utility.m.b("VenusHelper", (new StringBuilder()).append("[detectFaces] face ").append(k1).append(": ").append(((ai) (obj1)).b()).append(", ").append(((ai) (obj1)).c()).append(", ").append(((ai) (obj1)).d()).append(", ").append(((ai) (obj1)).e()).toString());
                    obj2 = new y();
                    int k2 = j.a(((ai) (obj1)), ((y) (obj2)));
                    c((new StringBuilder()).append("[detectFaces] face ").append(k1).append(": uiVenus.GetFaceAlignmentData iRet=").append(k2).toString());
                    ax ax2 = new ax();
                    k2 = j.a(((ai) (obj1)), ax2);
                    c((new StringBuilder()).append("[detectFaces] face ").append(k1).append(": uiVenus.GetIrisRadius iRet=").append(k2).append(" iris radius = ").append(ax2.b()).toString());
                    bn bn2 = new bn();
                    k2 = j.a(((ai) (obj1)), bn2);
                    c((new StringBuilder()).append("[detectFaces] face ").append(k1).append(": uiVenus.GetAutoWigLuminanceParameter iRet=").append(k2).append(" wig luminance = ").append(bn2.b()).toString());
                    boolean flag1 = j.a(((ai) (obj1)));
                    c((new StringBuilder()).append("[detectFaces] face ").append(k1).append(": uiVenus.DetectOpenMouth boolean = ").append(flag1).toString());
                    ar ar2 = new ar(k1);
                    ar2.b = ((ai) (obj1));
                    ar2.c = ((y) (obj2));
                    ar2.d = ax2;
                    ar2.e = bn2;
                    ar2.f = flag1;
                    arraylist.add(ar2);
                }

                ((Bitmap) (obj)).recycle();
            }
        }
        uiimageorientation = a(uiimageorientation);
        uiimageorientation = a(imagebufferwrapper1.b(), imagebufferwrapper1.c(), ((List) (arraylist)), uiimageorientation);
        imagebufferwrapper1.m();
        imagebufferwrapper.m();
        return uiimageorientation;
    }

    static ExecutorService a(VenusHelper venushelper)
    {
        return venushelper.h;
    }

    private void a(ae ae1)
    {
        if (ae1 != null)
        {
            for (int i1 = 0; (long)i1 < ae1.b(); i1++)
            {
                if (ae1.a(i1) != null)
                {
                    bb.b(new File(ae1.a(i1)));
                }
            }

        }
    }

    private void a(aw aw1)
    {
        if (aw1 != null && aw1.i() != null && aw1.i().size() >= 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        at at1 = (at)aw1.i().get(0);
        aw1 = Globals.d().getResources().openRawResource(0x7f0208e9);
        if (aw1 == null)
        {
            break MISSING_BLOCK_LABEL_290;
        }
        Object obj;
        obj = BitmapFactory.decodeStream(aw1, null, MotionControlHelper.d);
        aw1.close();
        Object obj1;
        for (; obj == null; obj = null)
        {
            break MISSING_BLOCK_LABEL_285;
        }

        aw1 = new ImageBufferWrapper();
        aw1.b(((Bitmap) (obj)));
        obj1 = new r();
        ((r) (obj1)).a(at1.a().intValue());
        ((r) (obj1)).b(at1.b().intValue());
        ((r) (obj1)).c(at1.c().intValue());
        j.a(aw1.j(), ((r) (obj1)));
        aw1.k();
        obj1 = (new StringBuilder()).append(y).append("/").append(UUID.randomUUID().toString()).toString();
        com.cyberlink.youcammakeup.utility.aa.a(((Bitmap) (obj)), android.graphics.Bitmap.CompressFormat.JPEG, ((String) (obj1)), false);
        if (z == null)
        {
            z = new ConcurrentHashMap();
        }
        z.put(at1.i(), obj1);
_L8:
        if (aw1 != null)
        {
            aw1.m();
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        aw1;
        aw1 = null;
_L7:
        com.pf.common.utility.m.e("VenusHelper", "getHairDyeThumbnail exception !!!");
        if (aw1 == null) goto _L1; else goto _L4
_L4:
        aw1.m();
        return;
        obj;
        aw1 = null;
_L6:
        if (aw1 != null)
        {
            aw1.m();
        }
        throw obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L6; else goto _L5
_L5:
        obj;
          goto _L7
        aw1 = null;
          goto _L8
    }

    static boolean a(VenusHelper venushelper, boolean flag)
    {
        venushelper.t = flag;
        return flag;
    }

    static ae b(VenusHelper venushelper, ae ae1)
    {
        venushelper.x = ae1;
        return ae1;
    }

    static f b(VenusHelper venushelper)
    {
        return venushelper.j;
    }

    private ImageBufferWrapper b(ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation)
    {
        if (uiimageorientation == UIImageOrientation.b || uiimageorientation == UIImageOrientation.a || uiimageorientation == null)
        {
            imagebufferwrapper.l();
            return imagebufferwrapper;
        } else
        {
            ImageBufferWrapper imagebufferwrapper1 = new ImageBufferWrapper();
            imagebufferwrapper1.name = "VenusRotated";
            imagebufferwrapper1.a(imagebufferwrapper, uiimageorientation);
            return imagebufferwrapper1;
        }
    }

    static boolean b(VenusHelper venushelper, boolean flag)
    {
        venushelper.u = flag;
        return flag;
    }

    private ao c(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType accessorytype)
    {
        class _cls6
        {

            static final int a[];

            static 
            {
                a = new int[com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    a[com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.d.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.e.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls6.a[accessorytype.ordinal()])
        {
        default:
            throw new AssertionError();

        case 1: // '\001'
            return l;

        case 2: // '\002'
            return m;

        case 3: // '\003'
            return n;

        case 4: // '\004'
            return o;

        case 5: // '\005'
            return p;
        }
    }

    static ImageBufferWrapper c(VenusHelper venushelper)
    {
        return venushelper.v;
    }

    private void c(String s1)
    {
        com.pf.common.utility.m.b("VenusHelper", s1);
    }

    static String d(VenusHelper venushelper)
    {
        return venushelper.y;
    }

    static ae e(VenusHelper venushelper)
    {
        return venushelper.w;
    }

    static boolean f(VenusHelper venushelper)
    {
        return venushelper.u;
    }

    static ae g(VenusHelper venushelper)
    {
        return venushelper.x;
    }

    public void A()
    {
        synchronized (f)
        {
            if (com.cyberlink.youcammakeup.utility.aa.b(p.b))
            {
                Bitmap bitmap = p.b;
                Matrix matrix = new Matrix();
                matrix.preScale(-1F, 1.0F);
                p.b = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
                bitmap.recycle();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void B()
    {
        synchronized (e)
        {
            o.a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void C()
    {
        synchronized (f)
        {
            p.a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean D()
    {
        return o.b();
    }

    public boolean E()
    {
        return p.b();
    }

    public void F()
    {
        if (y != null)
        {
            bb.b(new File(y));
            bb.a(y);
        }
        if (w != null)
        {
            w.c();
            w = null;
        }
        if (x != null)
        {
            x.c();
            x = null;
        }
        if (z != null)
        {
            z.clear();
            z = null;
        }
    }

    public void G()
    {
        bj bj1 = new bj();
        if (j.a(bj1) == 0)
        {
            switch (bj1.b())
            {
            case 1: // '\001'
            default:
                return;

            case 0: // '\0'
                com.pf.common.utility.m.e("VenusHelper", "extractUserProfile, information is NOT ready yet, need check!!");
                return;

            case 2: // '\002'
                com.pf.common.utility.m.b("VenusHelper", (new StringBuilder()).append("extractUserProfile, need update, gender = ").append(bj1.c()).append(", skin color = ").append(bj1.d()).append(", hair color = ").append(bj1.e()).append(", eyebrow color = ").append(bj1.f()).append(", iris color = ").append(bj1.g()).append(", lip color = ").append(bj1.h()).toString());
                break;
            }
            com.cyberlink.youcammakeup.clflurry.b.a(new au(bj1.c(), bj1.d(), bj1.e(), bj1.f(), bj1.g(), bj1.h()));
            return;
        } else
        {
            com.pf.common.utility.m.e("VenusHelper", "extractUserProfile failed");
            return;
        }
    }

    public int a(boolean flag, int i1)
    {
        Object obj;
        Object obj1;
        int j1;
        obj = null;
        j1 = -1;
        obj1 = obj;
        long l1 = StatusManager.j().l();
        obj1 = obj;
        obj = StatusManager.j().c(l1).g().b();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        obj1 = ViewEngine.a().a(l1, 1.0D, null);
        obj = obj1;
        if (obj != null) goto _L2; else goto _L1
_L1:
        i1 = j1;
        if (obj != null)
        {
            ((ImageBufferWrapper) (obj)).m();
            i1 = j1;
        }
_L4:
        return i1;
_L2:
        obj1 = obj;
        Object obj2 = ViewEngine.a().a(l1);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        obj1 = obj;
        obj2 = ((d) (obj2)).a;
        if (obj2 != null)
        {
            break; /* Loop/switch isn't completed */
        }
        i1 = j1;
        if (obj != null)
        {
            ((ImageBufferWrapper) (obj)).m();
            return -1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        obj1 = obj;
        obj2 = com.cyberlink.youcammakeup.kernelctrl.a.a().a(false);
        obj1 = obj;
        ((ByteBuffer) (obj2)).rewind();
        obj1 = obj;
        i1 = j.a(((ImageBufferWrapper) (obj)).j(), ((ByteBuffer) (obj2)), flag, i1);
        j1 = i1;
        i1 = j1;
        if (obj == null) goto _L4; else goto _L5
_L5:
        ((ImageBufferWrapper) (obj)).m();
        return j1;
        obj1;
        obj = null;
_L9:
        com.pf.common.utility.m.b("VenusHelper", "updateHairDyeMask exception!!", ((Throwable) (obj1)));
        i1 = j1;
        if (obj == null) goto _L4; else goto _L6
_L6:
        ((ImageBufferWrapper) (obj)).m();
        return -1;
        obj;
_L8:
        if (obj1 != null)
        {
            ((ImageBufferWrapper) (obj1)).m();
        }
        throw obj;
        Exception exception;
        exception;
        obj1 = obj;
        obj = exception;
        continue; /* Loop/switch isn't completed */
        exception;
        obj1 = obj;
        obj = exception;
        if (true) goto _L8; else goto _L7
_L7:
        obj1;
          goto _L9
        obj1;
          goto _L9
    }

    public av a(ai ai1)
    {
        av av1 = new av();
        j.a(ai1, av1);
        return av1;
    }

    public az a(az az1, int i1)
    {
        com.pf.common.utility.m.b("VenusHelper", "GetLookParameters input params: ");
        az1.r();
        az az2 = new az();
        if (j.a(az1, i1, az2) == 0)
        {
            com.pf.common.utility.m.b("VenusHelper", "GetLookParameters output params: ");
            az2.r();
            if ((float)az1.d() == -1F)
            {
                az2.c(az1.d());
            }
            if ((float)az1.e() == -1F)
            {
                az2.d(az1.e());
            }
            if ((float)az1.b() == -1F)
            {
                az2.a(az1.b());
            }
            if ((float)az1.c() == -1F)
            {
                az2.b(az1.c());
            }
            if ((float)az1.f() == -1F)
            {
                az2.e(az1.f());
            }
        }
        return az2;
    }

    public az a(i i1)
    {
        az az1 = new az();
        if (i1 == null)
        {
            return az1;
        }
        az1.a((int)i1.l());
        az1.b((int)i1.m());
        az1.c((int)i1.n());
        az1.d((int)i1.o());
        az1.e((int)i1.r());
        if (i1.a() != null)
        {
            az1.f((int)i1.a().g());
            az1.g((int)i1.a().a());
        }
        if (i1.d() != null)
        {
            az1.h((int)i1.d().b());
        }
        if (i1.c() != null)
        {
            az1.i((int)i1.c().g());
        }
        if (i1.b() != null && i1.b().f() != null)
        {
            List list = i1.b().f();
            av av1 = new av();
            av av2 = new av();
            for (int j1 = 0; j1 < list.size(); j1++)
            {
                at at1 = (at)list.get(j1);
                if (at1 != null)
                {
                    av1.a(at1.d());
                    av2.a(at1.j());
                }
            }

            az1.j(list.size());
            az1.a(av1);
            az1.b(av2);
        }
        if (i1.e() != null)
        {
            az1.k((int)i1.e().g());
        }
        if (i1.f() != null)
        {
            az1.l((int)i1.f().g());
        }
        if (i1.h() != null)
        {
            az1.m((int)i1.h().g());
        }
        if (i1.C() != null)
        {
            az1.n((int)i1.C().g());
        }
        if (i1.i() != null)
        {
            az1.o((int)i1.i().g());
        }
        if (i1.g() != null)
        {
            az1.p((int)i1.g().g());
        }
        return az1;
    }

    public bi a(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType accessorytype)
    {
        if (accessorytype != com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.d) goto _L2; else goto _L1
_L1:
        if (o.a != null) goto _L4; else goto _L3
_L3:
        com.pf.common.utility.m.e("getInitialedEarringsModelTransform", "left is null");
_L6:
        return null;
_L4:
        return new bi(o.a);
_L2:
        if (accessorytype == com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType.e)
        {
            if (p.a == null)
            {
                com.pf.common.utility.m.e("getInitialedEarringsModelTransform", "right is null");
                return null;
            } else
            {
                return new bi(p.a);
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public i a(i i1, az az1)
    {
        if (i1 == null)
        {
            return null;
        }
        i1 = new i(i1);
        i1.c(az1.b());
        i1.d(az1.c());
        i1.e(az1.d());
        i1.f(az1.e());
        i1.h(az1.f());
        if (i1.a() != null)
        {
            i1.a().a(az1.g());
            i1.a().b(az1.h());
        }
        if (i1.d() != null)
        {
            i1.d().a(az1.i());
        }
        if (i1.c() != null)
        {
            i1.c().a(az1.j());
        }
        if (i1.b() != null && i1.b().f() != null)
        {
            int k1 = az1.k();
            List list = i1.b().f();
            if (list.size() >= k1)
            {
                av av1 = new av();
                av av2 = new av();
                az1.c(av1);
                az1.d(av2);
                for (int j1 = 0; j1 < k1; j1++)
                {
                    at at1 = (at)list.get(j1);
                    if (at1 != null)
                    {
                        at1.a(av1.b(j1));
                        at1.b(av2.b(j1));
                    }
                }

            }
        }
        if (i1.e() != null)
        {
            i1.e().a(az1.l());
        }
        if (i1.f() != null)
        {
            i1.f().a(az1.m());
        }
        if (i1.h() != null)
        {
            i1.h().a(az1.n());
        }
        if (i1.C() != null)
        {
            i1.C().a(az1.o());
        }
        if (i1.i() != null)
        {
            i1.i().a(az1.p());
        }
        if (i1.g() != null)
        {
            i1.g().a(az1.q());
        }
        return i1;
    }

    public String a(at at1)
    {
        Object obj1 = null;
        Object obj;
        if (at1 == null)
        {
            obj = obj1;
        } else
        {
            obj = obj1;
            if (z != null)
            {
                obj = obj1;
                if (z.containsKey(at1.i()))
                {
                    at1 = (String)z.get(at1.i());
                    obj = at1;
                    if (at1 != null)
                    {
                        return at1;
                    }
                }
            }
        }
        return ((String) (obj));
    }

    public void a(float f1, float f2)
    {
        while (StatusManager.j().s() != BeautyMode.x || k.a == null || k.a.b() <= 0 || k.a.c() <= 0 || q || r || BeautifierManager.a().f()) 
        {
            return;
        }
        q = true;
        bi bi1 = com.cyberlink.youcammakeup.widgetpool.wigpreviewview.c.h().f();
        ah ah1 = new ah();
        ah1.a(f1);
        ah1.b(f2);
        int i1 = j.a(bi1, ah1);
        com.pf.common.utility.m.b("VenusHelper", (new StringBuilder()).append("startWarpWigInLocal, ret = ").append(i1).append(" ,x = ").append(f1).append(" ,y = ").append(f2).toString());
        StatusManager.j().a(com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.WigWarpState.a);
    }

    public void a(bi bi1)
    {
        k.b = bi1;
    }

    public void a(bl bl1)
    {
        k.a = bl1;
    }

    public void a(bm bm, float f1, boolean flag)
    {
        if (t && !flag)
        {
            return;
        } else
        {
            t = true;
            (new AsyncTask(bm, f1) {

                final bm a;
                final float b;
                final VenusHelper c;

                protected transient Void a(Void avoid[])
                {
                    com.cyberlink.youcammakeup.kernelctrl.VenusHelper.b(c).a(a, b);
                    c.d();
                    return null;
                }

                protected void a(Void void1)
                {
                    void1 = Globals.d().t();
                    if (void1 != null)
                    {
                        void1.a(com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageLoader.BufferName.c);
                        void1.M();
                        Globals.d().i().b(false);
                        Globals.d().i().h(void1);
                    }
                    VenusHelper.a(c, false);
                }

                protected Object doInBackground(Object aobj[])
                {
                    return a((Void[])aobj);
                }

                protected void onPostExecute(Object obj)
                {
                    a((Void)obj);
                }

            
            {
                c = VenusHelper.this;
                a = bm;
                b = f1;
                super();
            }
            }).executeOnExecutor(h, new Void[0]);
            return;
        }
    }

    public void a(aq aq)
    {
        i.post(new Runnable(aq) {

            final aq a;
            final VenusHelper b;

            public void run()
            {
                (new com.cyberlink.youcammakeup.kernelctrl.au(b, a)).executeOnExecutor(VenusHelper.a(b), new Void[0]);
            }

            
            {
                b = VenusHelper.this;
                a = aq;
                super();
            }
        });
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.b b1, ai ai1, y y1)
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        ImageBufferWrapper imagebufferwrapper = com.cyberlink.youcammakeup.kernelctrl.t.a(b1.d, Boolean.valueOf(false));
        if (imagebufferwrapper != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        bi bi1 = new bi();
        if (j.a(imagebufferwrapper.j(), b1.f, b1.g, b1.e, ai1, y1, bi1) != 0)
        {
            break MISSING_BLOCK_LABEL_211;
        }
        com.cyberlink.youcammakeup.utility.aa.a(l.b);
        l.b = null;
        l.b = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
        imagebufferwrapper.c(l.b);
        if (b1.c)
        {
            b1.j.c(bi1.d());
            b1.j.d(bi1.e());
            b1.j.a(bi1.b());
            b1.j.b(bi1.c());
        }
        if (b1.b)
        {
            n();
        }
        b(b1.j);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
        com.cyberlink.youcammakeup.utility.aa.a(l.b);
        l.b = null;
        l.b = com.cyberlink.youcammakeup.kernelctrl.t.b(b1.d);
        b(b1.j);
          goto _L1
    }

    public void a(com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.b b1, com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.b b2, ai ai1, y y1)
    {
        Object obj1 = e;
        obj1;
        JVM INSTR monitorenter ;
        Object obj2 = f;
        obj2;
        JVM INSTR monitorenter ;
        Object obj = com.cyberlink.youcammakeup.kernelctrl.t.a(b1.d, Boolean.valueOf(false));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        obj2;
        JVM INSTR monitorexit ;
        obj1;
        JVM INSTR monitorexit ;
        return;
        bi bi2;
        bi bi3;
        bi3 = new bi();
        bi2 = new bi();
        if (j.a(((ImageBufferWrapper) (obj)).j(), b1.h, b1.i, b2.h, b2.i, ai1, y1, bi3, bi2) != 0) goto _L2; else goto _L1
_L1:
        com.cyberlink.youcammakeup.utility.aa.a(o.b);
        o.b = null;
        if (b1.a)
        {
            o.b = Bitmap.createBitmap((int)((ImageBufferWrapper) (obj)).b(), (int)((ImageBufferWrapper) (obj)).c(), android.graphics.Bitmap.Config.ARGB_8888);
            ((ImageBufferWrapper) (obj)).c(o.b);
        }
        com.cyberlink.youcammakeup.utility.aa.a(p.b);
        p.b = null;
        bi bi1 = bi2;
        if (!b2.a) goto _L4; else goto _L3
_L3:
        if (b2.k) goto _L6; else goto _L5
_L5:
        p.b = Bitmap.createBitmap((int)((ImageBufferWrapper) (obj)).b(), (int)((ImageBufferWrapper) (obj)).c(), android.graphics.Bitmap.Config.ARGB_8888);
        ((ImageBufferWrapper) (obj)).c(p.b);
        bi1 = bi2;
_L4:
        if (b1.a && b1.b)
        {
            z();
        }
        if (b2.a && (!b2.k && !b2.b || b2.k && b2.b))
        {
            A();
        }
        if (b1.c)
        {
            b1.j.c(bi3.d());
            b1.j.d(bi3.e());
            b1.j.a(bi3.b());
            b1.j.b(bi3.c());
        }
        if (b1.a)
        {
            e(b1.j);
        }
        if (b2.c)
        {
            b2.j.c(bi1.d());
            b2.j.d(bi1.e());
            b2.j.a(bi1.b());
            b2.j.b(bi1.c());
        }
        if (b2.a)
        {
            f(b2.j);
        }
_L9:
        obj2;
        JVM INSTR monitorexit ;
        obj1;
        JVM INSTR monitorexit ;
        return;
        b1;
        obj1;
        JVM INSTR monitorexit ;
        throw b1;
_L6:
        ImageBufferWrapper imagebufferwrapper = com.cyberlink.youcammakeup.kernelctrl.t.a(b2.d, Boolean.valueOf(false));
        bi1 = bi2;
        if (imagebufferwrapper == null) goto _L4; else goto _L7
_L7:
        bi bi4;
        bi4 = new bi();
        obj = new bi();
        bi1 = bi2;
        if (j.a(imagebufferwrapper.j(), b1.h, b1.i, b2.h, b2.i, ai1, y1, bi4, ((bi) (obj))) != 0) goto _L4; else goto _L8
_L8:
        p.b = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
        imagebufferwrapper.c(p.b);
        bi1 = ((bi) (obj));
          goto _L4
_L2:
        com.cyberlink.youcammakeup.utility.aa.a(o.b);
        o.b = null;
        if (b1.a)
        {
            o.b = com.cyberlink.youcammakeup.kernelctrl.t.b(b1.d);
        }
        com.cyberlink.youcammakeup.utility.aa.a(p.b);
        p.b = null;
        if (b2.a)
        {
            p.b = com.cyberlink.youcammakeup.kernelctrl.t.b(b2.d);
        }
        A();
        if (b1.a)
        {
            e(b1.j);
        }
        if (b2.a)
        {
            f(b2.j);
        }
          goto _L9
        b1;
        obj2;
        JVM INSTR monitorexit ;
        throw b1;
          goto _L4
    }

    public void a(ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation, com.cyberlink.youcammakeup.kernelctrl.aw aw1)
    {
        i.post(new Runnable(imagebufferwrapper, uiimageorientation, aw1) {

            final ImageBufferWrapper a;
            final UIImageOrientation b;
            final com.cyberlink.youcammakeup.kernelctrl.aw c;
            final VenusHelper d;

            public void run()
            {
                (new as(d, a, b, c)).executeOnExecutor(VenusHelper.a(d), new Void[0]);
            }

            
            {
                d = VenusHelper.this;
                a = imagebufferwrapper;
                b = uiimageorientation;
                c = aw1;
                super();
            }
        });
    }

    public void a(aw aw1, aq aq)
    {
        MotionControlHelper.e().r(false);
        i.post(new Runnable(aw1, aq) {

            final aw a;
            final aq b;
            final VenusHelper c;

            public void run()
            {
                (new ap(c, a, b)).executeOnExecutor(VenusHelper.a(c), new Void[0]);
            }

            
            {
                c = VenusHelper.this;
                a = aw1;
                b = aq;
                super();
            }
        });
    }

    public void a(Float float1, Float float2)
    {
        a(false, float1, float2);
    }

    public void a(boolean flag)
    {
        j.a(flag);
        d();
    }

    public void a(boolean flag, boolean flag1, aq aq)
    {
        if (flag)
        {
            i.post(new Runnable(flag1, aq) {

                final boolean a;
                final aq b;
                final VenusHelper c;

                public void run()
                {
                    (new ay(c, a, null, null, b)).executeOnExecutor(VenusHelper.a(c), new Void[0]);
                }

            
            {
                c = VenusHelper.this;
                a = flag;
                b = aq;
                super();
            }
            });
            return;
        } else
        {
            a(flag1, ((Float) (null)), ((Float) (null)));
            return;
        }
    }

    public boolean a(String s1)
    {
        return j.b(s1);
    }

    public void b(float f1, float f2)
    {
        while (StatusManager.j().s() != BeautyMode.x || k.a == null || k.a.b() <= 0 || k.a.c() <= 0 || !j.c() || !q || BeautifierManager.a().f()) 
        {
            return;
        }
        r = true;
        d();
        ah ah1 = new ah();
        ah1.a(f1);
        ah1.b(f2);
        int i1 = j.a(ah1);
        com.pf.common.utility.m.b("VenusHelper", (new StringBuilder()).append("continueWarpWigInLocal, ret = ").append(i1).append(" ,x = ").append(f1).append(" ,y = ").append(f2).toString());
        StatusManager.j().a(com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.WigWarpState.b);
    }

    public void b(bi bi1)
    {
        l.a = bi1;
    }

    public void b(com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.b b1, ai ai1, y y1)
    {
        Object obj = c;
        obj;
        JVM INSTR monitorenter ;
        ImageBufferWrapper imagebufferwrapper = com.cyberlink.youcammakeup.kernelctrl.t.a(b1.d, Boolean.valueOf(false));
        if (imagebufferwrapper != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        bi bi1 = new bi();
        if (j.a(imagebufferwrapper.j(), b1.f, b1.g, ai1, y1, bi1) != 0)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        com.cyberlink.youcammakeup.utility.aa.a(m.b);
        m.b = null;
        m.b = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
        imagebufferwrapper.c(m.b);
        if (b1.b)
        {
            r();
        }
        if (b1.c)
        {
            b1.j.c(bi1.d() + (float)MotionControlHelper.e().aw());
            b1.j.d(bi1.e() + (float)MotionControlHelper.e().ax());
            b1.j.a(bi1.b());
            b1.j.b(bi1.c());
        }
        c(b1.j);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
        com.cyberlink.youcammakeup.utility.aa.a(m.b);
        m.b = null;
        m.b = com.cyberlink.youcammakeup.kernelctrl.t.b(b1.d);
        c(b1.j);
          goto _L1
    }

    public void b(List list)
    {
        if (list != null)
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                aw aw1 = (aw)list.next();
                if (aw1 != null && aw1.i() != null && aw1.i().size() >= 1 && (z == null || !z.containsKey(((at)aw1.i().get(0)).i())))
                {
                    a(aw1);
                }
            }
        }
    }

    public void b(boolean flag)
    {
        if (x != null)
        {
            String s1;
            if (flag)
            {
                s1 = x.a((int)(x.b() - 1L));
                ae ae1 = new ae();
                for (int i1 = 0; (long)i1 < x.b() - 1L; i1++)
                {
                    ae1.a(x.a(i1));
                }

                a(ae1);
                ae1.c();
            } else
            {
                a(x);
                s1 = null;
            }
            x.c();
            x = null;
            if (s1 != null && flag)
            {
                x = new ae();
                x.a(s1);
            }
        }
    }

    public boolean b()
    {
        return q;
    }

    public boolean b(com.cyberlink.youcammakeup.widgetpool.accessorypreviewview.AccessoryDrawingCtrl.AccessoryType accessorytype)
    {
        return !c(accessorytype).b();
    }

    public boolean b(String s1)
    {
        return j.c(s1);
    }

    public void c()
    {
        ImageBufferWrapper imagebufferwrapper;
        while (StatusManager.j().s() != BeautyMode.x || k.a == null || k.a.b() <= 0 || k.a.c() <= 0 || !q || !r || s || BeautifierManager.a().f()) 
        {
            return;
        }
        q = false;
        r = false;
        s = true;
        imagebufferwrapper = new ImageBufferWrapper();
        imagebufferwrapper.a(k.a.b(), k.a.c(), 4L);
        int i1 = j.b(k.a, imagebufferwrapper.j());
        com.pf.common.utility.m.b("VenusHelper", (new StringBuilder()).append("endWarpWigInLocal, ret = ").append(i1).toString());
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_257;
        }
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (k.c == null || k.c.getWidth() != k.a.b() || k.c.getHeight() != k.a.c())
        {
            break MISSING_BLOCK_LABEL_278;
        }
        imagebufferwrapper.c(k.c);
_L2:
        imagebufferwrapper.m();
        s = false;
        StatusManager.j().a(com.cyberlink.youcammakeup.kernelctrl.status.StatusManager.WigWarpState.c);
        return;
        com.cyberlink.youcammakeup.utility.aa.a(k.c);
        k.c = null;
        k.c = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
        imagebufferwrapper.c(k.c);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void c(bi bi1)
    {
        m.a = bi1;
    }

    public void c(com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.b b1, ai ai1, y y1)
    {
        Object obj = d;
        obj;
        JVM INSTR monitorenter ;
        ImageBufferWrapper imagebufferwrapper = com.cyberlink.youcammakeup.kernelctrl.t.a(b1.d, Boolean.valueOf(false));
        if (imagebufferwrapper != null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        bi bi1 = new bi();
        if (j.b(imagebufferwrapper.j(), b1.f, b1.g, ai1, y1, bi1) != 0)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        com.cyberlink.youcammakeup.utility.aa.a(n.b);
        n.b = null;
        n.b = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
        imagebufferwrapper.c(n.b);
        if (b1.b)
        {
            v();
        }
        if (b1.c)
        {
            b1.j.c(bi1.d());
            b1.j.d(bi1.e());
            b1.j.a(bi1.b());
            b1.j.b(bi1.c());
        }
        d(b1.j);
_L1:
        obj;
        JVM INSTR monitorexit ;
        return;
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
        com.cyberlink.youcammakeup.utility.aa.a(n.b);
        n.b = null;
        n.b = com.cyberlink.youcammakeup.kernelctrl.t.b(b1.d);
        d(b1.j);
          goto _L1
    }

    public void d()
    {
        ImageBufferWrapper imagebufferwrapper;
        while (StatusManager.j().s() != BeautyMode.x || !j.c() || k.a == null || k.a.b() <= 0 || k.a.c() <= 0 || s) 
        {
            return;
        }
        s = true;
        imagebufferwrapper = new ImageBufferWrapper();
        imagebufferwrapper.a(k.a.b(), k.a.c(), 4L);
        int i1 = j.a(k.a, imagebufferwrapper.j());
        com.pf.common.utility.m.b("VenusHelper", (new StringBuilder()).append("getWarpedWigModel, ret = ").append(i1).toString());
        if (i1 != 0)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (k.c == null || k.c.getWidth() != k.a.b() || k.c.getHeight() != k.a.c())
        {
            break MISSING_BLOCK_LABEL_246;
        }
        imagebufferwrapper.c(k.c);
_L2:
        imagebufferwrapper.m();
        s = false;
        return;
        com.cyberlink.youcammakeup.utility.aa.a(k.c);
        k.c = null;
        k.c = Bitmap.createBitmap((int)imagebufferwrapper.b(), (int)imagebufferwrapper.c(), android.graphics.Bitmap.Config.ARGB_8888);
        imagebufferwrapper.c(k.c);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void d(bi bi1)
    {
        n.a = bi1;
    }

    public Bitmap e()
    {
        return k.c;
    }

    public void e(bi bi1)
    {
        o.a = bi1;
    }

    public bi f()
    {
        if (k.b == null)
        {
            com.pf.common.utility.m.e("getInitialedWarpedWigModelTransform", "UITransform is null");
            return null;
        } else
        {
            return new bi(k.b);
        }
    }

    public void f(bi bi1)
    {
        p.a = bi1;
    }

    public void g()
    {
        k.a();
        q = false;
        r = false;
        s = false;
    }

    public void h()
    {
        j.d();
    }

    public void i()
    {
        j.e();
        d();
    }

    public void j()
    {
        j.f();
        d();
    }

    public void k()
    {
        j.g();
        d();
    }

    public bi l()
    {
        if (l.a == null)
        {
            com.pf.common.utility.m.e("getInitialedEyeWearModelTransform", "UITransform is null");
            return null;
        } else
        {
            return new bi(l.a);
        }
    }

    public Bitmap m()
    {
        Bitmap bitmap;
        synchronized (b)
        {
            bitmap = l.b;
        }
        return bitmap;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void n()
    {
        synchronized (b)
        {
            if (com.cyberlink.youcammakeup.utility.aa.b(l.b))
            {
                Bitmap bitmap = l.b;
                Matrix matrix = new Matrix();
                matrix.preScale(-1F, 1.0F);
                l.b = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
                bitmap.recycle();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void o()
    {
        synchronized (b)
        {
            l.a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public bi p()
    {
        if (m.a == null)
        {
            com.pf.common.utility.m.e("getInitialedHairbandModelTransform", "UITransform is null");
            return null;
        } else
        {
            return new bi(m.a);
        }
    }

    public Bitmap q()
    {
        Bitmap bitmap;
        synchronized (c)
        {
            bitmap = m.b;
        }
        return bitmap;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void r()
    {
        synchronized (c)
        {
            if (com.cyberlink.youcammakeup.utility.aa.b(m.b))
            {
                Bitmap bitmap = m.b;
                Matrix matrix = new Matrix();
                matrix.preScale(-1F, 1.0F);
                m.b = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
                bitmap.recycle();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void s()
    {
        synchronized (c)
        {
            m.a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public bi t()
    {
        if (n.a == null)
        {
            com.pf.common.utility.m.e("getInitialedNecklaceModelTransform", "UITransform is null");
            return null;
        } else
        {
            return new bi(n.a);
        }
    }

    public Bitmap u()
    {
        Bitmap bitmap;
        synchronized (d)
        {
            bitmap = n.b;
        }
        return bitmap;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void v()
    {
        synchronized (d)
        {
            if (com.cyberlink.youcammakeup.utility.aa.b(n.b))
            {
                Bitmap bitmap = n.b;
                Matrix matrix = new Matrix();
                matrix.preScale(-1F, 1.0F);
                n.b = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
                bitmap.recycle();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void w()
    {
        synchronized (d)
        {
            n.a();
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Bitmap x()
    {
        Bitmap bitmap;
        synchronized (e)
        {
            bitmap = o.b;
        }
        return bitmap;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Bitmap y()
    {
        Bitmap bitmap;
        synchronized (f)
        {
            bitmap = p.b;
        }
        return bitmap;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void z()
    {
        synchronized (e)
        {
            if (com.cyberlink.youcammakeup.utility.aa.b(o.b))
            {
                Bitmap bitmap = o.b;
                Matrix matrix = new Matrix();
                matrix.preScale(-1F, 1.0F);
                o.b = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
                bitmap.recycle();
            }
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

}
