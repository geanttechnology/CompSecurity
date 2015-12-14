// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.async;

import android.app.Activity;
import android.app.Dialog;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;

// Referenced classes of package com.amazon.gallery.foundation.utils.async:
//            BlockingProgressDialog

class t> extends ShowDialogSyncTask
{

    final BlockingProgressDialog this$0;

    protected Dialog createDialog()
    {
        return dialog;
    }

    (Activity activity)
    {
        this$0 = BlockingProgressDialog.this;
        super(activity);
    }
}
