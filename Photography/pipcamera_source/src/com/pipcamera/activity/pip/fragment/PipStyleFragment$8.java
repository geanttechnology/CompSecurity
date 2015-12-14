// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import com.pipcamera.activity.pip.PipStyleActivity;
import com.wantu.ResourceOnlineLibrary.Manage.OnlineGridViewAdapter;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipStyleFragment

class a
    implements Runnable
{

    final PipStyleFragment a;

    public void run()
    {
        PipStyleFragment.d(a).n();
        if (PipStyleFragment.m(a) != null)
        {
            PipStyleFragment.m(a).notifyDataSetChanged();
        }
    }

    apter(PipStyleFragment pipstylefragment)
    {
        a = pipstylefragment;
        super();
    }
}
