// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import com.google.analytics.containertag.common.Key;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types, InstallReferrerUtil

class InstallReferrerMacro extends FunctionCallImplementation
{

    private static final String COMPONENT;
    private static final String ID;
    private final Context context;

    public InstallReferrerMacro(Context context1)
    {
        super(ID, new String[0]);
        context = context1;
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        if ((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(COMPONENT) != null)
        {
            map = Types.valueToString((com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(COMPONENT));
        } else
        {
            map = null;
        }
        map = InstallReferrerUtil.getInstallReferrer(context, map);
        if (map != null)
        {
            return Types.objectToValue(map);
        } else
        {
            return Types.getDefaultValue();
        }
    }

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ID = FunctionType.INSTALL_REFERRER.toString();
        COMPONENT = Key.COMPONENT.toString();
    }
}
