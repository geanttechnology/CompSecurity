// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class oe
{

    public oe()
    {
    }

    protected void a()
    {
    }

    public void a(Map map)
    {
        Object obj = new HashMap();
        Field afield[] = getClass().getFields();
        int j = afield.length;
        for (int i = 0; i < j; i++)
        {
            Field field1 = afield[i];
            og og1 = (og)field1.getAnnotation(og);
            if (og1 != null)
            {
                ((Map) (obj)).put(og1.a(), field1);
            }
        }

        if (((Map) (obj)).isEmpty())
        {
            acb.e("No server options fields detected. To suppress this message either add a field with the @Parameter annotation, or override the load() method.");
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
                    acb.e((new StringBuilder()).append("Server option \"").append((String)entry.getKey()).append("\" could not be set: Illegal Access").toString());
                }
                catch (IllegalArgumentException illegalargumentexception)
                {
                    acb.e((new StringBuilder()).append("Server option \"").append((String)entry.getKey()).append("\" could not be set: Bad Type").toString());
                }
            } else
            {
                acb.a((new StringBuilder()).append("Unexpected server option: ").append((String)entry.getKey()).append(" = \"").append((String)entry.getValue()).append("\"").toString());
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
            if (((og)field.getAnnotation(og)).b())
            {
                acb.e((new StringBuilder()).append("Required server option missing: ").append(((og)field.getAnnotation(og)).a()).toString());
                if (map.length() > 0)
                {
                    map.append(", ");
                }
                map.append(((og)field.getAnnotation(og)).a());
            }
        } while (true);
        if (map.length() > 0)
        {
            throw new of((new StringBuilder()).append("Required server option(s) missing: ").append(map.toString()).toString());
        } else
        {
            a();
            return;
        }
    }
}
