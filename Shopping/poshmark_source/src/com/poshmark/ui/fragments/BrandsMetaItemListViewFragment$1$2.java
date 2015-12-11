// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import com.emilsjolander.components.stickylistheaders.StickyListHeadersListView;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.utils.meta_data.BrandsMetaItemPickerInfo;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            BrandsMetaItemListViewFragment

class this._cls1
    implements android.content.gment._cls1._cls2
{

    final Keyboard this$1;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.dismiss();
        hideKeyboard();
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1

/* anonymous class */
    class BrandsMetaItemListViewFragment._cls1
        implements android.widget.AdapterView.OnItemClickListener
    {

        final BrandsMetaItemListViewFragment this$0;

        public void onItemClick(AdapterView adapterview, final View input, int i, long l)
        {
            int k = stickyListView.getHeaderViewsCount();
            int j = recentItemsCount;
            itemClick = true;
            if (i - k < brandsMetaItemInfo.allItems.size() + j)
            {
                i = ((Integer)input.getTag()).intValue();
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
                input = new EditText(getActivity());
                adapterview.setView(input);
                adapterview.setPositiveButton(getString(0x7f0601e1), new BrandsMetaItemListViewFragment._cls1._cls1());
                adapterview.setNegativeButton(getString(0x7f06006d), new BrandsMetaItemListViewFragment._cls1._cls2());
                adapterview.show();
                showKeyboard();
                return;
            }
        }

            
            {
                this$0 = BrandsMetaItemListViewFragment.this;
                super();
            }

        // Unreferenced inner class com/poshmark/ui/fragments/BrandsMetaItemListViewFragment$1$1

/* anonymous class */
        class BrandsMetaItemListViewFragment._cls1._cls1
            implements android.content.DialogInterface.OnClickListener
        {

            final BrandsMetaItemListViewFragment._cls1 this$1;
            final EditText val$input;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                metaItem = new MetaItem(input.getText().toString(), input.getText().toString());
                dialoginterface.dismiss();
                hideKeyboard();
                returnData();
            }

                    
                    {
                        this$1 = BrandsMetaItemListViewFragment._cls1.this;
                        input = edittext;
                        super();
                    }
        }

    }

}
