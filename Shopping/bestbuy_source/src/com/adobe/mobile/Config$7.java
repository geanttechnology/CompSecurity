// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import java.util.concurrent.Callable;

// Referenced classes of package com.adobe.mobile:
//            Config, StaticMethods

final class val.task
    implements Runnable
{

    final Callable val$task;

    public void run()
    {
        try
        {
            StaticMethods.setAdvertisingIdentifier((String)val$task.call());
            return;
        }
        catch (Exception exception)
        {
            StaticMethods.logErrorFormat("Config - Error running the task to get Advertising Identifier (%s).", new Object[] {
                exception.getLocalizedMessage()
            });
        }
    }

    ble()
    {
        val$task = callable;
        super();
    }
}
