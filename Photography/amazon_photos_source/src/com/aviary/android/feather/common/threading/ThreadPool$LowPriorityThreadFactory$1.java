// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.threading;

import android.os.Process;

// Referenced classes of package com.aviary.android.feather.common.threading:
//            ThreadPool

class this._cls1 extends Thread
{

    final this._cls1 this$1;

    public void run()
    {
        Process.setThreadPriority(cess._mth200(this._cls1.this));
        super.run();
    }

    (Runnable runnable, String s)
    {
        this$1 = this._cls1.this;
        super(runnable, s);
    }
}
