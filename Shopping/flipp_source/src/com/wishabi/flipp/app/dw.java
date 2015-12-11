// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.app.Activity;
import android.content.Intent;
import com.wishabi.flipp.widget.cw;

// Referenced classes of package com.wishabi.flipp.app:
//            PrintCouponFragment, CouponHelpActivity

final class dw
    implements cw
{

    final PrintCouponFragment a;

    dw(PrintCouponFragment printcouponfragment)
    {
        a = printcouponfragment;
        super();
    }

    public final void a()
    {
        PrintCouponFragment.b(a);
    }

    public final void b()
    {
        Activity activity = a.getActivity();
        if (activity == null)
        {
            return;
        } else
        {
            activity.startActivity(new Intent(activity, com/wishabi/flipp/app/CouponHelpActivity));
            activity.overridePendingTransition(0x7f040001, 0x7f040002);
            return;
        }
    }
}
