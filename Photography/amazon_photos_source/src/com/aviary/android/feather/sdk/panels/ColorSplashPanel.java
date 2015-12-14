// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.filters.NativeToolFilter;
import com.aviary.android.feather.headless.moa.MoaActionFactory;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.services.ConfigService;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.widget.AviaryHighlightImageButton;
import com.aviary.android.feather.sdk.widget.ImageViewSpotDraw;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;
import java.util.Locale;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractContentPanel, BackgroundDrawThread

public class ColorSplashPanel extends AbstractContentPanel
    implements android.view.View.OnClickListener, com.aviary.android.feather.sdk.widget.AviaryHighlightImageButton.OnCheckedChangeListener, com.aviary.android.feather.sdk.widget.ImageViewSpotDraw.OnDrawListener
{
    class GenerateResultTask extends AviaryAsyncTask
    {

        ProgressDialog mProgress;
        final ColorSplashPanel this$0;

        protected transient MoaActionList doInBackground(Void avoid[])
        {
            avoid = MoaActionFactory.actionList();
            if (mBackgroundDrawThread != null)
            {
                while (mBackgroundDrawThread != null && !mBackgroundDrawThread.isCompleted()) 
                {
                    mLogger.log((new StringBuilder()).append("waiting.... ").append(mBackgroundDrawThread.getQueueSize()).toString());
                    try
                    {
                        Thread.sleep(50L);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                }
            }
            avoid.add(mFilter.getActions().get(0));
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void doPostExecute(MoaActionList moaactionlist)
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
                catch (IllegalArgumentException illegalargumentexception) { }
            }
            onComplete(mPreview, moaactionlist);
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((MoaActionList)obj);
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
            this$0 = ColorSplashPanel.this;
            super();
            mProgress = new ProgressDialog(getContext().getBaseContext());
        }
    }


    static final float BRUSH_MULTIPLIER = 1.5F;
    private BackgroundDrawThread mBackgroundDrawThread;
    private com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode mBrushType;
    private AviaryHighlightImageButton mCurrent;
    private View mDisabledStatusView;
    private AviaryHighlightImageButton mErase;
    private NativeToolFilter mFilter;
    private AviaryHighlightImageButton mFree;
    private AviaryHighlightImageButton mLensButton;
    private AviaryHighlightImageButton mSmart;
    Handler mThreadHandler;
    private final ToolActionVO mToolAction;

    public ColorSplashPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry);
        mBrushType = com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode.Free;
        mThreadHandler = new Handler(new android.os.Handler.Callback() {

            final ColorSplashPanel this$0;

            public boolean handleMessage(Message message)
            {
                message.what;
                JVM INSTR lookupswitch 4: default 48
            //                           4: 50
            //                           5: 60
            //                           12: 70
            //                           1000: 103;
                   goto _L1 _L2 _L3 _L4 _L5
_L1:
                return false;
_L2:
                onProgressStart();
                continue; /* Loop/switch isn't completed */
_L3:
                onProgressEnd();
                continue; /* Loop/switch isn't completed */
_L4:
                if (isActive() && mImageView != null)
                {
                    mImageView.postInvalidate();
                }
                continue; /* Loop/switch isn't completed */
_L5:
                if (isActive())
                {
                    setIsChanged(true);
                }
                if (true) goto _L1; else goto _L6
_L6:
            }

            
            {
                this$0 = ColorSplashPanel.this;
                super();
            }
        });
        mToolAction = new ToolActionVO(com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode.None.name());
    }

    private void onComplete(Bitmap bitmap, MoaActionList moaactionlist)
    {
        mEditResult.setActionList(moaactionlist);
        mEditResult.setToolAction(mToolAction);
        onComplete(bitmap);
    }

    private void setSelectedTool(com.aviary.android.feather.sdk.widget.ImageViewSpotDraw.TouchMode touchmode)
    {
        boolean flag1 = true;
        ((ImageViewSpotDraw)mImageView).setDrawMode(touchmode);
        AviaryHighlightImageButton aviaryhighlightimagebutton = mLensButton;
        boolean flag;
        if (touchmode == com.aviary.android.feather.sdk.widget.ImageViewSpotDraw.TouchMode.IMAGE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aviaryhighlightimagebutton.setSelected(flag);
        if (touchmode != com.aviary.android.feather.sdk.widget.ImageViewSpotDraw.TouchMode.IMAGE)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        setPanelEnabled(flag);
    }

    protected NativeToolFilter createFilter()
    {
        return (NativeToolFilter)ToolLoaderFactory.get(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.SPLASH);
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_spot_draw, null);
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        return (ViewGroup)layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_panel_colorsplash, viewgroup, false);
    }

    public boolean getPanelEnabled()
    {
        if (mOptionView != null)
        {
            return mOptionView.isEnabled();
        } else
        {
            return false;
        }
    }

    public volatile boolean isRendering()
    {
        return super.isRendering();
    }

    public void onActivate()
    {
        super.onActivate();
        mFree.setOnCheckedChangeListener(this);
        if (mFree.isChecked())
        {
            mCurrent = mFree;
        }
        mSmart.setOnCheckedChangeListener(this);
        if (mSmart.isChecked())
        {
            mCurrent = mSmart;
        }
        mErase.setOnCheckedChangeListener(this);
        if (mErase.isChecked())
        {
            mCurrent = mErase;
        }
        mPreview = BitmapUtils.copy(mBitmap, android.graphics.Bitmap.Config.ARGB_8888);
        ((ImageViewSpotDraw)mImageView).setOnDrawStartListener(this);
        mImageView.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_TO_SCREEN);
        mImageView.setImageBitmap(mPreview, null, -1F, 8F);
        mBackgroundDrawThread.start(mBitmap, mPreview);
        mLensButton.setOnClickListener(this);
        getContentView().setVisibility(0);
        contentReady();
    }

    public void onCheckedChanged(AviaryHighlightImageButton aviaryhighlightimagebutton, boolean flag, boolean flag1)
    {
        if (mCurrent != null && !aviaryhighlightimagebutton.equals(mCurrent))
        {
            mCurrent.setChecked(false);
        }
        mCurrent = aviaryhighlightimagebutton;
        if (!flag1 || !flag) goto _L2; else goto _L1
_L1:
        int i = aviaryhighlightimagebutton.getId();
        if (i != mFree.getId()) goto _L4; else goto _L3
_L3:
        mBrushType = com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode.Free;
        getContext().getTracker().tagEvent((new StringBuilder()).append(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.SPLASH.name().toLowerCase(Locale.US)).append(": free_color_selected").toString());
_L6:
        if (((ImageViewSpotDraw)mImageView).getDrawMode() != com.aviary.android.feather.sdk.widget.ImageViewSpotDraw.TouchMode.DRAW)
        {
            setSelectedTool(com.aviary.android.feather.sdk.widget.ImageViewSpotDraw.TouchMode.DRAW);
        }
_L2:
        return;
_L4:
        if (i == mSmart.getId())
        {
            mBrushType = com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode.Smart;
            getContext().getTracker().tagEvent((new StringBuilder()).append(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.SPLASH.name().toLowerCase(Locale.US)).append(": smart_color_selected").toString());
        } else
        if (i == mErase.getId())
        {
            mBrushType = com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode.Erase;
            getContext().getTracker().tagEvent((new StringBuilder()).append(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.SPLASH.name().toLowerCase(Locale.US)).append(": eraser_selected").toString());
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onClick(View view)
    {
        if (view.getId() == mLensButton.getId())
        {
            if (((ImageViewSpotDraw)mImageView).getDrawMode() == com.aviary.android.feather.sdk.widget.ImageViewSpotDraw.TouchMode.DRAW)
            {
                view = com.aviary.android.feather.sdk.widget.ImageViewSpotDraw.TouchMode.IMAGE;
            } else
            {
                view = com.aviary.android.feather.sdk.widget.ImageViewSpotDraw.TouchMode.DRAW;
            }
            setSelectedTool(view);
        }
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        int i = ((ConfigService)getContext().getService(com/aviary/android/feather/library/services/ConfigService)).getDimensionPixelSize(com.aviary.android.feather.sdk.R.dimen.aviary_color_splash_brush_size);
        mLensButton = (AviaryHighlightImageButton)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_lens_button);
        mFree = (AviaryHighlightImageButton)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_button1);
        mSmart = (AviaryHighlightImageButton)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_button2);
        mErase = (AviaryHighlightImageButton)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_button3);
        mImageView = (ImageViewSpotDraw)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.image);
        ((ImageViewSpotDraw)mImageView).setBrushSize((int)((float)i * 1.5F));
        ((ImageViewSpotDraw)mImageView).setDrawLimit(0.0D);
        ((ImageViewSpotDraw)mImageView).setPaintEnabled(false);
        ((ImageViewSpotDraw)mImageView).setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_IF_BIGGER);
        mDisabledStatusView = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_disable_status);
        mFilter = createFilter();
        mBackgroundDrawThread = new BackgroundDrawThread("draw-thread", 5, mFilter, mThreadHandler, 1.5D);
    }

    public void onDeactivate()
    {
        mFree.setOnCheckedChangeListener(this);
        mSmart.setOnCheckedChangeListener(this);
        mErase.setOnCheckedChangeListener(this);
        mLensButton.setOnClickListener(null);
        ((ImageViewSpotDraw)mImageView).setOnDrawStartListener(null);
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
        mImageView.clear();
        super.onDestroy();
    }

    protected void onDispose()
    {
        mBackgroundDrawThread = null;
        mContentReadyListener = null;
        mThreadHandler = null;
        mFilter.dispose();
        super.onDispose();
    }

    public void onDrawEnd()
    {
        mBackgroundDrawThread.pathEnd();
    }

    public void onDrawStart(float af[], float f)
    {
        f = Math.max(1.0F, f);
        mBackgroundDrawThread.pathStart(f / 1.5F, af, mBrushType);
        mToolAction.setValue(mBrushType.name());
        setIsChanged(true);
    }

    public void onDrawing(float af[], float f)
    {
        mBackgroundDrawThread.lineTo(af);
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

    public void setPanelEnabled(boolean flag)
    {
        if (mOptionView != null && flag != mOptionView.isEnabled())
        {
            mOptionView.setEnabled(flag);
            View view;
            byte byte0;
            if (flag)
            {
                getContext().restoreToolbarTitle();
            } else
            {
                getContext().setToolbarTitle(com.aviary.android.feather.sdk.R.string.feather_zoom_mode);
            }
            view = mDisabledStatusView;
            if (flag)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
        }
    }



}
