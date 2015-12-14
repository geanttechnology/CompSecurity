// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.graphics.Bitmap;
import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.CameraCtrl;
import com.cyberlink.youcammakeup.camera.y;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p;
import com.pf.common.utility.m;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            o, c, k, p, 
//            n

public class b extends o
{

    public b(CameraCtrl cameractrl)
    {
        super(cameractrl);
    }

    public static c a(String s)
    {
        c c1;
        c1 = new c();
        s = PanelDataCenter.a().a(s);
        c1.a = new byte[Math.min(s.size(), 2)][];
        c1.b = 450;
        c1.c = 300;
        s = s.iterator();
_L8:
        if (!s.hasNext()) goto _L2; else goto _L1
_L1:
        com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask;
        Bitmap bitmap;
        Bitmap bitmap1;
        mask = (com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)s.next();
        bitmap = MotionControlHelper.i(mask.b());
        if (bitmap == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        bitmap1 = Bitmap.createScaledBitmap(bitmap, c1.b, c1.c, true);
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.values().length];
                try
                {
                    a[com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.e.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1.a[mask.f().ordinal()];
        JVM INSTR tableswitch 1 3: default 136
    //                   1 147
    //                   2 147
    //                   3 176;
           goto _L3 _L4 _L4 _L5
_L3:
        m.e("EyeLinerEffectPanel", "");
        continue; /* Loop/switch isn't completed */
_L4:
        int i = 0;
_L6:
        c1.a[i] = a(bitmap1);
        if (bitmap1 != bitmap)
        {
            aa.a(bitmap1);
        }
        continue; /* Loop/switch isn't completed */
_L5:
        i = 1;
        if (true) goto _L6; else goto _L2
_L2:
        c1.a();
        return c1;
        if (true) goto _L8; else goto _L7
_L7:
    }

    public static byte[] a(Bitmap bitmap)
    {
        int i = 0;
        int j = bitmap.getWidth();
        int l = bitmap.getHeight();
        int ai[] = new int[j * l];
        byte abyte0[] = new byte[j * l];
        bitmap.getPixels(ai, 0, j, 0, 0, j, l);
        for (; i < j * l; i++)
        {
            abyte0[i] = (byte)(ai[i] >>> 24);
        }

        return abyte0;
    }

    protected int a()
    {
        return 0x7f03017f;
    }

    protected BeautyMode b()
    {
        return BeautyMode.l;
    }

    protected void c()
    {
        BeautifierManager beautifiermanager;
        CLMakeupLiveFilter clmakeuplivefilter;
        Object obj = c.j();
        beautifiermanager = c.k().j();
        if (!(obj instanceof CLMakeupLiveFilter))
        {
            break MISSING_BLOCK_LABEL_285;
        }
        clmakeuplivefilter = (CLMakeupLiveFilter)obj;
        int i = b.a();
        obj = b.b(i);
        Object obj1 = p.a().c(b());
        if (obj1 != null && ((at) (obj1)).equals(obj))
        {
            obj = obj1;
        }
        int j = a.b();
        byte abyte0[][] = a.a(j);
        com.cyberlink.youcammakeup.widgetpool.panel.c.p p1 = p.a();
        BeautyMode beautymode = BeautyMode.l;
        byte abyte1[];
        if (abyte0 == null)
        {
            obj1 = null;
        } else
        {
            obj1 = ((p) (abyte0)).c;
        }
        p1.a(beautymode, ((String) (obj1)));
        p1.b(BeautyMode.l, b.a(i));
        p1.a(BeautyMode.l, ((at) (obj)));
        if (abyte0 == null || obj == null)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        Globals.d().e((new StringBuilder()).append("LiveMakeup EyeLinerEffectPanel eyeline patternID = ").append(String.valueOf(((p) (abyte0)).c)).toString());
        obj1 = a(((p) (abyte0)).c);
        abyte0 = ((c) (obj1)).a;
        i = abyte0.length;
        abyte1 = new byte[((c) (obj1)).b * ((c) (obj1)).c];
        j = ((at) (obj)).e();
        beautifiermanager;
        JVM INSTR monitorenter ;
        beautifiermanager.a(abyte1, abyte0, j, 50, i, ((c) (obj1)).b, ((c) (obj1)).c);
        beautifiermanager;
        JVM INSTR monitorexit ;
        clmakeuplivefilter.b(true, abyte1, j);
        clmakeuplivefilter.b(false, abyte1, j);
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.a, true);
        return;
        Exception exception;
        exception;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw exception;
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.a, false);
        return;
    }
}
