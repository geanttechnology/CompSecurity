// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.uplynk.media;

import android.graphics.Rect;
import android.util.Log;
import android.view.SurfaceHolder;

// Referenced classes of package com.uplynk.media:
//            MediaPlayer

private class <init>
    implements android.view.ner
{

    final MediaPlayer this$0;

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        Log.v("upLynkMediaPlayer", (new StringBuilder("SurfaceListener::surfaceChanged() ")).append(j).append("x").append(k).toString());
        MediaPlayer.access$22(MediaPlayer.this, 0, 0, j, k);
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        Log.v("upLynkMediaPlayer", "SurfaceListener::surfaceCreated()");
        Rect rect = surfaceholder.getSurfaceFrame();
        MediaPlayer.access$23(MediaPlayer.this, surfaceholder.getSurface(), rect.left, rect.top, rect.right, rect.bottom);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        Log.v("upLynkMediaPlayer", "SurfaceListener::surfaceDestroyed()");
        if (MediaPlayer.access$0(MediaPlayer.this) != 0)
        {
            try
            {
                MediaPlayer.access$23(MediaPlayer.this, null, 0, 0, 0, 0);
                if (MediaPlayer.access$9(MediaPlayer.this) != null)
                {
                    Log.i("upLynkMediaPlayer", "Display Surface Destroyed - Unlinking SurfaceHolder from Player");
                    MediaPlayer.access$9(MediaPlayer.this).removeCallback(MediaPlayer.access$24(MediaPlayer.this));
                    MediaPlayer.access$25(MediaPlayer.this, null);
                    return;
                }
            }
            // Misplaced declaration of an exception variable
            catch (SurfaceHolder surfaceholder)
            {
                Log.v("upLynkMediaPlayer", "Ignoring IllegalStateException on _setSurface(null,0,0,0,0)");
                return;
            }
        }
    }

    public void surfaceRedrawNeeded(SurfaceHolder surfaceholder)
    {
        Log.v("upLynkMediaPlayer", "SurfaceListener::surfaceRedrawNeeded()");
    }

    private ()
    {
        this$0 = MediaPlayer.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
