// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.core.util;

import java.util.concurrent.ConcurrentHashMap;

public final class InternCache extends ConcurrentHashMap
{

    private static final int MAX_ENTRIES = 180;
    private static final Object _flushLock = new Object();
    public static final InternCache instance = new InternCache();

    private InternCache()
    {
        super(180, 0.8F, 4);
    }

    public String intern(String s)
    {
        String s1 = (String)get(s);
        if (s1 != null)
        {
            return s1;
        }
        if (size() >= 180)
        {
            synchronized (_flushLock)
            {
                if (size() >= 180)
                {
                    clear();
                }
            }
        }
        s = s.intern();
        put(s, s);
        return s;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

}
