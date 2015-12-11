// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct;

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.api.lib.models.browse.Category;
import java.util.List;

// Referenced classes of package com.bestbuy.android.activities.browseproduct:
//            BrowseSuperSubCategoryFragment

class a
    implements android.widget.wseSuperSubCategoryFragment._cls1
{

    final BrowseSuperSubCategoryFragment a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (Category)BrowseSuperSubCategoryFragment.a(a).get(i - 2);
        if (!adapterview.getWidgetType().equalsIgnoreCase("group"))
        {
            a.a(adapterview);
        }
    }

    (BrowseSuperSubCategoryFragment browsesupersubcategoryfragment)
    {
        a = browsesupersubcategoryfragment;
        super();
    }
}
