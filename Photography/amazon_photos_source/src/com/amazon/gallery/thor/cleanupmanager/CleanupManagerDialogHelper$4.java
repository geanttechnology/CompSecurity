// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cleanupmanager;

import android.app.Activity;
import android.app.Dialog;
import com.amazon.gallery.framework.gallery.dialog.DialogManager;
import com.amazon.gallery.framework.gallery.dialog.ShowDialogSyncTask;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.thor.app.ThorGalleryApplication;

// Referenced classes of package com.amazon.gallery.thor.cleanupmanager:
//            CleanupManagerDialogHelper

class > extends ShowDialogSyncTask
{

    final CleanupManagerDialogHelper this$0;
    final String val$cancel;
    final String val$confirm;
    final String val$message;
    final android.content.er val$onClickListener;

    protected Dialog createDialog()
    {
        return ((DialogManager)ThorGalleryApplication.getBean(Keys.DIALOG_MANAGER)).createDialog(CleanupManagerDialogHelper.access$000(CleanupManagerDialogHelper.this), val$confirm, val$cancel, val$message, val$onClickListener);
    }

    I(android.content.er er)
    {
        this$0 = final_cleanupmanagerdialoghelper;
        val$confirm = s;
        val$cancel = s1;
        val$message = String.this;
        val$onClickListener = er;
        super(final_activity);
    }
}
