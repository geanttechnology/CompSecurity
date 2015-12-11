// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.google.gson.reflect.TypeToken;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.adapters.ColorListAdapter;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.StringUtils;
import com.poshmark.utils.meta_data.ColorPickerInfo;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, SearchResultsFragment, PMFilterableFragment

public class ColorPickerFragment extends PMFragment
{
    public static final class COLOR_MODE extends Enum
    {

        private static final COLOR_MODE $VALUES[];
        public static final COLOR_MODE COLOR_BROWSE;
        public static final COLOR_MODE COLOR_FILTER;
        public static final COLOR_MODE COLOR_LISTING_FLOW;

        public static COLOR_MODE valueOf(String s)
        {
            return (COLOR_MODE)Enum.valueOf(com/poshmark/ui/fragments/ColorPickerFragment$COLOR_MODE, s);
        }

        public static COLOR_MODE[] values()
        {
            return (COLOR_MODE[])$VALUES.clone();
        }

        static 
        {
            COLOR_BROWSE = new COLOR_MODE("COLOR_BROWSE", 0);
            COLOR_FILTER = new COLOR_MODE("COLOR_FILTER", 1);
            COLOR_LISTING_FLOW = new COLOR_MODE("COLOR_LISTING_FLOW", 2);
            $VALUES = (new COLOR_MODE[] {
                COLOR_BROWSE, COLOR_FILTER, COLOR_LISTING_FLOW
            });
        }

        private COLOR_MODE(String s, int i)
        {
            super(s, i);
        }
    }


    int MAX_COUNT;
    ColorListAdapter adapter;
    boolean colorDataChanged;
    boolean dataChanged;
    int defaultAllTextColor;
    View headerView;
    ColorPickerInfo info;
    boolean isAllSelected;
    ListView listView;
    COLOR_MODE mode;
    PMFilterableFragment parentFragment;
    boolean returnResult;

    public ColorPickerFragment()
    {
        colorDataChanged = false;
        dataChanged = false;
        MAX_COUNT = 2;
        mode = COLOR_MODE.COLOR_FILTER;
        isAllSelected = false;
        returnResult = true;
    }

