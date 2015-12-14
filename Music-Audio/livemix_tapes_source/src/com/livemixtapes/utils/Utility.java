// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility
{

    private static final SimpleDateFormat apiDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss'Z'");
    private static final SimpleDateFormat shortDateFormat = new SimpleDateFormat("M/d/yy");

    public Utility()
    {
    }

    public static float dpToPixel(Context context, float f)
    {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static String formatDateShort(Date date)
    {
        return shortDateFormat.format(date);
    }

    public static void hideKeyboard(Activity activity)
    {
        View view = activity.getCurrentFocus();
        if (view != null)
        {
            ((InputMethodManager)activity.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
        Log.d("Utility", "Hide keyboard...");
    }

    public static Date parseApiDate(String s)
    {
        try
        {
            s = apiDateFormat.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return null;
        }
        return s;
    }

}
