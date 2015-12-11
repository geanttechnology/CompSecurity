// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;
import com.wishabi.flipp.app.dn;

// Referenced classes of package com.wishabi.flipp.widget:
//            CouponCell

final class w
    implements android.view.View.OnLongClickListener
{

    final int a;
    final CouponCell b;

    w(CouponCell couponcell, int i)
    {
        b = couponcell;
        a = i;
        super();
    }

    public final boolean onLongClick(View view)
    {
        if (CouponCell.a(b) == null)
        {
            return false;
        } else
        {
            return CouponCell.a(b).a();
        }
    }
}
