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
    implements Runnable
{

    final a a;

    public void run()
    {
        f.a().a(UserManager.n().d(), a.a);
    }

    UserManager(UserManager usermanager)
    {
        a = usermanager;
        super();
    }

    // Unreferenced inner class com/smule/pianoandroid/utils/s$1

/* anonymous class */
    class s._cls1
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
                    b.a(new s._cls1._cls1(this));
                }
            }
        }

            
            {
                a = s1;
                super();
            }
    }

}
