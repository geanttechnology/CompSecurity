// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.EditText;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            RegisterForgetPasswordActivity

class a
    implements Runnable
{

    final RegisterForgetPasswordActivity a;

    public void run()
    {
        String s = RegisterForgetPasswordActivity.a(a).getText().toString();
        RegisterForgetPasswordActivity.a(a, 48256, s);
    }

    (RegisterForgetPasswordActivity registerforgetpasswordactivity)
    {
        a = registerforgetpasswordactivity;
        super();
    }
}
