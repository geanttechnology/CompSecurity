// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.e:
//            ch, cj, aj, v, 
//            by, dj

class ct extends ch
{
    public static interface a
    {

        public abstract v a();
    }


    static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final String f;
    private static final Set g = new HashSet();
    private final a h;
    private final Context i;

    public ct(Context context)
    {
        this(context, new a(context) {

            final Context a;

            public final v a()
            {
                return dj.a(a);
            }

            
            {
                a = context;
                super();
            }
        });
    }

    private ct(Context context, a a1)
    {
        super(c, new String[] {
            d
        });
        h = a1;
        i = context;
    }

    private boolean a(String s)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = g.contains(s);
        if (!flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (i.getSharedPreferences(b, 0).contains(s))
        {
            g.add(s);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_60;
        s;
        throw s;
        flag = false;
        if (true) goto _L1; else goto _L3
_L3:
    }

    public final void b(Map map)
    {
        String s;
        if (map.get(f) != null)
        {
            s = cj.a((com.google.android.gms.d.h.a)map.get(f));
        } else
        {
            s = null;
        }
        if (s == null || !a(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android.net.Uri.Builder builder = Uri.parse(cj.a((com.google.android.gms.d.h.a)map.get(d))).buildUpon();
        map = (com.google.android.gms.d.h.a)map.get(e);
        if (map != null)
        {
            map = ((Map) (com.google.android.gms.e.cj.e(map)));
            if (!(map instanceof List))
            {
                aj.a((new StringBuilder("ArbitraryPixel: additional params not a list: not sending partial hit: ")).append(builder.build().toString()).toString());
                return;
            }
            for (map = ((List)map).iterator(); map.hasNext();)
            {
                Object obj = map.next();
                if (!(obj instanceof Map))
                {
                    aj.a((new StringBuilder("ArbitraryPixel: additional params contains non-map: not sending partial hit: ")).append(builder.build().toString()).toString());
                    return;
                }
                obj = ((Map)obj).entrySet().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                    builder.appendQueryParameter(entry.getKey().toString(), entry.getValue().toString());
                }
            }

        }
        map = builder.build().toString();
        h.a().a(map);
        aj.d();
        if (s == null) goto _L1; else goto _L3
_L3:
        com/google/android/gms/e/ct;
        JVM INSTR monitorenter ;
        g.add(s);
        by.a(i, b, s, "true");
        com/google/android/gms/e/ct;
        JVM INSTR monitorexit ;
        return;
        map;
        com/google/android/gms/e/ct;
        JVM INSTR monitorexit ;
        throw map;
    }

    static 
    {
        c = e.aj.toString();
        d = f.dn.toString();
        e = f.d.toString();
        f = f.dm.toString();
        b = (new StringBuilder("gtm_")).append(c).append("_unrepeatable").toString();
    }
}
