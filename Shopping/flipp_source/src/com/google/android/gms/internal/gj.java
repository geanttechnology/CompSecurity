// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.ComponentName;
import android.os.IBinder;
import java.util.HashSet;

// Referenced classes of package com.google.android.gms.internal:
//            gk, gi, gb

final class gj
{

    final String a;
    final gk b = new gk(this);
    final HashSet c = new HashSet();
    int d;
    boolean e;
    IBinder f;
    ComponentName g;
    final gi h;

    public gj(gi gi, String s)
    {
        h = gi;
        super();
        a = s;
        d = 0;
    }

    public final void a(gb gb)
    {
        c.add(gb);
    }

    public final boolean b(gb gb)
    {
        return c.contains(gb);
    }
}
