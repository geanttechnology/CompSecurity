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

class val.input
    implements android.content.er
{

    final rnData this$1;
    final EditText val$input;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        metaItem = new MetaItem(val$input.getText().toString(), val$input.getText().toString());
        dialoginterface.dismiss();
        hideKeyboard();
        returnData();
    }

    is._cls0()
    {
        this$1 = final__pcls0;
        val$input = EditText.this;
        super();
    }

    // Unreferenced inner class com/poshmark/ui/fragments/MetaItemListViewFragment$2

/* anonymous class */
    class MetaItemListViewFragment._cls2
        implements android.widget.AdapterView.OnItemClickListener
    {

        final MetaItemListViewFragment this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
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
                    i = ((Integer)view.getTag()).intValue();
                    metaItem = (MetaItem)initInfo.allItems.get(i);
                    hideKeyboard();
                    returnData();
                    return;
                }
            }
            if (j < initInfo.allItems.size())
            {
                i = ((Integer)view.getTag()).intValue();
                metaItem = (MetaItem)initInfo.allItems.get(i);
                if (allowMultiSelect)
                {
                    if (multiSelectList.contains(metaItem))
                    {
                        multiSelectList.remove(metaItem);
                        MetaItemListViewFragment.access$000(MetaItemListViewFragment.this, view);
                        return;
                    } else
                    {
                        multiSelectList.add(metaItem);
                        MetaItemListViewFragment.access$100(MetaItemListViewFragment.this, view);
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
                adapterview = new android.app.AlertDialog.Builder(getActivity());
                adapterview.setTitle(getString(0x7f060032));
                adapterview.setMessage("");
                view = new EditText(getActivity());
                adapterview.setView(view);
                adapterview.setPositiveButton(getString(0x7f0601e1), view. new MetaItemListViewFragment._cls2._cls1());
                adapterview.setNegativeButton(getString(0x7f06006d), new MetaItemListViewFragment._cls2._cls2());
                adapterview.show();
                showKeyboard();
                return;
            }
            if (true) goto _L6; else goto _L5
_L5:
        }

            
            {
                this$0 = MetaItemListViewFragment.this;
                super();
            }

        // Unreferenced inner class com/poshmark/ui/fragments/MetaItemListViewFragment$2$2

/* anonymous class */
        class MetaItemListViewFragment._cls2._cls2
            implements android.content.DialogInterface.OnClickListener
        {

            final MetaItemListViewFragment._cls2 this$1;

            public void onClick(DialogInterface dialoginterface, int i)
            {
                dialoginterface.dismiss();
                hideKeyboard();
            }

                    
                    {
                        this$1 = MetaItemListViewFragment._cls2.this;
                        super();
                    }
        }

    }

}
