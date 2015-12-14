// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.Post;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager, d

public class f
{

    public static j a(Long long1, int i, int k, Integer integer)
    {
        return NetworkManager.a(NetworkManager.b).a(new j(long1, i, k, integer) {

            final Long a;
            final int b;
            final int c;
            final Integer d;

            protected u a(NetworkManager networkmanager)
            {
                if (networkmanager.e.feed.listMyFeed == null)
                {
                    b(NetworkManager.NetworkErrorCode.c.a());
                    return null;
                }
                networkmanager = new u(networkmanager.e.feed.listMyFeed);
                if (Globals.j())
                {
                    networkmanager.a("postStatus", "Published");
                    networkmanager.a("postStatus", "Auditing");
                }
                networkmanager.a("userId", a);
                networkmanager.a("offset", Integer.valueOf(b));
                networkmanager.a("limit", Integer.valueOf(c));
                networkmanager.a("init", d);
                return networkmanager;
            }

            protected volatile Object a(Object obj)
            {
                return a((NetworkManager)obj);
            }

            
            {
                a = long1;
                b = i;
                c = k;
                d = integer;
                super();
            }
        }).a(NetworkManager.c()).a(new j() {

            protected d a(String s)
            {
                return new d(com/cyberlink/beautycircle/model/Post, s);
            }

            protected volatile Object a(Object obj)
            {
                return a((String)obj);
            }

        });
    }
}
