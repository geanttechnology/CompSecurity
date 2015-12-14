// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.decorator.sprite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import bkd;
import bkk;
import bkl;
import bkt;
import java.util.List;

public class ImageCanvasSurfaceView extends SurfaceView
    implements android.view.SurfaceHolder.Callback
{

    private bkk mCanvasThread;
    private SurfaceHolder mHolder;
    private boolean mSizeChanged;

    public ImageCanvasSurfaceView(Context context)
    {
        super(context);
        mSizeChanged = true;
        init();
    }

    public ImageCanvasSurfaceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSizeChanged = true;
        init();
    }

    private void init()
    {
        mHolder = getHolder();
        mHolder.addCallback(this);
        mHolder.setType(0);
        mHolder.setFormat(-3);
    }

    public void addGifDecortor(bkd bkd, Matrix matrix, Matrix matrix1, Matrix matrix2)
    {
        mCanvasThread.a(bkd, matrix, matrix1, matrix2);
    }

    public void clearEvent()
    {
        mCanvasThread.o();
    }

    public void clearSprite()
    {
        mCanvasThread.b();
    }

    public void cloneCurSelectedSprite()
    {
        mCanvasThread.f();
    }

    public Bitmap getResultBitmap()
    {
        return mCanvasThread.a();
    }

    public List getSprite()
    {
        return mCanvasThread.c();
    }

    public int getSpriteCount()
    {
        return mCanvasThread.g();
    }

    public SurfaceHolder getSurfaceHolder()
    {
        return mHolder;
    }

    public void hideCurSelectedSprite()
    {
        mCanvasThread.e();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mCanvasThread.n();
    }

    public void onHide()
    {
        mCanvasThread.m();
    }

    public void onPause()
    {
        mCanvasThread.j();
    }

    public void onResume()
    {
        mCanvasThread.k();
    }

    public void onShow()
    {
        mCanvasThread.l();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        mCanvasThread.a(motionevent);
        return true;
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        mCanvasThread.a(flag);
    }

    public void removeCurSelectedSprite()
    {
        mCanvasThread.d();
    }

    public void replaceCurrentSpriteWithImage(Bitmap bitmap)
    {
        mCanvasThread.a(bitmap);
    }

    public void setBackgroundBitmap(int i, Bitmap bitmap, int j, int k, int l)
    {
        mCanvasThread.a(i, bitmap, j, k, l);
    }

    public void setEvent(Runnable runnable)
    {
        mCanvasThread.a(runnable);
    }

    public void setForeGroundBitmap(Bitmap bitmap, int i, int j)
    {
        mCanvasThread.a(bitmap, i, j);
    }

    public void setRenderer(bkl bkl1)
    {
        mCanvasThread = new bkk(this, mHolder, bkl1);
        mCanvasThread.start();
    }

    public void setSpriteCallBack(bkt bkt)
    {
        mCanvasThread.a(bkt);
    }

    public void startRender()
    {
        setRenderer(new bkl());
    }

    protected void stopDrawing()
    {
        mCanvasThread.n();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        mCanvasThread.a(j, k);
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        if (mCanvasThread != null)
        {
            mCanvasThread.h();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        if (mCanvasThread != null)
        {
            mCanvasThread.i();
        }
    }



/*
    public static boolean access$002(ImageCanvasSurfaceView imagecanvassurfaceview, boolean flag)
    {
        imagecanvassurfaceview.mSizeChanged = flag;
        return flag;
    }

*/
}
