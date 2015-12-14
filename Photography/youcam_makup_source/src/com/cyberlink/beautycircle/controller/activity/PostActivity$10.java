// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.controller.a.am;
import com.cyberlink.beautycircle.controller.a.aq;
import com.cyberlink.beautycircle.controller.a.e;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.perfectcorp.a.b;
import java.util.TreeMap;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity, g

class a
    implements android.view.ener
{

    final PostActivity a;

    public void onClick(View view)
    {
        view = (g)com.cyberlink.beautycircle.controller.activity.PostActivity.e(a).get(Integer.valueOf(PostActivity.d(a)));
        if (view != null)
        {
            view.g();
        }
        aq.c = "comment";
        String s = PostActivity.a(a, g.a(view));
        if (s != null)
        {
            b.a(new e(s, 0L, "comment", PostActivity.f(a), 0L));
        }
        if (view != null)
        {
            b.a(new am(am.b, "comment", Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.b(view)), Long.valueOf(g.a(view).creator.userId), 0L));
        }
    }

    (PostActivity postactivity)
    {
        a = postactivity;
        super();
    }
}
