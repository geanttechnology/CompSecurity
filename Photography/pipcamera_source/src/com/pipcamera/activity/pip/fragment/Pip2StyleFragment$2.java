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
//            Pip2StyleFragment

class a
    implements android.view.lobalLayoutListener
{

    final Pip2StyleFragment a;

    public void onGlobalLayout()
    {
        Pip2StyleFragment.a(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if (Pip2StyleFragment.a(a) != null)
        {
            android.view.ms ms = Pip2StyleFragment.a(a).getLayoutParams();
            if (ms != null)
            {
                Log.v("height:", (new StringBuilder()).append("Pip2StyleFragment:").append(Pip2StyleFragment.b(a).getLayoutParams().height).append("").toString());
                ms.height = Pip2StyleFragment.b(a).getHeight() - pb.a(Pip2StyleFragment.c(a), 14F);
                ms.width = Pip2StyleFragment.b(a).getHeight() - pb.a(Pip2StyleFragment.c(a), 14F);
                Pip2StyleFragment.a(a).setLayoutParams(ms);
            }
        }
    }

    (Pip2StyleFragment pip2stylefragment)
    {
        a = pip2stylefragment;
        super();
    }
}
