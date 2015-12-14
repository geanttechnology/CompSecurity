// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkPost, NetworkManager

final class d extends j
{

    final String a;
    final Long b;
    final String c;
    final JSONObject d;

    protected u a(NetworkManager networkmanager)
    {
        if (networkmanager.e.post.updateComment == null)
        {
            b(NetworkErrorCode.c.a());
            networkmanager = null;
        } else
        {
            u u1 = new u(networkmanager.e.post.updateComment);
            u1.a("token", a);
            u1.a("commentId", b);
            u1.a("comment", c);
            networkmanager = u1;
            if (d != null)
            {
                u1.a("tags", d.toString());
                return u1;
            }
        }
        return networkmanager;
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    NetworkErrorCode(String s, Long long1, String s1, JSONObject jsonobject)
    {
        a = s;
        b = long1;
        c = s1;
        d = jsonobject;
        super();
    }
}
