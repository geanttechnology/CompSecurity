// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.logging;

import java.security.PrivilegedAction;

class val.def
    implements PrivilegedAction
{

    private final String val$def;
    private final String val$key;

    public Object run()
    {
        return System.getProperty(val$key, val$def);
    }

    ()
    {
        val$key = s;
        val$def = s1;
    }
}
