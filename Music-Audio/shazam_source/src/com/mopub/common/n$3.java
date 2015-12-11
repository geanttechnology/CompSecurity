// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.c.a;

// Referenced classes of package com.mopub.common:
//            n, o

static final class nit> extends n
{

    protected final void a(Context context, Uri uri, o o)
    {
        com.mopub.common.c.a.b("Link to about page ignored.");
    }

    public final boolean a(Uri uri)
    {
        return "about".equals(uri.getScheme());
    }

    xt(String s)
    {
        super(s, 1, false, (byte)0);
    }
}
