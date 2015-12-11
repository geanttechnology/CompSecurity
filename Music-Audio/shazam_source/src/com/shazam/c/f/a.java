// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.f;

import com.shazam.server.response.follow.Follow;
import com.shazam.server.response.follow.FollowingListResponse;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class a
    implements com.shazam.b.a.a
{

    private final com.shazam.b.a.a a;

    public a(com.shazam.b.a.a a1)
    {
        a = a1;
    }

    public final Object a(Object obj)
    {
        obj = (FollowingListResponse)obj;
        ArrayList arraylist = new ArrayList();
        Object obj1;
        if (((FollowingListResponse) (obj)).followings == null)
        {
            obj = Collections.emptyList();
        } else
        {
            obj = ((FollowingListResponse) (obj)).followings;
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((com.shazam.model.follow.Follow.Builder) (obj1)).b()))
        {
            obj1 = (Follow)((Iterator) (obj)).next();
            obj1 = com.shazam.model.follow.Follow.Builder.a((com.shazam.model.follow.Follow)a.a(obj1));
            obj1.isFollowing = true;
        }

        return arraylist;
    }
}
