// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.f;

import com.shazam.b.a.a;
import com.shazam.server.response.follow.Avatar;
import com.shazam.server.response.follow.Follow;
import com.shazam.server.response.follow.FollowData;

public final class c
    implements a
{

    public c()
    {
    }

    public final Object a(Object obj)
    {
        String s = null;
        Follow follow = (Follow)obj;
        com.shazam.model.follow.Follow.Builder builder;
        if (follow.avatar == null)
        {
            obj = null;
        } else
        {
            obj = follow.avatar.defaultUrl;
        }
        if (follow.followKey != null)
        {
            s = follow.followKey.key;
        }
        builder = com.shazam.model.follow.Follow.Builder.a();
        builder.id = follow.id;
        builder.defaultAvatar = ((String) (obj));
        builder.name = follow.name;
        builder.followKey = s;
        builder.verified = follow.isVerified;
        return builder.b();
    }
}
