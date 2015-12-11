// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.widget.EditText;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.at;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            LoginActivity, b

class a
    implements Runnable
{

    final at a;
    final LoginActivity b;

    public void run()
    {
        if (a != null && a.a.a())
        {
            LoginActivity.e(b).a(0x7f0c0147);
            return;
        }
        if (a != null && (a.a.b == 1012 || a.a.b == 65))
        {
            LoginActivity.e(b).a();
            LoginActivity.a(b, com.smule.pianoandroid.utils.o.a(b, com.smule.pianoandroid.magicpiano.registration.LoginActivity.b(b).getText().toString(), LoginActivity.f(b), LoginActivity.g(b)));
            return;
        } else
        {
            com.smule.android.network.core.b.a(a.a);
            LoginActivity.e(b).f();
            return;
        }
    }

    (LoginActivity loginactivity, at at1)
    {
        b = loginactivity;
        a = at1;
        super();
    }
}
