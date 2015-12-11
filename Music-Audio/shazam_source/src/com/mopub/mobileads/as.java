// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import com.mopub.c.i;
import com.mopub.common.c;
import com.mopub.common.d;
import com.mopub.common.f;

public final class as extends c
{

    private final boolean g;

    public as(Context context, boolean flag)
    {
        super(context);
        g = flag;
    }

    public final String c(String s)
    {
        String s1;
        if (i.c())
        {
            s1 = "https";
        } else
        {
            s1 = "http";
        }
        super.e = (new StringBuilder(s1)).append("://").append(s).append("/m/ad");
        super.f = true;
        d("6");
        a(f.a(a));
        a();
        a(g);
        return super.e.toString();
    }
}
