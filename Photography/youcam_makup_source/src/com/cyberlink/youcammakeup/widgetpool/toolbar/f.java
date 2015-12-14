// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.view.ViewPropertyAnimator;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.ai;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.widgetpool.clhorizontalgridview.HorizontalGridView;
import com.cyberlink.youcammakeup.widgetpool.panel.lookspanel.LooksImageAdapter;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar

class f
    implements ai
{

    final MakeupLooksBottomToolbar a;
    private boolean b;

    f(MakeupLooksBottomToolbar makeuplooksbottomtoolbar, boolean flag)
    {
        a = makeuplooksbottomtoolbar;
        super();
        b = false;
        b = flag;
    }

    public void a()
    {
        if (!b) goto _L2; else goto _L1
_L1:
        if (DownloadUseUtils.a(a.getActivity()) != null)
        {
            MakeupLooksBottomToolbar.a(a, DownloadUseUtils.a(a.getActivity()));
        } else
        {
            i j = StatusManager.j().d();
            int k;
            if (j != null)
            {
                k = MakeupLooksBottomToolbar.a(a, j.v());
            } else
            {
                k = -1;
            }
            MakeupLooksBottomToolbar.b(a).g(k);
            MakeupLooksBottomToolbar.c(a).setAlpha(0.0F);
            Globals.d(new Runnable() {

                final f a;

                public void run()
                {
                    MakeupLooksBottomToolbar.c(a.a).setSelection(0);
                    MakeupLooksBottomToolbar.c(a.a).animate().alpha(1.0F);
                }

            
            {
                a = f.this;
                super();
            }
            });
        }
        MakeupLooksBottomToolbar.f(a, true);
_L4:
        a.c(false);
        if (a.getActivity() instanceof BaseActivity)
        {
            ((BaseActivity)a.getActivity()).i();
        }
        if (MakeupLooksBottomToolbar.t(a) != null)
        {
            StatusManager.j().b(MakeupLooksBottomToolbar.t(a));
            MakeupLooksBottomToolbar.a(a, null);
        }
        return;
_L2:
        if (MakeupLooksBottomToolbar.r(a) == null)
        {
            break; /* Loop/switch isn't completed */
        }
        int l = MakeupLooksBottomToolbar.a(a, MakeupLooksBottomToolbar.r(a));
        if (a.m() || a.n())
        {
            if (!a.n())
            {
                MakeupLooksBottomToolbar.b(a).g(l);
                MakeupLooksBottomToolbar.c(a).a(l, true);
            }
            a.a("Apply", Boolean.valueOf(true));
            StatusManager.j().d().a(MakeupLooksBottomToolbar.r(a));
            MakeupLooksBottomToolbar.a(a, MakeupLooksBottomToolbar.b(a, MakeupLooksBottomToolbar.r(a)));
            a.a(MakeupLooksBottomToolbar.n(a));
            a.c(false);
            a.b(false);
        }
_L5:
        MakeupLooksBottomToolbar.g(a, false);
        if (true) goto _L4; else goto _L3
_L3:
        if (DownloadUseUtils.a(a.getActivity()) != null)
        {
            MakeupLooksBottomToolbar.a(a, DownloadUseUtils.a(a.getActivity()));
        } else
        if (!MakeupLooksBottomToolbar.s(a));
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }
}
