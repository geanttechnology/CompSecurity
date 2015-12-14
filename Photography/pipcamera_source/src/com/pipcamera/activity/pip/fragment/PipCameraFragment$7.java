// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import com.pipcamera.activity.pip.PipRealTimeCameraActivity;
import com.wantu.ResourceOnlineLibrary.Manage.OnlineGridViewAdapter;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a
    implements Runnable
{

    final PipCameraFragment a;

    public void run()
    {
        PipCameraFragment.d(a).n();
        if (PipCameraFragment.l(a) != null)
        {
            PipCameraFragment.l(a).notifyDataSetChanged();
        }
    }

    pter(PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
