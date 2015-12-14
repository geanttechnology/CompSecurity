// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.controller.a.am;
import com.cyberlink.beautycircle.controller.adapter.a;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.model.Creator;
import com.cyberlink.beautycircle.model.Post;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a
    implements n
{

    final g a;

    public void a()
    {
        View view;
        e.b(new Object[0]);
        g.s(a).b(a.b());
        view = g.o(a).findViewById(j.post_related_posts);
        if (g.f(a)) goto _L2; else goto _L1
_L1:
        g.s(a).clear();
        if (view != null)
        {
            view.setVisibility(8);
        }
_L4:
        if (g.s(a).getCount() > 80)
        {
            g.s(a).c(false);
        }
        return;
_L2:
        if (view != null)
        {
            view.setVisibility(0);
            if (!g.t(a))
            {
                com.perfectcorp.a.b.a(new am(am.b, "related_post_show", com.cyberlink.beautycircle.controller.activity.g.a(a).postId, Long.valueOf(com.cyberlink.beautycircle.controller.activity.g.a(a).creator.userId), 0L));
            }
            com.cyberlink.beautycircle.controller.activity.g.b(a, true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(int i)
    {
        e.b(new Object[] {
            Integer.valueOf(i)
        });
    }

    public void a(Post post)
    {
        if (post == null)
        {
            return;
        } else
        {
            e.b(new Object[] {
                post.postId
            });
            a.b.a(post);
            return;
        }
    }

    public void a(boolean flag)
    {
        e.b(new Object[] {
            Boolean.valueOf(flag)
        });
    }

    public void b(boolean flag)
    {
        e.b(new Object[] {
            Boolean.valueOf(flag)
        });
    }

    ctivity(g g1)
    {
        a = g1;
        super();
    }
}
