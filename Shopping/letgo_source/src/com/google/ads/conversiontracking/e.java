// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads.conversiontracking;

import android.content.Context;
import android.util.Log;

// Referenced classes of package com.google.ads.conversiontracking:
//            c

public class e extends c
{

    private Context a;

    public e(Context context)
    {
        a = context;
    }

    public void a(String s, long l)
    {
        try
        {
            a(a, (new j.c()).a(s).a(true).a().a(l), false, true, true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Log.e("GoogleConversionReporter", "Error sending ping", s);
        }
    }
}
