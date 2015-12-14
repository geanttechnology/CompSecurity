// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import android.graphics.Point;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.c;
import com.cyberlink.youcammakeup.database.d;
import com.cyberlink.youcammakeup.database.e;
import com.cyberlink.youcammakeup.database.n;
import com.cyberlink.youcammakeup.database.o;
import com.cyberlink.youcammakeup.database.p;
import com.cyberlink.youcammakeup.database.r;
import com.cyberlink.youcammakeup.jniproxy.UIBytePerPixel;
import com.cyberlink.youcammakeup.jniproxy.UIImageCodecErrorCode;
import com.cyberlink.youcammakeup.jniproxy.UIImageFormat;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.jniproxy.UIInterpolation;
import com.cyberlink.youcammakeup.jniproxy.an;
import com.cyberlink.youcammakeup.jniproxy.ap;
import com.cyberlink.youcammakeup.jniproxy.ba;
import com.cyberlink.youcammakeup.jniproxy.bd;
import com.cyberlink.youcammakeup.jniproxy.be;
import com.cyberlink.youcammakeup.jniproxy.bf;
import com.cyberlink.youcammakeup.jniproxy.k;
import com.cyberlink.youcammakeup.jniproxy.t;
import com.cyberlink.youcammakeup.kernelctrl.ROI;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.ad;
import com.cyberlink.youcammakeup.kernelctrl.status.g;
import com.cyberlink.youcammakeup.kernelctrl.status.q;
import com.pf.common.utility.m;
import java.io.File;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            m, f, b, p, 
//            d, o, k, ImageBufferWrapper, 
//            h, i, l, j, 
//            c, a, n

