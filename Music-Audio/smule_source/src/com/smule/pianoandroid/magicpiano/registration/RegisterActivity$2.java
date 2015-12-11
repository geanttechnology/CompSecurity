// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            RegisterActivity, NewAccountFlow

class a
    implements android.view.r
{

    final RegisterActivity a;

    public void onClick(View view)
    {
        if ((new NewAccountFlow(a)).a(a.a.getText().toString(), null))
        {
            a.b.setEnabled(false);
        }
    }

    (RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}
