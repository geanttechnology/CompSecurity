// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.n;

import com.shazam.b.a.a;
import com.shazam.c.i;
import com.shazam.server.response.follow.Avatar;
import com.shazam.server.response.follow.FollowData;
import com.shazam.server.response.search.SearchResultArtist;
import java.util.List;

public final class c
    implements a
{

    private final i a;

    public c(i j)
    {
        a = j;
    }

    public final Object a(Object obj)
    {
        Object obj1 = null;
        SearchResultArtist searchresultartist = (SearchResultArtist)obj;
        com.shazam.p.p.a a1;
        if (searchresultartist.followData.key == null)
        {
            obj = null;
        } else
        {
            obj = searchresultartist.followData.key;
        }
        a1 = new com.shazam.p.p.a();
        a1.a = searchresultartist.id;
        a1.b = searchresultartist.name;
        if (searchresultartist.avatar != null)
        {
            obj1 = searchresultartist.avatar.defaultUrl;
        }
        a1.c = ((String) (obj1));
        a1.d = searchresultartist.verified;
        obj1 = com.shazam.model.follow.FollowData.Builder.a();
        obj1.followKey = ((String) (obj));
        obj1.artistId = searchresultartist.id;
        a1.e = ((com.shazam.model.follow.FollowData.Builder) (obj1)).b();
        obj = com.shazam.model.Actions.Builder.a();
        obj.actions = (List)a.a(searchresultartist.actions);
        obj.urlParams = searchresultartist.urlParams;
        a1.f = ((com.shazam.model.Actions.Builder) (obj)).b();
        return a1.a();
    }
}
