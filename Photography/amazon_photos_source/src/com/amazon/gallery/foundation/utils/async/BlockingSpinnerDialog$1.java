// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.utils.async;

import android.app.Activity;
import android.app.Dialog;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;

// Referenced classes of package com.amazon.gallery.foundation.utils.async:
//            BlockingSpinnerDialog

class it> extends ShowDialogSyncTask
{

    final BlockingSpinnerDialog this$0;

    protected Dialog createDialog()
    {
        return BlockingSpinnerDialog.access$000(BlockingSpinnerDialog.this);
    }

    (Activity activity)
    {
        this$0 = BlockingSpinnerDialog.this;
        super(activity);
    }
}
