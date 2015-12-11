// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.IntentFilter;
import com.google.android.gms.cast.CastDevice;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class aiq
{

    final ip a;
    final chq b;
    air c;
    private final ajb d;
    private final bmi e;
    private final String f;
    private final Set g = new HashSet();
    private HashMap h;
    private String i;

    public aiq(ajb ajb1, bmi bmi1, ip ip1, String s, chq chq1)
    {
        d = ajb1;
        e = bmi1;
        f = (String)b.a(s);
        a = (ip)b.a(ip1);
        b = (chq)b.a(chq1);
        h = new HashMap();
        i = null;
    }

    private Collection b()
    {
        Set set = g;
        set;
        JVM INSTR monitorenter ;
        long l = e.a();
        Iterator iterator = h.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            String s = (String)((java.util.Map.Entry)iterator.next()).getKey();
            if (l - ((Long)h.get(s)).longValue() > 60000L)
            {
                g.remove(s);
                iterator.remove();
            }
        } while (true);
        break MISSING_BLOCK_LABEL_105;
        Exception exception;
        exception;
        set;
        JVM INSTR monitorexit ;
        throw exception;
        Set set1 = g;
        set;
        JVM INSTR monitorexit ;
        return set1;
    }

    public final String a(als als1)
    {
        Object obj;
        if (als1 == null || !als1.h())
        {
            return null;
        }
        obj = als1.a.g;
        als1 = g;
        als1;
        JVM INSTR monitorenter ;
        Iterator iterator = b().iterator();
_L9:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        String s = (String)iterator.next();
        if (s != null && obj != null) goto _L4; else goto _L3
_L6:
        boolean flag;
        if (!flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        als1;
        JVM INSTR monitorexit ;
        return s;
        obj;
        als1;
        JVM INSTR monitorexit ;
        throw obj;
_L4:
        String s1 = ((cgt) (obj)).toString().replace("-", "").replace("uuid:", "");
        if (s1.length() < 16)
        {
            break; /* Loop/switch isn't completed */
        }
        String s2 = s.replace("-", "");
        if (s2.length() < 16 || !s.contains(s1) && !s2.contains(s1))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = true;
        continue; /* Loop/switch isn't completed */
_L2:
        als1;
        JVM INSTR monitorexit ;
        return null;
_L3:
        flag = false;
        continue; /* Loop/switch isn't completed */
        if (true) goto _L6; else goto _L5
_L5:
        flag = false;
        if (true) goto _L6; else goto _L7
_L7:
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final void a()
    {
        chq chq1 = b;
        if (i != null)
        {
            d.a();
            i = null;
        }
    }

    public final boolean a(iz iz1)
    {
        if (f.isEmpty())
        {
            return false;
        }
        for (iz1 = iz1.g.iterator(); iz1.hasNext();)
        {
            if (((IntentFilter)iz1.next()).hasCategory(a.h(f)))
            {
                return true;
            }
        }

        return false;
    }

    public final void b(iz iz1)
    {
        if (a(iz1)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        chq chq1 = b;
        String s = String.valueOf(iz1.b);
        if (s.length() != 0)
        {
            obj = "add available CastV2 route: ".concat(s);
        } else
        {
            obj = new String("add available CastV2 route: ");
        }
        chq1.a(((String) (obj)));
        synchronized (g)
        {
            iz1 = iz1.b;
            g.add(iz1);
            h.remove(iz1);
        }
        if (c == null) goto _L1; else goto _L3
_L3:
        c.a();
        return;
        iz1;
        obj;
        JVM INSTR monitorexit ;
        throw iz1;
    }

    public final void c(iz iz1)
    {
        if (a(iz1)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        chq chq1 = b;
        String s = String.valueOf(iz1.b);
        if (s.length() != 0)
        {
            obj = "remove available CastV2 route: ".concat(s);
        } else
        {
            obj = new String("remove available CastV2 route: ");
        }
        chq1.a(((String) (obj)));
        synchronized (g)
        {
            iz1 = iz1.b;
            if (g.contains(iz1))
            {
                h.put(iz1, Long.valueOf(e.a()));
            }
        }
        if (c == null) goto _L1; else goto _L3
_L3:
        c.a();
        return;
        iz1;
        obj;
        JVM INSTR monitorexit ;
        throw iz1;
    }

    public final boolean d(iz iz1)
    {
        chq chq1 = b;
        a();
        if (a(iz1))
        {
            chq chq3 = b;
            Object obj = String.valueOf(iz1.c);
            if (((String) (obj)).length() != 0)
            {
                obj = "change route to Cast route ".concat(((String) (obj)));
            } else
            {
                obj = new String("change route to Cast route ");
            }
            chq3.a(((String) (obj)));
            obj = CastDevice.a(iz1.m);
            if (obj != null)
            {
                Object obj1 = b;
                obj1 = String.valueOf(((CastDevice) (obj)).d);
                if (((String) (obj1)).length() != 0)
                {
                    "Select device ".concat(((String) (obj1)));
                } else
                {
                    new String("Select device ");
                }
                obj = new alo(((CastDevice) (obj)));
                d.a(((ame) (obj)));
                i = iz1.b;
                return true;
            }
        } else
        {
            chq chq2 = b;
            if (iz1 != null)
            {
                iz1 = iz1.c;
            } else
            {
                iz1 = "null";
            }
            iz1 = String.valueOf(iz1);
            if (iz1.length() != 0)
            {
                "change route to non-Cast route ".concat(iz1);
            } else
            {
                new String("change route to non-Cast route ");
            }
        }
        return false;
    }
}
