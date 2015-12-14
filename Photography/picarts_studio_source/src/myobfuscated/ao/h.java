// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ao;

import com.millennialmedia.google.gson.JsonSyntaxException;
import com.millennialmedia.google.gson.d;
import com.millennialmedia.google.gson.e;
import com.millennialmedia.google.gson.f;
import com.millennialmedia.google.gson.g;
import com.millennialmedia.google.gson.i;
import com.millennialmedia.google.gson.internal.c;
import com.millennialmedia.google.gson.internal.j;
import com.millennialmedia.google.gson.stream.JsonToken;
import com.millennialmedia.google.gson.stream.a;
import com.millennialmedia.google.gson.stream.b;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import myobfuscated.f.m;

// Referenced classes of package myobfuscated.ao:
//            o, g

final class h extends i
{

    private final i a;
    private final i b;
    private final j c;
    private myobfuscated.ao.g d;

    public h(myobfuscated.ao.g g1, com.millennialmedia.google.gson.b b1, Type type, i k, Type type1, i l, j j1)
    {
        d = g1;
        super();
        a = new o(b1, k, type);
        b = new o(b1, l, type1);
        c = j1;
    }

    public final Object a(a a1)
    {
        JsonToken jsontoken = a1.f();
        if (jsontoken == JsonToken.NULL)
        {
            a1.k();
            return null;
        }
        Map map = (Map)c.a();
        if (jsontoken == JsonToken.BEGIN_ARRAY)
        {
            a1.a();
            for (; a1.e(); a1.b())
            {
                a1.a();
                Object obj = a.a(a1);
                if (map.put(obj, b.a(a1)) != null)
                {
                    throw new JsonSyntaxException((new StringBuilder("duplicate key: ")).append(obj).toString());
                }
            }

            a1.b();
            return map;
        }
        a1.c();
        while (a1.e()) 
        {
            c.a.a(a1);
            Object obj1 = a.a(a1);
            if (map.put(obj1, b.a(a1)) != null)
            {
                throw new JsonSyntaxException((new StringBuilder("duplicate key: ")).append(obj1).toString());
            }
        }
        a1.d();
        return map;
    }

    public final void a(b b1, Object obj)
    {
        boolean flag3 = false;
        boolean flag2 = false;
        obj = (Map)obj;
        if (obj == null)
        {
            b1.e();
            return;
        }
        if (!d.a)
        {
            b1.c();
            java.util.Map.Entry entry;
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); b.a(b1, entry.getValue()))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                b1.a(String.valueOf(entry.getKey()));
            }

            b1.d();
            return;
        }
        ArrayList arraylist = new ArrayList(((Map) (obj)).size());
        ArrayList arraylist1 = new ArrayList(((Map) (obj)).size());
        obj = ((Map) (obj)).entrySet().iterator();
        boolean flag = false;
        while (((Iterator) (obj)).hasNext()) 
        {
            java.util.Map.Entry entry1 = (java.util.Map.Entry)((Iterator) (obj)).next();
            e e1 = a.a(entry1.getKey());
            arraylist.add(e1);
            arraylist1.add(entry1.getValue());
            boolean flag1;
            if ((e1 instanceof d) || (e1 instanceof g))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag = flag1 | flag;
        }
        if (flag)
        {
            b1.a();
            for (int k = ((flag2) ? 1 : 0); k < arraylist.size(); k++)
            {
                b1.a();
                m.a((e)arraylist.get(k), b1);
                b.a(b1, arraylist1.get(k));
                b1.b();
            }

            b1.b();
            return;
        }
        b1.c();
        int l = ((flag3) ? 1 : 0);
        while (l < arraylist.size()) 
        {
            obj = (e)arraylist.get(l);
            if (obj instanceof com.millennialmedia.google.gson.h)
            {
                obj = ((e) (obj)).g();
                if (((com.millennialmedia.google.gson.h) (obj)).a instanceof Number)
                {
                    obj = String.valueOf(((com.millennialmedia.google.gson.h) (obj)).a());
                } else
                if (((com.millennialmedia.google.gson.h) (obj)).a instanceof Boolean)
                {
                    obj = Boolean.toString(((com.millennialmedia.google.gson.h) (obj)).f());
                } else
                if (((com.millennialmedia.google.gson.h) (obj)).a instanceof String)
                {
                    obj = ((com.millennialmedia.google.gson.h) (obj)).b();
                } else
                {
                    throw new AssertionError();
                }
            } else
            if (obj instanceof f)
            {
                obj = "null";
            } else
            {
                throw new AssertionError();
            }
            b1.a(((String) (obj)));
            b.a(b1, arraylist1.get(l));
            l++;
        }
        b1.d();
    }
}
