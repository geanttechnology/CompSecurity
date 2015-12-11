// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.slf4j;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import org.slf4j.helpers.SubstituteLoggerFactory;
import org.slf4j.helpers.Util;
import org.slf4j.impl.StaticLoggerBinder;

// Referenced classes of package org.slf4j:
//            ILoggerFactory, Logger

public final class LoggerFactory
{

    private static int a = 0;
    private static SubstituteLoggerFactory b = new SubstituteLoggerFactory();
    private static final String c[] = {
        "1.5.5", "1.5.6", "1.5.7", "1.5.8"
    };
    private static String d = "org/slf4j/impl/StaticLoggerBinder.class";

    private LoggerFactory()
    {
    }

    private static final void a()
    {
        int i;
        boolean flag = false;
        String s;
        try
        {
            s = StaticLoggerBinder.REQUESTED_API_VERSION;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
        catch (Throwable throwable)
        {
            Util.reportFailure("Unexpected problem occured during version sanity check", throwable);
            return;
        }
        i = 0;
_L2:
        if (i < c.length)
        {
            if (c[i].equals(s))
            {
                flag = true;
            }
            break MISSING_BLOCK_LABEL_92;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        Util.reportFailure((new StringBuilder()).append("The requested version ").append(s).append(" by your slf4j binding is not compatible with ").append(Arrays.asList(c).toString()).toString());
        Util.reportFailure("See http://www.slf4j.org/codes.html#version_mismatch for further details.");
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void b()
    {
        ArrayList arraylist;
        Enumeration enumeration = org/slf4j/LoggerFactory.getClassLoader().getResources(d);
        arraylist = new ArrayList();
        for (; enumeration.hasMoreElements(); arraylist.add((URL)enumeration.nextElement())) { }
          goto _L1
        IOException ioexception;
        ioexception;
        Util.reportFailure("Error getting resources from path", ioexception);
_L3:
        return;
_L1:
        if (arraylist.size() <= 1) goto _L3; else goto _L2
_L2:
        Util.reportFailure("Class path contains multiple SLF4J bindings.");
        int i = 0;
_L5:
        if (i >= arraylist.size())
        {
            break; /* Loop/switch isn't completed */
        }
        Util.reportFailure((new StringBuilder()).append("Found binding in [").append(arraylist.get(i)).append("]").toString());
        i++;
        if (true) goto _L5; else goto _L4
_L4:
        Util.reportFailure("See http://www.slf4j.org/codes.html#multiple_bindings for an explanation.");
        return;
    }

    public static ILoggerFactory getILoggerFactory()
    {
        if (a != 0)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        a = 1;
        List list;
        StaticLoggerBinder.getSingleton();
        a = 3;
        list = b.getLoggerNameList();
        if (list.size() == 0) goto _L2; else goto _L1
_L1:
        Util.reportFailure("The following loggers will not work becasue they were created");
        Util.reportFailure("during the default configuration phase of the underlying logging system.");
        Util.reportFailure("See also http://www.slf4j.org/codes.html#substituteLogger");
        int i = 0;
_L3:
        if (i >= list.size())
        {
            break; /* Loop/switch isn't completed */
        }
        Util.reportFailure((String)list.get(i));
        i++;
        if (true) goto _L3; else goto _L2
        Object obj;
        obj;
        a = 2;
        String s = ((NoClassDefFoundError) (obj)).getMessage();
        if (s != null && s.indexOf("org/slf4j/impl/StaticLoggerBinder") != -1)
        {
            Util.reportFailure("Failed to load class \"org.slf4j.impl.StaticLoggerBinder\".");
            Util.reportFailure("See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.");
        }
        throw obj;
        obj;
        a = 2;
        Util.reportFailure((new StringBuilder()).append("Failed to instantiate logger [").append(StaticLoggerBinder.getSingleton().getLoggerFactoryClassStr()).append("]").toString(), ((Throwable) (obj)));
_L2:
        a();
        b();
        switch (a)
        {
        default:
            throw new IllegalStateException("Unreachable code");

        case 3: // '\003'
            return StaticLoggerBinder.getSingleton().getLoggerFactory();

        case 2: // '\002'
            throw new IllegalStateException("org.slf4j.LoggerFactory could not be successfully initialized. See also http://www.slf4j.org/codes.html#unsuccessfulInit");

        case 1: // '\001'
            return b;
        }
    }

    public static Logger getLogger(Class class1)
    {
        return getLogger(class1.getName());
    }

    public static Logger getLogger(String s)
    {
        return getILoggerFactory().getLogger(s);
    }

}
