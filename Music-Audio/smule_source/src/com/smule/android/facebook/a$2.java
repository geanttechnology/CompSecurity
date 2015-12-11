// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.facebook;

import android.content.SharedPreferences;
import com.smule.android.c.aa;
import com.smule.android.f.p;
import com.smule.android.network.core.o;
import com.smule.android.network.managers.UserManager;

// Referenced classes of package com.smule.android.facebook:
//            a

class a
    implements Runnable
{

    final SharedPreferences a;
    final a b;

    public void run()
    {
        Object obj = b.a(null, false);
        obj = UserManager.n().a(((c) (obj)));
        if (obj != null && ((o) (obj)).a())
        {
            aa.a(com.smule.android.facebook.a.j(), "on connectFacebookToSmuleAccountSync - Facebook account successfully connected");
            p.a(a.edit().putBoolean("DID_CONNECT_FACEBOOK", true));
        }
        com.smule.android.facebook.a.a(b, false);
    }

    es(a a1, SharedPreferences sharedpreferences)
    {
        b = a1;
        a = sharedpreferences;
        super();
    }
}
