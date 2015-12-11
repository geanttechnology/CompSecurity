// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.apps.youtube.kids.activities;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import java.io.IOException;
import yk;
import yl;
import ym;

public class ScalingVideoView extends TextureView
    implements android.view.TextureView.SurfaceTextureListener
{

    android.media.MediaPlayer.OnCompletionListener a;
    private MediaPlayer b;
    private AssetFileDescriptor c;
    private Surface d;
    private float e;
    private float f;
    private final String g;
    private int h;
    private android.media.MediaPlayer.OnVideoSizeChangedListener i;
    private android.media.MediaPlayer.OnPreparedListener j;
    private android.media.MediaPlayer.OnCompletionListener k;

    public ScalingVideoView(Context context)
    {
        super(context);
        g = com/google/android/apps/youtube/kids/activities/ScalingVideoView.getSimpleName();
        i = new yk(this);
        j = new yl(this);
        k = new ym(this);
        c();
    }

    public ScalingVideoView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        g = com/google/android/apps/youtube/kids/activities/ScalingVideoView.getSimpleName();
        i = new yk(this);
        j = new yl(this);
        k = new ym(this);
        c();
    }

    public ScalingVideoView(Context context, AttributeSet attributeset, int l)
    {
        super(context, attributeset, l);
        g = com/google/android/apps/youtube/kids/activities/ScalingVideoView.getSimpleName();
        i = new yk(this);
        j = new yl(this);
        k = new ym(this);
        c();
    }

    public static float a(ScalingVideoView scalingvideoview, float f1)
    {
        scalingvideoview.e = f1;
        return f1;
    }

    public static int a(ScalingVideoView scalingvideoview, int l)
    {
        scalingvideoview.h = l;
        return l;
    }

    public static void a(ScalingVideoView scalingvideoview)
    {
        scalingvideoview.f();
    }

    public static float b(ScalingVideoView scalingvideoview, float f1)
    {
        scalingvideoview.f = f1;
        return f1;
    }

    public static android.media.MediaPlayer.OnPreparedListener b(ScalingVideoView scalingvideoview)
    {
        return null;
    }

    public static int c(ScalingVideoView scalingvideoview)
    {
        return scalingvideoview.h;
    }

    private void c()
    {
        h = 1;
        setSurfaceTextureListener(this);
    }

    public static android.media.MediaPlayer.OnCompletionListener d(ScalingVideoView scalingvideoview)
    {
        return scalingvideoview.a;
    }

    private boolean d()
    {
        return b != null && h != 1 && h != 2 && h != 3;
    }

    private void e()
    {
        if (c == null || d == null)
        {
            return;
        }
        g();
        if (b == null)
        {
            b = new MediaPlayer();
        } else
        {
            b.reset();
        }
        try
        {
            b.setDataSource(c.getFileDescriptor(), c.getStartOffset(), c.getLength());
        }
        catch (IOException ioexception)
        {
            Log.e(g, ioexception.getMessage());
        }
        b.setSurface(d);
        b.setOnVideoSizeChangedListener(i);
        b.setOnPreparedListener(j);
        b.setOnCompletionListener(k);
        b.prepareAsync();
        if (h == 3 || d())
        {
            h = 4;
            return;
        } else
        {
            h = 2;
            return;
        }
    }

    private void f()
    {
        float f2 = 1.0F;
        float f1 = getWidth();
        float f5 = getHeight();
        float f3 = f1 / 2.0F;
        float f4 = f5 / 2.0F;
        Matrix matrix;
        if (f1 / f5 > f / e)
        {
            f1 = (f1 / f) * (e / f5);
        } else
        {
            f2 = f5 / e;
            f2 = (f / f1) * f2;
            f1 = 1.0F;
        }
        matrix = new Matrix();
        matrix.setScale(f2, f1, f3, f4);
        setTransform(matrix);
        setScaleX(1.00001F);
    }

    private void g()
    {
        if (b != null)
        {
            b.reset();
            b.release();
            b = null;
        }
    }

    public final void a()
    {
        if (d())
        {
            if (!b.isPlaying())
            {
                b.start();
            }
            h = 5;
            return;
        }
        if (h == 2)
        {
            h = 4;
            e();
            return;
        } else
        {
            h = 3;
            return;
        }
    }

    public final void a(AssetFileDescriptor assetfiledescriptor)
    {
        c = assetfiledescriptor;
        e();
    }

    public final void b()
    {
        if (d() && b.isPlaying())
        {
            b.pause();
            h = 6;
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfacetexture, int l, int i1)
    {
        d = new Surface(surfacetexture);
        e();
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfacetexture)
    {
        d = null;
        h = 1;
        g();
        return false;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfacetexture, int l, int i1)
    {
        f();
        e();
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfacetexture)
    {
    }
}
