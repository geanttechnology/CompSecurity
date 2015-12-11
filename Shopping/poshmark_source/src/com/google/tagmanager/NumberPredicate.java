// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            Predicate, Types, TypedNumber

abstract class NumberPredicate extends Predicate
{

    public NumberPredicate(String s)
    {
        super(s);
    }

    protected boolean evaluateNoDefaultValues(com.google.analytics.midtier.proto.containertag.TypeSystem.Value value, com.google.analytics.midtier.proto.containertag.TypeSystem.Value value1, Map map)
    {
        value = Types.valueToNumber(value);
        value1 = Types.valueToNumber(value1);
        if (value == Types.getDefaultNumber() || value1 == Types.getDefaultNumber())
        {
            return false;
        } else
        {
            return evaluateNumber(value, value1, map);
        }
    }

    protected abstract boolean evaluateNumber(TypedNumber typednumber, TypedNumber typednumber1, Map map);
}
