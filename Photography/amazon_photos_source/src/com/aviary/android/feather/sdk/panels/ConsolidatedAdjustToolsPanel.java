// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import com.aviary.android.feather.common.tracking.AviaryTracker;
import com.aviary.android.feather.common.utils.ApiHelper;
import com.aviary.android.feather.common.utils.os.AviaryAsyncTask;
import com.aviary.android.feather.headless.filters.IFilter;
import com.aviary.android.feather.headless.filters.INativeFilter;
import com.aviary.android.feather.headless.filters.NativeFilter;
import com.aviary.android.feather.headless.filters.impl.AdjustColorFilter;
import com.aviary.android.feather.headless.filters.impl.AdjustExposureFilter;
import com.aviary.android.feather.headless.filters.impl.AdjustSliderFilter;
import com.aviary.android.feather.headless.moa.MoaActionList;
import com.aviary.android.feather.headless.moa.MoaResult;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.filters.ToolLoaderFactory;
import com.aviary.android.feather.library.graphics.drawable.FakeBitmapDrawable;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.library.utils.BitmapUtils;
import com.aviary.android.feather.library.vo.EditToolResultVO;
import com.aviary.android.feather.library.vo.ToolActionVO;
import com.aviary.android.feather.sdk.widget.AviaryTextView;
import java.util.HashMap;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AbstractOptionPanel

