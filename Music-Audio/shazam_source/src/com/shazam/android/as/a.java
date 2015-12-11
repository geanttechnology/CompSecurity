// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.as;

import android.content.res.Resources;
import android.net.Uri;
import com.shazam.android.k.f.b.a.r;

public final class a
    implements r
{

    private final Resources a;

    public a(Resources resources)
    {
        a = resources;
    }

    public final boolean a(Uri uri)
    {
        String s;
        if (uri != null)
        {
            if (!com.shazam.b.e.a.a(s = uri.getScheme()) && !com.shazam.b.e.a.a(uri.getQuery()) && !com.shazam.b.e.a.a(uri.getQueryParameter("vkey")))
            {
                if (a.getString(0x7f0901a7).equals(s))
                {
                    return a.getString(0x7f0901a8).equals(uri.getHost());
                } else
                {
                    return a.getString(0x7f09028c).equals(uri.getPath());
                }
            }
        }
        return false;
    }
}
