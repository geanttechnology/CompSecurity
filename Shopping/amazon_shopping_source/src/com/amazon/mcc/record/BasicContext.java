// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.mcc.record:
//            RecordableContext

public class BasicContext
    implements RecordableContext
{

    private final String id;
    private final Map properties;

    public BasicContext()
    {
        this("");
    }

    protected BasicContext(String s)
    {
        properties = new HashMap();
        id = s;
    }

    protected final void addProperties(Map map)
    {
        synchronized (properties)
        {
            properties.putAll(map);
        }
        return;
        map;
        map1;
        JVM INSTR monitorexit ;
        throw map;
    }

    public Map getProperties()
    {
        HashMap hashmap;
        synchronized (properties)
        {
            hashmap = new HashMap(properties);
        }
        return Collections.unmodifiableMap(hashmap);
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
