// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.util.Log;
import android.view.ViewTreeObserver;
import android.widget.Button;
import com.wantu.view.TPipStyleListScrollView;
import pb;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a
    implements android.view.obalLayoutListener
{

    final PipCameraFragment a;

    public void onGlobalLayout()
    {
        PipCameraFragment.b(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (PipCameraFragment.b(a) != null)
        {
            android.view.s s = PipCameraFragment.b(a).getLayoutParams();
            if (s != null)
            {
                Log.v("height:", (new StringBuilder()).append("PipCameraFragment:").append(PipCameraFragment.c(a).getLayoutParams().height).append("").toString());
                s.height = PipCameraFragment.c(a).getHeight() - pb.a(PipCameraFragment.d(a), 29F);
                s.width = PipCameraFragment.c(a).getHeight() - pb.a(PipCameraFragment.d(a), 29F);
                PipCameraFragment.b(a).setLayoutParams(s);
            }
        }
    }

    (PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
