// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;

import com.amazon.clouddrive.extended.model.UploadFileExtendedResponse;

// Referenced classes of package com.amazon.mixtape.upload:
//            UploadTask, UploadErrorCode

public static interface eExtendedResponse
{

    public abstract void onCancelled(UploadTask uploadtask);

    public abstract void onComplete(UploadTask uploadtask);

    public abstract void onProgress(UploadTask uploadtask, long l, long l1);

    public abstract void onRequestReevaluate(UploadTask uploadtask);

    public abstract void onRunning(UploadTask uploadtask);

    public abstract void onSidelined(UploadTask uploadtask, UploadErrorCode uploaderrorcode);

    public abstract void onSuccess(UploadTask uploadtask, UploadFileExtendedResponse uploadfileextendedresponse);
}
