// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            adm, ls, lt, ado, 
//            abo, aba, add, aeo

class ady extends adm
{
    public static interface a
    {

        public abstract aba a();
    }


    static final String a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final Set f = new HashSet();
    private final a g;
    private final Context h;

    public ady(Context context)
    {
        this(context, new a(context) {

            final Context a;

            public aba a()
            {
                return aeo.a(a);
            }

            
            {
                a = context;
                super();
            }
        });
    }

    ady(Context context, a a1)
    {
        super(b, new String[] {
            c
        });
        g = a1;
        h = context;
    }

    private boolean c(String s)
    {
        boolean flag = true;
        this;
        JVM INSTR monitorenter ;
        boolean flag1 = b(s);
        if (!flag1) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (a(s))
        {
            f.add(s);
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_44;
        s;
        throw s;
        flag = false;
        if (true) goto _L1; else goto _L3
_L3:
    }

    boolean a(String s)
    {
        return h.getSharedPreferences(a, 0).contains(s);
    }

    public void b(Map map)
    {
        String s;
        if (map.get(e) != null)
        {
            s = ado.a((lv.a)map.get(e));
        } else
        {
            s = null;
        }
        if (s == null || !c(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        android.net.Uri.Builder builder = Uri.parse(ado.a((lv.a)map.get(c))).buildUpon();
        map = (lv.a)map.get(d);
        if (map != null)
        {
            map = ((Map) (ado.e(map)));
            if (!(map instanceof List))
            {
                abo.a((new StringBuilder()).append("ArbitraryPixel: additional params not a list: not sending partial hit: ").append(builder.build().toString()).toString());
                return;
            }
            for (map = ((List)map).iterator(); map.hasNext();)
            {
                Object obj = map.next();
                if (!(obj instanceof Map))
                {
                    abo.a((new StringBuilder()).append("ArbitraryPixel: additional params contains non-map: not sending partial hit: ").append(builder.build().toString()).toString());
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
        g.a().a(map);
        abo.d((new StringBuilder()).append("ArbitraryPixel: url = ").append(map).toString());
        if (s == null) goto _L1; else goto _L3
_L3:
        android/support/v7/ady;
        JVM INSTR monitorenter ;
        f.add(s);
        add.a(h, a, s, "true");
        android/support/v7/ady;
        JVM INSTR monitorexit ;
        return;
        map;
        android/support/v7/ady;
        JVM INSTR monitorexit ;
        throw map;
    }

    boolean b(String s)
    {
        return f.contains(s);
    }

    static 
    {
        b = ls.aj.toString();
        c = lt.dn.toString();
        d = lt.d.toString();
        e = lt.dm.toString();
        a = (new StringBuilder()).append("gtm_").append(b).append("_unrepeatable").toString();
    }
}
