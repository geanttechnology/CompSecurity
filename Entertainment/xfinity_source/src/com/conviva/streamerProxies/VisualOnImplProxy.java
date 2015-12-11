// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.streamerProxies;

import com.conviva.ConvivaStreamerProxy;
import com.conviva.monitor.IMonitorNotifier;
import com.visualon.OSMPPlayer.VOCommonPlayerListener;
import com.visualon.OSMPPlayerImpl.VOCommonPlayerImpl;

public class VisualOnImplProxy
    implements ConvivaStreamerProxy, VOCommonPlayerListener
{

    private VOCommonPlayerListener _iListenerOrig;
    private IMonitorNotifier _notifier;
    private VOCommonPlayerImpl _streamer;

    public void Cleanup()
    {
        _streamer.setOnEventListener(_iListenerOrig);
        _iListenerOrig = null;
        _streamer = null;
        _notifier = null;
    }

    public int GetBufferLengthMs()
    {
        return -1;
    }

    public int GetCapabilities()
    {
        return 7;
    }

    public int GetMinBufferLengthMs()
    {
        return -1;
    }

    public int GetPlayheadTimeMs()
    {
label0:
        {
            int i;
            try
            {
                if (_streamer == null)
                {
                    break label0;
                }
                i = (int)_streamer.getPosition();
                if (_streamer.getPlayerStatus() == com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PAUSED)
                {
                    _notifier.SetPlayingState(12);
                }
            }
            catch (Exception exception)
            {
                return -1;
            }
            return i;
        }
        return -1;
    }

    public double GetRenderedFrameRate()
    {
        return -1D;
    }

    public int GetStartingBufferLengthMs()
    {
        return -1;
    }

    public String GetStreamerType()
    {
        return "VisualOn";
    }

    public String GetStreamerVersion()
    {
        return _streamer.getVersion(com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_MODULE_TYPE.VO_OSMP_MODULE_TYPE_SDK);
    }

    public void startMonitoring(IMonitorNotifier imonitornotifier)
    {
        _notifier = imonitornotifier;
    }
}
