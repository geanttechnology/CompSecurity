// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.adapters.BundleListAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PMData;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.utils.BundleItemRemoveClickListener;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment

public class UnavailableBundleItemsFragment extends PMFragment
    implements BundleItemRemoveClickListener
{

    BundleListAdapter adapter;
    ListView bundleListView;
    boolean countChanged;
    String sellerUsername;
    List unavailableBundleData;
    String userName;

    public UnavailableBundleItemsFragment()
    {
        countChanged = false;
    }

    private void createAllViews(View view)
    {
        LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
        bundleListView = (ListView)view.findViewById(0x7f0c030b);
        view = (LinearLayout)layoutinflater.inflate(0x7f0300c5, null, false);
        bundleListView.addFooterView(view);
        bundleListView.setAdapter(adapter);
    }

    private void fillCursor(CustomMatrixCursor custommatrixcursor)
    {
        if (custommatrixcursor != null)
        {
            for (Iterator iterator = unavailableBundleData.iterator(); iterator.hasNext(); custommatrixcursor.addRow(new Object[] {
    Integer.valueOf(0), (ListingSummary)iterator.next()
})) { }
        }
    }

    private void updateView()
    {
        CustomMatrixCursor custommatrixcursor = new CustomMatrixCursor(new String[] {
            PMData.ID_COL, PMData.DATA_COL
        });
        fillCursor(custommatrixcursor);
        adapter.changeCursor(custommatrixcursor);
        adapter.notifyDataSetChanged();
    }

    public boolean handleBack()
    {
        PMFragment pmfragment = (PMFragment)getTargetFragment();
        if (pmfragment != null)
        {
            int i = getTargetRequestCode();
            Bundle bundle = new Bundle();
            bundle.putBoolean("UNAVAILABLE_ITEMS_COUNT_CHANGED", countChanged);
            pmfragment.onFragmentResult(bundle, i);
        }
        return false;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            unavailableBundleData = (List)getFragmentDataOfType(java/util/List);
        }
        bundle = getArguments().getString("NAME");
        if (bundle != null)
        {
            userName = bundle.trim().replaceAll("\n", "");
        }
        bundle = getArguments().getString("SELLER_USER_NAME");
        if (bundle != null)
        {
            sellerUsername = bundle.trim().replaceAll("\n", "");
        }
        adapter = new BundleListAdapter(getActivity(), this, this, com.poshmark.data_model.adapters.BundleListAdapter.MODE.VIEW_UNAVAILABLE_ITEMS, null, 0x80000000);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f0300ce, viewgroup, false);
        createAllViews(layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
    }

    public void onPMResume()
    {
        super.onPMResume();
        updateView();
    }

    public void removeItemFromBundle(final int position)
    {
        if (unavailableBundleData != null && position < unavailableBundleData.size())
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "remove_listing_from_bundle_tapped", null);
            ListingSummary listingsummary = (ListingSummary)unavailableBundleData.get(position);
            showProgressDialogWithMessage(getString(0x7f060224));
            PMApi.removeListingFromBundle(listingsummary.getUserId(), listingsummary.getIdAsString(), new PMApiResponseHandler() {

                final UnavailableBundleItemsFragment this$0;
                final int val$position;

                public void handleResponse(PMApiResponse pmapiresponse)
                {
                    hideProgressDialog();
                    if (!pmapiresponse.hasError())
                    {
                        unavailableBundleData.remove(position);
                        pmapiresponse = new CustomMatrixCursor(new String[] {
                            PMData.ID_COL, PMData.DATA_COL
                        });
                        fillCursor(pmapiresponse);
                        adapter.changeCursor(pmapiresponse);
                        adapter.notifyDataSetChanged();
                        countChanged = true;
                    }
                }

            
            {
                this$0 = UnavailableBundleItemsFragment.this;
                position = i;
                super();
            }
            });
        }
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "bundle_unavailable_items_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle(String.format(getString(0x7f0602a3), new Object[] {
            sellerUsername
        }));
    }

}
