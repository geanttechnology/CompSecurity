// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.n;

import com.shazam.b.a.a;
import com.shazam.c.i;
import com.shazam.server.response.chart.DefaultImage;
import com.shazam.server.response.details.Heading;
import com.shazam.server.response.search.SearchResultTrack;
import java.util.List;

public final class d
    implements a
{

    private final i a;

    public d(i j)
    {
        a = j;
    }

    public final Object a(Object obj)
    {
        obj = (SearchResultTrack)obj;
        com.shazam.p.p.e.a a1 = new com.shazam.p.p.e.a();
        Object obj1 = ((SearchResultTrack) (obj)).heading;
        if (obj1 != null)
        {
            a1.b = ((Heading) (obj1)).title;
            a1.c = ((Heading) (obj1)).subtitle;
        }
        a1.a = ((SearchResultTrack) (obj)).key;
        a1.d = ((SearchResultTrack) (obj)).defaultImage.url;
        obj1 = com.shazam.model.Actions.Builder.a();
        obj1.actions = (List)a.a(((SearchResultTrack) (obj)).actions);
        obj1.urlParams = ((SearchResultTrack) (obj)).urlParams;
        a1.e = ((com.shazam.model.Actions.Builder) (obj1)).b();
        return a1.a();
    }
}
