// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook;

import android.content.Intent;
import android.support.v4.a.h;
import com.facebook.internal.o;
import com.facebook.internal.p;

// Referenced classes of package com.facebook:
//            i, r, Profile

final class s
{

    private static volatile s a;
    private final h b;
    private final r c;
    private Profile d;

    s(h h1, r r1)
    {
        p.a(h1, "localBroadcastManager");
        p.a(r1, "profileCache");
        b = h1;
        c = r1;
    }

    static s a()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        com/facebook/s;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new s(h.a(i.f()), new r());
        }
        com/facebook/s;
        JVM INSTR monitorexit ;
_L2:
        return a;
        Exception exception;
        exception;
        com/facebook/s;
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
        if (!o.a(profile1, profile))
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
