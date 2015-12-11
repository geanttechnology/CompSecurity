// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.util.Hashtable;

public final class ThreadLocalMap extends InheritableThreadLocal
{

    public ThreadLocalMap()
    {
    }

    public final Object childValue(Object obj)
    {
        obj = (Hashtable)obj;
        if (obj != null)
        {
            return ((Hashtable) (obj)).clone();
        } else
        {
            return null;
        }
    }
}
