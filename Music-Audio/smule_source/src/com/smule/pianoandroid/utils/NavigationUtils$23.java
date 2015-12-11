// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.support.v4.app.FragmentActivity;
import com.smule.android.c.a;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.au;
import com.smule.pianoandroid.magicpiano.ag;
import com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity;
import com.smule.pianoandroid.magicpiano.registration.b;

// Referenced classes of package com.smule.pianoandroid.utils:
//            o, q

final class c
    implements com.smule.android.network.managers.ResponseCallback
{

    final FragmentActivity a;
    final b b;
    final Runnable c;

    public void handleResponse(au au1)
    {
        a.runOnUiThread(new Runnable(au1) {

            final au a;
            final NavigationUtils._cls23 b;

            public void run()
            {
                if (a.a.a != p.a)
                {
                    b.b.f();
                    b.c.run();
                }
                if (a.a.a())
                {
                    com.smule.android.c.a.a(true);
                    if (!b.a.isFinishing())
                    {
                        ((ag)b.a).p = null;
                        b.b.a();
                    }
                    android.content.Intent intent = RegistrationEntryActivity.a(b.a, true, true, a.mHandle, a.mEmail, null);
                    q.B();
                    b.a.startActivity(intent);
                    return;
                }
                if (a.a.b == 65)
                {
                    com.smule.android.c.a.a(false);
                    b.b.a();
                    b.c.run();
                    return;
                } else
                {
                    b.b.g();
                    com.smule.android.network.core.b.a(a.a);
                    b.c.run();
                    return;
                }
            }

            
            {
                b = NavigationUtils._cls23.this;
                a = au1;
                super();
            }
        });
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((au)obj);
    }

    (FragmentActivity fragmentactivity, b b1, Runnable runnable)
    {
        a = fragmentactivity;
        b = b1;
        c = runnable;
        super();
    }
}
