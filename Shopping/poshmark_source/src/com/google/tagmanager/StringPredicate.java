// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            Predicate, Types

abstract class StringPredicate extends Predicate
{

    public StringPredicate(String s)
    {
        super(s);
    }

    protected boolean evaluateNoDefaultValues(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value, com.google.analytics.midtier.proto.containertag.TypeSystem.Value value1, Map map)
    {
        value = Types.valueToString(value);
        value1 = Types.valueToString(value1);
        if (value == Types.getDefaultString() || value1 == Types.getDefaultString())
        {
            return false;
        } else
        {
            return evaluateString(value, value1, map);
        }
    }

    protected abstract boolean evaluateString(String s, String s1, Map map);
}
