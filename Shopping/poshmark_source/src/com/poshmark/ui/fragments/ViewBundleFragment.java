// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.adapters.BundleListAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.data_model.models.PMBundle;
import com.poshmark.data_model.models.PMData;
import com.poshmark.http.api.PMApi;
import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.customviews.PMAutoScaleTextView;
import com.poshmark.ui.customviews.PMButton;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.BundleFlowHandler;
import com.poshmark.utils.BundleItemRemoveClickListener;
import com.poshmark.utils.FBDPAHelper;
import java.util.List;
import java.util.UUID;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, UnavailableBundleItemsFragment, ClosetFragment, MyLikesFragment, 
//            MappPageFragment

public class ViewBundleFragment extends PMFragment
    implements BundleItemRemoveClickListener
{

    int VIEW_UNAVAILABLE_ITEMS;
    BundleListAdapter adapter;
    PMButton addMoreItemsButton;
    PMBundle bundleData;
    ListView bundlesListView;
    LinearLayout listFooterView;
    LinearLayout listHeaderView;
    List unavailableBundleData;
    PMTextView unavailableItemsView;
    String userName;

    public ViewBundleFragment()
    {
        VIEW_UNAVAILABLE_ITEMS = 1;
    }

    private void createAllViews(View view)
    {
        LayoutInflater layoutinflater = LayoutInflater.from(getActivity());
        bundlesListView = (ListView)view.findViewById(0x7f0c030b);
        listHeaderView = (LinearLayout)layoutinflater.inflate(0x7f0300d0, null, false);
        bundlesListView.addHeaderView(listHeaderView);
        listFooterView = (LinearLayout)layoutinflater.inflate(0x7f0300cf, null, false);
        bundlesListView.addFooterView(listFooterView);
        unavailableItemsView = (PMTextView)listFooterView.findViewById(0x7f0c0313);
        unavailableItemsView.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewBundleFragment this$0;

            public void onClick(View view1)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "view_unavailable_listings_in_bundle_tapped", null);
                view1 = new Bundle();
                view1.putString("NAME", userName);
                view1.putString("PARENT_ID", getFragmentId().toString());
                view1.putString("SELLER_USER_NAME", bundleData.getSellerUsername());
                getParentActivity().launchFragmentForResult(view1, com/poshmark/ui/fragments/UnavailableBundleItemsFragment, unavailableBundleData, ViewBundleFragment.this, VIEW_UNAVAILABLE_ITEMS);
            }

            
            {
                this$0 = ViewBundleFragment.this;
                super();
            }
        });
        addMoreItemsButton = (PMButton)listFooterView.findViewById(0x7f0c0314);
        addMoreItemsButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ViewBundleFragment this$0;

            public void onClick(View view1)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "add_more_listings_to_bundle_tapped", null);
                view1 = new Bundle();
                view1.putString("NAME", userName);
                getParentActivity().launchFragment(view1, com/poshmark/ui/fragments/ClosetFragment, null);
            }

            
            {
                this$0 = ViewBundleFragment.this;
                super();
            }
        });
        ((PMButton)listFooterView.findViewById(0x7f0c0315)).setOnClickListener(new android.view.View.OnClickListener() {

            final ViewBundleFragment this$0;

            public void onClick(View view1)
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "view_my_bundles_tapped", null);
                view1 = new Bundle();
                view1.putString("MODE", MyLikesFragment.MODE.BUNDLES.name());
                getParentActivity().launchFragment(view1, com/poshmark/ui/fragments/MyLikesFragment, null);
            }

            
            {
                this$0 = ViewBundleFragment.this;
                super();
            }
        });
        bundlesListView.setAdapter(adapter);
    }

    private void fetchBundleData()
    {
        showProgressDialogWithMessage(getString(0x7f060190));
        PMApi.getBundleFromCloset(userName, new PMApiResponseHandler() {

            final ViewBundleFragment this$0;

            public void handleResponse(PMApiResponse pmapiresponse)
            {
                hideProgressDialog();
                if (!pmapiresponse.hasError())
                {
                    bundleData = (PMBundle)pmapiresponse.data;
                    unavailableBundleData = bundleData.removeUnavailableItems();
                    pmapiresponse = new CustomMatrixCursor(new String[] {
                        PMData.ID_COL, PMData.DATA_COL
                    });
                    bundleData.fillCursor(pmapiresponse);
                    adapter.changeCursor(pmapiresponse);
                    adapter.notifyDataSetChanged();
                    updateView();
                }
            }

            
            {
                this$0 = ViewBundleFragment.this;
                super();
            }
        });
    }

    private void setupBottomBar()
    {
        Object obj = getView().findViewById(0x7f0c00ab);
        if (bundleData.getList().size() == 0)
        {
            ((View) (obj)).setVisibility(8);
            return;
        }
        Object obj1 = (PMTextView)((View) (obj)).findViewById(0x7f0c030c);
        int i = bundleData.getList().size();
        PMTextView pmtextview;
        if (i > 1)
        {
            ((PMTextView) (obj1)).setText(String.format("%s Items - ", new Object[] {
                Integer.valueOf(i)
            }));
        } else
        {
            ((PMTextView) (obj1)).setText("1 Item - ");
        }
        ((PMAutoScaleTextView)((View) (obj)).findViewById(0x7f0c030d)).setText(bundleData.getFinalPriceAsString());
        obj1 = bundleData.getTotalDiscountTitle();
        pmtextview = (PMTextView)((View) (obj)).findViewById(0x7f0c030e);
        if (obj1 != null && ((String) (obj1)).length() > 0)
        {
            pmtextview.setText(((CharSequence) (obj1)));
            pmtextview.setVisibility(0);
        } else
        {
            pmtextview.setVisibility(8);
        }
        ((View) (obj)).setVisibility(0);
        obj = (Button)((View) (obj)).findViewById(0x7f0c0186);
        if (bundleData.getList().size() > 0)
        {
            ((Button) (obj)).setVisibility(0);
            ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

                final ViewBundleFragment this$0;

                public void onClick(View view)
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "buy_bundle_tapped", null);
                    FBDPAHelper.trackBundlePurchaseInitiated(bundleData);
                    (new BundleFlowHandler(ViewBundleFragment.this)).beginCheckoutForBundle(bundleData);
                }

            
            {
                this$0 = ViewBundleFragment.this;
                super();
            }
            });
            return;
        } else
        {
            ((Button) (obj)).setVisibility(8);
            return;
        }
    }

    private void setupListViewHeaderFooter()
    {
        Object obj = (LinearLayout)listHeaderView.findViewById(0x7f0c0316);
        String s = bundleData.getBundleDiscountMessage();
        if (s != null && s.length() > 0)
        {
            ((LinearLayout) (obj)).setVisibility(0);
            ((PMTextView)listHeaderView.findViewById(0x7f0c0317)).setText(s);
        } else
        {
            ((LinearLayout) (obj)).setVisibility(8);
        }
        obj = (LinearLayout)listFooterView.findViewById(0x7f0c030f);
        if (bundleData.getList().size() == 0 && unavailableBundleData.size() == 0)
        {
            ((LinearLayout) (obj)).setVisibility(0);
            ((PMButton)((LinearLayout) (obj)).findViewById(0x7f0c010c)).setOnClickListener(new android.view.View.OnClickListener() {

                final ViewBundleFragment this$0;

                public void onClick(View view)
                {
                    view = new Bundle();
                    view.putString("URL", "https://www.poshmark.com/mapp/bundles_help");
                    view.putString("ANALYTICS_PAGE_NAME", "bundle_learn_more_screen");
                    ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/MappPageFragment, null);
                }

            
            {
                this$0 = ViewBundleFragment.this;
                super();
            }
            });
        } else
        {
            ((LinearLayout) (obj)).setVisibility(8);
        }
        obj = (LinearLayout)listFooterView.findViewById(0x7f0c0312);
        if (unavailableBundleData.size() > 0)
        {
            ((LinearLayout) (obj)).setVisibility(0);
            obj = (PMTextView)listFooterView.findViewById(0x7f0c0313);
            if (unavailableBundleData.size() == 1)
            {
                ((PMTextView) (obj)).setText(getString(0x7f0602c7));
            } else
            {
                ((PMTextView) (obj)).setText(String.format(getString(0x7f0602c8), new Object[] {
                    Integer.valueOf(unavailableBundleData.size())
                }));
            }
        } else
        {
            ((LinearLayout) (obj)).setVisibility(8);
        }
        obj = (PMButton)listFooterView.findViewById(0x7f0c0314);
        if (bundleData.getList().size() == 0 && unavailableBundleData.size() == 0)
        {
            ((PMButton) (obj)).setText(String.format(getString(0x7f060033), new Object[] {
                bundleData.getSellerUsername()
            }));
        } else
        {
            ((PMButton) (obj)).setText(String.format(getString(0x7f060035), new Object[] {
                bundleData.getSellerUsername()
            }));
        }
        ((PMButton) (obj)).setVisibility(0);
        ((PMButton)listFooterView.findViewById(0x7f0c0315)).setVisibility(0);
    }

    private void updateView()
    {
        setTitle(String.format(getString(0x7f060065), new Object[] {
            bundleData.getSellerUsername()
        }));
        setupListViewHeaderFooter();
        setupBottomBar();
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i == BundleFlowHandler.BUY_BUNDLE_REQUEST && j == -1)
        {
            getParentActivity().onBackPressed();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments().getString("NAME");
        if (bundle == null) goto _L2; else goto _L1
_L1:
        userName = bundle.trim().replaceAll("\n", "");
_L4:
        adapter = new BundleListAdapter(getActivity(), this, this, com.poshmark.data_model.adapters.BundleListAdapter.MODE.VIEW_BUNDLE, null, 0x80000000);
        return;
_L2:
        bundle = getArguments().getString("ID");
        if (bundle != null)
        {
            userName = bundle.trim().replaceAll("\n", "");
        }
        if (true) goto _L4; else goto _L3
_L3:
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
        if (unavailableBundleData != null)
        {
            unavailableBundleData.clear();
        }
        if (bundleData == null)
        {
            fetchBundleData();
        } else
        {
            updateView();
        }
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.BUNDLE_ITEMS_CHANGED", this);
    }

    public void onPause()
    {
        super.onPause();
        bundleData = null;
        adapter.changeCursor(null);
        adapter.notifyDataSetChanged();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        PMNotificationManager.getNotificationManager().unregisterAllEvents(this);
    }

    public void removeItemFromBundle(final int position)
    {
        if (bundleData != null)
        {
            final List bundleItems = bundleData.getList();
            if (position < bundleItems.size())
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "remove_listing_from_bundle_tapped", null);
                ListingSummary listingsummary = (ListingSummary)bundleItems.get(position);
                showProgressDialogWithMessage(getString(0x7f060224));
                PMApi.removeListingFromBundle(listingsummary.getUserId(), listingsummary.getIdAsString(), new PMApiResponseHandler() {

                    final ViewBundleFragment this$0;
                    final List val$bundleItems;
                    final int val$position;

                    public void handleResponse(PMApiResponse pmapiresponse)
                    {
                        hideProgressDialog();
                        if (!pmapiresponse.hasError())
                        {
                            bundleItems.remove(position);
                            pmapiresponse = new CustomMatrixCursor(new String[] {
                                PMData.ID_COL, PMData.DATA_COL
                            });
                            bundleData.fillCursor(pmapiresponse);
                            adapter.changeCursor(pmapiresponse);
                            adapter.notifyDataSetChanged();
                            fetchBundleData();
                        }
                    }

            
            {
                this$0 = ViewBundleFragment.this;
                bundleItems = list;
                position = i;
                super();
            }
                });
            }
        }
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "bundle_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        setTitle(getString(0x7f060064));
    }


}
