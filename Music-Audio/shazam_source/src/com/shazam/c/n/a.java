// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.n;

import com.shazam.model.search.SearchResultList;
import com.shazam.model.search.SearchSection;
import com.shazam.p.p.d;
import com.shazam.p.p.f;
import com.shazam.p.p.j;
import com.shazam.p.p.l;
import com.shazam.server.response.search.SearchResponse;
import java.util.ArrayList;
import java.util.List;

public final class a
    implements com.shazam.b.a.a
{

    private final com.shazam.b.a.a a;

    public a(com.shazam.b.a.a a1)
    {
        a = a1;
    }

    private static void a(List list, String s, j j1)
    {
        if (com.shazam.b.e.a.c(s))
        {
            com.shazam.p.p.d.a a1 = new com.shazam.p.p.d.a();
            a1.b = j1;
            a1.a = s;
            list.add(new d(a1, (byte)0));
        }
    }

    public final Object a(Object obj)
    {
        obj = (SearchResponse)obj;
        f f1 = (f)a.a(obj);
        ArrayList arraylist = new ArrayList();
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist2 = new ArrayList();
        if (f1.a != null)
        {
            arraylist.add(SearchSection.TOP_RESULT);
            arraylist1.add(Integer.valueOf(0));
            if (f1.a.a == null)
            {
                obj = f1.a.b;
            } else
            {
                obj = f1.a.a;
            }
            arraylist2.add(obj);
        }
        if (f1.c != null && !f1.c.results.isEmpty())
        {
            arraylist.add(SearchSection.SONGS);
            arraylist1.add(Integer.valueOf(arraylist2.size()));
            arraylist2.addAll(f1.c.results);
            a(((List) (arraylist2)), f1.c.nextPage, j.b);
        }
        if (f1.b != null && !f1.b.results.isEmpty())
        {
            arraylist.add(SearchSection.ARTISTS);
            arraylist1.add(Integer.valueOf(arraylist2.size()));
            arraylist2.addAll(f1.b.results);
            a(((List) (arraylist2)), f1.b.nextPage, j.a);
        }
        return (new com.shazam.p.p.h.a()).c(arraylist2).a(arraylist).b(arraylist1).a();
    }
}
