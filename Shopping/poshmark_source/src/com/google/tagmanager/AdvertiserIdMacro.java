// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import com.google.analytics.containertag.common.FunctionType;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types

class AdvertiserIdMacro extends FunctionCallImplementation
{

    private static final String ID;
    private final Context mContext;

    public AdvertiserIdMacro(Context context)
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
        return Types.getDefaultValue();
    }

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ID = FunctionType.ADVERTISER_ID.toString();
    }
}
