// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.net.URL;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

// Referenced classes of package a.a:
//            ft, fl, fn, et, 
//            en, fj, eq, ds

public final class fs
    implements URLStreamHandlerFactory
{

    private static final Object a = new Object();
    private static fs b;
    private LinkedList c;
    private boolean d;
    private boolean e;

    public fs(ft ft1, eq eq, ds ds)
    {
        c = new LinkedList();
        d = false;
        e = false;
        if (ft1 == ft.c || ft1 == ft.a)
        {
            c.add(new fl(eq, ds));
        }
        if (ft1 == ft.c || ft1 == ft.b)
        {
            c.add(new fn(eq, ds));
        }
    }

    public static fs a()
    {
        return b;
    }

    private boolean d()
    {
        boolean flag = false;
        this;
        JVM INSTR monitorenter ;
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (b == this) goto _L2; else goto _L1
_L1:
        boolean flag1 = d;
_L4:
        this;
        JVM INSTR monitorexit ;
        return flag;
_L2:
        if (d && e())
        {
            d = false;
            b = null;
        }
        obj;
        JVM INSTR monitorexit ;
        flag = d;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception1;
        exception1;
        obj;
        JVM INSTR monitorexit ;
        throw exception1;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static boolean e()
    {
        Field afield[];
        int i;
        int j;
        afield = java/net/URL.getDeclaredFields();
        j = afield.length;
        i = 0;
_L5:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Field field;
        field = afield[i];
        if (!java/net/URLStreamHandlerFactory.isAssignableFrom(field.getType()))
        {
            break MISSING_BLOCK_LABEL_64;
        }
        et et1 = et.f;
        field.setAccessible(true);
        field.set(null, null);
        field.setAccessible(false);
        URL.setURLStreamHandlerFactory(null);
        return true;
        Object obj;
        obj;
        en.c();
_L3:
        i++;
        continue; /* Loop/switch isn't completed */
        obj;
        en.c();
        continue; /* Loop/switch isn't completed */
        obj;
        en.c();
        if (true) goto _L3; else goto _L2
_L2:
        return false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static boolean f()
    {
        Field afield[];
        int i;
        int j;
        afield = java/net/URL.getDeclaredFields();
        j = afield.length;
        i = 0;
_L5:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Field field;
        field = afield[i];
        if (!java/util/Hashtable.isAssignableFrom(field.getType()))
        {
            break MISSING_BLOCK_LABEL_127;
        }
        Object obj2 = (ParameterizedType)field.getGenericType();
        Class class1 = (Class)((ParameterizedType) (obj2)).getActualTypeArguments()[0];
        obj2 = (Class)((ParameterizedType) (obj2)).getActualTypeArguments()[1];
        if (!java/lang/String.isAssignableFrom(class1) || !java/net/URLStreamHandler.isAssignableFrom(((Class) (obj2))))
        {
            break MISSING_BLOCK_LABEL_127;
        }
        Object obj1;
        obj1 = et.g;
        field.setAccessible(true);
        obj1 = (Hashtable)(Hashtable)field.get(null);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_116;
        }
        ((Hashtable) (obj1)).clear();
        field.setAccessible(false);
        return true;
        Object obj;
        obj;
        en.c();
_L3:
        i++;
        continue; /* Loop/switch isn't completed */
        obj;
        en.c();
        continue; /* Loop/switch isn't completed */
        obj;
        en.c();
        if (true) goto _L3; else goto _L2
_L2:
        return false;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public final boolean b()
    {
        boolean flag = true;
        Object obj = a;
        obj;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        Object obj1;
        if (b != this)
        {
            flag = false;
        }
        return flag;
        if (d)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        flag = e;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        try
        {
            URL.setURLStreamHandlerFactory(this);
            d = true;
            b = this;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1) { }
        obj;
        JVM INSTR monitorexit ;
        return d;
        obj1;
        throw obj1;
    }

    public final boolean c()
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag;
        d();
        if (!d)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        e = true;
        flag = f();
_L1:
        boolean flag2 = d;
        if (!flag2 || flag)
        {
            flag1 = true;
        }
        this;
        JVM INSTR monitorexit ;
        return flag1;
        Exception exception;
        exception;
        throw exception;
        flag = false;
          goto _L1
    }

    public final URLStreamHandler createURLStreamHandler(String s)
    {
        Iterator iterator;
        if (e)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        iterator = c.iterator();
        fj fj1;
        boolean flag;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_51;
            }
            fj1 = (fj)iterator.next();
            flag = fj1.a().equals(s);
        } while (!flag);
        return fj1;
        return null;
        s;
        throw s;
        s;
        e = true;
        en.a(s);
        return null;
    }

}
