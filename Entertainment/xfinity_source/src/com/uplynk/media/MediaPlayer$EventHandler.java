// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.SurfaceHolder;

// Referenced classes of package com.uplynk.media:
//            MediaPlayer, CaptionManager

private class mMediaPlayer extends Handler
{

    private MediaPlayer mMediaPlayer;
    final MediaPlayer this$0;

    public void handleMessage(Message message)
    {
        if (MediaPlayer.access$0(mMediaPlayer) != 0) goto _L2; else goto _L1
_L1:
        Log.w("upLynkMediaPlayer", "mediaplayer went away with unhandled events");
_L4:
        return;
_L2:
        message.what;
        JVM INSTR lookupswitch 13: default 136
    //                   0: 18
    //                   1: 162
    //                   2: 189
    //                   3: 244
    //                   4: 275
    //                   5: 302
    //                   6: 402
    //                   7: 747
    //                   100: 511
    //                   200: 660
    //                   201: 738
    //                   400: 775
    //                   401: 1136;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16
_L16:
        continue; /* Loop/switch isn't completed */
_L3:
        Log.e("upLynkMediaPlayer", (new StringBuilder("Unknown message type ")).append(message.what).toString());
        return;
_L5:
        if (MediaPlayer.access$1(MediaPlayer.this) != null)
        {
            MediaPlayer.access$1(MediaPlayer.this).onPrepared(mMediaPlayer);
            return;
        }
          goto _L4
_L6:
        if (MediaPlayer.access$2(MediaPlayer.this) != null)
        {
            MediaPlayer.access$2(MediaPlayer.this).onCompletion(mMediaPlayer);
        }
        MediaPlayer.access$3(MediaPlayer.this, false);
        if (MediaPlayer.access$4(MediaPlayer.this) != null)
        {
            MediaPlayer.access$4(MediaPlayer.this).reset();
            return;
        }
          goto _L4
_L7:
        if (MediaPlayer.access$5(MediaPlayer.this) != null)
        {
            MediaPlayer.access$5(MediaPlayer.this).onBufferingUpdate(mMediaPlayer, message.arg1);
            return;
        }
          goto _L4
_L8:
        if (MediaPlayer.access$6(MediaPlayer.this) != null)
        {
            MediaPlayer.access$6(MediaPlayer.this).onSeekComplete(mMediaPlayer);
            return;
        }
          goto _L4
_L9:
        if (MediaPlayer.access$7(MediaPlayer.this) != null)
        {
            MediaPlayer.access$7(MediaPlayer.this).onVideoSizeChanged(mMediaPlayer, message.arg1, message.arg2);
        }
        Log.i("upLynkMediaPlayer", (new StringBuilder("Video Resolution Changed: ")).append(message.arg1).append("x").append(message.arg2).toString());
        if (MediaPlayer.access$4(MediaPlayer.this) != null)
        {
            MediaPlayer.access$4(MediaPlayer.this).setVideoSize(message.arg1, message.arg2);
            return;
        }
          goto _L4
_L10:
        if (MediaPlayer.access$8() && MediaPlayer.access$9(MediaPlayer.this) != null)
        {
            Log.i("upLynkMediaPlayer", (new StringBuilder("Setting window to fixed size of ")).append(message.arg1).append("x").append(message.arg2).toString());
            MediaPlayer.access$9(MediaPlayer.this).setFixedSize(message.arg1, message.arg2);
        }
        Log.i("upLynkMediaPlayer", String.format("Video Window Size Changed: %dx%d", new Object[] {
            Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)
        }));
        return;
_L12:
        Log.e("upLynkMediaPlayer", (new StringBuilder("Error (")).append(message.arg1).append(",").append(message.arg2).append(")").toString());
        boolean flag = false;
        if (MediaPlayer.access$10(MediaPlayer.this) != null)
        {
            flag = MediaPlayer.access$10(MediaPlayer.this).onError(mMediaPlayer, message.arg1, message.arg2);
        }
        if (MediaPlayer.access$2(MediaPlayer.this) != null && !flag)
        {
            MediaPlayer.access$2(MediaPlayer.this).onCompletion(mMediaPlayer);
        }
        MediaPlayer.access$3(MediaPlayer.this, false);
        if (MediaPlayer.access$4(MediaPlayer.this) != null)
        {
            MediaPlayer.access$4(MediaPlayer.this).reset();
        }
        MediaPlayer.access$11(MediaPlayer.this, false);
        return;
_L13:
        Log.i("upLynkMediaPlayer", (new StringBuilder("Info (")).append(message.arg1).append(",").append(message.arg2).append(")").toString());
        if (MediaPlayer.access$12(MediaPlayer.this) != null)
        {
            MediaPlayer.access$12(MediaPlayer.this).onInfo(mMediaPlayer, message.arg1, message.arg2);
            return;
        }
          goto _L4
_L14:
        MediaPlayer.access$11(MediaPlayer.this, true);
        return;
_L11:
        if (MediaPlayer.access$13(MediaPlayer.this) != null)
        {
            MediaPlayer.access$13(MediaPlayer.this).onAssetBoundary(mMediaPlayer, null);
            return;
        }
          goto _L4
_L15:
        message = MediaPlayer.access$14(MediaPlayer.this);
        if (message == null) goto _L4; else goto _L17
_L17:
        String as[] = message.split("_");
        if (as.length != 3) goto _L4; else goto _L18
_L18:
        String s = as[0];
        if (s == null || s.length() != 32) goto _L20; else goto _L19
_L19:
        int i;
        if (MediaPlayer.access$15(MediaPlayer.this) == null || !s.equals(MediaPlayer.access$15(MediaPlayer.this)))
        {
            MediaPlayer.access$16(MediaPlayer.this, s);
            if (MediaPlayer.access$4(MediaPlayer.this) != null)
            {
                MediaPlayer.access$4(MediaPlayer.this).clearDisplay(true);
            }
            if (MediaPlayer.access$13(MediaPlayer.this) != null)
            {
                MediaPlayer.access$13(MediaPlayer.this).onAssetBoundary(mMediaPlayer, s);
            }
        }
        if (MediaPlayer.access$17(MediaPlayer.this) != null && MediaPlayer.access$17(MediaPlayer.this)._assetID.equals(s))
        {
            continue; /* Loop/switch isn't completed */
        }
        message = MediaPlayer.access$18(MediaPlayer.this, s);
        i = 0;
_L24:
        if (message == null && i < 15) goto _L22; else goto _L21
_L21:
        if (message != null)
        {
            message = new fo(MediaPlayer.this, message);
            Object obj = MediaPlayer.this;
            InterruptedException interruptedexception;
            if (!((fo) (message))._isValid)
            {
                message = null;
            }
            MediaPlayer.access$19(((MediaPlayer) (obj)), message);
        } else
        {
            MediaPlayer.access$19(MediaPlayer.this, null);
        }
        if (MediaPlayer.access$20(MediaPlayer.this) == null) goto _L4; else goto _L23
_L23:
        message = new a(MediaPlayer.this, as);
        if (MediaPlayer.access$17(MediaPlayer.this) != null)
        {
            message._assetInfo = MediaPlayer.access$17(MediaPlayer.this);
        }
        MediaPlayer.access$20(MediaPlayer.this).onUplynkMetadata(mMediaPlayer, message);
        return;
_L22:
        Log.d("upLynkMediaPlayer", "AssetInfo not yet available, sleeping");
        Thread.sleep(150L);
        obj = MediaPlayer.access$18(MediaPlayer.this, s);
        message = ((Message) (obj));
        i++;
          goto _L24
        interruptedexception;
        interruptedexception.printStackTrace();
          goto _L24
_L20:
        Log.w("upLynkMediaPlayer", (new StringBuilder("Invalid Metadata: ")).append(message).toString());
        return;
        if (MediaPlayer.access$21(MediaPlayer.this) == null) goto _L4; else goto _L25
_L25:
        MediaPlayer.access$21(MediaPlayer.this).onID3Metadata(mMediaPlayer, (mMediaPlayer)message.obj);
        return;
    }

    public Listener(MediaPlayer mediaplayer1, Looper looper)
    {
        this$0 = MediaPlayer.this;
        super(looper);
        mMediaPlayer = mediaplayer1;
    }
}
