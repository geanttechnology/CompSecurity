// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.os.Build;
import com.google.analytics.containertag.common.FunctionType;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types

class DeviceNameMacro extends FunctionCallImplementation
{

    private static final String ID;

    public DeviceNameMacro()
    {
        super(ID, new String[0]);
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        String s1 = Build.MANUFACTURER;
        String s = Build.MODEL;
        map = s;
        if (!s.startsWith(s1))
        {
            map = s;
            if (!s1.equals("unknown"))
            {
                map = (new StringBuilder()).append(s1).append(" ").append(s).toString();
            }
        }
        return Types.objectToValue(map);
    }

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ID = FunctionType.DEVICE_NAME.toString();
    }
}
