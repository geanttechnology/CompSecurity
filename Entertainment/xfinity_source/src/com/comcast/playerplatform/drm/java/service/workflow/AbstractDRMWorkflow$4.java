// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import com.adobe.ave.drm.DRMOperationErrorCallback;
import com.google.common.util.concurrent.SettableFuture;

// Referenced classes of package com.comcast.playerplatform.drm.java.service.workflow:
//            AbstractDRMWorkflow

class this._cls0
    implements DRMOperationErrorCallback
{

    final AbstractDRMWorkflow this$0;

    public void OperationError(long l, long l1, Exception exception)
    {
        if (drmLicenseFuture != null)
        {
            drmLicenseFuture.set(Boolean.valueOf(true));
        }
        sendDrmFailure((new StringBuilder()).append(String.valueOf(l)).append(".").append(String.valueOf(l1)).toString(), "Offline Drm Failure", messageId);
    }

    ()
    {
        this$0 = AbstractDRMWorkflow.this;
        super();
    }
}
