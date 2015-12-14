// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.kernelctrl.z;
import com.cyberlink.youcammakeup.utility.bd;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            MoreActivity

class a
    implements android.view.tener
{

    final MoreActivity a;

    public void onClick(View view)
    {
        MoreActivity.a(a, false);
        boolean flag = bd.a(a);
        if (flag)
        {
            z.a("HAS_RATE_THIS_APP", Boolean.valueOf(flag), a);
        }
    }

    (MoreActivity moreactivity)
    {
        a = moreactivity;
        super();
    }
}
