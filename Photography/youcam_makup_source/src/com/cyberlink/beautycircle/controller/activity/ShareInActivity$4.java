// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.DialogInterface;
import com.perfectcorp.utility.e;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInActivity

class a
    implements android.content.ClickListener
{

    final ShareInActivity a;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        e.b(new Object[] {
            "Click to cancel"
        });
        ShareInActivity.t(a);
        ShareInActivity.u(a);
        if (ShareInActivity.f(a) != null)
        {
            a.finish();
        }
    }

    (ShareInActivity shareinactivity)
    {
        a = shareinactivity;
        super();
    }
}
