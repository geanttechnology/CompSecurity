// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.a.e;
import com.facebook.b.t;
import org.json.JSONObject;

// Referenced classes of package com.facebook:
//            k, t, Profile

final class u
{

    private static volatile u c;
    final com.facebook.t a;
    Profile b;
    private final e d;

    private u(e e1, com.facebook.t t1)
    {
        com.facebook.b.u.a(e1, "localBroadcastManager");
        com.facebook.b.u.a(t1, "profileCache");
        d = e1;
        a = t1;
    }

    static u a()
    {
        if (c != null) goto _L2; else goto _L1
_L1:
        com/facebook/u;
        JVM INSTR monitorenter ;
        if (c == null)
        {
            c = new u(e.a(k.g()), new com.facebook.t());
        }
        com/facebook/u;
        JVM INSTR monitorexit ;
_L2:
        return c;
        Exception exception;
        exception;
        com/facebook/u;
        JVM INSTR monitorexit ;
        throw exception;
    }

    final void a(Profile profile, boolean flag)
    {
        Profile profile1 = b;
        b = profile;
        if (flag)
        {
            if (profile != null)
            {
                com.facebook.t t1 = a;
                com.facebook.b.u.a(profile, "profile");
                JSONObject jsonobject = profile.c();
                if (jsonobject != null)
                {
                    t1.a.edit().putString("com.facebook.ProfileManager.CachedProfile", jsonobject.toString()).apply();
                }
            } else
            {
                a.a.edit().remove("com.facebook.ProfileManager.CachedProfile").apply();
            }
        }
        if (!t.a(profile1, profile))
        {
            Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
            intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile1);
            intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile);
            d.a(intent);
        }
    }
}