    private void fireBrowseWithColor(PMColor pmcolor)
    {
        SearchFilterModel searchfiltermodel = new SearchFilterModel();
        searchfiltermodel.setAvailability("available");
        searchfiltermodel.setSearchTrigger("clr");
        searchfiltermodel.setFacet("brand");
        searchfiltermodel.setFacet("category_v2");
        searchfiltermodel.setFacet("category_feature");
        searchfiltermodel.setFacet("size");
        searchfiltermodel.addColor(pmcolor.name);
        pmcolor = new Bundle();
        pmcolor.putString("SEARCH_TRIGGER", "clr");
        ((PMContainerActivity)getActivity()).launchFragmentInNewActivity(pmcolor, com/poshmark/ui/fragments/SearchResultsFragment, searchfiltermodel);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "browse_listings_by_color_shop_tab", null);
    }

    private void setAllOption(boolean flag, View view)
    {
        ImageView imageview = (ImageView)view.findViewById(0x7f0c00d3);
        view = (TextView)view.findViewById(0x7f0c00d2);
        if (flag)
        {
            imageview.setVisibility(0);
            view.setTextColor(getResources().getColor(0x7f09003c));
            view.setTypeface(null, 1);
            return;
        } else
        {
            imageview.setVisibility(4);
            view.setTextColor(defaultAllTextColor);
            view.setTypeface(null, 0);
            return;
        }
    }

    private void setupItemSelectionHandler()
    {
        listView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final ColorPickerFragment this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (listView.getHeaderViewsCount() > 0 && i == 0)
                {
                    if (!isAllSelected)
                    {
                        isAllSelected = true;
                        setAllOption(true, headerView);
                        info.clearSelectionList();
                        adapter.notifyDataSetChanged();
                        dataChanged = true;
                    }
                    if (mode != COLOR_MODE.COLOR_LISTING_FLOW)
                    {
                        returnData();
                    }
                }
                if (i - listView.getHeaderViewsCount() < 0) goto _L2; else goto _L1
_L1:
                boolean flag;
                i = info.selectedColors.size();
                adapterview = (PMColor)view.getTag();
                view = (ImageView)view.findViewById(0x7f0c00d3);
                flag = info.isColorInSelectColorList(adapterview);
                if (mode != COLOR_MODE.COLOR_LISTING_FLOW) goto _L4; else goto _L3
_L3:
                if (i >= MAX_COUNT) goto _L6; else goto _L5
_L5:
                dataChanged = true;
                if (!flag) goto _L8; else goto _L7
_L7:
                view.setImageDrawable(null);
                info.removeColorFromSelectedColorList(adapterview);
_L2:
                return;
_L8:
                view.setImageDrawable(getActivity().getResources().getDrawable(0x7f02007e));
                info.selectedColors.add(adapterview);
                return;
_L6:
                if (flag)
                {
                    dataChanged = true;
                    view.setImageDrawable(null);
                    info.removeColorFromSelectedColorList(adapterview);
                    return;
                } else
                {
                    showAutoHideSuccessMessage(String.format("You can only select up to %s colors", new Object[] {
                        Integer.valueOf(MAX_COUNT)
                    }));
                    return;
                }
_L4:
                if (mode == COLOR_MODE.COLOR_FILTER)
                {
                    dataChanged = true;
                    isAllSelected = false;
                    setAllOption(false, headerView);
                    info.clearSelectionList();
                    info.selectedColors.add(adapterview);
                    adapter.notifyDataSetChanged();
                    returnData();
                    return;
                }
                if (mode == COLOR_MODE.COLOR_BROWSE)
                {
                    dataChanged = true;
                    fireBrowseWithColor(adapterview);
                    return;
                }
                if (true) goto _L2; else goto _L9
_L9:
            }

            
            {
                this$0 = ColorPickerFragment.this;
                super();
            }
        });
    }

    public String getTrackingLabel()
    {
        return "clr";
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        listView = (ListView)getView().findViewById(0x7f0c00d0);
        if (mode == COLOR_MODE.COLOR_FILTER)
        {
            headerView = LayoutInflater.from(getActivity()).inflate(0x7f03002d, null);
            bundle = (TextView)headerView.findViewById(0x7f0c00d2);
            bundle.setText(getString(0x7f06003f));
            defaultAllTextColor = bundle.getTextColors().getDefaultColor();
            if (info.selectedColors == null || info.selectedColors.isEmpty())
            {
                setAllOption(true, headerView);
                isAllSelected = true;
            }
            listView.addHeaderView(headerView);
        }
        listView.setAdapter(adapter);
        setupItemSelectionHandler();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        info = (ColorPickerInfo)getFragmentDataOfType(com/poshmark/utils/meta_data/ColorPickerInfo);
        parentFragment = (PMFilterableFragment)getFragmentDataOfType(com/poshmark/ui/fragments/PMFilterableFragment);
        bundle = getArguments();
        if (bundle != null)
        {
            mode = COLOR_MODE.values()[getArguments().getInt("COLOR_PICKER_MODE", 1)];
            returnResult = bundle.getBoolean("RETURN_RESULT", true);
        }
        if (info == null)
        {
            info = new ColorPickerInfo();
            info.allItems = parentFragment.getColorFacetList();
            if (info.allItems == null)
            {
                info.allItems = new ArrayList();
            }
            info.selectedColors = new ArrayList();
            info.selectedColors.addAll(parentFragment.getFilterManager().getCurrentColorSelections());
            info.colorFacetList = parentFragment.getUnscrubbedColorFacetList();
        }
        adapter = new ColorListAdapter(getActivity(), 0x7f03002e, info);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f03002c, viewgroup, false);
    }

    public boolean returnData()
    {
        Object obj = new Intent();
        Object obj1 = new Bundle();
        if (dataChanged)
        {
            ((Bundle) (obj1)).putBoolean("COLOR_CHANGED", true);
            java.lang.reflect.Type type = (new TypeToken() {

                final ColorPickerFragment this$0;

            
            {
                this$0 = ColorPickerFragment.this;
                super();
            }
            }).getType();
            ((Bundle) (obj1)).putString("COLOR_LIST", StringUtils.toJson(info.selectedColors, type));
        } else
        {
            ((Bundle) (obj1)).putBoolean("COLOR_CHANGED", false);
        }
        ((Intent) (obj)).putExtra("RETURNED_RESULTS", ((Bundle) (obj1)));
        obj1 = (PMFragment)getTargetFragment();
        if (obj1 != null)
        {
            ((PMFragment) (obj1)).onActivityResult(getTargetRequestCode(), -1, ((Intent) (obj)));
            obj = getActivity();
            if (obj != null)
            {
                ((Activity) (obj)).onBackPressed();
            }
            return false;
        } else
        {
            finishActivityWithResult(-1, ((Intent) (obj)));
            return false;
        }
    }

    public void setViewNameForAnalytics()
    {
        if (mode == COLOR_MODE.COLOR_LISTING_FLOW)
        {
            viewNameForAnalytics = "listing_select_color_screen";
            return;
        }
        if (mode == COLOR_MODE.COLOR_FILTER)
        {
            viewNameForAnalytics = "listing_select_color_filter_screen";
            return;
        } else
        {
            viewNameForAnalytics = "listing_select_color_screen";
            return;
        }
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (mode == COLOR_MODE.COLOR_LISTING_FLOW)
        {
            setTitle(getString(0x7f060242));
            setNextActionButton(getString(0x7f0600bf), new android.view.View.OnClickListener() {

                final ColorPickerFragment this$0;

                public void onClick(View view)
                {
                    returnData();
                }

            
            {
                this$0 = ColorPickerFragment.this;
                super();
            }
            });
            return;
        } else
        {
            setTitle(getString(0x7f060241));
            return;
        }
    }


}
