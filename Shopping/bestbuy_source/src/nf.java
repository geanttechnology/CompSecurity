// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class nf
{

    public static float a(float f, Context context)
    {
        return ((float)context.getResources().getDisplayMetrics().densityDpi / 160F) * f;
    }

    public static int a(Context context)
    {
        context = context.getResources().getDisplayMetrics();
        return Math.round((float)((DisplayMetrics) (context)).widthPixels / ((DisplayMetrics) (context)).density);
    }

    public static int b(float f, Context context)
    {
        return Math.round(((float)context.getResources().getDisplayMetrics().densityDpi / 160F) * f);
    }

    public static int b(Context context)
    {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
