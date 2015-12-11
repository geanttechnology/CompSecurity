// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.request;

import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import com.comcast.playerplatform.drm.java.event.AbstractDrmEventListener;

// Referenced classes of package com.comcast.playerplatform.drm.java.request:
//            ClientSessionRequest

class this._cls0
    implements com.adobe.mediacore.ener
{

    final ClientSessionRequest this$0;

    public void onError(long l, long l1, Exception exception)
    {
        ClientSessionRequest.access$100(ClientSessionRequest.this).internalDRMError(SecurityTokenType.XSCT, "7505.1", "Unable to initialize");
    }

    public void onInitialized()
    {
        ClientSessionRequest.access$000(ClientSessionRequest.this);
    }

    ()
    {
        this$0 = ClientSessionRequest.this;
        super();
    }
}
