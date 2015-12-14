// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.utility.ac;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a
    implements android.view.OnLongClickListener
{

    final ac a;
    final g b;

    public boolean onLongClick(View view)
    {
        view.setOnClickListener(null);
        g.a(b, a);
        b.b.a(g.a(b));
        return false;
    }

    ctivity(g g1, ac ac)
    {
        b = g1;
        a = ac;
        super();
    }
}
