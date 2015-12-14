// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.util;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import java.io.FileInputStream;

public final class MediaUtil
{
    public static abstract class MediaHandler extends Handler
        implements android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener
    {

        public static final int ASYNCERROR = -2;
        public static final int COMPLETE = 0;
        public static final int ERROR = -1;

        public void handleMessage(Message message)
        {
            if (message.what == 0)
            {
                onPlaybackComplete();
                return;
            } else
            {
                onPlaybackError();
                return;
            }
        }

        public void onCompletion(MediaPlayer mediaplayer1)
        {
            sendEmptyMessage(0);
        }

        public boolean onError(MediaPlayer mediaplayer1, int i, int j)
        {
            sendEmptyMessage(-2);
            return true;
        }

        public void onPlaybackComplete()
        {
        }

        public void onPlaybackError()
        {
        }

        public MediaHandler()
        {
        }
    }


    private static MediaPlayer mediaplayer;

    private MediaUtil()
    {
    }

    public static final int getPosition()
    {
        if (mediaplayer == null)
        {
            return 0;
        } else
        {
            return getPosition(mediaplayer);
        }
    }

    protected static final int getPosition(MediaPlayer mediaplayer1)
    {
        if (mediaplayer1 == null)
        {
            return 0;
        } else
        {
            return mediaplayer1.getCurrentPosition();
        }
    }

    public static final void loadAndPlayMedia(String s, MediaHandler mediahandler)
    {
        loadMedia(s, mediahandler);
        playMedia();
    }

    protected static final void loadMedia(MediaPlayer mediaplayer1, String s, MediaHandler mediahandler)
    {
        if (mediaplayer1 != null && s != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if (mediahandler != null)
        {
            mediaplayer1.setOnCompletionListener(mediahandler);
            mediaplayer1.setOnErrorListener(mediahandler);
        }
        if (!s.startsWith("file://"))
        {
            break MISSING_BLOCK_LABEL_69;
        }
        mediaplayer1.setDataSource((new FileInputStream(s.substring(7))).getFD());
_L4:
        mediaplayer1.prepare();
        return;
        mediaplayer1;
        if (mediahandler == null) goto _L1; else goto _L3
_L3:
        mediahandler.sendEmptyMessage(-1);
        return;
        mediaplayer1.setDataSource(s);
          goto _L4
    }

    public static final void loadMedia(String s, MediaHandler mediahandler)
    {
        if (s == null)
        {
            return;
        }
        if (mediaplayer != null)
        {
            stopMedia();
        }
        mediaplayer = new MediaPlayer();
        loadMedia(mediaplayer, s, mediahandler);
    }

    public static final int pauseMedia()
    {
        if (mediaplayer == null)
        {
            return -1;
        } else
        {
            return pauseMedia(mediaplayer);
        }
    }

    protected static final int pauseMedia(MediaPlayer mediaplayer1)
    {
        if (mediaplayer1 == null)
        {
            return -1;
        } else
        {
            mediaplayer1.pause();
            return mediaplayer1.getCurrentPosition();
        }
    }

    public static final void playMedia()
    {
        if (mediaplayer == null)
        {
            return;
        } else
        {
            playMedia(mediaplayer);
            return;
        }
    }

    public static final void playMedia(int i)
    {
        if (mediaplayer == null)
        {
            return;
        } else
        {
            mediaplayer.seekTo(i);
            playMedia(mediaplayer);
            return;
        }
    }

    protected static final void playMedia(MediaPlayer mediaplayer1)
    {
        if (mediaplayer1 == null)
        {
            return;
        } else
        {
            mediaplayer1.start();
            return;
        }
    }

    public static final void setVolume(float f)
    {
        if (mediaplayer == null)
        {
            return;
        } else
        {
            mediaplayer.setVolume(f, f);
            return;
        }
    }

    public static final void stopMedia()
    {
        if (mediaplayer == null)
        {
            return;
        } else
        {
            stopMedia(mediaplayer);
            mediaplayer = null;
            return;
        }
    }

    protected static final void stopMedia(MediaPlayer mediaplayer1)
    {
        if (mediaplayer1 == null)
        {
            return;
        } else
        {
            mediaplayer1.stop();
            mediaplayer1.reset();
            return;
        }
    }
}
