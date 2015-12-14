// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.youcammakeup.camera.CameraCtrl;
import com.cyberlink.youcammakeup.camera.y;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            o, k, p, n

public class j extends o
{

    public j(CameraCtrl cameractrl)
    {
        super(cameractrl);
    }

    protected int a()
    {
        return 0x7f030182;
    }

    protected BeautyMode b()
    {
        return BeautyMode.v;
    }

    protected void c()
    {
        BeautifierManager beautifiermanager;
        CLMakeupLiveFilter clmakeuplivefilter;
        Object obj = c.j();
        beautifiermanager = c.k().j();
        if (!(obj instanceof CLMakeupLiveFilter))
        {
            break MISSING_BLOCK_LABEL_240;
        }
        clmakeuplivefilter = (CLMakeupLiveFilter)obj;
        int i = b.a();
        obj = b.b(i);
        Object obj1 = p.a().c(b());
        if (obj1 != null && ((at) (obj1)).equals(obj))
        {
            obj = obj1;
        }
        int l = a.b();
        p p1 = a.a(l);
        com.cyberlink.youcammakeup.widgetpool.panel.c.p p2 = p.a();
        BeautyMode beautymode = BeautyMode.v;
        int i1;
        int j1;
        int k1;
        if (p1 == null)
        {
            obj1 = null;
        } else
        {
            obj1 = p1.c;
        }
        p2.a(beautymode, ((String) (obj1)));
        p2.b(BeautyMode.v, b.a(i));
        p2.a(BeautyMode.v, ((at) (obj)));
        if (obj == null || p1 == null)
        {
            break MISSING_BLOCK_LABEL_262;
        }
        i1 = ((at) (obj)).f();
        j1 = ((at) (obj)).g();
        k1 = ((at) (obj)).e();
        if (((at) (obj)).d() > 0)
        {
            i = ((at) (obj)).d();
        } else
        {
            i = 50;
        }
        clmakeuplivefilter.a(k1);
        obj = new com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter.LipStickProfile(com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter.BlendMode.values()[l], k1, i1, j1);
        beautifiermanager;
        JVM INSTR monitorenter ;
        beautifiermanager.a(((com.cyberlink.clgpuimage.CLMakeupLiveLipStickFilter.LipStickProfile) (obj)));
        beautifiermanager.a(i);
        beautifiermanager;
        JVM INSTR monitorexit ;
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.c, true);
        return;
        Exception exception;
        exception;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw exception;
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.c, false);
        return;
    }

    protected int d()
    {
        if (p.a().c(b()) != null || b.a() != 0) goto _L2; else goto _L1
_L1:
        int l = -1;
_L6:
        return l;
_L2:
        String s;
        int i;
        String s1 = p.a().a(b());
        s = s1;
        if (s1 == null)
        {
            s = "patten_lipstick_02";
        }
        i = 0;
_L7:
        if (i >= a.getCount()) goto _L4; else goto _L3
_L3:
        if (a.a(i) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = i;
        if (a.a(i).c.equals(s)) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        return super.d();
    }

    protected int e()
    {
        at at1 = p.a().c(b());
        if (at1 != null) goto _L2; else goto _L1
_L1:
        int l = super.e();
_L6:
        return l;
_L2:
        int i = 0;
_L7:
        if (i >= b.getCount()) goto _L4; else goto _L3
_L3:
        if (b.b(i) == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        l = i;
        if (b.b(i).equals(at1)) goto _L6; else goto _L5
_L5:
        i++;
          goto _L7
_L4:
        return super.e();
    }
}
