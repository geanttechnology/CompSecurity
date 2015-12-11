// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.utils;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.io.File;
import java.util.HashMap;

public class z
{

    public static final String a = com/smule/pianoandroid/utils/z.getName();
    private static HashMap b = new HashMap();

    public z()
    {
    }

    public static Typeface a(Context context)
    {
        return a(context, "Gotham-XLight");
    }

    public static Typeface a(Context context, String s)
    {
        Typeface typeface1 = (Typeface)b.get(s);
        Typeface typeface = typeface1;
        if (typeface1 == null)
        {
            String s1 = (new StringBuilder()).append("fonts").append(File.separator).append(s).append(".ttf").toString();
            try
            {
                typeface = Typeface.createFromAsset(context.getAssets(), s1);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.i(a, (new StringBuilder()).append("failed to create font asset").append(s1).toString());
                return Typeface.DEFAULT;
            }
            b.put(s, typeface);
            Log.i(a, (new StringBuilder()).append("adding font ").append(s1).append("id ").append(typeface.toString()).toString());
        }
        return typeface;
    }

    public static void a(View view)
    {
        a(view, b(view.getContext()));
    }

    public static void a(View view, Typeface typeface)
    {
        if (view instanceof ViewGroup)
        {
            view = (ViewGroup)view;
            for (int i = 0; i < view.getChildCount(); i++)
            {
                a(view.getChildAt(i), typeface);
            }

        } else
        if (view instanceof TextView)
        {
            ((TextView)view).setTypeface(typeface);
        }
    }

    public static Typeface b(Context context)
    {
        return a(context, "Gotham-Light");
    }

    public static Typeface c(Context context)
    {
        return a(context, "Gotham-Medium");
    }

    public static Typeface d(Context context)
    {
        return a(context, "Gotham-Bold");
    }

    public static Typeface e(Context context)
    {
        return a(context, "Gotham-Book");
    }

}
