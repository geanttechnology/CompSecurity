// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

// Referenced classes of package com.google.ads.conversiontracking:
//            c, b, j, f

public class a extends c
{

    private final Context a;
    private final String b;
    private final String c;
    private final j.d d;
    private final String e;
    private final boolean f;

    public a(Context context, String s, String s1, String s2, boolean flag)
    {
        a = context;
        b = s;
        c = s1;
        e = s2;
        f = flag;
        if (this instanceof b)
        {
            context = j.d.b;
        } else
        {
            context = j.d.c;
        }
        d = context;
    }

    public static void a(Context context, String s, String s1, String s2, boolean flag)
    {
        (new a(context, s, s1, s2, flag)).a();
    }

    public static boolean a(Context context, Uri uri)
    {
        if (uri == null)
        {
            Log.e("GoogleConversionReporter", "Failed to register referrer from a null click url");
            return false;
        }
        Object obj = String.valueOf(String.valueOf(uri));
        Log.i("GoogleConversionReporter", (new StringBuilder(((String) (obj)).length() + 13)).append("Registering: ").append(((String) (obj))).toString());
        obj = j.a(uri);
        if (obj == null)
        {
            context = String.valueOf(String.valueOf(uri));
            Log.w("GoogleConversionReporter", (new StringBuilder(context.length() + 31)).append("Failed to parse referrer from: ").append(context).toString());
            return false;
        }
        boolean flag = j.a(context, ((j.b) (obj)));
        if (flag)
        {
            context = String.valueOf(String.valueOf(uri));
            Log.i("GoogleConversionReporter", (new StringBuilder(context.length() + 25)).append("Successfully registered: ").append(context).toString());
            return flag;
        } else
        {
            context = String.valueOf(String.valueOf(uri));
            Log.w("GoogleConversionReporter", (new StringBuilder(context.length() + 20)).append("Failed to register: ").append(context).toString());
            return flag;
        }
    }

    public void a()
    {
        j.c c1;
        boolean flag;
        flag = true;
        c1 = (new j.c()).a(b).a(d).b(c).c(e);
        if (d == j.d.c)
        {
            f f1 = com.google.ads.conversiontracking.f.a(a);
            f1.a(b);
            c1.a(f1.b(b));
        }
        if (!j.a(a, c1, f))
        {
            return;
        }
        if (d != j.d.c)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        c1.a(j.a(a, b));
_L1:
        a(a, c1, true, f, flag);
        return;
        Exception exception;
        exception;
        Log.e("GoogleConversionReporter", "Error sending ping", exception);
        return;
        flag = false;
          goto _L1
    }
}
