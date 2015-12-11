// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.ui.fragments.SubCategoryListFragment;
import com.poshmark.utils.meta_data.CategorySubCategorySelectionModel;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.adapters:
//            SubCategoryAdapter

class this._cls0
    implements android.widget.ckListener
{

    final SubCategoryAdapter this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (parentListView.getHeaderViewsCount() > 0 && i == 0)
        {
            fragment.allItemSelected();
            return;
        } else
        {
            int j = parentListView.getHeaderViewsCount();
            adapterview = (MetaItem)info.scrubbedSubCategoryList.get(i - j);
            fragment.itemSelected(adapterview);
            return;
        }
    }

    ionModel()
    {
        this$0 = SubCategoryAdapter.this;
        super();
    }
}
