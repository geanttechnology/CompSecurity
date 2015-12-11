// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.database.DataSetObserver;
import android.widget.ListView;
import com.groupon.adapter.HotelPagerAdapter;
import com.groupon.mapview.HotelMapView;
import commonlib.adapter.JavaListAdapter;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

class this._cls0 extends DataSetObserver
{

    final HotelCardListFragment this$0;

    public void onChanged()
    {
        boolean flag1 = true;
        super.onChanged();
        if (hotelsMapView != null)
        {
            HotelCardListFragment.access$1000(HotelCardListFragment.this);
            if (HotelCardListFragment.access$500(HotelCardListFragment.this))
            {
                hotelsMapView.setHotels(HotelCardListFragment.access$1100(HotelCardListFragment.this).getListCopy());
                if (isLandscape || isHotelPagerModeActivated)
                {
                    hotelsMapView.setSelectedMarker(HotelCardListFragment.access$1200(HotelCardListFragment.this), true, true);
                }
            }
            if (isLandscape)
            {
                list.setItemChecked(HotelCardListFragment.access$1200(HotelCardListFragment.this), true);
                list.setSelection(HotelCardListFragment.access$1200(HotelCardListFragment.this));
            }
        }
        if (!isLandscape)
        {
            HotelCardListFragment.access$1300(HotelCardListFragment.this).notifyDataSetChanged();
            boolean flag2 = isHotelPagerModeOnly;
            if (HotelCardListFragment.access$1400(HotelCardListFragment.this) > 0)
            {
                isHotelPagerModeOnly = HotelCardListFragment.access$1500(HotelCardListFragment.this);
            }
            HotelCardListFragment hotelcardlistfragment = HotelCardListFragment.this;
            boolean flag;
            if (isHotelPagerModeOnly || isHotelPagerModeActivated)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag2 == isHotelPagerModeOnly)
            {
                flag1 = false;
            }
            HotelCardListFragment.access$1600(hotelcardlistfragment, flag, false, flag1);
        }
    }

    ()
    {
        this$0 = HotelCardListFragment.this;
        super();
    }
}
