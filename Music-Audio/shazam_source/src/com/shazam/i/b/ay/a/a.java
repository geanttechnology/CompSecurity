// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.ay.a;

import android.content.Context;
import com.shazam.android.k.f.j;
import com.shazam.android.v.r;
import com.shazam.android.widget.c.b;
import com.shazam.android.widget.c.e;
import com.shazam.android.widget.c.f;
import com.shazam.i.b.c;
import com.shazam.i.d.d;

public final class a
{

    public static com.shazam.android.widget.c.d a()
    {
        return new b(new j(), com.shazam.i.b.c.a().getPackageManager(), com.shazam.i.b.c.a().getPackageName());
    }

    public static f b()
    {
        return new e(d.c(), a(), com.shazam.i.b.c.a().getPackageName());
    }

    public static com.shazam.android.widget.c.a c()
    {
        return new com.shazam.android.widget.c.c(new r(), com.shazam.i.b.ab.a.a(), a());
    }
}
