// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.refinements;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.retailsearch.android.ui.StyledSpannableString;
import com.amazon.retailsearch.android.ui.UIUtils;
import com.amazon.retailsearch.android.ui.ViewHolder;
import com.amazon.searchapp.retailsearch.model.Current;
import com.amazon.searchapp.retailsearch.model.CustomRefinementFilter;
import com.amazon.searchapp.retailsearch.model.Label;
import com.amazon.searchapp.retailsearch.model.LocationSuggestion;
import com.amazon.searchapp.retailsearch.model.LocationSuggestionGroup;
import com.amazon.searchapp.retailsearch.model.LocationSuggestions;
import com.amazon.searchapp.retailsearch.model.Locations;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.ui.refinements:
//            RefinementGroupAdapter, SpinnerHiderRelativeLayout, RefinementGroupType

public class DDSAdapter extends RefinementGroupAdapter
{

    public static final String ID = com/amazon/retailsearch/android/ui/refinements/DDSAdapter.getName();
    private static int frequentlyUsedStaticTextRowsCount = 1;
    private List cityDomains;
    private Current currentAddress;
    private List districtDomains;
    private CustomRefinementFilter filter;
    private int frequentlyUsedAddressRowsCount;
    private boolean isLocationSuggestionsLoaded;
    private LocationSuggestions locationSuggestions;
    private Locations locations;
    private List provinceDomains;
    private String textChooseCity;
    private String textChooseDistrict;
    private String textChooseProvince;
    private String textNewLocation;

    public DDSAdapter(Context context, CustomRefinementFilter customrefinementfilter)
    {
        super(context);
        isLocationSuggestionsLoaded = false;
        filter = customrefinementfilter;
    }

    private int getFrequentlyUsedRowsCount()
    {
        if (frequentlyUsedAddressRowsCount == 0)
        {
            return 0;
        } else
        {
            return frequentlyUsedAddressRowsCount + frequentlyUsedStaticTextRowsCount;
        }
    }

    private int getNewLocationRowCount()
    {
        return frequentlyUsedAddressRowsCount != 0 ? 5 : 4;
    }

    private boolean isLoading()
    {
        return locations == null || currentAddress == null || !isLocationSuggestionsLoaded;
    }

    public Object getChild(int i)
    {
        return null;
    }

    public String getChildUrl(int i)
    {
        if (isFrequentlyUsedAddress(i))
        {
            return ((LocationSuggestion)((LocationSuggestionGroup)locationSuggestions.getGroups().get(0)).getSuggestions().get(i - 1)).getValue();
        } else
        {
            return null;
        }
    }

    public View getChildView(int i, boolean flag, View view, ViewGroup viewgroup)
    {
        View view1;
        TextView textview;
        ImageView imageview;
        TextView textview1;
        View view2;
        View view3;
        SpinnerHiderRelativeLayout spinnerhiderrelativelayout;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        view1 = view;
        if (view == null)
        {
            view1 = UIUtils.inflate(viewgroup.getContext(), com.amazon.retailsearch.R.layout.refinements_child_dds, viewgroup, false);
        }
        view = (LinearLayout)ViewHolder.get(view1, com.amazon.retailsearch.R.id.rs_refinements_child_dds_title);
        textview1 = (TextView)ViewHolder.get(view1, com.amazon.retailsearch.R.id.rs_refinements_child_dds_title_text);
        view2 = ViewHolder.get(view1, com.amazon.retailsearch.R.id.rs_refinements_child_dds_title_divider_left);
        view3 = ViewHolder.get(view1, com.amazon.retailsearch.R.id.rs_refinements_child_dds_title_divider_right);
        viewgroup = (LinearLayout)ViewHolder.get(view1, com.amazon.retailsearch.R.id.rs_refinements_child_dds_address);
        textview = (TextView)ViewHolder.get(view1, com.amazon.retailsearch.R.id.rs_refinements_child_dds_address_text);
        imageview = (ImageView)ViewHolder.get(view1, com.amazon.retailsearch.R.id.rs_refinements_child_dds_address_check_box);
        spinnerhiderrelativelayout = (SpinnerHiderRelativeLayout)ViewHolder.get(view1, com.amazon.retailsearch.R.id.refinements_child_spinner);
        divider = ViewHolder.get(view1, com.amazon.retailsearch.R.id.rs_refinements_child_divider);
        view.setVisibility(8);
        view2.setVisibility(8);
        view3.setVisibility(8);
        viewgroup.setVisibility(8);
        spinnerhiderrelativelayout.setVisibility(8);
        textview.setTextColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_black));
        k = resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_item_dds_padding_left);
        l = resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_item_dds_padding_right);
        i1 = resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_item_dds_address_padding_next);
        j = resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_item_dds_location_padding_next);
        j1 = frequentlyUsedAddressRowsCount;
        if (!isLoading()) goto _L2; else goto _L1
