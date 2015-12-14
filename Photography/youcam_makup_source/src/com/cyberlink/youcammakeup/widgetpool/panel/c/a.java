// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.c;

import android.graphics.Bitmap;
import com.cyberlink.clgpuimage.CLMakeupLiveFilter;
import com.cyberlink.youcammakeup.camera.CameraCtrl;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.p;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.c:
//            o, k, p, n

public class a extends o
{

    public a(CameraCtrl cameractrl)
    {
        super(cameractrl);
    }

    public static Bitmap[] a(String s)
    {
        Bitmap abitmap[] = new Bitmap[2];
        s = PanelDataCenter.a().a(s);
        for (int i = 0; i < s.size(); i++)
        {
            Bitmap bitmap = MotionControlHelper.i(((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)s.get(i)).b());
            if (bitmap == null)
            {
                continue;
            }
            if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)s.get(i)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.a)
            {
                abitmap[0] = bitmap;
            }
            if (((com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask)s.get(i)).f() == com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask.Position.b)
            {
                abitmap[1] = bitmap;
            }
        }

        return abitmap;
    }

    protected int a()
    {
        return 0x7f03017e;
    }

    protected BeautyMode b()
    {
        return BeautyMode.a;
    }

    protected void c()
    {
        CLMakeupLiveFilter clmakeuplivefilter;
label0:
        {
            Object obj = c.j();
            if (obj instanceof CLMakeupLiveFilter)
            {
                clmakeuplivefilter = (CLMakeupLiveFilter)obj;
                int i = b.a();
                obj = b.b(i);
                Object obj1 = p.a().c(b());
                if (obj1 != null && ((at) (obj1)).equals(obj))
                {
                    obj = obj1;
                }
                int j = a.b();
                p p1 = a.a(j);
                com.cyberlink.youcammakeup.widgetpool.panel.c.p p2 = p.a();
                BeautyMode beautymode = BeautyMode.a;
                if (p1 == null)
                {
                    obj1 = null;
                } else
                {
                    obj1 = p1.c;
                }
                p2.a(beautymode, ((String) (obj1)));
                p2.b(BeautyMode.a, b.a(i));
                p2.a(BeautyMode.a, ((at) (obj)));
                if (obj == null || p1 == null)
                {
                    break label0;
                }
                obj1 = a(p1.c);
                i = ((at) (obj)).e();
                clmakeuplivefilter.a(((Bitmap []) (obj1)));
                clmakeuplivefilter.a(25);
                clmakeuplivefilter.b(i);
                clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.e, true);
            }
            return;
        }
        clmakeuplivefilter.a(com.cyberlink.clgpuimage.CLMakeupLiveFilter.MakeupLiveFeatures.e, false);
    }
}
