// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

public class bg
{

    public static float a(Context context, float f)
    {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int a(Context context, int i)
    {
        return (int)TypedValue.applyDimension(1, i, context.getResources().getDisplayMetrics());
    }

    public static float b(Context context, float f)
    {
        return TypedValue.applyDimension(2, f, context.getResources().getDisplayMetrics());
    }
}
