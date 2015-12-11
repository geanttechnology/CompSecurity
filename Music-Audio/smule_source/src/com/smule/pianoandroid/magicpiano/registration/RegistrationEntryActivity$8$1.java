// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.app.Dialog;
import android.view.View;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.aw;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            RegistrationEntryActivity, b, e

class a
    implements com.smule.android.network.managers.ack
{

    final handleResponse a;

    public void handleResponse(aw aw1)
    {
        a..runOnUiThread(new Runnable(aw1) {

            final aw a;
            final RegistrationEntryActivity._cls8._cls1 b;

            public void run()
            {
                if (a.a.a != p.a)
                {
                    RegistrationEntryActivity.e(b.a.b).f();
                    RegistrationEntryActivity.a("FAILURE");
                    return;
                }
                if (a.a.a())
                {
                    if (RegistrationEntryActivity.d(b.a.b) != null)
                    {
                        RegistrationEntryActivity.d(b.a.b).dismiss();
                    }
                    RegistrationEntryActivity.e(b.a.b).a();
                    RegistrationEntryActivity.a("SUCCESS");
                    com.smule.pianoandroid.magicpiano.registration.e.b();
                    e.a(b.a.b);
                    return;
                } else
                {
                    RegistrationEntryActivity.e(b.a.b).g();
                    RegistrationEntryActivity.a("FAILURE");
                    com.smule.android.network.core.b.a(a.a);
                    return;
                }
            }

            
            {
                b = RegistrationEntryActivity._cls8._cls1.this;
                a = aw1;
                super();
            }
        });
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((aw)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/magicpiano/registration/RegistrationEntryActivity$12

/* anonymous class */
    class RegistrationEntryActivity._cls12
        implements android.view.View.OnClickListener
    {

        final String a;
        final RegistrationEntryActivity b;

        public void onClick(View view)
        {
            if (!RegistrationEntryActivity.c(b))
            {
                RegistrationEntryActivity.a(b, a, null);
                RegistrationEntryActivity.d(b).dismiss();
                return;
            } else
            {
                RegistrationEntryActivity.a("IN_PROGRESS");
                RegistrationEntryActivity.e(b).a(b.getString(0x7f0c016c), "");
                UserManager.n().a(new RegistrationEntryActivity._cls8._cls1(this));
                return;
            }
        }

            
            {
                b = registrationentryactivity;
                a = s;
                super();
            }
    }

}
