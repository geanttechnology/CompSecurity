// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.recommendations;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.PagedItemAdapter;
import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.control.recommendations.RecommendationsBrowser;
import com.amazon.mShop.control.recommendations.RecommendationsController;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.CategoryResult;
import com.amazon.rio.j2me.client.services.mShop.RecsRating;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import java.util.Set;

// Referenced classes of package com.amazon.mShop.recommendations:
//            RecommendationsItemView, RecommendationsResultsView, RecommendationsActivity

public class RecommendationsAdapter extends PagedItemAdapter
{

    private AmazonActivity mActivity;
    private android.view.View.OnClickListener mFixRecommendationClickListener;
    private AmazonAlertDialog mFixThisRecsDialog;
    private RecommendationsResultsView mResultsView;

    public RecommendationsAdapter(AmazonActivity amazonactivity, RecommendationsResultsView recommendationsresultsview)
    {
        super(amazonactivity, com.amazon.mShop.android.lib.R.layout.recs_item_view);
        mFixRecommendationClickListener = new android.view.View.OnClickListener() {

            final RecommendationsAdapter this$0;

            public void onClick(View view)
            {
                if (mFixThisRecsDialog == null || !mFixThisRecsDialog.isShowing())
                {
                    Object obj = new com.amazon.mShop.AmazonAlertDialog.Builder(mActivity);
                    mFixThisRecsDialog = ((com.amazon.mShop.AmazonAlertDialog.Builder) (obj)).create();
                    obj = new ArrayAdapter(mActivity, com.amazon.mShop.android.lib.R.layout.select_dialog_item);
                    ((ArrayAdapter) (obj)).add(mActivity.getString(com.amazon.mShop.android.lib.R.string.recommendations_item_ownit));
                    ((ArrayAdapter) (obj)).add(mActivity.getString(com.amazon.mShop.android.lib.R.string.recommendations_item_notinterest));
                    AmazonAlertDialog.customizeAlertDialog(mActivity, mFixThisRecsDialog, mActivity.getString(com.amazon.mShop.android.lib.R.string.recommendations_fix_this), ((android.widget.ListAdapter) (obj)), view. new android.widget.AdapterView.OnItemClickListener() {

                        final _cls1 this$1;
                        final View val$view;

                        public void onItemClick(AdapterView adapterview, View view1, int i, long l)
                        {
                            mFixThisRecsDialog.dismiss();
                            if (i == 0)
                            {
                                RefMarkerObserver.logRefMarker("recs_o");
                                removeItemAndRefreshUI(_fld0, Integer.parseInt(view.getTag().toString()), 0);
                            } else
                            if (i == 1)
                            {
                                RefMarkerObserver.logRefMarker("recs_ni");
                                removeItemAndRefreshUI(_fld0, Integer.parseInt(view.getTag().toString()), 1);
                                return;
                            }
                        }

            
            {
                this$1 = final__pcls1;
                view = View.this;
                super();
            }
                    }, -1);
                    mFixThisRecsDialog.setCanceledOnTouchOutside(true);
                    mFixThisRecsDialog.show();
                }
            }

            
            {
                this$0 = RecommendationsAdapter.this;
                super();
            }
        };
        mActivity = amazonactivity;
        mResultsView = recommendationsresultsview;
    }

    public void dismissDialog()
    {
        if (mFixThisRecsDialog != null && mFixThisRecsDialog.isShowing())
        {
            mFixThisRecsDialog.dismiss();
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        browser.setCurrentIndex(i);
        if (view == null)
        {
            view = (RecommendationsItemView)layoutInflater.inflate(rowResId, null);
        } else
        {
            view = (RecommendationsItemView)view;
        }
        view.update(this, browser.getObjectAtIndex(i), browser.getImageAtIndex(i), i);
        viewgroup = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.fix_this_recommendation);
        viewgroup.setTag(Integer.valueOf(i));
        viewgroup.setOnClickListener(mFixRecommendationClickListener);
        view.findViewById(com.amazon.mShop.android.lib.R.id.item_amazonpoints).setVisibility(8);
        view.findViewById(com.amazon.mShop.android.lib.R.id.item_used_and_new).setVisibility(8);
        view.findViewById(com.amazon.mShop.android.lib.R.id.item_rating).setVisibility(8);
        view.findViewById(com.amazon.mShop.android.lib.R.id.item_customer_reviews_count).setVisibility(8);
        return view;
    }

