// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.widget.SeekBar;
import com.wantu.piprender.PipFreeStyleImageGLSurfaceView;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipFreeStyleFragment

class a
    implements android.widget.Listener
{

    final PipFreeStyleFragment a;

    public void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
    }

    public void onStartTrackingTouch(SeekBar seekbar)
    {
    }

    public void onStopTrackingTouch(SeekBar seekbar)
    {
        int i = seekbar.getProgress() / 5;
        PipFreeStyleFragment.b(a).setBlurRadius(i);
    }

    (PipFreeStyleFragment pipfreestylefragment)
    {
        a = pipfreestylefragment;
        super();
    }
}
