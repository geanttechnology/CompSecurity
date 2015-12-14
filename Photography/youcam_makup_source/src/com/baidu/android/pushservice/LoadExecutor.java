// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.silentupdate.SilentManager;

public class LoadExecutor
{

    private static final String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCYAFbG0oYmKgh6o7BhZIHf1njBpZXqyWBnYz2ip3Wp+s97OeA/pTe8xebuGJHwq4xbsGQrJWepIbUVrdjm6JRmdvuJhar7/hC/UNnUkJgYdYl10OZKlvcFFgK3V7XGBPplXldDnhbgscna3JG8U3025WSxZCP5vy/8cfxsEoVx5QIDAQAB";

    public LoadExecutor()
    {
    }

    public static void excuteMethod(Runnable runnable, Context context)
    {
        if (isPushLibLoaded(context))
        {
            runnable.run();
            return;
        } else
        {
            (new Thread(context, runnable) {

                private final Context a;
                private final Runnable b;

                public void run()
                {
                    if (!LoadExecutor.loadPush(a))
                    {
                        return;
                    } else
                    {
                        b.run();
                        return;
                    }
                }

            
            {
                a = context;
                b = runnable;
                super();
            }
            }).start();
            return;
        }
    }

    public static boolean isPushLibLoaded(Context context)
    {
        try
        {
            context.getClassLoader().loadClass("com.baidu.android.pushservice.internal.PushManager");
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

    public static boolean loadPush(Context context)
    {
        com/baidu/android/pushservice/LoadExecutor;
        JVM INSTR monitorenter ;
        context.getClassLoader().loadClass("com.baidu.android.pushservice.internal.PushManager");
        boolean flag = true;
_L2:
        com/baidu/android/pushservice/LoadExecutor;
        JVM INSTR monitorexit ;
        return flag;
        ClassNotFoundException classnotfoundexception;
        classnotfoundexception;
        SilentManager.setKey("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCYAFbG0oYmKgh6o7BhZIHf1njBpZXqyWBnYz2ip3Wp+s97OeA/pTe8xebuGJHwq4xbsGQrJWepIbUVrdjm6JRmdvuJhar7/hC/UNnUkJgYdYl10OZKlvcFFgK3V7XGBPplXldDnhbgscna3JG8U3025WSxZCP5vy/8cfxsEoVx5QIDAQAB");
        flag = SilentManager.loadLib(context.getApplicationContext(), "frontia_plugin", "plugin-deploy.jar");
        if (true) goto _L2; else goto _L1
_L1:
        context;
        throw context;
    }
}
