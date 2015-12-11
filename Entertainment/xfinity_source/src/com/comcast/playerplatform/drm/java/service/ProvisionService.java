// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.service;

import com.comcast.playerplatform.drm.java.request.ClientSessionRequest;
import com.comcast.playerplatform.util.android.MoneyTrace;

public class ProvisionService
{

    private ClientSessionRequest clientSessionRequest;

    public void getXact()
    {
        getXact(null);
    }

    public void getXact(MoneyTrace moneytrace)
    {
        clientSessionRequest.getXactToken(moneytrace);
    }
}
