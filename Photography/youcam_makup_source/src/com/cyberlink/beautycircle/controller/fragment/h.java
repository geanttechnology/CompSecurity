// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import com.cyberlink.beautycircle.BaseArcMenuActivity;
import com.cyberlink.beautycircle.controller.adapter.n;
import com.cyberlink.beautycircle.model.Post;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g

public class h
    implements n
{

    final g a;

    public h(g g1)
    {
        a = g1;
        super();
    }

    public void a()
    {
        e.b(new Object[] {
            a.getClass().getSimpleName()
        });
        a.a(false);
        a.a(a.g, a.k, a.b);
    }

    public void a(int i)
    {
        e.b(new Object[] {
            a.getClass().getSimpleName(), ": ", Integer.valueOf(i)
        });
    }

    public void a(Post post)
    {
        if (post != null)
        {
            e.b(new Object[] {
                a.getClass().getSimpleName(), ": ", post.postId
            });
            android.support.v4.app.FragmentActivity fragmentactivity = a.getActivity();
            if (fragmentactivity instanceof BaseArcMenuActivity)
            {
                ((BaseArcMenuActivity)fragmentactivity).a(post);
                return;
            }
        }
    }

    public void a(boolean flag)
    {
        e.b(new Object[] {
            a.getClass().getSimpleName(), ": ", Boolean.valueOf(flag)
        });
        a.c(flag);
    }

    public void b(boolean flag)
    {
        e.b(new Object[] {
            a.getClass().getSimpleName(), ": ", Boolean.valueOf(flag)
        });
        a.b(flag);
    }
}
