// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.view.video.support;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

// Referenced classes of package com.facebook.ads.internal.view.video.support:
//            e, b, c

public class d extends TextureView
    implements android.media.MediaPlayer.OnBufferingUpdateListener, android.media.MediaPlayer.OnPreparedListener, android.view.TextureView.SurfaceTextureListener, e
{

    private static final String i = com/facebook/ads/internal/view/video/support/d.getSimpleName();
    private View a;
    private Uri b;
    private b c;
    private Surface d;
    private MediaPlayer e;
    private boolean f;
    private boolean g;
    private int h;

    public d(Context context)
    {
        super(context);
    }

    public void a(View view, Uri uri)
    {
        a = view;
        b = uri;
        setSurfaceTextureListener(this);
    }

    public int getCurrentPosition()
    {
        int j = 0;
        if (e != null)
        {
            j = e.getCurrentPosition();
        }
        return j;
    }

    public void onBufferingUpdate(MediaPlayer mediaplayer, int j)
    {
    }

    public void onPrepared(MediaPlayer mediaplayer)
    {
        if (c != null)
        {
            c.a(mediaplayer);
        }
        if (g)
        {
            mediaplayer.start();
            g = false;
        }
        if (h > 0)
        {
            if (h >= e.getDuration())
            {
                h = 0;
            }
            e.seekTo(h);
            h = 0;
        }
        f = true;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int j, int k)
    {
        d = new Surface(surfacetexture);
        if (e != null)
        {
            e.setSurface(d);
            return;
        }
        surfacetexture = new MediaPlayer();
        try
        {
            surfacetexture.setDataSource(getContext(), b);
            surfacetexture.setSurface(d);
            surfacetexture.setOnPreparedListener(this);
            surfacetexture.setOnInfoListener(new c(a));
            surfacetexture.setOnBufferingUpdateListener(this);
            surfacetexture.setLooping(false);
            surfacetexture.prepareAsync();
            e = surfacetexture;
            return;
        }
        catch (Exception exception)
        {
            surfacetexture.release();
            Log.e(i, (new StringBuilder()).append("Cannot prepare media player with SurfaceTexture: ").append(exception).toString());
            return;
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        pause();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int j, int k)
    {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }

    public void pause()
    {
        if (e != null)
        {
            h = e.getCurrentPosition();
            e.stop();
            e.reset();
            e.release();
        }
        e = null;
        f = false;
        g = false;
    }

    public void setFrameVideoViewListener(b b1)
    {
        c = b1;
    }

    public void start()
    {
        if (f)
        {
            e.start();
        } else
        {
            g = true;
        }
        if (isAvailable())
        {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }

}
