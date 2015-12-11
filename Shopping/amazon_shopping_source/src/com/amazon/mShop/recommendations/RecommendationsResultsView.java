// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.recommendations;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.ObjectSubscriber;
import com.amazon.mShop.control.recommendations.RecommendationsBrowser;
import com.amazon.mShop.control.recommendations.RecommendationsController;
import com.amazon.mShop.control.recommendations.RecommendationsRatingSubscriber;
import com.amazon.mShop.control.recommendations.RecommendationsSubscriber;
import com.amazon.mShop.control.search.QueryProvider;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.ui.BottomToolBar;
import com.amazon.mShop.util.AmazonErrorUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CategoryResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.recommendations:
//            RecommendationsAdapter, RecommendationsDepartmentAdapter, RecommendationsActivity

public class RecommendationsResultsView extends LinearLayout
    implements TitleProvider, ObjectSubscriber, RecommendationsRatingSubscriber, RecommendationsSubscriber, QueryProvider, com.amazon.mShop.ui.BottomToolBar.ToolBarParent
{

    private AmazonActivity mActivity;
    private RecommendationsAdapter mAdapter;
    private BottomToolBar mBottomToolBar;
    protected final RecommendationsBrowser mBrowser;
    protected CategoryResult mCategoryResult;
    private com.amazon.mShop.ui.BottomToolBar.ToolBarItem mChangeDepartment;
    private final View mFooter;
    protected ListView mListView;
    protected TextView mNoRecommendation;
    private final ProgressBar mProgress;
    protected final RecommendationsDepartmentAdapter mRefineAdapter = new RecommendationsDepartmentAdapter(this);
    private final TextView mStatus;
    private boolean mWaitingForRecsRatingResponse;

    public RecommendationsResultsView(AmazonActivity amazonactivity, String s, String s1)
    {
        super(amazonactivity);
        mActivity = amazonactivity;
        View.inflate(mActivity, com.amazon.mShop.android.lib.R.layout.recs_results_view, this);
        mListView = (ListView)findViewById(com.amazon.mShop.android.lib.R.id.items_list);
        mListView.setHeaderDividersEnabled(false);
        mListView.setFooterDividersEnabled(false);
        mFooter = inflate(amazonactivity, com.amazon.mShop.android.lib.R.layout.search_results_footer, null);
        mProgress = (ProgressBar)mFooter.findViewById(com.amazon.mShop.android.lib.R.id.search_results_progress);
        mStatus = (TextView)mFooter.findViewById(com.amazon.mShop.android.lib.R.id.search_results_status);
        if (!Util.isEmpty(s))
        {
            mCategoryResult = new CategoryResult();
            mCategoryResult.setCategory(s);
            mCategoryResult.setDisplayName(s1);
        }
        mListView.addFooterView(mFooter, null, false);
        mAdapter = new RecommendationsAdapter(amazonactivity, this);
        mBrowser = new RecommendationsBrowser(8, 3, getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.item_row_height) - getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.padding), this, s);
        mAdapter.setBrowser(mBrowser);
        mBrowser.setSecondarySubscriber(this);
        mBrowser.setRecSubscriber(this);
        mListView.setItemsCanFocus(true);
        mNoRecommendation = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.no_recommendation);
        mNoRecommendation.setVisibility(8);
        mAdapter.setListView(mListView);
        mBottomToolBar = (BottomToolBar)findViewById(com.amazon.mShop.android.lib.R.id.bottom_tool_bar);
        mBottomToolBar.setToolBarParent(this);
        initToolBar();
    }

    private void initToolBar()
    {
        ArrayList arraylist = new ArrayList();
        mChangeDepartment = new com.amazon.mShop.ui.BottomToolBar.ToolBarItem(com.amazon.mShop.android.lib.R.id.refine_recs, com.amazon.mShop.android.lib.R.string.search_refine_by_category, false);
        arraylist.add(mChangeDepartment);
        mBottomToolBar.init(arraylist);
    }

    private void refresh()
    {
        resetViewStatus();
        if (mCategoryResult != null)
        {
            refine(mCategoryResult);
            return;
        } else
        {
            mBrowser.startFirstPageRequest(0x7fffffff, null);
            return;
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyevent)
    {
        if (mActivity.menuDispatchedKeyEvent(keyevent))
        {
            return true;
        }
        if (4 == keyevent.getKeyCode() && keyevent.getAction() == 0 && ((RecommendationsActivity)mActivity).needShowErrorInfo() && mActivity.isErrorBoxShowing())
        {
            keyevent = ((RecommendationsActivity)mActivity).constructUserUniqueInfo();
            RecommendationsController.getInstance().eraseRatingRequestErrorInfo(keyevent);
            mActivity.finish();
            return true;
        } else
        {
            return super.dispatchKeyEvent(keyevent);
        }
    }

    public RecommendationsBrowser getBrowser()
    {
        return mBrowser;
    }

    public CategoryResult getCategoryResult()
    {
        return mCategoryResult;
    }

    public String getQuery()
    {
        return null;
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        if (mCategoryResult != null && !Util.isEmpty(mCategoryResult.getDisplayName()))
        {
            return (new StringBuilder()).append(getContext().getString(com.amazon.mShop.android.lib.R.string.recommendations_title)).append(" - ").append(mCategoryResult.getDisplayName()).toString();
        } else
        {
            return getContext().getString(com.amazon.mShop.android.lib.R.string.recommendations_title);
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        RecommendationsController.getInstance().addSubscriber(this);
        setWaitingForRecsRatingResponse(RecommendationsController.getInstance().recsItemsRequestShouldWait());
        if (!mWaitingForRecsRatingResponse && !((RecommendationsActivity)mActivity).needShowErrorInfo())
        {
            mBrowser.startFirstPageRequest(0x7fffffff, null);
        }
    }

    public void onAvailableCountReceived(int i)
    {
    }

    public void onCancelled()
    {
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        RecommendationsController.getInstance().removeSubscriber(this);
        if (mProgress != null)
        {
            mProgress.setVisibility(4);
        }
        mAdapter.dismissDialog();
    }

    public void onError(Exception exception, ServiceCall servicecall)
    {
        Log.e("AmazonActivity", exception.toString());
        servicecall = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final RecommendationsResultsView this$0;

            public void onActionButtonClick(int i)
            {
                mProgress.setVisibility(0);
                mStatus.setText(com.amazon.mShop.android.lib.R.string.loading);
                mStatus.setVisibility(0);
                mBrowser.replayPageRequest();
            }

            
            {
                this$0 = RecommendationsResultsView.this;
                super();
            }
        };
        AmazonErrorUtils.reportMShopServerError(mActivity, servicecall, this, exception);
    }

    public void onObjectReceived(Object obj, int i)
    {
    }

    public void onObjectsReceived()
    {
    }

    public void onPageComplete()
    {
        int i = mBrowser.getReceivedCount() + mBrowser.getRatingPendingIndexSet().size();
        if (mBrowser.getAvailableCount() == 0 && i == 0)
        {
            mProgress.setVisibility(8);
            mStatus.setVisibility(0);
        } else
        if (mBrowser.getAvailableCount() <= i)
        {
            mProgress.setVisibility(8);
            if (!mBrowser.hasCategoryResult())
            {
                mStatus.setVisibility(0);
                mStatus.setText(com.amazon.mShop.android.lib.R.string.search_for_more_results);
            } else
            if (mCategoryResult != null && !Util.isEmpty(mCategoryResult.getDisplayName()))
            {
                mStatus.setVisibility(0);
                mStatus.setText(getResources().getString(com.amazon.mShop.android.lib.R.string.search_end_of_x_top_results_for_y, new Object[] {
                    Integer.valueOf(mBrowser.getReceivedCount()), mCategoryResult.getDisplayName()
                }));
            } else
            {
                mStatus.setVisibility(8);
            }
        } else
        {
            mProgress.setVisibility(0);
            mStatus.setText(com.amazon.mShop.android.lib.R.string.loading);
        }
        if (!mBrowser.hasCategoryResult())
        {
            List list = mBrowser.getRefinements();
            if (list != null && !list.isEmpty())
            {
                mRefineAdapter.update(list);
                mBottomToolBar.setToolBarItemEnabled(mChangeDepartment, true);
            }
        }
    }

    public void onReceivedNoRecommendationsExplanation(String s)
    {
        mNoRecommendation.setText(s);
        mNoRecommendation.setVisibility(0);
    }

    public void onRecsRatingCallCancelled()
    {
        setWaitingForRecsRatingResponse(false);
    }

    public void onRecsRatingCallCompleted()
    {
        setWaitingForRecsRatingResponse(false);
        if (mCategoryResult != null)
        {
            refine(mCategoryResult);
            return;
        } else
        {
            mBrowser.startFirstPageRequest(0x7fffffff, null);
            return;
        }
    }

    public void onRecsRatingCallError()
    {
        setWaitingForRecsRatingResponse(false);
        if (mActivity.getCurrentView() instanceof RecommendationsResultsView)
        {
            showErrorDialog();
        }
    }

    public void onRecsRatingCallStarted()
    {
        setWaitingForRecsRatingResponse(true);
        mBrowser.cancel();
        resetViewStatus();
    }

    public void onToolBarItemSelected(com.amazon.mShop.ui.BottomToolBar.ToolBarItem toolbaritem)
    {
        if (toolbaritem.getItemId() == com.amazon.mShop.android.lib.R.id.refine_recs)
        {
            toolbaritem = (new com.amazon.mShop.AmazonAlertDialog.Builder(mActivity)).create();
            mRefineAdapter.bindAmazonAlertDialog(toolbaritem);
            AmazonAlertDialog.customizeAlertDialog(mActivity, toolbaritem, getResources().getString(com.amazon.mShop.android.lib.R.string.search_refine_by_category), mRefineAdapter, mRefineAdapter, mRefineAdapter.getSelectedPosition());
            toolbaritem.show();
        }
    }

    public void refine(CategoryResult categoryresult)
    {
        mCategoryResult = categoryresult;
        mNoRecommendation.setVisibility(8);
        mActivity.updateTitle(this);
        if (!mWaitingForRecsRatingResponse)
        {
            if (categoryresult.getCategory() == null)
            {
                mCategoryResult = null;
            }
            mProgress.setVisibility(0);
            mStatus.setText(com.amazon.mShop.android.lib.R.string.loading);
            mStatus.setVisibility(0);
            mBrowser.refine(mCategoryResult);
            mAdapter.notifyDataSetChanged();
        }
    }

    public void resetViewStatus()
    {
        mBrowser.clearRatingPendingIndexSet();
        mBrowser.clearAllList();
        mAdapter.notifyDataSetChanged();
        mNoRecommendation.setVisibility(8);
        mProgress.setVisibility(0);
        mStatus.setText(com.amazon.mShop.android.lib.R.string.loading);
        mStatus.setVisibility(0);
    }

    public void setWaitingForRecsRatingResponse(boolean flag)
    {
        mWaitingForRecsRatingResponse = flag;
    }

    public void showErrorDialog()
    {
        com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener amazonerrorboxactionlistener;
        byte byte0;
        if (NetInfo.hasNetworkConnection())
        {
            byte0 = 4;
        } else
        {
            byte0 = 1;
        }
        amazonerrorboxactionlistener = new com.amazon.mShop.error.AmazonErrorBox.AmazonErrorBoxActionListener() {

            final RecommendationsResultsView this$0;

            public void onActionButtonClick(int i)
            {
                String s = ((RecommendationsActivity)mActivity).constructUserUniqueInfo();
                RecommendationsController.getInstance().eraseRatingRequestErrorInfo(s);
                refresh();
            }

            
            {
                this$0 = RecommendationsResultsView.this;
                super();
            }
        };
        AmazonErrorUtils.reportError(mActivity, byte0, amazonerrorboxactionlistener, this, com.amazon.mShop.android.lib.R.string.recommendations_alert_info, com.amazon.mShop.android.lib.R.string.recommendations_ok);
    }




}
