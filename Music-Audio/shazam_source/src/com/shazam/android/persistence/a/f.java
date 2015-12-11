// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.a;

import android.content.Intent;
import com.shazam.android.persistence.n.b;
import com.shazam.android.util.b.a;
import com.shazam.k.t;
import com.shazam.model.account.UserState;

public final class f
    implements t
{

    private final b b;
    private final a c;

    public f(b b1, a a1)
    {
        b = b1;
        c = a1;
    }

    public final UserState a()
    {
        return UserState.fromString(b.h("user_state"));
    }

    public final void a(UserState userstate)
    {
        b.b("user_state", userstate.name());
        a a1 = c;
        Intent intent = new Intent("com.shazam.android.action.USER_STATE_CHANGED");
        intent.putExtra("extraNewUserState", userstate);
        a1.a(intent);
    }

    public final boolean b()
    {
        return b.a("pk_f_rc", false);
    }
}
