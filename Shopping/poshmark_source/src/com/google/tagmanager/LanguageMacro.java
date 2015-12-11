// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import com.google.analytics.containertag.common.FunctionType;
import java.util.Locale;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types

class LanguageMacro extends FunctionCallImplementation
{

    private static final String ID;

    public LanguageMacro()
    {
        super(ID, new String[0]);
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        map = Locale.getDefault();
        if (map == null)
        {
            return Types.getDefaultValue();
        }
        map = map.getLanguage();
        if (map == null)
        {
            return Types.getDefaultValue();
        } else
        {
            return Types.objectToValue(map.toLowerCase());
        }
    }

    public boolean isCacheable()
    {
        return false;
    }

    static 
    {
        ID = FunctionType.LANGUAGE.toString();
    }
}
