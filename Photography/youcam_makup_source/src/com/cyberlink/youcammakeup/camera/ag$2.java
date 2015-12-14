// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.LauncherActivity;
import com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent;
import com.cyberlink.youcammakeup.flurry.a;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            ag

class a
    implements android.view.OnClickListener
{

    final ag a;

    public void onClick(View view)
    {
        if (!com.cyberlink.youcammakeup.camera.ag.a(a))
        {
            return;
        } else
        {
            com.cyberlink.youcammakeup.camera.ag.a(a, false);
            com.cyberlink.youcammakeup.flurry.a.a(new PhotoSavePageClickEvent(com.cyberlink.youcammakeup.flurry.SavePageClickEvent.ButtonName.b));
            b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.sultPageEvent.Operation.b, YMKResultPageEvent.b, System.currentTimeMillis()));
            com.cyberlink.youcammakeup.camera.ag.b(a);
            view = (new Intent(a.getActivity(), com/cyberlink/youcammakeup/activity/LauncherActivity)).setFlags(0x4000000);
            a.getActivity().startActivity(view);
            Globals.d().H();
            com.cyberlink.youcammakeup.camera.ag.a(a, true);
            return;
        }
    }

    ncherActivity(ag ag1)
    {
        a = ag1;
        super();
    }
}
