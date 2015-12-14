// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.messaging;


public class PowerConnectionStateChanged
{

    private boolean connected;

    public PowerConnectionStateChanged(boolean flag)
    {
        connected = flag;
    }

    public boolean isConnected()
    {
        return connected;
    }
}
