// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.ads;

import android.content.ContentValues;
import com.inmobi.commons.core.b.b;
import com.inmobi.commons.core.c.a;
import com.inmobi.commons.core.utilities.Logger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.inmobi.ads:
//            a

public class c
{

    public static final String a[] = {
        "id", "ad_content", "ad_type", "ad_size", "placement_id", "insertion_ts", "imp_id"
    };
    private static final String b = com/inmobi/ads/c.getSimpleName();
    private static c c;
    private static Object d = new Object();

    private c()
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        b1.a("ad", "(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, placement_id INTEGER NOT NULL, ad_content TEXT NOT NULL, ad_type TEXT NOT NULL, ad_size TEXT, insertion_ts INTEGER NOT NULL, imp_id TEXT NOT NULL)");
        b1.b();
    }

    public static c a()
    {
        Object obj;
        obj = c;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        Object obj1 = d;
        obj1;
        JVM INSTR monitorenter ;
        c c1 = c;
        obj = c1;
        if (c1 != null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        c = new c();
        obj = c;
        obj1;
        JVM INSTR monitorexit ;
        return ((c) (obj));
        obj;
        obj1;
        JVM INSTR monitorexit ;
        throw obj;
        return ((c) (obj));
    }

    public int a(long l, String s)
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        int i;
        if (s != null && s.trim().length() != 0)
        {
            i = b1.b("ad", "placement_id=? AND ad_size=?", new String[] {
                String.valueOf(l), s
            });
        } else
        {
            i = b1.b("ad", "placement_id=?", new String[] {
                String.valueOf(l)
            });
        }
        b1.b();
        return i;
    }

    public void a(String s, long l)
    {
        b b1 = com.inmobi.commons.core.b.b.a();
        int i = b1.a("ad", "ad_type=? AND insertion_ts<?", new String[] {
            s, String.valueOf(System.currentTimeMillis() - 1000L * l)
        });
        Logger.a(com.inmobi.commons.core.utilities.Logger.InternalLogLevel.INTERNAL, b, (new StringBuilder()).append("Deleted ").append(i).append(" expired ads from cache of type:").append(s).toString());
        b1.b();
    }

    public void a(List list, int i, String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (i == 0) goto _L2; else goto _L1
_L1:
        int j = list.size();
        if (j != 0) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        b b1 = com.inmobi.commons.core.b.b.a();
        j = 0;
_L5:
        if (j >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        b1.a("ad", ((com.inmobi.ads.a)list.get(j)).a());
        j++;
        if (true) goto _L5; else goto _L4
_L4:
        i = b1.b("ad", "ad_type=?", new String[] {
            s
        }) - i;
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        list = new HashMap();
        list.put("type", s);
        list.put("count", Integer.valueOf(i));
        com.inmobi.commons.core.c.a.a().a("ads", "DbSpaceOverflow", list);
        list = b1.a("ad", new String[] {
            "id"
        }, "ad_type=?", new String[] {
            s
        }, null, null, "insertion_ts ASC", String.valueOf(i));
        s = new String[list.size()];
        i = 0;
_L7:
        if (i >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        s[i] = String.valueOf(((ContentValues)list.get(i)).getAsInteger("id"));
        i++;
        if (true) goto _L7; else goto _L6
_L6:
        list = Arrays.toString(s).replace("[", "(").replace("]", ")");
        b1.a("ad", (new StringBuilder()).append("id IN ").append(list).toString(), null);
        b1.b();
        if (true) goto _L2; else goto _L8
_L8:
        list;
        throw list;
    }

    public com.inmobi.ads.a b(long l, String s)
    {
        this;
        JVM INSTR monitorenter ;
        b b1 = com.inmobi.commons.core.b.b.a();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        if (s.trim().length() == 0)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s = b1.a("ad", a, "placement_id=? AND ad_size=?", new String[] {
            String.valueOf(l), s
        }, null, null, "insertion_ts", "1");
_L1:
        s = (ContentValues)s.get(0);
        b1.a("ad", "id=?", new String[] {
            String.valueOf(s.getAsInteger("id").intValue())
        });
        s = new com.inmobi.ads.a(s);
        this;
        JVM INSTR monitorexit ;
        return s;
        s = b1.a("ad", a, "placement_id=?", new String[] {
            String.valueOf(l)
        }, null, null, "insertion_ts", "1");
          goto _L1
        s;
        throw s;
    }

}
