// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.sdk.internal;

import com.google.a.d.e;
import com.rdio.android.core.RdioService_Api;
import com.rdio.android.core.remote.RemoteClientManager;
import com.rdio.android.core.util.Logging;

public class SdkRemoteClientManager extends RemoteClientManager
{

    private static final String TAG = "SdkRemoteClientManager";
    private final e eventBus;
    private boolean isPlaying;

    protected SdkRemoteClientManager(String s, RdioService_Api rdioservice_api, e e, Logging logging)
    {
        super(s, rdioservice_api, e, logging);
        eventBus = e;
    }

    protected int getPlayState()
    {
        return !isPlaying ? 0 : 1;
    }

    public com.rdio.android.core.remote.RemoteClientManager.Status getStatus()
    {
        return super.getStatus();
    }

    protected boolean isRemoteControllable()
    {
        return false;
    }

    protected void publishMasterPlayer()
    {
        super.publishMasterPlayer();
    }

    protected void publishMasterQuery()
    {
        super.publishMasterQuery();
    }

    protected void setPlayState(boolean flag)
    {
        isPlaying = flag;
    }
}
