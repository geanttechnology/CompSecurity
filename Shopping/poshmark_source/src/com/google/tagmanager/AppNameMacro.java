// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.analytics.containertag.common.FunctionType;
import java.util.Map;

// Referenced classes of package com.google.tagmanager:
//            FunctionCallImplementation, Types, Log

class AppNameMacro extends FunctionCallImplementation
{

    private static final String ID;
    private final Context mContext;

    public AppNameMacro(Context context)
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
        try
        {
            map = mContext.getPackageManager();
            map = Types.objectToValue(map.getApplicationLabel(map.getApplicationInfo(mContext.getPackageName(), 0)).toString());
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            Log.e("App name is not found.", map);
            return Types.getDefaultValue();
        }
        return map;
    }

    public boolean isCacheable()
    {
        return true;
    }

    static 
    {
        ID = FunctionType.APP_NAME.toString();
    }
}
