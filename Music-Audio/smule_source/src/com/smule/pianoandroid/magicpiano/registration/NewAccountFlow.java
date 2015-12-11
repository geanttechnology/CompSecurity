// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.smule.pianoandroid.magicpiano.b.l;
import com.smule.pianoandroid.utils.ab;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            b

public class NewAccountFlow
{

    private static final String c = com/smule/pianoandroid/magicpiano/registration/NewAccountFlow.getName();
    com.smule.pianoandroid.magicpiano.registration.b a;
    String b;
    private FragmentActivity d;

    public NewAccountFlow(FragmentActivity fragmentactivity)
    {
        d = fragmentactivity;
    }

    static FragmentActivity a(NewAccountFlow newaccountflow)
    {
        return newaccountflow.d;
    }

    public boolean a(String s, String s1)
    {
        if (a != null)
        {
            a.c();
            a = null;
        }
        b = s;
        Listeners listeners = new Listeners();
        a = new com.smule.pianoandroid.magicpiano.registration.b(d);
        a.a(d.getResources().getString(0x7f0c0054), c);
        if (!ab.a(s))
        {
            a.a(d.getResources().getString(0x7f0c00e4));
            return false;
        } else
        {
            (new l(d, b, s1, listeners)).execute(new Void[0]);
            return true;
        }
    }


    private class Listeners
        implements com.smule.android.network.managers.UserManager.AccountIconResponseCallback, m
    {

        final NewAccountFlow a;

        public void a(ay ay1)
        {
            ay1 = ay1.a;
            if (ay1 == null || ((o) (ay1)).a != p.a)
            {
                a.a.f();
                com.smule.android.network.core.b.d().p();
                return;
            }
            switch (((o) (ay1)).b)
            {
            default:
                com.smule.android.network.core.b.a(ay1);
                a.a.g();
                return;

            case 56: // '8'
            case 67: // 'C'
            case 1006: 
                if (((o) (ay1)).f == 13)
                {
                    UserManager.n().a(a.b, this);
                    return;
                } else
                {
                    a.a.a(0x7f0c00e4);
                    return;
                }

            case 0: // '\0'
                e.d();
                ay1 = new Intent(com.smule.pianoandroid.magicpiano.registration.NewAccountFlow.a(a), com/smule/pianoandroid/magicpiano/registration/NewHandleActivity);
                a.a.c();
                com.smule.pianoandroid.magicpiano.registration.NewAccountFlow.a(a).startActivity(ay1);
                com.smule.pianoandroid.magicpiano.registration.NewAccountFlow.a(a).finish();
                return;
            }
        }

        public void handleResponse(at at1)
        {
            com.smule.pianoandroid.magicpiano.registration.NewAccountFlow.a(a).runOnUiThread(new Runnable(at1) {

                final at a;
                final Listeners b;

                public void run()
                {
                    if (a.a == null || a.a.a != p.a)
                    {
                        b.a.a.f();
                        return;
                    }
                    if (!a.a.a())
                    {
                        b.a.a.g();
                        com.smule.android.network.core.b.a(a.a);
                        return;
                    }
                    if (a.mAccount.handle != null)
                    {
                        com.smule.android.c.a.a(com.smule.android.c.l.a);
                        b.a.a.c();
                        Intent intent = com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a(com.smule.pianoandroid.magicpiano.registration.NewAccountFlow.a(b.a), a.mAccount.handle, b.a.b);
                        com.smule.pianoandroid.magicpiano.registration.NewAccountFlow.a(b.a).startActivity(intent);
                        com.smule.pianoandroid.magicpiano.registration.NewAccountFlow.a(b.a).finish();
                        return;
                    } else
                    {
                        b.a.a.g();
                        return;
                    }
                }

                
                {
                    b = Listeners.this;
                    a = at1;
                    super();
                }
            });
        }

        public volatile void handleResponse(Object obj)
        {
            handleResponse((at)obj);
        }

        private Listeners()
        {
            a = NewAccountFlow.this;
            super();
        }

    }

}
