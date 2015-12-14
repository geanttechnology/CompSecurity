// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;
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
import com.aviary.android.feather.sdk.graphics.PreviewSpotDrawable;
import com.aviary.android.feather.sdk.overlays.AviaryOverlay;
import com.aviary.android.feather.sdk.overlays.BlemishOverlay;
import com.aviary.android.feather.sdk.utils.UIUtils;
import com.aviary.android.feather.sdk.widget.AviaryAdapterView;
import com.aviary.android.feather.sdk.widget.AviaryGallery;
import com.aviary.android.feather.sdk.widget.AviaryHighlightImageButton;
import com.aviary.android.feather.sdk.widget.ImageViewSpotSingleTap;
import com.aviary.android.feather.sdk.widget.VibrationWidget;
import it.sephiroth.android.library.imagezoom.ImageViewTouch;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractContentPanel, BackgroundDrawThread

public class BlemishPanel extends AbstractContentPanel
    implements android.view.View.OnClickListener, com.aviary.android.feather.sdk.widget.AviaryGallery.OnItemsScrollListener, com.aviary.android.feather.sdk.widget.ImageViewSpotSingleTap.OnTapListener
{
    class GalleryAdapter extends BaseAdapter
    {

        private static final int INVALID_POSITION = 1;
        private static final float RADIUS_MULTIPLIER = 0.55F;
        private static final int VALID_POSITION = 0;
        LayoutInflater mLayoutInflater;
        Resources mRes;
        private int sizes[];
        final BlemishPanel this$0;

        public int getCount()
        {
            return sizes.length;
        }

        public Object getItem(int i)
        {
            return Integer.valueOf(sizes[i]);
        }

        public long getItemId(int i)
        {
            return 0L;
        }

        public int getItemViewType(int i)
        {
            if (i >= 0 && i < getCount())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            return i == 0 ? 1 : 0;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            int j;
            boolean flag;
            flag = false;
            j = getItemViewType(i);
            viewgroup = null;
            if (view != null) goto _L2; else goto _L1
_L1:
            View view1;
            view = mLayoutInflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_gallery_item_view, mGallery, false);
            view1 = view;
            if (j == 0)
            {
                viewgroup = new PreviewSpotDrawable(getContext().getBaseContext());
                ((ImageView)view.findViewById(com.aviary.android.feather.sdk.R.id.image)).setImageDrawable(viewgroup);
                view.setTag(viewgroup);
                view1 = view;
            }
_L4:
            if (viewgroup != null && j == 0)
            {
                j = sizes[i];
                float f = minRadiusSize + (((float)j - (float)minBrushSize) / (float)(maxBrushSize - minBrushSize)) * (maxRadiusSize - minRadiusSize) * 0.55F;
                viewgroup.setRadius(f);
                view1.setContentDescription((new StringBuilder()).append(mSizeContentDescription).append(" ").append(Float.toString(f)).toString());
            }
            if (mSelectedPosition == i)
            {
                flag = true;
            }
            view1.setSelected(flag);
            view1.setId(i);
            return view1;
_L2:
            view1 = view;
            if (j == 0)
            {
                viewgroup = (PreviewSpotDrawable)view.getTag();
                view1 = view;
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        public int getViewTypeCount()
        {
            return 2;
        }

        public GalleryAdapter(Context context, int ai[])
        {
            this$0 = BlemishPanel.this;
            super();
            mLayoutInflater = LayoutInflater.from(context);
            sizes = ai;
            mRes = context.getResources();
        }
    }

    class GenerateResultTask extends AviaryAsyncTask
    {

        ProgressDialog mProgress;
        final BlemishPanel this$0;

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
            this$0 = BlemishPanel.this;
            super();
            mProgress = new ProgressDialog(getContext().getBaseContext());
        }
    }


    static final float BRUSH_MULTIPLIER = 1.5F;
    private BackgroundDrawThread mBackgroundDrawThread;
    protected int mBrushSize;
    private int mBrushSizeIndex;
    protected int mBrushSizes[];
    private com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode mBrushType;
    private View mDisabledStatusView;
    protected PreviewSpotDrawable mDrawable;
    private NativeToolFilter mFilter;
    protected com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools mFilterType;
    protected AviaryGallery mGallery;
    protected AviaryHighlightImageButton mLensButton;
    private AviaryOverlay mOverlay;
    protected int mSelectedPosition;
    String mSizeContentDescription;
    Handler mThreadHandler;
    protected Toast mToast;
    private int maxBrushSize;
    float maxRadiusSize;
    private int minBrushSize;
    float minRadiusSize;

    public BlemishPanel(IAviaryController iaviarycontroller, ToolEntry toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools)
    {
        super(iaviarycontroller, toolentry);
        mBrushType = com.aviary.android.feather.headless.filters.NativeToolFilter.BrushMode.Free;
        mThreadHandler = new Handler(new android.os.Handler.Callback() {

            final BlemishPanel this$0;

            public boolean handleMessage(Message message)
            {
                message.what;
                JVM INSTR lookupswitch 3: default 40
            //                           4: 42
            //                           5: 52
            //                           12: 62;
                   goto _L1 _L2 _L3 _L4
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
                if (true) goto _L1; else goto _L5
_L5:
            }

            
            {
                this$0 = BlemishPanel.this;
                super();
            }
        });
        mSelectedPosition = -1;
        mFilterType = tools;
    }

    private Toast makeToast()
    {
        mDrawable = new PreviewSpotDrawable(getContext().getBaseContext());
        Toast toast = UIUtils.makeCustomToast(getContext().getBaseContext());
        ((ImageView)toast.getView().findViewById(com.aviary.android.feather.sdk.R.id.image)).setImageDrawable(mDrawable);
        return toast;
    }

    private void onComplete(Bitmap bitmap, MoaActionList moaactionlist)
    {
        mEditResult.setActionList(moaactionlist);
        mEditResult.setToolAction(new ToolActionVO(Integer.valueOf(mBrushSize)));
        onComplete(bitmap);
    }

    private void setSelectedTool(com.aviary.android.feather.sdk.widget.ImageViewSpotSingleTap.TouchMode touchmode)
    {
        boolean flag1 = true;
        ((ImageViewSpotSingleTap)mImageView).setDrawMode(touchmode);
        AviaryHighlightImageButton aviaryhighlightimagebutton = mLensButton;
        boolean flag;
        if (touchmode == com.aviary.android.feather.sdk.widget.ImageViewSpotSingleTap.TouchMode.IMAGE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        aviaryhighlightimagebutton.setSelected(flag);
        if (touchmode != com.aviary.android.feather.sdk.widget.ImageViewSpotSingleTap.TouchMode.IMAGE)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        setPanelEnabled(flag);
    }

    private void showSizePreview(int i)
    {
        if (!isActive())
        {
            return;
        } else
        {
            updateSizePreview(i);
            return;
        }
    }

    private void updateSizePreview(int i)
    {
        while (!isActive() || mToast == null) 
        {
            return;
        }
        mDrawable.setFixedRadius(i);
        mToast.show();
    }

    protected NativeToolFilter createFilter(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools)
    {
        return (NativeToolFilter)ToolLoaderFactory.get(tools);
    }

    protected View generateContentView(LayoutInflater layoutinflater)
    {
        return layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_content_blemish, null);
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        return (ViewGroup)layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_panel_spot, viewgroup, false);
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
        mToast = makeToast();
        disableHapticIsNecessary(new VibrationWidget[] {
            mGallery
        });
        mPreview = BitmapUtils.copy(mBitmap, android.graphics.Bitmap.Config.ARGB_8888);
        mLensButton.setOnClickListener(this);
        mGallery.setOnItemsScrollListener(this);
        ((ImageViewSpotSingleTap)mImageView).setOnTapListener(this);
        mImageView.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_IF_BIGGER);
        mImageView.setImageBitmap(mPreview, null, -1F, 8F);
        mBackgroundDrawThread.start(mPreview);
        getContentView().setVisibility(0);
        contentReady();
        if (AviaryOverlay.shouldShow(getContext(), 2))
        {
            mOverlay = new BlemishOverlay(getContext().getBaseContext(), com.aviary.android.feather.sdk.R.style.AviaryWidget_Overlay_Blemish, mImageView, mLensButton);
            mOverlay.showDelayed(100L);
        }
    }

    public boolean onBackPressed()
    {
        mLogger.info("onBackPressed");
        if (mOverlay != null && mOverlay.onBackPressed())
        {
            return true;
        } else
        {
            return super.onBackPressed();
        }
    }

    public void onClick(View view)
    {
        if (view.getId() == mLensButton.getId())
        {
            if (((ImageViewSpotSingleTap)mImageView).getDrawMode() == com.aviary.android.feather.sdk.widget.ImageViewSpotSingleTap.TouchMode.DRAW)
            {
                view = com.aviary.android.feather.sdk.widget.ImageViewSpotSingleTap.TouchMode.IMAGE;
            } else
            {
                view = com.aviary.android.feather.sdk.widget.ImageViewSpotSingleTap.TouchMode.DRAW;
            }
            setSelectedTool(view);
        }
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        bitmap = (ConfigService)getContext().getService(com/aviary/android/feather/library/services/ConfigService);
        mBrushSizeIndex = bitmap.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_spot_brush_index);
        mBrushSizes = bitmap.getSizeArray(com.aviary.android.feather.sdk.R.array.aviary_single_tap_spot_brush_sizes);
        mBrushSize = mBrushSizes[mBrushSizeIndex];
        minBrushSize = mBrushSizes[0];
        maxBrushSize = mBrushSizes[mBrushSizes.length - 1];
        minRadiusSize = (float)bitmap.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_spot_gallery_item_min_size) / 100F;
        maxRadiusSize = (float)bitmap.getInteger(com.aviary.android.feather.sdk.R.integer.aviary_spot_gallery_item_max_size) / 100F;
        mLensButton = (AviaryHighlightImageButton)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_lens_button);
        mSizeContentDescription = bitmap.getString(com.aviary.android.feather.sdk.R.string.feather_acc_size);
        mGallery = (AviaryGallery)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_gallery);
        mGallery.setDefaultPosition(mBrushSizeIndex);
        mGallery.setAutoSelectChild(true);
        mGallery.setCallbackDuringFling(false);
        mGallery.setAdapter(new GalleryAdapter(getContext().getBaseContext(), mBrushSizes));
        mSelectedPosition = mBrushSizeIndex;
        mImageView = (ImageViewSpotSingleTap)getContentView().findViewById(com.aviary.android.feather.sdk.R.id.image);
        mImageView.setDisplayType(it.sephiroth.android.library.imagezoom.ImageViewTouchBase.DisplayType.FIT_IF_BIGGER);
        ((ImageViewSpotSingleTap)mImageView).setBrushSize(mBrushSize);
        mDisabledStatusView = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_disable_status);
        mFilter = createFilter(mFilterType);
        mBackgroundDrawThread = new BackgroundDrawThread("draw-thread", 5, mFilter, mThreadHandler, 1.5D);
        mBackgroundDrawThread.setSingleTapAllowed(true);
        mBackgroundDrawThread.setRegisterStrokeInitParams(true);
    }

    public void onDeactivate()
    {
        mLensButton.setOnClickListener(null);
        mGallery.setOnItemsScrollListener(null);
        ((ImageViewSpotSingleTap)mImageView).setOnTapListener(null);
        if (mBackgroundDrawThread != null)
        {
            mBackgroundDrawThread.clear();
            if (mBackgroundDrawThread.isAlive())
            {
                mBackgroundDrawThread.quit();
                while (mBackgroundDrawThread.isAlive()) ;
            }
        }
        if (mOverlay != null)
        {
            mOverlay.dismiss();
        }
        onProgressEnd();
        super.onDeactivate();
    }

    public void onDestroy()
    {
        mImageView.clear();
        super.onDestroy();
        if (mToast != null)
        {
            mToast.cancel();
        }
    }

    protected void onDispose()
    {
        mBackgroundDrawThread = null;
        mThreadHandler = null;
        mContentReadyListener = null;
        mFilter.dispose();
        super.onDispose();
    }

    protected void onGenerateResult()
    {
        if (AviaryOverlay.shouldShow(getContext(), 4))
        {
            AviaryOverlay.markAsViewed(getContext(), 4);
        }
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

    public void onScroll(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        updateSizePreview(mBrushSizes[i]);
    }

    public void onScrollFinished(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        mBrushSize = mBrushSizes[i];
        ((ImageViewSpotSingleTap)mImageView).setBrushSize(mBrushSize);
        setSelectedTool(com.aviary.android.feather.sdk.widget.ImageViewSpotSingleTap.TouchMode.DRAW);
    }

    public void onScrollStarted(AviaryAdapterView aviaryadapterview, View view, int i, long l)
    {
        showSizePreview(mBrushSizes[i]);
        setSelectedTool(com.aviary.android.feather.sdk.widget.ImageViewSpotSingleTap.TouchMode.DRAW);
    }

    public void onTap(float af[], float f)
    {
        mLogger.info("onTap, radius: %.2f", new Object[] {
            Float.valueOf(f)
        });
        f = Math.max(1.0F, f);
        mBackgroundDrawThread.pathStart(2.0F * f, af, mBrushType);
        mBackgroundDrawThread.pathEnd();
        setIsChanged(true);
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
