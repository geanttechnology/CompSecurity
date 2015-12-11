// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.ae;

import com.shazam.android.ah.d;
import com.shazam.android.ah.e;
import com.shazam.i.b.n.b;

public final class a
{

    private static com.shazam.android.ah.b a;

    public static d a()
    {
        com.shazam.android.aq.c c = com.shazam.i.b.m.a.a();
        com.shazam.android.j.af.f f = b.i();
        android.app.ActivityManager activitymanager = com.shazam.i.b.a.a();
        if (a == null)
        {
            a = new com.shazam.android.ah.b("5505f227656f44acb141c5990f99fdad");
        }
        return e.a(c, f, activitymanager, a);
    }
}
