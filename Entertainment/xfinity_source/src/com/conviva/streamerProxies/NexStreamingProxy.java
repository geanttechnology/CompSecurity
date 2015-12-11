// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.streamerProxies;

import com.conviva.ConvivaStreamerProxy;
import com.conviva.monitor.IMonitorNotifier;
import com.conviva.utils.PlatformUtils;
import com.nexstreaming.nexplayerengine.NexPlayer;

public class NexStreamingProxy
    implements ConvivaStreamerProxy, com.nexstreaming.nexplayerengine.NexPlayer.IListener
{

    private com.nexstreaming.nexplayerengine.NexPlayer.IListener _iListenerOrig;
    private IMonitorNotifier _notifier;
    private int _playheadSec;
    private NexPlayer _streamer;
    private PlatformUtils _utils;

    public void Cleanup()
    {
        _streamer.setListener(_iListenerOrig);
        _iListenerOrig = null;
        _streamer = null;
        _notifier = null;
        _utils = null;
    }

    public int GetBufferLengthMs()
    {
        return _streamer.getContentInfoInt(7);
    }

    public int GetCapabilities()
    {
        return 7;
    }

    public int GetMinBufferLengthMs()
    {
        return _streamer.getProperty(com.nexstreaming.nexplayerengine.NexPlayer.NexProperty.RE_BUFFERING_DURATION);
    }

    public int GetPlayheadTimeMs()
    {
        return _playheadSec;
    }

    public double GetRenderedFrameRate()
    {
        return (double)_streamer.getContentInfoInt(5);
    }

    public int GetStartingBufferLengthMs()
    {
        return _streamer.getProperty(com.nexstreaming.nexplayerengine.NexPlayer.NexProperty.INITIAL_BUFFERING_DURATION);
    }

    public String GetStreamerType()
    {
        return "NexPlayer";
    }

    public String GetStreamerVersion()
    {
        return (new StringBuilder()).append(_streamer.getVersion(0)).append(".").append(_streamer.getVersion(1)).toString();
    }

    public void startMonitoring(IMonitorNotifier imonitornotifier)
    {
        _notifier = imonitornotifier;
    }
}
