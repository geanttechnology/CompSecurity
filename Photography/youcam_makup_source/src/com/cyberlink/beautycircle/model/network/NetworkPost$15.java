// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.model.Post;
import com.cyberlink.beautycircle.model.SubPost;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkPost, NetworkManager

final class d extends j
{

    final String a;
    final String b;
    final Post c;
    final ArrayList d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.post.createPosts == null)
        {
            b(NetworkErrorCode.c.a());
            return null;
        }
        networkmanager = new u(networkmanager.e.post.createPosts);
        networkmanager.a("token", a);
        networkmanager.a("postSource", b);
        networkmanager.a("mainPost", c);
        if (d != null)
        {
            for (Iterator iterator = d.iterator(); iterator.hasNext(); networkmanager.a("subPosts", (SubPost)iterator.next())) { }
        }
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    NetworkErrorCode(String s, String s1, Post post, ArrayList arraylist)
    {
        a = s;
        b = s1;
        c = post;
        d = arraylist;
        super();
    }
}
