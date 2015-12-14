// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.dialogs;

import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKRatingCardEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bd;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.dialogs:
//            ad

class a
    implements android.view.OnClickListener
{

    final ad a;

    public void onClick(View view)
    {
        b.a(new YMKRatingCardEvent(com.cyberlink.youcammakeup.clflurry.tingCardEvent.Operation.b));
        a.dismiss();
        boolean flag = bd.a(ad.a(a));
        if (flag)
        {
            z.a("HAS_RATE_THIS_APP", Boolean.valueOf(flag), Globals.d());
            return;
        } else
        {
            m.e("[PromoteUserRatingDialog] RateUsButton#onClick", "startActivity exception");
            return;
        }
    }

    ent.Operation(ad ad1)
    {
        a = ad1;
        super();
    }
}
