// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;

public class dc
{

    public static int a(Context context, int i)
    {
        return a(context, i, false);
    }

    public static int a(Context context, int i, boolean flag)
    {
        context = context.getResources().getDisplayMetrics();
        switch (((DisplayMetrics) (context)).densityDpi)
        {
        default:
            return (int)TypedValue.applyDimension(3, (float)i * 0.56F, context);

        case 120: // 'x'
        case 160: 
            if (flag)
            {
                return (int)TypedValue.applyDimension(3, (float)i * 0.67F, context);
            } else
            {
                return (int)TypedValue.applyDimension(3, (float)i * 0.5F, context);
            }

        case 240: 
            if (flag)
            {
                return (int)TypedValue.applyDimension(3, (float)i * 0.5F, context);
            } else
            {
                return (int)TypedValue.applyDimension(3, (float)i * 0.5F, context);
            }

        case 320: 
            if (flag)
            {
                return (int)TypedValue.applyDimension(3, (float)i * 0.56F, context);
            } else
            {
                return (int)TypedValue.applyDimension(3, (float)i * 0.56F, context);
            }

        case 480: 
            break;
        }
        if (flag)
        {
            return (int)TypedValue.applyDimension(3, (float)i * 0.56F, context);
        } else
        {
            return (int)TypedValue.applyDimension(3, (float)i * 0.56F, context);
        }
    }
}
