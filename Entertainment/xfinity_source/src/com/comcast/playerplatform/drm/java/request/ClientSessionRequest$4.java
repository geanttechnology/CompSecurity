// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.request;

import com.adobe.ave.drm.DRMLicense;
import com.adobe.ave.drm.DRMLicenseAcquiredCallback;
import com.comcast.playerplatform.drm.java.client.ClientStateInterface;
import com.comcast.playerplatform.drm.java.client.SecurityToken;
import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import com.comcast.playerplatform.drm.java.event.AbstractDrmEventListener;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.playerplatform.drm.java.request:
//            ClientSessionRequest, ClientSessionParser

class this._cls0
    implements DRMLicenseAcquiredCallback
{

    final ClientSessionRequest this$0;

    public void LicenseAcquired(DRMLicense drmlicense)
    {
        ClientSessionRequest.logger.debug("LicenseAcquiredCallback");
        if (ClientSessionRequest.access$500(ClientSessionRequest.this).equals(ClientSessionRequest.DEPROVISION_WORKFLOW))
        {
            ClientSessionRequest.access$200(ClientSessionRequest.this).deleteAllSecurityTokens();
            ClientSessionRequest.access$100(ClientSessionRequest.this).deProvisionComplete();
        } else
        {
            drmlicense = new ClientSessionParser(drmlicense);
            if (drmlicense.isParsed())
            {
                ClientSessionRequest.logger.debug((new StringBuilder()).append("DrmLicense parsed. Current Workflow:").append(String.valueOf(ClientSessionRequest.access$500(ClientSessionRequest.this))).toString());
                if (ClientSessionRequest.access$500(ClientSessionRequest.this).equals(ClientSessionRequest.SESSION_WORKFLOW))
                {
                    ClientSessionRequest.access$200(ClientSessionRequest.this).addSecurityToken(new SecurityToken(SecurityTokenType.XSCT, drmlicense));
                    ClientSessionRequest.logger.debug("Session Created. Call event listener");
                    ClientSessionRequest.access$100(ClientSessionRequest.this).sessionCreated();
                    return;
                }
                if (ClientSessionRequest.access$500(ClientSessionRequest.this).equals(ClientSessionRequest.PROVISION_WORKFLOW))
                {
                    ClientSessionRequest.access$200(ClientSessionRequest.this).addSecurityToken(new SecurityToken(SecurityTokenType.XSCT, drmlicense));
                    ClientSessionRequest.access$100(ClientSessionRequest.this).provisionComplete();
                    return;
                }
                if (ClientSessionRequest.access$500(ClientSessionRequest.this).equals(ClientSessionRequest.ACCOUNT_WORKFLOW))
                {
                    ClientSessionRequest.access$200(ClientSessionRequest.this).addSecurityToken(new SecurityToken(SecurityTokenType.XACT, drmlicense));
                    ClientSessionRequest.access$100(ClientSessionRequest.this).xactCreated();
                    return;
                }
            } else
            {
                ClientSessionRequest.logger.debug("Internal DRM Error 7503.3");
                ClientSessionRequest.access$100(ClientSessionRequest.this).internalDRMError(SecurityTokenType.XSCT, "7503.3", "XSCT Token Failure Unable to Parse XSCT Token");
                return;
            }
        }
    }

    ()
    {
        this$0 = ClientSessionRequest.this;
        super();
    }
}
