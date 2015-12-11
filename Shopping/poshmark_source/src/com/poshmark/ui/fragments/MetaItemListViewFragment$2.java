// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.poshmark.ui.fragments:
//            MetaItemListViewFragment

class this._cls0
    implements android.widget.ener
{

    final MetaItemListViewFragment this$0;

    public void onItemClick(AdapterView adapterview, final View input, int i, long l)
    {
        int j = i;
        if (listView.getHeaderViewsCount() <= 0) goto _L2; else goto _L1
_L1:
        if (i != 0) goto _L4; else goto _L3
_L3:
        returnData();
_L6:
        return;
_L4:
        j = i - 1;
_L2:
        if (searchBox != null && searchBox.getText().toString().length() > 0)
        {
            if (j == 0)
            {
                metaItem = new MetaItem(searchBox.getText().toString(), searchBox.getText().toString());
                hideKeyboard();
                returnData();
                return;
            } else
            {
                i = ((Integer)input.getTag()).intValue();
                metaItem = (MetaItem)initInfo.allItems.get(i);
                hideKeyboard();
                returnData();
                return;
            }
        }
        if (j < initInfo.allItems.size())
        {
            i = ((Integer)input.getTag()).intValue();
            metaItem = (MetaItem)initInfo.allItems.get(i);
            if (allowMultiSelect)
            {
                if (multiSelectList.contains(metaItem))
                {
                    multiSelectList.remove(metaItem);
                    MetaItemListViewFragment.access$000(MetaItemListViewFragment.this, input);
                    return;
                } else
                {
                    multiSelectList.add(metaItem);
                    MetaItemListViewFragment.access$100(MetaItemListViewFragment.this, input);
                    return;
                }
            } else
            {
                returnData();
                return;
            }
        }
        if (listView.getFooterViewsCount() == 0)
        {
            adapterview = new android.app.ount(getActivity());
            adapterview.e(getString(0x7f060032));
            adapterview.age("");
            input = new EditText(getActivity());
            adapterview.(input);
            adapterview.tiveButton(getString(0x7f0601e1), new android.content.DialogInterface.OnClickListener() {

                final MetaItemListViewFragment._cls2 this$1;
                final EditText val$input;

                public void onClick(DialogInterface dialoginterface, int k)
                {
                    metaItem = new MetaItem(input.getText().toString(), input.getText().toString());
                    dialoginterface.dismiss();
                    hideKeyboard();
                    returnData();
                }

            
            {
                this$1 = MetaItemListViewFragment._cls2.this;
                input = edittext;
                super();
            }
            });
            adapterview.tiveButton(getString(0x7f06006d), new android.content.DialogInterface.OnClickListener() {

                final MetaItemListViewFragment._cls2 this$1;

                public void onClick(DialogInterface dialoginterface, int k)
                {
                    dialoginterface.dismiss();
                    hideKeyboard();
                }

            
            {
                this$1 = MetaItemListViewFragment._cls2.this;
                super();
            }
            });
            adapterview._mth2();
            showKeyboard();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    _cls2.this._cls1()
    {
        this$0 = MetaItemListViewFragment.this;
        super();
    }
}
