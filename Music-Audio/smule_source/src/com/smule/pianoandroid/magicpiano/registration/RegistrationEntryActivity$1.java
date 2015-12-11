// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.widget.Toast;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.smule.android.c.a;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            RegistrationEntryActivity

class a
    implements FacebookCallback
{

    final RegistrationEntryActivity a;

    public void a(LoginResult loginresult)
    {
        aa.a("Success", "Login");
        com.smule.android.c.a.c();
        com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a(a);
    }

    public void onCancel()
    {
        Toast.makeText(a, "Login Cancel", 1).show();
    }

    public void onError(FacebookException facebookexception)
    {
        Toast.makeText(a, facebookexception.getMessage(), 1).show();
    }

    public void onSuccess(Object obj)
    {
        a((LoginResult)obj);
    }

    (RegistrationEntryActivity registrationentryactivity)
    {
        a = registrationentryactivity;
        super();
    }
}
