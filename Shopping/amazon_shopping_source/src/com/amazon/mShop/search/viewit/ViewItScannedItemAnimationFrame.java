// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItItemBarcodeSearchController, ViewItItemImageSearchController, ViewItSlidingDrawerView, 
//            ViewItAnimationItemView, ViewItPhotoCaptureView, ViewItDialogHelper, ViewItSlidingDrawerBrowser, 
//            ViewItSearchResultWrapper, ViewItUtil, ViewItDBHelper

public class ViewItScannedItemAnimationFrame extends LinearLayout
{

    private ViewItActivity mActivity;
    private ViewItSlidingDrawerView.ViewItSlidingDrawerItemAdapter mAdapter;
    private ViewItItemBarcodeSearchController mBarcodeSearchController;
    private ViewItSlidingDrawerBrowser mBrowser;
    private ViewItItemImageSearchController mImageSearchController;
    private boolean mIsAnimationEnd;
    private boolean mIsErrorHappened;
    private ViewGroup mItemContent;
    private ViewItAnimationItemView mItemRow;
    private View mProgressContainer;
    private View mProgressSpinner;
    private int mProgressSpinnerMinimumHeight;
    private ViewItSlidingDrawerView mSlidingDrawer;
    private TextView mStatus;

    public ViewItScannedItemAnimationFrame(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mIsErrorHappened = false;
        mActivity = (ViewItActivity)context;
        mProgressSpinnerMinimumHeight = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_sliding_drawer_empty_height);
    }

    private void cancel()
    {
        if (mBarcodeSearchController != null)
        {
            mBarcodeSearchController.cancel();
        }
        if (mImageSearchController != null)
        {
            mImageSearchController.cancel();
        }
    }

    private int getStatusBarHeight()
    {
        Rect rect = new Rect();
        mActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    private void hideProgressBar()
    {
        mProgressContainer.setVisibility(8);
        mProgressSpinner.setVisibility(8);
        mStatus.setVisibility(8);
    }

    private void prepareLoading(boolean flag)
    {
        setVisibility(0);
        mItemContent.setClickable(false);
        mItemContent.setVisibility(8);
        mIsAnimationEnd = false;
        if (flag)
        {
            showProgressBar();
            return;
        } else
        {
            hideProgressBar();
            return;
        }
    }

    private void showProgressBar()
    {
        android.view.ViewGroup.LayoutParams layoutparams = mProgressContainer.getLayoutParams();
        if (layoutparams.height != -mSlidingDrawer.getBottomOffset())
        {
            if (-mSlidingDrawer.getBottomOffset() < mProgressSpinnerMinimumHeight)
            {
                layoutparams.height = mProgressSpinnerMinimumHeight;
            } else
            {
                layoutparams.height = -mSlidingDrawer.getBottomOffset();
            }
            mProgressContainer.setLayoutParams(layoutparams);
        }
        mProgressContainer.setVisibility(0);
        mProgressSpinner.setVisibility(0);
        mStatus.setVisibility(0);
        mStatus.setText(com.amazon.mShop.android.lib.R.string.loading);
    }

    private void startItemScaleAndTranslateAnimation()
    {
        mIsAnimationEnd = false;
        ScaleAnimation scaleanimation = new ScaleAnimation(0.5F, 1.0F, 0.5F, 1.0F, 1, 0.5F, 1, 0.5F);
        int i = -mSlidingDrawer.getBottomOffset();
        int k = mActivity.getWindowManager().getDefaultDisplay().getHeight();
        int i1 = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_top_toolbar_height);
        TranslateAnimation translateanimation;
        AnimationSet animationset;
        if (getResources().getConfiguration().orientation == 1)
        {
            k = (k - getStatusBarHeight() - i1 - -mSlidingDrawer.getBottomOffset()) / 2;
            i1 = i / 2;
            int j1 = -mSlidingDrawer.getBottomOffset();
            translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 0, -(k + i1), 0, -(j1 - i));
        } else
        {
            int l = getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_bottom_toolbar_height);
            int j = (mSlidingDrawer.mBottomOffset + mSlidingDrawer.getHandle().getWidth()) / 2;
            l = -(l / 2);
            translateanimation = new TranslateAnimation(0, j, 0, j, 0, l, 0, l);
        }
        animationset = new AnimationSet(true);
        animationset.addAnimation(scaleanimation);
        animationset.addAnimation(translateanimation);
        animationset.setInterpolator(new AccelerateDecelerateInterpolator());
        animationset.setFillAfter(true);
        animationset.setDuration(1000L);
        animationset.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

            final ViewItScannedItemAnimationFrame this$0;

            public void onAnimationEnd(Animation animation)
            {
                mIsAnimationEnd = true;
                if (getVisibility() == 0)
                {
                    if (mProgressSpinner.getVisibility() == 8)
                    {
                        updateSlidingDrawerAndDismissAnimationWindow(false);
                    } else
                    if (-mSlidingDrawer.getBottomOffset() < mProgressSpinnerMinimumHeight)
                    {
                        mSlidingDrawer.updateBottomOffset(-mProgressSpinnerMinimumHeight);
                        mAdapter.notifyDataSetChanged();
                        return;
                    }
                }
            }

            public void onAnimationRepeat(Animation animation)
            {
            }

            public void onAnimationStart(Animation animation)
            {
            }

            
            {
                this$0 = ViewItScannedItemAnimationFrame.this;
                super();
            }
        });
        mItemRow.startAnimation(animationset);
    }

    public void dismissAnimationWindow(boolean flag)
    {
        setVisibility(8);
        if (flag)
        {
            mActivity.enableLoading();
        }
    }

    public boolean isLoading()
    {
        return getVisibility() == 0 && mProgressSpinner.getVisibility() == 0;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        hideProgressBar();
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        setVisibility(8);
        mItemRow = (ViewItAnimationItemView)findViewById(com.amazon.mShop.android.lib.R.id.animation_item_row);
        mItemContent = (ViewGroup)mItemRow.findViewById(com.amazon.mShop.android.lib.R.id.animation_item_content);
        mItemContent.setVisibility(8);
        mProgressContainer = mItemRow.findViewById(com.amazon.mShop.android.lib.R.id.view_it_item_loading_progress);
        mProgressSpinner = mProgressContainer.findViewById(com.amazon.mShop.android.lib.R.id.loading_progress);
        mStatus = (TextView)mProgressContainer.findViewById(com.amazon.mShop.android.lib.R.id.loading_results_status);
        hideProgressBar();
    }

    public void popUpLoadingWindow(List list, ResultWrapper.ResultType resulttype)
    {
        if (getVisibility() != 8 || mSlidingDrawer.isOpened() || mSlidingDrawer.isMoving()) goto _L2; else goto _L1
_L1:
        static class _cls4
        {

            static final int $SwitchMap$com$amazon$mShop$search$viewit$ResultWrapper$ResultType[];

            static 
            {
                $SwitchMap$com$amazon$mShop$search$viewit$ResultWrapper$ResultType = new int[ResultWrapper.ResultType.values().length];
                try
                {
                    $SwitchMap$com$amazon$mShop$search$viewit$ResultWrapper$ResultType[ResultWrapper.ResultType.BARCODE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$mShop$search$viewit$ResultWrapper$ResultType[ResultWrapper.ResultType.IMAGE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4..SwitchMap.com.amazon.mShop.search.viewit.ResultWrapper.ResultType[resulttype.ordinal()];
        JVM INSTR tableswitch 1 2: default 60
    //                   1 61
    //                   2 117;
           goto _L2 _L3 _L4
_L2:
        return;
_L3:
        if (mBarcodeSearchController == null)
        {
            mBarcodeSearchController = new ViewItItemBarcodeSearchController(mActivity, this);
        }
        mBarcodeSearchController.startBarcodeSearch(list);
        mIsErrorHappened = false;
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItScannedItemAnimationFrame this$0;

            public void run()
            {
                if (!mIsErrorHappened)
                {
                    prepareLoading(true);
                    startItemScaleAndTranslateAnimation();
                }
            }

            
            {
                this$0 = ViewItScannedItemAnimationFrame.this;
                super();
            }
        }, 200L);
        return;
_L4:
        if (mImageSearchController == null)
        {
            mImageSearchController = new ViewItItemImageSearchController(mActivity, this);
        }
        mImageSearchController.startBasicProductsRequest(list);
        mIsErrorHappened = false;
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItScannedItemAnimationFrame this$0;

            public void run()
            {
                if (!mIsErrorHappened)
                {
                    prepareLoading(true);
                    startItemScaleAndTranslateAnimation();
                }
            }

            
            {
                this$0 = ViewItScannedItemAnimationFrame.this;
                super();
            }
        }, 200L);
        return;
    }

    public void setViewItSlidingDrawer(ViewItSlidingDrawerView viewitslidingdrawerview)
    {
        mSlidingDrawer = viewitslidingdrawerview;
        mAdapter = mSlidingDrawer.getViewItSlidingDrawerItemAdapter();
        mBrowser = mSlidingDrawer.getBrowser();
    }

    public void showServiceCallErrorInLoadingWindow(String s, String s1, ViewItDialogHelper.DialogType dialogtype)
    {
        mActivity.getPhotoCaptureView().updateTitleForPeriod(com.amazon.mShop.android.lib.R.string.view_it_product_not_found, com.amazon.mShop.android.lib.R.string.view_it_searching);
        mIsErrorHappened = true;
        hideProgressBar();
        mActivity.getPhotoCaptureView().getViewItDialogHelper().showDialog(null, s1, dialogtype);
        dismissAnimationWindow(true);
    }

    public void updateSlidingDrawerAndDismissAnimationWindow(boolean flag)
    {
        if (mSlidingDrawer.getListViewHeaderContent().getVisibility() == 0 && !Util.isEmpty(mBrowser.getRecentlyScannedObjects()))
        {
            mSlidingDrawer.setListViewHeaderVisibility(8);
        }
        mAdapter.notifyDataSetChanged();
        dismissAnimationWindow(flag);
        cancel();
    }

    public void updateToShowItemContentInLoadingWindow(ViewItSearchResultWrapper viewitsearchresultwrapper)
    {
        this;
        JVM INSTR monitorenter ;
        if (Util.isEmpty(viewitsearchresultwrapper.getSearchResults()))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        mActivity.getPhotoCaptureView().updateTitleForPeriod(com.amazon.mShop.android.lib.R.string.view_it_product_found, com.amazon.mShop.android.lib.R.string.view_it_searching);
        if (!ResultWrapper.ResultType.BARCODE.equals(viewitsearchresultwrapper.getResultType())) goto _L2; else goto _L1
_L1:
        ViewItSearchResultWrapper viewitsearchresultwrapper1 = ViewItUtil.removeSimilarObjectFromHistory(viewitsearchresultwrapper.getAsinList(), ResultWrapper.ResultType.BARCODE, mBrowser, mBrowser.getViewItDBHelper(), false);
        if (viewitsearchresultwrapper1 == null) goto _L4; else goto _L3
_L3:
        ViewItUtil.mergeSimilarObejcts(viewitsearchresultwrapper, viewitsearchresultwrapper1);
        viewitsearchresultwrapper1.setDeletedAsin(null);
        viewitsearchresultwrapper1.setRecentlyScanned(true);
        viewitsearchresultwrapper1.updateScannedDate();
        mBrowser.getRecentlyScannedObjects().add(0, viewitsearchresultwrapper1);
        mBrowser.getViewItDBHelper().update(viewitsearchresultwrapper1);
        viewitsearchresultwrapper = viewitsearchresultwrapper1;
_L7:
        hideProgressBar();
        if (!mIsAnimationEnd) goto _L6; else goto _L5
_L5:
        updateSlidingDrawerAndDismissAnimationWindow(false);
_L8:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        mBrowser.addNewSannedObejct(viewitsearchresultwrapper);
          goto _L7
        viewitsearchresultwrapper;
        throw viewitsearchresultwrapper;
_L2:
        mBrowser.addNewSannedObejct(viewitsearchresultwrapper);
          goto _L7
_L6:
        mItemContent.setVisibility(0);
        mItemRow.updateAnimationItem(viewitsearchresultwrapper);
          goto _L8
        showServiceCallErrorInLoadingWindow(null, getResources().getString(com.amazon.mShop.android.lib.R.string.view_it_error_no_matched_item_found), ViewItDialogHelper.DialogType.ERROR_NO_MATCHED_ITEM);
          goto _L8
    }





/*
    static boolean access$302(ViewItScannedItemAnimationFrame viewitscanneditemanimationframe, boolean flag)
    {
        viewitscanneditemanimationframe.mIsAnimationEnd = flag;
        return flag;
    }

*/




}
