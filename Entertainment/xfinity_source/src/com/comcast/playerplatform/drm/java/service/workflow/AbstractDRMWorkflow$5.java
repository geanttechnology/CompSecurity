// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import com.adobe.ave.drm.DRMLicense;
import com.adobe.ave.drm.DRMLicenseAcquiredCallback;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Date;

// Referenced classes of package com.comcast.playerplatform.drm.java.service.workflow:
//            AbstractDRMWorkflow

class this._cls0
    implements DRMLicenseAcquiredCallback
{

    final AbstractDRMWorkflow this$0;

    public void LicenseAcquired(DRMLicense drmlicense)
    {
        if (drmLicenseFuture != null)
        {
            drmLicenseFuture.set(Boolean.valueOf(true));
        }
        if (drmlicense != null)
        {
            if ((new Date()).compareTo(drmlicense.getLicenseEndDate()) < 0)
            {
                sendDrmComplete(drmlicense);
            }
            return;
        } else
        {
            sendDrmFailure("7005.7", "license does not exist", messageId);
            return;
        }
    }

    ()
    {
        this$0 = AbstractDRMWorkflow.this;
        super();
    }
}
