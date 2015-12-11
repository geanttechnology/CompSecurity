// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.ui.fragments.CategoryListFragment;
import com.poshmark.utils.meta_data.CategorySubCategorySelectionModel;
import java.util.List;

// Referenced classes of package com.poshmark.data_model.adapters:
//            CategoryAdapter

class this._cls0
    implements android.widget.ClickListener
{

    final CategoryAdapter this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (parentListView.getHeaderViewsCount() > 0 && i == 0)
        {
            if (!isAllSelected)
            {
                isAllSelected = true;
            }
            CategoryAdapter.access$000(CategoryAdapter.this, view, isAllSelected);
            CategoryAdapter.access$100(CategoryAdapter.this);
            notifyDataSetChanged();
            fragment.allItemSelected();
            return;
        }
        int j = parentListView.getHeaderViewsCount();
        adapterview = (MetaItem)info.categoryFacetList.get(i - j);
        if (info.currentCategory == null)
        {
            isAllSelected = true;
            CategoryAdapter.access$000(CategoryAdapter.this, fragment.getListHeaderView(), isAllSelected);
        } else
        {
            notifyDataSetChanged();
        }
        fragment.itemSelected(adapterview);
    }

    ectionModel()
    {
        this$0 = CategoryAdapter.this;
        super();
    }
}
