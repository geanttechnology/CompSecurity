// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.adapter;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.utility.DialogUtils;
import com.cyberlink.beautycircle.utility.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.adapter:
//            a

class a
    implements b
{

    final Post a;
    final a b;

    public void a()
    {
        Globals.b("Get AccountToken Fail");
    }

    public void a(String s)
    {
        if (s != null)
        {
            DialogUtils.a(b.c, s, "Post", a.postId.longValue(), com.cyberlink.beautycircle.utility.ogUtils.ReportSource.a, null);
        }
    }

    public void b()
    {
        Globals.b("Get AccountToken Cancel");
    }

    ortSource(a a1, Post post)
    {
        b = a1;
        a = post;
        super();
    }
}
