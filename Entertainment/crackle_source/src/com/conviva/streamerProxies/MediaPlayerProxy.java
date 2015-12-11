// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.conviva.streamerProxies;

import android.media.MediaPlayer;
import java.lang.reflect.Field;

// Referenced classes of package com.conviva.streamerProxies:
//            NativeStreamerProxy

public class MediaPlayerProxy extends NativeStreamerProxy
    implements android.media.MediaPlayer.OnBufferingUpdateListener
{

    private int _bufferingPercentage;
    private android.media.MediaPlayer.OnBufferingUpdateListener _onBufferingUpdateListenerOrig;

    public MediaPlayerProxy(Object obj)
        throws Exception
    {
        int i;
        i = 0;
        super();
        _onBufferingUpdateListenerOrig = null;
        _bufferingPercentage = 0;
        _mPlayer = (MediaPlayer)obj;
        if (_mPlayer == null) goto _L2; else goto _L1
_L1:
        Field afield[];
        int j;
        afield = android/media/MediaPlayer.getDeclaredFields();
        j = afield.length;
_L11:
        if (i >= j) goto _L4; else goto _L3
_L3:
        Field field = afield[i];
        Class class1 = field.getType();
        if (!android/media/MediaPlayer$OnErrorListener.equals(class1)) goto _L6; else goto _L5
_L5:
        field.setAccessible(true);
        _onErrorListenerOrig = (android.media.MediaPlayer.OnErrorListener)field.get(_mPlayer);
          goto _L7
_L6:
        if (!android/media/MediaPlayer$OnBufferingUpdateListener.equals(class1)) goto _L9; else goto _L8
_L8:
        field.setAccessible(true);
        _onBufferingUpdateListenerOrig = (android.media.MediaPlayer.OnBufferingUpdateListener)field.get(_mPlayer);
          goto _L7
_L2:
        return;
_L9:
        if (android/media/MediaPlayer$OnInfoListener.equals(class1))
        {
            field.setAccessible(true);
            _onInfoListenerOrig = (android.media.MediaPlayer.OnInfoListener)field.get(obj);
        }
        break; /* Loop/switch isn't completed */
_L4:
        try
        {
            _mPlayer.setOnErrorListener(this);
            _mPlayer.setOnBufferingUpdateListener(this);
            _mPlayer.setOnInfoListener(this);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            ((SecurityException) (obj)).printStackTrace();
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
            return;
        }
        if (true) goto _L2; else goto _L7
_L7:
        i++;
        if (true) goto _L11; else goto _L10
_L10:
    }

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
