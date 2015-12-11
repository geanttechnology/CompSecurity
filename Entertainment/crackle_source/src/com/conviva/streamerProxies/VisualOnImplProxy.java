// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.streamerProxies;

import com.conviva.ConvivaStreamerProxy;
import com.conviva.StreamerError;
import com.conviva.monitor.IMonitorNotifier;
import com.conviva.utils.PlatformUtils;
import com.conviva.utils.TLog;
import com.visualon.OSMPPlayer.VOCommonPlayerListener;
import com.visualon.OSMPPlayerImpl.VOCommonPlayerImpl;
import java.lang.reflect.Field;
import java.util.HashMap;

public class VisualOnImplProxy
    implements ConvivaStreamerProxy, VOCommonPlayerListener
{

    private static final String TAG = "CONVIVA";
    private int _durationMs;
    private VOCommonPlayerListener _iListenerOrig;
    private boolean _inListener;
    private IMonitorNotifier _notifier;
    private boolean _paused;
    private VOCommonPlayerImpl _streamer;
    protected PlatformUtils _utils;

    public VisualOnImplProxy(Object obj)
        throws Exception
    {
        int i;
        i = 0;
        super();
        _inListener = false;
        _streamer = null;
        _durationMs = -1;
        _utils = null;
        _notifier = null;
        _iListenerOrig = null;
        _paused = false;
        _utils = PlatformUtils.getInstance();
        _streamer = (VOCommonPlayerImpl)obj;
        if (_streamer == null) goto _L2; else goto _L1
_L1:
        int j;
        obj = com/visualon/OSMPPlayerImpl/VOCommonPlayerImpl.getDeclaredFields();
        j = obj.length;
_L7:
        if (i >= j) goto _L4; else goto _L3
_L3:
        Field field = obj[i];
        if (!com/visualon/OSMPPlayer/VOCommonPlayerListener.equals(field.getType())) goto _L6; else goto _L5
_L5:
        field.setAccessible(true);
        _iListenerOrig = (VOCommonPlayerListener)field.get(_streamer);
_L4:
        _streamer.setOnEventListener(this);
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

    public int GetDroppedFrames()
    {
        return -1;
    }

    public int GetIsLive()
    {
        return !_streamer.isLiveStreaming() ? -1 : 1;
    }

    public int GetMinBufferLengthMs()
    {
        return -1;
    }

    public int GetPlayheadTimeMs()
    {
        com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_STATUS vo_osmp_status;
        int j;
        if (_streamer == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        j = (int)_streamer.getPosition();
        vo_osmp_status = _streamer.getPlayerStatus();
        if (vo_osmp_status != com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PAUSED)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        _notifier.SetPlayingState(12);
        _paused = true;
        return j;
        int i;
        i = j;
        try
        {
            if (vo_osmp_status != com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PLAYING)
            {
                break MISSING_BLOCK_LABEL_89;
            }
        }
        catch (Exception exception)
        {
            return -1;
        }
        i = j;
        if (!_paused)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        _notifier.SetPlayingState(3);
        _paused = false;
        return j;
        i = -1;
        return i;
    }

    public double GetRenderedFrameRate()
    {
        return -1D;
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
        return _streamer.getVersion(com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_MODULE_TYPE.VO_OSMP_MODULE_TYPE_SDK);
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

    public com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_RETURN_CODE onVOEvent(com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID vo_osmp_cb_event_id, int i, int j, Object obj)
    {
        if (!_inListener && _streamer != null) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        static class _cls1
        {

            static final int $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[];

            static 
            {
                $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID = new int[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.values().length];
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_ADAPTIVE_STREAMING_ERROR.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_FAIL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_LOSS.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_REJECTED.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_CONNECTION_TIMEOUT.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DOWNLOAD_FAIL.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DRM_AV_OUT_FAIL.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DRM_FAIL.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_DRM_NOT_SECURE.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_PLAYLIST_PARSE_ERR.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_ADAPTIVE_STREAMING_INFO.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_PLAY_COMPLETE.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_SRC_CB_PD_BUFFERING_PERCENT.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_AUDIO_START_BUFFER.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_VIDEO_START_BUFFER.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_AUDIO_STOP_BUFFER.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_VIDEO_STOP_BUFFER.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$visualon$OSMPPlayer$VOCommonPlayerListener$VO_OSMP_CB_EVENT_ID[com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID.VO_OSMP_CB_VIDEO_RENDER_START.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_EVENT_ID[vo_osmp_cb_event_id.ordinal()];
        JVM INSTR tableswitch 1 18: default 112
    //                   1 146
    //                   2 146
    //                   3 146
    //                   4 146
    //                   5 146
    //                   6 146
    //                   7 146
    //                   8 146
    //                   9 146
    //                   10 146
    //                   11 170
    //                   12 257
    //                   13 270
    //                   14 290
    //                   15 290
    //                   16 304
    //                   17 304
    //                   18 370;
           goto _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L5 _L6 _L7 _L8 _L8 _L9 _L9 _L10
_L3:
        if (_iListenerOrig == null)
        {
            break; /* Loop/switch isn't completed */
        }
        _inListener = true;
        vo_osmp_cb_event_id = _iListenerOrig.onVOEvent(vo_osmp_cb_event_id, i, j, obj);
        _inListener = false;
        return vo_osmp_cb_event_id;
_L4:
        StreamerError streamererror = StreamerError.makeUnscopedError(vo_osmp_cb_event_id.toString(), 1);
        _notifier.OnError(streamererror);
        continue; /* Loop/switch isn't completed */
_L5:
        int k = (int)_streamer.getDuration();
        if (k != _durationMs)
        {
            _durationMs = k;
            HashMap hashmap = new HashMap();
            hashmap.put("duration", String.valueOf(k));
            _notifier.OnMetadata(hashmap);
        }
        if (i == com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_SRC_ADAPTIVE_STREAMING_INFO_EVENT.VO_OSMP_SRC_ADAPTIVE_STREAMING_INFO_EVENT_BITRATE_CHANGE.getValue())
        {
            _notifier.SetStream(j / 1000, null, null);
        }
        continue; /* Loop/switch isn't completed */
_L6:
        _notifier.SetPlayingState(1);
        continue; /* Loop/switch isn't completed */
_L7:
        if (i < 100)
        {
            _notifier.SetPlayingState(6);
        }
        continue; /* Loop/switch isn't completed */
_L8:
        _notifier.SetPlayingState(6);
        continue; /* Loop/switch isn't completed */
_L9:
        com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_STATUS vo_osmp_status = _streamer.getPlayerStatus();
        if (vo_osmp_status == com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PAUSED)
        {
            _notifier.SetPlayingState(12);
        } else
        if (vo_osmp_status == com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PLAYING)
        {
            _notifier.SetPlayingState(3);
        } else
        {
            _notifier.SetPlayingState(100);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        if (_durationMs == -1 || _durationMs == 0)
        {
            _durationMs = (int)_streamer.getDuration();
            if (_durationMs > 0)
            {
                HashMap hashmap1 = new HashMap();
                hashmap1.put("duration", String.valueOf(_durationMs));
                _notifier.OnMetadata(hashmap1);
            }
        }
        if (_streamer.getPlayerStatus() == com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PLAYING)
        {
            _notifier.SetPlayingState(3);
        }
        if (true) goto _L3; else goto _L11
_L11:
        if (true) goto _L1; else goto _L12
_L12:
        vo_osmp_cb_event_id;
        _inListener = false;
        throw vo_osmp_cb_event_id;
    }

    public com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_RETURN_CODE onVOSyncEvent(com.visualon.OSMPPlayer.VOCommonPlayerListener.VO_OSMP_CB_SYNC_EVENT_ID vo_osmp_cb_sync_event_id, int i, int j, Object obj)
    {
        while (_inListener || _iListenerOrig == null) 
        {
            return null;
        }
        _inListener = true;
        vo_osmp_cb_sync_event_id = _iListenerOrig.onVOSyncEvent(vo_osmp_cb_sync_event_id, i, j, obj);
        _inListener = false;
        return vo_osmp_cb_sync_event_id;
        vo_osmp_cb_sync_event_id;
        _inListener = false;
        throw vo_osmp_cb_sync_event_id;
    }

    public void setMonitoringNotifier(IMonitorNotifier imonitornotifier)
    {
        _notifier = imonitornotifier;
        if (_notifier != null && _streamer.getPlayerStatus() == com.visualon.OSMPPlayer.VOOSMPType.VO_OSMP_STATUS.VO_OSMP_STATUS_PLAYING)
        {
            _notifier.SetPlayingState(3);
        }
    }
}
