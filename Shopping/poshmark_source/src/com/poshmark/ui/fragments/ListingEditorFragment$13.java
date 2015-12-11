// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.NewListing;
import com.poshmark.data_model.models.inner_models.ListingFeature;
import com.poshmark.db.DbApi;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.meta_data.CategorySubCategorySelectionModel;
import com.poshmark.utils.meta_data.ColorPickerInfo;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;
import com.poshmark.utils.meta_data.NWTOptionsMetaData;
import com.poshmark.utils.view_holders.ListingEditorViewHolder;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorFragment, CategoryListFragment, MetaItemListViewFragment, ListingConditionPickerFragment, 
//            ColorPickerFragment

class this._cls0
    implements android.view.rFragment._cls13
{

    final ListingEditorFragment this$0;

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        PMActivity pmactivity = (PMActivity)getActivity();
        MetaItemPickerInfo metaitempickerinfo = new MetaItemPickerInfo();
        if (!handlingUserTap)
        {
            Bundle bundle1 = new Bundle();
            if (view == viewHolder.categoryEditText && motionevent.getAction() == 1)
            {
                handlingUserTap = true;
                currentState = TING_STATES.GET_CATEGORY;
                view = new CategorySubCategorySelectionModel();
                view.categoryFacetList = DbApi.getAllCategories();
                view.currentCategory = newListing.getCategory();
                view.currentSubCategorySelection = newListing.getSubCategoryList();
                bundle1.putBoolean("ENABLE_LISTING_MODE", true);
                pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/CategoryListFragment, view, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
            } else
            if (view == viewHolder.sizeEditText && motionevent.getAction() == 1)
            {
                view = newListing.getCategory();
                if (view == null)
                {
                    showAlertMessage("", getResources().getString(0x7f060180));
                    return true;
                }
                handlingUserTap = true;
                metaitempickerinfo.allItems = GlobalDbController.getGlobalDbController().getAllSizesForCategory(view.getId());
                if (metaitempickerinfo.allItems == null)
                {
                    metaitempickerinfo.allItems = new ArrayList();
                }
                currentState = TING_STATES.GET_SIZE;
                bundle1.putInt("META_ITEM_MODE", META_ITEM_MODES.SIZE_MODE.ordinal());
                bundle1.putBoolean("CUSTOM_OPTION_ENABLED", true);
                pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/MetaItemListViewFragment, metaitempickerinfo, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
            } else
            if (view == viewHolder.brandEditText && motionevent.getAction() == 1)
            {
                handlingUserTap = true;
                metaitempickerinfo.allItems = DbApi.getAllBrands();
                currentState = TING_STATES.GET_BRAND;
                bundle1.putInt("META_ITEM_MODE", META_ITEM_MODES.BRAND_MODE.ordinal());
                bundle1.putBoolean("SEARCH_ENABLED", true);
                bundle1.putBoolean("CUSTOM_STRING_ENABLED", true);
                pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/MetaItemListViewFragment, metaitempickerinfo, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
            } else
            if (view == viewHolder.nwtEditText && motionevent.getAction() == 1)
            {
                handlingUserTap = true;
                currentState = TING_STATES.GET_CONDITION_STATUS;
                bundle1.putInt("META_ITEM_MODE", META_ITEM_MODES.NWT_MODE.ordinal());
                pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/ListingConditionPickerFragment, NWTOptionsMetaData.getConditionMetaItemForListingFlow(newListing.getCondition()), ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
            } else
            if (view == viewHolder.availabilityEditText && motionevent.getAction() == 1)
            {
                view = FeatureManager.getGlobalFeatureManager().getListingFeature();
                if (!view.isValidSellingPrice(newListing.getPrice()) && !newListing.getInventoryStatus().equals("available"))
                {
                    showAlertMessage("", String.format(getString(0x7f06018d), new Object[] {
                        view.getFormattedMinimumSellingPrice()
                    }));
                    return true;
                }
                handlingUserTap = true;
                metaitempickerinfo.allItems = DbApi.getNFSListingOptions();
                currentState = TING_STATES.GET_AVAILABILITY_STATUS;
                bundle1.putInt("META_ITEM_MODE", META_ITEM_MODES.AVAILABILITY_MODE.ordinal());
                pmactivity.launchFragmentInNewActivityForResult(bundle1, com/poshmark/ui/fragments/MetaItemListViewFragment, metaitempickerinfo, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
            } else
            if (view == viewHolder.colorDummyEditText && motionevent.getAction() == 1)
            {
                handlingUserTap = true;
                currentState = TING_STATES.GET_COLOR;
                view = new ColorPickerInfo();
                view.allItems = DbApi.getAllColors();
                ((ColorPickerInfo) (view)).selectedColors.addAll(newListing.getColors());
                motionevent = (PMActivity)getActivity();
                Bundle bundle = new Bundle();
                bundle.putInt("COLOR_PICKER_MODE", _MODE.COLOR_LISTING_FLOW.ordinal());
                motionevent.launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/ColorPickerFragment, view, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listing_select_color", null);
            } else
            {
                return false;
            }
            return true;
        } else
        {
            return false;
        }
    }

    _MODE()
    {
        this$0 = ListingEditorFragment.this;
        super();
    }
}
