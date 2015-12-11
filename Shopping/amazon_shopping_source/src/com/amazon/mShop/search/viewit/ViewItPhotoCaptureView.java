// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItActivity, ViewItSlidingDrawerBrowser, ViewItUtil, ViewItSearchResultWrapper, 
//            ViewItDBHelper, ViewItSlidingDrawerView, ViewItDialogHelper, ViewItScannedItemAnimationFrame, 
//            CameraBgHelper, ViewItMetricHelper

public class ViewItPhotoCaptureView extends FrameLayout
{

    private ViewItActivity mActivity;
    private ViewItSlidingDrawerBrowser mBrowser;
    private FrameLayout mCameraFrameLayout;
    private ViewItDBHelper mDBHelper;
    private ViewItDialogHelper mDialogHelper;
    private ViewItSlidingDrawer.OnDrawerCloseListener mOnDrawerCloseListener;
    private ViewItSlidingDrawer.OnDrawerOpenListener mOnDrawerOpenListener;
    private ViewItScannedItemAnimationFrame mScannedItemAnimationFrame;
    private ViewItSlidingDrawerView mSlidingDrawer;
    private ToggleButton mTopFlashButton;
    private View mTopFlashButtonGroup;
    private TextView mTopTitle;
    private View mTopToolBar;
    private View mWindowOverCamera;

