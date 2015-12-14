// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.model.SubPost;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkPost, NetworkManager, q

final class c extends j
{

    final String a;
    final q b;
    final String c;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.post.updatePosts == null)
        {
            b(NetworkErrorCode.c.a());
            return null;
        }
        if (a == null || b == null || b.a == null)
        {
            b(NetworkErrorCode.b.a());
            return null;
        }
        networkmanager = new u(networkmanager.e.post.updatePosts);
        networkmanager.a("token", a);
        networkmanager.a("postSource", c);
        networkmanager.a("mainPost", b.a);
        if (b.b != null)
        {
            for (Iterator iterator = b.b.iterator(); iterator.hasNext(); networkmanager.a("updateSubPosts", (SubPost)iterator.next())) { }
        }
        if (b.c != null)
        {
            for (Iterator iterator1 = b.c.iterator(); iterator1.hasNext(); networkmanager.a("newSubPosts", (SubPost)iterator1.next())) { }
        }
        if (b.d != null)
        {
            for (Iterator iterator2 = b.d.iterator(); iterator2.hasNext(); networkmanager.a("deleteSubPosts", (SubPost)iterator2.next())) { }
        }
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    NetworkErrorCode(String s, q q1, String s1)
    {
        a = s;
        b = q1;
        c = s1;
        super();
    }
}
