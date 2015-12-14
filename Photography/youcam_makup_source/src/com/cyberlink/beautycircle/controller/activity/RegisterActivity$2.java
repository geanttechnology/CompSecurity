// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.widget.EditText;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.as;
import com.cyberlink.beautycircle.j;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a
    implements android.view.r
{

    final RegisterActivity a;

    public void onClick(View view)
    {
        view = ((EditText)a.findViewById(j.register_id)).getText().toString();
        c.a(a, view);
        b.a(new as("forgot_password"));
    }

    (RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}