public class ConsolidatedAdjustToolsPanel extends AbstractOptionPanel
    implements android.view.View.OnClickListener, android.widget.SeekBar.OnSeekBarChangeListener
{
    class ApplyFilterTask extends AviaryAsyncTask
    {

        IFilter filter;
        boolean isPreview;
        Bitmap mCurrentBitmap;
        MoaResult mResult;
        boolean mShowProgress;
        final ConsolidatedAdjustToolsPanel this$0;

        private Bitmap acquireBitmap(boolean flag)
        {
            if (flag)
            {
                Bitmap bitmap = Bitmap.createBitmap(mBitmap.getWidth() / 3, mBitmap.getHeight() / 3, mBitmap.getConfig());
                BitmapUtils.copy(mBitmap, bitmap);
                return bitmap;
            } else
            {
                return Bitmap.createBitmap(mBitmap.getWidth(), mBitmap.getHeight(), mBitmap.getConfig());
            }
        }

        protected transient Bitmap doInBackground(Bitmap abitmap[])
        {
            if (isCancelled() || filter == null)
            {
                return null;
            }
            mCurrentBitmap = acquireBitmap(isPreview);
            if (isCancelled())
            {
                return null;
            }
            if (!isPreview)
            {
                break MISSING_BLOCK_LABEL_86;
            }
            mResult = ((INativeFilter)filter).prepare(mCurrentBitmap, mCurrentBitmap, 1, 1);
_L1:
            mResult.execute();
            if (isCancelled())
            {
                return null;
            }
            break MISSING_BLOCK_LABEL_125;
            try
            {
                mResult = ((INativeFilter)filter).prepare(mBitmap, mCurrentBitmap, 1, 1);
            }
            // Misplaced declaration of an exception variable
            catch (Bitmap abitmap[])
            {
                abitmap.printStackTrace();
                return null;
            }
              goto _L1
            mActions = ((NativeFilter)filter).getActions();
            if (isCancelled())
            {
                return null;
            } else
            {
                return mCurrentBitmap;
            }
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Bitmap[])aobj);
        }

        protected void doPostExecute(Bitmap bitmap)
        {
            mLogger.info("onPostExecute, isPreview: %b", new Object[] {
                Boolean.valueOf(isPreview)
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
                if (isPreview)
                {
                    FakeBitmapDrawable fakebitmapdrawable = new FakeBitmapDrawable(bitmap, mBitmap.getWidth(), mBitmap.getHeight());
                    onPreviewChanged(fakebitmapdrawable, false, true);
                } else
                {
                    onPreviewChanged(bitmap, false, true);
                }
                setIsChanged(true);
                mPreview = bitmap;
            } else
            {
                BitmapUtils.copy(mBitmap, mPreview);
                onPreviewChanged(mPreview, false, true);
                setIsChanged(false);
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

        public ApplyFilterTask(boolean flag, boolean flag1)
        {
            this$0 = ConsolidatedAdjustToolsPanel.this;
            super();
            isPreview = flag1;
            mShowProgress = flag;
            filter = ToolLoaderFactory.get(getName());
            if (filter != null)
            {
                ((AdjustSliderFilter)filter).setAdjustTool(0, convertValue(mAdjustToolValues.get(0)));
                ((AdjustSliderFilter)filter).setAdjustTool(1, convertValue(mAdjustToolValues.get(1)));
                ((AdjustSliderFilter)filter).setAdjustTool(2, convertValue(mAdjustToolValues.get(2)));
                ((AdjustSliderFilter)filter).setAdjustTool(3, convertValue(mAdjustToolValues.get(3)));
            }
        }
    }

    class GenerateResultTask extends AviaryAsyncTask
    {

        ProgressDialog mProgress;
        final ConsolidatedAdjustToolsPanel this$0;

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
            mLogger.info("GenerateResultTask::PostExecute");
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
            this$0 = ConsolidatedAdjustToolsPanel.this;
            super();
            mProgress = new ProgressDialog(getContext().getBaseContext());
        }
    }

    class ViewPagerAdapter extends PagerAdapter
    {

        final LayoutInflater inflater;
        final ConsolidatedAdjustToolsPanel this$0;

        public void destroyItem(ViewGroup viewgroup, int i, Object obj)
        {
            viewgroup.removeView((View)obj);
        }

        public int getCount()
        {
            return 4;
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            View view;
            SeekBar seekbar;
            view = inflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_adjust_seekbar, viewgroup, false);
            seekbar = (SeekBar)view.findViewById(com.aviary.android.feather.sdk.R.id.aviary_seekbar);
            View view1 = view.findViewById(com.aviary.android.feather.sdk.R.id.aviary_button_plus);
            view.findViewById(com.aviary.android.feather.sdk.R.id.aviary_button_minus).setOnClickListener(ConsolidatedAdjustToolsPanel.this);
            view1.setOnClickListener(ConsolidatedAdjustToolsPanel.this);
            i;
            JVM INSTR tableswitch 0 3: default 88
        //                       0 114
        //                       1 179
        //                       2 160
        //                       3 198;
               goto _L1 _L2 _L3 _L4 _L5
_L1:
            seekbar.setOnSeekBarChangeListener(ConsolidatedAdjustToolsPanel.this);
            seekbar.setTag(Integer.valueOf(i));
            viewgroup.addView(view, 0);
            return view;
_L2:
            seekbar.setProgress(mAdjustToolValues.get(0));
            if (mFirstLaunch)
            {
                mCurrentSeekBar = seekbar;
                mFirstLaunch = false;
            }
            continue; /* Loop/switch isn't completed */
_L4:
            seekbar.setProgress(mAdjustToolValues.get(2));
            continue; /* Loop/switch isn't completed */
_L3:
            seekbar.setProgress(mAdjustToolValues.get(1));
            continue; /* Loop/switch isn't completed */
_L5:
            seekbar.setProgress(mAdjustToolValues.get(3));
            if (true) goto _L1; else goto _L6
_L6:
        }

        public boolean isViewFromObject(View view, Object obj)
        {
            return view == obj;
        }

        ViewPagerAdapter(Context context)
        {
            this$0 = ConsolidatedAdjustToolsPanel.this;
            super();
            inflater = LayoutInflater.from(context);
        }
    }


    private static final int POSITION_TOOL_1 = 0;
    private static final int POSITION_TOOL_2 = 1;
    private static final int POSITION_TOOL_3 = 2;
    private static final int POSITION_TOOL_4 = 3;
    static final int PREVIEW_FAKE_RATIO = 3;
    private static final int TOOL_COUNT = 4;
    boolean enableFastPreview;
    MoaActionList mActions;
    ViewPagerAdapter mAdapter;
    SparseIntArray mAdjustToolValues;
    SeekBar mCurrentSeekBar;
    ApplyFilterTask mCurrentTask;
    private int mCurrentToolId;
    boolean mFirstLaunch;
    volatile boolean mIsRendering;
    final ToolActionVO mToolAction = new ToolActionVO();
    ViewPager mViewPager;
    View tool1;
    View tool2;
    View tool3;
    View tool4;

    public ConsolidatedAdjustToolsPanel(IAviaryController iaviarycontroller, ToolEntry toolentry)
    {
        super(iaviarycontroller, toolentry);
        enableFastPreview = ApiHelper.AT_LEAST_14;
        mIsRendering = false;
        mFirstLaunch = true;
        mCurrentToolId = 0;
        mAdjustToolValues = new SparseIntArray();
    }

    private void changeSeekBarToCurrent(int i)
    {
        if (mCurrentSeekBar == null)
        {
            return;
        }
        switch (i)
        {
        default:
            return;

        case 0: // '\0'
            mCurrentSeekBar.setProgress(mAdjustToolValues.get(0));
            return;

        case 2: // '\002'
            mCurrentSeekBar.setProgress(mAdjustToolValues.get(2));
            return;

        case 1: // '\001'
            mCurrentSeekBar.setProgress(mAdjustToolValues.get(1));
            return;

        case 3: // '\003'
            mCurrentSeekBar.setProgress(mAdjustToolValues.get(3));
            break;
        }
    }

    private String getToolName(int i)
    {
        if (getName() == com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.LIGHTING)
        {
            return AdjustExposureFilter.getToolName(i);
        }
        if (getName() == com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.COLOR)
        {
            return AdjustColorFilter.getToolName(i);
        } else
        {
            return "invalid";
        }
    }

    private void setToolNames()
    {
        if (getName() == com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.LIGHTING)
        {
            ((AviaryTextView)tool1).setText(com.aviary.android.feather.sdk.R.string.feather_brightness);
            ((AviaryTextView)tool2).setText(com.aviary.android.feather.sdk.R.string.feather_contrast);
            ((AviaryTextView)tool3).setText(com.aviary.android.feather.sdk.R.string.feather_tool_highlight);
            ((AviaryTextView)tool4).setText(com.aviary.android.feather.sdk.R.string.feather_tool_shadow);
        }
        if (getName() == com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.COLOR)
        {
            ((AviaryTextView)tool1).setText(com.aviary.android.feather.sdk.R.string.feather_saturation);
            ((AviaryTextView)tool2).setText(com.aviary.android.feather.sdk.R.string.feather_tool_temperature);
            ((AviaryTextView)tool3).setText(com.aviary.android.feather.sdk.R.string.feather_tool_tint);
            ((AviaryTextView)tool4).setText(com.aviary.android.feather.sdk.R.string.feather_tool_fade);
        }
    }

    private void setToolSelected(int i)
    {
        mViewPager.setCurrentItem(i);
        i;
        JVM INSTR tableswitch 0 3: default 40
    //                   0 90
    //                   1 101
    //                   2 112
    //                   3 123;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        if (i == mCurrentToolId) goto _L7; else goto _L6
_L6:
        mCurrentToolId;
        JVM INSTR tableswitch 0 3: default 84
    //                   0 134
    //                   1 145
    //                   2 156
    //                   3 167;
           goto _L7 _L8 _L9 _L10 _L11
_L7:
        mCurrentToolId = i;
        return;
_L2:
        tool1.setSelected(true);
          goto _L1
_L3:
        tool2.setSelected(true);
          goto _L1
_L4:
        tool3.setSelected(true);
          goto _L1
_L5:
        tool4.setSelected(true);
          goto _L1
_L8:
        tool1.setSelected(false);
          goto _L7
_L9:
        tool2.setSelected(false);
          goto _L7
_L10:
        tool3.setSelected(false);
          goto _L7
_L11:
        tool4.setSelected(false);
          goto _L7
    }

    private void updatedToolValue(int i, int j)
    {
        mLogger.log((new StringBuilder()).append("new value tag, value: ").append(i).append(", ").append(j).toString());
        mAdjustToolValues.put(i, j);
    }

    protected void applyFilter(boolean flag, boolean flag1)
    {
        mLogger.info("applyFilter(showProgress:%b, isPreview:%b)", new Object[] {
            Boolean.valueOf(flag), Boolean.valueOf(flag1)
        });
        if (!enableFastPreview)
        {
            boolean flag2;
            if (!enableFastPreview)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            killCurrentTask(flag2);
        }
        mIsRendering = true;
        mCurrentTask = new ApplyFilterTask(flag, flag1);
        mCurrentTask.execute(new Bitmap[] {
            mBitmap
        });
        setIsChanged(true);
    }

    double convertValue(float f)
    {
        return (double)((f - 50F) * 2.0F);
    }

    protected void decreaseValue()
    {
        if (mCurrentSeekBar == null)
        {
            return;
        } else
        {
            updatedToolValue(((Integer)mCurrentSeekBar.getTag()).intValue(), mCurrentSeekBar.getProgress() - 1);
            mCurrentSeekBar.setProgress(mCurrentSeekBar.getProgress() - 1);
            onSliderEnd(mCurrentSeekBar.getProgress());
            return;
        }
    }

    protected ViewGroup generateOptionView(LayoutInflater layoutinflater, ViewGroup viewgroup)
    {
        return (ViewGroup)layoutinflater.inflate(com.aviary.android.feather.sdk.R.layout.aviary_panel_adjustment_consolidation, viewgroup, false);
    }

    protected void increaseValue()
    {
        if (mCurrentSeekBar == null)
        {
            return;
        } else
        {
            updatedToolValue(((Integer)mCurrentSeekBar.getTag()).intValue(), mCurrentSeekBar.getProgress() + 1);
            mCurrentSeekBar.setProgress(mCurrentSeekBar.getProgress() + 1);
            onSliderEnd(mCurrentSeekBar.getProgress());
            return;
        }
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
            applyFilter(false, false);
            setValue(50);
        }
    }

    public void onCancelled()
    {
        killCurrentTask(true);
        mIsRendering = false;
        super.onCancelled();
    }

    public void onClick(View view)
    {
        if (view != null)
        {
            int i = view.getId();
            if (i == com.aviary.android.feather.sdk.R.id.aviary_button_plus)
            {
                increaseValue();
                return;
            }
            if (i == com.aviary.android.feather.sdk.R.id.aviary_button_minus)
            {
                decreaseValue();
                return;
            }
            if (i == com.aviary.android.feather.sdk.R.id.tool1)
            {
                setToolSelected(0);
                getContext().getTracker().tagEvent("adjust: option_selected", new String[] {
                    "name", getToolName(0)
                });
                return;
            }
            if (i == com.aviary.android.feather.sdk.R.id.tool2)
            {
                setToolSelected(1);
                getContext().getTracker().tagEvent("adjust: option_selected", new String[] {
                    "name", getToolName(1)
                });
                return;
            }
            if (i == com.aviary.android.feather.sdk.R.id.tool3)
            {
                setToolSelected(2);
                getContext().getTracker().tagEvent("adjust: option_selected", new String[] {
                    "name", getToolName(2)
                });
                return;
            }
            if (i == com.aviary.android.feather.sdk.R.id.tool4)
            {
                setToolSelected(3);
                getContext().getTracker().tagEvent("adjust: option_selected", new String[] {
                    "name", getToolName(3)
                });
                return;
            }
        }
    }

    protected void onComplete(Bitmap bitmap, EditToolResultVO edittoolresultvo)
    {
        edittoolresultvo.setToolAction(mToolAction);
        edittoolresultvo.setActionList(mActions);
        int j = 0;
        int i = 0;
        while (i < 4) 
        {
            if (convertValue(mAdjustToolValues.get(i)) != 0.0D)
            {
                mTrackingAttributes.put(getToolName(i), "true");
                j++;
            } else
            {
                mTrackingAttributes.put(getToolName(i), "false");
            }
            i++;
        }
        mTrackingAttributes.put("item_count", String.valueOf(j));
        super.onComplete(bitmap, edittoolresultvo);
    }

    public void onCreate(Bitmap bitmap, Bundle bundle)
    {
        super.onCreate(bitmap, bundle);
        mAdapter = new ViewPagerAdapter(getContext().getBaseContext());
        mViewPager = (ViewPager)getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.aviary_pager);
        mViewPager.setAdapter(mAdapter);
        mViewPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.SimpleOnPageChangeListener() {

            final ConsolidatedAdjustToolsPanel this$0;

            public void onPageSelected(int i)
            {
                mLogger.info("onPageSelected: %d", new Object[] {
                    Integer.valueOf(i)
                });
                mCurrentSeekBar = (SeekBar)mViewPager.findViewWithTag(Integer.valueOf(i));
                changeSeekBarToCurrent(i);
            }

            
            {
                this$0 = ConsolidatedAdjustToolsPanel.this;
                super();
            }
        });
        tool1 = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.tool1);
        tool2 = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.tool2);
        tool3 = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.tool3);
        tool4 = getOptionView().findViewById(com.aviary.android.feather.sdk.R.id.tool4);
        setToolNames();
        tool1.setOnClickListener(this);
        tool2.setOnClickListener(this);
        tool3.setOnClickListener(this);
        tool4.setOnClickListener(this);
        mAdjustToolValues.put(0, 50);
        mAdjustToolValues.put(1, 50);
        mAdjustToolValues.put(3, 50);
        mAdjustToolValues.put(2, 50);
        setToolSelected(0);
        changeSeekBarToCurrent(0);
    }

    public void onDeactivate()
    {
        onProgressEnd();
        super.onDeactivate();
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

    public final void onProgressChanged(SeekBar seekbar, int i, boolean flag)
    {
        onSliderChanged(i, flag);
    }

    protected void onSliderChanged(int i, boolean flag)
    {
        mLogger.info((new StringBuilder()).append("onSliderChanged: ").append(i).append(", fromUser: ").append(flag).toString());
        updatedToolValue(mViewPager.getCurrentItem(), i);
        if ((enableFastPreview || !flag) && mCurrentTask == null)
        {
            if (!flag)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            applyFilter(flag, true);
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
        boolean flag;
        if (!enableFastPreview)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        applyFilter(flag, false);
    }

    protected void onSliderStart(int i)
    {
        if (enableFastPreview)
        {
            onProgressStart();
        }
    }

    public final void onStartTrackingTouch(SeekBar seekbar)
    {
        onSliderStart(seekbar.getProgress());
    }

    public final void onStopTrackingTouch(SeekBar seekbar)
    {
        onSliderEnd(seekbar.getProgress());
    }

    public volatile void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
    }

    protected void setValue(int i)
    {
        mCurrentSeekBar.setProgress(i);
    }

}
