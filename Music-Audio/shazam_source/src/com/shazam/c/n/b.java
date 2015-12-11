// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.n;

import com.shazam.b.a.a;
import com.shazam.model.search.SearchResultList;
import com.shazam.p.p.f;
import com.shazam.p.p.l;
import com.shazam.server.response.search.SearchResponse;
import com.shazam.server.response.search.SearchResultArtist;
import com.shazam.server.response.search.SearchResultTrack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
    implements a
{

    private final a a;
    private final a b;
    private final a c;

    public b(a a1, a a2, a a3)
    {
        a = a1;
        b = a2;
        c = a3;
    }

    private SearchResultList a(SearchResponse searchresponse)
    {
        ArrayList arraylist = new ArrayList();
        com.shazam.model.search.SearchResultList.Builder builder = com.shazam.model.search.SearchResultList.Builder.a();
        searchresponse = searchresponse.tracks;
        if (searchresponse != null)
        {
            SearchResultTrack searchresulttrack;
            for (Iterator iterator = ((SearchResultList) (searchresponse)).results.iterator(); iterator.hasNext(); arraylist.add(b.a(searchresulttrack)))
            {
                searchresulttrack = (SearchResultTrack)iterator.next();
            }

            builder.nextPage = ((SearchResultList) (searchresponse)).nextPage;
            builder.total = ((SearchResultList) (searchresponse)).total;
        }
        return builder.a(arraylist).b();
    }

    public final Object a(Object obj)
    {
        SearchResponse searchresponse = (SearchResponse)obj;
        com.shazam.p.p.f.a a1 = new com.shazam.p.p.f.a();
        ArrayList arraylist;
        SearchResultList searchresultlist;
        if (searchresponse.topResult == null)
        {
            obj = null;
        } else
        {
            obj = (l)a.a(searchresponse.topResult);
        }
        a1.a = ((l) (obj));
        obj = com.shazam.model.search.SearchResultList.Builder.a();
        arraylist = new ArrayList();
        searchresultlist = searchresponse.artists;
        if (searchresultlist != null)
        {
            SearchResultArtist searchresultartist;
            for (Iterator iterator = searchresultlist.results.iterator(); iterator.hasNext(); arraylist.add(c.a(searchresultartist)))
            {
                searchresultartist = (SearchResultArtist)iterator.next();
            }

            obj.nextPage = searchresultlist.nextPage;
            obj.total = searchresultlist.total;
        }
        a1.b = ((com.shazam.model.search.SearchResultList.Builder) (obj)).a(arraylist).b();
        a1.c = a(searchresponse);
        return new f(a1, (byte)0);
    }
}
