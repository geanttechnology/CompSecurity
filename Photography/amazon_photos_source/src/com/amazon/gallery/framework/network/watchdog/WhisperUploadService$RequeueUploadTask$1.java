// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.watchdog;

import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.gallery.framework.network.watchdog:
//            WhisperUploadService

class val.isEmpty
    implements Runnable
{

    final this._cls0 this$0;
    final boolean val$isEmpty;

    public void run()
    {
        cess._mth2100(this._cls0.this).set(false);
        if (val$isEmpty)
        {
            cess._mth2200(this._cls0.this).run();
        }
    }

    ()
    {
        this$0 = final_;
        val$isEmpty = Z.this;
        super();
    }
}
