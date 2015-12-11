// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class DisplayUtils
{

    public DisplayUtils()
    {
    }

    public static int dpToPixel(Context context, int i)
    {
        float f = context.getResources().getDisplayMetrics().density;
        return (int)((float)i * f + 0.5F);
    }

    public static int pixelToDp(Context context, int i)
    {
        float f = context.getResources().getDisplayMetrics().density;
        return (int)((float)i / f + 0.5F);
    }
}
