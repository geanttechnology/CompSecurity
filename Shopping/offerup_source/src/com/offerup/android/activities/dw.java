// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.DialogInterface;
import com.offerup.android.c.a;
import com.offerup.android.dto.Item;
import java.util.List;

// Referenced classes of package com.offerup.android.activities:
//            MyOffersActivity, a

final class dw
    implements android.content.DialogInterface.OnClickListener
{

    private MyOffersActivity a;

    dw(MyOffersActivity myoffersactivity)
    {
        a = myoffersactivity;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        dialoginterface.cancel();
        MyOffersActivity.b(a);
        if (MyOffersActivity.c(a) && a.ratingsUseInAppRatings)
        {
            a.f.d((Item)a.c.get(MyOffersActivity.d(a)));
        }
    }
}
