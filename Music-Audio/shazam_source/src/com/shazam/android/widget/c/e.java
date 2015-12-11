// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.widget.c;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.shazam.android.k.f.i;
import com.shazam.b.a.a;

// Referenced classes of package com.shazam.android.widget.c:
//            f, d

public final class e
    implements f
{

    private final a b;
    private final d c;
    private final String d;

    public e(a a1, d d1, String s)
    {
        b = a1;
        c = d1;
        d = s;
    }

    public final void a(Context context, Uri uri)
    {
        a(context, uri, (new com.shazam.android.k.f.i.a()).a());
    }

    public final void a(Context context, Uri uri, Bundle bundle)
    {
        a(context, uri, bundle, (new com.shazam.android.k.f.i.a()).a());
    }

    public final void a(Context context, Uri uri, Bundle bundle, i j)
    {
        uri = (Intent)b.a(uri);
        uri.setPackage(d);
        if (bundle != null)
        {
            uri.putExtras(bundle);
        }
        c.a(context, uri, j);
    }

    public final void a(Context context, Uri uri, View view, i j)
    {
        a(context, uri, i.a(view, j));
    }

    public final void a(Context context, Uri uri, i j)
    {
        a(context, uri, j, ((Bundle) (null)));
    }

    public final void a(Context context, Uri uri, i j, Bundle bundle)
    {
        uri = (Intent)b.a(uri);
        uri.setPackage(d);
        c.a(context, uri, j, bundle);
    }
}
