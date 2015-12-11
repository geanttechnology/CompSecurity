// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.streamerProxies;

import com.conviva.ConvivaStreamerProxy;
import com.conviva.StreamerError;
import com.conviva.monitor.IMonitorNotifier;
import com.conviva.utils.PlatformUtils;
import com.conviva.utils.TLog;
import com.visualon.OSMPBasePlayer.voOSBasePlayer;
import com.visualon.OSMPUtils.voOSVideoPerformance;
import java.lang.reflect.Field;
import java.util.HashMap;

public class VisualOnProxy
    implements ConvivaStreamerProxy, com.visualon.OSMPBasePlayer.voOSBasePlayer.onEventListener
{

    private static final String TAG = "CONVIVA";
    private int _durationMs;
    private com.visualon.OSMPBasePlayer.voOSBasePlayer.onEventListener _iListenerOrig;
    private IMonitorNotifier _notifier;
    private voOSBasePlayer _streamer;
    protected PlatformUtils _utils;

    public VisualOnProxy(Object obj)
        throws Exception
    {
        _streamer = null;
        _durationMs = -1;
        _utils = null;
        _notifier = null;
        _iListenerOrig = null;
        _utils = PlatformUtils.getInstance();
        _streamer = (voOSBasePlayer)obj;
        if (_streamer == null) goto _L2; else goto _L1
_L1:
        int j;
        obj = com/visualon/OSMPBasePlayer/voOSBasePlayer.getDeclaredFields();
        j = obj.length;
        int i = 0;
_L7:
        if (i >= j) goto _L4; else goto _L3
_L3:
        Field field = obj[i];
        if (!com/visualon/OSMPBasePlayer/voOSBasePlayer$onEventListener.equals(field.getType())) goto _L6; else goto _L5
_L5:
        field.setAccessible(true);
        _iListenerOrig = (com.visualon.OSMPBasePlayer.voOSBasePlayer.onEventListener)field.get(_streamer);
_L4:
        _streamer.setEventListener(this);
_L2:
        return;
_L6:
        i++;
          goto _L7
        obj;
        TLog.i("CONVIVA", ((Exception) (obj)).toString());
          goto _L4
    }

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

    public int GetDroppedFrames()
    {
        voOSVideoPerformance voosvideoperformance = (voOSVideoPerformance)_streamer.GetParam(53);
        if (voosvideoperformance != null)
        {
            return voosvideoperformance.RenderDropNum();
        } else
        {
            return -1;
        }
    }

    public int GetIsLive()
    {
        return _streamer.GetDuration() != 0 ? -1 : 1;
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

    public String GetServerAddress()
    {
        return null;
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

    public void Log(String s)
    {
        if (_notifier != null)
        {
            _notifier.Log(s);
            return;
        } else
        {
            _utils.log(s);
            return;
        }
    }

    public int onEvent(int i, int j, int k, Object obj)
    {
        i;
        JVM INSTR lookupswitch 13: default 116
    //                   -2113929213: 138
    //                   -2113929212: 138
    //                   -2113929210: 138
    //                   -2113929209: 138
    //                   -2113929208: 138
    //                   -2113929207: 138
    //                   -2113929206: 138
    //                   -2113929203: 138
    //                   1: 243
    //                   3: 256
    //                   4: 270
    //                   33554444: 138
    //                   33554480: 162;
           goto _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L3 _L4 _L5 _L2 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_270;
_L7:
        StreamerError streamererror;
        if (_iListenerOrig != null)
        {
            return _iListenerOrig.onEvent(i, j, k, obj);
        } else
        {
            return 0;
        }
_L2:
        streamererror = StreamerError.makeUnscopedError(Integer.toString(i), 1);
        _notifier.OnError(streamererror);
          goto _L7
_L6:
        int l = _streamer.GetDuration();
        if (l != _durationMs)
        {
            _durationMs = l;
            HashMap hashmap = new HashMap();
            hashmap.put("duration", String.valueOf(l));
            _notifier.OnMetadata(hashmap);
        }
        if (j == 1)
        {
            _notifier.SetStream(k / 1000, null, null);
        }
          goto _L7
_L3:
        _notifier.SetPlayingState(1);
          goto _L7
_L4:
        _notifier.SetPlayingState(6);
          goto _L7
        if (((Integer)_streamer.GetParam(14)).intValue() == 3)
        {
            _notifier.SetPlayingState(12);
        } else
        {
            _notifier.SetPlayingState(3);
        }
          goto _L7
    }

    public void setMonitoringNotifier(IMonitorNotifier imonitornotifier)
    {
        _notifier = imonitornotifier;
    }
}
