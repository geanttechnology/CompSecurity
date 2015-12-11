// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.animation.Animator;
import android.widget.ImageButton;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

class val.shown
    implements android.animation.
{

    final HotelCardListFragment this$0;
    final boolean val$shown;

    private void handleVisibility()
    {
        while (val$shown != HotelCardListFragment.access$1800(HotelCardListFragment.this) || HotelCardListFragment.access$1800(HotelCardListFragment.this)) 
        {
            return;
        }
        mapFloatingActionButton.setVisibility(4);
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
        val$shown = Z.this;
        super();
    }
}
