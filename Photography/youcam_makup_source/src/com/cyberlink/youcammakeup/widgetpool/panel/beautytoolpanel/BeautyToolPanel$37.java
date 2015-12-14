// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.view.View;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel, k

class a
    implements android.view.r
{

    final BeautyToolPanel a;

    public void onClick(View view)
    {
        if (a.b == null)
        {
            return;
        } else
        {
            a.k(false);
            a.b.H();
            view = StatusManager.j().g();
            a.c.a(view);
            return;
        }
    }

    (BeautyToolPanel beautytoolpanel)
    {
        a = beautytoolpanel;
        super();
    }
}
