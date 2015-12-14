// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.filters.IFilter;
import com.aviary.android.feather.headless.filters.INativeRangeFilter;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaFloatParameter;
import com.aviary.android.feather.headless.moa.MoaResult;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.graphics.drawable.FakeBitmapDrawable;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            SliderEffectPanel

public class NativeEffectRangePanel extends SliderEffectPanel
{
    class ApplyFilterTask extends AviaryAsyncTask
    {

        IFilter filter;
        boolean isPreview;
        Bitmap mCurrentBitmap;
        MoaResult mResult;
        boolean mShowProgress;
        final NativeEffectRangePanel this$0;

        protected transient Bitmap doInBackground(Bitmap abitmap[])
        {
            if (isCancelled() || filter == null)
            {
                return null;
            }
            if (!isPreview || mPreviewSmallBitmap == null)
            {
                break MISSING_BLOCK_LABEL_129;
            }
            mCurrentBitmap = Bitmap.createBitmap(mPreviewSmallBitmap.getWidth(), mPreviewSmallBitmap.getHeight(), mPreviewSmallBitmap.getConfig());
            mResult = ((INativeRangeFilter)filter).prepare(mPreviewSmallBitmap, mCurrentBitmap, 1, 1);
_L1:
            mResult.execute();
            if (!isCancelled())
            {
                break MISSING_BLOCK_LABEL_171;
            }
            mLogger.warn("isCancelled... return null");
            return null;
            try
            {
                mResult = ((INativeRangeFilter)filter).prepare(mBitmap, mPreview, 1, 1);
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap abitmap[])
            {
                abitmap.printStackTrace();
                return null;
            }
              goto _L1
            mToolAction.setValue(((INativeRangeFilter)filter).getValue().getValue());
            mActions = ((INativeRangeFilter)filter).getActions();
            if (isCancelled())
            {
                return null;
            } else
            {
                return mResult.outputBitmap;
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Bitmap[])aobj);
        }

