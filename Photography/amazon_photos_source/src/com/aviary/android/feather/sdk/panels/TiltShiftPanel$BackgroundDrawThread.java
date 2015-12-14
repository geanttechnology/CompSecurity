// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.aviary.android.feather.headless.filters.NativeToolFilter;
import com.aviary.android.feather.headless.moa.Moa;
import com.aviary.android.feather.library.vo.ToolActionVO;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            TiltShiftPanel

class init extends Thread
{

    running mCurrentQueue;
    final Queue mQueue = new LinkedBlockingQueue();
    volatile boolean running;
    boolean started;
    final TiltShiftPanel this$0;

    public void clear()
    {
        if (!running || mQueue == null) goto _L2; else goto _L1
_L1:
        Queue queue = mQueue;
        queue;
        JVM INSTR monitorenter ;
_L3:
        init init1;
        do
        {
            if (mQueue.size() <= 0)
            {
                break MISSING_BLOCK_LABEL_76;
            }
            init1 = (mQueue)mQueue.poll();
        } while (init1 == null);
        mLogger.mQueue("end element...");
        init1.mQueue();
          goto _L3
        Exception exception;
        exception;
        queue;
        JVM INSTR monitorexit ;
        throw exception;
        queue;
        JVM INSTR monitorexit ;
_L2:
    }

    public void draw(float af[], float f, float f1, float f2, float f3, float f4, float f5)
    {
        this;
        JVM INSTR monitorenter ;
        if (!running) goto _L2; else goto _L1
_L1:
        mQueue mqueue = mCurrentQueue;
        if (mqueue != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        mCurrentQueue.mCurrentQueue();
        mCurrentQueue.mCurrentQueue(new float[] {
            af[0], af[1], f, f1, f2, f3, f4, f5
        });
        if (true) goto _L2; else goto _L4
_L4:
        af;
        throw af;
    }

    public void drawStart(float af[], com.aviary.android.feather.sdk.widget.awMode awmode, float f, float f1, float f2, float f3, float f4, 
            float f5)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = running;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        Object obj;
        if (mCurrentQueue != null)
        {
            mCurrentQueue.mCurrentQueue();
            mCurrentQueue = null;
        }
        if (awmode != com.aviary.android.feather.sdk.widget.awMode.Radial)
        {
            break MISSING_BLOCK_LABEL_162;
        }
        obj = com.aviary.android.feather.headless.filters.l;
_L3:
        ToolActionVO toolactionvo;
        obj = new .Radial(((com.aviary.android.feather.headless.filters.l) (obj)));
        (() (obj)).(new float[] {
            af[0], af[1], f, f1, f2, f3, f4, f5
        });
        toolactionvo = mToolAction;
        if (awmode == com.aviary.android.feather.sdk.widget.awMode.Radial)
        {
            af = "circle";
        } else
        {
            af = "rectangle";
        }
        toolactionvo.setValue(af);
        mQueue.add(obj);
        mCurrentQueue = ((mCurrentQueue) (obj));
          goto _L1
        af;
        throw af;
        obj = com.aviary.android.feather.headless.filters.r;
          goto _L3
    }

    public void finish()
    {
        if (!running || mQueue == null) goto _L2; else goto _L1
_L1:
        Queue queue = mQueue;
        queue;
        JVM INSTR monitorenter ;
        Iterator iterator = mQueue.iterator();
_L4:
        .Linear linear;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_80;
            }
            linear = (mQueue)iterator.next();
        } while (linear == null);
        mLogger.mQueue("end element...");
        linear.mQueue();
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        queue;
        JVM INSTR monitorexit ;
        throw exception;
        queue;
        JVM INSTR monitorexit ;
_L2:
    }

    public int getQueueSize()
    {
        return mQueue.size();
    }

    void init()
    {
    }

    public boolean isCompleted()
    {
        return mQueue.size() == 0;
    }

    public void pathEnd()
    {
        this;
        JVM INSTR monitorenter ;
        if (!running) goto _L2; else goto _L1
_L1:
        mQueue mqueue = mCurrentQueue;
        if (mqueue != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        mCurrentQueue.mCurrentQueue();
        mCurrentQueue = null;
        if (true) goto _L2; else goto _L4
_L4:
        Exception exception;
        exception;
        throw exception;
    }

    public void quit()
    {
        this;
        JVM INSTR monitorenter ;
        started = true;
        running = false;
        interrupt();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void run()
    {
        while (!started) ;
        boolean flag = false;
        mLogger.started("thread.start!");
        mLogger.started("filter.init");
        TiltShiftPanel.access$200(TiltShiftPanel.this).init(mBitmap, mPreview);
        RectF rectf = new RectF(0.0F, 0.0F, mPreview.getWidth(), mPreview.getHeight());
        RectF rectf1 = new RectF();
label0:
        do
        {
            if (!running)
            {
                break;
            }
            if (mQueue.size() > 0 && !isInterrupted())
            {
                mLogger.isInterrupted((new StringBuilder()).append("queue.size: ").append(mQueue.size()).toString());
                boolean flag1 = flag;
                if (!flag)
                {
                    flag1 = true;
                    onProgressStart();
                }
                  = (mQueue)mQueue.element();
                if ( == null)
                {
                    mQueue.poll();
                    flag = flag1;
                    continue;
                }
                com.aviary.android.feather.headless.filters.upt upt = mQueue();
                TiltShiftPanel.access$200(TiltShiftPanel.this).setTiltShiftMode(upt);
                do
                {
                    if (.() <= 0 && .() || !running || isInterrupted())
                    {
                        mQueue.poll();
                        flag = flag1;
                        continue label0;
                    }
                    float af[] = (float[]).mQueue();
                    if (af != null)
                    {
                        float f = af[0];
                        float f1 = af[1];
                        float f2 = af[2];
                        float f3 = af[3];
                        float f4 = af[4];
                        float f5 = af[5];
                        float f6 = af[6];
                        float f7 = af[7];
                        TiltShiftPanel.access$200(TiltShiftPanel.this).draw(f2, f3, 0, false, new float[] {
                            f, f1
                        });
                        rectf1.set(f4, f5, f6, f7);
                        rectf.union(rectf1);
                        TiltShiftPanel.access$200(TiltShiftPanel.this).renderPreview(rectf);
                        rectf.set(rectf1);
                        Moa.notifyPixelsChanged(mPreview);
                    }
                } while (true);
            }
            if (flag)
            {
                onProgressEnd();
                flag = false;
            }
        } while (true);
        onProgressEnd();
        mLogger.("thread.end");
    }

    public void start()
    {
        this;
        JVM INSTR monitorenter ;
        started = true;
        running = true;
        super.start();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public awMode(String s, int i)
    {
        this$0 = TiltShiftPanel.this;
        super(s);
        setPriority(i);
        init();
    }
}
