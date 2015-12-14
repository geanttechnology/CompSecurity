// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.view.View;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipFreeStyleFragment

class a
    implements android.view.PipFreeStyleFragment._cls9
{

    final PipFreeStyleFragment a;

    public void onClick(View view)
    {
        view = PipFreeStyleFragment.f(a);
        byte byte0;
        if (PipFreeStyleFragment.f(a).getVisibility() == 0)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        view.setVisibility(byte0);
    }

    (PipFreeStyleFragment pipfreestylefragment)
    {
        a = pipfreestylefragment;
        super();
    }
}
