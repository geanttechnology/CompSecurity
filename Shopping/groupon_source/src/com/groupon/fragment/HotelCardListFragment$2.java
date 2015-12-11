// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.animation.Animator;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.ListView;
import com.groupon.mapview.HotelMapView;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

class val.animated
    implements android.animation.r
{

    final HotelCardListFragment this$0;
    final boolean val$activate;
    final boolean val$animated;

    private void handleVisibility()
    {
        if (val$activate != isHotelPagerModeActivated)
        {
            return;
        }
        if (!val$activate) goto _L2; else goto _L1
_L1:
        scrollableContent.setVisibility(4);
_L4:
        if (HotelCardListFragment.access$500(HotelCardListFragment.this))
        {
            hotelsMapView.setMapGesturesEnabled(val$activate);
        }
        HotelCardListFragment.access$602(HotelCardListFragment.this, false);
        return;
_L2:
        HotelCardListFragment.access$302(HotelCardListFragment.this, false);
        if (list.getFirstVisiblePosition() > 0)
        {
            HotelCardListFragment.access$400(HotelCardListFragment.this, true, val$animated);
        }
        hotelPagerContainer.setVisibility(4);
        hotelPager.setCurrentItem(0, false);
        if (HotelCardListFragment.access$500(HotelCardListFragment.this))
        {
            hotelsMapView.setSelectedMarker(-1, false, false);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onAnimationCancel(Animator animator)
    {
        handleVisibility();
    }

    public void onAnimationEnd(Animator animator)
    {
        handleVisibility();
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    ()
    {
        this$0 = final_hotelcardlistfragment;
        val$activate = flag;
        val$animated = Z.this;
        super();
    }
}
