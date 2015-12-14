// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.database.more.i.d;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.sku.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.SkuTemplateUtils;
import com.cyberlink.youcammakeup.utility.at;
import com.cyberlink.youcammakeup.utility.ax;
import com.cyberlink.youcammakeup.utility.az;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            d, e, k, c

public class g extends com.cyberlink.youcammakeup.widgetpool.common.a.d
{

    private List j;
    private List k;
    private at l;

    public g()
    {
        j = null;
        k = null;
        l = null;
    }

    protected c a(BeautyMode beautymode)
    {
        Object obj;
        obj = StatusManager.j().e();
        if (g != null && beautymode != BeautyMode.n)
        {
            if (beautymode == BeautyMode.s && obj != null)
            {
                k = SkuTemplateUtils.b(((String) (obj)));
            } else
            {
                k = SkuTemplateUtils.a(h.b().a(g.b(), g.a()).d());
            }
        } else
        {
            j = PanelDataCenter.a().d(beautymode);
            at at1 = MotionControlHelper.e().J().e();
            if (at1 != null && at1.h() != null)
            {
                j.add(0, at1);
            }
        }
        if (obj != null)
        {
            obj = PanelDataCenter.a().p(((String) (obj)));
        } else
        {
            obj = null;
        }
        if (beautymode != BeautyMode.n) goto _L2; else goto _L1
_L1:
        beautymode = "assets://makeup/eyeshadow/texture_leyeshadow.png";
_L4:
        return new e(getActivity(), beautymode, j, k);
_L2:
        if (beautymode == BeautyMode.s)
        {
            beautymode = "assets://makeup/eyecontact/texture_eyecontact.png";
            continue; /* Loop/switch isn't completed */
        }
        if (beautymode == BeautyMode.v && obj != null)
        {
            if (((ax) (obj)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.b)
            {
                beautymode = "assets://makeup/lipstick/texture_lipstick_thick.png";
                continue; /* Loop/switch isn't completed */
            }
            if (((ax) (obj)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.a)
            {
                beautymode = "assets://makeup/lipstick/texture_lipstick_bright.png";
                continue; /* Loop/switch isn't completed */
            }
            if (((ax) (obj)).h().b() == com.cyberlink.youcammakeup.utility.PanelDataCenter.LipstickProfile.LipstickType.c)
            {
                beautymode = "assets://makeup/lipstick/texture_lipstick_gloss.png";
                continue; /* Loop/switch isn't completed */
            }
        } else
        if (beautymode == BeautyMode.x || beautymode == BeautyMode.k)
        {
            beautymode = "assets://makeup/wig/texture_hair_frame.png";
            continue; /* Loop/switch isn't completed */
        }
        beautymode = "assets://makeup/texture_color_general.png";
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a()
    {
        j = null;
        k = null;
        l = null;
        super.a();
    }

    public void a(View view, int i)
    {
_L2:
        return;
        if (j != null && i >= j.size() || k != null && i >= k.size()) goto _L2; else goto _L1
_L1:
        view = StatusManager.j().s();
        if (d == null)
        {
            break MISSING_BLOCK_LABEL_234;
        }
        if (e != i)
        {
            break; /* Loop/switch isn't completed */
        }
        d.W();
        if (view == BeautyMode.n)
        {
            d.a(Boolean.valueOf(false), Boolean.valueOf(false));
            if (d.findViewById(0x7f0c0854).getVisibility() == 0)
            {
                i = 4;
            } else
            {
                i = 0;
            }
            b(i);
            return;
        }
        if (view == BeautyMode.v || view == BeautyMode.r || view == BeautyMode.l || view == BeautyMode.s || view == BeautyMode.b || view == BeautyMode.a || view == BeautyMode.m || view == BeautyMode.y)
        {
            d.a(Boolean.valueOf(false), Boolean.valueOf(false));
            return;
        }
        if (view != BeautyMode.k && view != BeautyMode.x)
        {
            d.a(Boolean.valueOf(false), Boolean.valueOf(true));
            return;
        }
        if (true) goto _L2; else goto _L3
_L3:
        if (view == BeautyMode.n)
        {
            b(0);
        }
        d();
        if (b != null)
        {
            b.a(i, true);
        }
        view = null;
        if (j == null) goto _L5; else goto _L4
_L4:
        view = (at)j.get(i);
_L7:
        if (c != null)
        {
            c.a(view);
        }
        if (d != null)
        {
            d.a(Boolean.valueOf(false), Boolean.valueOf(false));
        }
        view = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        e = i;
        return;
_L5:
        if (k != null)
        {
            view = (at)k.get(i);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }

    public void a(at at1, boolean flag)
    {
        int i;
        int i1;
        i = 0;
        i1 = 0;
        if (flag)
        {
            l = at1;
        }
        if (j != null || k != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (j == null) goto _L4; else goto _L3
_L3:
        if (i1 >= j.size())
        {
            break MISSING_BLOCK_LABEL_173;
        }
        if (!(at1 instanceof com.cyberlink.youcammakeup.widgetpool.common.a.k) || !(j.get(i1) instanceof com.cyberlink.youcammakeup.widgetpool.common.a.k)) goto _L6; else goto _L5
_L5:
        i = i1;
_L8:
        if (i != -1)
        {
            a(i, flag);
            return;
        }
          goto _L1
_L6:
        i = i1;
        if (at1.equals(j.get(i1))) goto _L8; else goto _L7
_L7:
        i1++;
          goto _L3
_L4:
        if (k == null)
        {
            break MISSING_BLOCK_LABEL_173;
        }
        i1 = i;
_L10:
        if (i1 >= k.size())
        {
            break MISSING_BLOCK_LABEL_173;
        }
        i = i1;
        if (at1.equals(k.get(i1))) goto _L8; else goto _L9
_L9:
        i1++;
          goto _L10
        i = -1;
          goto _L8
    }

    protected void b(BeautyMode beautymode)
    {
        super.b(beautymode);
        if (l != null)
        {
            a(l, true);
        }
    }

    protected void c(BeautyMode beautymode)
    {
        b.setVisibility(8);
        if (beautymode == null || beautymode == BeautyMode.D)
        {
            return;
        }
        if (beautymode == BeautyMode.r || beautymode == BeautyMode.l || beautymode == BeautyMode.b || beautymode == BeautyMode.a || beautymode == BeautyMode.m || beautymode == BeautyMode.y)
        {
            a.setBackgroundColor(Color.parseColor("#FFE1E1E1"));
            return;
        }
        if (beautymode == BeautyMode.s || beautymode == BeautyMode.n || beautymode == BeautyMode.x || beautymode == BeautyMode.k || beautymode == BeautyMode.A || beautymode == BeautyMode.z || beautymode == BeautyMode.B || beautymode == BeautyMode.C)
        {
            a.setBackgroundColor(Color.parseColor("#00000000"));
            return;
        } else
        {
            a.setBackgroundColor(Color.parseColor("#F219171E"));
            return;
        }
    }
}
