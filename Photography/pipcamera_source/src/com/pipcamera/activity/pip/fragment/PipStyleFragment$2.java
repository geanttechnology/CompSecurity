// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.view.View;
import com.pipcamera.application.PIPCameraApplication;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipStyleFragment

class a
    implements android.view.r
{

    final PipStyleFragment a;

    public void onClick(View view)
    {
        if (a.b)
        {
            a.b = false;
            a.a(false);
            if (PIPCameraApplication.a(a.getActivity()))
            {
                a.d();
                return;
            }
        }
    }

    (PipStyleFragment pipstylefragment)
    {
        a = pipstylefragment;
        super();
    }
}
