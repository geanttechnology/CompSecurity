// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation

class ConstantMacro extends FunctionCallImplementation
{

    private static final String ID;
    private static final String VALUE;

    public ConstantMacro()
    {
        super(ID, new String[] {
            VALUE
        });
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public static String getValueKey()
    {
        return VALUE;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        return (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(VALUE);
    }

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ID = FunctionType.CONSTANT.toString();
        VALUE = Key.VALUE.toString();
    }
}
