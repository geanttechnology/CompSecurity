// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.cyberlink.youcammakeup.activity.LibraryPickerActivity;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class a
    implements android.view.stener
{

    final CameraCtrl a;

    public void onClick(View view)
    {
        if (CameraCtrl.u(a) != null)
        {
            YMKFeatureRoomLookEvent.b(com.cyberlink.youcammakeup.clflurry.LookEvent.Source.b.a());
            StatusManager.j().b(CameraCtrl.V(a));
            StatusManager.j().a(CameraCtrl.W(a), CameraCtrl.a);
            view = new com.cyberlink.youcammakeup.activity.ctivity.State("editView");
            Intent intent = new Intent(CameraCtrl.u(a), com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
            intent.putExtra("LibraryPickerActivity_STATE", view);
            intent.putExtra("ShowZooView", true);
            intent.putExtra(CameraCtrl.u(a).getResources().getString(0x7f070729), com/cyberlink/youcammakeup/activity/CameraActivity);
            CameraCtrl.u(a).startActivity(intent);
            CameraCtrl.u(a).finish();
        }
    }

    ty(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
