// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.o.c;

import android.content.Context;
import com.shazam.android.k.f.ab;
import com.shazam.android.k.f.e;
import com.shazam.i.b.ah.a;
import com.shazam.i.b.c;

public final class d
{

    public static ab a()
    {
        return a(c.a(), "my_tags");
    }

    public static ab a(Context context, String s)
    {
        return new e(com.shazam.i.b.ah.a.a(context).a(s, new String[0]), context.getContentResolver());
    }

    public static ab b()
    {
        return a(c.a(), "streaming_provider");
    }
}
