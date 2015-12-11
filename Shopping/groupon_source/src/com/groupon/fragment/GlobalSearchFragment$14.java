// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.GlobalSearch;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.SnapOfferGridActivity;
import com.groupon.adapter.GlobalCategoriesAdapter;
import com.groupon.models.category.Category;
import com.groupon.models.nst.GlobalSearchCategoryClickExtraInfo;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.nst.SnapGroceryGenericMetadata;
import com.groupon.util.LoggingUtils;
import com.groupon.util.SearchInterfaceProvider;
import java.util.List;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class this._cls0
    implements android.view.ment._cls14
{

    final GlobalSearchFragment this$0;

    public void onClick(View view)
    {
        Category category = (Category)view.getTag();
        if (category == null || !category.id.equals("groceries")) goto _L2; else goto _L1
_L1:
        GlobalSearchFragment.access$000(GlobalSearchFragment.this).logClick(null, "groceries_search_all_click", "snap", null, new SnapGroceryGenericMetadata(null, com/groupon/activity/GlobalSearch.getSimpleName(), null, null));
        startActivity(((IntentFactory)intentFactory.get()).newSnapOfferGridIntent((new StringBuilder()).append(Channel.SNAP_GROCERY).append(com/groupon/activity/SnapOfferGridActivity.getSimpleName()).toString(), Channel.SNAP_GROCERY));
_L4:
        return;
_L2:
        if (category == null || category.isParent()) goto _L4; else goto _L3
_L3:
        int i;
        int j;
        int k;
        GlobalSearchFragment.access$300(GlobalSearchFragment.this).setQueryText(category.friendlyName);
        j = 0;
        i = 0;
        view = GlobalSearchFragment.access$1600(GlobalSearchFragment.this).getExpandedCategories();
        k = j;
        if (view == null) goto _L6; else goto _L5
_L5:
        k = j;
        if (view.size() <= 2) goto _L6; else goto _L7
_L7:
        j = 2;
_L12:
        k = i;
        if (j >= view.size()) goto _L6; else goto _L8
_L8:
        Object obj = (Category)view.get(j);
        if (!((Category) (obj)).equals(category)) goto _L10; else goto _L9
_L9:
        k = i;
_L6:
        GlobalSearchFragment.access$1702(GlobalSearchFragment.this, new java.util.<init>(category, Integer.valueOf(k + 1)));
        reload("", "", false);
        GlobalSearchFragment.access$300(GlobalSearchFragment.this).clearFocus();
        if (isBrowseByCategory)
        {
            int l;
            if (category.relevanceContext.equals("mobile_goods"))
            {
                view = "goods";
            } else
            {
                view = "nearby";
            }
            if (category.isAllDeals || !category.isSubcategory)
            {
                obj = "L2";
            } else
            {
                obj = "L3";
            }
            GlobalSearchFragment.access$000(GlobalSearchFragment.this).logCategoryClick("category_click", view, Channel.GLOBAL_SEARCH.toString(), ((String) (obj)), category);
            isBrowseByCategory = false;
            GlobalSearchFragment.access$1802(GlobalSearchFragment.this, true);
            view = (GlobalSearch)getActivity();
            if (GlobalSearchFragment.access$1900(GlobalSearchFragment.this))
            {
                i = 0;
            } else
            {
                i = 8;
            }
            view.setRadioTabGroupVisibility(i);
            return;
        }
        break; /* Loop/switch isn't completed */
_L10:
        l = i;
        if (!((Category) (obj)).isSubcategory)
        {
            l = i + 1;
        }
        j++;
        i = l;
        if (true) goto _L12; else goto _L11
_L11:
        GlobalSearchCategoryClickExtraInfo globalsearchcategoryclickextrainfo;
        if (category.isAllDeals || !category.isSubcategory)
        {
            view = "category_selection_click";
        } else
        {
            view = "sub-category_click";
        }
        globalsearchcategoryclickextrainfo = new GlobalSearchCategoryClickExtraInfo(((Category)GlobalSearchFragment.access$1700(GlobalSearchFragment.this).ragment()).toNstTracking(((Integer)GlobalSearchFragment.access$1700(GlobalSearchFragment.this).ragment()).intValue()));
        GlobalSearchFragment.access$000(GlobalSearchFragment.this).logClick("", view, "global_search", JsonEncodedNSTField.NULL_JSON_NST_FIELD, globalsearchcategoryclickextrainfo);
        return;
    }

    ickExtraInfo()
    {
        this$0 = GlobalSearchFragment.this;
        super();
    }
}
