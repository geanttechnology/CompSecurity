// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.dex;

import android.util.Log;

// Referenced classes of package com.amazon.mShop.android.platform.dex:
//            SecondDexEntry

public class ExceptionUtil
{

    private static final boolean DEBUG = SecondDexEntry.getInstance().isDebuggable();

    public ExceptionUtil()
    {
    }

    public static void reportExceptions(String s, Exception exception)
    {
        if (DEBUG)
        {
            Log.e(s, "Exception", exception);
        }
    }

}
