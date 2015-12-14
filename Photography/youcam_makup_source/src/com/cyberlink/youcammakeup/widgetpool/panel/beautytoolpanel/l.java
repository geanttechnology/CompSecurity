// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.aw;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.utility.bo;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.common.a.j;
import java.util.Arrays;
import java.util.List;

public class l extends j
{

    private boolean n;

    public l()
    {
        n = false;
    }

    public void c(boolean flag)
    {
        n = flag;
    }

    public void d(BeautyMode beautymode)
    {
        System.nanoTime();
        if (g != null)
        {
            beautymode = h.b().a(g.b(), g.a());
            l = PanelDataCenter.a().k(beautymode.d());
        } else
        {
            aw aw1;
            if (n)
            {
                l = PanelDataCenter.a().a(beautymode, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a, 2);
                l.addAll(PanelDataCenter.a().a(beautymode, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b, 2));
                l.addAll(PanelDataCenter.a().a(beautymode, com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c, 2));
            } else
            {
                List list = Arrays.asList(new String[] {
                    com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.a.toString(), com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.b.toString(), com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.c.toString()
                });
                l = PanelDataCenter.a().a(list, beautymode);
            }
            e(beautymode);
            aw1 = PanelDataCenter.a().j(MotionControlHelper.e().J().c());
            if (aw1 != null && com.cyberlink.youcammakeup.utility.PanelDataCenter.SourceType.d.equals(aw1.g()) && h.b().m(aw1.k(), bo.a(beautymode)))
            {
                l.add(0, aw1);
                return;
            }
        }
    }

    public String f()
    {
        Object obj = StatusManager.j().e();
        if (obj == null)
        {
            return super.f();
        }
        obj = PanelDataCenter.a().p(((String) (obj)));
        if (obj == null)
        {
            return super.f();
        }
        if (((ax) (obj)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.b)
        {
            return "assets://makeup/lipstick/texture_lipstick_thick.png";
        }
        if (((ax) (obj)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.a)
        {
            return "assets://makeup/lipstick/texture_lipstick_bright.png";
        }
        if (((ax) (obj)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.c)
        {
            return "assets://makeup/lipstick/texture_lipstick_gloss.png";
        } else
        {
            return super.f();
        }
    }
}
