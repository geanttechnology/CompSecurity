// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.view.View;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a
    implements Runnable
{

    final PipCameraFragment a;

    public void run()
    {
        PipCameraFragment.t(a).setVisibility(0);
    }

    (PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
