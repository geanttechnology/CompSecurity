// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a
    implements android.view..OnLongClickListener
{

    final View a;
    final g b;

    public boolean onLongClick(View view)
    {
        a.setOnClickListener(null);
        b.b.a(g.a(b));
        return false;
    }

    Activity(g g1, View view)
    {
        b = g1;
        a = view;
        super();
    }
}