_L1:
        spinnerhiderrelativelayout.setVisibility(0);
        spinnerhiderrelativelayout.show();
_L14:
        divider.setVisibility(8);
        return view1;
_L2:
        if (j1 <= 0 || i >= frequentlyUsedStaticTextRowsCount + j1) goto _L4; else goto _L3
_L3:
        if (i == 0)
        {
            textview1.setText(((LocationSuggestionGroup)locationSuggestions.getGroups().get(0)).getLabel());
            view.setVisibility(0);
        } else
        {
            viewgroup.setVisibility(0);
            textview.setText(((LocationSuggestion)((LocationSuggestionGroup)locationSuggestions.getGroups().get(0)).getSuggestions().get(i - 1)).getLabel());
            imageview.setImageDrawable(context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_radiobox));
            view = new android.widget.LinearLayout.LayoutParams(-1, -1);
            if (j1 == 1)
            {
                view.setMargins(k, i1, l, i1);
                UIUtils.setBackground(viewgroup, resources.getDrawable(com.amazon.retailsearch.R.drawable.rs_refinement_address_box));
            } else
            if (i == 1)
            {
                view.setMargins(k, i1, l, 0);
                UIUtils.setBackground(viewgroup, resources.getDrawable(com.amazon.retailsearch.R.drawable.rs_rounded_list_bg_top));
            } else
            if (i == j1)
            {
                view.setMargins(k, 0, l, i1);
                UIUtils.setBackground(viewgroup, resources.getDrawable(com.amazon.retailsearch.R.drawable.rs_rounded_list_bg_bottom));
            } else
            {
                view.setMargins(k, 0, l, 0);
                UIUtils.setBackground(viewgroup, resources.getDrawable(com.amazon.retailsearch.R.drawable.rs_rounded_list_bg_middle));
            }
            textview.setBackgroundColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_dds_address_background));
            viewgroup.setLayoutParams(view);
        }
          goto _L5
_L4:
        if (getFrequentlyUsedRowsCount() == 0)
        {
            i++;
        } else
        {
            i -= getFrequentlyUsedRowsCount();
        }
        if (i != 0) goto _L7; else goto _L6
_L6:
        textview1.setText(resources.getText(com.amazon.retailsearch.R.string.rs_refinement_menu_dds_or));
        view.setVisibility(0);
        view2.setVisibility(0);
        view3.setVisibility(0);
          goto _L5
_L7:
        if (i != 1) goto _L9; else goto _L8
_L8:
        textview1.setText(textNewLocation);
        view.setVisibility(0);
          goto _L5
_L9:
        i;
        JVM INSTR tableswitch 2 4: default 660
    //                   2 662
    //                   3 822
    //                   4 839;
           goto _L10 _L11 _L12 _L13
_L10:
        return null;
_L11:
        view = provinceDomains;
        textview.setText(textChooseProvince);
_L15:
        if (view != null && view.size() <= 1)
        {
            textview.setTextColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_gray));
        }
        viewgroup.setVisibility(0);
        imageview.setImageDrawable(context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_checkbox));
        view = new android.widget.LinearLayout.LayoutParams(-1, -1);
        if (i == getNewLocationRowCount() - 1)
        {
            i = j * 2;
        } else
        {
            i = j;
        }
        view.setMargins(k, j, l, i);
        UIUtils.setBackground(viewgroup, resources.getDrawable(com.amazon.retailsearch.R.drawable.rs_refinement_address_box_gray));
        textview.setBackgroundColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_dds_location_background));
        imageview.setImageDrawable(context.getResources().getDrawable(com.amazon.retailsearch.R.drawable.rs_carrot_right));
        viewgroup.setLayoutParams(view);
_L5:
        if (true) goto _L14; else goto _L12
_L12:
        view = cityDomains;
        textview.setText(textChooseCity);
          goto _L15
