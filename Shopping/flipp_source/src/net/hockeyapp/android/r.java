// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import net.hockeyapp.android.b.a;

// Referenced classes of package net.hockeyapp.android:
//            y, z, UpdateActivity

final class r extends a
{

    final UpdateActivity a;

    r(UpdateActivity updateactivity)
    {
        a = updateactivity;
        super();
    }

    public final String a(int i)
    {
        z z1 = y.b();
        if (z1 != null)
        {
            return z1.a(i);
        } else
        {
            return null;
        }
    }

    public final void a()
    {
        a.b();
    }

    public final void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            a.a();
            return;
        } else
        {
            a.b();
            return;
        }
    }
}
