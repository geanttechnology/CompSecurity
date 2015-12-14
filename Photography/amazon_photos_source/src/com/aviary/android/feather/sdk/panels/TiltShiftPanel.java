// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.filters.NativeToolFilter;
import com.aviary.android.feather.headless.moa.Moa;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.widget.AviaryHighlightImageButton;
import com.aviary.android.feather.sdk.widget.ImageViewTiltiShiftTouch;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractContentPanel

public class TiltShiftPanel extends AbstractContentPanel
    implements com.aviary.android.feather.sdk.widget.AviaryHighlightImageButton.OnCheckedChangeListener, com.aviary.android.feather.sdk.widget.ImageViewTiltiShiftTouch.OnTiltShiftDrawListener, it.sephiroth.android.library.imagezoom.ImageViewTouchBase.OnDrawableChangeListener
{
    class BackgroundDrawThread extends Thread
    {

        DrawQueue mCurrentQueue;
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
            DrawQueue drawqueue;
            do
            {
                if (mQueue.size() <= 0)
                {
                    break MISSING_BLOCK_LABEL_76;
                }
                drawqueue = (DrawQueue)mQueue.poll();
            } while (drawqueue == null);
            mLogger.log("end element...");
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

        public void draw(float af[], float f, float f1, float f2, float f3, float f4, float f5)
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
            mCurrentQueue.clear();
            mCurrentQueue.add(new float[] {
                af[0], af[1], f, f1, f2, f3, f4, f5
            });
            if (true) goto _L2; else goto _L4
_L4:
            af;
            throw af;
        }

        public void drawStart(float af[], com.aviary.android.feather.sdk.widget.ImageViewTiltiShiftTouch.TiltShiftDrawMode tiltshiftdrawmode, float f, float f1, float f2, float f3, float f4, 
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
                mCurrentQueue.end();
                mCurrentQueue = null;
            }
            if (tiltshiftdrawmode != com.aviary.android.feather.sdk.widget.ImageViewTiltiShiftTouch.TiltShiftDrawMode.Radial)
            {
                break MISSING_BLOCK_LABEL_162;
            }
            obj = com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode.Radial;
_L3:
            ToolActionVO toolactionvo;
            obj = new DrawQueue(((com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode) (obj)));
            ((DrawQueue) (obj)).add(new float[] {
                af[0], af[1], f, f1, f2, f3, f4, f5
            });
            toolactionvo = mToolAction;
            if (tiltshiftdrawmode == com.aviary.android.feather.sdk.widget.ImageViewTiltiShiftTouch.TiltShiftDrawMode.Radial)
            {
                af = "circle";
            } else
            {
                af = "rectangle";
            }
            toolactionvo.setValue(af);
            mQueue.add(obj);
            mCurrentQueue = ((DrawQueue) (obj));
              goto _L1
            af;
            throw af;
            obj = com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode.Linear;
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
            DrawQueue drawqueue;
            do
            {
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_80;
                }
                drawqueue = (DrawQueue)iterator.next();
            } while (drawqueue == null);
            mLogger.log("end element...");
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
            DrawQueue drawqueue = mCurrentQueue;
            if (drawqueue != null) goto _L3; else goto _L2
_L2:
            this;
            JVM INSTR monitorexit ;
            return;
