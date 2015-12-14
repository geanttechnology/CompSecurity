// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.model.network.NetworkPost;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g

class c
    implements Runnable
{

    final String a;
    final long b;
    final View c;
    final g d;

    public void run()
    {
        NetworkPost.b(a, Long.valueOf(b));
        g.a(d, c);
    }

    (g g1, String s, long l, View view)
    {
        d = g1;
        a = s;
        b = l;
        c = view;
        super();
    }
}
