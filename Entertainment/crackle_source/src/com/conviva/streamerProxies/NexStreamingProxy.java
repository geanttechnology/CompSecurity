// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.streamerProxies;

import com.conviva.ConvivaStreamerProxy;
import com.conviva.StreamerError;
import com.conviva.monitor.IMonitorNotifier;
import com.conviva.utils.PlatformUtils;
import com.conviva.utils.TLog;
import com.nexstreaming.nexplayerengine.NexClosedCaption;
import com.nexstreaming.nexplayerengine.NexContentInformation;
import com.nexstreaming.nexplayerengine.NexID3TagInformation;
import com.nexstreaming.nexplayerengine.NexPictureTimingInfo;
import com.nexstreaming.nexplayerengine.NexPlayer;
import com.nexstreaming.nexplayerengine.NexStreamInformation;
import com.nexstreaming.nexplayerengine.NexTrackInformation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class NexStreamingProxy
    implements ConvivaStreamerProxy, com.nexstreaming.nexplayerengine.NexPlayer.IListener
{

    private static final String TAG = "CONVIVA";
    private int _bitrate;
    private com.nexstreaming.nexplayerengine.NexPlayer.IListener _iListenerOrig;
    private IMonitorNotifier _notifier;
    private int _playheadSec;
    private NexPlayer _streamer;
    private PlatformUtils _utils;

    public NexStreamingProxy(Object obj)
        throws Exception
    {
        _streamer = null;
        _utils = null;
        _notifier = null;
        _iListenerOrig = null;
        _bitrate = -1;
        _playheadSec = 0;
        _streamer = (NexPlayer)obj;
        if (_streamer == null)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        int j;
        obj = com/nexstreaming/nexplayerengine/NexPlayer.getDeclaredFields();
        j = obj.length;
        int i = 0;
_L2:
        Field field;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        field = obj[i];
        if (com/nexstreaming/nexplayerengine/NexPlayer$IListener.equals(field.getType()))
        {
            field.setAccessible(true);
            _iListenerOrig = (com.nexstreaming.nexplayerengine.NexPlayer.IListener)field.get(_streamer);
        }
        i++;
        if (true) goto _L2; else goto _L1
        obj;
        TLog.i("CONVIVA", (new StringBuilder()).append("Cannot create NexPlayerProxy: ").append(((Exception) (obj)).toString()).toString());
_L1:
        _streamer.setListener(this);
        _utils = PlatformUtils.getInstance();
        return;
    }

    private void updateBitrate()
    {
        NexContentInformation nexcontentinformation;
        int k;
        int i1;
        k = -1;
        i1 = -1;
        nexcontentinformation = _streamer.getContentInfo();
        if (nexcontentinformation != null && nexcontentinformation.mArrStreamInformation != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int l;
        int j1;
        NexStreamInformation anexstreaminformation[] = nexcontentinformation.mArrStreamInformation;
        int i3 = anexstreaminformation.length;
        int i = 0;
        j1 = -1;
        l = -1;
        while (i < i3) 
        {
            NexStreamInformation nexstreaminformation = anexstreaminformation[i];
            int k1 = j1;
            int l1 = l;
            if (nexstreaminformation.mType == 1)
            {
                k1 = j1;
                l1 = l;
                if (nexstreaminformation.mCurrTrackID != -1)
                {
                    NexTrackInformation anextrackinformation[] = nexstreaminformation.mArrTrackInformation;
                    int k2 = anextrackinformation.length;
                    int i2 = 0;
                    do
                    {
                        k1 = j1;
                        l1 = l;
                        if (i2 >= k2)
                        {
                            break;
                        }
                        NexTrackInformation nextrackinformation = anextrackinformation[i2];
                        if (nexstreaminformation.mCurrTrackID == nextrackinformation.mTrackID)
                        {
                            j1 = nextrackinformation.mTrackID;
                            l = nextrackinformation.mBandWidth;
                        }
                        i2++;
                    } while (true);
                }
            }
            int j2 = i1;
            int l2 = k;
            if (nexstreaminformation.mType == 0)
            {
                j2 = i1;
                l2 = k;
                if (nexstreaminformation.mCurrTrackID != -1)
                {
                    NexTrackInformation anextrackinformation1[] = nexstreaminformation.mArrTrackInformation;
                    j1 = anextrackinformation1.length;
                    l = 0;
                    do
                    {
                        j2 = i1;
                        l2 = k;
                        if (l >= j1)
                        {
                            break;
                        }
                        NexTrackInformation nextrackinformation1 = anextrackinformation1[l];
                        if (nexstreaminformation.mCurrTrackID == nextrackinformation1.mTrackID)
                        {
                            i1 = nextrackinformation1.mTrackID;
                            k = nextrackinformation1.mBandWidth;
                        }
                        l++;
                    } while (true);
                }
            }
            i++;
            j1 = k1;
            l = l1;
            i1 = j2;
            k = l2;
        }
        if (j1 == -1 || i1 != -1) goto _L4; else goto _L3
_L3:
        int j = l;
_L5:
        if (j != 0)
        {
            j /= 1000;
        } else
        {
            j = 0;
        }
        if (j != _bitrate)
        {
            _notifier.SetStream(j, null, null);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        if (j1 == -1 && i1 != -1)
        {
            j = k;
        } else
        if (j1 != -1 && i1 != -1)
        {
            j = l;
            if (j1 != i1)
            {
                j = l + k;
            }
        } else
        if (j1 == -1 && i1 == -1)
        {
            j = 0;
        } else
        {
            j = -1;
        }
          goto _L5
    }

    private void updatePlayerState()
    {
        if (_streamer != null && _notifier != null && _streamer.getState() == 3)
        {
            _notifier.SetPlayingState(3);
        }
    }

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

    public int GetDroppedFrames()
    {
        return -1;
    }

    public int GetIsLive()
    {
        return 0;
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
        if (_streamer.getState() == 3)
        {
            return (double)_streamer.getContentInfoInt(5);
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

    public void onAsyncCmdComplete(NexPlayer nexplayer, int i, int j, int k, int l)
    {
        i;
        JVM INSTR tableswitch 1 9: default 52
    //                   1 76
    //                   2 76
    //                   3 242
    //                   4 52
    //                   5 52
    //                   6 52
    //                   7 52
    //                   8 203
    //                   9 222;
           goto _L1 _L2 _L2 _L3 _L1 _L1 _L1 _L1 _L4 _L5
_L1:
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onAsyncCmdComplete(nexplayer, i, j, k, l);
        }
        return;
_L2:
        if (j != 0)
        {
            onError(nexplayer, com.nexstreaming.nexplayerengine.NexPlayer.NexErrorCode.fromIntegerValue(j));
        } else
        {
            int i1 = nexplayer.getContentInfoInt(1);
            int j1 = nexplayer.getContentInfoInt(5);
            Log((new StringBuilder()).append("onAsyncCmdComplete(): OPEN duration (ms) = ").append(i1).append(", frameRate = ").append(j1).toString());
            HashMap hashmap = new HashMap();
            if (i1 > 0)
            {
                hashmap.put("duration", Integer.toString(i1));
            }
            if (j1 > 0)
            {
                hashmap.put("framerate", Integer.toString(j1));
            }
            _notifier.OnMetadata(hashmap);
        }
        continue; /* Loop/switch isn't completed */
_L4:
        _notifier.SetPlayingState(1);
        Log("onAsyncCmdComplete(): STOPPED");
        continue; /* Loop/switch isn't completed */
_L5:
        _notifier.SetPlayingState(12);
        Log("onAsyncCmdComplete(): PAUSED");
        continue; /* Loop/switch isn't completed */
_L3:
        _notifier.SetPlayingState(3);
        Log("onAsyncCmdComplete(): PLAYING");
        if (true) goto _L1; else goto _L6
_L6:
    }

    public void onAudioRenderCreate(NexPlayer nexplayer, int i, int j)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onAudioRenderCreate(nexplayer, i, j);
        }
    }

    public void onAudioRenderDelete(NexPlayer nexplayer)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onAudioRenderDelete(nexplayer);
        }
    }

    public void onAudioRenderPrepared(NexPlayer nexplayer)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onAudioRenderPrepared(nexplayer);
        }
    }

    public void onBuffering(NexPlayer nexplayer, int i)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onBuffering(nexplayer, i);
        }
    }

    public void onBufferingBegin(NexPlayer nexplayer)
    {
        _notifier.SetPlayingState(6);
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onBufferingBegin(nexplayer);
        }
    }

    public void onBufferingEnd(NexPlayer nexplayer)
    {
        updatePlayerState();
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onBufferingEnd(nexplayer);
        }
    }

    public void onDataInactivityTimeOut(NexPlayer nexplayer)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onDataInactivityTimeOut(nexplayer);
        }
    }

    public void onDownloaderAsyncCmdComplete(NexPlayer nexplayer, int i, int j, int k)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onDownloaderAsyncCmdComplete(nexplayer, i, j, k);
        }
    }

    public void onDownloaderError(NexPlayer nexplayer, int i, int j)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onDownloaderError(nexplayer, i, j);
        }
    }

    public void onDownloaderEventBegin(NexPlayer nexplayer, int i, int j)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onDownloaderEventBegin(nexplayer, i, j);
        }
    }

    public void onDownloaderEventComplete(NexPlayer nexplayer, int i)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onDownloaderEventComplete(nexplayer, i);
        }
    }

    public void onDownloaderEventProgress(NexPlayer nexplayer, int i, int j, long l, long l1)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onDownloaderEventProgress(nexplayer, i, j, l, l1);
        }
    }

    public void onDownloaderEventState(NexPlayer nexplayer, int i, int j)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onDownloaderEventState(nexplayer, i, j);
        }
    }

    public void onEndOfContent(NexPlayer nexplayer)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onEndOfContent(nexplayer);
        }
    }

    public void onError(NexPlayer nexplayer, com.nexstreaming.nexplayerengine.NexPlayer.NexErrorCode nexerrorcode)
    {
        Log((new StringBuilder()).append("Proxy: onError (errorCode: ").append(nexerrorcode).append(")").toString());
        StreamerError streamererror = StreamerError.makeUnscopedError(nexerrorcode.name(), 1);
        _notifier.OnError(streamererror);
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onError(nexplayer, nexerrorcode);
        }
    }

    public void onHTTPRequest(NexPlayer nexplayer, String s)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onHTTPRequest(nexplayer, s);
        }
    }

    public void onHTTPResponse(NexPlayer nexplayer, String s)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onHTTPResponse(nexplayer, s);
        }
    }

    public String onModifyHttpRequest(NexPlayer nexplayer, int i, Object obj)
    {
        if (_iListenerOrig != null)
        {
            return _iListenerOrig.onModifyHttpRequest(nexplayer, i, obj);
        } else
        {
            return null;
        }
    }

    public void onPauseSupervisionTimeOut(NexPlayer nexplayer)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onPauseSupervisionTimeOut(nexplayer);
        }
    }

    public void onPictureTimingInfo(NexPlayer nexplayer, NexPictureTimingInfo anexpicturetiminginfo[])
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onPictureTimingInfo(nexplayer, anexpicturetiminginfo);
        }
    }

    public void onProgramTime(NexPlayer nexplayer, String s, int i)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onProgramTime(nexplayer, s, i);
        }
    }

    public void onRTSPCommandTimeOut(NexPlayer nexplayer)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onRTSPCommandTimeOut(nexplayer);
        }
    }

    public void onRecording(NexPlayer nexplayer, int i, int j)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onRecording(nexplayer, i, j);
        }
    }

    public void onRecordingEnd(NexPlayer nexplayer, int i)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onRecordingEnd(nexplayer, i);
        }
    }

    public void onRecordingErr(NexPlayer nexplayer, int i)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onRecordingErr(nexplayer, i);
        }
    }

    public void onSignalStatusChanged(NexPlayer nexplayer, int i, int j)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onSignalStatusChanged(nexplayer, i, j);
        }
    }

    public void onStartAudioTask(NexPlayer nexplayer)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onStartAudioTask(nexplayer);
        }
    }

    public void onStartVideoTask(NexPlayer nexplayer)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onStartVideoTask(nexplayer);
        }
    }

    public void onStateChanged(NexPlayer nexplayer, int i, int j)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onStateChanged(nexplayer, i, j);
        }
    }

    public void onStatusReport(NexPlayer nexplayer, int i, int j)
    {
        updateBitrate();
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onStatusReport(nexplayer, i, j);
        }
    }

    public void onTextRenderInit(NexPlayer nexplayer, int i)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onTextRenderInit(nexplayer, i);
        }
    }

    public void onTextRenderRender(NexPlayer nexplayer, int i, NexClosedCaption nexclosedcaption)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onTextRenderRender(nexplayer, i, nexclosedcaption);
        }
    }

    public void onTime(NexPlayer nexplayer, int i)
    {
        _playheadSec = i;
        updatePlayerState();
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onTime(nexplayer, i);
        }
    }

    public void onTimedMetaRenderRender(NexPlayer nexplayer, NexID3TagInformation nexid3taginformation)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onTimedMetaRenderRender(nexplayer, nexid3taginformation);
        }
    }

    public void onTimeshift(NexPlayer nexplayer, int i, int j)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onTimeshift(nexplayer, i, j);
        }
    }

    public void onTimeshiftErr(NexPlayer nexplayer, int i)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onTimeshiftErr(nexplayer, i);
        }
    }

    public void onVideoRenderCapture(NexPlayer nexplayer, int i, int j, int k, Object obj)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onVideoRenderCapture(nexplayer, i, j, k, obj);
        }
    }

    public void onVideoRenderCreate(NexPlayer nexplayer, int i, int j, Object obj)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onVideoRenderCreate(nexplayer, i, j, obj);
        }
    }

    public void onVideoRenderDelete(NexPlayer nexplayer)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onVideoRenderDelete(nexplayer);
        }
    }

    public void onVideoRenderPrepared(NexPlayer nexplayer)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onVideoRenderPrepared(nexplayer);
        }
    }

    public void onVideoRenderRender(NexPlayer nexplayer)
    {
        if (_iListenerOrig != null)
        {
            _iListenerOrig.onVideoRenderRender(nexplayer);
        }
    }

    public void setMonitoringNotifier(IMonitorNotifier imonitornotifier)
    {
        _notifier = imonitornotifier;
        updatePlayerState();
    }
}
