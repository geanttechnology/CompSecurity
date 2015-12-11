// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.l;

import com.shazam.p.n.b;
import com.shazam.server.response.follow.Avatar;
import com.shazam.server.response.user.Promode;
import com.shazam.server.response.user.User;
import com.shazam.server.response.user.UserProfile;

public final class a
    implements com.shazam.b.a.a
{

    public a()
    {
    }

    public final Object a(Object obj)
    {
        com.shazam.p.n.b.a a1;
        Promode promode;
        obj = (User)obj;
        a1 = new com.shazam.p.n.b.a();
        promode = ((User) (obj)).promode;
        if (promode == null || !promode.enabled) goto _L2; else goto _L1
_L1:
        a1.a = promode.name;
        if (promode.avatar != null)
        {
            a1.b = promode.avatar.defaultUrl;
        }
_L4:
        return new b(a1, (byte)0);
_L2:
        if (((User) (obj)).profile != null)
        {
            a1.a = ((User) (obj)).profile.name;
            a1.b = ((User) (obj)).profile.avatarUrl;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
