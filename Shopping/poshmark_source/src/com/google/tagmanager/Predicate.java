// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.Key;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types

abstract class Predicate extends FunctionCallImplementation
{

    private static final String ARG0;
    private static final String ARG1;

    public Predicate(String s)
    {
        super(s, new String[] {
            ARG0, ARG1
        });
    }

    public static String getArg0Key()
    {
        return ARG0;
    }

    public static String getArg1Key()
    {
        return ARG1;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        boolean flag1 = false;
        for (Iterator iterator = map.values().iterator(); iterator.hasNext();)
        {
            if ((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)iterator.next() == Types.getDefaultValue())
            {
                return Types.objectToValue(Boolean.valueOf(false));
            }
        }

        com.google.analytics.midtier.proto.containertag.TypeSystem.Value value = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ARG0);
        com.google.analytics.midtier.proto.containertag.TypeSystem.Value value1 = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(ARG1);
        boolean flag = flag1;
        if (value != null)
        {
            if (value1 == null)
            {
                flag = flag1;
            } else
            {
                flag = evaluateNoDefaultValues(value, value1, map);
            }
        }
        return Types.objectToValue(Boolean.valueOf(flag));
    }

    protected abstract boolean evaluateNoDefaultValues(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value, com.google.analytics.midtier.proto.containertag.TypeSystem.Value value1, Map map);

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ARG0 = Key.ARG0.toString();
        ARG1 = Key.ARG1.toString();
    }
}
