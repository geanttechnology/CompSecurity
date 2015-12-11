// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.Surface;
import android.view.SurfaceHolder;
import java.util.Map;

public final class cjr
    implements android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnCompletionListener, android.media.MediaPlayer.OnErrorListener, android.media.MediaPlayer.OnInfoListener, android.media.MediaPlayer.OnPreparedListener, android.media.MediaPlayer.OnSeekCompleteListener, android.media.MediaPlayer.OnVideoSizeChangedListener, cjv
{

    private cjw a;
    private MediaPlayer b;

    public cjr()
    {
        b = new MediaPlayer();
        b.setOnPreparedListener(this);
        b.setOnVideoSizeChangedListener(this);
        b.setOnBufferingUpdateListener(this);
        b.setOnSeekCompleteListener(this);
        b.setOnCompletionListener(this);
        b.setOnErrorListener(this);
        b.setOnInfoListener(this);
    }

    public final void a()
    {
        b.prepareAsync();
    }

    public final void a(float f1, float f2)
    {
        b.setVolume(f1, f2);
    }

    public final void a(int i)
    {
        b.seekTo(i);
    }

    public final void a(Context context, Uri uri, Map map)
    {
        b.setDataSource(context, uri, map);
    }

    public final void a(Surface surface)
    {
        b.setSurface(surface);
    }

    public final void a(SurfaceHolder surfaceholder)
    {
        b.setDisplay(surfaceholder);
    }

    public final void a(cjw cjw1)
    {
        a = cjw1;
    }

    public final void b()
    {
        b.start();
    }

    public final void b(int i)
    {
        b.setAudioStreamType(3);
    }

    public final void c()
    {
        b.pause();
    }

    public final void d()
    {
        b.release();
    }

    public final int e()
    {
        return b.getCurrentPosition();
    }

    public final int f()
    {
        return b.getDuration();
    }

    public final void onBufferingUpdate(MediaPlayer mediaplayer, int i)
    {
        if (a != null)
        {
            a.a(i);
        }
    }

    public final void onCompletion(MediaPlayer mediaplayer)
    {
        if (a != null)
        {
            a.d();
        }
    }

    public final boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        if (a != null)
        {
            return a.a(i, j);
        } else
        {
            return false;
        }
    }

    public final boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        if (a != null)
        {
            return a.b(i, j);
        } else
        {
            return false;
        }
    }

    public final void onPrepared(MediaPlayer mediaplayer)
    {
        if (a != null)
        {
            a.a(this);
        }
    }

    public final void onSeekComplete(MediaPlayer mediaplayer)
    {
        if (a != null)
        {
            a.e();
        }
    }

    public final void onVideoSizeChanged(MediaPlayer mediaplayer, int i, int j)
    {
        if (a != null)
        {
            a.a(this, i, j);
        }
    }
}
