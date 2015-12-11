// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.g.b:
//            a

final class e
    implements android.view.View.OnClickListener
{

    private com.offerup.android.g.b.a a;

    e(com.offerup.android.g.b.a a1)
    {
        a = a1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("Login_Cancel-Button_click");
        a.dismiss();
    }
}
