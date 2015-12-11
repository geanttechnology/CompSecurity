// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.os.Handler;

// Referenced classes of package com.apprupt.sdk:
//            CvMediation

class val.callback
    implements Runnable
{

    final CvMediation this$0;
    final Runnable val$callback;

    public void run()
    {
    /* block-local class not found */
    class _cls1 {}

        CvMediation.access$400(CvMediation.this).post(new _cls1());
    }

    _cls1()
    {
        this$0 = final_cvmediation;
        val$callback = Runnable.this;
        super();
    }
}
