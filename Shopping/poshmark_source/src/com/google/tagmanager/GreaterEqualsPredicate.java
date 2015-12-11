// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            NumberPredicate, TypedNumber

class GreaterEqualsPredicate extends NumberPredicate
{

    private static final String ID;

    public GreaterEqualsPredicate()
    {
        super(ID);
    }

    public static String getFunctionId()
    {
        return ID;
    }

    protected boolean evaluateNumber(TypedNumber typednumber, TypedNumber typednumber1, Map map)
    {
        return typednumber.compareTo(typednumber1) >= 0;
    }

    static 
    {
        ID = FunctionType.GREATER_EQUALS.toString();
    }
}