    public ViewItPhotoCaptureView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mOnDrawerOpenListener = new ViewItSlidingDrawer.OnDrawerOpenListener() {

            final ViewItPhotoCaptureView this$0;

            public void onDrawerOpened()
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                    final _cls3 this$1;

                    public void run()
                    {
                        mActivity.getViewItMetricHelper().logCountMetricsPerSession("history-maximized", 1);
                        RefMarkerObserver.logRefMarker("fl_tray_open");
                        mSlidingDrawer.updateHandleBackground(0.0F);
                        mSlidingDrawer.updateBottomToolBar();
                        mActivity.getCameraBgHelper().setCameraFlashMode("off");
                        updateFlashModeButtonVisibility();
                        updateTitle(com.amazon.mShop.android.lib.R.string.view_it_history_text);
                        if (mScannedItemAnimationFrame.getVisibility() == 0)
                        {
                            mScannedItemAnimationFrame.updateSlidingDrawerAndDismissAnimationWindow(false);
                        }
                        if (!mActivity.isEnginePaused())
                        {
                            mActivity.pauseEngine();
                        }
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            
            {
                this$0 = ViewItPhotoCaptureView.this;
                super();
            }
        };
        mOnDrawerCloseListener = new ViewItSlidingDrawer.OnDrawerCloseListener() {

            final ViewItPhotoCaptureView this$0;

            public void onDrawerClosed()
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                    final _cls4 this$1;

                    public void run()
                    {
                        mActivity.getViewItMetricHelper().logCountMetricsPerSession("history-minimized", 1);
                        RefMarkerObserver.logRefMarker("fl_tray_close");
                        mSlidingDrawer.updateHandleBackground(1.0F);
                        mSlidingDrawer.updateBottomToolBar();
                        updateFlashModeButtonVisibility();
                        updateTitle(com.amazon.mShop.android.lib.R.string.view_it_searching);
                        ViewItSlidingDrawerBrowser viewitslidingdrawerbrowser = mSlidingDrawer.getBrowser();
                        viewitslidingdrawerbrowser.deleteUndoObject();
                        if (viewitslidingdrawerbrowser.getObjectsCount() == 0 && !mSlidingDrawer.isProgressBarDisplayed())
                        {
                            mSlidingDrawer.setListViewHeaderVisibility(0);
                            mSlidingDrawer.updateBottomOffset(getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_vertical_bottom_empty_offset));
                        } else
                        {
                            com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

                                final _cls1 this$2;

                                public void run()
                                {
                                    mSlidingDrawer.getListView().setSelection(1);
                                }

            
            {
                this$2 = _cls1.this;
                super();
            }
                            });
                        }
                        if (!mActivity.isEngineStopped()) goto _L2; else goto _L1
_L1:
                        mActivity.startScanning();
_L4:
                        mActivity.enableLoading();
                        mActivity.enableDrawing();
                        return;
_L2:
                        if (mActivity.isEnginePaused())
                        {
                            mActivity.unpauseEngine();
                        }
                        if (true) goto _L4; else goto _L3
_L3:
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
            }

            
            {
                this$0 = ViewItPhotoCaptureView.this;
                super();
            }
        };
        mActivity = (ViewItActivity)context;
    }

    private boolean existsInHistoryList(List list, ResultWrapper.ResultType resulttype)
    {
        ViewItSearchResultWrapper viewitsearchresultwrapper = mBrowser.getObjectAtIndex(0);
        if (viewitsearchresultwrapper != null && ViewItUtil.isSimilarObject(list, viewitsearchresultwrapper, resulttype, true))
        {
            return true;
        }
        list = ViewItUtil.removeSimilarObjectFromHistory(list, resulttype, mBrowser, mDBHelper, true);
        if (list != null)
        {
            list.setDeletedAsin(null);
            list.setRecentlyScanned(true);
            list.updateScannedDate();
            mBrowser.getRecentlyScannedObjects().add(0, list);
            mDBHelper.update(list);
            mSlidingDrawer.getViewItSlidingDrawerItemAdapter().notifyDataSetChanged();
            return true;
        } else
        {
            return false;
        }
    }

    public FrameLayout getCameraFrameLayout()
    {
        return mCameraFrameLayout;
    }

    public View getTopToolBar()
    {
        return mTopToolBar;
    }

    public ViewItDialogHelper getViewItDialogHelper()
    {
        return mDialogHelper;
    }

    public ViewItScannedItemAnimationFrame getViewItScannedItemAnimationFrame()
    {
        return mScannedItemAnimationFrame;
    }

    public ViewItSlidingDrawerBrowser getViewItSlidingDrawerBrowser()
    {
        return mBrowser;
    }

    public ViewItSlidingDrawerView getViewItSlidingDrawerView()
    {
        return mSlidingDrawer;
    }

    public View getWindowOverCamera()
    {
        return mWindowOverCamera;
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mDialogHelper.clearErrorWindow();
    }

    public void onFinishInflate()
    {
        super.onFinishInflate();
        mCameraFrameLayout = new FrameLayout(mActivity);
        android.widget.FrameLayout.LayoutParams layoutparams = new android.widget.FrameLayout.LayoutParams(-1, -1);
        mCameraFrameLayout.setLayoutParams(layoutparams);
        addView(mCameraFrameLayout, 0);
        mCameraFrameLayout.setBackgroundResource(com.amazon.mShop.android.lib.R.color.view_it_dark_background);
        mCameraFrameLayout.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewItPhotoCaptureView this$0;

            public void onClick(View view)
            {
                if (mDialogHelper.isPauseDialogShowing())
                {
                    mDialogHelper.clearErrorWindow();
                    return;
                } else
                {
                    mActivity.getCameraBgHelper().focusOnClick();
                    return;
                }
            }

            
            {
                this$0 = ViewItPhotoCaptureView.this;
                super();
            }
        });
        mWindowOverCamera = findViewById(com.amazon.mShop.android.lib.R.id.view_it_window_over_camera);
        mSlidingDrawer = (ViewItSlidingDrawerView)findViewById(com.amazon.mShop.android.lib.R.id.sliding_drawer);
        mSlidingDrawer.setOnDrawerOpenListener(mOnDrawerOpenListener);
        mSlidingDrawer.setOnDrawerCloseListener(mOnDrawerCloseListener);
        mBrowser = mSlidingDrawer.getBrowser();
        mDBHelper = mBrowser.getViewItDBHelper();
        mScannedItemAnimationFrame = (ViewItScannedItemAnimationFrame)findViewById(com.amazon.mShop.android.lib.R.id.view_it_animation_frame);
        mScannedItemAnimationFrame.setViewItSlidingDrawer(mSlidingDrawer);
        mTopToolBar = findViewById(com.amazon.mShop.android.lib.R.id.view_it_top_tool_bar);
        mTopTitle = (TextView)mTopToolBar.findViewById(com.amazon.mShop.android.lib.R.id.view_it_top_title);
        mTopFlashButtonGroup = findViewById(com.amazon.mShop.android.lib.R.id.view_it_top_camera_flash_button_group);
        mTopFlashButton = (ToggleButton)findViewById(com.amazon.mShop.android.lib.R.id.view_it_top_camera_flash_btn);
        mTopFlashButtonGroup.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewItPhotoCaptureView this$0;

            public void onClick(View view)
            {
                view = mTopFlashButton;
                boolean flag;
                if (!mTopFlashButton.isChecked())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                view.setChecked(flag);
                mActivity.getCameraBgHelper().switchCameraFlashMode();
            }

            
            {
                this$0 = ViewItPhotoCaptureView.this;
                super();
            }
        });
        mDialogHelper = new ViewItDialogHelper(mActivity, this);
        if (!NetInfo.hasNetworkConnection())
        {
            mDialogHelper.showDialog(null, mActivity.getString(com.amazon.mShop.android.lib.R.string.view_it_error_network_error), ViewItDialogHelper.DialogType.ERROR_NETWORK);
        }
    }

    public void showLoadingWindow(List list, ResultWrapper.ResultType resulttype)
    {
        if (!existsInHistoryList(list, resulttype))
        {
            mScannedItemAnimationFrame.popUpLoadingWindow(list, resulttype);
            return;
        } else
        {
            updateTitleForPeriod(com.amazon.mShop.android.lib.R.string.view_it_product_found, com.amazon.mShop.android.lib.R.string.view_it_searching);
            return;
        }
    }

    public void updateFlashModeButtonVisibility()
    {
        CameraBgHelper camerabghelper = mActivity.getCameraBgHelper();
        if (camerabghelper.isCameraFlashModeOff())
        {
            mTopFlashButton.setChecked(false);
        }
        if (!mSlidingDrawer.isOpened() && camerabghelper.isSupportedFlashTorchMode())
        {
            mTopFlashButtonGroup.setVisibility(0);
            return;
        } else
        {
            mTopFlashButtonGroup.setVisibility(8);
            return;
        }
    }

    public void updateTitle(int i)
    {
        if (mTopTitle != null)
        {
            mTopTitle.setText(i);
        }
    }

    public void updateTitleForPeriod(int i, final int back_resid)
    {
        updateTitle(i);
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final ViewItPhotoCaptureView this$0;
            final int val$back_resid;

            public void run()
            {
                if (!mSlidingDrawer.isOpened())
                {
                    updateTitle(back_resid);
                }
            }

            
            {
                this$0 = ViewItPhotoCaptureView.this;
                back_resid = i;
                super();
            }
        }, 1000L);
    }





}
