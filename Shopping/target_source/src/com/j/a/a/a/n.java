// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.a.a;

import com.j.a.d.e;
import com.j.a.g.w;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.j.a.a.a:
//            l

public class n extends LinkedBlockingQueue
{

    String a;

    public n()
    {
        a = null;
    }

    public boolean add(Object obj)
    {
        if (!e.e().j())
        {
            return super.add(obj);
        }
        if (a != null) goto _L2; else goto _L1
_L1:
        Field afield[];
        int j;
        afield = obj.getClass().getDeclaredFields();
        j = afield.length;
        int i = 0;
_L6:
        if (i >= j) goto _L2; else goto _L3
_L3:
        Field field = afield[i];
        if (!field.getType().equals(java/util/Map)) goto _L5; else goto _L4
_L4:
        a = field.getName();
_L2:
        if (a != null)
        {
            Object obj1 = obj.getClass().getDeclaredField(a);
            ((Field) (obj1)).setAccessible(true);
            obj1 = new HashMap((Map)((Field) (obj1)).get(obj));
            l.b().a(((Map) (obj1)));
        }
_L7:
        return super.add(obj);
_L5:
        i++;
          goto _L6
        Exception exception;
        exception;
        w.b("GA Break adding", exception);
          goto _L7
    }

    public boolean addAll(Collection collection)
    {
        return super.addAll(collection);
    }

    public Object poll()
    {
        return super.poll();
    }
}
