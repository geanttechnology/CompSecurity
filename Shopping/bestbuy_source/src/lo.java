// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;

public class lo
{

    public static Typeface a;
    public static Typeface b;
    public static Typeface c;
    public static Typeface d;
    public static Typeface e;

    public static Typeface a(Context context, int i, Resources resources)
    {
        a(context, resources);
        context = null;
        if (i == 0x7f080021)
        {
            context = a;
        } else
        {
            if (i == 0x7f080020)
            {
                return b;
            }
            if (i == 0x7f080024)
            {
                return c;
            }
            if (i == 0x7f080022)
            {
                return d;
            }
            if (i == 0x7f080023)
            {
                return e;
            }
        }
        return context;
    }

    public static void a(Context context, Resources resources)
    {
        if (a == null)
        {
            a = Typeface.createFromAsset(context.getAssets(), resources.getString(0x7f080021));
        }
        if (b == null)
        {
            b = Typeface.createFromAsset(context.getAssets(), resources.getString(0x7f080020));
        }
        if (c == null)
        {
            c = Typeface.createFromAsset(context.getAssets(), resources.getString(0x7f080024));
        }
        if (d == null)
        {
            d = Typeface.createFromAsset(context.getAssets(), resources.getString(0x7f080022));
        }
        if (e == null)
        {
            e = Typeface.createFromAsset(context.getAssets(), resources.getString(0x7f080023));
        }
    }
}
