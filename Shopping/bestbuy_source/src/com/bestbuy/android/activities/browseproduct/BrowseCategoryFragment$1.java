// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct;

import android.view.View;
import android.widget.AdapterView;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.browse.Category;
import com.bestbuy.android.api.lib.models.browse.UberCategoryList;
import com.bestbuy.android.base.BaseFragmentContainer;
import java.util.HashMap;
import java.util.List;
import lu;

// Referenced classes of package com.bestbuy.android.activities.browseproduct:
//            BrowseCategoryFragment, BrowseSuperSubCategoryFragment

class a
    implements android.widget.stener
{

    final BrowseCategoryFragment a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        Category category;
        category = (Category)BrowseCategoryFragment.a(a).getHeader().get(i - 2);
        BrowseCategoryFragment.a(a, category.getName());
        adapterview = new HashMap();
        adapterview.put(lu.bo, "browse,deptCat");
        adapterview.put(lu.bp, "PRD");
        lu.b(BrowseCategoryFragment.b(a), adapterview);
        if (category.getWidgetType().equalsIgnoreCase("group")) goto _L2; else goto _L1
_L1:
        if (category.getGroups() == null || category.getGroups().size() <= 0) goto _L4; else goto _L3
_L3:
        adapterview = new BrowseSuperSubCategoryFragment(category, BrowseCategoryFragment.c(a));
        if (a.getParentFragment() == null) goto _L6; else goto _L5
_L5:
        if (!(a.getParentFragment() instanceof BaseTabContainer)) goto _L8; else goto _L7
_L7:
        ((BaseTabContainer)a.getParentFragment()).a(adapterview, true);
_L2:
        return;
_L8:
        ((BaseFragmentContainer)a.getParentFragment()).a(adapterview, true);
        return;
_L6:
        ((HomeActivity)BrowseCategoryFragment.d(a)).addFragment(0x7f0c0033, adapterview, "BrowseSuperSubCategoryFragment");
        return;
_L4:
        adapterview = category.getSearchPath();
        if (adapterview != null && !adapterview.isEmpty())
        {
            view = adapterview.substring(adapterview.indexOf("query")).replace("query=", "");
            adapterview = view;
            if (view.contains("="))
            {
                adapterview = view.split("=")[0];
            }
            view = new PLPFragment(category.getName(), adapterview, true, category.getName());
            if (a.getParentFragment() != null)
            {
                if (a.getParentFragment() instanceof BaseTabContainer)
                {
                    adapterview = new PLPFragmentContainer();
                    ((BaseTabContainer)a.getParentFragment()).a(adapterview, true);
                } else
                {
                    adapterview = new PLPFragmentContainer(true);
                    view.b(true);
                    ((HomeActivity)BrowseCategoryFragment.d(a)).addFragment(0x7f0c0033, adapterview, "PLPFragmentContainer");
                }
                adapterview.a(view, true);
                return;
            } else
            {
                ((HomeActivity)BrowseCategoryFragment.d(a)).addFragment(0x7f0c0033, view, "PLPFragment");
                return;
            }
        }
        if (true) goto _L2; else goto _L9
_L9:
    }

    gment(BrowseCategoryFragment browsecategoryfragment)
    {
        a = browsecategoryfragment;
        super();
    }
}