_L3:
            mCurrentQueue.end();
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
            mLogger.log("thread.start!");
            mLogger.log("filter.init");
            mFilter.init(mBitmap, mPreview);
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
                    mLogger.log((new StringBuilder()).append("queue.size: ").append(mQueue.size()).toString());
                    boolean flag1 = flag;
                    if (!flag)
                    {
                        flag1 = true;
                        onProgressStart();
                    }
                    DrawQueue drawqueue = (DrawQueue)mQueue.element();
                    if (drawqueue == null)
                    {
                        mQueue.poll();
                        flag = flag1;
                        continue;
                    }
                    com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode tiltshiftmode = drawqueue.tiltShiftMode;
                    mFilter.setTiltShiftMode(tiltshiftmode);
                    do
                    {
                        if (drawqueue.size() <= 0 && drawqueue.isCompleted() || !running || isInterrupted())
                        {
                            mQueue.poll();
                            flag = flag1;
                            continue label0;
                        }
                        float af[] = (float[])drawqueue.poll();
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
                            mFilter.draw(f2, f3, 0, false, new float[] {
                                f, f1
                            });
                            rectf1.set(f4, f5, f6, f7);
                            rectf.union(rectf1);
                            mFilter.renderPreview(rectf);
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
            mLogger.log("thread.end");
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

        public BackgroundDrawThread(String s, int i)
        {
            this$0 = TiltShiftPanel.this;
            super(s);
            setPriority(i);
            init();
        }
    }

    static class DrawQueue extends LinkedBlockingQueue
    {

        private static final long serialVersionUID = 1L;
        private volatile boolean completed;
        private com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode tiltShiftMode;

        public void end()
        {
            completed = true;
        }

        public com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode getMode()
        {
            return tiltShiftMode;
        }

        public boolean isCompleted()
        {
            return completed;
        }


        public DrawQueue(com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode tiltshiftmode)
        {
            tiltShiftMode = tiltshiftmode;
            completed = false;
        }
    }

    class GenerateResultTask extends AviaryAsyncTask
    {

        ProgressDialog mProgress;
        final TiltShiftPanel this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (mBackgroundDrawThread != null)
            {
                while (mBackgroundDrawThread != null && !mBackgroundDrawThread.isCompleted()) 
                {
                    mLogger.log((new StringBuilder()).append("waiting.... ").append(mBackgroundDrawThread.getQueueSize()).toString());
                    try
                    {
                        Thread.sleep(50L);
                    }
                    // Misplaced declaration of an exception variable
                    catch (Void avoid[])
                    {
                        avoid.printStackTrace();
                    }
                }
            }
            mActions.add(mFilter.getActions().get(0));
            return null;
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((Void)obj);
        }

        protected void doPostExecute(Void void1)
        {
            if (getContext().getBaseActivity().isFinishing())
            {
                return;
            }
            if (mProgress.isShowing())
            {
                try
                {
                    mProgress.dismiss();
                }
                // Misplaced declaration of an exception variable
                catch (Void void1) { }
            }
            onComplete(mPreview, mActions);
        }

        protected void doPreExecute()
        {
            mProgress.setTitle(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.R.string.feather_loading_title));
            mProgress.setMessage(getContext().getBaseContext().getString(com.aviary.android.feather.sdk.R.string.feather_effect_loading_message));
            mProgress.setIndeterminate(true);
            mProgress.setCancelable(false);
            mProgress.show();
        }

        GenerateResultTask()
        {
            this$0 = TiltShiftPanel.this;
            super();
            mProgress = new ProgressDialog(getContext().getBaseContext());
        }
    }


    static final float BRUSH_MULTIPLIER = 2F;
    MoaActionList mActions;
    private BackgroundDrawThread mBackgroundDrawThread;
    private AviaryHighlightImageButton mCircleButton;
    private NativeToolFilter mFilter;
    private AviaryHighlightImageButton mRectButton;
    com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode mTiltShiftMode;
    final ToolActionVO mToolAction = new ToolActionVO();

    public TiltShiftPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry);
        mActions = MoaActionFactory.actionList();
    }

    private String printRect(Rect rect)
    {
        return (new StringBuilder()).append("( left=").append(rect.left).append(", top=").append(rect.top).append(", width=").append(rect.width()).append(", height=").append(rect.height()).append(")").toString();
    }

    protected NativeToolFilter createFilter()
    {
        return (NativeToolFilter)ToolLoaderFactory.get(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.FOCUS);
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_focus, null);
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        return (ViewGroup)layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_panel_focus, viewgroup, false);
    }

    public volatile boolean isRendering()
    {
        return super.isRendering();
    }

    public void onActivate()
    {
        super.onActivate();
        mPreview = BitmapUtils.copy(mBitmap, android.graphics.Bitmap.Config.ARGB_8888);
        mBackgroundDrawThread.start();
        ((ImageViewTiltiShiftTouch)mImageView).setOnDrawStartListener(this);
        mImageView.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        mImageView.setImageBitmap(mPreview, null, -1F, 8F);
        contentReady();
    }

    public void onCancelled()
    {
        super.onCancelled();
    }

    public void onCheckedChanged(AviaryHighlightImageButton aviaryhighlightimagebutton, boolean flag, boolean flag1)
    {
        int i;
        mLogger.info((new StringBuilder()).append("onCheckedChanged: ").append(flag).append(", fromUser: ").append(flag1).toString());
        i = aviaryhighlightimagebutton.getId();
        if (!flag)
        {
            return;
        }
        if (i != mRectButton.getId()) goto _L2; else goto _L1
_L1:
        mLogger.log("rect");
        mTiltShiftMode = com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode.Linear;
        mCircleButton.setChecked(false);
_L4:
        if (!flag1)
        {
            mLogger.log("return");
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (i == mCircleButton.getId())
        {
            mLogger.log("circle");
            mTiltShiftMode = com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode.Radial;
            mRectButton.setChecked(false);
        }
        if (true) goto _L4; else goto _L3
_L3:
        aviaryhighlightimagebutton = new HashMap();
        if (mTiltShiftMode != com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode.Radial) goto _L6; else goto _L5
_L5:
        ((ImageViewTiltiShiftTouch)mImageView).setTiltShiftDrawMode(com.aviary.android.feather.sdk.widget.ImageViewTiltiShiftTouch.TiltShiftDrawMode.Radial);
        aviaryhighlightimagebutton.put("style", "circle");
_L8:
        getContext().getTracker().tagEventAttributes((new StringBuilder()).append(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.FOCUS.name().toLowerCase(Locale.US)).append(": style_selected").toString(), aviaryhighlightimagebutton);
        return;
_L6:
        if (mTiltShiftMode == com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode.Linear)
        {
            ((ImageViewTiltiShiftTouch)mImageView).setTiltShiftDrawMode(com.aviary.android.feather.sdk.widget.ImageViewTiltiShiftTouch.TiltShiftDrawMode.Linear);
            aviaryhighlightimagebutton.put("style", "rectangle");
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void onComplete(Bitmap bitmap, MoaActionList moaactionlist)
    {
        if (mTiltShiftMode == com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode.Radial)
        {
            mTrackingAttributes.put("style", "circle");
        } else
        {
            mTrackingAttributes.put("style", "rectangle");
        }
        mEditResult.setActionList(moaactionlist);
        mEditResult.setToolAction(mToolAction);
        super.onComplete(bitmap);
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        mRectButton = (AviaryHighlightImageButton)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_button_rectangle);
        mCircleButton = (AviaryHighlightImageButton)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_button_circle);
        mImageView = (ImageViewTiltiShiftTouch)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_image);
        bitmap = (ImageViewTiltiShiftTouch)mImageView;
        bitmap.setOnDrawableChangedListener(this);
        bitmap.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        mCircleButton.setOnCheckedChangeListener(this);
        mRectButton.setOnCheckedChangeListener(this);
        mBackgroundDrawThread = new BackgroundDrawThread("filter-thread", 5);
        mFilter = createFilter();
    }

    public void onDeactivate()
    {
        mImageView.setOnDrawableChangedListener(null);
        mCircleButton.setOnCheckedChangeListener(this);
        mRectButton.setOnCheckedChangeListener(this);
        ((ImageViewTiltiShiftTouch)mImageView).setOnDrawStartListener(null);
        if (mBackgroundDrawThread != null)
        {
            mBackgroundDrawThread.clear();
            if (mBackgroundDrawThread.isAlive())
            {
                mBackgroundDrawThread.quit();
                for (; mBackgroundDrawThread.isAlive(); mLogger.log("isAlive...")) { }
            }
        }
        onProgressEnd();
        super.onDeactivate();
    }

    public void onDestroy()
    {
        super.onDestroy();
        mBackgroundDrawThread = null;
        mImageView.clear();
    }

    protected void onDispose()
    {
        mContentReadyListener = null;
        mFilter.dispose();
        super.onDispose();
    }

    public void onDrawEnd()
    {
        mBackgroundDrawThread.pathEnd();
    }

    public void onDrawStart(float af[], com.aviary.android.feather.sdk.widget.ImageViewTiltiShiftTouch.TiltShiftDrawMode tiltshiftdrawmode, float f, float f1, float f2, float f3, float f4, 
            float f5)
    {
        mBackgroundDrawThread.drawStart(af, tiltshiftdrawmode, f, f1, f2, f3, f4, f5);
        setIsChanged(true);
    }

    public void onDrawableChanged(Drawable drawable)
    {
        mLogger.info((new StringBuilder()).append("onDrawableChanged: ").append(drawable).toString());
        if (!mCircleButton.isChecked()) goto _L2; else goto _L1
_L1:
        mTiltShiftMode = com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode.Radial;
_L4:
        getHandler().postDelayed(new Runnable() {

            final TiltShiftPanel this$0;

            public void run()
            {
                ImageViewTiltiShiftTouch imageviewtiltishifttouch = (ImageViewTiltiShiftTouch)mImageView;
                if (mTiltShiftMode == com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode.Radial)
                {
                    mCircleButton.setChecked(true);
                    imageviewtiltishifttouch.setTiltShiftDrawMode(com.aviary.android.feather.sdk.widget.ImageViewTiltiShiftTouch.TiltShiftDrawMode.Radial);
                    return;
                } else
                {
                    mRectButton.setChecked(true);
                    imageviewtiltishifttouch.setTiltShiftDrawMode(com.aviary.android.feather.sdk.widget.ImageViewTiltiShiftTouch.TiltShiftDrawMode.Linear);
                    return;
                }
            }

            
            {
                this$0 = TiltShiftPanel.this;
                super();
            }
        }, 500L);
        return;
_L2:
        if (mRectButton.isChecked())
        {
            mTiltShiftMode = com.aviary.android.feather.headless.filters.NativeToolFilter.TiltShiftMode.Linear;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onDrawing(float af[], float f, float f1, float f2, float f3, float f4, float f5)
    {
        mBackgroundDrawThread.draw(af, f, f1, f2, f3, f4, f5);
    }

    protected void onGenerateResult()
    {
        if (mBackgroundDrawThread.isAlive() && !mBackgroundDrawThread.isCompleted())
        {
            mBackgroundDrawThread.finish();
            (new GenerateResultTask()).execute(new Void[0]);
            return;
        } else
        {
            onComplete(mPreview, mFilter.getActions());
            return;
        }
    }

    public volatile void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }




}
