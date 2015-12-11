// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class pp
{

    public final Uri a;
    private final Map b = new HashMap();
    private final cpz c;
    private final pq d[];
    private int e;

    transient pp(cpz cpz1, Uri uri, pq apq[])
    {
        c = (cpz)b.a(cpz1);
        a = (Uri)b.a(uri);
        d = (pq[])b.a(apq);
        e = uri.toString().length();
    }

    private int c(String s, String s1)
    {
        List list = (List)b.get(s);
        int i;
        if (list == null || list.isEmpty())
        {
            i = s.length() + 1;
        } else
        {
            i = 0;
        }
        return i + s1.length() + 1;
    }

    public final void a()
    {
        Iterator iterator = b.values().iterator();
_L4:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if (((List)iterator.next()).isEmpty()) goto _L4; else goto _L3
_L3:
        boolean flag = false;
_L6:
        if (flag)
        {
            bmo.e("No ping as there is nothing new to report");
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        flag = true;
        if (true) goto _L6; else goto _L5
_L5:
        Object obj = bnf.a(a);
        pq apq[] = d;
        int j = apq.length;
        for (int i = 0; i < j; i++)
        {
            apq[i].a(((bnf) (obj)));
        }

        Object obj1 = b.entrySet().iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj1)).next();
            List list = (List)entry.getValue();
            if (!list.isEmpty())
            {
                ((bnf) (obj)).a((String)entry.getKey(), TextUtils.join(",", list), ",:");
                list.clear();
            }
        } while (true);
        e = a.toString().length();
        obj = ((bnf) (obj)).a.build();
        obj1 = String.valueOf(obj);
        bmo.e((new StringBuilder(String.valueOf(obj1).length() + 8)).append("Pinging ").append(((String) (obj1))).toString());
        obj1 = c;
        obj = cpz.a("qoe", 0x323467f).a(((Uri) (obj)));
        obj.d = true;
        c.a(((cqd) (obj)), cni.a);
        return;
    }

    public final void a(String s, String s1)
    {
        int l = c(s, s1);
        int i = e;
        pq apq[] = d;
        int i1 = apq.length;
        for (int j = 0; j < i1; j++)
        {
            i += apq[j].a();
        }

        int k = l;
        if (i + l > 1900)
        {
            a();
            k = c(s, s1);
        }
        e = k + e;
        b(s, s1);
    }

    final void b(String s, String s1)
    {
        List list = (List)b.get(s);
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
            b.put(s, obj);
        }
        ((List) (obj)).add(s1);
    }
}
