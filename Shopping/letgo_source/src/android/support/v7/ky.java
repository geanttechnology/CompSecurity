// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            lc, ld, lg, lb

public class ky
{
    protected static class a
    {

        lc a;
        Map b;
        List c;
        List d;
        private Map e;

        public a a(lb lb1)
        {
            if (lb1 == null)
            {
                f.a("product should be non-null");
                return this;
            } else
            {
                d.add(lb1);
                return this;
            }
        }

        public a a(lb lb1, String s)
        {
            if (lb1 == null)
            {
                f.a("product should be non-null");
                return this;
            }
            String s1 = s;
            if (s == null)
            {
                s1 = "";
            }
            if (!b.containsKey(s1))
            {
                b.put(s1, new ArrayList());
            }
            ((List)b.get(s1)).add(lb1);
            return this;
        }

        public a a(lc lc1)
        {
            a = lc1;
            return this;
        }

        public a a(ld ld1)
        {
            if (ld1 == null)
            {
                f.a("promotion should be non-null");
                return this;
            } else
            {
                c.add(ld1);
                return this;
            }
        }

        public final a a(String s, String s1)
        {
            if (s != null)
            {
                e.put(s, s1);
                return this;
            } else
            {
                f.a(" HitBuilder.set() called with a null paramName.");
                return this;
            }
        }

        public final a a(Map map)
        {
            if (map == null)
            {
                return this;
            } else
            {
                e.putAll(new HashMap(map));
                return this;
            }
        }

        public Map a()
        {
            HashMap hashmap = new HashMap(e);
            if (a != null)
            {
                hashmap.putAll(a.a());
            }
            Iterator iterator = c.iterator();
            for (int i = 1; iterator.hasNext(); i++)
            {
                hashmap.putAll(((ld)iterator.next()).e(lg.e(i)));
            }

            iterator = d.iterator();
            for (int j = 1; iterator.hasNext(); j++)
            {
                hashmap.putAll(((lb)iterator.next()).g(lg.c(j)));
            }

            iterator = b.entrySet().iterator();
            for (int k = 1; iterator.hasNext(); k++)
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                Object obj = (List)entry.getValue();
                String s = lg.h(k);
                obj = ((List) (obj)).iterator();
                for (int l = 1; ((Iterator) (obj)).hasNext(); l++)
                {
                    hashmap.putAll(((lb)((Iterator) (obj)).next()).g((new StringBuilder()).append(s).append(lg.g(l)).toString()));
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
            e = new HashMap();
            b = new HashMap();
            c = new ArrayList();
            d = new ArrayList();
        }
    }

    public static class b extends a
    {

        public volatile Map a()
        {
            return super.a();
        }

        public b()
        {
            a("&t", "screenview");
        }
    }

}
