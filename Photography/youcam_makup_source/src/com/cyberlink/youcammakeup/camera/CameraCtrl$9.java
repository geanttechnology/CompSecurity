// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.content.DialogInterface;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements android.content.ce.OnDismissListener
{

    final CameraCtrl a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        CameraCtrl.t(a).setSelected(false);
        CameraCtrl.a(false);
        CameraCtrl.a(a, true);
    }

    er(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
