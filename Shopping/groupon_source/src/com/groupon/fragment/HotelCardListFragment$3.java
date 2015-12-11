// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.Channel;
import com.groupon.mapview.HotelMapView;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

class this._cls0
    implements android.support.v4.view.stener
{

    final HotelCardListFragment this$0;

    public void onPageScrollStateChanged(int i)
    {
    }

    public void onPageScrolled(int i, float f, int j)
    {
    }

    public void onPageSelected(int i)
    {
        if (isHotelPagerModeActivated && HotelCardListFragment.access$500(HotelCardListFragment.this))
        {
            if (!HotelCardListFragment.access$700(HotelCardListFragment.this))
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
                loggingutils.logClickWithMetadata("", "map_carousel_swipe_click", s, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            }
            hotelsMapView.setSelectedMarker(i, true, false);
        }
        HotelCardListFragment.access$800(HotelCardListFragment.this, i);
    }

    eListener()
    {
        this$0 = HotelCardListFragment.this;
        super();
    }
}
