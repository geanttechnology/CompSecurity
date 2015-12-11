// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.groupon.service.core.UserManager;

// Referenced classes of package com.groupon.fragment:
//            Coupons

class val.inflated
    implements android.view.ckListener
{

    final Coupons this$0;
    final View val$inflated;

    public void onClick(View view)
    {
        ((ViewGroup)val$inflated.getParent()).removeView(val$inflated);
        userManager.setHasSeenCouponsIntroScreen();
        recyclerView.setVisibility(0);
    }

    lerView()
    {
        this$0 = final_coupons;
        val$inflated = View.this;
        super();
    }
}
