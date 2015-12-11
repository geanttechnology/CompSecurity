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

class this._cls0
    implements android.widget.Fragment._cls1
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
            adapterview = new android.app.iewFragment.returnData(getActivity());
            adapterview.getActivity(getString(0x7f060032));
            adapterview.getString("");
            input = new EditText(getActivity());
            adapterview.getActivity(input);
            adapterview.tton(getString(0x7f0601e1), new android.content.DialogInterface.OnClickListener() {

                final BrandsMetaItemListViewFragment._cls1 this$1;
                final EditText val$input;

                public void onClick(DialogInterface dialoginterface, int i1)
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
            });
            adapterview.tton(getString(0x7f06006d), new android.content.DialogInterface.OnClickListener() {

                final BrandsMetaItemListViewFragment._cls1 this$1;

                public void onClick(DialogInterface dialoginterface, int i1)
                {
                    dialoginterface.dismiss();
                    hideKeyboard();
                }

            
            {
                this$1 = BrandsMetaItemListViewFragment._cls1.this;
                super();
            }
            });
            adapterview._mth1();
            showKeyboard();
            return;
        }
    }

    _cls2.this._cls1()
    {
        this$0 = BrandsMetaItemListViewFragment.this;
        super();
    }
}
