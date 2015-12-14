// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.graphics.Bitmap;
import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.youcammakeup.camera.CameraCtrl;
import com.cyberlink.youcammakeup.camera.y;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            o, i, k, p, 
//            n

public class h extends o
{

    public h(CameraCtrl cameractrl)
    {
        super(cameractrl);
    }

    public static i a(String s)
    {
        i j = new i();
        s = PanelDataCenter.a().a(s);
        j.a = new byte[s.size()][];
        j.b = 450;
        j.c = 300;
        for (int l = 0; l < s.size(); l++)
        {
            Bitmap bitmap = MotionControlHelper.i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)s.get(l)).b());
            if (bitmap == null)
            {
                continue;
            }
            bitmap = Bitmap.createScaledBitmap(bitmap, j.b, j.c, true);
            if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)s.get(l)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.c || ((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)s.get(l)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.e)
            {
                j.a[0] = new byte[bitmap.getWidth() * bitmap.getHeight()];
                j.a[0] = a(bitmap);
            }
            if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)s.get(l)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.d)
            {
                j.a[1] = new byte[bitmap.getWidth() * bitmap.getHeight()];
                j.a[1] = a(bitmap);
            }
            aa.a(bitmap);
        }

        return j;
    }

    public static byte[] a(Bitmap bitmap)
    {
        int j = 0;
        int l = bitmap.getWidth();
        int i1 = bitmap.getHeight();
        int ai[] = new int[l * i1];
        byte abyte0[] = new byte[l * i1];
        bitmap.getPixels(ai, 0, l, 0, 0, l, i1);
        for (; j < l * i1; j++)
        {
            abyte0[j] = (byte)(ai[j] >>> 24);
        }

        return abyte0;
    }

    protected int a()
    {
        return 0x7f030181;
    }

    protected BeautyMode b()
    {
        return BeautyMode.m;
    }

    protected void c()
    {
        BeautifierManager beautifiermanager;
        CLMakeupLiveFilter clmakeuplivefilter;
        Object obj = c.j();
        beautifiermanager = c.k().j();
        if (!(obj instanceof CLMakeupLiveFilter))
        {
            break MISSING_BLOCK_LABEL_253;
        }
        clmakeuplivefilter = (CLMakeupLiveFilter)obj;
        int j = b.a();
        obj = b.b(j);
        Object obj1 = p.a().c(b());
        if (obj1 != null && ((at) (obj1)).equals(obj))
        {
            obj = obj1;
        }
        int l = a.b();
        byte abyte0[][] = a.a(l);
        com.cyberlink.youcammakeup.widgetpool.panel.c.p p1 = p.a();
        BeautyMode beautymode = BeautyMode.m;
        byte abyte1[];
        if (abyte0 == null)
        {
            obj1 = null;
        } else
        {
            obj1 = ((p) (abyte0)).c;
        }
        p1.a(beautymode, ((String) (obj1)));
        p1.b(BeautyMode.m, b.a(j));
        p1.a(BeautyMode.m, ((at) (obj)));
        if (obj == null || abyte0 == null)
        {
            break MISSING_BLOCK_LABEL_268;
        }
        obj1 = a(((p) (abyte0)).c);
        abyte0 = ((i) (obj1)).a;
        j = abyte0.length;
        abyte1 = new byte[((i) (obj1)).b * ((i) (obj1)).c];
        l = ((at) (obj)).e();
        beautifiermanager;
        JVM INSTR monitorenter ;
        beautifiermanager.b(abyte1, abyte0, l, 75, j, ((i) (obj1)).b, ((i) (obj1)).c);
        beautifiermanager;
        JVM INSTR monitorexit ;
        clmakeuplivefilter.a(true, abyte1, l);
        clmakeuplivefilter.a(false, abyte1, l);
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.f, true);
        return;
        Exception exception;
        exception;
        beautifiermanager;
        JVM INSTR monitorexit ;
        throw exception;
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.f, false);
        return;
    }
}
