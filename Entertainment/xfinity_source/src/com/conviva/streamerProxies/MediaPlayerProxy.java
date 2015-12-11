// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.streamerProxies;

import android.media.MediaPlayer;

// Referenced classes of package com.conviva.streamerProxies:
//            NativeStreamerProxy

public class MediaPlayerProxy extends NativeStreamerProxy
    implements android.media.MediaPlayer.OnBufferingUpdateListener
{

    private int _bufferingPercentage;
    private android.media.MediaPlayer.OnBufferingUpdateListener _onBufferingUpdateListenerOrig;

    public void Cleanup()
    {
        Log("MediaPlayerStreamerProxy.Cleanup()");
        if (_mPlayer != null)
        {
            _mPlayer.setOnBufferingUpdateListener(_onBufferingUpdateListenerOrig);
        }
        _onBufferingUpdateListenerOrig = null;
        super.Cleanup();
    }

    public int GetBufferLengthMs()
    {
        int j = -1;
        int i = j;
        try
        {
            if (_mPlayer == null)
            {
                break MISSING_BLOCK_LABEL_48;
            }
        }
        catch (IllegalStateException illegalstateexception)
        {
            Log("player is not in the proper state when GetBufferLengthMs() is called");
            return -1;
        }
        i = j;
        if (_duration <= 0)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        i = (int)((double)(_duration * _bufferingPercentage) / 100D);
        j = _mPlayer.getCurrentPosition();
        i -= j;
        return i;
    }

    public String GetStreamerType()
    {
        return "MediaPlay";
    }

    public void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        _bufferingPercentage = i;
        if (_onBufferingUpdateListenerOrig != null)
        {
            _onBufferingUpdateListenerOrig.onBufferingUpdate(mediaplayer, i);
        }
    }
}
