// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.widget.Toast;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.smule.android.c.a;
import com.smule.android.c.aa;
import com.smule.pianoandroid.magicpiano.b.c;
import com.smule.pianoandroid.magicpiano.b.d;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            SettingsActivity

class a
    implements FacebookCallback
{

    final SettingsActivity a;

    public void a(LoginResult loginresult)
    {
        com.smule.android.c.a.c();
        (new c(a, new d() {

            final SettingsActivity._cls12 a;

            public void a(boolean flag)
            {
                a.a.a(flag);
            }

            
            {
                a = SettingsActivity._cls12.this;
                super();
            }
        })).execute(new Void[0]);
    }

    public void onCancel()
    {
        aa.a(com.smule.pianoandroid.magicpiano.SettingsActivity.c(), "Cancel FB connect attempt");
    }

    public void onError(FacebookException facebookexception)
    {
        aa.b(com.smule.pianoandroid.magicpiano.SettingsActivity.c(), "Failed to connect to FB", facebookexception);
        Toast.makeText(a, "Error connecting to Facebook. Please try again.", 1).show();
    }

    public void onSuccess(Object obj)
    {
        a((LoginResult)obj);
    }

    _cls1.a(SettingsActivity settingsactivity)
    {
        a = settingsactivity;
        super();
    }
}
