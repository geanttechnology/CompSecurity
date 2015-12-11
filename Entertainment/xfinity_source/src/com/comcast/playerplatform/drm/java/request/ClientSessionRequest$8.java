// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.request;

import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import com.comcast.playerplatform.drm.java.event.AbstractDrmEventListener;
import com.comcast.playerplatform.drm.java.util.DrmUtil;
import com.comcast.playerplatform.util.android.MoneyTrace;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.playerplatform.drm.java.request:
//            ClientSessionRequest, TokenRequestData

class val.type
    implements Runnable
{

    final ClientSessionRequest this$0;
    final String val$accountToken;
    final String val$messageType;
    final MoneyTrace val$moneyTrace;
    final SecurityTokenType val$type;

    public void run()
    {
        ClientSessionRequest.logger.debug((new StringBuilder()).append("Get Token  ThreadTest:").append(Thread.currentThread().toString()).toString());
        byte abyte0[] = DrmUtil.generateNonce();
        if (val$moneyTrace != null)
        {
            ClientSessionRequest.access$402(ClientSessionRequest.this, val$moneyTrace.generateHttpHeaderValue());
        } else
        {
            ClientSessionRequest.access$402(ClientSessionRequest.this, DrmUtil.generateId());
        }
        ClientSessionRequest.logger.debug((new StringBuilder()).append("Current DRM MessageId:").append(ClientSessionRequest.access$400(ClientSessionRequest.this)).toString());
        if (abyte0 != null)
        {
            ObjectMapper objectmapper = new ObjectMapper();
            try
            {
                ClientSessionRequest.access$1102(ClientSessionRequest.this, objectmapper.writeValueAsString(new TokenRequestData(ClientSessionRequest.access$400(ClientSessionRequest.this), val$messageType, new String(abyte0), ClientSessionRequest.access$800(ClientSessionRequest.this), val$accountToken)));
                submitRequest();
                return;
            }
            catch (JsonProcessingException jsonprocessingexception)
            {
                ClientSessionRequest.access$100(ClientSessionRequest.this).internalDRMError(val$type, "7503.0", (new StringBuilder()).append(val$messageType).append(" Error").append("Unable to generate key").toString());
            }
            return;
        } else
        {
            ClientSessionRequest.access$100(ClientSessionRequest.this).internalDRMError(val$type, "7503.0", "Session Create ErrorUnable to generate key");
            return;
        }
    }

    ()
    {
        this$0 = final_clientsessionrequest;
        val$moneyTrace = moneytrace;
        val$messageType = s;
        val$accountToken = s1;
        val$type = SecurityTokenType.this;
        super();
    }
}
