// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva;

import com.conviva.monitor.IMonitorNotifier;

public interface ConvivaStreamerProxy
{

    public abstract void Cleanup();

    public abstract int GetBufferLengthMs();

    public abstract int GetCapabilities();

    public abstract int GetMinBufferLengthMs();

    public abstract int GetPlayheadTimeMs();

    public abstract double GetRenderedFrameRate();

    public abstract int GetStartingBufferLengthMs();

    public abstract String GetStreamerType();

    public abstract String GetStreamerVersion();

    public abstract void startMonitoring(IMonitorNotifier imonitornotifier);
}
