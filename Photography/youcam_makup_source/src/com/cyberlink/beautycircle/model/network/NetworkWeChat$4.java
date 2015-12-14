// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkWeChat, NetworkManager

final class b extends j
{

    final String a;
    final String b;

    protected u a(NetworkManager networkmanager)
    {
        if (a == null || b == null)
        {
            b(etworkErrorCode.b.a());
            return null;
        } else
        {
            networkmanager = new u("https://api.weixin.qq.com/sns/userinfo");
            networkmanager.a("access_token", a);
            networkmanager.a("openid", b);
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    etworkErrorCode(String s, String s1)
    {
        a = s;
        b = s1;
        super();
    }
}
