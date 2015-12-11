// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            LoginActivity, ForgotPasswordActivity

class a
    implements android.view.ener
{

    final LoginActivity a;

    public void onClick(View view)
    {
        view = new Intent(a, com/smule/pianoandroid/magicpiano/registration/ForgotPasswordActivity);
        String s = LoginActivity.b(a).getText().toString();
        if (s != null)
        {
            view.putExtra("EMAIL", s);
        }
        a.startActivity(view);
        a.finish();
    }

    tivity(LoginActivity loginactivity)
    {
        a = loginactivity;
        super();
    }
}
