// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.content.DialogInterface;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStrategy;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            ManualUploadAction

protected class postUploadAction
    implements android.content..UploadDialogClickListener
{

    private postUploadAction postUploadAction;
    final ManualUploadAction this$0;
    private postUploadAction uploadRequest;
    private UploadStrategy uploadStrategy;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        queueUpload(uploadRequest, uploadStrategy, postUploadAction);
    }

    public ( )
    {
        this(, UploadStrategy.WIFI_ONLY, null);
    }

    public <init>(<init> <init>1, UploadStrategy uploadstrategy, <init> <init>2)
    {
        this$0 = ManualUploadAction.this;
        super();
        uploadRequest = <init>1;
        uploadStrategy = uploadstrategy;
        postUploadAction = <init>2;
    }
}
