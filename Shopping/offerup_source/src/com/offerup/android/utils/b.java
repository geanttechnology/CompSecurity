// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import android.content.Context;
import android.util.Log;
import com.b.a.a.g;
import com.b.a.a.j;
import org.apache.commons.lang3.StringUtils;

public final class b
{

    private static String a = "AndroidIdHelper";
    private static String b;

    public static String a(Context context)
    {
        if (StringUtils.isEmpty(b))
        {
            try
            {
                context = android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
                b = context;
                if (StringUtils.isNotEmpty(context))
                {
                    j.a().m(b);
                }
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                g.c(a, Log.getStackTraceString(context));
            }
        }
        if (StringUtils.isEmpty(b))
        {
            g.c(a, "Returning an empty Android Id");
        }
        return b;
    }

}
