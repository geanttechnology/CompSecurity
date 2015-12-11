// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.content.Context;
import com.ebay.nautilus.shell.content.FwLoader;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            BaseActivity

private final class <init>
    implements <init>
{

    final BaseActivity this$0;

    public Context getContext()
    {
        return BaseActivity.this;
    }

    public void onCanceled(int i, FwLoader fwloader)
    {
        BaseActivity.this.onCanceled(i, fwloader);
    }

    public void onTaskComplete(int i, FwLoader fwloader)
    {
        BaseActivity.this.onTaskComplete(i, fwloader);
    }

    public void onTaskStarted(int i, FwLoader fwloader)
    {
        BaseActivity.this.onTaskStarted(i, fwloader);
    }

    private ()
    {
        this$0 = BaseActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
