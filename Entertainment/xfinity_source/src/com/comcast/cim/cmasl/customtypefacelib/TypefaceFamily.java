// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.customtypefacelib;

import android.content.Context;
import android.graphics.Typeface;
import android.util.SparseArray;

public class TypefaceFamily
{

    public static int STYLE_BLACK = 100;
    public static int STYLE_BLACK_ITALIC = 101;
    public static int STYLE_BOLD = 200;
    public static int STYLE_BOLD_CONDENSED = 201;
    public static int STYLE_BOLD_CONDENSED_ITALIC = 202;
    public static int STYLE_BOLD_ITALIC = 203;
    public static int STYLE_CONDENSED = 300;
    public static int STYLE_CONDENSED_ITALIC = 301;
    public static int STYLE_CUSTOM_1 = 1000;
    public static int STYLE_CUSTOM_2 = 1001;
    public static int STYLE_ITALIC = 400;
    public static int STYLE_LIGHT = 500;
    public static int STYLE_LIGHT_ITALIC = 501;
    public static int STYLE_MEDIUM = 600;
    public static int STYLE_MEDIUM_CONDENSED = 601;
    public static int STYLE_MEDIUM_ITALIC = 602;
    public static int STYLE_REGULAR = 0;
    public static int STYLE_THIN = 700;
    public static int STYLE_THIN_ITALIC = 701;
    private Context context;
    SparseArray fontsByStyle;

    public TypefaceFamily(Context context1)
    {
        fontsByStyle = new SparseArray();
        context = context1;
    }

    public static int getCustomStyleIdForAndroidStyle(int i)
    {
        switch (i)
        {
        default:
            return STYLE_REGULAR;

        case 1: // '\001'
            return STYLE_BOLD;

        case 3: // '\003'
            return STYLE_BOLD_ITALIC;

        case 2: // '\002'
            return STYLE_ITALIC;
        }
    }

    public void addTypeface(String s, int i)
    {
        fontsByStyle.put(i, createTypeface(s));
    }

    protected Typeface createTypeface(String s)
    {
        return Typeface.createFromAsset(context.getAssets(), (new StringBuilder()).append("fonts/").append(s).toString());
    }

    public Typeface getTypeface(int i)
    {
        return (Typeface)fontsByStyle.get(i);
    }

}
