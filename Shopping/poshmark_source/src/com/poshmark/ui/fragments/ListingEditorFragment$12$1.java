// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.data_model.models.NewListing;
import com.poshmark.data_model.models.inner_models.ListingFeature;
import com.poshmark.ui.customviews.LabelledEditText;
import com.poshmark.utils.FeatureManager;
import com.poshmark.utils.view_holders.ListingEditorViewHolder;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingEditorFragment

class this._cls1
    implements com.poshmark.ui.customviews.alogAutoDismissListener
{

    final is._cls0 this$1;

    public void dialogDismissed()
    {
        newListing.setInventoryStatus("not_for_sale");
        viewHolder.availabilityEditText.setText(newListing.getInventoryStatusDisplayString(getActivity()));
        ListingEditorFragment.access$300(_fld0);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/ListingEditorFragment$12

/* anonymous class */
    class ListingEditorFragment._cls12
        implements android.view.View.OnClickListener
    {

        final ListingEditorFragment this$0;

        public void onClick(View view)
        {
            hideKeyboard();
            if (!ListingEditorFragment.access$200(ListingEditorFragment.this))
            {
                return;
            }
            view = FeatureManager.getGlobalFeatureManager().getListingFeature();
            if (!view.isValidSellingPrice(newListing.getPrice()) && newListing.getInventoryStatus().equals("available"))
            {
                view = String.format(getString(0x7f060175), new Object[] {
                    view.getFormattedMinimumSellingPrice()
                });
                showAutoHideProgressDialogWithMessage(view, new ListingEditorFragment._cls12._cls1());
                return;
            } else
            {
                ListingEditorFragment.access$300(ListingEditorFragment.this);
                return;
            }
        }

            
            {
                this$0 = ListingEditorFragment.this;
                super();
            }
    }

}
