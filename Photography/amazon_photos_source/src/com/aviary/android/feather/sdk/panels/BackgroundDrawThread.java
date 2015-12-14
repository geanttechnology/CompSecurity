// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.headless.filters.MoaJavaToolStrokeResult;
import com.aviary.android.feather.headless.filters.NativeToolFilter;
import com.aviary.android.feather.headless.moa.Moa;
import com.aviary.android.feather.headless.moa.MoaStrokeParameter;
import com.aviary.android.feather.library.utils.ArrayUtils;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

final class BackgroundDrawThread extends Thread
{
    static class DrawQueue extends LinkedBlockingQueue
    {

        private static final long serialVersionUID = 1L;
        private volatile boolean completed;
        private com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode mode;
        private float radius;
        private PointF startPoint;

        public void end()
        {
            completed = true;
        }

        public com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode getMode()
        {
            return mode;
        }

        public PointF getOriginalPoint()
        {
            return startPoint;
        }

        public float getRadius()
        {
            return radius;
        }

        public boolean isCompleted()
        {
            return completed;
        }

        public DrawQueue(com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode brushmode, float f, float af[])
        {
            mode = brushmode;
            radius = f;
            completed = false;
            startPoint = new PointF();
            if (af != null && af.length >= 2)
            {
                startPoint.x = af[0];
                startPoint.y = af[1];
            }
            add(af);
        }
    }


    public static final int PREVIEW_INITIALIZED = 1000;
    static com.aviary.android.feather.common.log.LoggerFactory.Logger logger;
    private double brushMultiplier;
    private NativeToolFilter filter;
    private Handler handler;
    private DrawQueue mCurrentQueue;
    private final PointF mLastPoint = new PointF();
    SoftReference mPreviewBitmap;
    private final Queue mQueue = new LinkedBlockingQueue();
    private boolean mRegisterStrokeInitParams;
    SoftReference mSourceBitmap;
    private volatile boolean running;
    private boolean singleTapAllowed;
    private boolean started;

    public BackgroundDrawThread(String s, int i, NativeToolFilter nativetoolfilter, Handler handler1, double d)
    {
        super(s);
        filter = nativetoolfilter;
        handler = handler1;
        brushMultiplier = d;
        setPriority(i);
        init();
    }

    public void clear()
    {
        logger.info("clear");
        if (!running || mQueue == null) goto _L2; else goto _L1
_L1:
        Queue queue = mQueue;
        queue;
        JVM INSTR monitorenter ;
_L3:
        DrawQueue drawqueue;
        do
        {
            if (mQueue.size() <= 0)
            {
                break MISSING_BLOCK_LABEL_82;
            }
            drawqueue = (DrawQueue)mQueue.poll();
        } while (drawqueue == null);
        logger.log("end element...");
        drawqueue.end();
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

    public void finish()
    {
        logger.info("finish");
        if (!running || mQueue == null) goto _L2; else goto _L1
_L1:
        Queue queue = mQueue;
        queue;
        JVM INSTR monitorenter ;
        Iterator iterator = mQueue.iterator();
_L4:
        DrawQueue drawqueue;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_86;
            }
            drawqueue = (DrawQueue)iterator.next();
        } while (drawqueue == null);
        logger.log("end element...");
        drawqueue.end();
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

    void getLerp(PointF pointf, PointF pointf1, float f, PointF pointf2)
    {
        pointf2.set(pointf.x + (pointf1.x - pointf.x) * f, pointf.y + (pointf1.y - pointf.y) * f);
    }

    public int getQueueSize()
    {
        return mQueue.size();
    }

    public void init()
    {
    }

    public boolean isCompleted()
    {
        return mQueue.size() == 0;
    }

    public boolean isInterrupted()
    {
        if (!running)
        {
            return true;
        } else
        {
            return super.isInterrupted();
        }
    }

    public void lineTo(float af[])
    {
        if (!running || mCurrentQueue == null)
        {
            return;
        }
        float f = PointF.length(Math.abs(mLastPoint.x - af[0]), Math.abs(mLastPoint.y - af[1]));
        if (f > 10F)
        {
            mLastPoint.set(af[0], af[1]);
            mCurrentQueue.add(af);
            return;
        } else
        {
            logger.warn((new StringBuilder()).append("skipping point, too close... ").append(f).toString());
            return;
        }
    }