public class ViewEngine
    implements ad, g, q
{

    com.cyberlink.youcammakeup.kernelctrl.viewengine.d a;
    private ConcurrentHashMap b;
    private long c;
    private k d;
    private f e;
    private b f;
    private final com.cyberlink.youcammakeup.kernelctrl.viewengine.m g;
    private com.cyberlink.youcammakeup.kernelctrl.viewengine.p h;
    private p i;
    private n j;
    private com.cyberlink.youcammakeup.database.c k;
    private AtomicLong l;
    private HashMap m;
    private String n;

    private ViewEngine()
    {
        b = new ConcurrentHashMap();
        c = -1L;
        d = new k(Globals.d().l());
        g = new com.cyberlink.youcammakeup.kernelctrl.viewengine.m(this);
        l = new AtomicLong(0L);
        m = new HashMap();
        n = "";
        a = null;
        e = new f(this);
        f = new b(this, true);
        h = new com.cyberlink.youcammakeup.kernelctrl.viewengine.p(this);
        i = com.cyberlink.youcammakeup.c.f();
        j = com.cyberlink.youcammakeup.c.e();
        k = com.cyberlink.youcammakeup.c.d();
        StatusManager statusmanager = StatusManager.j();
        statusmanager.a(this);
        statusmanager.a(this);
        statusmanager.a(this);
    }


    private double a(long l1, long l2, long l3)
    {
        com.cyberlink.youcammakeup.kernelctrl.viewengine.d d1;
        try
        {
            d1 = a(l1);
        }
        catch (TaskMgrException taskmgrexception)
        {
            a((new StringBuilder()).append("[ViewEngine][getFitThumbnailSizeAsync] getSize Error. ImageID:").append(l1).append(" errResult:").append(taskmgrexception.getMessage()).toString());
            return -1D;
        }
        if (d1 == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        return a(d1.a.a, d1.a.b, l2, l3);
        throw new TaskMgrException("[getFitThumbnailRatioAsync] Cannot get the size info from the ImageInfo cache.");
    }

    private double a(long l1, long l2, long l3, long l4)
    {
label0:
        {
            long l5;
            if (l3 != -1L)
            {
                l5 = l4;
                if (l4 != -1L)
                {
                    break label0;
                }
            }
            double d1;
            if (l1 > l2)
            {
                l3 = 160L;
                l5 = 120L;
            } else
            {
                l3 = 120L;
                l5 = 160L;
            }
        }
        d1 = (double)l5 / (double)l2;
        return Math.min(Math.min((double)l3 / (double)l1, d1), 1.0D);
    }

    static com.cyberlink.youcammakeup.database.c a(ViewEngine viewengine)
    {
        return viewengine.k;
    }

    private ROI a(double d1, ROI roi)
    {
        if (d1 <= 0.0D || d1 > 1.0D)
        {
            throw new IllegalArgumentException("Invalid scaleRatio: scaleRatio should be (0, 1]");
        }
        if (d1 == 1.0D)
        {
            return roi;
        }
        if (roi == null)
        {
            return null;
        } else
        {
            roi.a(com.cyberlink.youcammakeup.kernelctrl.viewengine.k.a((double)roi.a() * d1));
            roi.b(com.cyberlink.youcammakeup.kernelctrl.viewengine.k.a((double)roi.b() * d1));
            roi.c(com.cyberlink.youcammakeup.kernelctrl.viewengine.k.a((double)roi.c() * d1));
            roi.d(com.cyberlink.youcammakeup.kernelctrl.viewengine.k.a((double)roi.d() * d1));
            return roi;
        }
    }

    private ImageBufferWrapper a(double d1, ImageBufferWrapper imagebufferwrapper, Argd argd)
    {
        if (imagebufferwrapper != null) goto _L2; else goto _L1
_L1:
        com.pf.common.utility.m.e("ViewEngine", "_generateStretchFromBuffer null srcOrigBuffer");
        argd = null;
_L4:
        return argd;
_L2:
        if (imagebufferwrapper.d() == -1L)
        {
            com.pf.common.utility.m.e("ViewEngine", "_generateStretchFromBuffer srcOrigBuffer.getBpp()=-1");
            return null;
        }
        Object obj = argd;
        if (argd == null)
        {
            obj = new Argd();
        }
        if (d1 == 0.0D)
        {
            throw new TaskMgrException("[_generateStretchFromThumbnailBuffer] Error scaleRatio");
        }
        e.a(((Long)((Argd) (obj)).get("taskID")).longValue());
        if (imagebufferwrapper != null)
        {
            ((Argd) (obj)).put("srcBuffer", imagebufferwrapper);
        }
        argd = new ImageBufferWrapper();
        argd.imageID = imagebufferwrapper.imageID;
        argd.imageType = imagebufferwrapper.imageType;
        double d2 = 1.0D / d1;
        long l3 = imagebufferwrapper.srcW;
        long l4 = imagebufferwrapper.srcH;
        long l1 = Math.round((double)l3 / d2);
        long l2 = Math.round((double)l4 / d2);
        if (l1 <= 0L)
        {
            l1 = 1L;
        }
        if (l2 <= 0L)
        {
            l2 = 1L;
        }
        argd.scaleRatio = d1;
        argd.name = (new StringBuilder()).append(((ImageBufferWrapper) (argd)).name).append("stretch").toString();
        argd.a(l1, l2, imagebufferwrapper.d());
        argd.srcW = l3;
        argd.srcH = l4;
        imagebufferwrapper.l();
        try
        {
            obj = a(com.cyberlink.youcammakeup.kernelctrl.viewengine.DecodeOpCode.e, ((ImageBufferWrapper) (argd)), ((Argd) (obj)));
            imagebufferwrapper.m();
        }
        // Misplaced declaration of an exception variable
        catch (Argd argd)
        {
            imagebufferwrapper.m();
            throw argd;
        }
        if (obj == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (((ImageBufferWrapper) (obj)).a != null) goto _L4; else goto _L3
_L3:
        throw new TaskMgrException("[_generateStretchFromBuffer] cannot stretch");
    }

    private ImageBufferWrapper a(long l1, double d1, ImageBufferWrapper imagebufferwrapper, Argd argd)
    {
        if (argd == null)
        {
            argd = new Argd();
        }
        e.a(((Long)argd.get("taskID")).longValue());
        if (d1 == 0.0D)
        {
            throw new TaskMgrException("[_generateStretchFromThumbnailBuffer] Error scaleRatio");
        }
        com.cyberlink.youcammakeup.kernelctrl.viewengine.d d2 = a(l1);
        if (d2 != null)
        {
            imagebufferwrapper.srcW = d2.a.a;
            imagebufferwrapper.srcH = d2.a.b;
            if (argd.get("forceWidth") != null && argd.get("forceHeight") != null)
            {
                return a(((Long)argd.get("forceWidth")).longValue(), ((Long)argd.get("forceHeight")).longValue(), imagebufferwrapper, argd);
            } else
            {
                return a(d1, imagebufferwrapper, argd);
            }
        } else
        {
            throw new TaskMgrException((new StringBuilder()).append("[_generateStretchFromThumbnailBuffer] get imageID Size Error~!!! imageID:").append(l1).toString());
        }
    }

    private ImageBufferWrapper a(long l1, double d1, Argd argd)
    {
        Object obj1 = null;
        a((new StringBuilder()).append("[__getImageBufferAsync] Enter:").append(l1).append(" scaleRatio:").append(d1).toString());
        Object obj;
        Argd argd1;
        TaskMgrException taskmgrexception;
        ROI roi;
        boolean flag;
        if (argd == null)
        {
            obj = new Argd();
        } else
        {
            obj = argd;
        }
        e.a(((Long)((Argd) (obj)).get("taskID")).longValue());
        roi = (ROI)((Argd) (obj)).get("ROI");
        argd = (DecodePolicy)((Argd) (obj)).get("policy");
        if (argd == null)
        {
            argd = DecodePolicy.a;
        }
        if (argd != DecodePolicy.a) goto _L2; else goto _L1
_L1:
        argd = a(l1, d1, ((DecodePolicy) (argd)), ((Argd) (obj)));
_L13:
        if (argd == null) goto _L4; else goto _L3
_L3:
        if (((ImageBufferWrapper) (argd)).a == null) goto _L4; else goto _L5
_L5:
        a((new StringBuilder()).append("[__getImageBufferAsync] Ready RatioSrcAsync:").append(l1).append(" scaleRatio:").append(d1).toString());
        if (roi != null) goto _L7; else goto _L6
_L6:
        flag = true;
        obj = null;
_L9:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        argd1 = argd;
        obj1 = obj;
        a((new StringBuilder()).append("[San] [hello bugs] Cannot get the correct buffer result~!!!").append(argd.e()).toString());
        break MISSING_BLOCK_LABEL_228;
_L2:
        argd = b(l1, d1, argd, ((Argd) (obj)));
        continue; /* Loop/switch isn't completed */
_L7:
        obj = new ImageBufferWrapper();
        argd1 = argd;
        obj1 = obj;
        obj.name = "roi_image";
        argd1 = argd;
        obj1 = obj;
        obj.roi = roi;
        argd1 = argd;
        obj1 = obj;
        flag = ((ImageBufferWrapper) (obj)).a(argd, roi.e());
        continue; /* Loop/switch isn't completed */
_L4:
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_366;
        }
        if (((Argd) (obj)).get("thumbRule") == null || (ThumbnailRule)((Argd) (obj)).get("thumbRule") != ThumbnailRule.b)
        {
            break MISSING_BLOCK_LABEL_366;
        }
        flag = false;
        obj = null;
        argd = null;
        if (true) goto _L9; else goto _L8
        try
        {
            throw new TaskMgrException("[__getImageBufferAsync] Cannot Get the Correct Src Ratio Buffer.");
        }
        // Misplaced declaration of an exception variable
        catch (Argd argd)
        {
            argd1 = null;
        }
        obj = obj1;
        obj1 = argd1;
_L11:
        if (obj != null)
        {
            ((ImageBufferWrapper) (obj)).m();
        }
        if (obj1 != null)
        {
            ((ImageBufferWrapper) (obj1)).m();
        }
        throw new TaskMgrException(a("[__getImageBufferAsync]", ((Throwable) (argd))), argd);
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        if (roi == null)
        {
            return argd;
        }
        if (argd == null)
        {
            break MISSING_BLOCK_LABEL_450;
        }
        argd1 = argd;
        obj1 = obj;
        argd.m();
        argd1 = argd;
        obj1 = obj;
        a((new StringBuilder()).append("[__getImageBufferAsync] Ready ROIBuffer:").append(l1).append(" scaleRatio:").append(d1).toString());
        return ((ImageBufferWrapper) (obj));
_L8:
        argd1 = argd;
        obj1 = obj;
        try
        {
            throw new TaskMgrException("[__getImageBufferAsync] Cannot Get the Correct ROI buffer");
        }
        // Misplaced declaration of an exception variable
        catch (Argd argd)
        {
            obj = argd1;
        }
        continue; /* Loop/switch isn't completed */
        taskmgrexception;
        obj1 = null;
        obj = argd;
        argd = taskmgrexception;
        if (true) goto _L11; else goto _L10
_L10:
        if (true) goto _L13; else goto _L12
_L12:
    }

    private ImageBufferWrapper a(long l1, double d1, DecodePolicy decodepolicy, Argd argd)
    {
        Object obj;
        Object obj1;
        double d2;
        Object obj2;
        Argd argd1;
        com.cyberlink.youcammakeup.jniproxy.d d3;
        boolean flag;
        if (argd == null)
        {
            argd1 = new Argd();
        } else
        {
            argd1 = argd;
        }
        e.a(((Long)argd1.get("taskID")).longValue());
        if (l1 == -5L)
        {
            decodepolicy = DecodePolicy.a;
        }
        argd = ImageType.a;
        flag = argd1.a("noCache");
        a((new StringBuilder()).append("[_findAndGenerateMasterSrcAsync] start:").append(l1).append(" scaleRatio:").append(d1).append(" policy:").append(decodepolicy).toString());
        try
        {
            obj = g.a(l1, d1, argd);
        }
        // Misplaced declaration of an exception variable
        catch (DecodePolicy decodepolicy)
        {
            obj2 = null;
            continue; /* Loop/switch isn't completed */
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (((ImageBufferWrapper) (obj)).a == null) goto _L2; else goto _L3
_L3:
        a((new StringBuilder()).append("[_findAndGenerateMasterSrcAsync][MASTER] get  Cache from VECacheMgr:").append(l1).append(" scaleRatio:").append(d1).append(" policy:").append(decodepolicy).toString());
        ((ImageBufferWrapper) (obj)).l();
        argd = null;
        decodepolicy = ((DecodePolicy) (obj));
_L37:
        obj = null;
        if (decodepolicy != null) goto _L5; else goto _L4
_L4:
        if (argd == null) goto _L7; else goto _L6
_L6:
        obj2 = argd;
        if (((ImageBufferWrapper) (argd)).a == null) goto _L7; else goto _L8
_L8:
        obj2 = argd;
        try
        {
            a((new StringBuilder()).append("[_findAndGenerateMasterSrcAsync][MASTER] get Master from VECacheMgr to generate RatioBuffer imageID:").append(l1).toString());
        }
        // Misplaced declaration of an exception variable
        catch (DecodePolicy decodepolicy)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj2 = argd;
        if (d1 != ((ImageBufferWrapper) (argd)).scaleRatio) goto _L10; else goto _L9
_L9:
        obj2 = argd;
        argd.l();
        decodepolicy = null;
        obj = null;
        obj1 = argd;
        argd = ((Argd) (obj));
_L22:
        if (obj1 != null) goto _L12; else goto _L11
_L11:
        obj = argd;
        if (decodepolicy == null) goto _L14; else goto _L13
_L13:
        obj2 = argd;
        d3 = ((ImageBufferWrapper) (decodepolicy)).a;
        obj = argd;
        if (d3 == null) goto _L14; else goto _L15
_L15:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_373;
        }
        if (!argd1.a("asThumbSrc") || d1 != 1.0D)
        {
            break MISSING_BLOCK_LABEL_364;
        }
        decodepolicy.imageType = ImageType.b;
        decodepolicy.scaleRatio = -1D;
        decodepolicy.name = "Thumb_Master";
        g.a(decodepolicy);
        d2 = ((ImageBufferWrapper) (decodepolicy)).scaleRatio;
        obj = decodepolicy;
        if (d1 == d2) goto _L17; else goto _L16
_L16:
        if (d1 != -1D) goto _L19; else goto _L18
_L18:
        obj = decodepolicy;
_L17:
        return ((ImageBufferWrapper) (obj));
_L2:
        if (d1 == 1.0D) goto _L21; else goto _L20
_L20:
        argd = g.a(l1, 1.0D, argd);
        decodepolicy = null;
        continue; /* Loop/switch isn't completed */
_L10:
        obj2 = argd;
        argd.l();
        obj = null;
        obj1 = decodepolicy;
        decodepolicy = ((DecodePolicy) (obj));
          goto _L22
_L7:
        obj2 = argd;
        a((new StringBuilder()).append("[_findAndGenerateMasterSrcAsync][MASTER][DB]  get Master from DB imageID:").append(l1).toString());
        obj2 = argd;
        obj = a(l1, argd1);
        obj1 = decodepolicy;
        decodepolicy = ((DecodePolicy) (obj));
          goto _L22
_L14:
        obj2 = obj;
        if (argd1.get("forceWidth") == null) goto _L24; else goto _L23
_L23:
        obj2 = obj;
        if (argd1.get("forceHeight") == null) goto _L24; else goto _L25
_L25:
        obj2 = obj;
        decodepolicy = a(((Long)argd1.get("forceWidth")).longValue(), ((Long)argd1.get("forceHeight")).longValue(), ((ImageBufferWrapper) (obj)), argd1);
        argd = ((Argd) (obj));
          goto _L26
_L24:
        obj2 = obj;
        decodepolicy = a(d1, ((ImageBufferWrapper) (obj)), argd1);
        argd = ((Argd) (obj));
          goto _L26
_L35:
        if (argd == null)
        {
            break MISSING_BLOCK_LABEL_619;
        }
        argd.m();
        if (decodepolicy == null) goto _L28; else goto _L27
_L27:
        if (((ImageBufferWrapper) (decodepolicy)).a == null) goto _L28; else goto _L29
_L29:
        a((new StringBuilder()).append("[_findAndGenerateMasterSrcAsync][MASTER] Stretch Finish:").append(decodepolicy.e()).toString());
        obj = decodepolicy;
        if (flag) goto _L17; else goto _L30
_L30:
        if (!argd1.a("asThumbSrc")) goto _L32; else goto _L31
_L31:
        decodepolicy.imageType = ImageType.b;
        decodepolicy.scaleRatio = -1D;
        decodepolicy.name = "Thumb_Master";
        h.a(l1, decodepolicy.b(), decodepolicy.c());
        g.b(decodepolicy);
        return decodepolicy;
_L33:
        if (obj2 != null)
        {
            ((ImageBufferWrapper) (obj2)).m();
        }
        throw new TaskMgrException(a("[_findAndGenerateRatioSrcAsync][DECODE_POLICY_MASTER]", ((Throwable) (decodepolicy))));
_L32:
        g.a(decodepolicy);
        return decodepolicy;
_L28:
        try
        {
            throw new TaskMgrException("[_findAndGenerateMasterSrcAsync] Unknown Error: Cannot get finalResultBuffer from resultStretch");
        }
        // Misplaced declaration of an exception variable
        catch (DecodePolicy decodepolicy)
        {
            obj2 = argd;
        }
        continue; /* Loop/switch isn't completed */
        argd;
        obj2 = decodepolicy;
        decodepolicy = argd;
        if (true) goto _L33; else goto _L12
_L12:
        decodepolicy = null;
        continue; /* Loop/switch isn't completed */
_L5:
        argd = null;
        obj1 = decodepolicy;
        decodepolicy = ((DecodePolicy) (obj));
          goto _L22
_L21:
        argd = null;
        decodepolicy = null;
        continue; /* Loop/switch isn't completed */
_L19:
        obj = decodepolicy;
          goto _L14
_L26:
        if (obj1 == null) goto _L35; else goto _L34
_L34:
        return ((ImageBufferWrapper) (obj1));
        if (true) goto _L37; else goto _L36
_L36:
    }

    private ImageBufferWrapper a(long l1, long l2, ImageBufferWrapper imagebufferwrapper, Argd argd)
    {
        Object obj;
        obj = argd;
        if (argd == null)
        {
            obj = new Argd();
        }
        if (l1 == 0L || l2 == 0L)
        {
            throw new TaskMgrException("[_generateStretchFromAbsoluteBuffer] Error w or h");
        }
        e.a(((Long)((Argd) (obj)).get("taskID")).longValue());
        if (imagebufferwrapper != null)
        {
            ((Argd) (obj)).put("srcBuffer", imagebufferwrapper);
        }
        argd = new ImageBufferWrapper();
        argd.imageID = imagebufferwrapper.imageID;
        argd.scaleRatio = Math.min((double)l1 / (double)imagebufferwrapper.b(), (double)l2 / (double)imagebufferwrapper.c());
        argd.imageType = imagebufferwrapper.imageType;
        argd.name = "stretch";
        argd.a(l1, l2, imagebufferwrapper.d());
        argd.srcW = imagebufferwrapper.srcW;
        argd.srcH = imagebufferwrapper.srcH;
        imagebufferwrapper.l();
        obj = a(com.cyberlink.youcammakeup.kernelctrl.viewengine.DecodeOpCode.e, ((ImageBufferWrapper) (argd)), ((Argd) (obj)));
        imagebufferwrapper.m();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_215;
        }
        if (((ImageBufferWrapper) (obj)).a != null)
        {
            return argd;
        }
        try
        {
            throw new TaskMgrException("[_generateStretchFromAbsoluteBuffer] cannot stretch");
        }
        // Misplaced declaration of an exception variable
        catch (Argd argd)
        {
            imagebufferwrapper.m();
        }
        throw argd;
    }

    private ImageBufferWrapper a(long l1, Argd argd)
    {
        e.a(((Long)argd.get("taskID")).longValue());
        if (com.cyberlink.youcammakeup.kernelctrl.viewengine.k.a(n) || a == null) goto _L2; else goto _L1
_L1:
        Object obj;
        long l3;
        long l4;
        long l5;
        long l6;
        obj = n;
        l5 = a.b.a;
        l4 = a.b.b;
        l6 = a.a.a;
        l3 = a.a.b;
        h.a(l1, l6, l3, l5, l4);
_L16:
        obj = a(((String) (obj)), null, argd);
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((ImageBufferWrapper) (obj)).a == null) goto _L4; else goto _L5
_L5:
        if (l5 != ((ImageBufferWrapper) (obj)).b())
        {
            break MISSING_BLOCK_LABEL_156;
        }
        long l2 = l4;
        if (l4 == ((ImageBufferWrapper) (obj)).c())
        {
            break MISSING_BLOCK_LABEL_186;
        }
        l5 = ((ImageBufferWrapper) (obj)).b();
        l2 = ((ImageBufferWrapper) (obj)).c();
        h.a(l1, l6, l3, l5, l2);
        if (l6 == l5 && l3 == l2)
        {
            break MISSING_BLOCK_LABEL_670;
        }
        Object obj2 = a(l6, l3, ((ImageBufferWrapper) (obj)), argd);
        argd = ((Argd) (obj));
_L19:
        Object obj1;
        obj1 = argd;
        if (argd == null)
        {
            break MISSING_BLOCK_LABEL_236;
        }
        obj = argd;
        argd.m();
        obj1 = null;
        if (obj2 == null) goto _L7; else goto _L6
_L6:
        obj = obj1;
        if (((ImageBufferWrapper) (obj2)).a == null) goto _L7; else goto _L8
_L8:
        obj = obj1;
        obj2.imageID = l1;
        obj = obj1;
        obj2.name = "Master";
        obj = obj1;
        obj2.scaleRatio = 1.0D;
        obj = obj1;
        obj2.imageType = ImageType.a;
        obj = obj1;
        obj2.srcW = ((ImageBufferWrapper) (obj2)).b();
        obj = obj1;
        obj2.srcH = ((ImageBufferWrapper) (obj2)).c();
        return ((ImageBufferWrapper) (obj2));
_L2:
        obj1 = i.c(l1);
        if (obj1 != null) goto _L10; else goto _L9
_L9:
        try
        {
            throw new TaskMgrException("[_generateMasterBufferFromID] imageObj is null");
        }
        // Misplaced declaration of an exception variable
        catch (Argd argd)
        {
            obj = null;
        }
_L17:
        if (obj != null)
        {
            ((ImageBufferWrapper) (obj)).m();
        }
        if (!argd.getMessage().isEmpty())
        {
            throw new TaskMgrException(a("[_generateMasterBufferFromID]", ((Throwable) (argd))));
        } else
        {
            throw new TaskMgrException("[_generateMasterBufferFromID] Unexpected Error");
        }
_L10:
        obj = j.b(((r) (obj1)).f());
        if (obj == null) goto _L12; else goto _L11
_L11:
        obj = ((o) (obj)).b();
        if ((new File(((String) (obj)))).exists())
        {
            break MISSING_BLOCK_LABEL_444;
        }
        StatusManager.j().v();
        return null;
        obj2 = ((r) (obj1)).d();
        if (obj2 != UIImageOrientation.g && obj2 != UIImageOrientation.f && obj2 != UIImageOrientation.i && obj2 != UIImageOrientation.h) goto _L14; else goto _L13
_L13:
        l6 = ((r) (obj1)).i();
        l4 = ((r) (obj1)).j();
        l2 = ((r) (obj1)).x();
        l3 = ((r) (obj1)).y();
          goto _L15
_L18:
        h.a(l1, l6, l3, l5, l4);
          goto _L16
_L14:
        l6 = ((r) (obj1)).j();
        l4 = ((r) (obj1)).i();
        l2 = ((r) (obj1)).y();
        l3 = ((r) (obj1)).x();
          goto _L15
_L12:
        StatusManager.j().v();
        return null;
_L4:
        throw new TaskMgrException("[_generateMasterBufferFromID] Cannot get masterResult");
_L7:
        obj = obj1;
        try
        {
            throw new TaskMgrException("[_generateMasterBufferFromID] Cannot get stretchResult");
        }
        // Misplaced declaration of an exception variable
        catch (Argd argd) { }
          goto _L17
        argd;
          goto _L17
_L15:
        l5 = l6;
        if (l6 % 2L == 1L)
        {
            l5 = l6 + 1L;
        }
        l6 = l2;
        if (l2 % 2L == 1L)
        {
            l6 = l2 + 1L;
        }
          goto _L18
        argd = null;
        obj2 = obj;
          goto _L19
    }

    private ImageBufferWrapper a(long l1, String s, long l2, long l3, 
            long l4)
    {
        String as[];
        Object obj2;
        obj2 = new bd();
        boolean flag1 = d.a(s, ((bd) (obj2)));
        a((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] GetThumbnailPropertyFromFile. bRet=").append(flag1).toString());
        a(obj2.toString());
        as = s.split("\\.");
        if (as == null) goto _L2; else goto _L1
_L1:
        if (as.length <= 0) goto _L2; else goto _L3
_L3:
        Object obj = as[as.length - 1];
_L9:
        boolean flag = false;
        if (((String) (obj)).equalsIgnoreCase("rw2"))
        {
            flag = true;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        a("[decodeThumbBufferFromJPEGThumbnail] in white list");
        return null;
        Object obj1;
        if (((bd) (obj2)).b() == null || ((bd) (obj2)).b().b() == 0L)
        {
            throw new TaskMgrException((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] No Property File! srcPath=>>>").append(s).append("<<<").toString());
        }
          goto _L4
_L5:
        a(s.getMessage());
        if (obj1 != null)
        {
            ((ImageBufferWrapper) (obj1)).m();
        }
        if (obj != null)
        {
            ((ImageBufferWrapper) (obj)).m();
        }
        return null;
_L4:
        long l5;
        l1 = ((bd) (obj2)).b().a(0).c();
        l5 = ((bd) (obj2)).b().a(0).d();
        boolean flag2;
        if (l4 == -1L)
        {
            l4 = 64L;
        }
        if (Math.min(l1, l5) < l4)
        {
            throw new TaskMgrException((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] Thumbnail size (").append(String.valueOf(l1)).append(", ").append(String.valueOf(l5)).append(") ").append("is too small! srcPath=>>>").append(s).append("<<<").toString());
        }
        obj1 = UIImageOrientation.a;
        obj = ((bd) (obj2)).b().a(0).e();
        obj1 = obj;
_L6:
        obj = ((bd) (obj2)).b().a(0).b();
        a((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] thumbnail width:").append(l1).toString());
        a((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] thumbnail height:").append(l5).toString());
        a((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] thumbnail nOrientation:").append(obj1).toString());
        a((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] thumbnail nType:").append(obj).toString());
        if (l1 <= l2 && l5 <= l3)
        {
            break MISSING_BLOCK_LABEL_520;
        }
        try
        {
            throw new TaskMgrException("[decodeThumbBufferFromJPEGThumbnail] Decoded thumbnail is too large to use, it is larger than source size.");
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            obj = null;
            obj1 = null;
        }
          goto _L5
        obj;
        a((new StringBuilder()).append("Unexpected exception from prop.getItems().get(0).getNOrientation(): ").append(((Exception) (obj)).getMessage()).toString());
          goto _L6
        obj2 = new ImageBufferWrapper();
        ((ImageBufferWrapper) (obj2)).a(4L);
        obj2.imageType = ImageType.b;
        obj2.scaleRatio = 1.0D;
        obj2.name = "Thumbnail_For_Tiny";
        flag2 = d.a(s, ((ImageBufferWrapper) (obj2)).a);
        a((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] imageCodec.GetThumbnailFromFile. bRet=").append(flag2).toString());
        if (flag2)
        {
            break MISSING_BLOCK_LABEL_638;
        }
        throw new TaskMgrException((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] Thumbnail Decode Error! srcPath=>>>").append(s).append("<<<").toString());
        l1 = ((ImageBufferWrapper) (obj2)).b();
        long l6 = ((ImageBufferWrapper) (obj2)).c();
        a((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] decodedBuffer: thumbnail width:").append(l1).toString());
        a((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] decodedBuffer: thumbnail height:").append(l6).toString());
        if (Math.min(l1, l6) < l4)
        {
            throw new TaskMgrException((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] Decoded thumbnail size (").append(String.valueOf(l1)).append(", ").append(String.valueOf(l6)).append(") ").append("is too small! srcPath=>>>").append(s).append("<<<").toString());
        }
        if (Math.abs((double)l2 / (double)l3 - (double)l1 / (double)l6) > 0.050000000000000003D)
        {
            throw new TaskMgrException("[decodeThumbBufferFromJPEGThumbnail] Different Ratio With Source Ratio. Skip it.");
        }
        if (obj1 != UIImageOrientation.a && obj1 != UIImageOrientation.b) goto _L8; else goto _L7
_L8:
        obj = new ImageBufferWrapper();
        flag2 = ((ImageBufferWrapper) (obj)).a(((ImageBufferWrapper) (obj2)), ((UIImageOrientation) (obj1)));
        a((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbnail] createBufferFromImageBuffer, orientation=").append(obj1).append(", bRet=").append(flag2).toString());
        if (flag2)
        {
            break MISSING_BLOCK_LABEL_933;
        }
        throw new TaskMgrException((new StringBuilder()).append("[decodeThumbBufferFromJPEGThumbmail] Thumbnail Rotate Error! srcPath=>>>").append(s).append("<<<, orientation=").append(obj1).toString());
        ((ImageBufferWrapper) (obj2)).m();
        obj1 = null;
        ((ImageBufferWrapper) (obj)).b();
        ((ImageBufferWrapper) (obj)).c();
        return ((ImageBufferWrapper) (obj));
        s;
          goto _L5
_L2:
        obj = "";
          goto _L9
        s;
        obj1 = obj2;
        obj = null;
          goto _L5
_L7:
        return ((ImageBufferWrapper) (obj2));
        s;
        obj1 = obj2;
          goto _L5
    }

    private ImageBufferWrapper a(long l1, String s, long l2, long l3, 
            com.cyberlink.youcammakeup.jniproxy.q q1, long l4)
    {
        Object obj;
        Object obj1;
        UIImageOrientation uiimageorientation;
        obj1 = new ba();
        if (!d.a(s, ((ba) (obj1))))
        {
            a((new StringBuilder()).append("[decodeThumbBufferFromFile] Fail to get metadata: imageID=").append(l1).append(", srcPath=").append(s).toString());
            return null;
        }
        double d1;
        long l5;
        long l6;
        boolean flag;
        if (l4 != -1L)
        {
            l5 = l4;
        } else
        {
            l5 = 200L;
        }
        if (l4 != -1L)
        {
            d1 = Math.min(1.0D, Math.max((double)l5 / (double)l2, (double)l5 / (double)l3));
        } else
        {
            d1 = Math.min(1.0D, Math.min((double)l5 / (double)l2, (double)l5 / (double)l3));
        }
        l2 = Math.round((double)l2 * d1);
        l3 = Math.round((double)l3 * d1);
        obj = ((ba) (obj1)).b().b();
        uiimageorientation = ((ba) (obj1)).b().e();
        l4 = Math.round(Math.floor(1.0D / d1));
        obj1 = new ap();
        flag = d.a(s, ((UIImageFormat) (obj)), l4, ((ap) (obj1)));
        a((new StringBuilder()).append("[decodeThumbBufferFromFile] imageCodec.CalcOutputDimension. bRet=").append(flag).toString());
        if (!flag) goto _L2; else goto _L1
_L1:
        l5 = ((ap) (obj1)).b();
        l6 = ((ap) (obj1)).c();
        a((new StringBuilder()).append("[decodeThumbBufferFromFile] calculated resultDimension.getUlWidth=").append(l5).toString());
        a((new StringBuilder()).append("[decodeThumbBufferFromFile] calculated resultDimension.getUlHeight=").append(l6).toString());
        obj1 = new t();
        ((t) (obj1)).a(UIBytePerPixel.a);
        ((t) (obj1)).a(((UIImageFormat) (obj)));
        ((t) (obj1)).c(l4);
        ((t) (obj1)).a(l5);
        ((t) (obj1)).b(l6);
        obj = new ImageBufferWrapper();
        obj.name = "TEMP_TINY_MASTER";
        ((ImageBufferWrapper) (obj)).a(l5, l6, 4L);
        q1 = d.a(s, ((ImageBufferWrapper) (obj)).a, ((t) (obj1)), q1);
        a((new StringBuilder()).append("[decodeThumbBufferFromFile] imageCodec.DecodeFromFile. bRet=").append(flag).toString());
        if (q1 != UIImageCodecErrorCode.a) goto _L4; else goto _L3
_L3:
        if (l5 > l2 || l6 > l3) goto _L6; else goto _L5
_L5:
        q1 = ((com.cyberlink.youcammakeup.jniproxy.q) (obj));
_L10:
        obj1 = q1;
        if (uiimageorientation == UIImageOrientation.a) goto _L8; else goto _L7
_L7:
        obj1 = q1;
        obj = UIImageOrientation.b;
        if (uiimageorientation != obj) goto _L9; else goto _L8
_L8:
        s = q1;
_L11:
        s.imageID = l1;
        s.imageType = ImageType.a;
        s.scaleRatio = 1.0D;
        s.name = "Master_For_Tiny";
        return s;
        obj1;
        obj = s;
        s = ((String) (obj1));
_L12:
        a(s.getMessage());
        if (q1 != null)
        {
            q1.m();
        }
        if (obj != null)
        {
            ((ImageBufferWrapper) (obj)).m();
        }
        return null;
_L6:
        q1 = new ImageBufferWrapper();
        obj1 = q1;
        q1.a(l2, l3, 4L);
        obj1 = q1;
        boolean flag1 = d.a(((ImageBufferWrapper) (obj)).a, ((ImageBufferWrapper) (q1)).a, UIInterpolation.b);
        obj1 = q1;
        a((new StringBuilder()).append("[decodeThumbBufferFromFile] imageCodec.Stretch. bRet=").append(flag1).toString());
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_651;
        }
        obj1 = q1;
        ((ImageBufferWrapper) (obj)).m();
          goto _L10
        obj1 = q1;
        ((ImageBufferWrapper) (obj)).m();
        obj1 = q1;
        q1.m();
        obj1 = q1;
        a((new StringBuilder()).append("[decodeThumbBufferFromFile] Stretch Error: uiImageCode.Stretch bRet=").append(flag1).toString());
        return null;
_L9:
        obj1 = q1;
        obj = new ImageBufferWrapper();
        flag1 = ((ImageBufferWrapper) (obj)).a(q1, uiimageorientation);
        a((new StringBuilder()).append("[decodeThumbBufferFromFile] createBufferFromImageBuffer, orientation=").append(uiimageorientation).append(", bRet=").append(flag1).toString());
        if (flag1)
        {
            break MISSING_BLOCK_LABEL_806;
        }
        throw new TaskMgrException((new StringBuilder()).append("[decodeThumbBufferFromFile] Thumbnail Rotate Error! srcPath=>>>").append(s).append("<<<, orientation=").append(uiimageorientation).toString());
        q1.m();
        q1 = null;
        s = ((String) (obj));
          goto _L11
_L4:
        ((ImageBufferWrapper) (obj)).m();
        a((new StringBuilder()).append("[decodeThumbBufferFromFile] File Decode Error! srcPath=>>>").append(s).append("<<<, retCode=").append(q1).append(" decodeParam=").append(obj1.toString()).toString());
        return null;
_L2:
        a((new StringBuilder()).append("[decodeThumbBufferFromFile] Output Dimension Calculation Error! srcPath=>>>").append(s).append("<<<, format=").append(((UIImageFormat) (obj)).toString()).append(", sampleSize=").append(l4).toString());
        return null;
        s;
        obj = null;
        q1 = null;
          goto _L12
        s;
        obj = null;
        q1 = ((com.cyberlink.youcammakeup.jniproxy.q) (obj1));
          goto _L12
        s;
          goto _L12
    }

    private ImageBufferWrapper a(e e1, com.cyberlink.youcammakeup.jniproxy.q q1)
    {
        if (e1 == null)
        {
            throw new IllegalArgumentException("Invalid cacheObj: cacheObj should not be null");
        }
        String s = e1.c();
        Object obj = new ba();
        if (!d.a(s, ((ba) (obj))))
        {
            a((new StringBuilder()).append("[loadBufferFromCache] Fail to get metadata: imageID=").append(e1.a()).append(", level=").append(e1.b()).append(", srcPath=").append(s).toString());
            a(e1.a(), e1.b());
            return null;
        }
        Object obj1 = ((ba) (obj)).b().b();
        ap ap1 = new ap();
        d.a(s, ((UIImageFormat) (obj1)), 1L, ap1);
        obj = new t();
        ((t) (obj)).a(UIBytePerPixel.a);
        ((t) (obj)).a(((UIImageFormat) (obj1)));
        ((t) (obj)).c(1L);
        ((t) (obj)).a(ap1.b());
        ((t) (obj)).b(ap1.c());
        obj1 = new ImageBufferWrapper();
        obj1.name = "TEMP_FOR_DECODE_CACHE";
        ((ImageBufferWrapper) (obj1)).a(e1.d(), e1.e(), 4L);
        q1 = d.a(s, ((ImageBufferWrapper) (obj1)).a, ((t) (obj)), q1);
        if (q1 == UIImageCodecErrorCode.a)
        {
            obj1.imageID = e1.a();
            obj1.imageType = ImageType.b;
            obj1.scaleRatio = 1.0D;
            obj1.name = (new StringBuilder()).append("CACHE_").append(e1.b.b()).toString();
            return ((ImageBufferWrapper) (obj1));
        }
        ((ImageBufferWrapper) (obj1)).m();
        a((new StringBuilder()).append("[loadBufferFromCache] Fail to decode file: imageID=").append(e1.a()).append(", level=").append(e1.b()).append(", retCode=").append(q1).append(", srcPath=").append(s).toString());
        if (q1 != UIImageCodecErrorCode.d)
        {
            a(e1.a(), e1.b());
        }
        return null;
    }

    private ImageBufferWrapper a(DecodeOpCode decodeopcode, ImageBufferWrapper imagebufferwrapper, Argd argd)
    {
        long l7;
        l7 = ((Long)argd.get("taskID")).longValue();
        e.a(l7);
        if (decodeopcode != DecodeOpCode.a) goto _L2; else goto _L1
_L1:
        long l8 = ((Long)argd.get("imageID")).longValue();
        Object obj = e(l8);
        obj;
        JVM INSTR monitorenter ;
        decodeopcode = g.a(l8, 1.0D, ImageType.a);
        if (decodeopcode == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        a("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] hit cachedMasterBuffer");
        decodeopcode.l();
        obj;
        JVM INSTR monitorexit ;
        return decodeopcode;
        imagebufferwrapper = (String)argd.get("srcPath");
        if (com.cyberlink.youcammakeup.kernelctrl.viewengine.k.a(imagebufferwrapper))
        {
            throw new TaskMgrException("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] undefined srcPath");
        }
        break MISSING_BLOCK_LABEL_127;
        decodeopcode;
        obj;
        JVM INSTR monitorexit ;
        throw decodeopcode;
        decodeopcode = new ba();
        d.a(imagebufferwrapper, decodeopcode);
        e.a(((Long)argd.get("taskID")).longValue());
        a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] ").append(decodeopcode).toString());
        if (b.containsKey(Long.valueOf(l8)))
        {
            b.remove(Long.valueOf(l8));
        }
        b.put(Long.valueOf(l8), decodeopcode);
        argd = i.c(l8);
        if (a == null) goto _L4; else goto _L3
_L3:
        long l1 = a.b.a;
_L22:
        if (a == null) goto _L6; else goto _L5
_L5:
        long l3 = a.b.b;
_L23:
        if (a == null) goto _L8; else goto _L7
_L7:
        long l2 = a.a.a;
_L24:
        if (a == null) goto _L10; else goto _L9
_L9:
        long l5 = a.a.b;
          goto _L11
_L40:
        Object obj1;
        long l6;
        boolean flag2;
        decodeopcode = decodeopcode.b().b();
        l2 = Math.round(Math.max((double)l6 / (double)l1, (double)l3 / (double)l5));
        obj1 = new ap();
        flag2 = d.a(imagebufferwrapper, decodeopcode, l2, ((ap) (obj1)));
        a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] imageCodec.CalcOutputDimension. bRet=").append(flag2).toString());
        if (!flag2) goto _L13; else goto _L12
_L12:
        Object obj2;
        l3 = ((ap) (obj1)).b();
        l6 = ((ap) (obj1)).c();
        a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] calculated resultDimension.getUlWidth=").append(l3).toString());
        a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] calculated resultDimension.getUlHeight=").append(l6).toString());
        obj1 = new t();
        ((t) (obj1)).a(UIBytePerPixel.a);
        ((t) (obj1)).a(decodeopcode);
        ((t) (obj1)).c(l2);
        ((t) (obj1)).a(l3);
        ((t) (obj1)).b(l6);
        decodeopcode = new ImageBufferWrapper();
        decodeopcode.name = "TEMP_BUFFER_FOR_DECODING";
        decodeopcode.a(l3, l6, 4L);
        obj2 = new com.cyberlink.youcammakeup.jniproxy.q();
        com.cyberlink.youcammakeup.kernelctrl.viewengine.f.e(e).put(Long.valueOf(l7), obj2);
        obj2 = d.a(imagebufferwrapper, ((ImageBufferWrapper) (decodeopcode)).a, ((t) (obj1)), ((com.cyberlink.youcammakeup.jniproxy.q) (obj2)));
        com.cyberlink.youcammakeup.kernelctrl.viewengine.f.e(e).remove(Long.valueOf(l7));
        a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] imageCodec.DecodeFromFile. bRet=").append(flag2).toString());
        if (obj2 != UIImageCodecErrorCode.a) goto _L15; else goto _L14
_L14:
        if (l3 > l1 || l6 > l5) goto _L17; else goto _L16
_L16:
        if (argd != null) goto _L19; else goto _L18
_L18:
        imagebufferwrapper = UIImageOrientation.a;
_L25:
        if (imagebufferwrapper != UIImageOrientation.a && imagebufferwrapper != UIImageOrientation.b && imagebufferwrapper != null) goto _L21; else goto _L20
_L20:
        decodeopcode.name = "File_Master";
_L26:
        imagebufferwrapper = decodeopcode;
        if (decodeopcode.b() % 2L == 1L)
        {
            imagebufferwrapper = new ImageBufferWrapper();
            imagebufferwrapper.a(1L + decodeopcode.b(), decodeopcode.c(), decodeopcode.d());
            d.a(((ImageBufferWrapper) (decodeopcode)).a, imagebufferwrapper.a);
            decodeopcode.m();
        }
        imagebufferwrapper.imageID = l8;
        imagebufferwrapper.imageType = ImageType.a;
        imagebufferwrapper.scaleRatio = 1.0D;
        obj;
        JVM INSTR monitorexit ;
        return imagebufferwrapper;
_L4:
        l1 = argd.j();
          goto _L22
_L6:
        l3 = argd.i();
          goto _L23
_L8:
        l2 = argd.y();
          goto _L24
_L10:
        l5 = argd.x();
          goto _L11
_L17:
        imagebufferwrapper = new ImageBufferWrapper();
        imagebufferwrapper.a(l1, l5, 4L);
        flag2 = d.a(((ImageBufferWrapper) (decodeopcode)).a, imagebufferwrapper.a);
        a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] imageCodec.Stretch. bRet=").append(flag2).toString());
        if (!flag2)
        {
            break MISSING_BLOCK_LABEL_882;
        }
        decodeopcode.m();
        decodeopcode = imagebufferwrapper;
          goto _L16
        decodeopcode.m();
        imagebufferwrapper.m();
        throw new TaskMgrException((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] Stretch Error: uiImageCode.Stretch bRet=").append(flag2).toString());
_L19:
        imagebufferwrapper = argd.d();
          goto _L25
_L21:
        argd = new ImageBufferWrapper();
        argd.a(decodeopcode, imagebufferwrapper);
        decodeopcode.m();
        argd.name = "File_Master_Rotated";
        decodeopcode = argd;
          goto _L26
_L15:
        decodeopcode.m();
        StatusManager.j().w();
        throw new TaskMgrException((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] File Decode Error! srcPath=>>>").append(imagebufferwrapper).append("<<<, retCode=").append(obj2).append(" decodeParam=").append(obj1.toString()).toString());
_L13:
        throw new TaskMgrException((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] Output Dimension Calculation Error! srcPath=>>>").append(imagebufferwrapper).append("<<<, format=").append(decodeopcode.toString()).append(", sampleSize=").append(l2).toString());
_L2:
        if (decodeopcode == DecodeOpCode.b)
        {
            throw new UnsupportedOperationException((new StringBuilder()).append("[_decodeImageBufferAsync] opCode=").append(decodeopcode).append(" is not ported since it should not be used in Android project").toString());
        }
        if (decodeopcode != com.cyberlink.youcammakeup.kernelctrl.viewengine.DecodeOpCode.c) goto _L28; else goto _L27
_L27:
        String s = (String)argd.get("srcPath");
        Long long1 = (Long)argd.get("srcW");
        Long long2 = (Long)argd.get("srcH");
        double d1;
        double d2;
        bd bd1;
        boolean flag;
        boolean flag1;
        long l4;
        boolean flag3;
        if (argd.a("ignoreASRatio"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bd1 = new bd();
        flag3 = d.a(s, bd1);
        a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] GetThumbnailPropertyFromFile. bRet=").append(flag3).toString());
        e.a(((Long)argd.get("taskID")).longValue());
        a(bd1.toString());
        decodeopcode = s.split("\\.");
        if (decodeopcode == null) goto _L30; else goto _L29
_L29:
        if (decodeopcode.length <= 0) goto _L30; else goto _L31
_L31:
        decodeopcode = decodeopcode[decodeopcode.length - 1];
_L41:
        flag1 = false;
        if (decodeopcode.equalsIgnoreCase("rw2"))
        {
            flag1 = true;
        }
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_1306;
        }
        a("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] in white list");
        return null;
        if (bd1.b() == null || bd1.b().b() == 0L)
        {
            throw new TaskMgrException((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] No Property File! srcPath=>>>").append(s).append("<<<").toString());
        }
          goto _L32
_L34:
        if (decodeopcode != null)
        {
            decodeopcode.m();
        }
        throw new TaskMgrException(a("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE]", ((Throwable) (imagebufferwrapper))));
_L32:
        l1 = ((Long)argd.get("imageID")).longValue();
        argd = i.c(l1);
        l2 = bd1.b().a(0).c();
        l4 = bd1.b().a(0).d();
        imagebufferwrapper = UIImageOrientation.a;
        decodeopcode = bd1.b().a(0).e();
        imagebufferwrapper = decodeopcode;
_L35:
        try
        {
            decodeopcode = bd1.b().a(0).b();
            a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] thumbnail width:").append(l2).toString());
            a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] thumbnail height:").append(l4).toString());
            a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] thumbnail nOrientation:").append(imagebufferwrapper).toString());
            a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] thumbnail nType:").append(decodeopcode).toString());
            if (l2 > (long)argd.y() || l4 > (long)argd.x())
            {
                a("[_decodeImageBufferAsync] Decoded thumbnail is too large to use, it is larger than source size.");
                return a(l1, s, argd.y(), argd.x(), ((com.cyberlink.youcammakeup.jniproxy.q) (null)), -1L);
            }
            break MISSING_BLOCK_LABEL_1656;
        }
        // Misplaced declaration of an exception variable
        catch (ImageBufferWrapper imagebufferwrapper)
        {
            decodeopcode = null;
        }
        if (true) goto _L34; else goto _L33
_L33:
        decodeopcode;
        a((new StringBuilder()).append("Unexpected exception from prop.getItems().get(0).getNOrientation(): ").append(decodeopcode.getMessage()).toString());
          goto _L35
        decodeopcode = new ImageBufferWrapper();
        decodeopcode.a(4L);
        flag3 = d.a(s, ((ImageBufferWrapper) (decodeopcode)).a);
        a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] imageCodec.GetThumbnailFromFile. bRet=").append(flag3).toString());
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_2028;
        }
        l1 = decodeopcode.b();
        l2 = decodeopcode.c();
        a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] decodedBuffer: thumbnail width:").append(l1).toString());
        a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] decodedBuffer: thumbnail height:").append(l2).toString());
        if (l1 >= 64L && l2 >= 64L)
        {
            break MISSING_BLOCK_LABEL_1807;
        }
        throw new TaskMgrException("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] Decoded thumbnail is too small to use");
        if (imagebufferwrapper != UIImageOrientation.a && imagebufferwrapper != UIImageOrientation.b) goto _L37; else goto _L36
_L36:
        decodeopcode.name = "ThumbNail";
        imagebufferwrapper = decodeopcode;
_L39:
        d2 = -1D;
        d1 = d2;
        if (long1 == null)
        {
            break MISSING_BLOCK_LABEL_1868;
        }
        d1 = d2;
        if (long2 == null)
        {
            break MISSING_BLOCK_LABEL_1868;
        }
        d1 = (double)long1.longValue() / (double)long2.longValue();
        d2 = (double)l1 / (double)l2;
        if (flag || d1 == -1D)
        {
            break; /* Loop/switch isn't completed */
        }
        if (Math.abs(d1 - d2) > 0.050000000000000003D)
        {
            imagebufferwrapper.m();
            throw new TaskMgrException("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] Different Ratio With Source Ratio. Skip it.");
        }
        break; /* Loop/switch isn't completed */
_L37:
        argd = new ImageBufferWrapper();
        argd.name = "ThumbNail_Rotated";
        flag3 = argd.a(decodeopcode, imagebufferwrapper);
        decodeopcode.m();
        if (flag3)
        {
            break MISSING_BLOCK_LABEL_1997;
        }
        throw new TaskMgrException((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] Thumbnail Rotation Error! srcPath=>>>").append(s).append("<<<, thumbOrientation=").append(imagebufferwrapper.toString()).toString());
        l1 = argd.b();
        l2 = argd.c();
        imagebufferwrapper = argd;
        if (true) goto _L39; else goto _L38
_L38:
        imagebufferwrapper.imageType = ImageType.b;
        imagebufferwrapper.scaleRatio = 1.0D;
        return imagebufferwrapper;
        try
        {
            throw new TaskMgrException((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_THUMB_FROM_FILE] Thumbnail Decode Error! srcPath=>>>").append(s).append("<<<").toString());
        }
        // Misplaced declaration of an exception variable
        catch (ImageBufferWrapper imagebufferwrapper) { }
        if (true) goto _L34; else goto _L28
_L28:
        if (decodeopcode == com.cyberlink.youcammakeup.kernelctrl.viewengine.DecodeOpCode.d)
        {
            throw new UnsupportedOperationException((new StringBuilder()).append("[_decodeImageBufferAsync] opCode=").append(decodeopcode).append(" is not ported since it should not be used in Android project").toString());
        }
        if (decodeopcode == com.cyberlink.youcammakeup.kernelctrl.viewengine.DecodeOpCode.e)
        {
            argd = (ImageBufferWrapper)argd.get("srcBuffer");
            if (argd == null)
            {
                throw new TaskMgrException((new StringBuilder()).append("[STRETCH_DEFAULT] Cannot Stretch. Unknown SourceFile: ").append(decodeopcode).toString());
            }
            if (imagebufferwrapper != null && imagebufferwrapper.a == null)
            {
                throw new TaskMgrException((new StringBuilder()).append("[STRETCH_DEFAULT] Cannot Stretch. Unknown TargetBuffer: ").append(decodeopcode).toString());
            }
            argd.l();
            imagebufferwrapper.l();
            flag3 = d.a(((ImageBufferWrapper) (argd)).a, imagebufferwrapper.a);
            argd.m();
            imagebufferwrapper.m();
            if (!flag3 || imagebufferwrapper.a == null)
            {
                throw new TaskMgrException("[STRETCH_DEFAULT] STRETCH_DEFAULT Failed");
            } else
            {
                return imagebufferwrapper;
            }
        } else
        {
            throw new TaskMgrException((new StringBuilder()).append("[STRETCH_DEFAULT] unsupported Opcode: ").append(decodeopcode).toString());
        }
_L11:
        l6 = l1;
        if (l1 % 2L == 1L)
        {
            l6 = l1 + 1L;
        }
        l1 = l2;
        if (l2 % 2L == 1L)
        {
            l1 = l2 + 1L;
        }
          goto _L40
_L30:
        decodeopcode = "";
          goto _L41
    }

    private ImageBufferWrapper a(DecodeOpCode decodeopcode, ImageBufferWrapper imagebufferwrapper, Argd argd, boolean flag, boolean flag1)
    {
        if (decodeopcode == DecodeOpCode.a)
        {
            long l5 = ((Long)argd.get("imageID")).longValue();
            argd = (String)argd.get("srcPath");
            if (com.cyberlink.youcammakeup.kernelctrl.viewengine.k.a(argd))
            {
                return null;
            }
            ba ba1 = new ba();
            d.a(argd, ba1);
            a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] ").append(ba1).toString());
            decodeopcode = null;
            Object obj;
            int i1;
            int j1;
            long l1;
            long l2;
            long l3;
            long l4;
            boolean flag2;
            if (flag)
            {
                imagebufferwrapper = ba1.b();
                l2 = imagebufferwrapper.d();
                l1 = imagebufferwrapper.c();
            } else
            {
                decodeopcode = i.c(l5);
                if (a != null)
                {
                    l1 = a.b.a;
                } else
                {
                    l1 = decodeopcode.j();
                }
                if (a != null)
                {
                    l2 = a.b.b;
                } else
                {
                    l2 = decodeopcode.i();
                }
            }
            imagebufferwrapper = com.cyberlink.youcammakeup.database.m.b((int)l1, (int)l2);
            l4 = ((Point) (imagebufferwrapper)).x;
            l3 = ((Point) (imagebufferwrapper)).y;
            i1 = Math.max((int)l1, (int)l2);
            j1 = Math.max((int)l4, (int)l3);
            if (j1 < i1 && (double)j1 * 1.3D > (double)i1)
            {
                l3 = l2;
                l2 = l1;
            } else
            {
                l2 = l4;
            }
            if (l1 % 2L != 1L);
            if (l2 % 2L == 1L)
            {
                l1 = l2 + 1L;
            } else
            {
                l1 = l2;
            }
            imagebufferwrapper = ba1.b().b();
            obj = new ap();
            flag2 = d.a(argd, imagebufferwrapper, 1L, ((ap) (obj)));
            a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] imageCodec.CalcOutputDimension. bRet=").append(flag2).toString());
            if (flag2)
            {
                l2 = ((ap) (obj)).b();
                l4 = ((ap) (obj)).c();
                a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] calculated resultDimension.getUlWidth=").append(l2).toString());
                a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] calculated resultDimension.getUlHeight=").append(l4).toString());
                obj = new t();
                ((t) (obj)).a(UIBytePerPixel.a);
                ((t) (obj)).a(imagebufferwrapper);
                ((t) (obj)).c(1L);
                ((t) (obj)).a(l2);
                ((t) (obj)).b(l4);
                imagebufferwrapper = new ImageBufferWrapper();
                imagebufferwrapper.name = "TEMP_BUFFER_FOR_DECODING";
                imagebufferwrapper.a(l2, l4, 4L);
                com.cyberlink.youcammakeup.jniproxy.q q1 = new com.cyberlink.youcammakeup.jniproxy.q();
                argd = d.a(argd, imagebufferwrapper.a, ((t) (obj)), q1);
                a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] imageCodec.DecodeFromFile. bRet=").append(flag2).toString());
                if (argd == UIImageCodecErrorCode.a)
                {
                    if (l2 > l1 || l4 > l3)
                    {
                        argd = new ImageBufferWrapper();
                        argd.a(l1, l3, 4L);
                        boolean flag3 = d.a(imagebufferwrapper.a, ((ImageBufferWrapper) (argd)).a);
                        a((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] imageCodec.Stretch. bRet=").append(flag3).toString());
                        if (flag3)
                        {
                            imagebufferwrapper.m();
                            imagebufferwrapper = argd;
                        } else
                        {
                            imagebufferwrapper.m();
                            argd.m();
                            throw new TaskMgrException((new StringBuilder()).append("[_decodeImageBufferAsync][DECODE_MASTER_FROM_FILE] Stretch Error: uiImageCode.Stretch bRet=").append(flag3).toString());
                        }
                    }
                    argd = UIImageOrientation.a;
                    if (flag)
                    {
                        try
                        {
                            decodeopcode = ba1.b().e();
                        }
                        // Misplaced declaration of an exception variable
                        catch (DecodeOpCode decodeopcode)
                        {
                            decodeopcode = argd;
                        }
                    } else
                    if (decodeopcode == null)
                    {
                        decodeopcode = UIImageOrientation.a;
                    } else
                    {
                        decodeopcode = decodeopcode.d();
                    }
                    if (decodeopcode == UIImageOrientation.a || decodeopcode == UIImageOrientation.b || decodeopcode == null || !flag1)
                    {
                        imagebufferwrapper.name = "File_Master";
                        decodeopcode = imagebufferwrapper;
                    } else
                    {
                        argd = new ImageBufferWrapper();
                        argd.a(imagebufferwrapper, decodeopcode);
                        imagebufferwrapper.m();
                        argd.name = "File_Master_Rotated";
                        decodeopcode = argd;
                    }
                    if (decodeopcode.b() % 2L == 1L)
                    {
                        imagebufferwrapper = new ImageBufferWrapper();
                        imagebufferwrapper.a(decodeopcode.b() + 1L, decodeopcode.c(), decodeopcode.d());
                        d.a(((ImageBufferWrapper) (decodeopcode)).a, imagebufferwrapper.a);
                        decodeopcode.m();
                        decodeopcode = imagebufferwrapper;
                    }
                    decodeopcode.imageID = l5;
                    decodeopcode.imageType = ImageType.a;
                    decodeopcode.scaleRatio = 1.0D;
                    return decodeopcode;
                }
            }
        }
        return null;
    }

    static ImageBufferWrapper a(ViewEngine viewengine, long l1, double d1, Argd argd)
    {
        return viewengine.a(l1, d1, argd);
    }

    static ImageBufferWrapper a(ViewEngine viewengine, e e1, com.cyberlink.youcammakeup.jniproxy.q q1)
    {
        return viewengine.a(e1, q1);
    }

    private ImageBufferWrapper a(String s, Object obj, Argd argd)
    {
        Argd argd1 = argd;
        if (argd == null)
        {
            argd1 = new Argd();
        }
        e.a(((Long)argd1.get("taskID")).longValue());
        if (com.cyberlink.youcammakeup.kernelctrl.viewengine.k.a(s))
        {
            throw new TaskMgrException("[_generateMasterBufferFromSrcAsync] undefined srcPath");
        }
        if (s != null)
        {
            argd1.put("srcPath", s);
        }
        if (obj != null)
        {
            argd1.put("stream", obj);
        }
        if (obj != null)
        {
            s = DecodeOpCode.b;
        } else
        {
            s = DecodeOpCode.a;
        }
        s = a(((DecodeOpCode) (s)), ((ImageBufferWrapper) (null)), argd1);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        if (((ImageBufferWrapper) (s)).a == null)
        {
            break MISSING_BLOCK_LABEL_142;
        }
        s.scaleRatio = 1.0D;
        s.srcW = s.b();
        s.srcH = s.c();
        return s;
        try
        {
            throw new TaskMgrException("[_generateMasterBufferFromSrcAsync] Cannot generate the Source buffer.");
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        if (!s.getMessage().isEmpty())
        {
            throw s;
        } else
        {
            throw new TaskMgrException("[_generateMasterBufferFromSrcAsync] Unexpected Error", s);
        }
    }

    public static ViewEngine a()
    {
        return com.cyberlink.youcammakeup.kernelctrl.viewengine.h.a();
    }

    private String a(String s, Throwable throwable)
    {
        if (throwable != null && !throwable.getMessage().isEmpty())
        {
            return (new StringBuilder()).append(s).append(throwable.getMessage()).toString();
        } else
        {
            return (new StringBuilder()).append(s).append(" UnExpect Reuslt").toString();
        }
    }

    private void a(long l1, d d1)
    {
        e e1 = k.a(l1, d1);
        if (e1 != null)
        {
            k.b(l1, d1);
            File file = new File(e1.c());
            if (file.exists() && !file.delete())
            {
                a((new StringBuilder()).append("[ViewEngine][removeImageCache] Fail to delete file: ").append(e1.c()).toString());
            }
            StatusManager.j().a(l1, d1);
        }
    }

    private void a(long l1, ImageBufferWrapper imagebufferwrapper, d d1, UIImageOrientation uiimageorientation)
    {
        a(l1, d1);
        String s = Globals.d().k();
        if (s == null)
        {
            a("[ViewEngine][writeBufferToCache] Unexpected Situation: cacheFolderPath is null. Skip it.");
        } else
        {
            s = (new StringBuilder()).append(s).append("/").append(UUID.randomUUID().toString()).append(".jpg").toString();
            if (imagebufferwrapper.a(s, uiimageorientation))
            {
                int i1;
                int j1;
                if (uiimageorientation == UIImageOrientation.g || uiimageorientation == UIImageOrientation.i || uiimageorientation == UIImageOrientation.f || uiimageorientation == UIImageOrientation.h)
                {
                    i1 = (int)imagebufferwrapper.c();
                    j1 = (int)imagebufferwrapper.b();
                } else
                {
                    i1 = (int)imagebufferwrapper.b();
                    j1 = (int)imagebufferwrapper.c();
                }
                imagebufferwrapper = new com.cyberlink.youcammakeup.database.k(l1, d1, s, i1, j1);
                if (k.a(imagebufferwrapper) == null)
                {
                    a((new StringBuilder()).append("[ViewEngine][writeBufferToCache] Fail to insert cacheObj. imageID=").append(l1).append(", level=").append(d1).append(", path=").append(s).append(", w=").append(i1).append(", h=").append(j1).toString());
                    return;
                } else
                {
                    StatusManager.j().a(l1, d1);
                    return;
                }
            }
            a((new StringBuilder()).append("[ViewEngine][writeBufferToCache] Fail to encode buffer to file. imageID=").append(l1).append(", path=").append(s).toString());
            imagebufferwrapper = new File(s);
            if (imagebufferwrapper.exists() && !imagebufferwrapper.delete())
            {
                a((new StringBuilder()).append("[ViewEngine][writeBufferToCache] Fail to delete the useless cache file: ").append(s).toString());
                return;
            }
        }
    }

    static void a(ViewEngine viewengine, long l1)
    {
        viewengine.f(l1);
    }

    private void a(String s)
    {
    }

    private ImageBufferWrapper b(long l1, double d1, DecodePolicy decodepolicy, Argd argd)
    {
        double d2;
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        Argd argd1;
        com.cyberlink.youcammakeup.jniproxy.d d3;
        ImageType imagetype;
        boolean flag;
        boolean flag1;
        boolean flag2;
        long l2;
        long l3;
        if (argd == null)
        {
            argd1 = new Argd();
        } else
        {
            argd1 = argd;
        }
        e.a(((Long)argd1.get("taskID")).longValue());
        obj2 = null;
        d3 = null;
        obj1 = null;
        if (!com.cyberlink.youcammakeup.kernelctrl.viewengine.i.a(l1)) goto _L2; else goto _L1
_L1:
        obj2 = a(l1, d1, DecodePolicy.a, argd1);
_L26:
        return ((ImageBufferWrapper) (obj2));
_L2:
        imagetype = ImageType.b;
        if (argd1.a("noCache"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a((new StringBuilder()).append("[_findAndGenerateThumbSrcAsync] start:").append(l1).append(" scaleRatio:").append(d1).append(" policy:").append(decodepolicy).toString());
        if (argd1.a("ignoreASRatio")) goto _L4; else goto _L3
_L3:
        argd = a(l1);
_L30:
        if (decodepolicy != DecodePolicy.b || argd1.a("ignoreASRatio") || argd == null) goto _L6; else goto _L5
_L5:
        l2 = ((com.cyberlink.youcammakeup.kernelctrl.viewengine.d) (argd)).a.a;
        l3 = ((com.cyberlink.youcammakeup.kernelctrl.viewengine.d) (argd)).a.b;
        if (l2 <= 0L || l3 <= 0L) goto _L6; else goto _L7
_L7:
        d2 = (double)l2 / (double)l3;
_L43:
        obj = g.a(l1, d1, imagetype);
        flag2 = false;
        flag1 = flag2;
        if (obj == null) goto _L9; else goto _L8
_L8:
        flag1 = flag2;
        if (((ImageBufferWrapper) (obj)).a == null) goto _L9; else goto _L10
_L10:
        flag1 = flag2;
        if (decodepolicy != DecodePolicy.b) goto _L9; else goto _L11
_L11:
        flag1 = flag2;
        if (argd1.a("ignoreASRatio")) goto _L9; else goto _L12
_L12:
        if (d2 == -1D) goto _L14; else goto _L13
_L13:
        flag1 = flag2;
        if (Math.abs((double)((ImageBufferWrapper) (obj)).b() / (double)((ImageBufferWrapper) (obj)).c() - d2) <= 0.01D) goto _L9; else goto _L15
_L15:
        a("[_findAndGenerateThumbSrcAsync] different AspectRatio. Re-gen. it");
        flag1 = true;
_L9:
        argd = null;
        if (flag1) goto _L17; else goto _L16
_L16:
        if (obj == null) goto _L19; else goto _L18
_L18:
        if (((ImageBufferWrapper) (obj)).a == null) goto _L19; else goto _L20
_L20:
        a((new StringBuilder()).append("[_findAndGenerateThumbSrcAsync][MASTER] get  Cache from VECacheMgr:").append(l1).append(" scaleRatio:").append(d1).append(" policy:").append(decodepolicy).toString());
        obj2 = obj;
        obj3 = d3;
        ((ImageBufferWrapper) (obj)).l();
        argd = null;
_L33:
        if (obj == null) goto _L22; else goto _L21
_L21:
        argd = null;
_L34:
        if (obj == null) goto _L24; else goto _L23
_L23:
        obj2 = null;
        argd = ((Argd) (obj));
        obj = obj2;
_L40:
        obj2 = argd;
        if (argd != null) goto _L26; else goto _L25
_L25:
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_461;
        }
        ((ImageBufferWrapper) (obj1)).m();
        if (obj == null) goto _L28; else goto _L27
_L27:
        obj2 = ((ImageBufferWrapper) (obj)).a;
        if (obj2 == null) goto _L28; else goto _L29
_L29:
        obj2 = obj;
        obj3 = obj1;
        a((new StringBuilder()).append("[_findAndGenerateThumbSrcAsync][Thumb] Stretch Finish:").append(((ImageBufferWrapper) (obj)).e()).toString());
        return ((ImageBufferWrapper) (obj));
_L4:
        argd = null;
          goto _L30
_L14:
        try
        {
            a("[_findAndGenerateThumbSrcAsync] getSizePromise Error~!!!");
            throw new TaskMgrException("[_findAndGenerateThumbSrcAsync] getSizePromise Error~!!!");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            argd = null;
        }
        obj1 = obj2;
_L41:
        if (obj1 != null)
        {
            ((ImageBufferWrapper) (obj1)).m();
        }
        if (argd != null)
        {
            argd.m();
        }
        if (decodepolicy != DecodePolicy.b) goto _L32; else goto _L31
_L19:
        if (imagetype != ImageType.b || (ThumbnailRule)argd1.get("thumbRule") != com.cyberlink.youcammakeup.kernelctrl.viewengine.ThumbnailRule.c)
        {
            break MISSING_BLOCK_LABEL_647;
        }
        argd = null;
        obj = null;
          goto _L33
        if (d1 == -1D)
        {
            break MISSING_BLOCK_LABEL_676;
        }
        argd = g.a(l1, -1D, imagetype);
        obj = null;
          goto _L33
        argd = null;
        obj = null;
          goto _L33
_L22:
        if (argd == null)
        {
            break MISSING_BLOCK_LABEL_853;
        }
        obj2 = obj;
        obj3 = d3;
        if (((ImageBufferWrapper) (argd)).a == null)
        {
            break MISSING_BLOCK_LABEL_853;
        }
        obj2 = obj;
        obj3 = d3;
        if (decodepolicy != DecodePolicy.b)
        {
            break MISSING_BLOCK_LABEL_853;
        }
        obj2 = obj;
        obj3 = d3;
        if (argd1.a("ignoreASRatio"))
        {
            break MISSING_BLOCK_LABEL_853;
        }
        if (d2 == -1D)
        {
            break MISSING_BLOCK_LABEL_819;
        }
        obj2 = obj;
        obj3 = d3;
        if (Math.abs((double)argd.b() / (double)argd.c() - d2) <= 0.01D)
        {
            break MISSING_BLOCK_LABEL_853;
        }
        obj2 = obj;
        obj3 = d3;
        a("[_findAndGenerateThumbSrcAsync] different AspectRatio. Re-gen. it");
        obj2 = obj;
        obj3 = d3;
        try
        {
            throw new TaskMgrException("[_findAndGenerateThumbSrcAsync] Unknown Error");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            argd = ((Argd) (obj2));
        }
        break MISSING_BLOCK_LABEL_1419;
        obj2 = obj;
        obj3 = d3;
        a("[_findAndGenerateThumbSrcAsync] getSizePromise Error~!!!");
        obj2 = obj;
        obj3 = d3;
        throw new TaskMgrException("[_findAndGenerateThumbSrcAsync] getSizePromise Error~!!!");
        if (argd == null)
        {
            break MISSING_BLOCK_LABEL_971;
        }
        obj2 = argd;
        obj1 = obj;
        if (((ImageBufferWrapper) (argd)).a == null)
        {
            break MISSING_BLOCK_LABEL_971;
        }
        obj2 = argd;
        obj1 = obj;
        a((new StringBuilder()).append("[_findAndGenerateThumbSrcAsync][MASTER] get Master from VECacheMgr to generate RatioBuffer imageID:").append(l1).toString());
        obj2 = argd;
        obj1 = obj;
        d2 = ((ImageBufferWrapper) (argd)).scaleRatio;
        if (d1 != d2)
        {
            break MISSING_BLOCK_LABEL_947;
        }
        argd.l();
        obj1 = null;
        obj = argd;
        argd = null;
          goto _L34
        obj2 = argd;
        obj1 = obj;
        argd.l();
        obj1 = argd;
        argd = null;
          goto _L34
        obj2 = argd;
        obj1 = obj;
        a((new StringBuilder()).append("[_findAndGenerateThumbSrcAsync][MASTER][DB]  get Master from DB imageID:").append(l1).toString());
        obj2 = argd;
        obj1 = obj;
        obj3 = b(l1, argd1);
        obj1 = argd;
        argd = ((Argd) (obj3));
          goto _L34
_L24:
        if (argd == null) goto _L36; else goto _L35
_L35:
        obj2 = obj;
        obj3 = obj1;
        d3 = ((ImageBufferWrapper) (argd)).a;
        if (d3 == null) goto _L36; else goto _L37
_L37:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_1104;
        }
        obj2 = argd;
        obj1 = obj;
        h.a(l1, argd.b(), argd.c());
        obj2 = argd;
        obj1 = obj;
        g.b(argd);
        obj2 = argd;
        obj1 = obj;
        d2 = ((ImageBufferWrapper) (argd)).scaleRatio;
        if (d1 == d2 || d1 == -1D)
        {
            obj1 = null;
            flag = false;
        } else
        {
            obj1 = argd;
            argd = ((Argd) (obj));
            flag = true;
        }
_L42:
        if (!flag || obj1 == null) goto _L39; else goto _L38
_L38:
        obj2 = argd;
        obj3 = obj1;
        obj = a(l1, d1, ((ImageBufferWrapper) (obj1)), argd1);
          goto _L40
_L28:
        try
        {
            throw new TaskMgrException("[_findAndGenerateThumbSrcAsync] Another Unknown Error");
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
          goto _L41
_L31:
        if (imagetype == ImageType.b && (ThumbnailRule)argd1.get("thumbRule") == ThumbnailRule.b)
        {
            return null;
        }
        if (d1 == -1D)
        {
            d2 = a(l1, argd1.a("viewerWidth", -1L), argd1.a("viewerHeight", -1L));
            argd1.put("asThumbSrc", Boolean.valueOf(true));
        } else
        {
            d2 = d1;
        }
        if (d2 == -1D)
        {
            d2 = d1;
        }
        if (d2 == -1D)
        {
            break MISSING_BLOCK_LABEL_1270;
        }
        return a(l1, d2, DecodePolicy.a, argd1);
        throw new TaskMgrException("[_findAndGenerateThumbSrcAsync][DECODE_POLICY_THUMB]");
        decodepolicy;
        throw new TaskMgrException(a("[_findAndGenerateThumbSrcAsync][DECODE_POLICY_THUMB]", decodepolicy), decodepolicy);
_L32:
        throw new TaskMgrException(a("[_findAndGenerateThumbSrcAsync][DECODE_POLICY_MASTER]", ((Throwable) (obj))), ((Throwable) (obj)));
        obj;
        argd = ((Argd) (obj1));
        obj1 = obj2;
          goto _L41
        obj;
        obj1 = argd;
          goto _L41
        obj;
        argd = ((Argd) (obj2));
        obj1 = obj3;
          goto _L41
_L39:
        obj = null;
          goto _L40
_L36:
        argd = ((Argd) (obj));
        flag = true;
          goto _L42
_L17:
        obj = null;
          goto _L33
_L6:
        d2 = -1D;
          goto _L43
        obj1 = obj3;
          goto _L41
    }

    private ImageBufferWrapper b(long l1, Argd argd)
    {
        Argd argd1;
        r r1;
        argd1 = argd;
        if (argd == null)
        {
            argd1 = new Argd();
        }
        e.a(((Long)argd1.get("taskID")).longValue());
        if (argd1.get("srcPath") != null)
        {
            break MISSING_BLOCK_LABEL_362;
        }
        r1 = i.c(l1);
        if (r1 == null)
        {
            StatusManager.j().v();
            return null;
        }
        argd = j.b(r1.f());
        if (argd == null) goto _L2; else goto _L1
_L1:
        argd = argd.b();
        if (!(new File(argd)).exists())
        {
            StatusManager.j().v();
            return null;
        }
        UIImageOrientation uiimageorientation = r1.d();
        long l2;
        long l3;
        long l4;
        long l5;
        if (uiimageorientation == UIImageOrientation.g || uiimageorientation == UIImageOrientation.f || uiimageorientation == UIImageOrientation.i || uiimageorientation == UIImageOrientation.h)
        {
            l2 = r1.x();
            l4 = r1.y();
            l3 = r1.i();
            l5 = r1.j();
        } else
        {
            l2 = r1.y();
            l4 = r1.x();
            l3 = r1.j();
            l5 = r1.i();
        }
        if (l3 % 2L == 1L)
        {
            l3++;
        }
        if (l2 % 2L == 1L)
        {
            l2++;
        }
        h.a(l1, l2, l4, l3, l5);
        argd1.put("srcW", Long.valueOf(l2));
        argd1.put("srcH", Long.valueOf(l4));
_L3:
        argd = b(((String) (argd)), null, argd1);
        if (argd != null && ((ImageBufferWrapper) (argd)).a != null)
        {
            argd.imageID = l1;
            argd.scaleRatio = -1D;
            argd.name = "ThumbMaster";
            argd.imageType = ImageType.b;
            return argd;
        } else
        {
            throw new TaskMgrException("[_generateThumbBufferFromID] get the thumbnail failed");
        }
_L2:
        StatusManager.j().v();
        return null;
        argd = (String)argd1.get("srcPath");
          goto _L3
    }

    private ImageBufferWrapper b(String s, Object obj, Argd argd)
    {
        if (com.cyberlink.youcammakeup.kernelctrl.viewengine.k.a(s))
        {
            throw new TaskMgrException("[_generateThumbBufferFromSrcAsync] undefined srcPath");
        }
        Argd argd1 = argd;
        if (argd == null)
        {
            argd1 = new Argd();
        }
        e.a(((Long)argd1.get("taskID")).longValue());
        if (s != null)
        {
            argd1.put("srcPath", s);
        }
        if (obj != null)
        {
            argd1.put("stream", obj);
        }
        if (obj != null)
        {
            s = com.cyberlink.youcammakeup.kernelctrl.viewengine.DecodeOpCode.d;
        } else
        {
            s = com.cyberlink.youcammakeup.kernelctrl.viewengine.DecodeOpCode.c;
        }
        s = a(s, ((ImageBufferWrapper) (null)), argd1);
        if (s != null)
        {
            return s;
        } else
        {
            throw new TaskMgrException("[_generateThumbBufferFromSrcAsync] get the null buffer");
        }
    }

    private ImageBufferWrapper b(byte abyte0[], ba ba1, Long long1)
    {
        Object obj;
        Object obj1;
        long l1;
        long l2;
        long l3;
        boolean flag;
        obj = ba1.b();
        int k1 = (int)((an) (obj)).d();
        int j1 = (int)((an) (obj)).c();
        obj1 = com.cyberlink.youcammakeup.database.m.a(j1, k1);
        l1 = ((Point) (obj1)).x;
        l2 = ((Point) (obj1)).y;
        int i1 = j1;
        if (j1 % 2 == 1)
        {
            i1 = j1 + 1;
        }
        if (l1 % 2L == 1L)
        {
            l1++;
        }
        ba1 = ba1.b().b();
        l3 = Math.round(Math.max((double)i1 / (double)l1, (double)k1 / (double)l2));
        obj1 = new ap();
        flag = d.a(abyte0, abyte0.length, ba1, l3, ((ap) (obj1)));
        a((new StringBuilder()).append("[decodeImageBufferFromBuffer] imageCodec.CalcOutputDimension. bRet=").append(flag).toString());
        if (!flag) goto _L2; else goto _L1
_L1:
        long l4;
        long l5;
        l4 = ((ap) (obj1)).b();
        l5 = ((ap) (obj1)).c();
        a((new StringBuilder()).append("[decodeImageBufferFromBuffer] calculated resultDimension.getUlWidth=").append(l4).toString());
        a((new StringBuilder()).append("[decodeImageBufferFromBuffer] calculated resultDimension.getUlHeight=").append(l5).toString());
        obj1 = new t();
        ((t) (obj1)).a(UIBytePerPixel.a);
        ((t) (obj1)).a(ba1);
        ((t) (obj1)).c(l3);
        ((t) (obj1)).a(l4);
        ((t) (obj1)).b(l5);
        ba1 = new ImageBufferWrapper();
        ba1.name = "TEMP_BUFFER_FOR_DECODING";
        ba1.a(l4, l5, 4L);
        abyte0 = d.a(abyte0, abyte0.length, ((ImageBufferWrapper) (ba1)).a, ((t) (obj1)));
        a((new StringBuilder()).append("[decodeImageBufferFromBuffer] imageCodec.DecodeFromFile. bRet=").append(flag).toString());
        if (abyte0 != UIImageCodecErrorCode.a) goto _L4; else goto _L3
_L3:
        if (l4 <= l1 && l5 <= l2)
        {
            abyte0 = ba1;
        } else
        {
            abyte0 = new ImageBufferWrapper();
            abyte0.a(l1, l2, 4L);
            boolean flag1 = d.a(((ImageBufferWrapper) (ba1)).a, ((ImageBufferWrapper) (abyte0)).a);
            a((new StringBuilder()).append("[decodeImageBufferFromBuffer] imageCodec.Stretch. bRet=").append(flag1).toString());
            if (flag1)
            {
                ba1.m();
            } else
            {
                ba1.m();
                abyte0.m();
                throw new TaskMgrException((new StringBuilder()).append("[decodeImageBufferFromBuffer] Stretch Error: uiImageCode.Stretch bRet=").append(flag1).toString());
            }
        }
        ba1 = UIImageOrientation.a;
        obj = ((an) (obj)).e();
        ba1 = ((ba) (obj));
_L6:
        if (ba1 == UIImageOrientation.a || ba1 == UIImageOrientation.b || ba1 == null)
        {
            abyte0.name = "File_Master";
        } else
        {
            ImageBufferWrapper imagebufferwrapper = new ImageBufferWrapper();
            imagebufferwrapper.a(abyte0, ba1);
            abyte0.m();
            imagebufferwrapper.name = "File_Master_Rotated";
            abyte0 = imagebufferwrapper;
        }
        if (abyte0.b() % 2L == 1L)
        {
            ba1 = new ImageBufferWrapper();
            ba1.a(abyte0.b() + 1L, abyte0.c(), abyte0.d());
            d.a(((ImageBufferWrapper) (abyte0)).a, ((ImageBufferWrapper) (ba1)).a);
            abyte0.m();
            abyte0 = ba1;
        }
        abyte0.imageID = long1.longValue();
        abyte0.imageType = ImageType.a;
        abyte0.scaleRatio = 1.0D;
        return abyte0;
_L4:
        ba1.m();
        throw new TaskMgrException((new StringBuilder()).append("[decodeImageBufferFromBuffer] File Decode Error!  retCode=").append(abyte0).append(" decodeParam=").append(obj1.toString()).toString());
_L2:
        throw new TaskMgrException((new StringBuilder()).append("[decodeImageBufferFromBuffer] Output Dimension Calculation Error! format=").append(ba1.toString()).append(", sampleSize=").append(l3).toString());
        Exception exception;
        exception;
        if (true) goto _L6; else goto _L5
_L5:
    }

    static com.cyberlink.youcammakeup.kernelctrl.viewengine.m b(ViewEngine viewengine)
    {
        return viewengine.g;
    }

    private Object e(long l1)
    {
        this;
        JVM INSTR monitorenter ;
        Object obj;
        if (!m.containsKey(Long.valueOf(l1)))
        {
            m.put(Long.valueOf(l1), new Object());
        }
        obj = m.get(Long.valueOf(l1));
        this;
        JVM INSTR monitorexit ;
        return obj;
        Exception exception;
        exception;
        throw exception;
    }

    private void f(long l1)
    {
        com.cyberlink.youcammakeup.jniproxy.q q1 = (com.cyberlink.youcammakeup.jniproxy.q)com.cyberlink.youcammakeup.kernelctrl.viewengine.f.e(e).get(Long.valueOf(l1));
        if (q1 != null)
        {
            q1.b();
        }
    }

    private void g(long l1)
    {
        e ae[] = k.a(l1);
        if (ae.length > 0)
        {
            k.b(l1);
            int j1 = ae.length;
            for (int i1 = 0; i1 < j1; i1++)
            {
                e e1 = ae[i1];
                File file = new File(e1.c());
                if (file.exists() && !file.delete())
                {
                    a((new StringBuilder()).append("[ViewEngine][removeImageCaches] Fail to delete file: ").append(e1.c()).toString());
                }
                StatusManager.j().a(l1, e1.b);
            }

        }
    }

    public ImageBufferWrapper a(long l1, double d1, ROI roi)
    {
        Argd argd = new Argd();
        argd.put("taskID", Long.valueOf(-99L));
        argd.put("imageID", Long.valueOf(l1));
        if (roi != null)
        {
            argd.put("ROI", a(d1, roi));
        }
        try
        {
            roi = a(l1, d1, argd);
        }
        // Misplaced declaration of an exception variable
        catch (ROI roi)
        {
            a((new StringBuilder()).append("[ViewEngine][getOriginalBuffer] Unexpected Error: ").append(roi.getMessage()).toString());
            roi = (new StringBuilder()).append("[ViewEngine] getOriginalBuffer imageID = ").append(l1).append("[ViewEngine] getOriginalBuffer Unexpected Error: ").append(roi.getMessage()).toString();
            Globals.d().e(roi);
            return null;
        }
        return roi;
    }

    public ImageBufferWrapper a(long l1, double d1, DevelopSetting developsetting, com.cyberlink.youcammakeup.kernelctrl.viewengine.c c1)
    {
        Object obj = new Object();
        l l2 = new l(obj);
        obj;
        JVM INSTR monitorenter ;
        a(l1, d1, developsetting, c1, ((a) (l2)), null);
        obj.wait();
        obj;
        JVM INSTR monitorexit ;
_L2:
label0:
        {
            c1 = l2.b;
            if (c1 != null)
            {
                developsetting = c1;
                if (((ImageBufferWrapper) (c1)).a != null)
                {
                    break label0;
                }
            }
            a((new StringBuilder()).append("[getEditBuffer] Unexpected Error: Cannot get buffer with retouch correctly. callback.cancelType=").append(l2.c).append(", callback.msg=").append(l2.d).toString());
            developsetting = null;
        }
        return developsetting;
        developsetting;
        obj;
        JVM INSTR monitorexit ;
        try
        {
            throw developsetting;
        }
        // Misplaced declaration of an exception variable
        catch (DevelopSetting developsetting)
        {
            developsetting.printStackTrace();
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ImageBufferWrapper a(long l1, com.cyberlink.youcammakeup.jniproxy.q q1)
    {
        Object obj = k.a(l1, d.a);
        if (obj != null)
        {
            ImageBufferWrapper imagebufferwrapper = a(((e) (obj)), q1);
            obj = imagebufferwrapper;
            if (imagebufferwrapper == null)
            {
                obj = imagebufferwrapper;
                if (q1 != null)
                {
                    obj = imagebufferwrapper;
                    if (!q1.c())
                    {
                        obj = b(l1, q1);
                    }
                }
            }
            return ((ImageBufferWrapper) (obj));
        } else
        {
            return b(l1, q1);
        }
    }

    public ImageBufferWrapper a(long l1, com.cyberlink.youcammakeup.jniproxy.q q1, long l2, d d1)
    {
        Object obj = k.a(l1, d1);
        if (obj != null)
        {
            ImageBufferWrapper imagebufferwrapper = a(((e) (obj)), q1);
            obj = imagebufferwrapper;
            if (imagebufferwrapper == null)
            {
                obj = imagebufferwrapper;
                if (q1 != null)
                {
                    obj = imagebufferwrapper;
                    if (!q1.c())
                    {
                        obj = b(l1, q1, l2, d1);
                    }
                }
            }
            return ((ImageBufferWrapper) (obj));
        } else
        {
            return b(l1, q1, l2, d1);
        }
    }

    public ImageBufferWrapper a(ImageBufferWrapper imagebufferwrapper, double d1, ROI roi)
    {
        if (imagebufferwrapper == null || imagebufferwrapper.a == null)
        {
            throw new IllegalArgumentException("Invalid srcBufferWrapper: srcBufferWrapper cannot be null.");
        }
        imagebufferwrapper.l();
        if (d1 >= 1.0D) goto _L2; else goto _L1
_L1:
        Object obj;
        obj = new Argd();
        ((Argd) (obj)).put("taskID", Long.valueOf(-99L));
        obj = a(d1, imagebufferwrapper, ((Argd) (obj)));
_L8:
        if (roi == null) goto _L4; else goto _L3
_L3:
        ROI roi1 = a(d1, roi);
        roi = new ImageBufferWrapper();
        roi.imageID = ((ImageBufferWrapper) (obj)).imageID;
        roi.imageType = ((ImageBufferWrapper) (obj)).imageType;
        roi.name = "roi_image";
        roi.roi = roi1;
        roi.a(((ImageBufferWrapper) (obj)), roi1.e());
        ((ImageBufferWrapper) (obj)).m();
_L6:
        imagebufferwrapper.m();
        return roi;
_L2:
        imagebufferwrapper.l();
        obj = imagebufferwrapper;
        continue; /* Loop/switch isn't completed */
_L4:
        roi = ((ROI) (obj));
        if (true) goto _L6; else goto _L5
_L5:
        roi;
        a((new StringBuilder()).append("[generateScaledRoiBuffer] Unexpected Error: ").append(roi.getMessage()).toString());
        imagebufferwrapper.m();
        return null;
        roi;
        imagebufferwrapper.m();
        throw roi;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public ImageBufferWrapper a(ImageBufferWrapper imagebufferwrapper, float f1)
    {
        if (imagebufferwrapper == null || imagebufferwrapper.a == null)
        {
            com.pf.common.utility.m.b("ViewEngine", "getScaledImageBuffer(), error. srcBufferWrapper or .imageBuffer is null");
            return null;
        }
        imagebufferwrapper.l();
        ImageBufferWrapper imagebufferwrapper1 = new ImageBufferWrapper();
        imagebufferwrapper1.imageID = imagebufferwrapper.imageID;
        imagebufferwrapper1.scaleRatio = imagebufferwrapper.scaleRatio * (double)f1;
        imagebufferwrapper1.imageType = imagebufferwrapper.imageType;
        imagebufferwrapper1.name = "stretch";
        imagebufferwrapper1.a((long)((float)imagebufferwrapper.b() * f1), (long)((float)imagebufferwrapper.c() * f1), imagebufferwrapper.d());
        imagebufferwrapper1.srcW = imagebufferwrapper.srcW;
        imagebufferwrapper1.srcH = imagebufferwrapper.srcH;
        boolean flag = d.a(imagebufferwrapper.a, imagebufferwrapper1.a);
        imagebufferwrapper.m();
        if (flag && imagebufferwrapper1.a != null)
        {
            com.pf.common.utility.m.b("ViewEngine", "getScaledImageBuffer(), info. Success.");
            return imagebufferwrapper1;
        } else
        {
            com.pf.common.utility.m.b("ViewEngine", "getScaledImageBuffer(), error. Stretch failed.");
            imagebufferwrapper1.m();
            return null;
        }
    }

    public ImageBufferWrapper a(byte abyte0[], ba ba1, Long long1)
    {
        try
        {
            abyte0 = b(abyte0, ba1, long1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            a(abyte0.toString());
            return null;
        }
        return abyte0;
    }

    public com.cyberlink.youcammakeup.kernelctrl.viewengine.d a(long l1)
    {
        return h.a(l1, true);
    }

    public com.cyberlink.youcammakeup.kernelctrl.viewengine.d a(long l1, boolean flag)
    {
        return h.a(l1, flag);
    }

    public com.cyberlink.youcammakeup.kernelctrl.viewengine.n a(long l1, double d1, DevelopSetting developsetting, com.cyberlink.youcammakeup.kernelctrl.viewengine.c c1, a a1)
    {
        return a(l1, d1, developsetting, c1, a1, null);
    }

    public com.cyberlink.youcammakeup.kernelctrl.viewengine.n a(long l1, double d1, DevelopSetting developsetting, com.cyberlink.youcammakeup.kernelctrl.viewengine.c c1, a a1, 
            Object obj)
    {
        a((new StringBuilder()).append("[ViewEngine][getEditBuffer] imageID:").append(l1).append(" scaleRatio:").append(d1).toString());
        if (d1 <= 0.0D || d1 > 1.0D)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Invalid scaleRatio: scaleRatio=").append(d1).append(", it should be (0, 1]").toString());
        }
        HashMap hashmap;
        Object obj1;
        HashMap hashmap1;
        if (c1 == null)
        {
            c1 = new Argd();
        } else
        {
            c1 = c1.a();
        }
        hashmap = new HashMap();
        hashmap.put("name", "getEditBufferAsyncEx");
        obj1 = (ROI)c1.get("ROI");
        if (obj1 != null)
        {
            c1.put("ROI", a(d1, ((ROI) (obj1))));
        }
        obj1 = (TaskRole)c1.get("Role");
        hashmap1 = new HashMap();
        hashmap1.put("imageID", Long.valueOf(l1));
        hashmap1.put("scaleRatio", Double.valueOf(d1));
        hashmap1.put("developSetting", developsetting);
        hashmap1.put("argd", c1);
        hashmap.put("Role", obj1);
        return e.a(com/cyberlink/youcammakeup/kernelctrl/viewengine/j, hashmap1, hashmap, a1, obj);
    }

    public void a(long l1, ImageBufferWrapper imagebufferwrapper)
    {
        if (imagebufferwrapper == null || imagebufferwrapper.j() == null)
        {
            return;
        } else
        {
            a((new StringBuilder()).append("[ViewEngine][setSourceBuffer] try to replace source buffer of image(imageID=").append(l1).append(") with buffer(name=").append(imagebufferwrapper.e()).append(")").toString());
            ImageBufferWrapper imagebufferwrapper1 = new ImageBufferWrapper();
            imagebufferwrapper1.a(imagebufferwrapper);
            imagebufferwrapper1.imageID = l1;
            imagebufferwrapper1.scaleRatio = 1.0D;
            imagebufferwrapper1.imageType = ImageType.a;
            imagebufferwrapper1.srcW = imagebufferwrapper1.b();
            imagebufferwrapper1.srcH = imagebufferwrapper1.c();
            imagebufferwrapper1.name = (new StringBuilder()).append(imagebufferwrapper1.name).append("NewSrc").toString();
            com.cyberlink.youcammakeup.kernelctrl.viewengine.m.a(g, l1);
            h.a(l1);
            h.a(l1, imagebufferwrapper1.b(), imagebufferwrapper1.c(), imagebufferwrapper1.b(), imagebufferwrapper1.c());
            g.a(imagebufferwrapper1);
            a((new StringBuilder()).append("[ViewEngine][setSourceBuffer] source buffer of image(imageID=").append(l1).append(") is replaced").toString());
            g(l1);
            imagebufferwrapper1.m();
            return;
        }
    }

    public void a(long l1, ImageBufferWrapper imagebufferwrapper, UIImageOrientation uiimageorientation)
    {
        double d1;
        double d2;
        ImageBufferWrapper imagebufferwrapper1;
        ImageBufferWrapper imagebufferwrapper2;
        long l2;
        long l3;
        imagebufferwrapper.l();
        l3 = imagebufferwrapper.b();
        l2 = imagebufferwrapper.c();
        imagebufferwrapper1 = new ImageBufferWrapper();
        imagebufferwrapper2 = new ImageBufferWrapper();
        d1 = 640D / (double)l3;
        d2 = 640D / (double)l2;
        d1 = Math.min(d1, d2);
        l3 = Math.round((double)l3 * d1);
        l2 = Math.round((double)l2 * d1);
        imagebufferwrapper1.name = "TEMP_CACHE_SMALL";
        imagebufferwrapper1.imageID = l1;
        imagebufferwrapper1.a(l3, l2, imagebufferwrapper.d());
        if (!d.a(imagebufferwrapper.a, imagebufferwrapper1.a, UIInterpolation.b))
        {
            break MISSING_BLOCK_LABEL_316;
        }
        a(l1, imagebufferwrapper1, d.b, uiimageorientation);
        d1 = Math.min(200D / (double)l3, 200D / (double)l2);
        l3 = Math.round((double)l3 * d1);
        l2 = Math.round((double)l2 * d1);
        imagebufferwrapper2.name = "TEMP_CACHE_TINY";
        imagebufferwrapper2.imageID = l1;
        imagebufferwrapper2.a(l3, l2, imagebufferwrapper1.d());
        if (!d.a(imagebufferwrapper1.a, imagebufferwrapper2.a, UIInterpolation.b)) goto _L2; else goto _L1
_L1:
        a(l1, imagebufferwrapper2, d.a, uiimageorientation);
_L3:
        imagebufferwrapper2.m();
        imagebufferwrapper1.m();
        imagebufferwrapper.m();
        return;
_L2:
        a((new StringBuilder()).append("[ViewEngine][generateImageCaches] Fail to stretch tiny buffer. imageID=").append(l1).toString());
          goto _L3
        uiimageorientation;
        imagebufferwrapper2.m();
        imagebufferwrapper1.m();
        imagebufferwrapper.m();
        throw uiimageorientation;
        a((new StringBuilder()).append("[ViewEngine][generateImageCaches] Fail to stretch small buffer. imageID=").append(l1).toString());
          goto _L3
    }

    public void a(long l1, Object obj, UUID uuid)
    {
        a((new StringBuilder()).append("[ViewEngine][onImageIDChange] pre-ImageID:").append(c).append(" setImageID:").append(l1).toString());
        if (c != l1 && c != -1L)
        {
            a("[ViewEngine][onImageIDChange] release buffers not being used");
            g.c();
        }
        if (l1 == -1L)
        {
            return;
        } else
        {
            c = l1;
            return;
        }
    }

    public void a(long l1, String s, long l2, long l3, 
            long l4, long l5)
    {
        g.b();
        h.a();
        g(l1);
        n = s;
        a = new com.cyberlink.youcammakeup.kernelctrl.viewengine.d(new com.cyberlink.youcammakeup.kernelctrl.viewengine.o(l4, l5), new com.cyberlink.youcammakeup.kernelctrl.viewengine.o(l2, l3));
    }

    public boolean a(byte abyte0[], ba ba1)
    {
        boolean flag = d.a(abyte0, abyte0.length, ba1);
        if (flag)
        {
            abyte0 = ba1.b().b();
            long l1 = ba1.b().d();
            long l2 = ba1.b().c();
            a(String.format("getMetaData : %s, %d, %d", new Object[] {
                abyte0.toString(), Long.valueOf(l2), Long.valueOf(l1)
            }));
        }
        return flag;
    }

    public ImageBufferWrapper b(long l1, com.cyberlink.youcammakeup.jniproxy.q q1)
    {
        return b(l1, q1, -1L, d.a);
    }

    public ImageBufferWrapper b(long l1, com.cyberlink.youcammakeup.jniproxy.q q1, long l2, d d1)
    {
        com.cyberlink.youcammakeup.kernelctrl.viewengine.d d2 = a(l1, false);
        String s;
        if (!com.cyberlink.youcammakeup.kernelctrl.viewengine.k.a(n))
        {
            s = n;
        } else
        if (i != null && i.b(l1) != null)
        {
            s = i.b(l1).b();
        } else
        {
            s = null;
        }
        if (s != null && (new File(s)).exists())
        {
            ImageBufferWrapper imagebufferwrapper = a(l1, s, d2.a.a, d2.a.b, l2);
            if (imagebufferwrapper != null && imagebufferwrapper.a != null)
            {
                return imagebufferwrapper;
            }
            q1 = a(l1, s, d2.b.a, d2.b.b, q1, l2);
            if (q1 == null || ((ImageBufferWrapper) (q1)).a == null)
            {
                a((new StringBuilder()).append("[generateTinyThumbBuffer] Unexpected Error: Cannot get tiny cache buffer correctly. imageID=").append(l1).toString());
                return null;
            } else
            {
                a(l1, q1, d1, UIImageOrientation.b);
                return q1;
            }
        } else
        {
            StatusManager.j().v();
            return null;
        }
    }

    b b()
    {
        return f;
    }

    public void b(long l1)
    {
        b(l1, true);
    }

    public void b(long l1, boolean flag)
    {
        a((new StringBuilder()).append("[ViewEngine][clearSourceBuffer] imageID=").append(l1).toString());
        if (flag)
        {
            g.b();
            h.a();
        } else
        {
            com.cyberlink.youcammakeup.kernelctrl.viewengine.m.a(g, l1);
            h.a(l1);
        }
        g(l1);
    }

    public ImageBufferWrapper c(long l1)
    {
        return a(l1, ((com.cyberlink.youcammakeup.jniproxy.q) (null)));
    }

    com.cyberlink.youcammakeup.kernelctrl.viewengine.m c()
    {
        return g;
    }

    public ImageBufferWrapper d(long l1)
    {
        Object obj = com.cyberlink.youcammakeup.c.f();
        if (((p) (obj)).d(l1) == null)
        {
            return null;
        }
        obj = ((p) (obj)).b(l1).b();
        DecodeOpCode decodeopcode = DecodeOpCode.a;
        Argd argd = new Argd();
        argd.put("srcPath", obj);
        argd.put("taskID", Long.valueOf(-99L));
        argd.put("imageID", Long.valueOf(l1));
        try
        {
            obj = a(decodeopcode, ((ImageBufferWrapper) (null)), argd, false, true);
        }
        catch (TaskMgrException taskmgrexception)
        {
            taskmgrexception.printStackTrace();
            taskmgrexception = null;
        }
        return ((ImageBufferWrapper) (obj));
    }

    public void finalize()
    {
        e.a();
        g.a();
        f.a();
    }

    private class TaskMgrException extends Exception
    {

        private static final long serialVersionUID = 0x52de69afd5ce02cbL;

        TaskMgrException(String s)
        {
            super(s);
        }

        TaskMgrException(String s, Throwable throwable)
        {
            super(s, throwable);
        }
    }


    private class Argd extends ConcurrentHashMap
    {

        private static final long serialVersionUID = 0x8eda185b9a918182L;

        long a(String s, long l1)
        {
            s = ((String) (get(s)));
            if (s == null)
            {
                return l1;
            } else
            {
                return ((Long)s).longValue();
            }
        }

        boolean a(String s)
        {
            return a(s, false);
        }

        boolean a(String s, boolean flag)
        {
            s = ((String) (get(s)));
            if (s == null)
            {
                return flag;
            } else
            {
                return ((Boolean)s).booleanValue();
            }
        }

        private Argd()
        {
        }

    }


    private class DecodeOpCode extends Enum
    {

        public static final DecodeOpCode a;
        public static final DecodeOpCode b;
        public static final DecodeOpCode c;
        public static final DecodeOpCode d;
        public static final DecodeOpCode e;
        private static final DecodeOpCode f[];

        public static DecodeOpCode valueOf(String s)
        {
            return (DecodeOpCode)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/viewengine/ViewEngine$DecodeOpCode, s);
        }

        public static DecodeOpCode[] values()
        {
            return (DecodeOpCode[])f.clone();
        }

        static 
        {
            a = new DecodeOpCode("DECODE_MASTER_FROM_FILE", 0);
            b = new DecodeOpCode("DECODE_MASTER_FROM_STREAM", 1);
            c = new DecodeOpCode("DECODE_THUMB_FROM_FILE", 2);
            d = new DecodeOpCode("DECODE_THUMB_FROM_STREAM", 3);
            e = new DecodeOpCode("STRETCH_DEFAULT", 4);
            f = (new DecodeOpCode[] {
                a, b, c, d, e
            });
        }

        private DecodeOpCode(String s, int i1)
        {
            super(s, i1);
        }
    }


    private class DecodePolicy extends Enum
    {

        public static final DecodePolicy a;
        public static final DecodePolicy b;
        public static final DecodePolicy c;
        private static final DecodePolicy d[];

        public static DecodePolicy valueOf(String s)
        {
            return (DecodePolicy)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/viewengine/ViewEngine$DecodePolicy, s);
        }

        public static DecodePolicy[] values()
        {
            return (DecodePolicy[])d.clone();
        }

        static 
        {
            a = new DecodePolicy("DECODE_POLICY_MASTER", 0);
            b = new DecodePolicy("DECODE_POLICY_THUMB", 1);
            c = new DecodePolicy("DECODE_POLICY_FAST_THUMB", 2);
            d = (new DecodePolicy[] {
                a, b, c
            });
        }

        private DecodePolicy(String s, int i1)
        {
            super(s, i1);
        }
    }


    private class ThumbnailRule extends Enum
    {

        public static final ThumbnailRule a;
        public static final ThumbnailRule b;
        public static final ThumbnailRule c;
        private static final ThumbnailRule d[];

        public static ThumbnailRule valueOf(String s)
        {
            return (ThumbnailRule)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/viewengine/ViewEngine$ThumbnailRule, s);
        }

        public static ThumbnailRule[] values()
        {
            return (ThumbnailRule[])d.clone();
        }

        static 
        {
            a = new ThumbnailRule("THUMBNAIL_RULE_DEFAULT", 0);
            b = new ThumbnailRule("THUMBNAIL_RULE_EXIF_ONLY", 1);
            c = new ThumbnailRule("THUMBNAIL_RULE_MASTER_ONLY", 2);
            d = (new ThumbnailRule[] {
                a, b, c
            });
        }

        private ThumbnailRule(String s, int i1)
        {
            super(s, i1);
        }
    }


    private class ImageType extends Enum
    {

        public static final ImageType a;
        public static final ImageType b;
        private static final ImageType c[];

        public static ImageType valueOf(String s)
        {
            return (ImageType)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/viewengine/ViewEngine$ImageType, s);
        }

        public static ImageType[] values()
        {
            return (ImageType[])c.clone();
        }

        static 
        {
            a = new ImageType("IMAGE_TYPE_MASTER", 0);
            b = new ImageType("IMAGE_TYPE_THUMB", 1);
            c = (new ImageType[] {
                a, b
            });
        }

        private ImageType(String s, int i1)
        {
            super(s, i1);
        }
    }


    private class TaskRole extends Enum
    {

        public static final TaskRole a;
        public static final TaskRole b;
        public static final TaskRole c;
        public static final TaskRole d;
        private static final TaskRole e[];

        public static TaskRole valueOf(String s)
        {
            return (TaskRole)Enum.valueOf(com/cyberlink/youcammakeup/kernelctrl/viewengine/ViewEngine$TaskRole, s);
        }

        public static TaskRole[] values()
        {
            return (TaskRole[])e.clone();
        }

        static 
        {
            a = new TaskRole("ROLE_DEFAULT", 0);
            b = new TaskRole("ROLE_SV_FASTBG", 1);
            c = new TaskRole("ROLE_SV_CACHEIMAGE", 2);
            d = new TaskRole("ROLE_SV_VIEWER", 3);
            e = (new TaskRole[] {
                a, b, c, d
            });
        }

        private TaskRole(String s, int i1)
        {
            super(s, i1);
        }
    }

}
