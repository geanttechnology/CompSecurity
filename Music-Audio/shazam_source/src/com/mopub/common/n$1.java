// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.a.a;

// Referenced classes of package com.mopub.common:
//            n, o

static final class nit> extends n
{

    protected final void a(Context context, Uri uri, o o1)
    {
        context = uri.getHost();
        o1 = o1.a;
        if ("finishLoad".equals(context))
        {
            o1.a();
        } else
        if (!"close".equals(context))
        {
            if ("failLoad".equals(context))
            {
                o1.b();
                return;
            } else
            {
                throw new a((new StringBuilder("Could not handle MoPub Scheme url: ")).append(uri).toString());
            }
        }
    }

    public final boolean a(Uri uri)
    {
        return "mopub".equals(uri.getScheme());
    }

    xt(String s)
    {
        super(s, 0, false, (byte)0);
    }
}
