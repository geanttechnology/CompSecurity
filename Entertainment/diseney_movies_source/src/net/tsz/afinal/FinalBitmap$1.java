// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package net.tsz.afinal:
//            FinalBitmap

class this._cls0
    implements ThreadFactory
{

    final FinalBitmap this$0;

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable);
        runnable.setPriority(4);
        return runnable;
    }

    ctory()
    {
        this$0 = FinalBitmap.this;
        super();
    }
}
