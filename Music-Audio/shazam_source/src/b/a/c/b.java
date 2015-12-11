// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.c;

import b.a.a.a;
import b.a.b.e;
import b.a.d;
import com.google.b.b.g;
import com.google.b.f;
import com.google.b.l;
import com.google.b.o;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package b.a.c:
//            a

public final class b
    implements d
{

    private static Map a = new ConcurrentHashMap();
    private final b.a.b.d b;

    public b()
    {
        this(((b.a.b.d) (new e(new b.a.b.d[0]))));
    }

    public b(b.a.b.d d1)
    {
        b = d1;
    }

    private b.a.c.a[] a(Class class1)
    {
        this;
        JVM INSTR monitorenter ;
        b.a.c.a aa1[] = (b.a.c.a[])a.get(class1);
        b.a.c.a aa[];
        aa = aa1;
        if (aa1 != null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        ArrayList arraylist;
        arraylist = new ArrayList();
        aa = b(class1).iterator();
_L1:
        Method method;
        do
        {
            if (!aa.hasNext())
            {
                break MISSING_BLOCK_LABEL_145;
            }
            method = (Method)aa.next();
        } while (!method.isAnnotationPresent(b/a/a/a));
        if (method.getParameterTypes().length > 0)
        {
            throw new InvalidParameterException("The methods annotated with ExposeMethodResult should have no arguments");
        }
        break MISSING_BLOCK_LABEL_94;
        class1;
        this;
        JVM INSTR monitorexit ;
        throw class1;
        a a1 = (a)method.getAnnotation(b/a/a/a);
        method.setAccessible(true);
        arraylist.add(new b.a.c.a(method, a1.a(), a1.b()));
          goto _L1
        aa = new b.a.c.a[arraylist.size()];
        arraylist.toArray(aa);
        a.put(class1, aa);
        this;
        JVM INSTR monitorexit ;
        return aa;
    }

    private Collection b(Class class1)
    {
        boolean flag = false;
        HashSet hashset = new HashSet();
        if (class1 != null && class1 != java/lang/Object)
        {
            Method amethod[] = class1.getDeclaredMethods();
            int k = amethod.length;
            for (int i = 0; i < k; i++)
            {
                hashset.add(amethod[i]);
            }

            hashset.addAll(b(class1.getSuperclass()));
            class1 = class1.getInterfaces();
            k = class1.length;
            int j = ((flag) ? 1 : 0);
            while (j < k) 
            {
                hashset.addAll(b(class1[j]));
                j++;
            }
        }
        return hashset;
    }

    public final void a(l l1, Object obj, f f1)
    {
        if (!(l1 instanceof o)) goto _L2; else goto _L1
_L1:
        b.a.c.a aa[];
        int i;
        int j;
        l1 = l1.g();
        aa = a(obj.getClass());
        j = aa.length;
        i = 0;
_L3:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        b.a.c.a a1 = aa[i];
        if (b.a(a1))
        {
            break MISSING_BLOCK_LABEL_129;
        }
        try
        {
            if (a1.c != b.a.a.a.a.a)
            {
                if (a1.c != b.a.a.a.a.b)
                {
                    break MISSING_BLOCK_LABEL_129;
                }
                String s = a1.b;
                if (((o) (l1)).a.containsKey(s))
                {
                    break MISSING_BLOCK_LABEL_129;
                }
            }
            Object obj1 = a1.a.invoke(obj, new Object[0]);
            l1.a(a1.b, f1.a(obj1));
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            illegalaccessexception.printStackTrace();
        }
        catch (InvocationTargetException invocationtargetexception)
        {
            invocationtargetexception.printStackTrace();
        }
        i++;
        if (true) goto _L3; else goto _L2
_L2:
    }

}
