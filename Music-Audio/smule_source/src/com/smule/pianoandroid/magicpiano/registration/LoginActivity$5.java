// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            LoginActivity, NewAccountFlow

class a
    implements android.view.ener
{

    final LoginActivity a;

    public void onClick(View view)
    {
        LoginActivity.a(a, null);
        (new NewAccountFlow(a)).a(LoginActivity.b(a).getText().toString(), LoginActivity.c(a).getText().toString());
    }

    (LoginActivity loginactivity)
    {
        a = loginactivity;
        super();
    }
}
