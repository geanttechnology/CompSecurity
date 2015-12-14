// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.d;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements android.view.
{

    final EditViewActivity a;

    public void onClick(View view)
    {
        if (EditViewActivity.G(a) == null)
        {
            return;
        }
        b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.ent.Operation.d, 0L, 0L, null, YMKFeatureRoomLookEvent.e(), null));
        b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.peration.k, false, false));
        ImageViewer imageviewer = (ImageViewer)a.findViewById(0x7f0c0720);
        if (imageviewer != null)
        {
            long l = StatusManager.j().l();
            if (StatusManager.j().z())
            {
                view = StatusManager.j().c(l);
            } else
            {
                view = StatusManager.j().g(l);
            }
            EditViewActivity.a(a, view.d());
            a.o(true);
            imageviewer.setFeaturePtVisibility(true);
        }
        com.cyberlink.youcammakeup.activity.EditViewActivity.d(a, false);
    }

    er(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}
