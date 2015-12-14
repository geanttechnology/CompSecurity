// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.amazon.gallery.thor.cds:
//            ColdBootUIHandler

class this._cls0
    implements ThreadFactory
{

    final ColdBootUIHandler this$0;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, "ColdBootPollingThread");
        runnable.setPriority(3);
        return runnable;
    }

    ()
    {
        this$0 = ColdBootUIHandler.this;
        super();
    }
}
