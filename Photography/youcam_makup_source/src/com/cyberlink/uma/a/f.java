// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.uma.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

// Referenced classes of package com.cyberlink.uma.a:
//            i, g

class f
{

    private final SharedPreferences a;

    f(Context context)
    {
        if (context == null)
        {
            throw new IllegalArgumentException("must provide valid context");
        } else
        {
            a = context.getSharedPreferences("COUNTLY_STORE", 0);
            return;
        }
    }

    static String a(Collection collection, String s)
    {
        ArrayList arraylist = new ArrayList();
        for (collection = collection.iterator(); collection.hasNext(); arraylist.add(((i)collection.next()).a().toString())) { }
        return b(arraylist, s);
    }

    static String b(Collection collection, String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        Iterator iterator = collection.iterator();
        int j = 0;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            stringbuilder.append((String)iterator.next());
            j++;
            if (j < collection.size())
            {
                stringbuilder.append(s);
            }
        } while (true);
        return stringbuilder.toString();
    }

    private String[] e()
    {
        String s = a.getString("EVENTS", "");
        if (s.length() == 0)
        {
            return new String[0];
        } else
        {
            return s.split("===");
        }
    }

    private List f()
    {
        String as[];
        ArrayList arraylist;
        int j;
        int k;
        as = e();
        arraylist = new ArrayList(as.length);
        k = as.length;
        j = 0;
_L3:
        if (j >= k) goto _L2; else goto _L1
_L1:
        Object obj = as[j];
        obj = i.a(new JSONObject(((String) (obj))));
        if (obj != null)
        {
            try
            {
                arraylist.add(obj);
            }
            catch (JSONException jsonexception)
            {
                Log.e("CountlyStore", "Cannot parse Event json", jsonexception);
            }
        }
        j++;
          goto _L3
_L2:
        Collections.sort(arraylist, new Comparator() {

            final f a;

            public int a(i l, i i1)
            {
                return l.e - i1.e;
            }

            public int compare(Object obj1, Object obj2)
            {
                return a((i)obj1, (i)obj2);
            }

            
            {
                a = f.this;
                super();
            }
        });
        return arraylist;
    }

    private void g()
    {
        this;
        JVM INSTR monitorenter ;
        a.edit().remove("EVENTS").commit();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void a(i j)
    {
        this;
        JVM INSTR monitorenter ;
        List list = f();
        list.add(j);
        a.edit().putString("EVENTS", a(((Collection) (list)), "===")).commit();
        this;
        JVM INSTR monitorexit ;
        return;
        j;
        throw j;
    }

    void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        if (s.length() > 0)
        {
            ArrayList arraylist = new ArrayList(Arrays.asList(a()));
            arraylist.add(s);
            a.edit().putString("CONNECTIONS", b(arraylist, "===")).commit();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    void a(String s, Map map, int j, double d1, g g1)
    {
        if (s == null || s.length() == 0)
        {
            throw new IllegalArgumentException("valid key required");
        } else
        {
            a(new i(s, map, j, d1, g1.a(), g1.b()));
            return;
        }
    }

    String[] a()
    {
        String s = a.getString("CONNECTIONS", "");
        if (s.length() == 0)
        {
            return new String[0];
        } else
        {
            return s.split("===");
        }
    }

    int b()
    {
        return e().length;
    }

    void b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        if (s.length() > 0)
        {
            ArrayList arraylist = new ArrayList(Arrays.asList(a()));
            if (arraylist.remove(s))
            {
                a.edit().putString("CONNECTIONS", b(((Collection) (arraylist)), "===")).commit();
            }
        }
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    List c()
    {
        this;
        JVM INSTR monitorenter ;
        List list;
        list = f();
        if (!list.isEmpty())
        {
            g();
        }
        this;
        JVM INSTR monitorexit ;
        return list;
        Exception exception;
        exception;
        throw exception;
    }

    boolean d()
    {
        return a.getString("CONNECTIONS", "").length() == 0;
    }
}
