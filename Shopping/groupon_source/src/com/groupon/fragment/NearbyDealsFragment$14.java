// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.res.Resources;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.SnapOfferGridActivity;
import com.groupon.models.FilterCategory;
import com.groupon.models.category.Category;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.gdt.GdtService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

class this._cls0
    implements android.widget.Listener
{

    final NearbyDealsFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = NearbyDealsFragment.access$1200(NearbyDealsFragment.this).getAdapter();
        if (adapterview == null)
        {
            return;
        }
        Category category = (Category)adapterview.getItem(i);
        if (isGTGOnNearby && category != null && Strings.equals(category.id, "gtg_mock_category_id"))
        {
            adapterview = getString(0x7f08012f);
            NearbyDealsFragment.access$1302(NearbyDealsFragment.this, new FilterCategory(adapterview, null));
            view.setBackgroundColor(getResources().getColor(0x7f0e00be));
            NearbyDealsFragment.access$1400(NearbyDealsFragment.this).dismiss();
            loggingUtils.logClick("", "gtg_on_nearby_click", Channel.NEARBY.toString(), Logger.NULL_NST_FIELD, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            startActivity(((IntentFactory)NearbyDealsFragment.access$1600(NearbyDealsFragment.this).get()).newGrouponWebViewIntent(NearbyDealsFragment.access$1500(NearbyDealsFragment.this).getGtgEntryUrl(), false, true, true, true, false));
            return;
        }
        if (category == null)
        {
            adapterview = ALL_DEALS;
            NearbyDealsFragment.access$1302(NearbyDealsFragment.this, new FilterCategory(ALL_DEALS, null));
        } else
        {
            if (category.id.equals(NearbyDealsFragment.access$500()))
            {
                adapterview = category.id;
                NearbyDealsFragment.access$1700(NearbyDealsFragment.this).logClick("", "category_click", Channel.NEARBY.toString(), adapterview);
                startActivity(((IntentFactory)NearbyDealsFragment.access$1600(NearbyDealsFragment.this).get()).newSnapOfferGridIntent((new StringBuilder()).append(Channel.SNAP_GROCERY).append(com/groupon/activity/SnapOfferGridActivity.getSimpleName()).toString(), Channel.SNAP_GROCERY));
                return;
            }
            adapterview = category.id;
            NearbyDealsFragment.access$1302(NearbyDealsFragment.this, new FilterCategory(category.name, adapterview));
        }
        NearbyDealsFragment.access$1700(NearbyDealsFragment.this).logClick("", "category_click", Channel.NEARBY.toString(), adapterview);
        view.setBackgroundColor(getResources().getColor(0x7f0e00be));
        updateCategoriesButtonText();
        NearbyDealsFragment.access$1400(NearbyDealsFragment.this).dismiss();
        reload(oadReason.filterModified);
    }

    oadReason()
    {
        this$0 = NearbyDealsFragment.this;
        super();
    }
}
