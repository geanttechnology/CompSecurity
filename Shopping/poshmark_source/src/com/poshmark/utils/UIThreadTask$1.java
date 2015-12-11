// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            UIThreadTask

class val.data
    implements Runnable
{

    final UIThreadTask this$0;
    final Object val$data;

    public void run()
    {
        callback.runOnUIThread(val$data);
    }

    llback()
    {
        this$0 = final_uithreadtask;
        val$data = Object.this;
        super();
    }
}
