// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import com.offerup.android.dto.Item;
import org.apache.commons.lang3.math.NumberUtils;

// Referenced classes of package com.offerup.android.activities:
//            BuyActivity

final class ac
    implements android.view.View.OnClickListener
{

    private BuyActivity a;

    ac(BuyActivity buyactivity)
    {
        a = buyactivity;
        super();
    }

    public final void onClick(View view)
    {
        if (NumberUtils.isNumber(a.a.getPrice()))
        {
            a.b = Double.valueOf(a.a.getPrice()).doubleValue();
        } else
        {
            a.b = 0.0D;
        }
        BuyActivity.a(a);
    }
}
