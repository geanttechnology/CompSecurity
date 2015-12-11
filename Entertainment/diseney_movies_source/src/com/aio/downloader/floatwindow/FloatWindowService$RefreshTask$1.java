// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.floatwindow;


// Referenced classes of package com.aio.downloader.floatwindow:
//            FloatWindowService, MyWindowManager

class this._cls1
    implements Runnable
{

    final Context this$1;

    public void run()
    {
        MyWindowManager.createSmallWindow(cess._mth0(this._cls1.this).getApplicationContext());
    }

    ()
    {
        this$1 = this._cls1.this;
        super();
    }
}
