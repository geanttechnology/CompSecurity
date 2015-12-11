// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;
import com.wishabi.flipp.app.dn;

// Referenced classes of package com.wishabi.flipp.widget:
//            CouponCell

final class v
    implements android.view.View.OnClickListener
{

    final int a;
    final CouponCell b;

    v(CouponCell couponcell, int i)
    {
        b = couponcell;
        a = i;
        super();
    }

    public final void onClick(View view)
    {
        if (CouponCell.a(b) == null)
        {
            return;
        } else
        {
            CouponCell.a(b).a(a);
            return;
        }
    }
}
