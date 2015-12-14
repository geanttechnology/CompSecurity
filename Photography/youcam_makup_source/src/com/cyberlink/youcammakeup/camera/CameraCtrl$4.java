// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements android.view.istener
{

    final CameraCtrl a;

    public void onClick(View view)
    {
        CameraCtrl cameractrl = a;
        if (CameraCtrl.j(a) != nelDisplayStatus.a)
        {
            view = nelDisplayStatus.a;
        } else
        {
            view = nelDisplayStatus.b;
        }
        CameraCtrl.a(cameractrl, view);
    }

    nelDisplayStatus(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
