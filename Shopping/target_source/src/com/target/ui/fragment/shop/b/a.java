// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop.b;

import android.support.v4.app.Fragment;
import com.target.ui.fragment.cardstream.CardStreamFragment;
import com.target.ui.model.shop.ShopOverrides;
import com.target.ui.util.deep_link.PromotionParams;
import java.util.Random;

// Referenced classes of package com.target.ui.fragment.shop.b:
//            e

public class a
    implements e
{

    private static final String LABEL = "my target";

    public a()
    {
    }

    public Fragment a(PromotionParams promotionparams, ShopOverrides shopoverrides)
    {
        return CardStreamFragment.b();
    }

    public String a()
    {
        return "my target";
    }

    public long b()
    {
        return ID_GENERATOR_FOR_CHANGING_FRAGMENTS.nextLong();
    }
}
