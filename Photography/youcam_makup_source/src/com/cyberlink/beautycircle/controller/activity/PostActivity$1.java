// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.support.v4.view.PagerAdapter;
import com.cyberlink.beautycircle.model.Post;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostActivity

class a extends m
{

    final long a;
    final PostActivity b;

    protected void a(Post post)
    {
        Post post1 = post;
        if (post == null)
        {
            post1 = new Post();
            post1.postId = Long.valueOf(a);
            PostActivity.a(b);
            b.k();
        }
        PostActivity.b(b).add(post1);
        PostActivity.c(b).notifyDataSetChanged();
    }

    protected void b(Object obj)
    {
        a((Post)obj);
    }

    (PostActivity postactivity, long l)
    {
        b = postactivity;
        a = l;
        super();
    }
}
