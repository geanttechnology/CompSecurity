// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.view.ViewTreeObserver;
import android.widget.ListView;
import com.wantu.ResourceOnlineLibrary.Manage.OnlineGridViewAdapter;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipCameraFragment

class a
    implements android.view.lobalLayoutListener
{

    final PipCameraFragment a;

    public void onGlobalLayout()
    {
        PipCameraFragment.g(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        PipCameraFragment.b(a, PipCameraFragment.h(a));
        PipCameraFragment.a(a, new OnlineGridViewAdapter(a.getActivity(), PipCameraFragment.i(a), PipCameraFragment.g(a).getWidth(), PipCameraFragment.g(a).getHeight(), PipCameraFragment.j(a), PipCameraFragment.k(a)));
        PipCameraFragment.l(a).setItemListener(a);
        PipCameraFragment.g(a).setAdapter(PipCameraFragment.l(a));
        PipCameraFragment.g(a).setDividerHeight(PipCameraFragment.l(a).gapBetweenChildrenInRow());
    }

    pter(PipCameraFragment pipcamerafragment)
    {
        a = pipcamerafragment;
        super();
    }
}
