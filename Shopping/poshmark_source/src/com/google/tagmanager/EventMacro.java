// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Runtime, Types

class EventMacro extends FunctionCallImplementation
{

    private static final String ID;
    private final Runtime mRuntime;

    public EventMacro(Runtime runtime)
    {
        super(ID, new String[0]);
        mRuntime = runtime;
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        map = mRuntime.getCurrentEventName();
        if (map == null)
        {
            return Types.getDefaultValue();
        } else
        {
            return Types.objectToValue(map);
        }
    }

    public boolean isCacheable()
    {
        return false;
    }

    static 
    {
        ID = FunctionType.EVENT.toString();
    }
}
