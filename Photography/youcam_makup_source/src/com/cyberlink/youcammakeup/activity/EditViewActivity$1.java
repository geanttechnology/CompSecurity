// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.IntroDialogUtils;
import com.cyberlink.youcammakeup.utility.ac;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements ac
{

    final EditViewActivity a;

    public void a(com.cyberlink.youcammakeup.utility.troDialogType trodialogtype)
    {
        if (IntroDialogUtils.a(StatusManager.j().r(), StatusManager.j().s()) == trodialogtype && EditViewActivity.a(a) != -1)
        {
            EditViewActivity.b(a).setVisibility(EditViewActivity.a(a));
            EditViewActivity.a(a, EditViewActivity.a(a));
        }
    }

    roDialogType(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}
