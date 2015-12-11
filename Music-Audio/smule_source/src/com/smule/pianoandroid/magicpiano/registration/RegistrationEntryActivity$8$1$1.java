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
    implements Runnable
{

    final aw a;
    final a b;

    public void run()
    {
        if (a.a.a != p.a)
        {
            RegistrationEntryActivity.e(b.b.b).f();
            RegistrationEntryActivity.a("FAILURE");
            return;
        }
        if (a.a.a())
        {
            if (RegistrationEntryActivity.d(b.b.b) != null)
            {
                RegistrationEntryActivity.d(b.b.b).dismiss();
            }
            RegistrationEntryActivity.e(b.b.b).a();
            RegistrationEntryActivity.a("SUCCESS");
            com.smule.pianoandroid.magicpiano.registration.e.b();
            e.a(b.b.b);
            return;
        } else
        {
            RegistrationEntryActivity.e(b.b.b).g();
            RegistrationEntryActivity.a("FAILURE");
            com.smule.android.network.core.b.a(a.a);
            return;
        }
    }

    ( , aw aw1)
    {
        b = ;
        a = aw1;
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


    // Unreferenced inner class com/smule/pianoandroid/magicpiano/registration/RegistrationEntryActivity$8$1

/* anonymous class */
    class RegistrationEntryActivity._cls8._cls1
        implements com.smule.android.network.managers.UserManager.LoginResponseCallback
    {

        final RegistrationEntryActivity._cls12 a;

        public void handleResponse(aw aw1)
        {
            a.b.runOnUiThread(new RegistrationEntryActivity._cls8._cls1._cls1(this, aw1));
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((aw)obj);
        }

            
            {
                a = _pcls12;
                super();
            }
    }

}
