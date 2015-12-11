// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.Locale;

// Referenced classes of package com.paypal.android.sdk:
//            ft, cj, by, ac, 
//            gq, gu, gw, ck

final class bt
    implements ft
{

    private final cj a;
    private by b;

    private bt(by by1, cj cj1)
    {
        b = by1;
        super();
        a = cj1;
    }

    bt(by by1, cj cj1, byte byte0)
    {
        this(by1, cj1);
    }

    private String a(String s)
    {
        Locale locale = Locale.US;
        String s1 = (new StringBuilder()).append(a.n()).append(" PayPal Debug-ID: %s [%s, %s]").toString();
        String s2 = by.d(b);
        StringBuilder stringbuilder = (new StringBuilder()).append(by.e(b).a()).append(";");
        by.e(b);
        return String.format(locale, s1, new Object[] {
            s, s2, stringbuilder.append("release").toString()
        });
    }

    public final void a(gq gq1, IOException ioexception)
    {
        try
        {
            a.b(ioexception.getMessage());
            gq1 = gq1.a("PayPal-Debug-Id");
            if (!TextUtils.isEmpty(gq1))
            {
                Log.w("paypal.sdk", a(((String) (gq1))));
            }
            by.a(b, a, null, ioexception);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (gq gq1)
        {
            Log.e("paypal.sdk", "exception in response handler", gq1);
        }
        throw gq1;
    }

    public final void a(gu gu1)
    {
        String s;
        s = gu1.a("paypal-debug-id");
        a.b(gu1.h().d());
        if (!gu1.d())
        {
            if (!TextUtils.isEmpty(s))
            {
                Log.w("paypal.sdk", a(s));
            }
            by.a(b, a, gu1, null);
            return;
        }
        try
        {
            a.c(s);
            by.b();
            (new StringBuilder()).append(a.n()).append(" success. response: ").append(a.g());
            if (!TextUtils.isEmpty(s))
            {
                Log.w("paypal.sdk", a(s));
            }
            if (a.q())
            {
                by.a(a);
            }
            by.c(b).a(a);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (gu gu1)
        {
            Log.e("paypal.sdk", "exception in response handler", gu1);
        }
        throw gu1;
    }
}
