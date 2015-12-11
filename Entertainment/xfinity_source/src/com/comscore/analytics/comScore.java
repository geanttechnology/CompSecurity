// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comscore.analytics;

import android.content.Context;

// Referenced classes of package com.comscore.analytics:
//            Core

public class comScore
{

    private static Core a = new Core();

    public static Core getCore()
    {
        return a;
    }

    public static void onEnterForeground()
    {
        a.onEnterForeground();
    }

    public static void onExitForeground()
    {
        a.onExitForeground();
    }

    public static void setAppContext(Context context)
    {
        a.setAppContext(context);
    }

}
