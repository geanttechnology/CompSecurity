// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.a.a;

import com.google.android.gms.ads.internal.util.client.zzb;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.a.a:
//            l, k

public abstract class j
{

    public j()
    {
    }

    protected void a()
    {
    }

    public void a(Map map)
    {
        Object obj = new HashMap();
        Field afield[] = getClass().getFields();
        int i1 = afield.length;
        for (int i = 0; i < i1; i++)
        {
            Field field1 = afield[i];
            l l1 = (l)field1.getAnnotation(com/google/a/a/l);
            if (l1 != null)
            {
                ((Map) (obj)).put(l1.a(), field1);
            }
        }

        if (((Map) (obj)).isEmpty())
        {
            zzb.zzan("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
        }
        for (map = map.entrySet().iterator(); map.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
            Field field2 = (Field)((Map) (obj)).remove(entry.getKey());
            if (field2 != null)
            {
                try
                {
                    field2.set(this, entry.getValue());
                }
                catch (IllegalAccessException illegalaccessexception)
                {
                    zzb.zzan((new StringBuilder()).append("Server option \"").append((String)entry.getKey()).append("\" could not be set: Illegal Access").toString());
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    zzb.zzan((new StringBuilder()).append("Server option \"").append((String)entry.getKey()).append("\" could not be set: Bad Type").toString());
                }
            } else
            {
                zzb.zzaj((new StringBuilder()).append("Unexpected server option: ").append((String)entry.getKey()).append(" = \"").append((String)entry.getValue()).append("\"").toString());
            }
        }

        map = new StringBuilder();
        obj = ((Map) (obj)).values().iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            Field field = (Field)((Iterator) (obj)).next();
            if (((l)field.getAnnotation(com/google/a/a/l)).b())
            {
                zzb.zzan((new StringBuilder()).append("Required server option missing: ").append(((l)field.getAnnotation(com/google/a/a/l)).a()).toString());
                if (map.length() > 0)
                {
                    map.append(", ");
                }
                map.append(((l)field.getAnnotation(com/google/a/a/l)).a());
            }
        } while (true);
        if (map.length() > 0)
        {
            throw new k((new StringBuilder()).append("Required server option(s) missing: ").append(map.toString()).toString());
        } else
        {
            a();
            return;
        }
    }
}
