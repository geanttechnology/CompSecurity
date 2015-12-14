// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.socialin.android.d;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class aa
{

    private static final String a = com/socialin/android/util/aa.getSimpleName();

    private aa()
    {
    }

    public static boolean a(Context context)
    {
        Method method = android/content/pm/PackageManager.getMethod("hasSystemFeature", new Class[] {
            java/lang/String
        });
        if (method == null) goto _L2; else goto _L1
_L1:
        boolean flag;
        Boolean boolean1 = (Boolean)method.invoke(context.getPackageManager(), new Object[] {
            "android.hardware.camera"
        });
        context = (Boolean)method.invoke(context.getPackageManager(), new Object[] {
            "android.hardware.camera.front"
        });
        if (boolean1.booleanValue())
        {
            break MISSING_BLOCK_LABEL_79;
        }
        flag = context.booleanValue();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_81;
        }
        return true;
        return false;
        context;
_L4:
        d.b(a, new Object[] {
            (new StringBuilder("Got unexpected exception: ")).append(context.getMessage()).toString()
        });
_L2:
        return true;
        context;
        continue; /* Loop/switch isn't completed */
        context;
        if (true) goto _L4; else goto _L3
_L3:
    }

}
