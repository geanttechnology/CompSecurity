// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.util.concurrent;


// Referenced classes of package com.google.common.util.concurrent:
//            AbstractIdleService

class this._cls1
    implements Runnable
{

    final tifyFailed this$1;

    public void run()
    {
        try
        {
            startUp();
            tifyStarted();
            return;
        }
        catch (Throwable throwable)
        {
            tifyFailed(throwable);
        }
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
