// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.cyberlink.youcammakeup.database.more.makeup.MakeupItemMetadata;
import com.cyberlink.youcammakeup.database.more.makeup.e;
import com.cyberlink.youcammakeup.h;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.DownloadUseUtils;
import com.cyberlink.youcammakeup.utility.MakeupMode;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            WeekStarActivity, CameraActivity, LibraryPickerActivity

class a
    implements android.view.r
{

    final String a;
    final WeekStarActivity b;

    public void onClick(View view)
    {
        MakeupItemMetadata makeupitemmetadata = h.v().a(a);
        MakeupMode makeupmode = MakeupMode.a;
        BeautyMode beautymode = BeautyMode.D;
        view = (new Intent()).setFlags(0x4000000);
        DownloadUseUtils.a(false);
        view.putExtra("EXTRA_KEY_DOWNLOADED_TEMPLATE", new com.cyberlink.youcammakeup.utility.eTemplate(makeupitemmetadata.a(), makeupitemmetadata.b(), makeupmode, beautymode));
        if (makeupitemmetadata.x())
        {
            view.setClass(b, com/cyberlink/youcammakeup/activity/CameraActivity);
        } else
        {
            ty.State state = new ty.State("editView");
            view.setClass(b, com/cyberlink/youcammakeup/activity/LibraryPickerActivity);
            view.putExtra("LibraryPickerActivity_STATE", state);
        }
        DownloadUseUtils.a(b.getIntent(), view);
        if (view.getComponent().getClassName().equals(com/cyberlink/youcammakeup/activity/LibraryPickerActivity.getName()))
        {
            StatusManager.j().b(-1L);
            StatusManager.j().a(-1L, null);
            b.startActivity(view);
            return;
        }
        if (view.getComponent().getClassName().equals(com/cyberlink/youcammakeup/activity/CameraActivity.getName()))
        {
            view.putExtra(b.getResources().getString(0x7f070729), com/cyberlink/youcammakeup/activity/WeekStarActivity);
            b.startActivity(view);
            return;
        } else
        {
            b.startActivity(view);
            b.finish();
            return;
        }
    }

    ty.State(WeekStarActivity weekstaractivity, String s)
    {
        b = weekstaractivity;
        a = s;
        super();
    }
}
