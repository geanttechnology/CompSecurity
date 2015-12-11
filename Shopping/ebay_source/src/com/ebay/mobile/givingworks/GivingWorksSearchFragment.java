// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.givingworks;

import android.app.Activity;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.ebay.app.DialogFragmentCallback;
import com.ebay.common.Preferences;
import com.ebay.common.net.api.finding.PagedList;
import com.ebay.common.net.api.givingworks.NonProfitPagedListLoader;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.app.TrackingSupport;
import com.ebay.nautilus.shell.content.FwLoader;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.ebay.mobile.givingworks:
//            GivingWorksCharityFragment

public class GivingWorksSearchFragment extends BaseFragment
    implements android.widget.AdapterView.OnItemClickListener, DialogFragmentCallback, com.ebay.common.net.AsyncList.NetworkListObserver, TrackingSupport
{
    protected class GivingSearchState
    {

        public ImageCache imageCache;
        public PagedList results;
        public String searchString;
        final GivingWorksSearchFragment this$0;

        protected GivingSearchState()
        {
            this$0 = GivingWorksSearchFragment.this;
            super();
        }
    }

    private class GivingWorksResultsAdapter extends ArrayAdapter
    {

        private com.ebay.common.model.givingworks.NonprofitData.Nonprofit firstNonprofit;
        private final LayoutInflater inflater;
        final GivingWorksSearchFragment this$0;

        public boolean areAllItemsEnabled()
        {
            return false;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit;
            if (view == null)
            {
                viewgroup = inflater.inflate(0x7f0300b6, null);
                view = new ViewCache(viewgroup);
                viewgroup.setTag(view);
                ((ViewCache) (view)).infoDivider.setVisibility(0);
                ((ViewCache) (view)).infoButton.setVisibility(0);
                ((ViewCache) (view)).infoButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final GivingWorksResultsAdapter this$1;

                    public void onClick(View view)
                    {
                        Object obj = (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)view.getTag();
                        view = new Bundle();
                        view.putParcelable("charity_nonprofit", ((android.os.Parcelable) (obj)));
                        obj = new GivingWorksCharityFragment();
                        ((GivingWorksCharityFragment) (obj)).setArguments(view);
                        ((GivingWorksCharityFragment) (obj)).show(getFragmentManager(), "giving_works_charity");
                    }

            
            {
                this$1 = GivingWorksResultsAdapter.this;
                super();
            }
                });
                ((ViewCache) (view)).selectButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final GivingWorksResultsAdapter this$1;

                    public void onClick(View view)
                    {
                        if (nonProfitSelectionListener != null)
                        {
                            nonProfitSelectionListener.onNonProfitSelected((com.ebay.common.model.givingworks.NonprofitData.Nonprofit)view.getTag());
                        }
                    }

            
            {
                this$1 = GivingWorksResultsAdapter.this;
                super();
            }
                });
                ((ViewCache) (view)).chevron.setVisibility(8);
            } else
            {
                viewgroup = view;
                view = (ViewCache)viewgroup.getTag();
            }
            ((ViewCache) (view)).selectButton.setVisibility(0);
            ((ViewCache) (view)).text.setVisibility(0);
            ((ViewCache) (view)).text.setText("");
            if (i == 0 && firstNonprofit != null)
            {
                nonprofit = firstNonprofit;
            } else
            {
                com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit1 = (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)getItem(i);
                nonprofit = nonprofit1;
                if (i == 0)
                {
                    nonprofit = nonprofit1;
                    if (firstNonprofit == null)
                    {
                        firstNonprofit = nonprofit1;
                        nonprofit = nonprofit1;
                    }
                }
            }
            if (nonprofit == null)
            {
                return viewgroup;
            } else
            {
                searchState.imageCache.setImage(((ViewCache) (view)).image, nonprofit.getLogoUrl());
                ((ViewCache) (view)).text.setText(nonprofit.name);
                ((ViewCache) (view)).infoButton.setTag(nonprofit);
                ((ViewCache) (view)).selectButton.setTag(nonprofit);
                return viewgroup;
            }
        }

        public boolean isEnabled(int i)
        {
            return getItem(i) != null;
        }

        public GivingWorksResultsAdapter(Context context, int i, List list)
        {
            this$0 = GivingWorksSearchFragment.this;
            super(context, i, list);
            inflater = LayoutInflater.from(context);
        }
    }

    public final class GivingWorksResultsAdapter.ViewCache
    {

        public final ImageView chevron;
        public final ImageView image;
        public final ImageButton infoButton;
        public final View infoDivider;
        public final View selectButton;
        public final TextView text;
        final GivingWorksResultsAdapter this$1;

        public GivingWorksResultsAdapter.ViewCache(View view)
        {
            this$1 = GivingWorksResultsAdapter.this;
            super();
            image = (ImageView)view.findViewById(0x7f1001d5);
            text = (TextView)view.findViewById(0x7f1001d7);
            selectButton = view.findViewById(0x7f1001d4);
            infoDivider = view.findViewById(0x7f1001d9);
            chevron = (ImageView)view.findViewById(0x7f1001da);
            infoButton = (ImageButton)view.findViewById(0x7f1001db);
        }
    }

    public static interface NonProfitSelectionListener
    {

        public abstract void onNonProfitSelected(com.ebay.common.model.givingworks.NonprofitData.Nonprofit nonprofit);
    }


    public static final String CHARITY_SEARCH_KEYWORDS = "charity_search_keywords";
    private static final int DIALOG_SEARCH_LENGTH_WARNING = 0;
    private static final int GET_NON_PROFITS = 1;
    protected static final String GIVING_WORKS_CHARITY = "giving_works_charity";
    private GivingWorksResultsAdapter adapter;
    private TextView noResultsText;
    private NonProfitSelectionListener nonProfitSelectionListener;
    private View progress;
    private View resultContainer;
    private ListView resultList;
    protected GivingSearchState searchState;
    public EditText searchText;

    public GivingWorksSearchFragment()
    {
    }

    private void onGetNonProfitsComplete(NonProfitPagedListLoader nonprofitpagedlistloader)
    {
        if (getActivity() == null || getActivity().isFinishing())
        {
            return;
        }
        progress.setVisibility(8);
        searchState.results = nonprofitpagedlistloader.list;
        if (searchState.results != null && !searchState.results.isEmpty())
        {
            adapter = new GivingWorksResultsAdapter(getActivity(), 0x7f030222, searchState.results);
            resultList.setAdapter(adapter);
            resultContainer.setVisibility(0);
            noResultsText.setVisibility(8);
            resultList.setOnItemClickListener(this);
            searchState.results.registerObserver(this);
            return;
        } else
        {
            adapter = null;
            resultList.setAdapter(null);
            resultContainer.setVisibility(8);
            noResultsText.setText(getString(0x7f07066e, new Object[] {
                nonprofitpagedlistloader.keywords
            }));
            noResultsText.setVisibility(0);
            searchState.results.unregisterObserver(this);
            return;
        }
    }

    public String getTrackingEventName()
    {
        return "GivingWorksSearch";
    }

    public void onChanged()
    {
        if (adapter != null)
        {
            adapter.notifyDataSetChanged();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300b8, viewgroup, false);
        searchText = (EditText)layoutinflater.findViewById(0x7f1001dd);
        resultList = (ListView)layoutinflater.findViewById(0x102000a);
        resultList.setOnItemClickListener(this);
        progress = layoutinflater.findViewById(0x7f1000c0);
        noResultsText = (TextView)layoutinflater.findViewById(0x7f1001f1);
        resultContainer = layoutinflater.findViewById(0x7f1001ef);
        searchState = null;
        if (bundle != null)
        {
            searchState = new GivingSearchState();
            searchState.imageCache = new ImageCache(getActivity());
            searchState.searchString = MyApp.getPrefs().getUserPref("searchLastCharityKeywords", "");
            startKeywordSearch(searchState.searchString);
            return layoutinflater;
        }
        searchState = new GivingSearchState();
        searchState.imageCache = new ImageCache(getActivity());
        viewgroup = getArguments();
        searchState.searchString = viewgroup.getString("charity_search_keywords");
        if (TextUtils.isEmpty(searchState.searchString))
        {
            searchState.searchString = MyApp.getPrefs().getUserPref("searchLastCharityKeywords", "");
        }
        startKeywordSearch(searchState.searchString);
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        nonProfitSelectionListener = null;
    }

    public void onDialogFragmentResult(DialogFragment dialogfragment, int i, int j)
    {
        if (j == 1) goto _L2; else goto _L1
_L1:
        return;
_L2:
        switch (i)
        {
        default:
            break; /* Loop/switch isn't completed */

        case 0: // '\0'
            break;
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    public void onGetNotReady()
    {
    }

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (com.ebay.common.model.givingworks.NonprofitData.Nonprofit)adapterview.getAdapter().getItem(i);
        if (nonProfitSelectionListener != null)
        {
            nonProfitSelectionListener.onNonProfitSelected(adapterview);
        }
    }

    public void onNetworkError(IOException ioexception)
    {
    }

    public void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(getActivity());
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            onGetNonProfitsComplete((NonProfitPagedListLoader)fwloader);
            break;
        }
    }

    public void setNonProfitSelectionListener(NonProfitSelectionListener nonprofitselectionlistener)
    {
        nonProfitSelectionListener = nonprofitselectionlistener;
    }

    public void startKeywordSearch(String s)
    {
        progress.setVisibility(0);
        resultContainer.setVisibility(8);
        noResultsText.setVisibility(8);
        MyApp.getPrefs().setUserPref(s, "searchLastCharityKeywords");
        s = new NonProfitPagedListLoader(((BaseActivity)getActivity()).getEbayContext(), MyApp.getPrefs().getCurrentSite(), s);
        getFwLoaderManager().start(1, s, true);
    }

}
