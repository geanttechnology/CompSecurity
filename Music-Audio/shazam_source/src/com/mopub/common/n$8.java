// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mopub.a.a;
import com.mopub.a.b;
import com.mopub.common.d.f;

// Referenced classes of package com.mopub.common:
//            n, m, o

static final class nit> extends n
{

    protected final void a(Context context, Uri uri, o o)
    {
        com.mopub.common.m.a(context);
        com.mopub.common.m.a(uri);
        o = (new StringBuilder("Could not handle share tweet intent with URI ")).append(uri).toString();
        try
        {
            f.a(context, Intent.createChooser(f.b(uri), "Share via"), o);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new a((new StringBuilder()).append(o).append("\n\t").append(context.getMessage()).toString());
        }
    }

    public final boolean a(Uri uri)
    {
        com.mopub.common.m.a(uri);
        return "mopubshare".equals(uri.getScheme()) && "tweet".equals(uri.getHost());
    }

    xt(String s)
    {
        super(s, 6, true, (byte)0);
    }
}
