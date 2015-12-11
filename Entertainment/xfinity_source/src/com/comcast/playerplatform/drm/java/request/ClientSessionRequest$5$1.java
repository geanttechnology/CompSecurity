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

class this._cls1
    implements Runnable
{

    final eDrmLicenseAcquiredCallback this$1;

    public void run()
    {
        ClientSessionRequest.logger.debug("DrmOperation Complete. Start drmManager acquireLicense");
        ClientSessionRequest.access$700(_fld0).acquireLicense(ClientSessionRequest.access$600(_fld0), DRMAcquireLicenseSettings.FORCE_REFRESH, adobeDrmOperationCallback, adobeDrmLicenseAcquiredCallback);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/comcast/playerplatform/drm/java/request/ClientSessionRequest$5

/* anonymous class */
    class ClientSessionRequest._cls5
        implements DRMOperationCompleteCallback
    {

        final ClientSessionRequest this$0;

        public void OperationComplete()
        {
            ThreadManager.getInstance().executeOnUIThread(new ClientSessionRequest._cls5._cls1());
        }

            
            {
                this$0 = ClientSessionRequest.this;
                super();
            }
    }

}
