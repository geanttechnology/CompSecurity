// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;
import com.baidu.android.pushservice.apiproxy.BridgeInternal;

// Referenced classes of package com.baidu.android.pushservice:
//            LoadExecutor

public class Internal
{

    public Internal()
    {
    }

    public static void createBdussIntent(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgeInternal.createBdussIntent(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void disablePushConnection(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgeInternal.disablePushConnection(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void disablePushService(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgeInternal.disablePushService(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void enablePushConnection(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgeInternal.enablePushConnection(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }

    public static void enablePushService(Context context)
    {
        LoadExecutor.excuteMethod(new Runnable(context) {

            private final Context a;

            public void run()
            {
                BridgeInternal.enablePushService(a);
            }

            
            {
                a = context;
                super();
            }
        }, context);
    }
}
