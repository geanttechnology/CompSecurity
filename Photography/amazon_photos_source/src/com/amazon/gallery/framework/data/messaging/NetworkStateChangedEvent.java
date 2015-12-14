// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.messaging;


public class NetworkStateChangedEvent
{

    private boolean connected;
    private boolean wan;

    public NetworkStateChangedEvent(boolean flag, boolean flag1)
    {
        connected = flag;
        wan = flag1;
    }

    public boolean isConnected()
    {
        return connected;
    }

    public boolean isWan()
    {
        return wan;
    }
}
