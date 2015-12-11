// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.poshmark.analytics.Analytics;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.fragments.SearchResultsFragment;
import com.poshmark.utils.SearchFilterModel;

public class ListingDetailsColorItem extends LinearLayout
{

    String category;
    PMColor color;
    Context context;
    String screenNameForAnalytics;
    String searchTriggerType;

    public ListingDetailsColorItem(Context context1, AttributeSet attributeset)
    {
        super(context1, attributeset);
        searchTriggerType = "clr";
        context = context1;
        setupListener();
    }

    private void setupListener()
    {
        setOnClickListener(new android.view.View.OnClickListener() {

            final ListingDetailsColorItem this$0;

            public void onClick(View view)
            {
                Analytics.getInstance().trackEvent(screenNameForAnalytics, "listing", "browse_listings_by_color", null);
                SearchFilterModel searchfiltermodel = new SearchFilterModel();
                searchfiltermodel.setSearchTrigger(searchTriggerType);
                searchfiltermodel.setAvailability("available");
                Object obj = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
                if (obj != null && ((UserStateSummary) (obj)).user_info.isMySizeAvailable())
                {
                    searchfiltermodel.enableMySizeFilter(true);
                }
                if (category != null && category.length() > 0)
                {
                    searchfiltermodel.setCategory(category);
                    searchfiltermodel.addColor(color.name);
                    searchfiltermodel.setFacet("brand");
                    searchfiltermodel.setFacet("size");
                    searchfiltermodel.setFacet("category_v2");
                    searchfiltermodel.setFacet("category_feature");
                }
                obj = (PMContainerActivity)view.getContext();
                InputMethodManager inputmethodmanager = (InputMethodManager)((PMContainerActivity) (obj)).getSystemService("input_method");
                if (inputmethodmanager.isAcceptingText())
                {
                    if (((PMContainerActivity) (obj)).getCurrentFocus() != null)
                    {
                        inputmethodmanager.hideSoftInputFromWindow(view.getWindowToken(), 0);
                    } else
                    {
                        inputmethodmanager.toggleSoftInput(1, 0);
                    }
                }
                view = new Bundle();
                view.putString("SEARCH_TRIGGER", searchTriggerType);
                ((PMContainerActivity) (obj)).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/SearchResultsFragment, searchfiltermodel);
            }

            
            {
                this$0 = ListingDetailsColorItem.this;
                super();
            }
        });
    }

    public void setCategory(String s)
    {
        category = s;
    }

    public void setColor(PMColor pmcolor)
    {
        ImageView imageview = (ImageView)findViewById(0x7f0c00d4);
        GradientDrawable gradientdrawable = (GradientDrawable)context.getResources().getDrawable(0x7f020038);
        gradientdrawable.setColor(Color.parseColor(pmcolor.rgb.trim()));
        imageview.setImageDrawable(gradientdrawable);
        ((TextView)findViewById(0x7f0c00d5)).setText(pmcolor.getName());
        color = pmcolor;
    }

    public void setParentScreenNameForAnalytics(String s)
    {
        screenNameForAnalytics = s;
    }
}
