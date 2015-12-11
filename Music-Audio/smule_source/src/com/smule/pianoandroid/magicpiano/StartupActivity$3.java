// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import com.smule.android.c.aa;
import com.smule.android.network.managers.UserManager;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            StartupActivity

class a
    implements Runnable
{

    final StartupActivity a;

    public void run()
    {
        a.runOnUiThread(new Runnable() {

            final StartupActivity._cls3 a;

            public void run()
            {
                StartupActivity.b(a.a, true);
                StartupActivity.a(a.a, false);
                aa.a(StartupActivity.d(), (new StringBuilder()).append("Login count for player ").append(UserManager.n().c()).append(" is ").append(UserManager.n().l()).toString());
                if (UserManager.n().l() < 3)
                {
                    a.a.c();
                    StartupActivity.c(a.a, true);
                    return;
                } else
                {
                    StartupActivity.e(a.a);
                    return;
                }
            }

            
            {
                a = StartupActivity._cls3.this;
                super();
            }
        });
    }

    _cls1.a(StartupActivity startupactivity)
    {
        a = startupactivity;
        super();
    }
}
