// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.t;

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
        Object obj1 = (User)obj;
        obj = com.shazam.model.myshazam.UserDetails.Builder.a();
        obj1 = ((User) (obj1)).profile;
        if (obj1 != null)
        {
            obj.name = ((UserProfile) (obj1)).name;
            obj.avatarUrl = ((UserProfile) (obj1)).avatarUrl;
            obj.coverUrl = ((UserProfile) (obj1)).coverUrl;
        }
        return ((com.shazam.model.myshazam.UserDetails.Builder) (obj)).b();
    }
}
