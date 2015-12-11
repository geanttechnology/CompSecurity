// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.Toast;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap

class a
    implements FacebookCallback
{

    final ap a;

    public void a(LoginResult loginresult)
    {
        if (ap.j(a) != null)
        {
            ap.j(a).run();
            ap.a(a, null);
        }
        if (ap.k(a))
        {
            ap.l(a);
            return;
        } else
        {
            ap.m(a);
            return;
        }
    }

    public void onCancel()
    {
        aa.a(ap.d(), "Cancel FB connect attempt");
    }

    public void onError(FacebookException facebookexception)
    {
        aa.b(ap.d(), "Failed to connect to FB", facebookexception);
        Toast.makeText(a, "Error connecting to Facebook. Please try again.", 1).show();
    }

    public void onSuccess(Object obj)
    {
        a((LoginResult)obj);
    }

    (ap ap1)
    {
        a = ap1;
        super();
    }
}
