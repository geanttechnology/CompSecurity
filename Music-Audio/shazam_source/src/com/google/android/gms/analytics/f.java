// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.a.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics:
//            k

public final class f
{
    protected static class a
    {

        public Map a;
        public com.google.android.gms.analytics.a.b b;
        public Map c;
        public List d;
        public List e;

        public final a a(String s, String s1)
        {
            a.put(s, s1);
            return this;
        }

        public Map a()
        {
            HashMap hashmap = new HashMap(a);
            if (b != null)
            {
                hashmap.putAll(b.a());
            }
            Iterator iterator = d.iterator();
            for (int i = 1; iterator.hasNext(); i++)
            {
                hashmap.putAll(((c)iterator.next()).a(k.a("&promo", i)));
            }

            iterator = e.iterator();
            for (int j = 1; iterator.hasNext(); j++)
            {
                hashmap.putAll(((com.google.android.gms.analytics.a.a)iterator.next()).a(k.a("&pr", j)));
            }

            iterator = c.entrySet().iterator();
            for (int l = 1; iterator.hasNext(); l++)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                Object obj = (List)entry.getValue();
                String s = k.a("&il", l);
                obj = ((List) (obj)).iterator();
                for (int i1 = 1; ((Iterator) (obj)).hasNext(); i1++)
                {
                    hashmap.putAll(((com.google.android.gms.analytics.a.a)((Iterator) (obj)).next()).a((new StringBuilder()).append(s).append(k.a("pi", i1)).toString()));
                }

                if (!TextUtils.isEmpty((CharSequence)entry.getKey()))
                {
                    hashmap.put((new StringBuilder()).append(s).append("nm").toString(), entry.getKey());
                }
            }

            return hashmap;
        }

        protected a()
        {
            a = new HashMap();
            c = new HashMap();
            d = new ArrayList();
            e = new ArrayList();
        }
    }

    public static final class b extends a
    {

        public final volatile Map a()
        {
            return super.a();
        }

        public b()
        {
            a("&t", "screenview");
        }
    }

}
