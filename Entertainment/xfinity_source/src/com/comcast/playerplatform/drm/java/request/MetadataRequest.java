// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.request;

import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.drm.java.util.ThreadManager;
import com.comcast.playerplatform.util.android.AbstractResponseEventListener;
import com.comcast.playerplatform.util.android.ConfigurationManager;
import com.comcast.playerplatform.util.android.XrestHelper;
import java.util.HashMap;

public class MetadataRequest
{

    private HttpClient httpClient;
    private AbstractResponseEventListener responseEventListener;

    public MetadataRequest(AbstractResponseEventListener abstractresponseeventlistener, HttpClient httpclient)
    {
        responseEventListener = abstractresponseeventlistener;
        httpClient = httpclient;
    }

    public void submitRequest()
    {
        ConfigurationManager configurationmanager = ConfigurationManager.getInstance();
        if (!configurationmanager.isReady())
        {
            responseEventListener.configurationNotReady();
            return;
        } else
        {
            ThreadManager.getInstance().executeRunnable(new XrestHelper("", configurationmanager.getConfigValue("MetadataEndPoint"), "GET", new HashMap(), responseEventListener, httpClient));
            return;
        }
    }
}
