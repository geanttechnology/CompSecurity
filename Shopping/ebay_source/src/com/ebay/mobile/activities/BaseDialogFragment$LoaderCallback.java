// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Context;
import com.ebay.nautilus.shell.content.FwLoader;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseDialogFragment

private final class <init>
    implements com.ebay.nautilus.shell.app.init>
{

    final BaseDialogFragment this$0;

    public Context getContext()
    {
        return getActivity();
    }

    public void onCanceled(int i, FwLoader fwloader)
    {
        BaseDialogFragment.this.onCanceled(i, fwloader);
    }

    public void onTaskComplete(int i, FwLoader fwloader)
    {
        BaseDialogFragment.this.onTaskComplete(i, fwloader);
    }

    public void onTaskStarted(int i, FwLoader fwloader)
    {
        BaseDialogFragment.this.onTaskStarted(i, fwloader);
    }

    private ()
    {
        this$0 = BaseDialogFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
