// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.hockeyapp.android;

import android.app.Activity;
import net.hockeyapp.android.b.a;

// Referenced classes of package net.hockeyapp.android:
//            y, z, v

final class w extends a
{

    final Activity a;
    final v b;

    w(v v1, Activity activity)
    {
        b = v1;
        a = activity;
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
    }

    public final void a(Boolean boolean1)
    {
        if (boolean1.booleanValue())
        {
            v.access$000(b, a);
        }
    }
}
