// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.view.View;
import android.widget.Button;
import com.pipcamera.activity.pip.view.PaintView;
import com.wantu.piprender.PipFreeStyleImageGLSurfaceView;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipFreeStyleFragment

class a
    implements android.view.PipFreeStyleFragment._cls5
{

    final PipFreeStyleFragment a;

    public void onClick(View view)
    {
        PipFreeStyleFragment.a(a).setEnabled(false);
        PipFreeStyleFragment.b(a).setBlurRadius(0.0F);
        PipFreeStyleFragment.b(a).setMaskImage(null);
        PipFreeStyleFragment.c(a).clear();
        PipFreeStyleFragment.c(a).setVisibility(0);
        PipFreeStyleFragment.d(a);
        PipFreeStyleFragment.a(a).setVisibility(0);
        PipFreeStyleFragment.e(a).setVisibility(4);
        PipFreeStyleFragment.f(a).setVisibility(4);
        PipFreeStyleFragment.g(a).setVisibility(4);
        PipFreeStyleFragment.h(a);
    }

    (PipFreeStyleFragment pipfreestylefragment)
    {
        a = pipfreestylefragment;
        super();
    }
}
