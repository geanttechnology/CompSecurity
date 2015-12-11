// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewTreeObserver;
import com.groupon.view.PagerSlidingTabStrip;

// Referenced classes of package com.groupon.fragment:
//            Coupons

class val.inflated
    implements android.view.server.OnGlobalLayoutListener
{

    final Coupons this$0;
    final View val$inflated;

    public void onGlobalLayout()
    {
        Object obj = (Toolbar)getActivity().findViewById(0x7f100180);
        int i = ((PagerSlidingTabStrip)getActivity().findViewById(0x7f1000a9)).getHeight();
        int j = ((Toolbar) (obj)).getHeight();
        obj = (android.widget.yout.LayoutParams)val$inflated.findViewById(0x7f1001e1).getLayoutParams();
        ((android.widget.yout.LayoutParams) (obj)).setMargins(0, i + j, 0, 0);
        val$inflated.findViewById(0x7f1001e1).setLayoutParams(((android.view.LayoutParams) (obj)));
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    ayoutParams()
    {
        this$0 = final_coupons;
        val$inflated = View.this;
        super();
    }
}
