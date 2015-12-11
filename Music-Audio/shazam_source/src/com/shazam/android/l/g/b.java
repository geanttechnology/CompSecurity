// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.g;

import android.content.Intent;
import android.os.Bundle;
import com.shazam.android.ab.d;
import com.shazam.android.k.f.j;
import com.shazam.b.a.a;
import com.shazam.f.e;
import com.shazam.model.analytics.ScreenOrigin;
import java.net.URISyntaxException;

public final class b
    implements a
{

    private final j a;
    private final d b;

    public b(j j1, d d1)
    {
        a = j1;
        b = d1;
    }

    private Intent a(String s)
    {
        Intent intent;
        try
        {
            intent = b.a(s);
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new e((new StringBuilder("Could not parse URI: ")).append(s).toString(), urisyntaxexception);
        }
        return intent;
    }

    private static String a(com.shazam.android.service.gcm.a a1, Bundle bundle)
    {
        return bundle.getString(a1.l);
    }

    public final Object a(Object obj)
    {
        obj = (Bundle)obj;
        Intent intent = a(a(com.shazam.android.service.gcm.a.a, ((Bundle) (obj))));
        com.shazam.android.k.f.i.a a1 = new com.shazam.android.k.f.i.a();
        com.shazam.android.al.c.a a2 = new com.shazam.android.al.c.a();
        a2.a = true;
        a2.b = a(com.shazam.android.service.gcm.a.k, ((Bundle) (obj)));
        a2.c = a(com.shazam.android.service.gcm.a.h, ((Bundle) (obj)));
        a1.c = a2.a();
        j.a(a1.a(), intent);
        intent.putExtra("com.shazam.android.analytic_source", ScreenOrigin.NOTIFICATION.value);
        return intent;
    }
}
