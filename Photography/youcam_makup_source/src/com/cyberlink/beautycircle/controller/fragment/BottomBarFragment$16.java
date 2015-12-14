// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.view.widgetpool.common.ObservableScrollView;
import com.cyberlink.beautycircle.view.widgetpool.common.n;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            BottomBarFragment

class a
    implements n
{

    final BottomBarFragment a;

    public void a(ObservableScrollView observablescrollview, int i)
    {
        if (i == 0)
        {
            BottomBarFragment.b(a, false);
        }
    }

    public void a(ObservableScrollView observablescrollview, int i, int j, int k, int l)
    {
        BottomBarFragment.a(a, l - j);
    }

    ew(BottomBarFragment bottombarfragment)
    {
        a = bottombarfragment;
        super();
    }
}
