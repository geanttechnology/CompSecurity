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
//            q, o

class a
    implements Runnable
{

    final au a;
    final b b;

    public void run()
    {
        if (a.a.a != p.a)
        {
            b.b.f();
            b.b.run();
        }
        if (a.a.a())
        {
            com.smule.android.c.a.a(true);
            if (!b.b.isFinishing())
            {
                ((ag)b.b).p = null;
                b.b.a();
            }
            android.content.Intent intent = RegistrationEntryActivity.a(b.b, true, true, a.mHandle, a.mEmail, null);
            q.B();
            b.b.startActivity(intent);
            return;
        }
        if (a.a.b == 65)
        {
            com.smule.android.c.a.a(false);
            b.b.a();
            b.b.run();
            return;
        } else
        {
            b.b.g();
            com.smule.android.network.core.b.a(a.a);
            b.b.run();
            return;
        }
    }

    ountResponseCallback(ountResponseCallback ountresponsecallback, au au1)
    {
        b = ountresponsecallback;
        a = au1;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/utils/NavigationUtils$23

/* anonymous class */
    final class NavigationUtils._cls23
        implements com.smule.android.network.managers.UserManager.AccountResponseCallback
    {

        final FragmentActivity a;
        final b b;
        final Runnable c;

        public void handleResponse(au au1)
        {
            a.runOnUiThread(new NavigationUtils._cls23._cls1(this, au1));
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((au)obj);
        }

            
            {
                a = fragmentactivity;
                b = b1;
                c = runnable;
                super();
            }
    }

}
