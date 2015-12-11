// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;

import java.util.HashMap;
import java.util.Map;

public class UriPatternMatcher
{

    private final Map map = new HashMap();

    public UriPatternMatcher()
    {
    }

    public void setHandlers(Map map1)
    {
        this;
        JVM INSTR monitorenter ;
        if (map1 != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("Map of handlers may not be null");
        map1;
        this;
        JVM INSTR monitorexit ;
        throw map1;
        map.clear();
        map.putAll(map1);
        this;
        JVM INSTR monitorexit ;
    }

    public void setObjects(Map map1)
    {
        this;
        JVM INSTR monitorenter ;
        if (map1 != null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new IllegalArgumentException("Map of handlers may not be null");
        map1;
        this;
        JVM INSTR monitorexit ;
        throw map1;
        map.clear();
        map.putAll(map1);
        this;
        JVM INSTR monitorexit ;
    }
}
