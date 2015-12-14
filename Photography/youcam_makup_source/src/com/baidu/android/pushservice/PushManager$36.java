// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.android.pushservice;

import android.content.Context;

// Referenced classes of package com.baidu.android.pushservice:
//            PushManager, LoadExecutor

class a extends Thread
{

    private final Context a;

    public void run()
    {
        LoadExecutor.loadPush(a);
    }

    (Context context)
    {
        a = context;
        super();
    }
}
