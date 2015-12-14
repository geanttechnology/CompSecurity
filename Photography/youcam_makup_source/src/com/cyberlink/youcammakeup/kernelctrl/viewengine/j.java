// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.kernelctrl.viewengine;

import com.cyberlink.youcammakeup.database.c;
import com.cyberlink.youcammakeup.database.d;
import com.cyberlink.youcammakeup.jniproxy.UIImageOrientation;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.DevelopSetting;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.e;
import java.util.HashMap;

// Referenced classes of package com.cyberlink.youcammakeup.kernelctrl.viewengine:
//            n, f, i, ViewEngine, 
//            q, m

class j extends n
{

    j()
    {
    }

    public q a()
    {
        double d1;
        Object obj;
        ViewEngine viewengine;
        long l;
        viewengine = com.cyberlink.youcammakeup.kernelctrl.viewengine.f.d(f);
        l = ((Long)d.get("imageID")).longValue();
        d1 = ((Double)d.get("scaleRatio")).doubleValue();
        ViewEngine.Argd argd = (ViewEngine.Argd)d.get("argd");
        obj = argd;
        if (argd == null)
        {
            obj = new ViewEngine.Argd(null);
        }
        ((ViewEngine.Argd) (obj)).put("imageID", Long.valueOf(l));
        boolean flag1 = ((ViewEngine.Argd) (obj)).a("bIgnoreCacheForFastBg");
        if (c == ViewEngine.TaskRole.b && !flag1 && !i.a(l))
        {
            Object obj1 = ViewEngine.a(viewengine).a(l, d.b);
            if (obj1 != null)
            {
                obj1 = ViewEngine.a(viewengine, ((com.cyberlink.youcammakeup.database.e) (obj1)), null);
                if (obj1 != null)
                {
                    return new q(l, ((ImageBufferWrapper) (obj1)));
                }
            }
            obj1 = ViewEngine.a(viewengine).a(l, d.a);
            if (obj1 != null)
            {
                obj1 = ViewEngine.a(viewengine, ((com.cyberlink.youcammakeup.database.e) (obj1)), null);
                if (obj1 != null)
                {
                    return new q(l, ((ImageBufferWrapper) (obj1)));
                }
            }
        }
        if (c == ViewEngine.TaskRole.b)
        {
            ImageBufferWrapper imagebufferwrapper;
            boolean flag;
            boolean flag2;
            if (ViewEngine.b(viewengine).a(l, 1.0D, ViewEngine.ImageType.a) != null)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                try
                {
                    ((ViewEngine.Argd) (obj)).put("policy", ViewEngine.DecodePolicy.b);
                    ((ViewEngine.Argd) (obj)).put("noCache", Boolean.valueOf(true));
                }
                catch (ViewEngine.TaskMgrException taskmgrexception)
                {
                    throw taskmgrexception;
                }
            }
        }
        if (d1 >= 1.0D)
        {
            break MISSING_BLOCK_LABEL_283;
        }
        ((ViewEngine.Argd) (obj)).put("noCache", Boolean.valueOf(true));
        imagebufferwrapper = ViewEngine.a(viewengine, l, d1, ((ViewEngine.Argd) (obj)));
        flag2 = ((ViewEngine.Argd) (obj)).a("bNotGenerateCache");
        if (c != com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.c && (c != com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine.TaskRole.d || ((ViewEngine.Argd) (obj)).get("ROI") != null) || flag2)
        {
            break MISSING_BLOCK_LABEL_405;
        }
        if (!i.a(l) && ViewEngine.a(viewengine).a(l, d.b) == null && ((DevelopSetting)d.get("developSetting")).a(e.a().a(Long.valueOf(l), Boolean.valueOf(true))))
        {
            viewengine.a(l, imagebufferwrapper, UIImageOrientation.b);
        }
        obj = new q(l, imagebufferwrapper);
        return ((q) (obj));
    }
}
