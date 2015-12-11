// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.e;

import android.util.Log;
import com.smule.android.f.h;
import com.smule.pianoandroid.magicpiano.a.g;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.e:
//            i, a, d

class a
    implements Observer
{

    final i a;

    public void update(Observable observable, Object obj)
    {
        observable = (String)obj;
        if (observable.compareTo("LOGIN_TYPE_EXISTING") == 0)
        {
            Log.i(i.d(), "user logged into existing account");
            i.a(a);
            h.a().b("USER_LOGGED_IN_EVENT", this);
        } else
        {
            if (observable.compareTo("LOGIN_TYPE_GUEST") == 0)
            {
                Log.i(i.d(), "user logged in as guest");
                return;
            }
            if (observable.compareTo("LOGIN_TYPE_NEW") == 0)
            {
                Log.i(i.d(), "user registered.");
                g.a().a(0, 0L);
                com.smule.pianoandroid.e.a.a().e();
                d.a().c();
                h.a().b("USER_LOGGED_IN_EVENT", this);
                return;
            }
        }
    }

    iano.a.g(i j)
    {
        a = j;
        super();
    }
}
