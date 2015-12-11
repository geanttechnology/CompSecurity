// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.a.a;
import com.mopub.a.b;
import com.mopub.common.d.f;

// Referenced classes of package com.mopub.common:
//            n, o

static final class nit> extends n
{

    protected final void a(Context context, Uri uri, o o)
    {
        o = (new StringBuilder("Unable to load mopub native browser url: ")).append(uri).toString();
        try
        {
            f.a(context, f.a(uri), o);
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
        return "mopubnativebrowser".equals(uri.getScheme());
    }

    xt(String s)
    {
        super(s, 3, true, (byte)0);
    }
}
