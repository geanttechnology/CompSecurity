// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.activity.MoreActivity;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            TopToolBar

class a
    implements android.view.istener
{

    final TopToolBar a;

    public void onClick(View view)
    {
        if (!StatusManager.j().E().booleanValue())
        {
            return;
        } else
        {
            StatusManager.j().a(Boolean.valueOf(false));
            view = new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/MoreActivity);
            a.startActivity(view);
            return;
        }
    }

    (TopToolBar toptoolbar)
    {
        a = toptoolbar;
        super();
    }
}
