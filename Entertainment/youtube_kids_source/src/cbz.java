// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class cbz
    implements crb
{

    final bid a;
    final bzl b;
    final bmi c;
    private final crb d;
    private final long e;

    public cbz(bid bid1, crb crb1, bzl bzl1, bmi bmi1, long l)
    {
        a = (bid)b.a(bid1);
        d = (crb)b.a(crb1);
        b = (bzl)b.a(bzl1);
        c = (bmi)b.a(bmi1);
        e = l;
    }

    private bzi a(List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("<?xml version='1.0' encoding='UTF-8'?>");
        stringbuilder.append("<feed xmlns='http://www.w3.org/2005/Atom' xmlns:batch='http://schemas.google.com/gdata/batch' xmlns:yt='http://gdata.youtube.com/schemas/2007'>");
        stringbuilder.append("<batch:operation type='query'/>");
        Uri uri = b.a.a().buildUpon().appendPath("videos").build();
        for (list = list.iterator(); list.hasNext(); stringbuilder.append("</entry>"))
        {
            String s = (String)list.next();
            stringbuilder.append("<entry>");
            s = String.valueOf(uri.buildUpon().appendPath(s).toString());
            stringbuilder.append((new StringBuilder(String.valueOf(s).length() + 9)).append("<id>").append(s).append("</id>").toString());
        }

        stringbuilder.append("</feed>");
        list = b.a.a().buildUpon().appendPath("videos").appendPath("batch").build();
        byte abyte0[] = a.n(stringbuilder.toString());
        b.a(abyte0);
        return new bzi(list, null, abyte0);
    }

    static List a(cbz cbz1, List list, Map map, Map map1)
    {
        return a(list, map, map1);
    }

    private static List a(List list, Map map, Map map1)
    {
        ArrayList arraylist = new ArrayList();
        for (list = list.iterator(); list.hasNext();)
        {
            String s = (String)list.next();
            if (map.containsKey(s))
            {
                cdk cdk1 = new cdk();
                cdk1.a = map.get(s);
                cdk1.b = 200;
                arraylist.add(cdk1.a());
            } else
            {
                arraylist.add(map1.get(s));
            }
        }

        return arraylist;
    }

    public final void a(Object obj, bhv bhv1)
    {
        obj = (List)obj;
        HashMap hashmap = new HashMap();
        ArrayList arraylist = new ArrayList();
        for (Iterator iterator = ((List) (obj)).iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            Object obj1 = b.a(s);
            obj1 = (cnz)a.a(obj1);
            long l = c.a();
            if (obj1 != null && l >= ((cnz) (obj1)).b && ((cnz) (obj1)).b + e >= l)
            {
                hashmap.put(s, ((cnz) (obj1)).a);
            } else
            {
                arraylist.add(s);
            }
        }

        if (arraylist.isEmpty())
        {
            bhv1.a(obj, a(((List) (obj)), ((Map) (hashmap)), Collections.emptyMap()));
            return;
        } else
        {
            d.a(a(((List) (arraylist))), new cca(this, ((List) (obj)), bhv1, hashmap, arraylist));
            return;
        }
    }
}
