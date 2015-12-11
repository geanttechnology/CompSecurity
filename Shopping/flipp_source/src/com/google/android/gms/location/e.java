// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.common.b;
import com.google.android.gms.common.c;
import com.google.android.gms.common.d;
import com.google.android.gms.internal.ir;
import com.google.android.gms.internal.iu;

public final class e
    implements b
{

    public final iu a;

    public e(Context context, c c, d d)
    {
        a = new iu(context, c, d, "location");
    }

    public final Location a()
    {
        return a.f.a();
    }
}
