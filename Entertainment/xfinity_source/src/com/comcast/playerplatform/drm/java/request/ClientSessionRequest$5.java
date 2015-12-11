// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.request;

import com.adobe.ave.drm.DRMAcquireLicenseSettings;
import com.adobe.ave.drm.DRMManager;
import com.adobe.ave.drm.DRMOperationCompleteCallback;
import com.comcast.playerplatform.drm.java.util.ThreadManager;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.playerplatform.drm.java.request:
//            ClientSessionRequest

class this._cls0
    implements DRMOperationCompleteCallback
{

    final ClientSessionRequest this$0;

    public void OperationComplete()
    {
        ThreadManager.getInstance().executeOnUIThread(new Runnable() {

            final ClientSessionRequest._cls5 this$1;

            public void run()
            {
                ClientSessionRequest.logger.debug("DrmOperation Complete. Start drmManager acquireLicense");
                ClientSessionRequest.access$700(this$0).acquireLicense(ClientSessionRequest.access$600(this$0), DRMAcquireLicenseSettings.FORCE_REFRESH, adobeDrmOperationCallback, adobeDrmLicenseAcquiredCallback);
            }

            
            {
                this$1 = ClientSessionRequest._cls5.this;
                super();
            }
        });
    }

    _cls1.this._cls1()
    {
        this$0 = ClientSessionRequest.this;
        super();
    }
}
