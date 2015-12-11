// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMMetadata;
import com.adobe.ave.drm.DRMPolicy;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.comcast.playerplatform.drm.java.service.workflow:
//            AbstractDRMWorkflow

class val.drmKey
    implements Runnable
{

    final AbstractDRMWorkflow this$0;
    final String val$drmKey;

    public void run()
    {
        drmManager.setAuthenticationToken(drmMetadata, drmMetadata.getPolicies()[0].getAuthenticationDomain(), val$drmKey.getBytes(), drmOperationErrorCallback, drmOperationCompleteCallback);
        drmLicenseFuture.get(20000L, TimeUnit.MILLISECONDS);
        return;
        Object obj;
        obj;
_L2:
        try
        {
            sendDrmFailure("7005.2", ((Exception) (obj)).getMessage(), messageId);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            drmLicenseFuture.setException(((Throwable) (obj)));
        }
        return;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    ()
    {
        this$0 = final_abstractdrmworkflow;
        val$drmKey = String.this;
        super();
    }
}
