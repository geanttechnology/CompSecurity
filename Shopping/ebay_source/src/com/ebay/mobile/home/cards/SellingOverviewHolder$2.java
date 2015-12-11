// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.animation.Animator;
import android.widget.TextView;
import com.ebay.mobile.common.EbayCurrencyUtil;

// Referenced classes of package com.ebay.mobile.home.cards:
//            SellingOverviewHolder

class cord.SellingOverview
    implements android.animation.r
{

    final SellingOverviewHolder this$0;
    final com.ebay.nautilus.domain.data.UnifiedStream.ntentRecord.SellingOverview val$overview;

    public void onAnimationCancel(Animator animator)
    {
        animator.removeAllListeners();
    }

    public void onAnimationEnd(Animator animator)
    {
        if (val$overview.grossMerchandiseVolume != null)
        {
            totalSold.setText(EbayCurrencyUtil.formatDisplay(val$overview.grossMerchandiseVolume.rrency, val$overview.grossMerchandiseVolume.lue, 2));
        }
        animator.removeAllListeners();
    }

    public void onAnimationRepeat(Animator animator)
    {
    }

    public void onAnimationStart(Animator animator)
    {
    }

    cord.SellingOverview()
    {
        this$0 = final_sellingoverviewholder;
        val$overview = com.ebay.nautilus.domain.data.UnifiedStream.ntentRecord.SellingOverview.this;
        super();
    }
}
