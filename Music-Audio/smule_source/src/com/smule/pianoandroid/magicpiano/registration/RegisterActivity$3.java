// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            RegisterActivity, LoginActivity

class a
    implements android.view.r
{

    final RegisterActivity a;

    public void onClick(View view)
    {
        view = new Intent(a, com/smule/pianoandroid/magicpiano/registration/LoginActivity);
        view.putExtra("param_email", a.a.getText().toString());
        a.startActivity(view);
        a.finish();
    }

    (RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}
