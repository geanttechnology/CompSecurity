// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g

class a
    implements Runnable
{

    final boolean a;
    final g b;

    public void run()
    {
        View view = b.o;
        int i;
        if (a)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        view.setVisibility(i);
    }

    (g g1, boolean flag)
    {
        b = g1;
        a = flag;
        super();
    }
}
