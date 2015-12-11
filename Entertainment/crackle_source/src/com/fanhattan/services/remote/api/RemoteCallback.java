// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.remote.api;


public interface RemoteCallback
{

    public abstract void onEnvironmentReport(int i, int j, int k, int l);

    public abstract void onRemoteBatteryLevelChanged(int i, int j);

    public abstract void onRemoteConnected(int i);

    public abstract void onRemoteDisconnected(int i);

    public abstract boolean onRemoteTouchEvent(int i, int j, float f, float f1, float f2, float f3, int k, 
            long l);
}
