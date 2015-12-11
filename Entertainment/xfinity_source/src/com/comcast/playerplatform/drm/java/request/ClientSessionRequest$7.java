// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.request;

import android.content.Context;
import com.adobe.ave.drm.DRMManager;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.drm.java.client.ClientStateInterface;
import com.comcast.playerplatform.drm.java.event.AbstractDrmEventListener;
import com.comcast.playerplatform.util.android.ConfigurationManager;

// Referenced classes of package com.comcast.playerplatform.drm.java.request:
//            ClientSessionRequest, MetadataRequest

class val.httpClient
    implements Runnable
{

    final ClientSessionRequest this$0;
    final AbstractDrmEventListener val$adobeDrmEventListener;
    final ClientStateInterface val$appclientState;
    final Context val$context;
    final HttpClient val$httpClient;

    public void run()
    {
        ClientSessionRequest.access$702(ClientSessionRequest.this, DRMManager.getSharedManager(val$context));
        ClientSessionRequest.access$202(ClientSessionRequest.this, val$appclientState);
        ClientSessionRequest.access$102(ClientSessionRequest.this, val$adobeDrmEventListener);
        ClientSessionRequest.access$802(ClientSessionRequest.this, ConfigurationManager.getInstance().getConfigValue("ProductType"));
        ClientSessionRequest.access$902(ClientSessionRequest.this, new MetadataRequest(ClientSessionRequest.access$1000(ClientSessionRequest.this), val$httpClient));
    }

    ()
    {
        this$0 = final_clientsessionrequest;
        val$context = context1;
        val$appclientState = clientstateinterface;
        val$adobeDrmEventListener = abstractdrmeventlistener;
        val$httpClient = HttpClient.this;
        super();
    }
}
