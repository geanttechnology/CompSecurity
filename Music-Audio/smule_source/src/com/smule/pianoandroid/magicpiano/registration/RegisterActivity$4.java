// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.app.Dialog;
import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            RegisterActivity

class a
    implements android.view.r
{

    final RegisterActivity a;

    public void onClick(View view)
    {
        RegisterActivity.b(a).dismiss();
        a.a.setText("");
    }

    (RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}