    public void moveTo(float af[])
    {
        if (!running || mCurrentQueue == null)
        {
            return;
        } else
        {
            mLastPoint.set(af[0], af[1]);
            mCurrentQueue.add(af);
            return;
        }
    }

    public void pathEnd()
    {
        this;
        JVM INSTR monitorenter ;
        if (!running) goto _L2; else goto _L1
_L1:
        DrawQueue drawqueue = mCurrentQueue;
        if (drawqueue != null) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        logger.info("pathEnd");
        if (!singleTapAllowed) goto _L5; else goto _L4
_L4:
        mCurrentQueue.add(new float[] {
            mLastPoint.x, mLastPoint.y
        });
_L6:
        mCurrentQueue.end();
        mCurrentQueue = null;
          goto _L2
        Exception exception;
        exception;
        throw exception;
_L5:
label0:
        {
            if (mLastPoint.equals(mCurrentQueue.getOriginalPoint()))
            {
                break label0;
            }
            logger.log("adding tail");
            mCurrentQueue.add(new float[] {
                mLastPoint.x, mLastPoint.y
            });
        }
          goto _L6
        logger.log("skipping tail");
          goto _L6
    }

    public void pathStart(float f, float af[], com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode brushmode)
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
        logger.info("pathStart");
        if (mCurrentQueue != null)
        {
            mCurrentQueue.end();
            mCurrentQueue = null;
        }
        mLastPoint.set(af[0], af[1]);
        af = new DrawQueue(brushmode, f, af);
        mQueue.add(af);
        mCurrentQueue = af;
        if (true) goto _L1; else goto _L3
_L3:
        af;
        throw af;
    }

    public void quit()
    {
        this;
        JVM INSTR monitorenter ;
        logger.info("quit");
        started = true;
        running = false;
        filter = null;
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
        MoaJavaToolStrokeResult moajavatoolstrokeresult;
        Bitmap bitmap1;
        float af1[];
        Rect rect;
        int i;
label0:
        {
            while (!started) ;
            boolean flag = false;
            Object obj = null;
            rect = new Rect();
            Bitmap bitmap;
            Bitmap bitmap2;
            Object obj1;
            Object obj2;
            if (mRegisterStrokeInitParams)
            {
                moajavatoolstrokeresult = new MoaJavaToolStrokeResult();
            } else
            {
                moajavatoolstrokeresult = null;
            }
            logger.log("thread.start!");
            obj2 = null;
            obj1 = null;
            bitmap1 = obj2;
            af1 = obj;
            i = ((flag) ? 1 : 0);
            if (filter == null)
            {
                break label0;
            }
            bitmap1 = obj2;
            af1 = obj;
            i = ((flag) ? 1 : 0);
            if (isInterrupted())
            {
                break label0;
            }
            bitmap1 = obj2;
            af1 = obj;
            i = ((flag) ? 1 : 0);
            if (mSourceBitmap == null)
            {
                break label0;
            }
            bitmap2 = (Bitmap)mSourceBitmap.get();
            if (mPreviewBitmap != null)
            {
                bitmap = (Bitmap)mPreviewBitmap.get();
            } else
            {
                bitmap = null;
            }
            bitmap1 = obj2;
            af1 = obj;
            i = ((flag) ? 1 : 0);
            if (bitmap2 == null)
            {
                break label0;
            }
            bitmap1 = obj2;
            af1 = obj;
            i = ((flag) ? 1 : 0);
            if (bitmap2.isRecycled())
            {
                break label0;
            }
            if (bitmap != null)
            {
                bitmap1 = obj2;
                af1 = obj;
                i = ((flag) ? 1 : 0);
                if (bitmap.isRecycled())
                {
                    break label0;
                }
            }
            filter.init(bitmap2, bitmap);
            if (bitmap == null)
            {
                bitmap = obj1;
                if (bitmap2 != null)
                {
                    bitmap = bitmap2;
                }
            }
            if (filter != null && !isInterrupted())
            {
                filter.renderPreview();
            }
            bitmap1 = bitmap;
            af1 = obj;
            i = ((flag) ? 1 : 0);
            if (handler != null)
            {
                bitmap1 = bitmap;
                af1 = obj;
                i = ((flag) ? 1 : 0);
                if (!isInterrupted())
                {
                    Moa.notifyPixelsChanged(bitmap);
                    handler.sendEmptyMessage(12);
                    handler.sendEmptyMessage(1000);
                    i = ((flag) ? 1 : 0);
                    af1 = obj;
                    bitmap1 = bitmap;
                }
            }
        }
_L6:
        float f;
        DrawQueue drawqueue;
        com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode brushmode;
        MoaStrokeParameter moastrokeparameter;
        ArrayList arraylist;
        int j;
        boolean flag1;
        int k;
label1:
        {
            if (!isInterrupted())
            {
                if (!isInterrupted())
                {
                    break label1;
                }
                logger.log("isInterrupted:true");
            }
            logger.log((new StringBuilder()).append("exiting while isInterrupted: ").append(isInterrupted()).toString());
            if (handler != null && !isInterrupted())
            {
                handler.sendEmptyMessage(5);
            }
            handler = null;
            logger.log("exiting thread...");
            return;
        }
        if (mQueue.size() <= 0 || isInterrupted())
        {
            break MISSING_BLOCK_LABEL_1605;
        }
        logger.log((new StringBuilder()).append("queue.size: ").append(mQueue.size()).toString());
        j = i;
        if (i == 0)
        {
            i = 1;
            j = i;
            if (handler != null)
            {
                handler.sendEmptyMessage(4);
                j = i;
            }
        }
        flag1 = true;
        drawqueue = (DrawQueue)mQueue.element();
        if (drawqueue == null)
        {
            mQueue.poll();
            i = j;
            continue; /* Loop/switch isn't completed */
        }
        f = drawqueue.getRadius();
        logger.log("radius: %.2f", new Object[] {
            Float.valueOf(f)
        });
        brushmode = drawqueue.getMode();
        moastrokeparameter = new MoaStrokeParameter(brushmode, f);
        arraylist = new ArrayList();
        k = 0;
_L2:
        while (drawqueue.size() <= 0 && drawqueue.isCompleted() || isInterrupted() || filter == null) 
        {
            if (filter != null && !isInterrupted())
            {
                filter.addStrokeData(moastrokeparameter);
            }
            mQueue.poll();
            i = j;
            continue; /* Loop/switch isn't completed */
        }
        float af[] = (float[])drawqueue.poll();
        if (af == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        int l = 0;
        rect.set((int)((double)af[0] - (double)f * brushMultiplier), (int)((double)af[1] - (double)f * brushMultiplier), (int)((double)af[0] + (double)f * brushMultiplier), (int)((double)af[1] + (double)f * brushMultiplier));
        moastrokeparameter.addPoint(af);
        arraylist.add(Float.valueOf(af[0]));
        arraylist.add(Float.valueOf(af[1]));
        if (filter != null && !isInterrupted())
        {
            filter.setBrushMode(brushmode);
            filter.drawStart(f, 0.0D, rect.centerX(), rect.centerY(), moajavatoolstrokeresult);
            if (moajavatoolstrokeresult != null)
            {
                logger.log("strokeResult: %s", new Object[] {
                    moajavatoolstrokeresult
                });
                moastrokeparameter.setInitParams(moajavatoolstrokeresult);
            }
            if (filter != null)
            {
                filter.renderPreview(rect);
            }
        }
        double d;
        float f1;
        float f2;
        NativeToolFilter nativetoolfilter;
        int i1;
        int j1;
        int k1;
        boolean flag2;
        if (handler != null && !isInterrupted())
        {
            Moa.notifyPixelsChanged(bitmap1);
            handler.sendEmptyMessage(12);
            i = 2;
        } else
        {
            i = 2;
        }
_L4:
        af1 = af;
        k = i;
        flag1 = l;
        if (true) goto _L2; else goto _L1
_L1:
        if (af1 == null) goto _L2; else goto _L3
_L3:
        logger.log("path.size: %d", new Object[] {
            Integer.valueOf(arraylist.size())
        });
        logger.log("element.iscompleted: %b", new Object[] {
            Boolean.valueOf(drawqueue.isCompleted())
        });
        logger.log("element.size: %d", new Object[] {
            Integer.valueOf(drawqueue.size())
        });
        i = 0;
        if (arraylist.size() == 2 && drawqueue.isCompleted() && drawqueue.size() == 0 && singleTapAllowed)
        {
            logger.warn("single tap!");
            f1 = ((Float)arraylist.get(arraylist.size() - 2)).floatValue();
            f2 = ((Float)arraylist.get(arraylist.size() - 1)).floatValue();
            if (f1 != af[0] || f2 != af[1])
            {
                arraylist.add(Float.valueOf(af[0]));
                arraylist.add(Float.valueOf(af[1]));
                moastrokeparameter.addPoint(af[0], af[1]);
                i = 2;
            } else
            {
                logger.warn("dont add more points..");
            }
        } else
        {
            arraylist.add(Float.valueOf(af[0]));
            arraylist.add(Float.valueOf(af[1]));
            moastrokeparameter.addPoint(af[0], af[1]);
            i = 2;
        }
        l = (int)af1[0];
        i1 = (int)af[0];
        j1 = (int)af1[1];
        k1 = (int)af[1];
        rect.set(Math.min(l, i1), Math.min(j1, k1), Math.max(l, i1), Math.max(j1, k1));
        rect.sort();
        rect.inset(-(int)((double)f * brushMultiplier), -(int)((double)f * brushMultiplier));
        if (drawqueue.isCompleted())
        {
            logger.log((new StringBuilder()).append("size: ").append(drawqueue.size()).append(", empty: ").append(drawqueue.isEmpty()).toString());
        }
        if (filter != null && !isInterrupted())
        {
            nativetoolfilter = filter;
            d = f;
            if (drawqueue.isCompleted() && drawqueue.isEmpty())
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            nativetoolfilter = nativetoolfilter.draw(d, 0.0D, k, flag2, ArrayUtils.toPrimitive(arraylist));
            if (nativetoolfilter != null && nativetoolfilter.length == 4)
            {
                rect.set((int)nativetoolfilter[0], (int)nativetoolfilter[1], (int)nativetoolfilter[2], (int)nativetoolfilter[3]);
            }
            if (filter != null)
            {
                filter.renderPreview(rect);
            }
        }
        k += i;
        i = k;
        l = ((flag1) ? 1 : 0);
        if (handler != null)
        {
            i = k;
            l = ((flag1) ? 1 : 0);
            if (!isInterrupted())
            {
                Moa.notifyPixelsChanged(bitmap1);
                handler.sendEmptyMessage(12);
                i = k;
                l = ((flag1) ? 1 : 0);
            }
        }
          goto _L4
        if (i != 0)
        {
            if (handler != null && !isInterrupted())
            {
                handler.sendEmptyMessage(5);
            }
            i = 0;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setRegisterStrokeInitParams(boolean flag)
    {
        mRegisterStrokeInitParams = flag;
    }

    public void setSingleTapAllowed(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        singleTapAllowed = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void singleTap(float f, float af[], com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode brushmode)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = running;
        if (flag);
        this;
        JVM INSTR monitorexit ;
        return;
        af;
        throw af;
    }

    public void start(Bitmap bitmap)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = started;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        logger.info("start");
        mSourceBitmap = new SoftReference(bitmap);
        started = true;
        running = true;
        super.start();
        if (true) goto _L1; else goto _L3
_L3:
        bitmap;
        throw bitmap;
    }

    public void start(Bitmap bitmap, Bitmap bitmap1)
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = started;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        logger.info("start");
        mSourceBitmap = new SoftReference(bitmap);
        mPreviewBitmap = new SoftReference(bitmap1);
        started = true;
        running = true;
        super.start();
        if (true) goto _L1; else goto _L3
_L3:
        bitmap;
        throw bitmap;
    }

    static 
    {
        logger = LoggerFactory.getLogger("BackgroundDrawThread", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType);
    }
}
