// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.d.f;

// Referenced classes of package com.mopub.common:
//            n, o

static final class nit> extends n
{

    protected final void a(Context context, Uri uri, o o)
    {
        f.b(context, uri);
    }

    public final boolean a(Uri uri)
    {
        String s = uri.getScheme();
        String s1 = uri.getHost();
        return "play.google.com".equals(s1) || "market.android.com".equals(s1) || "market".equals(s) || uri.toString().startsWith("play.google.com/") || uri.toString().startsWith("market.android.com/");
    }

    xt(String s)
    {
        super(s, 4, true, (byte)0);
    }
}
