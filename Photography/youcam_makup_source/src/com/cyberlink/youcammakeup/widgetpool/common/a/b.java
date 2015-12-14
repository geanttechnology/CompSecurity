// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.common.a;

import android.app.Activity;
import android.view.View;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.am;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.k;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.common.a:
//            d, a, c

public class b extends d
{

    private am j;
    private com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask k;

    public b()
    {
        j = null;
        k = null;
    }

    protected c a(BeautyMode beautymode)
    {
        beautymode = StatusManager.j().e();
        Activity activity = getActivity();
        j = PanelDataCenter.a().b(beautymode);
        return new a(activity, "assets://makeup/eyecontact/texture_eyecontact.png", j);
    }

    public void a()
    {
        k = null;
        super.a();
    }

    protected void a(View view, int i)
    {
        if (j == null || !j.a(i))
        {
            return;
        }
        if (d != null && e == i)
        {
            d.W();
            return;
        }
        d();
        if (b != null)
        {
            b.a(i, true);
        }
        view = StatusManager.j().e();
        com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask = j.b(i);
        MotionControlHelper.e().a(view, mask);
        if (c != null)
        {
            c.a(null);
        }
        if (d != null)
        {
            d.a(Boolean.valueOf(false), Boolean.valueOf(false));
        }
        view = (ImageViewer)getActivity().findViewById(0x7f0c0720);
        e = i;
    }

    public void a(com.cyberlink.youcammakeup.utility.PanelDataCenter.Mask mask, boolean flag)
    {
        if (flag)
        {
            k = mask;
        }
        if (j != null && mask != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int i = 0;
_L5:
        if (i >= j.a())
        {
            break MISSING_BLOCK_LABEL_74;
        }
        if (!j.b(i).b().equals(mask.b())) goto _L4; else goto _L3
_L3:
        if (i != -1)
        {
            a(i, flag);
            return;
        }
          goto _L1
_L4:
        i++;
          goto _L5
        i = -1;
          goto _L3
    }

    protected void b(BeautyMode beautymode)
    {
        super.b(beautymode);
        if (k != null)
        {
            a(k, true);
        }
    }
}
