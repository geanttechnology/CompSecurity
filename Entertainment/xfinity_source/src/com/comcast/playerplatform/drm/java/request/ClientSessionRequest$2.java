// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.request;

import com.comcast.playerplatform.drm.java.client.ClientStateInterface;
import com.comcast.playerplatform.drm.java.client.SecurityToken;
import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import com.comcast.playerplatform.drm.java.event.AbstractDrmEventListener;
import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import org.slf4j.Logger;

// Referenced classes of package com.comcast.playerplatform.drm.java.request:
//            ClientSessionRequest

class er extends AbstractResponseEventListener
{

    final ClientSessionRequest this$0;

    public void configurationNotReady()
    {
        ClientSessionRequest.logger.debug("MetaDataResponse Error: 7505.1");
        ClientSessionRequest.access$100(ClientSessionRequest.this).internalDRMError(SecurityTokenType.META, "7505.1", "Metadata ErrorNetwork Request Error");
    }

    public void requestFailed(String s)
    {
        ClientSessionRequest.logger.debug("MetaDataResponse Error: 7505.0");
        ClientSessionRequest.access$100(ClientSessionRequest.this).internalDRMError(SecurityTokenType.META, "7505.0", "Metadata ErrorNetwork Request Error");
    }

    public void responseReceived(String s)
    {
        ClientSessionRequest.logger.debug("MetaDataResponse Received. Creating Meta token");
        s = new SecurityToken(SecurityTokenType.META, s);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("Zulu"));
        calendar.add(11, 24);
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        simpledateformat.setTimeZone(TimeZone.getTimeZone("Zulu"));
        s.setNotOnOrAfter(simpledateformat.format(calendar.getTime()));
        ClientSessionRequest.access$200(ClientSessionRequest.this).addSecurityToken(s);
        ClientSessionRequest.access$000(ClientSessionRequest.this);
    }

    er()
    {
        this$0 = ClientSessionRequest.this;
        super();
    }
}
