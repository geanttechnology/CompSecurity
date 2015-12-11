// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import com.google.api.a.g.a.a;
import com.google.api.a.g.ab;
import com.google.api.a.g.ac;
import com.google.api.a.g.b;
import com.google.api.a.g.e;
import com.google.api.a.g.f;
import com.google.api.a.g.h;
import com.google.api.a.g.k;
import com.google.api.a.g.l;
import com.google.api.a.g.u;
import com.google.api.a.g.w;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.google.api.a.d:
//            o

public final class ad
    implements u
{

    public static final String a;

    private static Object a(Type type, List list, String s)
    {
        return h.a(h.a(list, type), s);
    }

    private static void a(Reader reader, Object obj)
    {
        l l1;
        Object obj1;
        Object obj2;
        Object obj4;
        f f1;
        List list;
        b b1;
        boolean flag;
        int i;
        obj1 = obj.getClass();
        f1 = f.a(((Class) (obj1)));
        list = Arrays.asList(new Type[] {
            obj1
        });
        StringWriter stringwriter;
        if (com/google/api/a/g/l.isAssignableFrom(((Class) (obj1))))
        {
            l1 = (l)obj;
        } else
        {
            l1 = null;
        }
        if (java/util/Map.isAssignableFrom(((Class) (obj1))))
        {
            obj1 = (Map)obj;
        } else
        {
            obj1 = null;
        }
        b1 = new b(obj);
        obj2 = new StringWriter();
        stringwriter = new StringWriter();
        flag = true;
        obj4 = obj2;
        obj2 = stringwriter;
_L10:
        i = reader.read();
        i;
        JVM INSTR lookupswitch 3: default 132
    //                   -1: 157
    //                   38: 157
    //                   61: 466;
           goto _L1 _L2 _L2 _L3
_L1:
        Object obj3;
        k k1;
        Object obj5;
        if (flag)
        {
            ((StringWriter) (obj4)).write(i);
        } else
        {
            ((StringWriter) (obj2)).write(i);
        }
        continue; /* Loop/switch isn't completed */
_L2:
        obj5 = com.google.api.a.g.a.a.b(((StringWriter) (obj4)).toString());
        if (((String) (obj5)).length() == 0) goto _L5; else goto _L4
_L4:
        obj4 = com.google.api.a.g.a.a.b(((StringWriter) (obj2)).toString());
        k1 = f1.a(((String) (obj5)));
        if (k1 == null) goto _L7; else goto _L6
_L6:
        obj5 = h.a(list, k1.b.getGenericType());
        if (ac.a(((Type) (obj5))))
        {
            obj2 = ac.a(list, ac.b(((Type) (obj5))));
            b1.a(k1.b, ((Class) (obj2)), a(((Type) (obj2)), list, ((String) (obj4))));
        } else
        if (ac.a(ac.a(list, ((Type) (obj5))), java/lang/Iterable))
        {
            obj3 = (Collection)k1.a(obj);
            obj2 = obj3;
            if (obj3 == null)
            {
                obj2 = h.b(((Type) (obj5)));
                k1.a(obj, obj2);
            }
            if (obj5 == java/lang/Object)
            {
                obj3 = null;
            } else
            {
                obj3 = ac.c(((Type) (obj5)));
            }
            ((Collection) (obj2)).add(a(((Type) (obj3)), list, ((String) (obj4))));
        } else
        {
            k1.a(obj, a(((Type) (obj5)), list, ((String) (obj4))));
        }
_L5:
        obj4 = new StringWriter();
        obj2 = new StringWriter();
        if (i == -1)
        {
            b1.a();
            return;
        }
        break; /* Loop/switch isn't completed */
_L7:
        if (obj1 != null)
        {
            obj3 = (ArrayList)((Map) (obj1)).get(obj5);
            obj2 = obj3;
            if (obj3 == null)
            {
                obj2 = new ArrayList();
                if (l1 != null)
                {
                    l1.set(((String) (obj5)), obj2);
                } else
                {
                    ((Map) (obj1)).put(obj5, obj2);
                }
            }
            ((ArrayList) (obj2)).add(obj4);
        }
        if (true) goto _L5; else goto _L8
_L3:
        flag = false;
        continue; /* Loop/switch isn't completed */
_L8:
        flag = true;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public static void a(String s, Object obj)
    {
        if (s == null)
        {
            return;
        }
        try
        {
            a(((Reader) (new StringReader(s))), obj);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw ab.a(s);
        }
    }

    public final Object a(InputStream inputstream, Charset charset, Class class1)
    {
        inputstream = new InputStreamReader(inputstream, charset);
        w.a(class1 instanceof Class, "dataType has to be of type Class<?>");
        charset = ((Charset) (ac.a((Class)class1)));
        a(((Reader) (new BufferedReader(inputstream))), charset);
        return charset;
    }

    static 
    {
        o o1 = new o("application/x-www-form-urlencoded");
        Object obj = e.a;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = ((Charset) (obj)).name();
        }
        o1.a("charset", ((String) (obj)));
        a = o1.a();
    }
}
