// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types

class PlatformMacro extends FunctionCallImplementation
{

    private static final String ID;
    private static final com.google.analytics.midtier.proto.containertag.TypeSystem.Value PLATFORM = Types.objectToValue("Android");

    public PlatformMacro()
    {
        super(ID, new String[0]);
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        return PLATFORM;
    }

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ID = FunctionType.PLATFORM.toString();
    }
}
