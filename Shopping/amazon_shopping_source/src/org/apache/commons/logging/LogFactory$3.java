// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.logging;

import java.security.PrivilegedAction;

class val.name
    implements PrivilegedAction
{

    private final ClassLoader val$loader;
    private final String val$name;

    public Object run()
    {
        if (val$loader != null)
        {
            return val$loader.getResourceAsStream(val$name);
        } else
        {
            return ClassLoader.getSystemResourceAsStream(val$name);
        }
    }

    ()
    {
        val$loader = classloader;
        val$name = s;
    }
}
