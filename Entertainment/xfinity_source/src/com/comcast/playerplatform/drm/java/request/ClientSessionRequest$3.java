// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.request;

import com.adobe.ave.drm.DRMOperationErrorCallback;
import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import com.comcast.playerplatform.drm.java.event.AbstractDrmEventListener;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.playerplatform.drm.java.request:
//            ClientSessionRequest

class this._cls0
    implements DRMOperationErrorCallback
{

    final ClientSessionRequest this$0;

    public void OperationError(long l, long l1, Exception exception)
    {
        ClientSessionRequest.logger.debug((new StringBuilder()).append("DRM OperationError: ").append(String.valueOf(l)).append(".").append(String.valueOf(l1)).toString());
        ClientSessionRequest.access$300(ClientSessionRequest.this);
        if (l == 3329L && l1 == 412L)
        {
            ClientSessionRequest.access$100(ClientSessionRequest.this).unprovisionedError();
            return;
        }
        if (l == 3329L)
        {
            ClientSessionRequest.access$100(ClientSessionRequest.this).serverSecurityError(SecurityTokenType.XSCT, (new StringBuilder()).append(String.valueOf(l)).append(".").append(String.valueOf(l1)).toString(), "Security Server Error", ClientSessionRequest.access$400(ClientSessionRequest.this));
            return;
        } else
        {
            ClientSessionRequest.access$100(ClientSessionRequest.this).internalDRMError(SecurityTokenType.XSCT, (new StringBuilder()).append(String.valueOf(l)).append(".").append(String.valueOf(l1)).toString(), "Internal Error");
            return;
        }
    }

    ()
    {
        this$0 = ClientSessionRequest.this;
        super();
    }
}
