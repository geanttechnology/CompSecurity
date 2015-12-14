// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.ViewGroup;
import com.cyberlink.beautycircle.j;
import com.cyberlink.beautycircle.model.Post;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            PostCommentActivity, j

class a extends m
{

    final long a;
    final PostCommentActivity b;

    protected void a(Post post)
    {
        Post post1 = post;
        if (post == null)
        {
            post1 = new Post();
            post1.postId = Long.valueOf(a);
            PostCommentActivity.a(b);
            b.k();
        }
        post = (ViewGroup)b.findViewById(j.post_view);
        PostCommentActivity.a(b, new com.cyberlink.beautycircle.controller.activity.j(b, post, post1));
        j.a(PostCommentActivity.b(b));
    }

    protected void b(Object obj)
    {
        a((Post)obj);
    }

    (PostCommentActivity postcommentactivity, long l)
    {
        b = postcommentactivity;
        a = l;
        super();
    }
}
