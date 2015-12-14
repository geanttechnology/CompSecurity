// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import com.perfectcorp.utility.j;
import com.perfectcorp.utility.u;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkWeChat, NetworkManager

final class c extends j
{

    final String a;
    final String b;
    final String c;

    protected u a(NetworkManager networkmanager)
    {
        if (a == null || b == null || c == null)
        {
            b(etworkErrorCode.b.a());
            return null;
        } else
        {
            networkmanager = new u("https://api.weixin.qq.com/sns/oauth2/access_token");
            networkmanager.a("appid", a);
            networkmanager.a("secret", b);
            networkmanager.a("code", c);
            networkmanager.a("grant_type", "authorization_code");
            return networkmanager;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((NetworkManager)obj);
    }

    etworkErrorCode(String s, String s1, String s2)
    {
        a = s;
        b = s1;
        c = s2;
        super();
    }
}
