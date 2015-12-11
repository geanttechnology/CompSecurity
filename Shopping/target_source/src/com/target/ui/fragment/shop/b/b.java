// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop.b;

import android.support.v4.app.Fragment;
import com.target.mothership.common.weeklyad.PromotionRequest;
import com.target.ui.fragment.shop.DealsFragment;

// Referenced classes of package com.target.ui.fragment.shop.b:
//            f

public class b
    implements f
{

    private PromotionRequest mPromotionRequest;

    public b(PromotionRequest promotionrequest)
    {
        mPromotionRequest = promotionrequest;
    }

    public Fragment a()
    {
        if (mPromotionRequest != null)
        {
            return DealsFragment.a(mPromotionRequest);
        } else
        {
            return DealsFragment.f();
        }
    }
}
