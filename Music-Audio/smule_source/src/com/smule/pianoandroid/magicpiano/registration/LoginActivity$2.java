// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.content.res.Resources;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.utils.ab;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            LoginActivity

class a
    implements android.view.ener
{

    final LoginActivity a;

    public void onClick(View view)
    {
        if (!ab.a(LoginActivity.b(a).getText().toString()))
        {
            MagicApplication.getInstance().showToast(a.getResources().getString(0x7f0c00e4), 0);
            return;
        }
        if (LoginActivity.c(a).getText().length() < 6)
        {
            MagicApplication.getInstance().showToast(a.getResources().getString(0x7f0c01cc), 0);
            return;
        } else
        {
            LoginActivity.d(a);
            return;
        }
    }

    (LoginActivity loginactivity)
    {
        a = loginactivity;
        super();
    }
}
