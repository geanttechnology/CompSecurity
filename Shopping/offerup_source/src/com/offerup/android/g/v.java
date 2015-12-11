// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g;

import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.g:
//            u, w

final class v
    implements android.view.View.OnClickListener
{

    private u a;

    v(u u1)
    {
        a = u1;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("MyAccount_ChangeProfilePhoto-Photo_click");
        com.offerup.android.g.u.a(a).a();
    }
}