    protected Object makeObjectForForward()
    {
        ProductController productcontroller = (ProductController)super.makeObjectForForward();
        productcontroller.setClickStreamTag(ClickStreamTag.ORIGIN_RECOMMENDEDITEMS);
        return productcontroller;
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        super.onItemClick(adapterview, view, i, l);
        com.amazon.mShop.platform.Platform.Factory.getInstance().invokeLater(new Runnable() {

            final RecommendationsAdapter this$0;

            public void run()
            {
                String s = ((RecommendationsActivity)mActivity).constructUserUniqueInfo();
                RecommendationsController.getInstance().sendRecsRatingsForUser(s);
            }

            
            {
                this$0 = RecommendationsAdapter.this;
                super();
            }
        }, 500L);
    }

    public void refreshStatus()
    {
        TextView textview;
        RecommendationsBrowser recommendationsbrowser;
        int i;
        textview = (TextView)mResultsView.findViewById(com.amazon.mShop.android.lib.R.id.search_results_status);
        recommendationsbrowser = (RecommendationsBrowser)browser;
        i = recommendationsbrowser.getReceivedCount() + recommendationsbrowser.getRatingPendingIndexSet().size();
        if (browser.getAvailableCount() > i || !recommendationsbrowser.hasCategoryResult() || textview == null) goto _L2; else goto _L1
_L1:
        if (getBrowser().getReceivedCount() <= 0) goto _L4; else goto _L3
_L3:
        textview.setText(mActivity.getResources().getString(com.amazon.mShop.android.lib.R.string.search_end_of_x_top_results_for_y, new Object[] {
            Integer.valueOf(getBrowser().getReceivedCount()), mResultsView.mCategoryResult.getDisplayName()
        }));
_L6:
        return;
_L4:
        if (getBrowser().getReceivedCount() == 0)
        {
            setNoRecommendation(mResultsView);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (browser.getAvailableCount() <= i && getBrowser().getReceivedCount() == 0)
        {
            setNoRecommendation(mResultsView);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void removeItemAndRefreshUI(RecommendationsAdapter recommendationsadapter, int i, int j)
    {
        Object obj = (RecommendationsBrowser)recommendationsadapter.getBrowser();
        SearchResult searchresult = (SearchResult)((RecommendationsBrowser) (obj)).removeItemAt(i);
        ((RecommendationsBrowser) (obj)).addRatingPendingIndex(((RecommendationsBrowser) (obj)).removeItemIndexAt(i));
        obj = new RecsRating();
        ((RecsRating) (obj)).setAsin(searchresult.getBasicProduct().getAsin());
        ((RecsRating) (obj)).setType(j);
        RecommendationsController.getInstance().addRatingToPendingList(((RecsRating) (obj)));
        recommendationsadapter.notifyDataSetChanged();
        recommendationsadapter.refreshStatus();
    }

    public void setNoRecommendation(RecommendationsResultsView recommendationsresultsview)
    {
        ((TextView)recommendationsresultsview.findViewById(com.amazon.mShop.android.lib.R.id.search_results_status)).setVisibility(8);
        if (recommendationsresultsview.mNoRecommendation.getVisibility() != 0)
        {
            recommendationsresultsview.mNoRecommendation.setText(com.amazon.mShop.android.lib.R.string.recommendations_no_recs_explanation);
            recommendationsresultsview.mNoRecommendation.setVisibility(0);
        }
    }



/*
    static AmazonAlertDialog access$002(RecommendationsAdapter recommendationsadapter, AmazonAlertDialog amazonalertdialog)
    {
        recommendationsadapter.mFixThisRecsDialog = amazonalertdialog;
        return amazonalertdialog;
    }

*/

}
