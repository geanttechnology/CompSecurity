// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;
import com.offerup.android.dto.Item;

// Referenced classes of package com.offerup.android.activities:
//            a, PostPaymentConfirmationActivity

final class ft
    implements android.view.View.OnClickListener
{

    private PostPaymentConfirmationActivity a;

    ft(PostPaymentConfirmationActivity postpaymentconfirmationactivity)
    {
        a = postpaymentconfirmationactivity;
        super();
    }

    public final void onClick(View view)
    {
        (new a(a)).c(a.a.getId());
    }
}
