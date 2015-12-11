// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.smule.android.c.a;
import com.smule.android.c.l;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.at;
import com.smule.android.network.managers.ay;
import com.smule.android.network.models.AccountIcon;
import com.smule.pianoandroid.magicpiano.b.m;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            NewAccountFlow, b, e, NewHandleActivity, 
//            RegistrationEntryActivity

class <init>
    implements com.smule.android.network.managers.sponseCallback, m
{

    final NewAccountFlow a;

    public void a(ay ay1)
    {
        ay1 = ay1.a;
        if (ay1 == null || ((o) (ay1)).a != p.a)
        {
            a.a.f();
            b.d().p();
            return;
        }
        switch (((o) (ay1)).b)
        {
        default:
            b.a(ay1);
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
            final NewAccountFlow.Listeners b;

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
                    com.smule.android.c.a.a(l.a);
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
                b = NewAccountFlow.Listeners.this;
                a = at1;
                super();
            }
        });
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((at)obj);
    }

    private _cls1.a(NewAccountFlow newaccountflow)
    {
        a = newaccountflow;
        super();
    }

    a(NewAccountFlow newaccountflow, a a1)
    {
        this(newaccountflow);
    }
}
