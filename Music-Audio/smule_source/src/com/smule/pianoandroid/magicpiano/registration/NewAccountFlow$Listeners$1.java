// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.support.v4.app.FragmentActivity;
import com.smule.android.c.a;
import com.smule.android.c.l;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.at;
import com.smule.android.network.models.AccountIcon;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            NewAccountFlow, b, RegistrationEntryActivity

class a
    implements Runnable
{

    final at a;
    final b b;

    public void run()
    {
        if (a.a == null || a.a.a != p.a)
        {
            b.b.a.f();
            return;
        }
        if (!a.a.a())
        {
            b.b.a.g();
            com.smule.android.network.core.b.a(a.a);
            return;
        }
        if (a.mAccount.handle != null)
        {
            com.smule.android.c.a.a(l.a);
            b.b.a.c();
            android.content.Intent intent = com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a(com.smule.pianoandroid.magicpiano.registration.NewAccountFlow.a(b.b), a.mAccount.handle, b.b.b);
            com.smule.pianoandroid.magicpiano.registration.NewAccountFlow.a(b.b).startActivity(intent);
            com.smule.pianoandroid.magicpiano.registration.NewAccountFlow.a(b.b).finish();
            return;
        } else
        {
            b.b.a.g();
            return;
        }
    }

    ( , at at1)
    {
        b = ;
        a = at1;
        super();
    }
}
