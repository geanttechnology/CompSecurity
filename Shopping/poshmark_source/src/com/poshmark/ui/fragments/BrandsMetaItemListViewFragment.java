// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.TextView;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersListView;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.adapters.BrandsMetaItemListAdapter;
import com.poshmark.data_model.models.IndexedMetaItem;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.DrawableOnTouchListener;
import com.poshmark.ui.customviews.PMEditText;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.meta_data.BrandsMetaItemPickerInfo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, PMFilterableFragment, BrandFragment

public class BrandsMetaItemListViewFragment extends PMFragment
{

    BrandsMetaItemListAdapter adapter;
    TextView allBrandsTextView;
    boolean bReturnResults;
    boolean bShowAllOption;
    boolean backoutFlag;
    BrandsMetaItemPickerInfo brandsMetaItemInfo;
    boolean itemClick;
    MetaItem metaItem;
    PMFilterableFragment parentFragment;
    ArrayList recentItems;
    int recentItemsCount;
    PMEditText searchEditText;
    String searchText;
    StickyListHeadersListView stickyListView;

    public BrandsMetaItemListViewFragment()
    {
        bShowAllOption = false;
        bReturnResults = false;
        backoutFlag = false;
    }

    private List getMetaItemListFromFilter()
    {
        return parentFragment.getBrandsFacetList();
    }

    private void resetBrandsList()
    {
        adapter.clear();
        adapter.notifyDataSetChanged();
        if (allBrandsTextView != null)
        {
            allBrandsTextView.setVisibility(0);
        }
        adapter.filteredData = IndexedMetaItem.convertRecentBrandsToIndexMetaItemList((ArrayList)brandsMetaItemInfo.allItems, recentItems);
        adapter.recentBrandsList.addAll(recentItems);
        adapter.notifyDataSetChanged();
    }

    private void restoreState(Bundle bundle)
    {
    }

    private void setupAdapter()
    {
        if (parentFragment != null)
        {
            brandsMetaItemInfo = new BrandsMetaItemPickerInfo();
            brandsMetaItemInfo.allItems = getMetaItemListFromFilter();
            brandsMetaItemInfo.currentSelection = parentFragment.getBrandsMetaItemSelection();
        }
        getFilteredRecentBrandsList();
        adapter = new BrandsMetaItemListAdapter(getActivity(), 0x7f03008a, brandsMetaItemInfo, recentItems);
    }

