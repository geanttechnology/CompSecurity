// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.remote;


public class RemoteClientStatusChangedEvent
{

    private final boolean isRemoteControllable;
    private final int playState;
    private final String playerName;
    private final RemoteClientManager.Status status;

    public RemoteClientStatusChangedEvent(RemoteClientManager.Status status1, String s, int i, boolean flag)
    {
        status = status1;
        playerName = s;
        playState = i;
        isRemoteControllable = flag;
    }

    public int getPlayState()
    {
        return playState;
    }

    public String getPlayerName()
    {
        return playerName;
    }

    public RemoteClientManager.Status getStatus()
    {
        return status;
    }

    public boolean isRemoteControllable()
    {
        return isRemoteControllable;
    }
}
