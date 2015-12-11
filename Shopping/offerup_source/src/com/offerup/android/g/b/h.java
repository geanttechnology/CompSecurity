// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.g.b;

import com.offerup.android.d.c;
import com.offerup.android.dto.response.UserResponse;
import com.offerup.android.tracker.a;
import com.offerup.android.utils.as;
import com.offerup.android.utils.n;

// Referenced classes of package com.offerup.android.g.b:
//            a

final class h
    implements c
{

    private com.offerup.android.g.b.a a;

    private h(com.offerup.android.g.b.a a1)
    {
        a = a1;
        super();
    }

    h(com.offerup.android.g.b.a a1, byte byte0)
    {
        this(a1);
    }

    public final void a()
    {
        com.offerup.android.g.b.a.a(a, "", a.getString(0x7f09014b));
    }

    public final void a(int i)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            as.a(com.offerup.android.g.b.a.a(a), a.getString(0x7f09010a));
            return;

        case 2: // '\002'
            as.a(com.offerup.android.g.b.a.a(a), a.getString(0x7f09011e));
            return;

        case 3: // '\003'
            as.a(com.offerup.android.g.b.a.b(a), a.getString(0x7f09010c));
            return;

        case 4: // '\004'
            as.a(com.offerup.android.g.b.a.b(a), a.getString(0x7f09011f));
            break;
        }
    }

    public final void a(UserResponse userresponse)
    {
        com.offerup.android.tracker.a.b("Login_Login-Button_success");
        n.a(com.offerup.android.g.b.a.e(a));
        com.offerup.android.g.b.a.a(a, userresponse);
        a.dismiss();
    }

    public final void b()
    {
        n.a(com.offerup.android.g.b.a.e(a));
        n.a(a.getActivity(), "", a.getString(0x7f090149));
    }
}
