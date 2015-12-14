// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.firegnom.rat;

import android.content.Context;
import android.util.Log;

// Referenced classes of package com.firegnom.rat:
//            DefaultExceptionHandler

public class ExceptionHandler
{

    public static final String TAG = com/firegnom/rat/ExceptionHandler.getName();

    public ExceptionHandler()
    {
    }

    public static boolean register(Context context, Class class1)
    {
        Log.i(TAG, "Registering default exceptions handler");
        Thread.UncaughtExceptionHandler uncaughtexceptionhandler = Thread.getDefaultUncaughtExceptionHandler();
        if (uncaughtexceptionhandler != null)
        {
            (new StringBuilder("current handler class=")).append(uncaughtexceptionhandler.getClass().getName());
        }
        if (!(uncaughtexceptionhandler instanceof DefaultExceptionHandler))
        {
            Thread.setDefaultUncaughtExceptionHandler(new DefaultExceptionHandler(context, class1));
        }
        return false;
    }

}
