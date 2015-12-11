// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.logging;

import java.security.PrivilegedAction;

// Referenced classes of package org.apache.commons.logging:
//            LogFactory

class val.classLoader
    implements PrivilegedAction
{

    private final ClassLoader val$classLoader;
    private final String val$factoryClass;

    public Object run()
    {
        return LogFactory.createFactory(val$factoryClass, val$classLoader);
    }

    ()
    {
        val$factoryClass = s;
        val$classLoader = classloader;
    }
}
