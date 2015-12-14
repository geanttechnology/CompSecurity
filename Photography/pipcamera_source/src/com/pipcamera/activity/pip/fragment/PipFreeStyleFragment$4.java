// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pipcamera.activity.pip.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;

// Referenced classes of package com.pipcamera.activity.pip.fragment:
//            PipFreeStyleFragment

class a
    implements android.view.PipFreeStyleFragment._cls4
{

    final PipFreeStyleFragment a;

    public void onClick(View view)
    {
        a.getActivity().openContextMenu(view);
    }

    (PipFreeStyleFragment pipfreestylefragment)
    {
        a = pipfreestylefragment;
        super();
    }
}