_L13:
        view = districtDomains;
        textview.setText(textChooseDistrict);
          goto _L15
    }

    public int getChildrenCount()
    {
        if (isLoading())
        {
            return 1;
        } else
        {
            return getFrequentlyUsedRowsCount() + getNewLocationRowCount();
        }
    }

    public String getCurrentValue(int i)
    {
        if (currentAddress != null && currentAddress.getLabels() != null && currentAddress.getLabels().size() > 2)
        {
            return ((Label)currentAddress.getLabels().get(i)).getLabel();
        } else
        {
            return null;
        }
    }

    public Object getData()
    {
        return filter;
    }

    public String getId()
    {
        return ID;
    }

    public RefinementGroupType getType()
    {
        return RefinementGroupType.DDS;
    }

    public View getView(boolean flag, View view, ViewGroup viewgroup)
    {
        view = super.getView(flag, view, viewgroup);
        viewgroup = new StyledSpannableString(context);
        viewgroup.append(filter.getLabel());
        groupTitle.setText(viewgroup);
        setDefaultGroupViewsStyle();
        groupTitle.setVisibility(0);
        groupSubTitle.setText(filter.getDetail());
        groupSubTitle.setTextSize(0, resources.getDimensionPixelSize(com.amazon.retailsearch.R.dimen.rs_refinement_menu_text_size_subheader));
        groupSubTitle.setTextColor(resources.getColor(com.amazon.retailsearch.R.color.rs_refinement_black));
        groupSubTitle.setVisibility(0);
        setDefaultGroupIndicatorStyle(flag);
        groupContent.setVisibility(0);
        return view;
    }

    public boolean isChildEnabled(int i)
    {
        if (isStaticText(i)) goto _L2; else goto _L1
_L1:
        List list = null;
        if (!isProvinceSelector(i)) goto _L4; else goto _L3
_L3:
        list = provinceDomains;
_L6:
        if (list == null || list.size() > 1)
        {
            break; /* Loop/switch isn't completed */
        }
_L2:
        return false;
_L4:
        if (isCitySelector(i))
        {
            list = cityDomains;
        } else
        if (isDistrictSelector(i))
        {
            list = districtDomains;
        }
        if (true) goto _L6; else goto _L5
_L5:
        return true;
    }

    public boolean isCitySelector(int i)
    {
        return getChildrenCount() - i == 2;
    }

    public boolean isDistrictSelector(int i)
    {
        return getChildrenCount() - i == 1;
    }

    public boolean isFrequentlyUsedAddress(int i)
    {
        return i != 0 && i < getFrequentlyUsedRowsCount();
    }

    public boolean isProvinceSelector(int i)
    {
        return getChildrenCount() - i == 3;
    }

    public boolean isStaticText(int i)
    {
        if (frequentlyUsedAddressRowsCount <= 0 || i != 0)
        {
            if (i >= getFrequentlyUsedRowsCount())
            {
                i -= getFrequentlyUsedRowsCount();
                if ((frequentlyUsedAddressRowsCount != 0 || i >= 1) && (frequentlyUsedAddressRowsCount == 0 || i >= 2))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public void setCityDomains(List list)
    {
        cityDomains = list;
    }

    public void setCurrentAddress(Current current)
    {
        currentAddress = current;
        if (current != null && current.getLabels() != null && current.getLabels().size() > 2)
        {
            textChooseProvince = ((Label)current.getLabels().get(0)).getLabel();
            textChooseCity = ((Label)current.getLabels().get(1)).getLabel();
            textChooseDistrict = ((Label)current.getLabels().get(2)).getLabel();
        }
    }

    public void setDistrictDomains(List list)
    {
        districtDomains = list;
    }

    public void setLocationSuggestions(LocationSuggestions locationsuggestions)
    {
        locationSuggestions = locationsuggestions;
        if (locationsuggestions != null && locationsuggestions.getGroups() != null && locationsuggestions.getGroups().size() > 0)
        {
            frequentlyUsedAddressRowsCount = ((LocationSuggestionGroup)locationsuggestions.getGroups().get(0)).getSuggestions().size();
        }
        isLocationSuggestionsLoaded = true;
    }

    public void setLocations(Locations locations1)
    {
        if (locations1 == null)
        {
            return;
        } else
        {
            locations = locations1;
            textNewLocation = locations1.getHeaderLabel();
            return;
        }
    }

    public void setProvinceDomains(List list)
    {
        provinceDomains = list;
    }

}
