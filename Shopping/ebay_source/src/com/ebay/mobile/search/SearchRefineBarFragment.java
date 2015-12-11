// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SearchResult;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.search.refine.types.ItemConditionHelper;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import java.text.NumberFormat;

// Referenced classes of package com.ebay.mobile.search:
//            DetailMode, DetailLaunchMode, SearchActivitySync

public final class SearchRefineBarFragment extends BaseFragment
    implements android.view.View.OnClickListener
{
    public static interface OnSearchRefineBarListener
    {

        public abstract void onFollowSearch(SearchResultFragmentActivity.FollowSearchOrigin followsearchorigin);

        public abstract void onShowRefinement(DetailMode detailmode, DetailLaunchMode detaillaunchmode);

        public abstract void onUnfollowSearch();

        public abstract void onViewSwitched(int i);
    }


    private SearchActivitySync activitySync;
    private TextView buyingFormatView;
    private TextView conditionView;
    private int currentSearchView;
    private TextView followView;
    private ItemConditionHelper helper;
    private TextView itemCountView;
    private OnSearchRefineBarListener listener;
    private TextView refineView;
    private TextView sortView;
    private ImageView viewSwitcherView;

    public SearchRefineBarFragment()
    {
        currentSearchView = 0;
    }

    private void onBuyingFormatButtonClicked()
    {
        listener.onShowRefinement(DetailMode.AUCTION_FORMAT, DetailLaunchMode.ONE_SHOT);
    }

    private void onConditionButtonClicked()
    {
        listener.onShowRefinement(DetailMode.CONDITION, DetailLaunchMode.ONE_SHOT);
    }

    private void onFollowButtonClicked()
    {
        if (!activitySync.isFollowing())
        {
            listener.onFollowSearch(SearchResultFragmentActivity.FollowSearchOrigin.CAROUSEL);
            return;
        } else
        {
            listener.onUnfollowSearch();
            return;
        }
    }

    private void onRefineButtonClicked()
    {
        listener.onShowRefinement(DetailMode.ROOT, DetailLaunchMode.DEFAULT);
    }

    private void onSortViewClicked()
    {
        listener.onShowRefinement(DetailMode.SORT, DetailLaunchMode.ONE_SHOT);
    }

    private void onViewSwitcherClicked()
    {
        int i = currentSearchView + 1;
        currentSearchView = i;
        currentSearchView = i % 2;
        updateViewSwitcherState();
        listener.onViewSwitched(currentSearchView);
    }

    private int refinementsSelected(SearchParameters searchparameters)
    {
        int j = searchparameters.getRefinementDelta(eBayDictionaryProvider.getDefaultSearchParameters(getActivity(), searchparameters.keywords));
        searchparameters = searchparameters.aspectHistogram;
        int i = j;
        if (searchparameters != null)
        {
            i = j + searchparameters.getAppliedAspectCount();
        }
        return i;
    }

    private void updateAuctionBuyItNowButton(SearchParameters searchparameters)
    {
        int i = 0x7f0d00df;
        if (!searchparameters.bestOfferOnly) goto _L2; else goto _L1
_L1:
        searchparameters = getString(0x7f070523);
_L4:
        buyingFormatView.setTextColor(getResources().getColor(i));
        buyingFormatView.setText(searchparameters);
        return;
_L2:
        switch (searchparameters.buyingFormat)
        {
        default:
            i = 0x7f0d00dd;
            searchparameters = getString(0x7f07051c);
            break;

        case 5: // '\005'
            searchparameters = getString(0x7f07055f);
            break;

        case 6: // '\006'
            searchparameters = getString(0x7f070529);
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void updateConditionButton(String s)
    {
        if (!TextUtils.isEmpty(s) && !com.ebay.mobile.search.refine.types.ItemConditionHelper.ItemConditionState.ANY.equals(s))
        {
            conditionView.setTextColor(getResources().getColor(0x7f0d00df));
            conditionView.setText(helper.getLocalizedCondition(s));
            return;
        } else
        {
            conditionView.setTextColor(getResources().getColor(0x7f0d00dd));
            conditionView.setText(getString(0x7f070535));
            return;
        }
    }

    private void updateFollowButtonState()
    {
        boolean flag = activitySync.isFollowing();
        TextView textview = followView;
        Resources resources = getResources();
        int i;
        if (flag)
        {
            i = 0x7f0d00df;
        } else
        {
            i = 0x7f0d00dd;
        }
        textview.setTextColor(resources.getColor(i));
        textview = followView;
        resources = getResources();
        if (flag)
        {
            i = 0x7f070956;
        } else
        {
            i = 0x7f070955;
        }
        textview.setText(resources.getString(i));
    }

    private void updateItemCountButtonState(SearchResult searchresult)
    {
        int i;
        if (searchresult.totalItemCount >= 100 && DeviceConfiguration.getAsync().get(DcsBoolean.SearchSmartDisplay))
        {
            i = searchresult.totalItemCountWithDupes;
        } else
        {
            i = searchresult.totalItemCount;
        }
        searchresult = NumberFormat.getInstance().format(i);
        searchresult = getResources().getQuantityString(0x7f080015, i, new Object[] {
            searchresult
        });
        itemCountView.setText(searchresult);
    }

    private void updateRefineButtonState(SearchParameters searchparameters)
    {
        Resources resources = getResources();
        int i = refinementsSelected(searchparameters);
        if (i > 0)
        {
            refineView.setTextColor(resources.getColor(0x7f0d00df));
            refineView.setText(resources.getString(0x7f0708e2, new Object[] {
                Integer.valueOf(i)
            }));
            return;
        } else
        {
            refineView.setTextColor(resources.getColor(0x7f0d00dd));
            refineView.setText(resources.getString(0x7f0708e1));
            return;
        }
    }

    private void updateSortPopupMenuState(SearchParameters searchparameters)
    {
        String as[];
        Object obj;
        String s;
        int j;
        boolean flag1;
        boolean flag2;
        flag1 = false;
        obj = getActivity().getResources();
        boolean flag;
        if (searchparameters.soldItemsOnly || searchparameters.completedListings)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            as = ((Resources) (obj)).getStringArray(0x7f0e001c);
            obj = ((Resources) (obj)).getStringArray(0x7f0e001e);
        } else
        {
            as = ((Resources) (obj)).getStringArray(0x7f0e001b);
            obj = ((Resources) (obj)).getStringArray(0x7f0e001d);
        }
        if (obj.length != as.length)
        {
            throw new IllegalStateException("Array resources sort_list_entries and sort_list_entry_values must be the same length");
        }
        s = searchparameters.sortOrder;
        flag2 = false;
        j = ((flag2) ? 1 : 0);
        if (s == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        j = ((flag2) ? 1 : 0);
        if (i >= obj.length) goto _L2; else goto _L3
_L3:
        if (!s.equals(obj[i])) goto _L5; else goto _L4
_L4:
        j = i;
_L2:
label0:
        {
            if (isTabletLayout())
            {
                sortView.setText((new StringBuilder()).append(getString(0x7f070ad7)).append(": ").append(as[j]).toString());
            }
            if (searchparameters.sortOrder != null)
            {
                i = ((flag1) ? 1 : 0);
                if (!searchparameters.sortOrder.equals("BestMatch"))
                {
                    break label0;
                }
            }
            i = 1;
        }
        searchparameters = sortView;
        Resources resources = getResources();
        if (i == 0)
        {
            i = 0x7f0d00df;
        } else
        {
            i = 0x7f0d00dd;
        }
        searchparameters.setTextColor(resources.getColor(i));
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public boolean isTabletLayout()
    {
        return viewSwitcherView != null;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            listener = (OnSearchRefineBarListener)activity;
            activitySync = (SearchActivitySync)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement these interfaces: ").append(com/ebay/mobile/search/SearchRefineBarFragment$OnSearchRefineBarListener.toString()).append(com/ebay/mobile/search/SearchActivitySync.toString()).toString());
        }
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        case 2131756532: 
        case 2131756533: 
        default:
            return;

        case 2131756536: 
            onViewSwitcherClicked();
            return;

        case 2131756531: 
            onSortViewClicked();
            return;

        case 2131756529: 
            onRefineButtonClicked();
            return;

        case 2131756530: 
            onFollowButtonClicked();
            return;

        case 2131756534: 
            onConditionButtonClicked();
            return;

        case 2131756535: 
            onBuyingFormatButtonClicked();
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f0301e3, viewgroup);
        helper = new ItemConditionHelper(layoutinflater.getContext());
        currentSearchView = MyApp.getPrefs().getPrefSearchView(0);
        refineView = (TextView)layoutinflater.findViewById(0x7f1005f1);
        conditionView = (TextView)layoutinflater.findViewById(0x7f1005f6);
        buyingFormatView = (TextView)layoutinflater.findViewById(0x7f1005f7);
        followView = (TextView)layoutinflater.findViewById(0x7f1005f2);
        itemCountView = (TextView)layoutinflater.findViewById(0x7f1005f0);
        sortView = (TextView)layoutinflater.findViewById(0x7f1005f3);
        viewSwitcherView = (ImageView)layoutinflater.findViewById(0x7f1005f8);
        if (viewSwitcherView != null)
        {
            updateViewSwitcherState();
        }
        if (refineView != null)
        {
            refineView.setOnClickListener(this);
        }
        if (conditionView != null)
        {
            conditionView.setOnClickListener(this);
        }
        if (buyingFormatView != null)
        {
            buyingFormatView.setOnClickListener(this);
        }
        if (followView != null)
        {
            followView.setOnClickListener(this);
        }
        if (sortView != null)
        {
            sortView.setOnClickListener(this);
        }
        if (viewSwitcherView != null)
        {
            viewSwitcherView.setOnClickListener(this);
        }
        return layoutinflater;
    }

    public void onFollowsChanged()
    {
        if (followView != null)
        {
            updateFollowButtonState();
        }
    }

    public void setViewSwitcherState(int i)
    {
        currentSearchView = i;
        updateViewSwitcherState();
    }

    public void updateFragmentState(SearchResult searchresult)
    {
        SearchParameters searchparameters = searchresult.getSearchParameters();
        if (followView != null && sortView != null)
        {
            if (activitySync.isFollowBarEnabled())
            {
                followView.setVisibility(8);
                sortView.setVisibility(0);
            } else
            {
                followView.setVisibility(0);
                sortView.setVisibility(8);
            }
        }
        if (itemCountView != null)
        {
            updateItemCountButtonState(searchresult);
        }
        if (refineView != null)
        {
            updateRefineButtonState(searchparameters);
        }
        if (followView != null)
        {
            updateFollowButtonState();
        }
        if (sortView != null)
        {
            updateSortPopupMenuState(searchparameters);
        }
        if (conditionView != null)
        {
            updateConditionButton(searchparameters.condition);
        }
        if (buyingFormatView != null)
        {
            updateAuctionBuyItNowButton(searchparameters);
        }
    }

    public void updateViewSwitcherState()
    {
        int i = (currentSearchView + 1) % 2;
        if (viewSwitcherView != null)
        {
            viewSwitcherView.setImageResource(SearchActivitySync.viewIconsSelected.get(i));
            viewSwitcherView.setContentDescription(getString(SearchActivitySync.viewModeAccessibilityStrings.get(i)));
        }
    }
}
