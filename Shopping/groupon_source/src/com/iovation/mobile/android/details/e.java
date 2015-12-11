// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.iovation.mobile.android.details;

import android.content.Context;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

// Referenced classes of package com.iovation.mobile.android.details:
//            i, j, w

public class e
    implements i
{

    public e()
    {
    }

    private static String a()
    {
        Object obj;
        try
        {
            obj = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            obj = String.format(Locale.getDefault(), "%04d-%02d-%02dT%02d:%02d:%02d.%03dZ", new Object[] {
                Integer.valueOf(((Calendar) (obj)).get(1)), Integer.valueOf(((Calendar) (obj)).get(2) + 0 + 1), Integer.valueOf(((Calendar) (obj)).get(5)), Integer.valueOf(((Calendar) (obj)).get(11)), Integer.valueOf(((Calendar) (obj)).get(12)), Integer.valueOf(((Calendar) (obj)).get(13)), Integer.valueOf(((Calendar) (obj)).get(14))
            });
        }
        catch (Throwable throwable)
        {
            return null;
        }
        return ((String) (obj));
    }

    public void a(Context context, j j1)
    {
        j1.a("BBSC", "Android");
        j1.a("CLIENT_TIME", a());
        j1.a("SDKVER", w.a());
        j1.a("SDKBN", w.b());
    }
}
