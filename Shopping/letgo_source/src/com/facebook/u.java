// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.support.v7.kb;
import android.support.v7.kc;
import android.support.v7.p;

// Referenced classes of package com.facebook:
//            k, t, Profile

final class u
{

    private static volatile u a;
    private final p b;
    private final t c;
    private Profile d;

    u(p p1, t t1)
    {
        kc.a(p1, "localBroadcastManager");
        kc.a(t1, "profileCache");
        b = p1;
        c = t1;
    }

    static u a()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        com/facebook/u;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new u(p.a(k.f()), new t());
        }
        com/facebook/u;
        JVM INSTR monitorexit ;
_L2:
        return a;
        Exception exception;
        exception;
        com/facebook/u;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private void a(Profile profile, Profile profile1)
    {
        Intent intent = new Intent("com.facebook.sdk.ACTION_CURRENT_PROFILE_CHANGED");
        intent.putExtra("com.facebook.sdk.EXTRA_OLD_PROFILE", profile);
        intent.putExtra("com.facebook.sdk.EXTRA_NEW_PROFILE", profile1);
        b.a(intent);
    }

    private void a(Profile profile, boolean flag)
    {
        Profile profile1 = d;
        d = profile;
        if (flag)
        {
            if (profile != null)
            {
                c.a(profile);
            } else
            {
                c.b();
            }
        }
        if (!kb.a(profile1, profile))
        {
            a(profile1, profile);
        }
    }

    void a(Profile profile)
    {
        a(profile, true);
    }

    Profile b()
    {
        return d;
    }

    boolean c()
    {
        boolean flag = false;
        Profile profile = c.a();
        if (profile != null)
        {
            a(profile, false);
            flag = true;
        }
        return flag;
    }
}
