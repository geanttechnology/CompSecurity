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
//            PipStyleFragment

class a
    implements android.view.lobalLayoutListener
{

    final PipStyleFragment a;

    public void onGlobalLayout()
    {
        PipStyleFragment.b(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (PipStyleFragment.b(a) != null)
        {
            android.view.ms ms = PipStyleFragment.b(a).getLayoutParams();
            if (ms != null)
            {
                Log.v("height:", (new StringBuilder()).append("PipStyleFragment:").append(PipStyleFragment.c(a).getLayoutParams().height).append("").toString());
                ms.height = PipStyleFragment.c(a).getHeight() - pb.a(PipStyleFragment.d(a), 29F);
                ms.width = PipStyleFragment.c(a).getHeight() - pb.a(PipStyleFragment.d(a), 29F);
                PipStyleFragment.b(a).setLayoutParams(ms);
            }
        }
    }

    (PipStyleFragment pipstylefragment)
    {
        a = pipstylefragment;
        super();
    }
}
