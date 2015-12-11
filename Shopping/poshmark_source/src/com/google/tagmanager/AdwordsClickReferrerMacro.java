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

class AdwordsClickReferrerMacro extends FunctionCallImplementation
{

    private static final String COMPONENT;
    private static final String CONVERSION_ID;
    private static final String ID;
    private final Context context;

    public AdwordsClickReferrerMacro(Context context1)
    {
        super(ID, new String[] {
            CONVERSION_ID
        });
        context = context1;
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        Object obj = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(CONVERSION_ID);
        if (obj == null)
        {
            return Types.getDefaultValue();
        }
        obj = Types.valueToString(((com.google.analytics.midtier.proto.containertag.TypeSystem.Value) (obj)));
        map = (com.google.analytics.midtier.proto.containertag.TypeSystem.Value)map.get(COMPONENT);
        if (map != null)
        {
            map = Types.valueToString(map);
        } else
        {
            map = null;
        }
        map = InstallReferrerUtil.getClickReferrer(context, ((String) (obj)), map);
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
        ID = FunctionType.ADWORDS_CLICK_REFERRER.toString();
        COMPONENT = Key.COMPONENT.toString();
        CONVERSION_ID = Key.CONVERSION_ID.toString();
    }
}
