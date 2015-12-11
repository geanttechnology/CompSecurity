// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.os.Handler;
import com.groupon.models.FilterCategory;
import com.groupon.models.category.Category;
import com.groupon.models.gdt.GtgMockCategory;
import com.groupon.util.Function1;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

class this._cls0
    implements Function1
{

    final NearbyDealsFragment this$0;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        if (!isGTGOnNearby) goto _L2; else goto _L1
_L1:
        int j;
        int k;
        k = list.size();
        j = k;
        if (list.size() <= 0) goto _L4; else goto _L3
_L3:
        int i = 0;
_L9:
        j = k;
        if (i >= list.size()) goto _L4; else goto _L5
_L5:
        if (!Strings.equalsIgnoreCase(((Category)list.get(i)).id, "food-and-drink")) goto _L7; else goto _L6
_L6:
        j = i + 1;
_L4:
        list.add(j, new GtgMockCategory());
_L2:
        if (isSnapNearbyCategoryEnabled)
        {
            Category category = new Category();
            category.id = NearbyDealsFragment.access$500();
            category.isAllDeals = false;
            category.name = getString(0x7f0804e1);
            list.add(category);
        }
        NearbyDealsFragment.access$2200(NearbyDealsFragment.this).setCategories(list);
        reloadIfNewCategoriesMissingCurrent(list, NearbyDealsFragment.access$1300(NearbyDealsFragment.this).getCategoryId());
        (new Handler()).post(new Runnable() {

            final NearbyDealsFragment._cls18 this$1;

            public void run()
            {
                if (NearbyDealsFragment.access$2200(this$0) != null)
                {
                    NearbyDealsFragment.access$2200(this$0).notifyDataSetChanged();
                }
            }

            
            {
                this$1 = NearbyDealsFragment._cls18.this;
                super();
            }
        });
        return;
_L7:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    _cls1.this._cls1()
    {
        this$0 = NearbyDealsFragment.this;
        super();
    }
}
