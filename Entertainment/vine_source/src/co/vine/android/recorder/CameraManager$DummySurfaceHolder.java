// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.recorder;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.Surface;
import android.view.SurfaceHolder;

// Referenced classes of package co.vine.android.recorder:
//            CameraManager

private static class mSurface
    implements SurfaceHolder
{

    private final Surface mSurface;

    public void addCallback(android.view.rfaceHolder rfaceholder)
    {
    }

    public Surface getSurface()
    {
        return mSurface;
    }

    public Rect getSurfaceFrame()
    {
        return null;
    }

    public boolean isCreating()
    {
        return false;
    }

    public Canvas lockCanvas()
    {
        return null;
    }

    public Canvas lockCanvas(Rect rect)
    {
        return null;
    }

    public void removeCallback(android.view.rfaceHolder rfaceholder)
    {
    }

    public void setFixedSize(int i, int j)
    {
    }

    public void setFormat(int i)
    {
    }

    public void setKeepScreenOn(boolean flag)
    {
    }

    public void setSizeFromLayout()
    {
    }

    public void setType(int i)
    {
    }

    public void unlockCanvasAndPost(Canvas canvas)
    {
    }

    public (Surface surface)
    {
        mSurface = surface;
    }
}
