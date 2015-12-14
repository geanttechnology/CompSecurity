// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.DialogInterface;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements android.content.smissListener
{

    final EditViewActivity a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        StatusManager.j().a(Boolean.valueOf(true));
    }

    er(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}
