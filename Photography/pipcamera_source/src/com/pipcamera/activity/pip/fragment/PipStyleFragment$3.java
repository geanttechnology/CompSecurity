// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.view.ViewTreeObserver;
import android.widget.ListView;
import com.wantu.ResourceOnlineLibrary.Manage.OnlineGridViewAdapter;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipStyleFragment

class a
    implements android.view.GlobalLayoutListener
{

    final PipStyleFragment a;

    public void onGlobalLayout()
    {
        PipStyleFragment.h(a).getViewTreeObserver().removeGlobalOnLayoutListener(this);
        PipStyleFragment.b(a, PipStyleFragment.i(a));
        PipStyleFragment.a(a, new OnlineGridViewAdapter(a.getActivity(), PipStyleFragment.j(a), PipStyleFragment.h(a).getWidth(), PipStyleFragment.h(a).getHeight(), PipStyleFragment.k(a), PipStyleFragment.l(a)));
        PipStyleFragment.m(a).setItemListener(a);
        PipStyleFragment.h(a).setAdapter(PipStyleFragment.m(a));
        PipStyleFragment.h(a).setDividerHeight(PipStyleFragment.m(a).gapBetweenChildrenInRow());
    }

    apter(PipStyleFragment pipstylefragment)
    {
        a = pipstylefragment;
        super();
    }
}
