// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import com.cyberlink.beautycircle.controller.a.as;
import com.perfectcorp.a.b;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterActivity

class a
    implements android.view.
{

    final RegisterActivity a;

    public void onClick(View view)
    {
        RegisterActivity.a(a, eMode.a, true, true);
        b.a(new as("sign_up"));
    }

    eMode(RegisterActivity registeractivity)
    {
        a = registeractivity;
        super();
    }
}
