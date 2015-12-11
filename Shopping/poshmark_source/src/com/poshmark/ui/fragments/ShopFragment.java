// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersListView;
import com.google.gson.reflect.TypeToken;
import com.poshmark.controllers.GlobalPartiesController;
import com.poshmark.controllers.ShowroomsController;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.adapters.ShowroomListAdapter;
import com.poshmark.data_model.customcursors.CustomMatrixCursor;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.data_model.models.PMData;
import com.poshmark.data_model.models.Showroom;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.db.DbApi;
import com.poshmark.notifications.PMNotificationListener;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.MainActivity;
import com.poshmark.ui.PMActivity;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMCustomSearchWidget;
import com.poshmark.ui.customviews.PMTextView;
import com.poshmark.utils.ObjectPickupDropOff;
import com.poshmark.utils.PMSearchViewListener;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.meta_data.BrandsMetaItemPickerInfo;
import com.poshmark.utils.meta_data.ColorPickerInfo;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, MyLikesFragment, AllPartiesFragment, SearchResultsFragment, 
//            BrandFragment, ShowroomFragment, BrandsMetaItemListViewFragment, CategoryListFragment, 
//            ColorPickerFragment

public class ShopFragment extends PMFragment
    implements PMNotificationListener
{
    class ButtonActionInfo
    {

        public Bundle fragmentData;
        public Class fragmentToLaunch;
        final ShopFragment this$0;

        ButtonActionInfo()
        {
            this$0 = ShopFragment.this;
            super();
            fragmentData = new Bundle();
        }
    }


    protected static final int GET_BRAND = 2;
    protected static final int GET_CATEGORY = 1;
    protected static final int GET_COLOR = 3;
    private ShowroomListAdapter adapter;
    Button brandsButton;
    Button categoriesButton;
    PMTextView currentPartyTag;
    View headerView;
    android.view.View.OnClickListener listener;
    Button myLikesButton;
    ViewGroup partiesLayout;
    String searchKeyword;
    PMCustomSearchWidget searchView;
    Boolean showRecentSearchesDropDown;
    StickyListHeadersListView showroomListView;

    public ShopFragment()
    {
        showRecentSearchesDropDown = Boolean.valueOf(false);
        adapter = null;
        listener = new android.view.View.OnClickListener() {

            final ShopFragment this$0;

            public void onClick(View view)
            {
                view = (ButtonActionInfo)view.getTag();
                if (view != null)
                {
                    launchUrl(view);
                }
            }

            
            {
                this$0 = ShopFragment.this;
                super();
            }
        };
    }

    private void launchUrl(ButtonActionInfo buttonactioninfo)
    {
        ((PMActivity)getActivity()).launchFragmentInNewActivity(buttonactioninfo.fragmentData, buttonactioninfo.fragmentToLaunch, null);
    }

    private void setUpButtons()
    {
        headerView = LayoutInflater.from(getActivity()).inflate(0x7f0300b8, null);
        myLikesButton = (Button)headerView.findViewById(0x7f0c02cb);
        myLikesButton.setText(getString(0x7f0601b2));
        myLikesButton.setCompoundDrawablesWithIntrinsicBounds(0x7f0200a9, 0, 0, 0);
        Object obj = new ButtonActionInfo();
        obj.fragmentToLaunch = com/poshmark/ui/fragments/MyLikesFragment;
        obj.fragmentData = null;
        myLikesButton.setTag(obj);
        myLikesButton.setOnClickListener(listener);
        brandsButton = (Button)headerView.findViewById(0x7f0c02cc);
        brandsButton.setText(getString(0x7f060061));
        brandsButton.setCompoundDrawablesWithIntrinsicBounds(0x7f02006b, 0, 0, 0);
        brandsButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ShopFragment this$0;

            public void onClick(View view)
            {
                view = new BrandsMetaItemPickerInfo();
                ((BrandsMetaItemPickerInfo) (view)).allItems.addAll(DbApi.getBrandsForAllCategories());
                Bundle bundle = new Bundle();
                bundle.putBoolean("SHOW_ALL", false);
                bundle.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.BRAND_MODE.ordinal());
                bundle.putBoolean("SEARCH_ENABLED", true);
                ((PMActivity)getActivity()).launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/BrandsMetaItemListViewFragment, view, ShopFragment.this, 2);
            }

            
            {
                this$0 = ShopFragment.this;
                super();
            }
        });
        categoriesButton = (Button)headerView.findViewById(0x7f0c02cd);
        categoriesButton.setText(getString(0x7f060073));
        categoriesButton.setCompoundDrawablesWithIntrinsicBounds(0x7f0200f4, 0, 0, 0);
        categoriesButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ShopFragment this$0;

            public void onClick(View view)
            {
                new MetaItemPickerInfo();
                view = new Bundle();
                view.putInt("META_ITEM_MODE", MetaItemListViewFragment.META_ITEM_MODES.CATEGORY_MODE.ordinal());
                view.putBoolean("ENABLE_BROWSE_MODE", true);
                view.putBoolean("RETURN_RESULT", false);
                ((PMActivity)getActivity()).launchFragmentInNewActivityForResult(view, com/poshmark/ui/fragments/CategoryListFragment, null, ShopFragment.this, 1);
            }

            
            {
                this$0 = ShopFragment.this;
                super();
            }
        });
        obj = (Button)headerView.findViewById(0x7f0c02ce);
        ((Button) (obj)).setText(getResources().getText(0x7f06008b));
        ((Button) (obj)).setCompoundDrawablesWithIntrinsicBounds(0x7f0200ef, 0, 0, 0);
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final ShopFragment this$0;

            public void onClick(View view)
            {
                view = new ColorPickerInfo();
                view.allItems = DbApi.getAllColors();
                PMActivity pmactivity = (PMActivity)getActivity();
                Bundle bundle = new Bundle();
                bundle.putInt("COLOR_PICKER_MODE", ColorPickerFragment.COLOR_MODE.COLOR_BROWSE.ordinal());
                bundle.putBoolean("RETURN_RESULT", false);
                pmactivity.launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/ColorPickerFragment, view, ShopFragment.this, 3);
            }

            
            {
                this$0 = ShopFragment.this;
                super();
            }
        });
        partiesLayout = (ViewGroup)headerView.findViewById(0x7f0c02cf);
        partiesLayout.setOnClickListener(listener);
        obj = new ButtonActionInfo();
        obj.fragmentToLaunch = com/poshmark/ui/fragments/AllPartiesFragment;
        obj.fragmentData = null;
        partiesLayout.setTag(obj);
        currentPartyTag = (PMTextView)headerView.findViewById(0x7f0c02d1);
        updatePartyRow();
        showroomListView.addHeaderView(headerView);
    }

    private void setupShowroomList()
    {
        updateList();
        showroomListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ShopFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (CustomMatrixCursor)((CursorAdapter)showroomListView.getWrappedAdapter()).getCursor();
                if (adapterview != null && adapterview.moveToPosition(i - 1))
                {
                    adapterview = (Showroom)adapterview.get(adapterview.getColumnIndex(PMData.DATA_COL));
                    view = adapterview.getId();
                    Bundle bundle = new Bundle();
                    bundle.putString("ID", view);
                    ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/ShowroomFragment, adapterview);
                }
            }

            
            {
                this$0 = ShopFragment.this;
                super();
            }
        });
    }

    private void setupView(View view)
    {
        showroomListView = (StickyListHeadersListView)view.findViewById(0x7f0c025a);
        setUpButtons();
        showroomListView.setAdapter(adapter);
        showroomListView.setOnHeaderClickListener(null);
    }

    private void showSearchResults(int i, Intent intent)
    {
        i;
        JVM INSTR tableswitch 1 3: default 28
    //                   1 29
    //                   2 166
    //                   3 225;
           goto _L1 _L2 _L3 _L4
_L1:
        return;
_L2:
        if ((intent = intent.getExtras().getString("DATA_SELECTED")) != null)
        {
            Object obj = (MetaItem)StringUtils.fromJson(intent, com/poshmark/data_model/models/MetaItem);
            intent = new SearchFilterModel();
            intent.setAvailability("available");
            UserStateSummary userstatesummary = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
            if (userstatesummary != null && userstatesummary.user_info.isMySizeAvailable())
            {
                intent.enableMySizeFilter(true);
            }
            intent.setSearchTrigger("ct");
            intent.setCategory(((MetaItem) (obj)).getId());
            intent.setFacet("brand");
            intent.setFacet("size");
            intent.setFacet("color");
            obj = new Bundle();
            ((Bundle) (obj)).putString("SEARCH_TRIGGER", "ct");
            ((PMContainerActivity)getActivity()).launchFragmentInNewActivity(((Bundle) (obj)), com/poshmark/ui/fragments/SearchResultsFragment, intent);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        intent = intent.getExtras().getString("DATA_SELECTED");
        if (intent != null)
        {
            intent = (MetaItem)StringUtils.fromJson(intent, com/poshmark/data_model/models/MetaItem);
            Bundle bundle = new Bundle();
            bundle.putString("NAME", intent.getId());
            ((PMContainerActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/BrandFragment, null);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
        intent = intent.getExtras();
        if (intent.getBoolean("COLOR_CHANGED"))
        {
            intent = intent.getString("COLOR_LIST");
            if (intent != null)
            {
                Object obj1 = (List)StringUtils.fromJson(intent, new TypeToken() {

                    final ShopFragment this$0;

            
            {
                this$0 = ShopFragment.this;
                super();
            }
                });
                if (obj1 != null && !((List) (obj1)).isEmpty())
                {
                    intent = new SearchFilterModel();
                    intent.setAvailability("available");
                    UserStateSummary userstatesummary1 = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
                    if (userstatesummary1 != null && userstatesummary1.user_info.isMySizeAvailable())
                    {
                        intent.enableMySizeFilter(true);
                    }
                    intent.setSearchTrigger("clr");
                    intent.setFacet("brand");
                    intent.setFacet("category_v2");
                    intent.setFacet("category_feature");
                    intent.setFacet("size");
                    intent.addColor(((PMColor)((List) (obj1)).get(0)).name);
                    obj1 = new Bundle();
                    ((Bundle) (obj1)).putString("SEARCH_TRIGGER", "clr");
                    ((PMContainerActivity)getActivity()).launchFragmentInNewActivity(((Bundle) (obj1)), com/poshmark/ui/fragments/SearchResultsFragment, intent);
                    return;
                }
            }
        }
        if (true) goto _L1; else goto _L5
_L5:
    }

    private void updateList()
    {
        if (getUserVisibleHint() && ShowroomsController.getGlobalShowroomsController().isModelPopulated())
        {
            CustomMatrixCursor custommatrixcursor = new CustomMatrixCursor(new String[] {
                PMData.ID_COL, PMData.DATA_COL
            });
            ShowroomsController.getGlobalShowroomsController().fillCursor(custommatrixcursor);
            adapter.changeCursor(custommatrixcursor);
            adapter.notifyDataSetChanged();
        }
    }

    private void updatePartyRow()
    {
        if (GlobalPartiesController.getGlobalPartiesController().getCurrentPartiesCount() > 0)
        {
            currentPartyTag.setVisibility(0);
            return;
        } else
        {
            currentPartyTag.setVisibility(8);
            return;
        }
    }

    public String getTrackingLabel()
    {
        return "shp";
    }

    public void handleNotification(Intent intent)
    {
        if (intent.getAction().equals("com.poshmark.intents.EVENTS_FETCH_COMPLETE"))
        {
            updatePartyRow();
        } else
        {
            if (intent.getAction().equals("com.poshmark.intents.PARTY_EVENT_END"))
            {
                updatePartyRow();
                return;
            }
            if (intent.getAction().equals("com.poshmark.intents.PARTY_EVENT_START"))
            {
                updatePartyRow();
                return;
            }
            if (intent.getAction().equals("com.poshmark.intents.SHOWROOMS_FETCH_COMPLETE"))
            {
                updateList();
                return;
            }
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle != null)
        {
            searchKeyword = bundle.getString("SAVED_SEARCH_KEYWORD");
        }
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == -1)
        {
            showSearchResults(i, intent);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        fragmentType = PMFragment.FRAGMENT_TYPE.REGULAR;
        adapter = new ShowroomListAdapter(getActivity(), null, 0x80000000);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.EVENTS_FETCH_COMPLETE", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.PARTY_EVENT_END", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.PARTY_EVENT_START", this);
        PMNotificationManager.getNotificationManager().registerForEvent("com.poshmark.intents.SHOWROOMS_FETCH_COMPLETE", this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        layoutinflater = layoutinflater.inflate(0x7f0300b7, viewgroup, false);
        setupView(layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        super.onDestroyView();
        saveSearchesInActionBar();
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (searchKeyword != null && searchKeyword.length() > 0)
        {
            if (showRecentSearchesDropDown.booleanValue())
            {
                searchView.setText(searchKeyword);
            } else
            {
                searchView.setSilentText(searchKeyword);
            }
        }
        setupShowroomList();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (searchView != null)
        {
            bundle.putString("SAVED_SEARCH_KEYWORD", searchView.getUserInput());
        }
    }

    protected void saveSearchesInActionBar()
    {
        if (getActivity().getActionBar().getCustomView() == null);
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "shop_screen";
    }

    public void setupActionBar()
    {
        if (getUserVisibleHint())
        {
            super.setupActionBar(0x7f030006);
            View view = getActivity().getActionBar().getCustomView();
            if (view != null)
            {
                searchView = (PMCustomSearchWidget)view.findViewById(0x7f0c0041);
                showRecentSearchesDropDown = (Boolean)ObjectPickupDropOff.pickupDataObject(MainActivity.SHOP_TAB_SEARCH_FLAG_KEY);
                if (showRecentSearchesDropDown != null)
                {
                    searchView.showRecentsAsDefaults(showRecentSearchesDropDown.booleanValue());
                } else
                {
                    showRecentSearchesDropDown = Boolean.valueOf(false);
                }
                searchView.setParentListener(new PMSearchViewListener() {

                    final ShopFragment this$0;

                    public void clearSearchString()
                    {
                        searchKeyword = null;
                    }

                    public void fireKeywordSearch(Bundle bundle, SearchFilterModel searchfiltermodel, boolean flag)
                    {
                        searchKeyword = searchfiltermodel.getQueryText();
                        PMContainerActivity pmcontaineractivity = (PMContainerActivity)getActivity();
                        if (flag)
                        {
                            pmcontaineractivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/BrandFragment, searchfiltermodel);
                            return;
                        } else
                        {
                            pmcontaineractivity.launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/SearchResultsFragment, searchfiltermodel);
                            return;
                        }
                    }

            
            {
                this$0 = ShopFragment.this;
                super();
            }
                });
            }
        }
    }

}
