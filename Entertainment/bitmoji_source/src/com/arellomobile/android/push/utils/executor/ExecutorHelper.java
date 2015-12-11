// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.utils.executor;

import android.os.AsyncTask;

// Referenced classes of package com.arellomobile.android.push.utils.executor:
//            V11ExecutorHelper

public class ExecutorHelper
{

    public ExecutorHelper()
    {
    }

    public static void executeAsyncTask(AsyncTask asynctask)
    {
label0:
        {
            if (asynctask != null)
            {
                if (android.os.Build.VERSION.SDK_INT < 11)
                {
                    break label0;
                }
                V11ExecutorHelper.executeOnExecutor(asynctask);
            }
            return;
        }
        asynctask.execute(new Void[] {
            (Void)null
        });
    }
}
