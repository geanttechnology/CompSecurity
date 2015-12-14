// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.r;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.PanelDataCenter;
import com.cyberlink.youcammakeup.utility.ar;
import com.cyberlink.youcammakeup.utility.aw;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            o, BeautyToolPanel, n, LipstickToolPanel

public class m extends o
{

    public m()
    {
    }

    protected void c(String s)
    {
        Object obj = null;
        StatusManager.j().c(s);
        s = StatusManager.j().d();
        BeautyToolPanel beautytoolpanel;
        if (s != null && s.h() != null)
        {
            StatusManager.j().d(s.h().d());
        } else
        {
            StatusManager.j().d(null);
        }
        beautytoolpanel = m;
        s = obj;
        if (f != null)
        {
            s = a.a();
        }
        beautytoolpanel.b(s);
        m.d(StatusManager.j().e());
        ((n)m).a(a);
        if (m != null && (m instanceof LipstickToolPanel))
        {
            ((LipstickToolPanel)m).b(a, f);
        }
    }

    protected void d(String s)
    {
        s = PanelDataCenter.a().r(s);
        StatusManager statusmanager = StatusManager.j();
        if (s != null)
        {
            s = s.a();
        } else
        {
            s = null;
        }
        statusmanager.d(s);
    }
}
