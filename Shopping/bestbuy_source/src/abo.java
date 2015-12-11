// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;

public final class abo
{

    public static void a(Context context, boolean flag)
    {
        context = b(context).edit();
        context.putBoolean("use_https", flag);
        context.commit();
    }

    public static boolean a(Context context)
    {
        return b(context).getBoolean("use_https", true);
    }

    private static SharedPreferences b(Context context)
    {
        return context.getSharedPreferences("admob", 0);
    }
}
