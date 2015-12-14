// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle;

import android.app.Dialog;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle:
//            BaseActivity

class a
    implements Runnable
{

    final BaseActivity a;

    public void run()
    {
        if (BaseActivity.a(a) != null && BaseActivity.a(a).isShowing())
        {
            e.b(new Object[] {
                "closeProgress"
            });
            BaseActivity.a(a).dismiss();
            BaseActivity.a(a, null);
        }
        BaseActivity.a(a, false);
    }

    (BaseActivity baseactivity)
    {
        a = baseactivity;
        super();
    }
}
