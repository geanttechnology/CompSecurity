// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service;

import android.content.Context;
import com.adobe.ave.drm.DRMMetadata;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.playerplatform.drm.java.client.ClientState;
import com.comcast.playerplatform.drm.java.client.ClientStateInterface;
import com.comcast.playerplatform.drm.java.event.AbstractDrmLicenseEventListener;
import com.comcast.playerplatform.drm.java.service.workflow.AbstractDRMWorkflow;
import com.comcast.playerplatform.drm.java.service.workflow.CustomDrmOfflineWorkflow;
import com.comcast.playerplatform.drm.java.service.workflow.CustomDrmStreamingWorkflow;
import com.comcast.playerplatform.drm.java.service.workflow.LocalDrmWorkflow;
import com.comcast.playerplatform.drm.java.service.workflow.OfflineDrmWorkflow;
import com.comcast.playerplatform.drm.java.service.workflow.StreamingDrmWorkflow;
import com.comcast.playerplatform.drm.java.service.workflow.WhitelistDrmWorkflow;
import com.comcast.playerplatform.drm.java.util.AuthenticationDelegate;
import com.comcast.playerplatform.util.android.MoneyTrace;
import com.comcast.playerplatform.util.android.StringUtil;

public class LicenseService
{

    private AuthenticationDelegate authDelegate;
    private ClientStateInterface clientState;
    private Context context;
    private HttpClient httpClient;

    public LicenseService(ClientStateInterface clientstateinterface, Context context1, HttpClient httpclient)
    {
        this(null, clientstateinterface, context1, httpclient);
    }

    public LicenseService(AuthenticationDelegate authenticationdelegate, Context context1, HttpClient httpclient)
    {
        this(authenticationdelegate, null, context1, httpclient);
    }

    public LicenseService(AuthenticationDelegate authenticationdelegate, ClientStateInterface clientstateinterface, Context context1, HttpClient httpclient)
    {
        if (clientstateinterface == null)
        {
            clientState = new ClientState();
        }
        authDelegate = authenticationdelegate;
        context = context1;
        httpClient = httpclient;
    }

    public void acquireLicenseForOfflinePlayback(String s, AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener)
    {
        acquireLicenseForOfflinePlayback(s, "", false, abstractdrmlicenseeventlistener, null);
    }

    public void acquireLicenseForOfflinePlayback(String s, String s1, boolean flag, AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener)
    {
        acquireLicenseForOfflinePlayback(s, s1, flag, abstractdrmlicenseeventlistener, null);
    }

    public void acquireLicenseForOfflinePlayback(String s, String s1, boolean flag, AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener, MoneyTrace moneytrace)
    {
        if (StringUtil.isNotNullOrEmpty(s1))
        {
            s1 = new CustomDrmOfflineWorkflow(clientState, authDelegate, context, httpClient, s1, true, moneytrace);
        } else
        {
            s1 = new OfflineDrmWorkflow(clientState, authDelegate, httpClient, context, moneytrace);
        }
        s1.addEventListener(abstractdrmlicenseeventlistener);
        s1.attachAsset(s);
    }

    public void acquireLicenseForStreaming(String s, String s1, boolean flag, AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener, DRMMetadata drmmetadata, MoneyTrace moneytrace)
    {
        if (StringUtil.isNotNullOrEmpty(s1))
        {
            s1 = new CustomDrmStreamingWorkflow(clientState, authDelegate, context, httpClient, s1, Boolean.valueOf(true), moneytrace);
        } else
        {
            s1 = new StreamingDrmWorkflow(clientState, authDelegate, httpClient, context, moneytrace);
        }
        s1.addEventListener(abstractdrmlicenseeventlistener);
        s1.attachAsset(s, drmmetadata);
    }

    public void acquireLicenseForWhitelist(String s, AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener, DRMMetadata drmmetadata)
    {
        acquireLicenseForWhitelist(s, abstractdrmlicenseeventlistener, drmmetadata, null);
    }

    public void acquireLicenseForWhitelist(String s, AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener, DRMMetadata drmmetadata, MoneyTrace moneytrace)
    {
        moneytrace = new WhitelistDrmWorkflow(clientState, authDelegate, context, httpClient, moneytrace);
        moneytrace.addEventListener(abstractdrmlicenseeventlistener);
        moneytrace.attachAsset(s, drmmetadata);
    }

    public void acquireLocalLicense(String s, AbstractDrmLicenseEventListener abstractdrmlicenseeventlistener)
    {
        LocalDrmWorkflow localdrmworkflow = new LocalDrmWorkflow(clientState, authDelegate, httpClient, context);
        localdrmworkflow.addEventListener(abstractdrmlicenseeventlistener);
        localdrmworkflow.attachAsset(s);
    }
}
