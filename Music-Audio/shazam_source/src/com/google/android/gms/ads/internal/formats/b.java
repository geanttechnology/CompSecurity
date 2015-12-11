// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.b.c;
import com.google.android.gms.b.d;

public final class b extends com.google.android.gms.d.bk.a
{

    private final Drawable a;
    private final Uri b;

    public b(Drawable drawable, Uri uri)
    {
        a = drawable;
        b = uri;
    }

    public final c a()
    {
        return d.a(a);
    }

    public final Uri b()
    {
        return b;
    }
}
