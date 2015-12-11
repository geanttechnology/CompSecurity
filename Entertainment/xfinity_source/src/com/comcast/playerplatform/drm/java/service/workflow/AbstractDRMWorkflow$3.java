// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service.workflow;

import com.adobe.ave.drm.DRMManager;

// Referenced classes of package com.comcast.playerplatform.drm.java.service.workflow:
//            AbstractDRMWorkflow

class this._cls0
    implements Runnable
{

    final AbstractDRMWorkflow this$0;

    public void run()
    {
        drmManager.acquireLicense(drmMetadata, licenseSettings, drmOperationErrorCallback, drmLicenseAcquiredCallback);
    }

    ()
    {
        this$0 = AbstractDRMWorkflow.this;
        super();
    }
}
