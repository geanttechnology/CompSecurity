// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.util.Log;
import android.widget.AbsListView;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipStyleFragment

class a
    implements android.widget.lListener
{

    final PipStyleFragment a;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (i == 0)
        {
            PipStyleFragment.a(a, true);
            Log.i("log", "\u6ED1\u5230\u9876\u90E8");
            return;
        } else
        {
            PipStyleFragment.a(a, false);
            return;
        }
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    (PipStyleFragment pipstylefragment)
    {
        a = pipstylefragment;
        super();
    }
}
