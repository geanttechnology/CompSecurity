// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.NewListing;
import com.poshmark.db.DbApi;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.meta_data.ColorPickerInfo;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorFragment, ColorPickerFragment

class this._cls0
    implements android.view.orFragment._cls7
{

    final ListingEditorFragment this$0;

    public void onClick(View view)
    {
        currentState = STING_STATES.GET_COLOR;
        view = new ColorPickerInfo();
        view.allItems = DbApi.getAllColors();
        ((ColorPickerInfo) (view)).selectedColors.addAll(newListing.getColors());
        PMActivity pmactivity = (PMActivity)getActivity();
        Bundle bundle = new Bundle();
        bundle.putInt("COLOR_PICKER_MODE", R_MODE.COLOR_LISTING_FLOW.ordinal());
        pmactivity.launchFragmentInNewActivityForResult(bundle, com/poshmark/ui/fragments/ColorPickerFragment, view, ListingEditorFragment.this, DEFAULT_REQUEST_CODE);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "listing_select_color", null);
    }

    R_MODE()
    {
        this$0 = ListingEditorFragment.this;
        super();
    }
}
