// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.e;

import com.facebook.ads.a.a;
import com.facebook.ads.a.d.c;
import com.facebook.ads.a.f.d;
import org.json.JSONException;

// Referenced classes of package com.facebook.ads.a.e:
//            b, c, d, f

final class nit> extends c
{

    final b a;

    public final void a(String s)
    {
        d.b(com.facebook.ads.a.e.b.d(a));
        com.facebook.ads.a.e.b.a(a, null);
        com.facebook.ads.a.e.b.a(a, s);
    }

    public final void a(Throwable throwable, String s)
    {
        d.b(com.facebook.ads.a.e.b.d(a));
        com.facebook.ads.a.e.b.a(a, null);
        Object obj;
        b b1;
        a a1;
        b.e(a);
        obj = com.facebook.ads.a.e.c.a(s);
        if (((com.facebook.ads.a.e.d) (obj)).b != b)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        obj = ((f)obj).c;
        b1 = a;
        a1 = a.m;
        if (obj != null)
        {
            s = ((String) (obj));
        }
        try
        {
            com.facebook.ads.a.e.b.a(b1, a1.a(s));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
        com.facebook.ads.a.e.b.a(a, new com.facebook.ads.a.c(a.b, throwable.getMessage()));
        return;
    }

    (b b1)
    {
        a = b1;
        super();
    }
}
