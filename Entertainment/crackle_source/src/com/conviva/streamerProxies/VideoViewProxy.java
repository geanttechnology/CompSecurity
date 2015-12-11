// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.streamerProxies;

import android.media.MediaPlayer;
import android.widget.VideoView;
import com.conviva.monitor.IMonitorNotifier;
import java.lang.reflect.Field;
import java.util.HashMap;

// Referenced classes of package com.conviva.streamerProxies:
//            NativeStreamerProxy

public class VideoViewProxy extends NativeStreamerProxy
    implements android.media.MediaPlayer.OnPreparedListener
{

    private VideoView _mVideoView;
    private android.media.MediaPlayer.OnPreparedListener _onPreparedListenerOrig;

    public VideoViewProxy(Object obj)
        throws Exception
    {
        _mVideoView = null;
        _onPreparedListenerOrig = null;
        _mVideoView = (VideoView)obj;
        if (_mVideoView == null)
        {
            return;
        }
        int j;
        obj = android/widget/VideoView.getDeclaredFields();
        j = obj.length;
        int i = 0;
_L2:
        Field field;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        field = obj[i];
        Class class1;
        String s;
        class1 = field.getType();
        s = field.getName();
        if (android/media/MediaPlayer$OnErrorListener.equals(class1) && s.startsWith("mOn"))
        {
            field.setAccessible(true);
            _onErrorListenerOrig = (android.media.MediaPlayer.OnErrorListener)field.get(_mVideoView);
            break MISSING_BLOCK_LABEL_185;
        }
        if (android/media/MediaPlayer$OnPreparedListener.equals(class1) && s.startsWith("mOn"))
        {
            field.setAccessible(true);
            _onPreparedListenerOrig = (android.media.MediaPlayer.OnPreparedListener)field.get(_mVideoView);
        }
        break MISSING_BLOCK_LABEL_185;
        try
        {
            _mVideoView.setOnErrorListener(this);
            _mVideoView.setOnPreparedListener(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((SecurityException) (obj)).printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IllegalArgumentException) (obj)).printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((IllegalAccessException) (obj)).printStackTrace();
        }
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void Cleanup()
    {
        Log("VideoViewStreamerProxy.Cleanup()");
        if (_mVideoView != null)
        {
            _mVideoView.setOnErrorListener(_onErrorListenerOrig);
            _mVideoView.setOnPreparedListener(_onPreparedListenerOrig);
        }
        super.Cleanup();
    }

    public int GetBufferLengthMs()
    {
        double d;
        double d1;
        int i;
        if (_mVideoView == null || _duration <= 0)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        d = (double)_mVideoView.getBufferPercentage() / 100D;
        d1 = _duration;
        i = _mVideoView.getCurrentPosition();
        return (int)(d * d1 - (double)i);
        IllegalStateException illegalstateexception;
        illegalstateexception;
        return -1;
    }

    public int GetPlayheadTimeMs()
    {
        int i;
        if (_mVideoView == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        i = _mVideoView.getCurrentPosition();
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        if (_duration == -1)
        {
            _duration = _mVideoView.getDuration();
            HashMap hashmap = new HashMap();
            hashmap.put("duration", String.valueOf(_duration));
            _notifier.OnMetadata(hashmap);
        }
        return i;
        IllegalStateException illegalstateexception;
        illegalstateexception;
        return -1;
    }

    public String GetStreamerType()
    {
        return "VideoView";
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        if (!_inListener) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Log("VideoViewProxy: onPrepared");
        if (_onPreparedListenerOrig == null)
        {
            break MISSING_BLOCK_LABEL_41;
        }
        _inListener = true;
        _onPreparedListenerOrig.onPrepared(mediaplayer);
        _inListener = false;
        _mPlayer = mediaplayer;
        Field field;
        int i;
        int j;
        try
        {
            mediaplayer = android/media/MediaPlayer.getDeclaredFields();
            j = mediaplayer.length;
        }
        // Misplaced declaration of an exception variable
        catch (MediaPlayer mediaplayer)
        {
            mediaplayer.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediaPlayer mediaplayer)
        {
            mediaplayer.printStackTrace();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MediaPlayer mediaplayer)
        {
            mediaplayer.printStackTrace();
            return;
        }
        for (i = 0; i >= j; i++)
        {
            continue; /* Loop/switch isn't completed */
        }

        field = mediaplayer[i];
        if (android/media/MediaPlayer$OnInfoListener.equals(field.getType()))
        {
            field.setAccessible(true);
            _onInfoListenerOrig = (android.media.MediaPlayer.OnInfoListener)field.get(_mPlayer);
            _mPlayer.setOnInfoListener(this);
            return;
        }
        break MISSING_BLOCK_LABEL_123;
        mediaplayer;
        _inListener = false;
        throw mediaplayer;
        if (true) goto _L1; else goto _L3
_L3:
    }
}
