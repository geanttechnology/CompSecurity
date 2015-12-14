// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.CameraActivity;
import com.cyberlink.youcammakeup.clflurry.YMKLiveCamEvent;
import com.cyberlink.youcammakeup.clflurry.YMKResultPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.flurry.PhotoSavePageClickEvent;
import com.cyberlink.youcammakeup.flurry.a;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            ag, o

class a
    implements android.view.OnClickListener
{

    final ag a;

    public void onClick(View view)
    {
        if (!com.cyberlink.youcammakeup.camera.ag.a(a))
        {
            return;
        }
        com.cyberlink.youcammakeup.camera.ag.a(a, false);
        com.cyberlink.youcammakeup.flurry.a.a(new PhotoSavePageClickEvent(com.cyberlink.youcammakeup.flurry.SavePageClickEvent.ButtonName.c));
        b.a(new YMKResultPageEvent(com.cyberlink.youcammakeup.clflurry.sultPageEvent.Operation.d, YMKResultPageEvent.b, System.currentTimeMillis()));
        YMKLiveCamEvent.b(com.cyberlink.youcammakeup.clflurry.veCamEvent.Source.b.a());
        com.cyberlink.youcammakeup.camera.ag.b(a);
        if (!com.cyberlink.youcammakeup.camera.o.a())
        {
            Toast.makeText(a.getActivity(), 0x7f070062, 0).show();
            return;
        } else
        {
            Globals.d().a(false);
            view = new Intent(a.getActivity().getApplicationContext(), com/cyberlink/youcammakeup/activity/CameraActivity);
            a.startActivity(view);
            a.getActivity().finish();
            com.cyberlink.youcammakeup.camera.ag.a(a, true);
            return;
        }
    }

    eraActivity(ag ag1)
    {
        a = ag1;
        super();
    }
}
