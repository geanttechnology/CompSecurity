// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package u.aly;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package u.aly:
//            ae, u, x, bj

public class z
{

    private static final String a = "activities";
    private final Map b = new HashMap();
    private final ArrayList c = new ArrayList();

    public z()
    {
    }

    public static List a(SharedPreferences sharedpreferences)
    {
        String s = sharedpreferences.getString("activities", "");
        if (!"".equals(s)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        sharedpreferences = new ArrayList();
        String as[] = s.split(";");
        int i = 0;
_L5:
        int j = as.length;
        if (i < j) goto _L4; else goto _L3
_L3:
        if (sharedpreferences.size() > 0)
        {
            return sharedpreferences;
        }
          goto _L1
_L4:
        String s1 = as[i];
label0:
        {
            if (TextUtils.isEmpty(s1))
            {
                break label0;
            }
            try
            {
                sharedpreferences.add(new ae(s1));
                break label0;
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
          goto _L3
        i++;
          goto _L5
    }

    public void a()
    {
        Map map = b;
        map;
        JVM INSTR monitorenter ;
        Iterator iterator = b.entrySet().iterator();
        String s;
        long l;
        s = null;
        l = 0L;
_L2:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_48;
        }
        map;
        JVM INSTR monitorexit ;
        if (s != null)
        {
            b(s);
        }
        return;
        java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
        if (((Long)entry.getValue()).longValue() > l)
        {
            l = ((Long)entry.getValue()).longValue();
            s = (String)entry.getKey();
        }
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(Context context)
    {
        Object obj;
        obj = u.a(context);
        context = ((SharedPreferences) (obj)).edit();
        if (c.size() <= 0) goto _L2; else goto _L1
_L1:
        String s = ((SharedPreferences) (obj)).getString("activities", "");
        obj = new StringBuilder();
        if (!TextUtils.isEmpty(s))
        {
            ((StringBuilder) (obj)).append(s);
            ((StringBuilder) (obj)).append(";");
        }
        ArrayList arraylist = c;
        arraylist;
        JVM INSTR monitorenter ;
        Iterator iterator = c.iterator();
_L3:
        if (iterator.hasNext())
        {
            break MISSING_BLOCK_LABEL_137;
        }
        c.clear();
        ((StringBuilder) (obj)).deleteCharAt(((StringBuilder) (obj)).length() - 1);
        context.remove("activities");
        context.putString("activities", ((StringBuilder) (obj)).toString());
_L2:
        context.commit();
        return;
        x x1 = (x)iterator.next();
        ((StringBuilder) (obj)).append(String.format("[\"%s\",%d]", new Object[] {
            x1.a, Long.valueOf(x1.b)
        }));
        ((StringBuilder) (obj)).append(";");
          goto _L3
        context;
        arraylist;
        JVM INSTR monitorexit ;
        throw context;
    }

    public void a(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            synchronized (b)
            {
                b.put(s, Long.valueOf(System.currentTimeMillis()));
            }
            return;
        } else
        {
            return;
        }
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void b(String s)
    {
        Long long1;
        if (!TextUtils.isEmpty(s))
        {
            synchronized (b)
            {
                long1 = (Long)b.remove(s);
            }
            if (long1 != null)
            {
                break MISSING_BLOCK_LABEL_58;
            }
            bj.e("MobclickAgent", String.format("please call 'onPageStart(%s)' before onPageEnd", new Object[] {
                s
            }));
        }
        return;
        s;
        map;
        JVM INSTR monitorexit ;
        throw s;
        long l = System.currentTimeMillis();
        long l1 = long1.longValue();
        synchronized (c)
        {
            c.add(new x(s, l - l1));
        }
        return;
        s;
        arraylist;
        JVM INSTR monitorexit ;
        throw s;
    }
}
