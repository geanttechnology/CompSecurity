// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Looper;

// Referenced classes of package com.amazon.device.ads:
//            ThreadUtils

static class 
{

    private static instance instance = new <init>();

    static  getInstance()
    {
        return instance;
    }

    boolean isOnMainThread()
    {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }


    ()
    {
    }
}
