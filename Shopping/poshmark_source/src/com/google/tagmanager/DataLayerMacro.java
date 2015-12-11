// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types, DataLayer

class DataLayerMacro extends FunctionCallImplementation
{

    private static final String DEFAULT_VALUE;
    private static final String ID;
    private static final String NAME;
    private final DataLayer mDataLayer;

    public DataLayerMacro(DataLayer datalayer)
    {
        super(ID, new String[] {
            NAME
        });
        mDataLayer = datalayer;
    }

    public static String getDefaultValueKey()
    {
        return DEFAULT_VALUE;
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public static String getNameKey()
    {
        return NAME;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        Object obj = mDataLayer.get(Types.valueToString((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(NAME)));
        if (obj == null)
        {
            map = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(DEFAULT_VALUE);
            if (map != null)
            {
                return map;
            } else
            {
                return Types.getDefaultValue();
            }
        } else
        {
            return Types.objectToValue(obj);
        }
    }

    public boolean isCacheable()
    {
        return false;
    }

    static 
    {
        ID = FunctionType.CUSTOM_VAR.toString();
        NAME = Key.NAME.toString();
        DEFAULT_VALUE = Key.DEFAULT_VALUE.toString();
    }
}
