// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;

public class ce
{

    public static int a(Context context, int i, int j)
    {
        Context context1 = null;
        context = context.getTheme().obtainStyledAttributes(new int[] {
            i
        });
        context1 = context;
        i = context.getColor(0, j);
        if (context != null)
        {
            context.recycle();
        }
        return i;
        context;
        if (context1 != null)
        {
            context1.recycle();
        }
        throw context;
    }

    public static ColorStateList a(int i, int j, int k)
    {
        return new ColorStateList(new int[][] {
            new int[] {
                0x101009e
            }, new int[] {
                0xfefeff62
            }, new int[] {
                0x10100a7
            }, new int[0]
        }, new int[] {
            i, j, k, i
        });
    }

    public static ColorStateList b(Context context, int i, int j)
    {
        TypedArray typedarray = context.getTheme().obtainStyledAttributes(new int[] {
            i
        });
        ColorStateList colorstatelist = typedarray.getColorStateList(0);
        context = colorstatelist;
        if (colorstatelist == null)
        {
            i = typedarray.getColor(0, 0);
            if (i != 0)
            {
                j = i;
            }
            context = ColorStateList.valueOf(j);
        }
        typedarray.recycle();
        return context;
    }
}
