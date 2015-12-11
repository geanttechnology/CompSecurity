// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ax;

import android.content.Context;
import com.google.android.a.a.a;
import com.google.android.a.a.b;
import com.shazam.model.availability.YouTubeAvailability;

public final class i
    implements YouTubeAvailability
{

    private final Context a;

    public i(Context context)
    {
        a = context;
    }

    public final boolean a()
    {
        return com.google.android.a.a.a.a(a) == b.a;
    }
}
