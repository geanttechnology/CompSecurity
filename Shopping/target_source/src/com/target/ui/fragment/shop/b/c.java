// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop.b;

import android.support.v4.app.Fragment;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.ui.fragment.shop.DealsPageItemFragment;

// Referenced classes of package com.target.ui.fragment.shop.b:
//            f

public class c
    implements f
{

    private PromotionRequest mPromotionRequest;

    public c(PromotionRequest promotionrequest)
    {
        mPromotionRequest = promotionrequest;
    }

    public Fragment a()
    {
        if (mPromotionRequest != null)
        {
            return DealsPageItemFragment.a(mPromotionRequest);
        } else
        {
            return DealsPageItemFragment.d();
        }
    }
}
