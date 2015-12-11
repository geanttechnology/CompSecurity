// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            StringPredicate

class EndsWithPredicate extends StringPredicate
{

    private static final String ID;

    public EndsWithPredicate()
    {
        super(ID);
    }

    public static String getFunctionId()
    {
        return ID;
    }

    protected boolean evaluateString(String s, String s1, Map map)
    {
        return s.endsWith(s1);
    }

    static 
    {
        ID = FunctionType.ENDS_WITH.toString();
    }
}
