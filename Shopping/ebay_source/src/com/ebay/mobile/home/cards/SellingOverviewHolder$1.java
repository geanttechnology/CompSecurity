// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.cards;

import android.animation.ValueAnimator;
import android.widget.TextView;
import com.ebay.mobile.common.EbayCurrencyUtil;

// Referenced classes of package com.ebay.mobile.home.cards:
//            SellingOverviewHolder

class cord.SellingOverview
    implements android.animation.dateListener
{

    final SellingOverviewHolder this$0;
    final com.ebay.nautilus.domain.data.UnifiedStream.ntentRecord.SellingOverview val$overview;

    public void onAnimationUpdate(ValueAnimator valueanimator)
    {
        if (val$overview.grossMerchandiseVolume != null)
        {
            double d = valueanimator.getAnimatedFraction();
            double d1 = val$overview.grossMerchandiseVolume.lue;
            double d2 = SellingOverviewHolder.access$000();
            totalSold.setText(EbayCurrencyUtil.formatDisplay(val$overview.grossMerchandiseVolume.rrency, (d * d1 * d2) / (double)SellingOverviewHolder.access$000(), 2));
        }
    }

    cord.SellingOverview()
    {
        this$0 = final_sellingoverviewholder;
        val$overview = com.ebay.nautilus.domain.data.UnifiedStream.ntentRecord.SellingOverview.this;
        super();
    }
}
