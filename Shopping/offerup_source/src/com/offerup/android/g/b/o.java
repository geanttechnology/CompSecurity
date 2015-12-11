// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.g.b:
//            k, x

final class o
    implements android.view.View.OnClickListener
{

    private k a;

    o(k k1)
    {
        a = k1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("SignupLogin_Signup-Button_click");
        if (k.c(a) != null)
        {
            k.c(a).b();
        }
    }
}
