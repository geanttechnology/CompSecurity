// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.f;

import com.shazam.b.a.a;
import com.shazam.server.response.follow.FollowData;

public final class b
    implements a
{

    public b()
    {
    }

    public final Object a(Object obj)
    {
        FollowData followdata = (FollowData)obj;
        obj = null;
        if ("artist".equals(followdata.type))
        {
            obj = followdata.id;
        }
        com.shazam.model.follow.FollowData.Builder builder = com.shazam.model.follow.FollowData.Builder.a();
        builder.followKey = followdata.key;
        builder.artistId = ((String) (obj));
        return builder.b();
    }
}
