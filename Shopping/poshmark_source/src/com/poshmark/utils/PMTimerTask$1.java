// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            PMTimerTask

class this._cls0
    implements Runnable
{

    final PMTimerTask this$0;

    public void run()
    {
        callback.timerCallback();
    }

    TimerTaskCallback()
    {
        this$0 = PMTimerTask.this;
        super();
    }
}