        protected void doPostExecute(Bitmap bitmap)
        {
            mLogger.info("onPostExecute, isPreview: %b, result: %s", new Object[] {
                Boolean.valueOf(isPreview), bitmap
            });
            if (!isActive())
            {
                return;
            }
            if (mShowProgress)
            {
                onProgressEnd();
            }
            if (bitmap != null && !isCancelled())
            {
                mLogger.log("result size: %dx%d", new Object[] {
                    Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())
                });
                mPreviewSmallDrawable.updateBitmap(bitmap, mBitmap.getWidth(), mBitmap.getHeight());
                onPreviewUpdated();
                if (!isPreview)
                {
                    setIsChanged(true);
                }
            } else
            {
                mLogger.warn("result == null || isCancelled");
            }
            if (!isPreview)
            {
                mIsRendering = false;
            }
            mCurrentTask = null;
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((Bitmap)obj);
        }

        protected void doPreExecute()
        {
            if (filter != null && mShowProgress)
            {
                onProgressStart();
            }
        }

        protected void onCancelled()
        {
            super.onCancelled();
            if (mResult != null)
            {
                mResult.cancel();
            }
            if (mCurrentBitmap != null && !mCurrentBitmap.isRecycled())
            {
                mCurrentBitmap.recycle();
            }
        }

        public ApplyFilterTask(float f, boolean flag, boolean flag1)
        {
            this$0 = NativeEffectRangePanel.this;
            super();
            isPreview = flag1;
            mShowProgress = flag;
            if (mFilter != null)
            {
                filter = ToolLoaderFactory.get(getName());
                ((INativeRangeFilter)filter).setValue(Float.valueOf(f));
            }
        }
    }

    class GenerateResultTask extends AviaryAsyncTask
    {

        ProgressDialog mProgress;
        final NativeEffectRangePanel this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            mLogger.info("GenerateResultTask::doInBackground", new Object[] {
                Boolean.valueOf(mIsRendering)
            });
            while (mIsRendering) ;
            return null;
        }

        protected volatile void doPostExecute(Object obj)
        {
            doPostExecute((Void)obj);
        }

        protected void doPostExecute(Void void1)
        {
            mLogger.info("GenerateResultTask::doPostExecute");
            if (getContext().getBaseActivity().isFinishing())
            {
                return;
            }
            if (mProgress.isShowing())
            {
                mProgress.dismiss();
            }
            onComplete(mPreview);
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
            this$0 = NativeEffectRangePanel.this;
            super();
            mProgress = new ProgressDialog(getContext().getBaseContext());
        }
    }


    static final int PREVIEW_FAKE_RATIO = 3;
    private boolean enableFastPreview;
    private MoaActionList mActions;
    private ApplyFilterTask mCurrentTask;
    volatile boolean mIsRendering;
    private Bitmap mPreviewSmallBitmap;
    private FakeBitmapDrawable mPreviewSmallDrawable;
    private final ToolActionVO mToolAction = new ToolActionVO();

    public NativeEffectRangePanel(IAviaryController iaviarycontroller, ToolEntry toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools, String s)
    {
        super(iaviarycontroller, toolentry, tools, s);
        enableFastPreview = ApiHelper.AT_LEAST_14;
        mIsRendering = false;
        mFilter = ToolLoaderFactory.get(tools);
    }

    private Bitmap acquireBitmap(int i)
    {
        Bitmap bitmap = Bitmap.createBitmap(mBitmap.getWidth() / i, mBitmap.getHeight() / i, mBitmap.getConfig());
        BitmapUtils.copy(mBitmap, bitmap);
        return bitmap;
    }

    protected void applyFilter(float f, boolean flag, boolean flag1)
    {
        boolean flag2 = true;
        mLogger.info((new StringBuilder()).append("applyFilter: ").append(f).toString());
        if (f == 0.0F)
        {
            if (!enableFastPreview)
            {
                flag = flag2;
            } else
            {
                flag = false;
            }
            killCurrentTask(flag);
            BitmapUtils.copy(mBitmap, mPreview);
            mPreviewSmallDrawable.updateBitmap(mPreview, mPreview.getWidth(), mPreview.getHeight());
            onPreviewUpdated();
            mIsRendering = false;
            setIsChanged(false);
            return;
        }
        if (!enableFastPreview)
        {
            boolean flag3;
            if (!enableFastPreview)
            {
                flag3 = true;
            } else
            {
                flag3 = false;
            }
            killCurrentTask(flag3);
        }
        mIsRendering = true;
        mCurrentTask = new ApplyFilterTask(f, flag, flag1);
        mCurrentTask.execute(new Bitmap[] {
            mBitmap
        });
        setIsChanged(true);
    }

    public boolean isRendering()
    {
        return mIsRendering;
    }

    boolean killCurrentTask(boolean flag)
    {
        if (mCurrentTask != null && mCurrentTask.cancel(true))
        {
            mIsRendering = false;
            if (flag)
            {
                onProgressEnd();
            }
            return true;
        } else
        {
            return false;
        }
    }

    public void onActivate()
    {
        super.onActivate();
        mPreview = BitmapUtils.copy(mBitmap, android.graphics.Bitmap.Config.ARGB_8888);
        if (enableFastPreview)
        {
            mPreviewSmallBitmap = acquireBitmap(3);
        }
        mPreviewSmallDrawable = new FakeBitmapDrawable(mPreview, mPreview.getWidth(), mPreview.getHeight());
        onPreviewChanged(mPreviewSmallDrawable, false, true);
        setIsChanged(false);
        if (hasOptions())
        {
            Bundle bundle = getOptions();
            if (bundle.containsKey("quick-numericValue"))
            {
                setValue(bundle.getInt("quick-numericValue", 0));
            }
        }
    }

    public boolean onBackPressed()
    {
        killCurrentTask(true);
        return super.onBackPressed();
    }

    public void onBitmapReplaced(Bitmap bitmap)
    {
        super.onBitmapReplaced(bitmap);
        if (isActive())
        {
            applyFilter(0.0F, false, false);
            setValue(50);
        }
    }

    public void onCancelled()
    {
        killCurrentTask(true);
        mIsRendering = false;
        super.onCancelled();
    }

    protected void onComplete(Bitmap bitmap, EditToolResultVO edittoolresultvo)
    {
        edittoolresultvo.setToolAction(mToolAction);
        edittoolresultvo.setActionList(mActions);
        super.onComplete(bitmap, edittoolresultvo);
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
    }

    public void onDeactivate()
    {
        onProgressEnd();
        super.onDeactivate();
    }

    protected void onDispose()
    {
        super.onDispose();
        if (mPreviewSmallBitmap != null && !mPreviewSmallBitmap.isRecycled())
        {
            mPreviewSmallBitmap.recycle();
            mPreviewSmallBitmap = null;
        }
    }

    protected void onGenerateResult()
    {
        mLogger.info((new StringBuilder()).append("onGenerateResult: ").append(mIsRendering).toString());
        if (mIsRendering)
        {
            (new GenerateResultTask()).execute(new Void[0]);
            return;
        } else
        {
            onComplete(mPreview);
            return;
        }
    }

    protected void onSliderChanged(int i, boolean flag)
    {
        mLogger.info((new StringBuilder()).append("onSliderChanged: ").append(i).append(", fromUser: ").append(flag).toString());
        if ((enableFastPreview || !flag) && mCurrentTask == null)
        {
            float f = (i - 50) * 2;
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            applyFilter(f, flag, true);
        }
    }

    protected void onSliderEnd(int i)
    {
        mLogger.info((new StringBuilder()).append("onSliderEnd: ").append(i).toString());
        if (enableFastPreview)
        {
            killCurrentTask(false);
            onProgressEnd();
        }
        float f = (i - 50) * 2;
        boolean flag;
        if (!enableFastPreview)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        applyFilter(f, flag, false);
    }

    protected void onSliderStart(int i)
    {
        if (enableFastPreview)
        {
            onProgressStart();
        }
    }




/*
    static MoaActionList access$202(NativeEffectRangePanel nativeeffectrangepanel, MoaActionList moaactionlist)
    {
        nativeeffectrangepanel.mActions = moaactionlist;
        return moaactionlist;
    }

*/



/*
    static ApplyFilterTask access$402(NativeEffectRangePanel nativeeffectrangepanel, ApplyFilterTask applyfiltertask)
    {
        nativeeffectrangepanel.mCurrentTask = applyfiltertask;
        return applyfiltertask;
    }

*/
}
