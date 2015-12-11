// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.activities;

import com.shazam.android.aspects.b.a.b;
import com.shazam.i.b.ap.a;
import com.shazam.model.configuration.RdioConfiguration;
import com.shazam.model.rdio.RdioConnectionState;

public class RdioReconnectionActivityAspect extends b
{

    private static final String RDIO_RECONNECTION_TAG = "rdioReconnectionTag";
    private final RdioConfiguration rdioConfiguration = com.shazam.i.b.n.b.h();
    private final RdioConnectionState rdioConnectionState = a.a();

    public RdioReconnectionActivityAspect()
    {
    }

    public void onResume(com.shazam.android.aspects.c.a.a a1)
    {
        if (rdioConfiguration.b() && rdioConnectionState.c())
        {
            (new com.shazam.android.fragment.c.a()).a(a1.getSupportFragmentManager(), "rdioReconnectionTag");
        }
    }
}
