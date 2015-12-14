// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.lib;

import android.view.ViewTreeObserver;
import android.widget.Button;
import com.pipcamera.application.PIPCameraApplication;
import pb;

// Referenced classes of package com.instamag.activity.lib:
//            InstaPhotoSelectorActivity

class a
    implements android.view.utListener
{

    final Button a;
    final InstaPhotoSelectorActivity b;

    public void onGlobalLayout()
    {
        a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (a != null)
        {
            android.view.utListener utlistener = a.getLayoutParams();
            if (utlistener != null)
            {
                utlistener. = pb.a(PIPCameraApplication.a, 44F);
                utlistener.a = pb.a(PIPCameraApplication.a, 60F);
                a.setLayoutParams(utlistener);
            }
        }
    }

    (InstaPhotoSelectorActivity instaphotoselectoractivity, Button button)
    {
        b = instaphotoselectoractivity;
        a = button;
        super();
    }
}
