// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity, g

class a
    implements android.view.
{

    final EditViewActivity a;

    public void onClick(View view)
    {
        while (!StatusManager.j().E().booleanValue() || EditViewActivity.E(a) == null || !EditViewActivity.E(a).c(view)) 
        {
            return;
        }
    }

    er(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}
