// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.imagelib.decorator.sprite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import bke;
import bkf;
import bkg;
import bkh;
import bkt;
import com.wantu.imagelib.decorator.TGifEleDecorator;
import java.util.List;

// Referenced classes of package com.wantu.imagelib.decorator.sprite:
//            GifTransformPanel

public class CanvasSurfaceView extends SurfaceView
    implements android.view.SurfaceHolder.Callback
{

    private bkf mCanvasThread;
    private SurfaceHolder mHolder;
    private boolean mSizeChanged;

    public CanvasSurfaceView(Context context)
    {
        super(context);
        mSizeChanged = true;
        init();
    }

    public CanvasSurfaceView(Context context, AttributeSet attributeset)
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
    }

    public void addGifDecortor(TGifEleDecorator tgifeledecorator)
    {
        mCanvasThread.a(tgifeledecorator);
    }

    public void changeCurSelectedSpriteGroupState(boolean flag)
    {
        mCanvasThread.a(flag);
    }

    public void changeFrameIndex(int i)
    {
        mCanvasThread.a(i);
    }

    public void clearEvent()
    {
        mCanvasThread.k();
    }

    public void cloneCurSelectedSprite()
    {
        mCanvasThread.d();
    }

    public List getPreviewFrames()
    {
        return mCanvasThread.a();
    }

    public List getResultFrames(int i)
    {
        return mCanvasThread.b(i);
    }

    public int getSpriteCount()
    {
        return mCanvasThread.e();
    }

    public SurfaceHolder getSurfaceHolder()
    {
        return mHolder;
    }

    public void hideCurSelectedSprite()
    {
        mCanvasThread.c();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mCanvasThread.j();
    }

    public void onPause()
    {
        mCanvasThread.h();
    }

    public void onResume()
    {
        mCanvasThread.i();
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        mCanvasThread.a(motionevent);
        return true;
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        mCanvasThread.b(flag);
    }

    public void removeCurSelectedSprite()
    {
        mCanvasThread.b();
    }

    public void setEvent(Runnable runnable)
    {
        mCanvasThread.a(runnable);
    }

    public void setRenderer(bkg bkg)
    {
        mCanvasThread = new bkf(this, mHolder, bkg);
        mCanvasThread.start();
    }

    public void setSpriteCallBack(bkt bkt)
    {
        mCanvasThread.a(bkt);
    }

    public void startRender(List list)
    {
        bkh bkh1 = new bkh();
        bkh1.a(new bke(list));
        bkh1.a(new GifTransformPanel(getContext()));
        setRenderer(bkh1);
    }

    protected void stopDrawing()
    {
        mCanvasThread.j();
    }

    public void surfaceChanged(SurfaceHolder surfaceholder, int i, int j, int k)
    {
        mCanvasThread.a(j, k);
    }

    public void surfaceCreated(SurfaceHolder surfaceholder)
    {
        if (mCanvasThread != null)
        {
            mCanvasThread.f();
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceholder)
    {
        if (mCanvasThread != null)
        {
            mCanvasThread.g();
        }
    }



/*
    public static boolean access$002(CanvasSurfaceView canvassurfaceview, boolean flag)
    {
        canvassurfaceview.mSizeChanged = flag;
        return flag;
    }

*/
}
