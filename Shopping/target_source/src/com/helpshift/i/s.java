// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.text.TextUtils;
import com.helpshift.v;
import java.util.Locale;

public class s
{

    private static final com.helpshift.s a = new com.helpshift.s(v.a());

    public static String a()
    {
        String s2 = a.X();
        String s1 = s2;
        if (TextUtils.isEmpty(s2))
        {
            s1 = Locale.getDefault().toString();
        }
        return s1;
    }

    private static Locale a(String s1)
    {
        if (s1.contains("_"))
        {
            s1 = s1.split("_");
            return new Locale(s1[0], s1[1]);
        } else
        {
            return new Locale(s1);
        }
    }

    public static void a(Context context)
    {
        String s1 = a.X();
        if (!TextUtils.isEmpty(s1))
        {
            context = context.getResources();
            android.util.DisplayMetrics displaymetrics = context.getDisplayMetrics();
            Configuration configuration = context.getConfiguration();
            configuration.locale = a(s1);
            context.updateConfiguration(configuration, displaymetrics);
        }
    }

}
