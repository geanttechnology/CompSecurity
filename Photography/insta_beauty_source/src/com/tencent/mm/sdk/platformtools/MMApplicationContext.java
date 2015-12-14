// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import android.content.Context;

// Referenced classes of package com.tencent.mm.sdk.platformtools:
//            Log

public final class MMApplicationContext
{

    private static Context R = null;
    private static String aE = "com.tencent.mm";

    private MMApplicationContext()
    {
    }

    public static Context getContext()
    {
        return R;
    }

    public static String getDefaultPreferencePath()
    {
        return (new StringBuilder()).append(aE).append("_preferences").toString();
    }

    public static String getPackageName()
    {
        return aE;
    }

    public static void setContext(Context context)
    {
        R = context;
        aE = context.getPackageName();
        Log.d("MicroMsg.MMApplicationContext", (new StringBuilder("setup application context for package: ")).append(aE).toString());
    }

}
