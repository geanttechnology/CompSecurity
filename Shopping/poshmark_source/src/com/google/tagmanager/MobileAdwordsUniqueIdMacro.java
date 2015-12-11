// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types

class MobileAdwordsUniqueIdMacro extends FunctionCallImplementation
{

    private static final String ID;
    private final Context mContext;

    public MobileAdwordsUniqueIdMacro(Context context)
    {
        super(ID, new String[0]);
        mContext = context;
    }

    public static String getFunctionId()
    {
        return ID;
    }

    public com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map)
    {
        map = getAndroidId(mContext);
        if (map == null)
        {
            return Types.getDefaultValue();
        } else
        {
            return Types.objectToValue(map);
        }
    }

    protected String getAndroidId(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ID = FunctionType.MOBILE_ADWORDS_UNIQUE_ID.toString();
    }
}
