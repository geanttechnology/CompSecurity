// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.PagedItemAdapter;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.ui.BottomToolBar;
import com.amazon.mShop.util.DBException;
import com.amazon.mShop.util.UIUtils;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            ViewItSlidingDrawer, ViewItActivity, ViewItSlidingDrawerBrowser, ViewItHistoryListView, 
//            ViewItDBHelper, ViewItItemView, ViewItPhotoCaptureView, ViewItScannedItemAnimationFrame, 
//            ViewItSearchResultWrapper, ViewItDialogHelper

public class ViewItSlidingDrawerView extends ViewItSlidingDrawer
    implements TitleProvider, com.amazon.mShop.ui.BottomToolBar.ToolBarParent
{
    public class ViewItSlidingDrawerItemAdapter extends PagedItemAdapter
    {

        final ViewItSlidingDrawerView this$0;

        public int getCount()
        {
            return mBrowser.getRecentlyScannedObjects().size() + mBrowser.getReceivedCount();
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            if (i >= mBrowser.getRecentlyScannedObjects().size())
            {
                mBrowser.setCurrentIndex(i - mBrowser.getRecentlyScannedObjects().size());
            }
            viewgroup = (ViewItSearchResultWrapper)browser.getObjectAtIndex(i);
            SearchResult searchresult = (SearchResult)viewgroup.getSearchResults().get(0);
            if (view == null)
            {
                view = (ViewItItemView)layoutInflater.inflate(rowResId, null);
            } else
            {
                view = (ViewItItemView)view;
            }
            view.setObject(viewgroup, searchresult, mBrowser, ViewItItemView.ItemShowType.ITME_SHOW_AS_GROUP);
            view.updateButtonVisibility();
            if (mBrowser.isObjectToDelete(viewgroup, searchresult, ViewItItemView.ItemShowType.ITME_SHOW_AS_GROUP))
            {
                view.showUndoButtonContent();
            } else
            {
                view.showItemContent();
            }
            view.update(this, viewgroup.getSearchResults().get(0), (byte[])null, i);
            view.setItemClickAction(ViewItSlidingDrawerView.this, (SearchResult)viewgroup.getSearchResults().get(0), viewgroup, false);
            if (i == 0 && isClosed())
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(view. new Runnable() {

                    final ViewItSlidingDrawerItemAdapter this$1;
                    final ViewItItemView val$itemView;

                    public void run()
                    {
                        if (mHeaderContent.getVisibility() == 8)
                        {
                            setBottomOffsetToFirstItemHeight(itemView);
                        }
                    }

            
            {
                this$1 = final_viewitslidingdraweritemadapter;
                itemView = ViewItItemView.this;
                super();
            }
                });
            }
            return view;
        }

        public void onCancelled()
        {
            hideProgressBar();
            updateHeaderVisibilityAndBottomOffset();
        }

        public void onError(Exception exception, ServiceCall servicecall)
        {
            hideProgressBar();
            updateHeaderVisibilityAndBottomOffset();
            mActivity.getPhotoCaptureView().getViewItDialogHelper().showDialog(null, UIUtils.getMessageForException(mActivity, exception), ViewItDialogHelper.DialogType.ERROR_MSHOP_SERVER);
        }

        public void onPageComplete()
        {
            super.onPageComplete();
            if (mBrowser.getAllHistoryDBObjects().size() > mBrowser.getNextPageStartIndex())
            {
                showProgressBar();
            } else
            {
                hideProgressBar();
            }
            mAdapter.notifyDataSetChanged();
        }

        public void setBrowser(PagedListingBrowser pagedlistingbrowser)
        {
            super.setBrowser(pagedlistingbrowser);
            ((ViewItSlidingDrawerBrowser)pagedlistingbrowser).setSlidingDrawerPageListingAdapter(this);
        }

        public ViewItSlidingDrawerItemAdapter(AmazonActivity amazonactivity, int i)
        {
            this$0 = ViewItSlidingDrawerView.this;
            super(amazonactivity, i);
        }
    }


    private ViewItActivity mActivity;
    private ViewItSlidingDrawerItemAdapter mAdapter;
    private BottomToolBar mBottomToolBar;
    private ViewItSlidingDrawerBrowser mBrowser;
    private com.amazon.mShop.ui.BottomToolBar.ToolBarItem mDeleteAllButton;
    private int mEmptyBottonOffset;
    private View mHandle;
    private View mHeaderContent;
    private ViewItHistoryListView mListView;
    private ProgressBar mProgress;
    private int mProgressSpinnerMinimumHeight;
    private TextView mStatus;

    public ViewItSlidingDrawerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mActivity = (ViewItActivity)context;
        mEmptyBottonOffset = -getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_vertical_bottom_empty_offset);
        mProgressSpinnerMinimumHeight = mEmptyBottonOffset;
    }

    private void hideProgressBar()
    {
        mProgress.setVisibility(8);
        mStatus.setVisibility(8);
    }

    private void showProgressBar()
    {
        mHeaderContent.setVisibility(8);
        mProgress.setVisibility(0);
        mStatus.setText(com.amazon.mShop.android.lib.R.string.loading);
        mStatus.setVisibility(0);
    }

    private void startBottomToolBarTransitionAnimation(View view, boolean flag)
    {
        float f = 0.0F;
        float f1 = 0.0F;
        TranslateAnimation translateanimation;
        if (flag)
        {
            f = 1.0F;
        } else
        {
            f1 = 1.0F;
        }
        translateanimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, f, 1, f1);
        translateanimation.setDuration(300L);
        translateanimation.setInterpolator(new LinearInterpolator());
        view.startAnimation(translateanimation);
    }

    private void updateHeaderVisibilityAndBottomOffset()
    {
        if (mBrowser.getObjectsCount() == 0)
        {
            setListViewHeaderVisibility(0);
            updateBottomOffset(getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_vertical_bottom_empty_offset));
        }
    }

    public int getBottomOffset()
    {
        return mBottomOffset;
    }

    public ViewItSlidingDrawerBrowser getBrowser()
    {
        return mBrowser;
    }

    public ListView getListView()
    {
        return mListView;
    }

    public View getListViewHeaderContent()
    {
        return mHeaderContent;
    }

    public CharSequence getTitle()
    {
        return getResources().getString(com.amazon.mShop.android.lib.R.string.history_title);
    }

    public ViewItSlidingDrawerItemAdapter getViewItSlidingDrawerItemAdapter()
    {
        return mAdapter;
    }

    public boolean isProgressBarDisplayed()
    {
        return mProgress.getVisibility() == 0;
    }

    protected boolean isScrolledToTop()
    {
        return mListView.isListViewScrolledToTop();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mBrowser.cancel();
    }

    protected void onFinishInflate()
    {
        mHandle = findViewById(com.amazon.mShop.android.lib.R.id.drawer_handle);
        mListView = (ViewItHistoryListView)findViewById(com.amazon.mShop.android.lib.R.id.items_list);
        mListView.setSlidingDrawerView(this);
        mListView.setDividerHeight(0);
        mListView.setItemsCanFocus(true);
        Object obj = inflate(mActivity, com.amazon.mShop.android.lib.R.layout.view_it_sliding_drawer_header, null);
        mHeaderContent = ((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.view_it_sliding_drawer_empty_indication);
        mListView.addHeaderView(((View) (obj)), null, false);
        obj = inflate(mActivity, com.amazon.mShop.android.lib.R.layout.view_it_item_loading_progress, null);
        mProgress = (ProgressBar)((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.loading_progress);
        mStatus = (TextView)((View) (obj)).findViewById(com.amazon.mShop.android.lib.R.id.loading_results_status);
        mListView.addFooterView(((View) (obj)), null, false);
        mBrowser = new ViewItSlidingDrawerBrowser(mActivity, 8, 3);
        mAdapter = new ViewItSlidingDrawerItemAdapter((AmazonActivity)getContext(), com.amazon.mShop.android.lib.R.layout.view_it_item_row);
        mAdapter.setBrowser(mBrowser);
        mAdapter.setListView(mListView);
        mListView.setOnItemClickListener(null);
        mDeleteAllButton = new com.amazon.mShop.ui.BottomToolBar.ToolBarItem(com.amazon.mShop.android.lib.R.id.view_it_delete_all_history, com.amazon.mShop.android.lib.R.string.view_it_history_delete_all, false);
        obj = new ArrayList();
        ((List) (obj)).add(mDeleteAllButton);
        mBottomToolBar = (BottomToolBar)findViewById(com.amazon.mShop.android.lib.R.id.bottom_tool_bar);
        mBottomToolBar.setToolBarParent(this);
        mBottomToolBar.init(((List) (obj)));
        mBottomToolBar.setVisibility(8);
        super.onFinishInflate();
        updateHandleBackground(1.0F);
    }

    public void onToolBarItemSelected(final com.amazon.mShop.ui.BottomToolBar.ToolBarItem dialog)
    {
        if (dialog.getItemId() == com.amazon.mShop.android.lib.R.id.view_it_delete_all_history)
        {
            RefMarkerObserver.logRefMarker("fl_del_all");
            dialog = new com.amazon.mShop.AmazonAlertDialog.Builder(getContext());
            dialog.setCancelable(true);
            dialog.setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

                final ViewItSlidingDrawerView this$0;

                public void onCancel(DialogInterface dialoginterface)
                {
                    dialoginterface.dismiss();
                }

            
            {
                this$0 = ViewItSlidingDrawerView.this;
                super();
            }
            });
            dialog = dialog.create();
            dialog.show();
            dialog.getWindow().setContentView(com.amazon.mShop.android.lib.R.layout.view_it_delete_all_history_dialog);
            ((Button)dialog.findViewById(com.amazon.mShop.android.lib.R.id.delete_all_cancel)).setOnClickListener(new android.view.View.OnClickListener() {

                final ViewItSlidingDrawerView this$0;
                final AmazonAlertDialog val$dialog;

                public void onClick(View view)
                {
                    dialog.dismiss();
                }

            
            {
                this$0 = ViewItSlidingDrawerView.this;
                dialog = amazonalertdialog;
                super();
            }
            });
            ((Button)dialog.findViewById(com.amazon.mShop.android.lib.R.id.delete_all_ok)).setOnClickListener(new android.view.View.OnClickListener() {

                final ViewItSlidingDrawerView this$0;
                final AmazonAlertDialog val$dialog;

                public void onClick(View view)
                {
                    mBrowser.deleteAllObjects();
                    hideProgressBar();
                    mHeaderContent.setVisibility(0);
                    mBottomToolBar.setToolBarItemEnabled(mDeleteAllButton, false);
                    mAdapter.notifyDataSetChanged();
                    animateClose();
                    dialog.dismiss();
                    return;
                    view;
                    view.printStackTrace();
                    dialog.dismiss();
                    return;
                    view;
                    dialog.dismiss();
                    throw view;
                }

            
            {
                this$0 = ViewItSlidingDrawerView.this;
                dialog = amazonalertdialog;
                super();
            }
            });
        }
    }

    protected void prepareContent()
    {
        super.prepareContent();
        if (!isOpened()) goto _L2; else goto _L1
_L1:
        if (!mActivity.isEngineStopped()) goto _L4; else goto _L3
_L3:
        mActivity.startScanning();
_L2:
        mActivity.disableLoading();
        mActivity.disableDrawing();
        return;
_L4:
        if (mActivity.isEnginePaused())
        {
            mActivity.unpauseEngine();
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    protected void refresh()
    {
        List list = mBrowser.getViewItDBHelper().getAllHistoryItems();
        if (list.size() == 0)
        {
            hideProgressBar();
            mHeaderContent.setVisibility(0);
            mAdapter.notifyDataSetChanged();
            return;
        } else
        {
            showProgressBar();
            mBrowser.startFirstPageRequest(list);
            mAdapter.notifyDataSetChanged();
            return;
        }
    }

    public void setBottomOffsetToFirstItemHeight(ViewItItemView viewititemview)
    {
        if ((mBottomOffset != mEmptyBottonOffset || mHeaderContent.getVisibility() != 0) && viewititemview != null)
        {
            int j = viewititemview.getHeight();
            int k = viewititemview.getDeleteButtonHeight();
            int i = j;
            if (k > 0)
            {
                i = j - k - getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.view_it_item_button_padding) * 2 - 2;
            }
            if (i != -mBottomOffset)
            {
                if (i < mProgressSpinnerMinimumHeight && mActivity.getPhotoCaptureView().getViewItScannedItemAnimationFrame().isLoading())
                {
                    updateBottomOffset(-mProgressSpinnerMinimumHeight);
                } else
                {
                    updateBottomOffset(-i);
                }
                if (isClosed())
                {
                    mAdapter.notifyDataSetChanged();
                    return;
                }
            }
        }
    }

    public void setListViewHeaderVisibility(int i)
    {
        mHeaderContent.setVisibility(i);
    }

    public void updateBottomOffset(int i)
    {
        mBottomOffset = i;
    }

    public void updateBottomToolBar()
    {
        if (isOpened())
        {
            if (mBrowser.getObjectsCount() > 0)
            {
                mBottomToolBar.setToolBarItemEnabled(mDeleteAllButton, true);
            } else
            {
                mBottomToolBar.setToolBarItemEnabled(mDeleteAllButton, false);
            }
            if (mBottomToolBar.getVisibility() == 8)
            {
                mBottomToolBar.setVisibility(0);
                startBottomToolBarTransitionAnimation(mBottomToolBar, true);
            }
        } else
        if (mBottomToolBar.getVisibility() == 0)
        {
            startBottomToolBarTransitionAnimation(mBottomToolBar, false);
            mBottomToolBar.setVisibility(8);
            return;
        }
    }

    public void updateHandleBackground(float f)
    {
        int j = 0xdddddd;
        int i = j;
        if (f >= 0.0F)
        {
            i = j;
            if (f <= 1.0F)
            {
                i = 0xdddddd | (int)(255F - 127F * f) << 24;
            }
        }
        mHandle.setBackgroundColor(i);
    }









}
