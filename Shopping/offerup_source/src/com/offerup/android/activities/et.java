// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.view.View;

// Referenced classes of package com.offerup.android.activities:
//            PayCashlessActivity

final class et
    implements android.view.View.OnClickListener
{

    private PayCashlessActivity a;

    et(PayCashlessActivity paycashlessactivity)
    {
        a = paycashlessactivity;
        super();
    }

    public final void onClick(View view)
    {
        if (PayCashlessActivity.a(a))
        {
            PayCashlessActivity.b(a);
        }
    }
}
