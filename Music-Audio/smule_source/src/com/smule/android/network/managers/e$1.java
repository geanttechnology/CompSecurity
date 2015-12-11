// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.managers;

import com.smule.android.f.h;
import java.util.Observable;
import java.util.Observer;

// Referenced classes of package com.smule.android.network.managers:
//            e

class a
    implements Observer
{

    final e a;

    public void update(Observable observable, Object obj)
    {
        if (((String)obj).compareTo("LOGIN_TYPE_EXISTING") == 0)
        {
            e.a(a);
            h.a().b("USER_LOGGED_IN_EVENT", e.b(a));
        }
    }

    (e e1)
    {
        a = e1;
        super();
    }
}
