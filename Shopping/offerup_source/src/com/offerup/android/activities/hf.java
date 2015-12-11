// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.support.v7.widget.CardView;
import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            SelectBuyerActivity

final class hf
    implements android.view.View.OnClickListener
{

    private SelectBuyerActivity a;

    hf(SelectBuyerActivity selectbuyeractivity)
    {
        a = selectbuyeractivity;
        super();
    }

    public final void onClick(View view)
    {
        SelectBuyerActivity.b(a).performClick();
    }
}
