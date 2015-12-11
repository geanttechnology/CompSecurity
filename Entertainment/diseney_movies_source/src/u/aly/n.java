// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import com.umeng.analytics.AnalyticsConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package u.aly:
//            l, k, bj, ab, 
//            ad, aa

public class n
{

    private final int a = 128;
    private final int b = 256;
    private l c;
    private Context d;
    private k e;

    public n(Context context)
    {
        if (context == null)
        {
            throw new RuntimeException("Context is null, can't track event");
        }
        d = context.getApplicationContext();
        c = new l(d);
        context = c;
        boolean flag;
        if (AnalyticsConfig.ENABLE_MEMORY_BUFFER)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        context.a(flag);
        e = k.a(d);
    }

    private boolean a(String s)
    {
        if (s != null)
        {
            int i = s.trim().getBytes().length;
            if (i > 0 && i <= 128)
            {
                return true;
            }
        }
        bj.b("MobclickAgent", "Event id is empty or too long in tracking Event");
        return false;
    }

    private boolean a(Map map)
    {
        if (map == null || map.isEmpty())
        {
            bj.b("MobclickAgent", "map is null or empty in onEvent");
            return false;
        }
        map = map.entrySet().iterator();
        java.util.Map.Entry entry;
        do
        {
            if (!map.hasNext())
            {
                return true;
            }
            entry = (java.util.Map.Entry)map.next();
            if (!a((String)entry.getKey()))
            {
                return false;
            }
            if (entry.getValue() == null)
            {
                return false;
            }
        } while (!(entry.getValue() instanceof String) || b(entry.getValue().toString()));
        return false;
    }

    private boolean b(String s)
    {
        while (s == null || s.trim().getBytes().length <= 256) 
        {
            return true;
        }
        bj.b("MobclickAgent", "Event label or value is empty or too long in tracking Event");
        return false;
    }

    public void a(String s, String s1)
    {
        if (!a(s) || !b(s1))
        {
            return;
        } else
        {
            c.a(ab.b(s, s1, null), ab.a(s, s1, null));
            return;
        }
    }

    public void a(String s, String s1, long l1, int i)
    {
        if (!a(s) || !b(s1))
        {
            return;
        }
        HashMap hashmap = new HashMap();
        String s2 = s1;
        if (s1 == null)
        {
            s2 = "";
        }
        hashmap.put(s, s2);
        e.a(new ab(s, hashmap, l1, i));
    }

    public void a(String s, Map map)
    {
        if (!a(s))
        {
            return;
        }
        try
        {
            e.a(new ad(s, map));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            bj.b("MobclickAgent", "Exception occurred in Mobclick.onEvent(). ", s);
        }
        return;
    }

    public void a(String s, Map map, long l1)
    {
        if (!a(s))
        {
            return;
        }
        try
        {
            if (a(map))
            {
                e.a(new ab(s, map, l1, -1));
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            bj.b("MobclickAgent", "Exception occurred in Mobclick.onEvent(). ", s);
        }
        return;
    }

    public void a(String s, Map map, String s1)
    {
        while (!a(s) || !a(map)) 
        {
            return;
        }
        c.a(ab.b(s, s1, map), ab.a(s, s1, map));
    }

    public void b(String s, String s1)
    {
        aa aa1;
        if (a(s) && b(s1))
        {
            if ((aa1 = c.b(ab.b(s, s1, null))) != null)
            {
                a(s, s1, (int)(System.currentTimeMillis() - aa1.a), 0);
                return;
            }
        }
    }

    public void c(String s, String s1)
    {
        if (a(s))
        {
            if ((s1 = c.b(ab.b(s, s1, null))) != null)
            {
                int i = (int)(System.currentTimeMillis() - ((aa) (s1)).a);
                a(s, ((aa) (s1)).d, i);
                return;
            }
        }
    }
}
