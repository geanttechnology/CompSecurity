// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import java.io.File;

public final class x
{

    private static String a = "Android";
    private static String b = "data";

    public static File a(Context context)
    {
        context = context.getExternalFilesDir(null);
        int i = 0;
_L2:
        Context context1;
        context1 = context;
        if (context == null)
        {
            break; /* Loop/switch isn't completed */
        }
        context1 = context;
        if (i >= 2)
        {
            break; /* Loop/switch isn't completed */
        }
        context = context.getParentFile();
        i++;
        if (true) goto _L2; else goto _L1
        context;
        context1 = null;
_L1:
        return context1;
    }

}
