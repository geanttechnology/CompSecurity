// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;

// Referenced classes of package com.baidu.android.pushservice:
//            LoadExecutor

class b extends Thread
{

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

    (Context context, Runnable runnable)
    {
        a = context;
        b = runnable;
        super();
    }
}
