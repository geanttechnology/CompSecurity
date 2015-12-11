// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.streamerProxies;

import com.conviva.ConvivaStreamerProxy;
import com.conviva.monitor.IMonitorNotifier;
import com.visualon.OSMPBasePlayer.voOSBasePlayer;
import com.visualon.OSMPUtils.voOSVideoPerformance;

public class VisualOnProxy
    implements ConvivaStreamerProxy, com.visualon.OSMPBasePlayer.voOSBasePlayer.onEventListener
{

    private com.visualon.OSMPBasePlayer.voOSBasePlayer.onEventListener _iListenerOrig;
    private IMonitorNotifier _notifier;
    private voOSBasePlayer _streamer;

    public void Cleanup()
    {
        _streamer.setEventListener(_iListenerOrig);
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
                i = _streamer.GetPos();
                if (((Integer)_streamer.GetParam(14)).intValue() == 3)
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
        voOSVideoPerformance voosvideoperformance = (voOSVideoPerformance)_streamer.GetParam(53);
        if (voosvideoperformance != null)
        {
            return 1000D / (double)voosvideoperformance.AverageRenderTime();
        } else
        {
            return -1D;
        }
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
        return null;
    }

    public void startMonitoring(IMonitorNotifier imonitornotifier)
    {
        _notifier = imonitornotifier;
    }
}
