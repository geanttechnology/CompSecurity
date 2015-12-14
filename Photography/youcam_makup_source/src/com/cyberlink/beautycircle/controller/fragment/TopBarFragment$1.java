// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            TopBarFragment

class a
    implements android.view.ner
{

    final TopBarFragment a;

    public void onClick(View view)
    {
        long l = System.currentTimeMillis();
        if (l - TopBarFragment.a(a) > TopBarFragment.c())
        {
            TopBarFragment.a(a, 1);
        } else
        {
            TopBarFragment.b(a);
        }
        TopBarFragment.a(a, l);
        if (TopBarFragment.c(a) >= TopBarFragment.d())
        {
            TopBarFragment.a(a, 0);
            TopBarFragment.d(a);
        }
    }

    (TopBarFragment topbarfragment)
    {
        a = topbarfragment;
        super();
    }
}