    private void setupListItemClickListener()
    {
        stickyListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final BrandsMetaItemListViewFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                int k = stickyListView.getHeaderViewsCount();
                int j = recentItemsCount;
                itemClick = true;
                if (i - k < brandsMetaItemInfo.allItems.size() + j)
                {
                    i = ((Integer)view.getTag()).intValue();
                    if (searchText != null && searchText.length() > 0)
                    {
                        metaItem = (MetaItem)brandsMetaItemInfo.allItems.get(i);
                    } else
                    if (j > 0)
                    {
                        if (i < j)
                        {
                            metaItem = (MetaItem)recentItems.get(i);
                        } else
                        {
                            metaItem = (MetaItem)brandsMetaItemInfo.allItems.get(i - j);
                        }
                    } else
                    {
                        metaItem = (MetaItem)brandsMetaItemInfo.allItems.get(i);
                    }
                    brandsMetaItemInfo.currentSelection = metaItem;
                    if (brandsMetaItemInfo.currentSelection != null)
                    {
                        GlobalDbController.getGlobalDbController().addBrandToRecents(brandsMetaItemInfo.currentSelection);
                    }
                    returnData();
                    return;
                } else
                {
                    adapterview = new android.app.AlertDialog.Builder(getActivity());
                    adapterview.setTitle(getString(0x7f060032));
                    adapterview.setMessage("");
                    view = new EditText(getActivity());
                    adapterview.setView(view);
                    adapterview.setPositiveButton(getString(0x7f0601e1), view. new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;
                        final EditText val$input;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            metaItem = new MetaItem(input.getText().toString(), input.getText().toString());
                            dialoginterface.dismiss();
                            hideKeyboard();
                            returnData();
                        }

            
            {
                this$1 = final__pcls1;
                input = EditText.this;
                super();
            }
                    });
                    adapterview.setNegativeButton(getString(0x7f06006d), new android.content.DialogInterface.OnClickListener() {

                        final _cls1 this$1;

                        public void onClick(DialogInterface dialoginterface, int i)
                        {
                            dialoginterface.dismiss();
                            hideKeyboard();
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    adapterview.show();
                    showKeyboard();
                    return;
                }
            }

            
            {
                this$0 = BrandsMetaItemListViewFragment.this;
                super();
            }
        });
    }

    private void setupSearchListener()
    {
        if (searchEditText == null)
        {
            return;
        } else
        {
            searchEditText.setOnTouchListener(new DrawableOnTouchListener(searchEditText) {

                final BrandsMetaItemListViewFragment this$0;

                public boolean onDrawableTouch(MotionEvent motionevent)
                {
                    if (searchText != null && searchText.length() > 0)
                    {
                        itemClick = false;
                        motionevent = getActivity();
                        if (motionevent != null)
                        {
                            motionevent.onBackPressed();
                        }
                        searchEditText.setText("");
                        hideKeyboard();
                    }
                    return false;
                }

            
            {
                this$0 = BrandsMetaItemListViewFragment.this;
                super(edittext);
            }
            });
            searchEditText.addTextChangedListener(new TextWatcher() {

                final BrandsMetaItemListViewFragment this$0;

                public void afterTextChanged(Editable editable)
                {
                    if (searchText != null && searchText.length() > 0)
                    {
                        if (allBrandsTextView != null)
                        {
                            allBrandsTextView.setVisibility(8);
                        }
                        adapter.getFilter().filter(editable);
                        return;
                    } else
                    {
                        resetBrandsList();
                        return;
                    }
                }

                public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                }

                public void onTextChanged(CharSequence charsequence, int i, int j, int k)
                {
                    searchText = charsequence.toString();
                }

            
            {
                this$0 = BrandsMetaItemListViewFragment.this;
                super();
            }
            });
            return;
        }
    }

    public void getFilteredRecentBrandsList()
    {
        recentItems = new ArrayList();
        recentItemsCount = 0;
        HashSet hashset = new HashSet();
        for (Iterator iterator = brandsMetaItemInfo.allItems.iterator(); iterator.hasNext(); hashset.add((MetaItem)iterator.next())) { }
        Iterator iterator1 = GlobalDbController.getGlobalDbController().getRecentBrandsAndFollowingBrands().iterator();
label0:
        do
        {
            MetaItem metaitem;
            do
            {
                if (!iterator1.hasNext())
                {
                    break label0;
                }
                metaitem = (MetaItem)iterator1.next();
            } while (metaitem == null || !hashset.contains(metaitem));
            recentItems.add(metaitem);
            recentItemsCount = recentItemsCount + 1;
        } while (recentItemsCount < 50);
    }

    public boolean handleBack()
    {
label0:
        {
            if (searchText != null && searchText.length() > 0)
            {
                if (!itemClick)
                {
                    break label0;
                }
                itemClick = false;
            }
            return false;
        }
        resetBrandsList();
        return true;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (bundle == null)
        {
            stickyListView = (StickyListHeadersListView)getView().findViewById(0x7f0c0206);
            if (brandsMetaItemInfo.allItems != null)
            {
                setupHeaderView();
            }
            stickyListView.setAdapter(adapter);
            setupListItemClickListener();
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            parentFragment = (PMFilterableFragment)getFragmentDataOfType(com/poshmark/ui/fragments/PMFilterableFragment);
            brandsMetaItemInfo = (BrandsMetaItemPickerInfo)getFragmentDataOfType(com/poshmark/utils/meta_data/BrandsMetaItemPickerInfo);
            bShowAllOption = getArguments().getBoolean("SHOW_ALL", true);
            bReturnResults = getArguments().getBoolean("RETURN_RESULT", false);
            setupAdapter();
            return;
        } else
        {
            backoutFlag = true;
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f030089, viewgroup, false);
    }

    public void onPMResume()
    {
        super.onPMResume();
        if (!backoutFlag)
        {
            adapter.notifyDataSetChanged();
            return;
        } else
        {
            getActivity().onBackPressed();
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
    }

    public void returnData()
    {
        if (!bReturnResults) goto _L2; else goto _L1
_L1:
        Object obj;
        Bundle bundle;
        String s;
        PMFragment pmfragment;
        obj = new Intent();
        bundle = new Bundle();
        s = StringUtils.toJson(metaItem, com/poshmark/data_model/models/MetaItem);
        pmfragment = (PMFragment)getTargetFragment();
        if (pmfragment == null) goto _L4; else goto _L3
_L3:
        bundle.putString("DATA_SELECTED", s);
        ((Intent) (obj)).putExtra("RETURNED_RESULTS", bundle);
        pmfragment.onActivityResult(getTargetRequestCode(), -1, ((Intent) (obj)));
        obj = getActivity();
        if (obj != null)
        {
            ((Activity) (obj)).onBackPressed();
        }
_L6:
        return;
_L4:
        ((Intent) (obj)).putExtra("DATA_SELECTED", s);
        finishActivityWithResult(-1, ((Intent) (obj)));
        return;
_L2:
        PMContainerActivity pmcontaineractivity = (PMContainerActivity)getActivity();
        if (pmcontaineractivity != null && pmcontaineractivity.isActivityInForeground())
        {
            Bundle bundle1 = new Bundle();
            bundle1.putString("NAME", metaItem.getId());
            pmcontaineractivity.launchFragment(bundle1, com/poshmark/ui/fragments/BrandFragment, null);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void setTitle()
    {
        setTitle(getResources().getString(0x7f060061));
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "listing_select_brand_filter_screen";
    }

    public void setupActionBar()
    {
        if (getUserVisibleHint())
        {
            super.setupActionBar(0x7f030001);
            View view = getActivity().getActionBar().getCustomView();
            if (view != null)
            {
                searchEditText = (PMEditText)view.findViewById(0x7f0c0030);
                if (searchText != null)
                {
                    searchEditText.setText(searchText);
                    searchEditText.requestFocus();
                    showKeyboard();
                }
                setupSearchListener();
            }
        }
        setTitle();
    }

    public void setupHeaderView()
    {
        if (bShowAllOption)
        {
            View view = LayoutInflater.from(getActivity()).inflate(0x7f030013, null, false);
            allBrandsTextView = (TextView)view.findViewById(0x7f0c0072);
            allBrandsTextView.setText(0x7f06003c);
            allBrandsTextView.setVisibility(0);
            if (brandsMetaItemInfo.currentSelection == null)
            {
                allBrandsTextView.setTextColor(getResources().getColor(0x7f09003c));
                allBrandsTextView.setTypeface(null, 1);
                allBrandsTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, getResources().getDrawable(0x7f02007e), null);
            } else
            {
                allBrandsTextView.setTextColor(getResources().getColor(0x7f090035));
                allBrandsTextView.setTypeface(null, 0);
            }
            stickyListView.addHeaderView(view);
            allBrandsTextView.setOnClickListener(new android.view.View.OnClickListener() {

                final BrandsMetaItemListViewFragment this$0;

                public void onClick(View view1)
                {
                    metaItem = null;
                    brandsMetaItemInfo.currentSelection = null;
                    if (parentFragment != null)
                    {
                        parentFragment.getFilterManager().getSearchModel().clearBrand();
                    }
                    hideKeyboard();
                    returnData();
                }

            
            {
                this$0 = BrandsMetaItemListViewFragment.this;
                super();
            }
            });
        }
    }

}
