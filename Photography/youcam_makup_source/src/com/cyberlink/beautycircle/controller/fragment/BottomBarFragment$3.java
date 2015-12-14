// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            BottomBarFragment, a

class a
    implements android.view.
{

    final BottomBarFragment a;

    public void onClick(View view)
    {
        BottomBarFragment.b = 0;
        if (BottomBarFragment.d(a) != null && BottomBarFragment.d(a).a(b.b))
        {
            BottomBarFragment.a(a, view);
        }
    }

    b(BottomBarFragment bottombarfragment)
    {
        a = bottombarfragment;
        super();
    }
}
