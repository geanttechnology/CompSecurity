// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.support.v4.view.ViewPager;
import android.widget.ListView;
import com.groupon.Channel;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

class this._cls0
    implements com.groupon.mapview.kListener
{

    final HotelCardListFragment this$0;

    public void onHotelClicked(int i)
    {
        LoggingUtils loggingutils = loggingUtils;
        String s;
        if (pagerChannel != null)
        {
            s = (new StringBuilder()).append(pagerChannel.toString()).append(":").append(i).toString();
        } else
        {
            s = Integer.toString(i);
        }
        loggingutils.logClickWithMetadata("", "map_deal_icon_click", s, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        HotelCardListFragment.access$702(HotelCardListFragment.this, true);
        if (isLandscape)
        {
            list.setItemChecked(i, true);
            list.setSelection(i);
        } else
        {
            hotelPager.setCurrentItem(i, true);
        }
        HotelCardListFragment.access$800(HotelCardListFragment.this, i);
        HotelCardListFragment.access$702(HotelCardListFragment.this, false);
    }

    Listener()
    {
        this$0 = HotelCardListFragment.this;
        super();
    }
}
