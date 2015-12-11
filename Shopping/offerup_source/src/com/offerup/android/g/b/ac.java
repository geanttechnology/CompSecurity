// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.text.style.ClickableSpan;
import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.g.b:
//            z

final class ac extends ClickableSpan
{

    private z a;

    ac(z z1)
    {
        a = z1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("Signup_TOS-Button_click");
        z.e(a).b(false);
    }
}
