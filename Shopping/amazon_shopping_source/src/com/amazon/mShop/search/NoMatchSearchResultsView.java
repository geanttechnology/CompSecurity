// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.barcodeSearch.HelpWithBarcodeScansActivity;
import com.amazon.mShop.recommendations.RecommendationsActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;

// Referenced classes of package com.amazon.mShop.search:
//            SearchActivity

public class NoMatchSearchResultsView extends LinearLayout
{

    private AmazonActivity mActivity;
    private Button mGoldBox;
    private Button mHelp;
    private TextView mMoreOptionsTitle;
    private Button mRecommendedForYou;
    private String mResultsType;
    private Button mSearchAgainButton;

    public NoMatchSearchResultsView(AmazonActivity amazonactivity, String s)
    {
        super(amazonactivity);
        mActivity = amazonactivity;
        mResultsType = s;
        amazonactivity = View.inflate(amazonactivity, com.amazon.mShop.android.lib.R.layout.search_results_no_match_view, null);
        init(amazonactivity);
        addView(amazonactivity);
    }

    private void init(View view)
    {
        mSearchAgainButton = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.search_results_view_research_button);
        mSearchAgainButton.setOnClickListener(new android.view.View.OnClickListener() {

            final NoMatchSearchResultsView this$0;

            public void onClick(View view1)
            {
                ((SearchActivity)mActivity).setSearchEntryViewAsRoot(((SearchActivity)mActivity).getIntent(), false);
            }

            
            {
                this$0 = NoMatchSearchResultsView.this;
                super();
            }
        });
        mMoreOptionsTitle = (TextView)view.findViewById(com.amazon.mShop.android.lib.R.id.search_results_view_group_title);
        mMoreOptionsTitle.setText(com.amazon.mShop.android.lib.R.string.more);
        mRecommendedForYou = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.search_dead_end_link_recommendations);
        mRecommendedForYou.setOnClickListener(new android.view.View.OnClickListener() {

            final NoMatchSearchResultsView this$0;

            public void onClick(View view1)
            {
                view1 = new Intent(mActivity, com/amazon/mShop/recommendations/RecommendationsActivity);
                view1.setFlags(0x20000);
                mActivity.startActivity(view1);
            }

            
            {
                this$0 = NoMatchSearchResultsView.this;
                super();
            }
        });
        mGoldBox = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.search_dead_end_link_goldbox);
        mGoldBox.setOnClickListener(new android.view.View.OnClickListener() {

            final NoMatchSearchResultsView this$0;

            public void onClick(View view1)
            {
                ActivityUtils.startDealsActivity(mActivity, null, null);
            }

            
            {
                this$0 = NoMatchSearchResultsView.this;
                super();
            }
        });
        if (ConfigUtils.isEnabled(mActivity, com.amazon.mShop.android.lib.R.string.config_hasGoldbox))
        {
            mGoldBox.setVisibility(0);
        } else
        {
            mGoldBox.setVisibility(8);
        }
        mHelp = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.search_dead_end_link_help);
        mHelp.setOnClickListener(new android.view.View.OnClickListener() {

            final NoMatchSearchResultsView this$0;

            public void onClick(View view1)
            {
                if (!Util.isEmpty(mResultsType) && mResultsType.equals("scanItSearchResultsType"))
                {
                    view1 = new Intent(mActivity, com/amazon/mShop/barcodeSearch/HelpWithBarcodeScansActivity);
                    view1.setFlags(0x20000);
                    mActivity.startActivity(view1);
                }
            }

            
            {
                this$0 = NoMatchSearchResultsView.this;
                super();
            }
        });
    }


}
