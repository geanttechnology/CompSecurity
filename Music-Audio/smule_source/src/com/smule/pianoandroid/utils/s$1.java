// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import com.c.a.b.f;
import com.smule.android.f.h;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.UserManager;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.pianoandroid.utils:
//            s

class a
    implements Observer
{

    final s a;

    public void update(Observable observable, Object obj)
    {
        if (((String)obj).compareTo("LOGIN_TYPE_EXISTING") == 0)
        {
            h.a().b("USER_LOGGED_IN_EVENT", this);
            if (UserManager.n().d() != null)
            {
                s.a(a, Boolean.valueOf(true));
                b.a(new Runnable() {

                    final s._cls1 a;

                    public void run()
                    {
                        f.a().a(UserManager.n().d(), a.a);
                    }

            
            {
                a = s._cls1.this;
                super();
            }
                });
            }
        }
    }

    _cls1.a(s s1)
    {
        a = s1;
        super();
    }
}
