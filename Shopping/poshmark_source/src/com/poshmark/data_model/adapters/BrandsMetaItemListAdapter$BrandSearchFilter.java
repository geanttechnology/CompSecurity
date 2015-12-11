// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.adapters;

import android.widget.Filter;
import com.poshmark.data_model.models.IndexedMetaItem;
import com.poshmark.data_model.models.MetaItem;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.poshmark.data_model.adapters:
//            BrandsMetaItemListAdapter

public class this._cls0 extends Filter
{

    final BrandsMetaItemListAdapter this$0;

    protected android.widget.BrandSearchFilter performFiltering(CharSequence charsequence)
    {
        android.widget.BrandSearchFilter brandsearchfilter = new android.widget.BrandSearchFilter();
        ArrayList arraylist = new ArrayList();
        searchTerm = charsequence.toString();
        charsequence = data.iterator();
        try
        {
            do
            {
                if (!charsequence.hasNext())
                {
                    break;
                }
                IndexedMetaItem indexedmetaitem = (IndexedMetaItem)charsequence.next();
                if (indexedmetaitem.getMetaItem().getDisplay().toLowerCase().startsWith(searchTerm.toLowerCase()))
                {
                    arraylist.add(indexedmetaitem);
                }
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (CharSequence charsequence)
        {
            charsequence.printStackTrace();
        }
        brandsearchfilter.searchTerm = arraylist.size();
        brandsearchfilter.searchTerm = arraylist;
        return brandsearchfilter;
    }

    protected void publishResults(CharSequence charsequence, android.widget.BrandSearchFilter brandsearchfilter)
    {
        filteredData = (ArrayList)brandsearchfilter.filteredData;
        recentBrandsList = new ArrayList();
        notifyDataSetChanged();
    }

    public ()
    {
        this$0 = BrandsMetaItemListAdapter.this;
        super();
    }
}
