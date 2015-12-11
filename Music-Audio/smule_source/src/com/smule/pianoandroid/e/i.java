// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import android.content.Context;
import android.util.Log;
import com.smule.android.f.h;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ak;
import com.smule.android.network.managers.ap;
import com.smule.android.network.managers.d;
import com.smule.pianoandroid.data.db.b;
import com.smule.pianoandroid.magicpiano.a.g;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.e:
//            a, d

public class i
{

    private static i a = new i();
    private static final String b = com/smule/pianoandroid/e/i.getName();
    private Context c;

    private i()
    {
    }

    public static i a()
    {
        return a;
    }

    static void a(i j)
    {
        j.e();
    }

    static String d()
    {
        return b;
    }

    private void e()
    {
        com.smule.pianoandroid.e.a.a().f();
        com.smule.pianoandroid.data.db.b.a(c);
        g.a().c();
        com.smule.android.network.managers.i.a().e();
        ak.a().h();
        ap.a().h();
        com.smule.pianoandroid.e.d.a().d();
    }

    public void a(Context context)
    {
        c = context;
        if (!UserManager.n().h())
        {
            context = new Observer() {

                final i a;

                public void update(Observable observable, Object obj)
                {
                    observable = (String)obj;
                    if (observable.compareTo("LOGIN_TYPE_EXISTING") == 0)
                    {
                        Log.i(com.smule.pianoandroid.e.i.d(), "user logged into existing account");
                        i.a(a);
                        h.a().b("USER_LOGGED_IN_EVENT", this);
                    } else
                    {
                        if (observable.compareTo("LOGIN_TYPE_GUEST") == 0)
                        {
                            Log.i(com.smule.pianoandroid.e.i.d(), "user logged in as guest");
                            return;
                        }
                        if (observable.compareTo("LOGIN_TYPE_NEW") == 0)
                        {
                            Log.i(com.smule.pianoandroid.e.i.d(), "user registered.");
                            g.a().a(0, 0L);
                            com.smule.pianoandroid.e.a.a().e();
                            com.smule.pianoandroid.e.d.a().c();
                            h.a().b("USER_LOGGED_IN_EVENT", this);
                            return;
                        }
                    }
                }

            
            {
                a = i.this;
                super();
            }
            };
            h.a().a("USER_LOGGED_IN_EVENT", context);
        }
    }

    public void b()
    {
        com.smule.android.network.managers.i.a().e();
        com.smule.android.network.managers.d.a().a(10);
        ak.a().h();
        ap.a().h();
    }

    public void c()
    {
        com.smule.android.network.managers.i.a().d();
        ak.a().g();
        com.smule.android.network.managers.d.a().c();
        com.smule.pianoandroid.e.d.a().d();
        ap.a().g();
    }

}
