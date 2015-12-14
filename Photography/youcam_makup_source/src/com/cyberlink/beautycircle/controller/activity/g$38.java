// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.controller.a.am;
import com.cyberlink.beautycircle.controller.a.e;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a
    implements android.view.OnClickListener
{

    final g a;

    public void onClick(View view)
    {
        String s = PostActivity.a(a.b, g.a(a));
        if (s != null)
        {
            b.a(new e(s, 0L, "share", PostActivity.f(a.b), 0L));
        }
        b.a(new am(am.b, "share", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(a)), Long.valueOf(g.a(a).creator.userId), 0L));
        a.b.a(view, g.a(a));
    }

    ctivity(g g1)
    {
        a = g1;
        super();
    }
}
