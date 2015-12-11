// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.b;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import org.b.a.e;
import org.b.a.g;
import org.b.a.h;
import org.b.a.i;

// Referenced classes of package org.b:
//            b, a

public final class c
{

    static int a = 0;
    static h b = new h();
    static e c = new e();
    static boolean d = Boolean.getBoolean("slf4j.detectLoggerNameMismatch");
    private static final String e[] = {
        "1.6", "1.7"
    };
    private static String f = "org/slf4j/impl/StaticLoggerBinder.class";

    private c()
    {
    }

    public static b a(Class class1)
    {
        b b1 = a(class1.getName());
        if (d)
        {
            Class class2 = i.a();
            boolean flag;
            if (!class2.isAssignableFrom(class1))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                i.a(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", new Object[] {
                    b1.a(), class2.getName()
                }));
                i.a("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
            }
        }
        return b1;
    }

    public static b a(String s)
    {
        boolean flag = true;
        if (a != 0) goto _L2; else goto _L1
_L1:
        a = 1;
        Object obj = c();
        if (!a(((Set) (obj)))) goto _L4; else goto _L3
_L3:
        i.a("Class path contains multiple SLF4J bindings.");
        URL url;
        for (Iterator iterator = ((Set) (obj)).iterator(); iterator.hasNext(); i.a((new StringBuilder("Found binding in [")).append(url).append("]").toString()))
        {
            url = (URL)iterator.next();
        }

          goto _L5
        obj;
          goto _L6
        if (!flag) goto _L8; else goto _L7
_L7:
        a = 4;
        i.a("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
        i.a("Defaulting to no-operation (NOP) logger implementation");
        i.a("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
_L17:
        if (a == 3)
        {
            b();
        }
_L2:
        a;
        JVM INSTR tableswitch 1 4: default 168
    //                   1 347
    //                   2 337
    //                   3 315
    //                   4 330;
           goto _L9 _L10 _L11 _L12 _L13
_L9:
        throw new IllegalStateException("Unreachable code");
_L5:
        i.a("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
_L4:
        org.b.b.c.a();
        a = 3;
        if (a(((Set) (obj))))
        {
            obj = new StringBuilder("Actual binding is of type [");
            org.b.b.c.a();
            i.a(((StringBuilder) (obj)).append(org.b.b.c.b()).append("]").toString());
        }
        a();
        continue; /* Loop/switch isn't completed */
        s;
        obj = s.getMessage();
        if (obj != null && ((String) (obj)).indexOf("org.slf4j.impl.StaticLoggerBinder.getSingleton()") != -1)
        {
            a = 2;
            i.a("slf4j-api 1.6.x (or later) is incompatible with this binding.");
            i.a("Your binding is version 1.5.5 or earlier.");
            i.a("Upgrade your binding to version 1.6.x.");
        }
        throw s;
_L6:
        String s1 = ((NoClassDefFoundError) (obj)).getMessage();
        if (s1 == null || s1.indexOf("org/slf4j/impl/StaticLoggerBinder") == -1 && s1.indexOf("org.slf4j.impl.StaticLoggerBinder") == -1)
        {
            flag = false;
        }
        break MISSING_BLOCK_LABEL_102;
_L8:
        a(((Throwable) (obj)));
        throw obj;
        s;
        a(((Throwable) (s)));
        throw new IllegalStateException("Unexpected initialization failure", s);
_L12:
        obj = org.b.b.c.a().b;
_L15:
        return ((a) (obj)).a(s);
_L13:
        obj = c;
        continue; /* Loop/switch isn't completed */
_L11:
        throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");
_L10:
        obj = b;
        if (true) goto _L15; else goto _L14
_L14:
        if (true) goto _L17; else goto _L16
_L16:
    }

    private static final void a()
    {
        Object obj = new ArrayList(b.a.values());
        if (((List) (obj)).isEmpty())
        {
            return;
        }
        i.a("The following set of substitute loggers may have been accessed");
        i.a("during the initialization phase. Logging calls during this");
        i.a("phase were not honored. However, subsequent logging calls to these");
        i.a("loggers will work as normally expected.");
        i.a("See also http://www.slf4j.org/codes.html#substituteLogger");
        g g1;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); i.a(g1.a()))
        {
            g1 = (g)((Iterator) (obj)).next();
            g1.a = a(g1.a());
        }

        b.a.clear();
    }

    private static void a(Throwable throwable)
    {
        a = 2;
        i.a("Failed to instantiate SLF4J LoggerFactory", throwable);
    }

    private static boolean a(Set set)
    {
        return set.size() > 1;
    }

    private static final void b()
    {
        int j;
        boolean flag = false;
        String s;
        try
        {
            s = org.b.b.c.a;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
        catch (Throwable throwable)
        {
            i.a("Unexpected problem occured during version sanity check", throwable);
            return;
        }
        j = 0;
_L2:
        if (j < e.length)
        {
            if (s.startsWith(e[j]))
            {
                flag = true;
            }
            break MISSING_BLOCK_LABEL_93;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        i.a((new StringBuilder("The requested version ")).append(s).append(" by your slf4j binding is not compatible with ").append(Arrays.asList(e).toString()).toString());
        i.a("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        return;
        j++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static Set c()
    {
        LinkedHashSet linkedhashset = new LinkedHashSet();
        Object obj = org/b/c.getClassLoader();
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
_L1:
        try
        {
            for (obj = ClassLoader.getSystemResources(f); ((Enumeration) (obj)).hasMoreElements(); linkedhashset.add((URL)((Enumeration) (obj)).nextElement())) { }
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            i.a("Error getting resources from path", ((Throwable) (obj)));
        }
        return linkedhashset;
        obj = ((ClassLoader) (obj)).getResources(f);
          goto _L1
    }

}
