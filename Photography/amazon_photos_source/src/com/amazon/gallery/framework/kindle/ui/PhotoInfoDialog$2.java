// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ui;

import android.app.Activity;
import android.app.Dialog;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;

// Referenced classes of package com.amazon.gallery.framework.kindle.ui:
//            PhotoInfoDialog

class cTask extends ShowDialogSyncTask
{

    final PhotoInfoDialog this$0;

    protected Dialog createDialog()
    {
        return PhotoInfoDialog.access$000(PhotoInfoDialog.this);
    }

    cTask(Activity activity)
    {
        this$0 = PhotoInfoDialog.this;
        super(activity);
    }
}
