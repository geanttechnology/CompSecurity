// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.Toast;

public class ai
{

    public static void a(Context context, int i)
    {
        a(context, ((CharSequence) (context.getString(i))));
    }

    public static void a(Context context, CharSequence charsequence)
    {
        a(context, charsequence, 0);
    }

    private static void a(Context context, CharSequence charsequence, int i)
    {
        Toast.makeText(context, charsequence, i).show();
    }

    public static void a(Fragment fragment, int i)
    {
        a(fragment, ((CharSequence) (fragment.getString(i))));
    }

    public static void a(Fragment fragment, CharSequence charsequence)
    {
        a(((Context) (fragment.getActivity())), charsequence);
    }

    public static void b(Context context, CharSequence charsequence)
    {
        a(context, charsequence, 1);
    }

    public static void b(Fragment fragment, int i)
    {
        b(fragment, ((CharSequence) (fragment.getString(i))));
    }

    public static void b(Fragment fragment, CharSequence charsequence)
    {
        b(((Context) (fragment.getActivity())), charsequence);
    }
}
