// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import com.cyberlink.beautycircle.model.BCTileImage;
import com.cyberlink.beautycircle.model.CompletePost;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            g, PostActivity

class a extends m
{

    final g a;

    protected void a(int i)
    {
        PostActivity.b(a.b, true);
        a.b.l();
    }

    protected void a(CompletePost completepost)
    {
        if (completepost == null || completepost.mainPost == null)
        {
            PostActivity.b(a.b, true);
            a.b.l();
            return;
        }
        if (g.i(a) != null)
        {
            g.i(a).setRefreshing(false);
        }
        g.a(a, true);
        PostActivity.b(a.b, false);
        g.a(a, completepost);
        g.a(a, completepost.mainPost);
        g.j(a);
        a.c();
        g.a(a, completepost.subPosts, false);
        a.d();
        BCTileImage.a(completepost.mainPost);
        g.e(a);
        a.f();
        a.b.l();
    }

    protected void b(Object obj)
    {
        a((CompletePost)obj);
    }

    Activity(g g1)
    {
        a = g1;
        super();
    }
}
