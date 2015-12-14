// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.support.v7.app.AlertDialog;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStrategy;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            ManualUploadAction

class loadRequest
    implements Runnable
{

    final ManualUploadAction this$0;
    final String val$message;
    final loadRequest val$uploadRequest;

    public void run()
    {
        (new android.support.v7.app.init>(ManualUploadAction.access$600(ManualUploadAction.this))).etTitle(0x7f0e0189).etMessage(val$message).etPositiveButton(0x7f0e004f, new loadDialogClickListener(ManualUploadAction.this, val$uploadRequest, UploadStrategy.ALL, null)).etNegativeButton(0x7f0e01a4, new loadDialogClickListener(ManualUploadAction.this, val$uploadRequest)).reate().show();
    }

    loadRequest()
    {
        this$0 = final_manualuploadaction;
        val$message = s;
        val$uploadRequest = loadRequest.this;
        super();
    }
}
